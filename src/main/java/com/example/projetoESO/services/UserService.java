package com.example.projetoESO.services;

import com.example.projetoESO.dto.CapturePokemonDTO;
import com.example.projetoESO.dto.CaptureResponseDTO;
import com.example.projetoESO.entities.User;

public interface UserService {
    User findByUserName(String username);
    void saveUser(User user);
    CaptureResponseDTO capturePokemon(CapturePokemonDTO capturePokemonDTO);
}
