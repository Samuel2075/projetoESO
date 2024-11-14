package com.example.projetoESO.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonFilterForm {
    private String name;
    private String habitat;
    private String color;
    private int minWeight;
    private int maxWeight;
    private String type;
    private int minBaseExperience;
    private int maxBaseExperience;
    private int page;
    private int size;
    private long idUser;
    private Boolean allCapturetedPokemons;

}
