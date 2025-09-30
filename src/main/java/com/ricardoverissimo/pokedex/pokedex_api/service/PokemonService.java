package com.ricardoverissimo.pokedex.pokedex_api.service;
import com.ricardoverissimo.pokedex.pokedex_api.dto.PokemonCreateDTO;
import com.ricardoverissimo.pokedex.pokedex_api.exception.ResourceNotFoundException;
import com.ricardoverissimo.pokedex.pokedex_api.model.Ability;
import com.ricardoverissimo.pokedex.pokedex_api.model.Pokemon;
import com.ricardoverissimo.pokedex.pokedex_api.model.Trainer;
import com.ricardoverissimo.pokedex.pokedex_api.model.Type;
import com.ricardoverissimo.pokedex.pokedex_api.repository.*;
import com.ricardoverissimo.pokedex.pokedex_api.repository.AbilityRepository;
import com.ricardoverissimo.pokedex.pokedex_api.repository.PokemonRepository;
import com.ricardoverissimo.pokedex.pokedex_api.repository.TrainerRepository;
import com.ricardoverissimo.pokedex.pokedex_api.repository.TypeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;
    private final TrainerRepository trainerRepository;
    private final TypeRepository typeRepository;
    private final AbilityRepository abilityRepository;

    public PokemonService(PokemonRepository pokemonRepository, TrainerRepository trainerRepository, TypeRepository typeRepository, AbilityRepository abilityRepository) {
        this.pokemonRepository = pokemonRepository;
        this.trainerRepository = trainerRepository;
        this.typeRepository = typeRepository;
        this.abilityRepository = abilityRepository;
    }

    public Pokemon createPokemon(Long trainerId, PokemonCreateDTO createDto) {
        Trainer trainer = trainerRepository.findById(trainerId)
                .orElseThrow(() -> new ResourceNotFoundException("Trainer", "id", trainerId));

        List<Type> types = resolveTypes(createDto.types());
        List<Ability> abilities = resolveAbilities(createDto.abilities());

        Pokemon pokemon = new Pokemon();
        pokemon.setName(CreateDto.name());
        pokemon.setPokedexNumber(createDto.abilities);
        pokemon.setHp(createDto.hp());
        pokemon.setAttack(createDto.attack());
        pokemon.setDefense(createDto.defense());
        pokemon.setImageUrl(createDto.imageUrl());

        pokemon.setTrainer(trainer);
        pokemon.setTypes(types);
        pokemon.setAbilities(abilities);

        return pokemonRepository.save(pokemon);
    }

    private List<Type> resolveTypes(List<String> typeNames) {
        return typeNames.stream()
                .map(name -> typeRepository.findByName(name)
                        .orElseGet(() -> typeRepository.save(new Type(null, name))))
                .collect(Collectors.toList());
    }

    private List<Ability> resolveAbilities(List<String> abilityNames) {
        return abilityNames.stream()
                .map(name -> abilityRepository.findByName(name)
                        .orElseGet(() -> abilityRepository.save(new Ability(null, name))))
                .collect(Collectors.toList());
    }
}
