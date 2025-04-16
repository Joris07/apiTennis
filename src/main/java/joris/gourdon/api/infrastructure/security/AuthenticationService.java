package joris.gourdon.api.infrastructure.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final CustomUserDetailsService customUserDetailsService;

    public Map<String, String> authenticate(String email, String password) {
        try {
            log.debug("Tentative d'authentification pour l'utilisateur: {}", email);
            
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );
            log.debug("Authentification réussie pour l'utilisateur: {}", email);
            
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(email);
            String token = jwtService.generateToken(userDetails);
            log.debug("Token généré avec succès pour l'utilisateur: {}", email);
            
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            response.put("email", email);
            response.put("message", "Authentification réussie");
            
            return response;
        } catch (AuthenticationException e) {
            log.error("Échec de l'authentification pour l'utilisateur: {}", email, e);
            throw e;
        } catch (Exception e) {
            log.error("Erreur inattendue lors de l'authentification", e);
            throw e;
        }
    }
} 