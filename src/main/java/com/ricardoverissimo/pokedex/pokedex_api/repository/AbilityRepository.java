package com.ricardoverissimo.pokedex.pokedex_api.repository;

import com.ricardoverissimo.pokedex.pokedex_api.model.Ability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbilityRepository extends JpaRepository<Ability, Long> {
    java.util.Optional<Ability> findByName(String name);
}
