package com.ricardoverissimo.pokedex.pokedex_api.service;
import com.ricardoverissimo.pokedex.pokedex_api.dto.TrainerRegistrationDTO;
import com.ricardoverissimo.pokedex.pokedex_api.exception.ResourceNotFoundException;
import com.ricardoverissimo.pokedex.pokedex_api.model.Trainer;
import com.ricardoverissimo.pokedex.pokedex_api.repository.TrainerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final TrainerRepository trainerRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(TrainerRepository trainerRepository, PasswordEncoder passwordEncoder) {
        this.trainerRepository = trainerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Trainer register(TrainerRegistrationDTO registrationDto) {
        if (trainerRepository.existsByUsername(registrationDto.username())) {
            throw new RuntimeException("Username já está em uso!");
        }

        if (trainerRepository.existsByEmail(registrationDto.email())) {
            throw new RuntimeException("Email já está em uso!");
        }

        Trainer trainer = new Trainer();
        trainer.setUsername(registrationDto.username());
        trainer.setEmail(registrationDto.email());
        trainer.setPassword(passwordEncoder.encode(registrationDto.password()));
        return trainerRepository.save(trainer);

    }

}
