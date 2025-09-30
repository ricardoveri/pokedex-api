package com.ricardoverissimo.pokedex.pokedex_api.service.security;
import com.ricardoverissimo.pokedex.pokedex_api.repository.TrainerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

public class UserDetailsServiceImpl {
    @Service
    public class UserDetailsServiceImpi implements UserDetailsService {

        private final TrainerRepository trainerRepository;

        public UserDetailsServiceImpi(TrainerRepository trainerRepository) {
            this.trainerRepository = trainerRepository;
        }

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            // Assume que seu Trainer implementa UserDetails, o que faremos no próximo sub-passo.
            return trainerRepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("Treinador não encontrado: " + username));
        }
    }
}
