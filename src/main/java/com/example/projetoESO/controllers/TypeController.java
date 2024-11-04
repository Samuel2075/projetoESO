package com.example.projetoESO.controllers;

import com.example.projetoESO.services.ColorService;
import com.example.projetoESO.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TypeController {
    @Autowired
    private TypeService typeService;
    @GetMapping("/types")
    @ResponseBody
    ResponseEntity<?> getAllColors() {
        return ResponseEntity.ok(typeService.getAllTypes());
    }
}
