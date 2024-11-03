package com.example.projetoESO.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RequestDTO {
    private int count;
    private String next;
    private String previous;
    private List<?> results;
}
