package com.example.demo.dto;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NotNull
@NoArgsConstructor
@Data
@AllArgsConstructor
public class PedidoCorridaResponsavelDto {

    private Long idMotorista;
}
