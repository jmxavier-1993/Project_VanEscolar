package com.example.demo.controller;


import com.example.demo.dto.*;
import com.example.demo.service.MotoristaService;
import com.example.demo.service.ResponsavelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/responsavel")
@Api(value = "responsavel API", description = "Operations pertaining to responsaveis in the Delivery System")
public class ResponsavelController {

    @Autowired
    private ResponsavelService responsavelService;

    @Autowired
    private MotoristaService motoristaService;

    @PostMapping
    @ApiOperation(value = "Create a new responsavel", response = ResponsavelDto.class)

    public ResponseEntity<ResponsavelDto> cadastrarResponsavel(@RequestBody @Valid ResponsavelDto dto,
                                                               UriComponentsBuilder uriComponentsBuilder) {


        ResponsavelDto responsavelDto = responsavelService.cadastrarResponsavel(dto);
        URI uri = uriComponentsBuilder.path("/responsavel/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(responsavelDto);
    }

    @GetMapping("/motorista")
    public Page<MotoristaDto> procurarMotorista(@RequestParam String cidade,
                                                @RequestParam(required = false) String bairro,
                                                Pageable pageable) {

        return motoristaService.acharMotorista(cidade, bairro, pageable);

    }

    @PatchMapping("/pedido/{idResponsavel}")
    public ResponseEntity<ResponsavelMotoristaDto> pedirCorridas(@PathVariable Long idResponsavel,
                                           @RequestBody @Valid PedidoCorridaResponsavelDto pedidoCorrida) {

        ResponsavelMotoristaDto responsavelMotoristaDto = responsavelService.solicitarCorrida(idResponsavel, pedidoCorrida);

        return ResponseEntity.ok(responsavelMotoristaDto);

    }

    @GetMapping("/{id}")
    public ResponsavelMotoristaDto procurarMotorista(@PathVariable Long id){

        return responsavelService.findByid(id);

    }


}