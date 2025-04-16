package joris.gourdon.api.infrastructure.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Slf4j
@Service
public class JwtService {
    private static final String SECRET_KEY = "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970";
    private static final long JWT_EXPIRATION = 86400000; // 24 heures

    public String extractUsername(String token) {
        try {
            String username = extractClaim(token, Claims::getSubject);
            log.debug("Nom d'utilisateur extrait du token: {}", username);
            return username;
        } catch (Exception e) {
            log.error("Erreur lors de l'extraction du nom d'utilisateur du token", e);
            return null;
        }
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        log.debug("Génération d'un token pour l'utilisateur: {}", userDetails.getUsername());
        String token = Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
        log.debug("Token généré: {}", token);
        return token;
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        try {
            final String username = extractUsername(token);
            log.debug("Validation du token pour l'utilisateur: {}", username);
            log.debug("Comparaison avec: {}", userDetails.getUsername());
            
            boolean isUsernameValid = username != null && username.equals(userDetails.getUsername());
            boolean isTokenExpired = isTokenExpired(token);
            
            log.debug("Nom d'utilisateur valide: {}", isUsernameValid);
            log.debug("Token expiré: {}", isTokenExpired);
            
            boolean isValid = isUsernameValid && !isTokenExpired;
            log.debug("Token valide: {}", isValid);
            
            return isValid;
        } catch (Exception e) {
            log.error("Erreur lors de la validation du token", e);
            return false;
        }
    }

    private boolean isTokenExpired(String token) {
        Date expiration = extractExpiration(token);
        boolean isExpired = expiration.before(new Date());
        log.debug("Date d'expiration du token: {}", expiration);
        log.debug("Token expiré: {}", isExpired);
        return isExpired;
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token) {
        try {
            return Jwts
                    .parserBuilder()
                    .setSigningKey(getSignInKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            log.error("Erreur lors de l'extraction des claims du token", e);
            throw e;
        }
    }

    private Key getSignInKey() {
        byte[] keyBytes = SECRET_KEY.getBytes();
        return Keys.hmacShaKeyFor(keyBytes);
    }
} 