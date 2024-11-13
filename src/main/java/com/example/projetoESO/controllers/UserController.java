package com.example.projetoESO.controllers;

import com.example.projetoESO.dto.CapturePokemonDTO;
import com.example.projetoESO.dto.ResponseJwtDTO;
import com.example.projetoESO.entities.User;
import com.example.projetoESO.form.RegisterForm;
import com.example.projetoESO.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "https://pokedexprojetoeso.netlify.app", allowedHeaders = "Authorization, Content-Type")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<?>  registerUser(@RequestBody RegisterForm registerForm) {
        ResponseJwtDTO responseJwtDTO = new ResponseJwtDTO();
        if (userService.findByUserName(registerForm.getUsername()) != null) {
            responseJwtDTO.setMessage("Usuário já cadastrado!");
            return ResponseEntity.ok(responseJwtDTO);
        }
        User newUser = registerForm.convertDtoUserToEntity(registerForm);
        userService.saveUser(newUser);
        responseJwtDTO.setMessage("Usuário registrado com sucesso!");
        return ResponseEntity.ok(responseJwtDTO);
    }

    @PostMapping("/pokemon/capture")
    @ResponseBody
    ResponseEntity<?> capturePokemon(@RequestBody @Valid CapturePokemonDTO capturePokemonDTO) {
        return ResponseEntity.ok(userService.capturePokemon(capturePokemonDTO));
    }

}
