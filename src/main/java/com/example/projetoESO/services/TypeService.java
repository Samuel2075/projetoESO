package com.example.projetoESO.services;

import com.example.projetoESO.entities.Types;

import java.util.List;

public interface TypeService {
    void saveType(Types type);
    Types getTypeByName(String name);
    List<Types> getAllTypes();
}
