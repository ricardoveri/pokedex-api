package com.ricardoverissimo.pokedex.pokedex_api.repository;
import com.ricardoverissimo.pokedex.pokedex_api.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {
    java.util.Optional<Type> findByName(String name);
}
