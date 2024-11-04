package com.example.projetoESO.services;

import com.example.projetoESO.entities.Color;

import java.util.List;

public interface ColorService {
    void saveColor(Color color);
    List<Color> getAllColors();
    Color getColorByName(String name);
}
