package com.example.projetoESO.dto;

import com.example.projetoESO.entities.Habitat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HabitatsDTO {
    private String name;
    private String url;

    public Habitat convertDtoHabitatToEntity() {
        Habitat habitatEntity = new Habitat();
        habitatEntity.setName(this.getName());
        habitatEntity.setUrl(this.getUrl());
        return habitatEntity;
    }
}
