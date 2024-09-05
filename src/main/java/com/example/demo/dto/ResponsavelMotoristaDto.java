package com.example.demo.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.modelo.Endereco;
import com.example.demo.modelo.EstadoCivil;
import com.example.demo.modelo.StatusPedidoCorrida;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsavelMotoristaDto {


    private Long id;
    @NotNull
    private String nome;
    private LocalDateTime dataNascimento;
    @NotNull
    private String cpf;
    @NotNull
    private String telefone;

    @NotNull
    @Valid
    private Endereco endereco;

    private StatusPedidoCorrida statusPedidoCorrida;

    @NotNull
    private EstadoCivil estadoCivil;

    private List<AlunoDto> aluno;

    private MotoristaDto motorista;

}

