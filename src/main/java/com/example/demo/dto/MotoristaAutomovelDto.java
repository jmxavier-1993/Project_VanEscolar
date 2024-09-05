package com.example.demo.dto;


import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.modelo.Endereco;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MotoristaAutomovelDto {

    private Long id;

    @NotNull
    @NotBlank
    private String nome;
    @NotNull
    @NotBlank
    private String cpf;

    @NotNull
    @NotBlank
    private String cnh;

    @Valid
    @NotNull
    private Endereco endereco;

    @NotNull
    @NotBlank
    private String telefone;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime dataDeNascimento;

    @NotNull
    @Valid
    private AutomovelDto automovel;

    
}
