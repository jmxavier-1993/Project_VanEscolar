package com.example.demo.dto;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AutomovelDto {

    private Long id;
    @NotBlank
    private String modelo;
    @NotBlank
    private String nomeCarro;

    @NotBlank
    private String placa;
}
