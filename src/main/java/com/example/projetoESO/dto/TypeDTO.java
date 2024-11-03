package com.example.projetoESO.dto;

import com.example.projetoESO.entities.Types;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypeDTO {
    private String name;
    private String url;
    public Types convertDtoTypeToEntity() {
        Types typeEntity = new Types();
        typeEntity.setName(this.getName());
        typeEntity.setUrl(this.getUrl());
        return typeEntity;
    }
}
