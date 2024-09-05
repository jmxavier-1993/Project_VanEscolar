package com.example.demo.service;

import com.example.demo.dto.MotoristaAutomovelDto;
import com.example.demo.modelo.Motorista;
import com.example.demo.repository.MotoristaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutomovelService {



    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public MotoristaAutomovelDto cadastrarMotorista(MotoristaAutomovelDto motoristaAutomovelDto) {

        Motorista motorista = modelMapper.map(motoristaAutomovelDto, Motorista.class);
        motoristaRepository.save(motorista);

        return modelMapper.map(motorista, MotoristaAutomovelDto.class);
    }

}
