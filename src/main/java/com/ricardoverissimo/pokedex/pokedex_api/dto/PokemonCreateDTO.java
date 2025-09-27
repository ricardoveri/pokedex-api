package com.ricardoverissimo.pokedex.pokedex_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public class PokemonCreateDTO(

    @NotBlank(message = "O nome é obrigatório.")
    String name,

    @NotNull(message = "O número da Pokédex é obrigatório.")
    @Positive(message = "O número da Pokédex deve ser positivo.")
    Integer pokedexNumber,

    @NotNull @Positive Integer hp,
    @NotNull @Positive Integer attack,
    @NotNull @Positive Integer defense,

    String imageUrl,

    List<String> types,
    List<String> abilites
){}
