package com.ricardoverissimo.pokedex.pokedex_api.controller;
import com.ricardoverissimo.pokedex.pokedex_api.dto.PokemonCreateDTO;
import com.ricardoverissimo.pokedex.pokedex_api.dto.PokemonResponseDTO;
import com.ricardoverissimo.pokedex.pokedex_api.model.Pokemon;
import com.ricardoverissimo.pokedex.pokedex_api.service.PokemonService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @PostMapping("/trainer/{trainerId}")
    public ResponseEntity<PokemonResponseDTO> createPokemon(
            @PathVariable Long trainerId,
            @Valid @RequestBody PokemonCreateDTO createDTO
            ){

        Pokemon newPokemon = pokemonService.createPokemon(trainerId, createDTO);

        PokemonResponseDTO responseDTO = new PokemonResponseDTO(
                newPokemon.getId(),
                newPokemon.getName(),
                newPokemon.getPokedexNumber(),
                newPokemon.getHp(),
                newPokemon.getAttack(),
                newPokemon.getDefense(),
                newPokemon.getImageUrl(),
                newPokemon.getTrainer().getId(),
                newPokemon.getTrainer().getUsername(),
                newPokemon.getTypes().stream().map(t -> t.getName()).toList(),
                newPokemon.getAbilities().stream().map(a -> a.getName()).toList()
        );

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
