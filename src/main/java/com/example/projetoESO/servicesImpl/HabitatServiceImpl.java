package com.example.projetoESO.servicesImpl;

import com.example.projetoESO.entities.Habitat;
import com.example.projetoESO.repositories.HabitatRepository;
import com.example.projetoESO.services.HabitatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitatServiceImpl implements HabitatService {
    @Autowired
    private HabitatRepository habitatRepository;
    @Override
    public void saveHabitat(Habitat habitat) {
        habitatRepository.save(habitat);
    }

    @Override
    public List<Habitat> getAllHabitats() {
        return habitatRepository.findAll();
    }

    @Override
    public Habitat getHabitatByName(String name) {
        return habitatRepository.findByName(name);
    }
}
