package com.example.projetoESO.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String urlStatus;
    @ManyToOne
    @JoinColumn(name="habitat_id")
    private Habitat habitat;
    @ManyToMany
    @JoinTable(
            name = "pokemon_type",
            joinColumns = @JoinColumn(name = "pokemon_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id")
    )
    private Set<Types> types = new HashSet<>();
    @ManyToMany
    @JoinTable(
            name = "pokemon_color",
            joinColumns = @JoinColumn(name = "pokemon_id"),
            inverseJoinColumns = @JoinColumn(name = "color_id")
    )
    private Set<Color> colors = new HashSet<>();
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    private String front_default;
    private String front_shiny;
    private int base_experience;
    private int weight;
}
