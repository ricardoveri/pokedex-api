package com.ricardoverissimo.pokedex.pokedex_api.controller;
import com.ricardoverissimo.pokedex.pokedex_api.dto.TrainerRegistrationDTO;
import com.ricardoverissimo.pokedex.pokedex_api.model.Trainer;
import com.ricardoverissimo.pokedex.pokedex_api.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerTrainer(@Valid @RequestBody TrainerRegistrationDTO registrationDTO) {
        Trainer newTrainer = authService.register(registrationDTO);

        return new ResponseEntity<>("Treinador " + newTrainer.getUsername() + " registrado com sucesso!", HttpStatus.CREATED);
    }
}
