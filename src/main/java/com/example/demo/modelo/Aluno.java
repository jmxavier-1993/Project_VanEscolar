package com.example.demo.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Table(name= "Aluno")
@Entity(name= "Aluno")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (of= "id")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime dataNascimento;
    private String cpf;

    private String telefone;

    @ManyToOne
    private Responsavel responsavel;


}

