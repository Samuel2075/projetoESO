package com.example.projetoESO.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String userName;
    @Column(unique = true, length = 100, nullable = false)
    private String name;
    @Column(nullable = false)
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Pokemon> pokemons = new HashSet<>();

    public void addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        pokemon.setUser(this);
    }

    public void removePokemon(Pokemon pokemon) {
        pokemons.remove(pokemon);
        pokemon.setUser(null);
    }
}
