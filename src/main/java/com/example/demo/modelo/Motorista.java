package com.example.demo.modelo;

import java.time.LocalDateTime;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Table (name="Motorista")
@Entity (name="Motorista")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode (of= "id")
public class Motorista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String cnh;
    private String telefone;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime dataDeNascimento;

    @OneToOne(cascade = CascadeType.ALL)
    private Automovel automovel;

    @Enumerated(EnumType.STRING)
    private StatusPedidoCorrida statusPedidoCorrida;


    @Embedded
    private Endereco endereco;

    @OneToMany(mappedBy = "motorista", cascade = CascadeType.ALL)
    private List<Responsavel> responsavel = new ArrayList<>();





}
