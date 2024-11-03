package com.example.projetoESO.dto;

import com.example.projetoESO.entities.Color;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ColorDTO {
    private String name;
    private String url;
    public Color convertDtoColorToEntity() {
        Color colorEntity = new Color();
        colorEntity.setName(this.getName());
        colorEntity.setUrl(this.getUrl());
        return colorEntity;
    }
}
