package com.example.projetoESO.services;

import com.example.projetoESO.entities.Habitat;

import java.util.List;

public interface HabitatService {
    void saveHabitat(Habitat habitat);
    List<Habitat> getAllHabitats();
    Habitat getHabitatByName(String name);
}
