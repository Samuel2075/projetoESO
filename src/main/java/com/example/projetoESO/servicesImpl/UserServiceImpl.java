package com.example.projetoESO.servicesImpl;

import com.example.projetoESO.dto.CapturePokemonDTO;
import com.example.projetoESO.dto.CaptureResponseDTO;
import com.example.projetoESO.entities.Color;
import com.example.projetoESO.entities.Pokemon;
import com.example.projetoESO.entities.User;
import com.example.projetoESO.repositories.PokemonRepository;
import com.example.projetoESO.repositories.UserRepository;
import com.example.projetoESO.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private PokemonRepository pokemonRepository;

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public CaptureResponseDTO capturePokemon(CapturePokemonDTO capturePokemonDTO) {
        User user = null;
        Pokemon pokemon = null;
        CaptureResponseDTO response = new CaptureResponseDTO();
        response.setError(false);
        Optional<User> userOptional = userRepository.findById(capturePokemonDTO.getIdUser());
        Optional<Pokemon> pokemonOptional = pokemonRepository.findById(capturePokemonDTO.getIdPokemon());
        if (userOptional.isPresent() && pokemonOptional.isPresent()){
            user = userOptional.get();
            pokemon = pokemonOptional.get();
            if(user.getPokemons().size() >= 3) {
                response.setMessage("Jogador já capturou 3 ou mais pokemons!");
                response.setError(true);
            } else {
                response.setMessage("Pokemon capturado com sucesso!");
                user.addPokemon(pokemon);
                userRepository.save(user);
            }

        } else {
            response.setMessage("Usuário ou pokemon inesistente!");
        }

        return response;
    }
}
