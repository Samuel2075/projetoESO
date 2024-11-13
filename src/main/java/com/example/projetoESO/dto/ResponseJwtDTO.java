package com.example.projetoESO.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseJwtDTO {
    private String message;
    private Object data;
}
