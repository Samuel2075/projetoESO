package com.example.projetoESO.repositories;

import com.example.projetoESO.entities.Pokemon;
import com.example.projetoESO.form.PokemonFilterForm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PokemonRepository extends JpaRepository<Pokemon, Long>{
    Pokemon findByName(String name);
}
