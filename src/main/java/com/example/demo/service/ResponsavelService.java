package com.example.demo.service;

import com.example.demo.dto.PedidoCorridaResponsavelDto;
import com.example.demo.dto.ResponsavelDto;
import com.example.demo.dto.ResponsavelMotoristaDto;
import com.example.demo.modelo.Motorista;
import com.example.demo.modelo.Responsavel;
import com.example.demo.modelo.StatusPedidoCorrida;
import com.example.demo.repository.MotoristaRepository;
import com.example.demo.repository.ResponsavelRepository;
import com.example.demo.exceptions.UsuarioNaoEncontrado;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponsavelService {


    @Autowired
    private ResponsavelRepository responsavelRepository;

    @Autowired
    private MotoristaRepository motoristaRepository;
    @Autowired
    private ModelMapper modelMapper;

    public ResponsavelDto cadastrarResponsavel(ResponsavelDto dto) {

        Responsavel responsavel = modelMapper.map(dto, Responsavel.class);


        responsavel.getAluno().forEach(aluno -> aluno.setResponsavel(responsavel));

        responsavelRepository.save(responsavel);

        return modelMapper.map(responsavel, ResponsavelDto.class);
    }

    public ResponsavelMotoristaDto solicitarCorrida(Long idResponsavel, PedidoCorridaResponsavelDto pedidoCorrida) {

        Responsavel responsavel = responsavelRepository.findById(idResponsavel).orElseThrow(UsuarioNaoEncontrado::new);
        Motorista motorista = motoristaRepository.findById(pedidoCorrida.getIdMotorista()).orElseThrow(UsuarioNaoEncontrado::new);

        responsavel.setStatusPedidoCorrida(StatusPedidoCorrida.Feito_Pedido);
        motorista.setStatusPedidoCorrida(StatusPedidoCorrida.Feito_Pedido);
        responsavel.setMotorista(motorista);

        responsavelRepository.save(responsavel);

        return modelMapper.map(responsavel, ResponsavelMotoristaDto.class);

    }

    public ResponsavelMotoristaDto findByid(Long id) {

        Responsavel responsavel = responsavelRepository.findById(id).orElseThrow(UsuarioNaoEncontrado::new);

        return modelMapper.map(responsavel, ResponsavelMotoristaDto.class);

    }
}
