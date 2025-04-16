package joris.gourdon.api.infrastructure.security;

import joris.gourdon.api.application.services.JoueurService;
import joris.gourdon.api.domain.models.Joueur;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    private final JoueurService joueurService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            return joueurService.findByEmail(username);
        } catch (Exception e) {
            throw new UsernameNotFoundException("Aucun utilisateur trouvé");
        }
    }
} 