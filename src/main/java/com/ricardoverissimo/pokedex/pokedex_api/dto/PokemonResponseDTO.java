package com.ricardoverissimo.pokedex.pokedex_api.dto;
import java.util.List;

public record PokemonResponseDTO(
    Long id,
    String name,
    Integer pokedexNumber,
    Integer hp,
    Integer attack,
    Integer defense,
    String imageUrl,
    Long trainerId,
    String trainerUsername,
    List<String> types,
    List<String> abilities
){}
