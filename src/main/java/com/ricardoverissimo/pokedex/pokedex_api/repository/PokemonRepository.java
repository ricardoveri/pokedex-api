package com.ricardoverissimo.pokedex.pokedex_api.repository;

import com.ricardoverissimo.pokedex.pokedex_api.model.Pokemon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PokemonRepository extends JpaRepository<Pokemon, Long>, JpaSpecificationExecutor<Pokemon> {
    Page<Pokemon> findByNameContainingIgnoreCase(String name, Pageable pageable);
    Page<Pokemon> findByTrainerId(Long TrainerId, Pageable pageable);
}
