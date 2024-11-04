package com.example.projetoESO.controllers;

import com.example.projetoESO.services.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ColorController {
    @Autowired
    private ColorService colorService;
    @GetMapping("/colors")
    @ResponseBody
    ResponseEntity<?> getAllColors() {
        return ResponseEntity.ok(colorService.getAllColors());
    }
}
