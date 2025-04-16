package joris.gourdon.api.infrastructure.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final CustomUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userEmail;

        log.debug("Traitement de la requête: {}", request.getRequestURI());
        log.debug("Header Authorization: {}", authHeader);

        // Si c'est une requête d'authentification, on la laisse passer
        if (request.getRequestURI().startsWith("/api/auth/")) {
            log.debug("Requête d'authentification, passage au filtre suivant");
            filterChain.doFilter(request, response);
            return;
        }

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            log.warn("Pas de token JWT trouvé dans la requête");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("{\"error\":\"Token JWT manquant\"}");
            return;
        }

        try {
            jwt = authHeader.substring(7);
            log.debug("Token JWT extrait: {}", jwt);
            
            userEmail = jwtService.extractUsername(jwt);
            log.debug("Email extrait du token: {}", userEmail);

            if (userEmail == null) {
                log.warn("Impossible d'extraire l'email du token");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("{\"error\":\"Token JWT invalide\"}");
                return;
            }

            if (SecurityContextHolder.getContext().getAuthentication() == null) {
                log.debug("Chargement des détails de l'utilisateur: {}", userEmail);
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
                
                if (jwtService.isTokenValid(jwt, userDetails)) {
                    log.debug("Token valide pour l'utilisateur: {}", userEmail);
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );
                    authToken.setDetails(
                            new WebAuthenticationDetailsSource().buildDetails(request)
                    );
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                    log.debug("Authentification réussie pour l'utilisateur: {}", userEmail);
                } else {
                    log.warn("Token JWT invalide pour l'utilisateur: {}", userEmail);
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.getWriter().write("{\"error\":\"Token JWT invalide\"}");
                    return;
                }
            }
        } catch (Exception e) {
            log.error("Erreur lors de l'authentification JWT", e);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("{\"error\":\"Erreur d'authentification: " + e.getMessage() + "\"}");
            return;
        }

        filterChain.doFilter(request, response);
    }
} 