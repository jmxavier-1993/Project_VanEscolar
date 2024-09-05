package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Motorista;

@Repository
public interface MotoristaRepository extends JpaRepository<Motorista,Long> {



    Page<Motorista> findByEndereco_CidadeOrEndereco_Bairro(String cidade, String bairro, Pageable pageable);



}
