package com.example.projetoESO.servicesImpl;

import com.example.projetoESO.entities.Types;
import com.example.projetoESO.repositories.TypeRepository;
import com.example.projetoESO.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeRepository typeRepository;

    @Override
    public void saveType(Types type) {
        typeRepository.save(type);
    }
}
