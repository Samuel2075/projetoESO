package com.example.projetoESO.services;

import com.example.projetoESO.entities.Types;

public interface TypeService {
    void saveType(Types type);
    Types getTypeByName(String name);
}
