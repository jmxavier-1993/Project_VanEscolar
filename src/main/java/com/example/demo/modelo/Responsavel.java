package com.example.demo.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table (name="Responsavel")
@Entity(name="Responsavel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode (of= "id")
public class Responsavel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Date dataNascimento;
    private String cpf;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;


    @Enumerated(EnumType.STRING)
    private StatusPedidoCorrida statusPedidoCorrida;

    @ManyToOne
    private Motorista motorista;

    @Embedded
    private Endereco endereco;

    @OneToMany(mappedBy = "responsavel", cascade = CascadeType.ALL)
    private List<Aluno> aluno = new ArrayList<>();



}
