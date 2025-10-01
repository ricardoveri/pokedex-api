package com.ricardoverissimo.pokedex.pokedex_api.service;
import com.ricardoverissimo.pokedex.pokedex_api.dto.TrainerRegistrationDTO;
import com.ricardoverissimo.pokedex.pokedex_api.model.Trainer;
import com.ricardoverissimo.pokedex.pokedex_api.repository.TrainerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import com.ricardoverissimo.pokedex.pokedex_api.service.security.JwtService;
import com.ricardoverissimo.pokedex.pokedex_api.dto.LoginDTO;

@Service
public class AuthService {
    private final TrainerRepository trainerRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthService(TrainerRepository trainerRepository, PasswordEncoder passwordEncoder,
                       AuthenticationManager authenticationManager, JwtService jwtService) {
        this.trainerRepository = trainerRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
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

    public String authenticate(LoginDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );

        var trainer = trainerRepository.findByUsername(request.username())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado após autenticação."));

        return jwtService.generateToken(trainer);
    }
}