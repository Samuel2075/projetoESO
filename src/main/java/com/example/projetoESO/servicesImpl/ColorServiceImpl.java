package com.example.projetoESO.servicesImpl;

import com.example.projetoESO.entities.Color;
import com.example.projetoESO.repositories.ColorRepository;
import com.example.projetoESO.services.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {
    @Autowired
    private ColorRepository colorRepository;
    @Override
    public void saveColor(Color color) {
        colorRepository.save(color);
    }

    @Override
    public List<Color> getAllColors() {
        return colorRepository.findAll();
    }

    @Override
    public Color getColorByName(String name) {
        return colorRepository.findByName(name);
    }
}
