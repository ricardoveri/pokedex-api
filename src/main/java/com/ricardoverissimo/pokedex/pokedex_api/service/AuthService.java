package com.ricardoverissimo.pokedex.pokedex_api.service;
import com.ricardoverissimo.pokedex.pokedex_api.dto.auth.TrainerRegistrationDTO;
import com.ricardoverissimo.pokedex.pokedex_api.exception.ResourceNotFoundException;
import com.ricardoverissimo.pokedex.pokedex_api.model.Trainer;
import com.ricardoverissimo.pokedex.pokedex_api.repository.TrainerRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final TrainerRepository trainerRepository;

    public AuthService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public Trainer register(TrainerRegistrationDTO registrationDto) {
        if (trainerRepository.existsByUsername(registrationDto.username())) {
            throw new RuntimeException("Username já está em uso!");
        }

        if (trainerRepository.existsByemail(registrationDto.email())) {
            throw new RuntimeException("Email já está em uso!");
        }

        Trainer trainer = new Trainer();
        trainer.setUsername(registrationDto.username());
        trainer.setEmail(registrationDto.email());
        trainer.setPassword(registrationDto.password);
        return trainerRepository.save(trainer);

    }

}
