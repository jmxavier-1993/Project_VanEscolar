package com.example.demo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@NotNull
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDto {

    private Long id;
    private String nome;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime dataNascimento;
    private String cpf;

    private String telefone;

}
