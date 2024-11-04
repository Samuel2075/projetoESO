package com.example.projetoESO.controllers;

import com.example.projetoESO.services.HabitatService;
import com.example.projetoESO.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HabitatController {
    @Autowired
    private HabitatService habitatService;
    @GetMapping("/habitats")
    @ResponseBody
    ResponseEntity<?> getAllhabitats() {
        return ResponseEntity.ok(habitatService.getAllHabitats());
    }
}
