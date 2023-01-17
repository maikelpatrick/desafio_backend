package com.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.domain.Agente;

public interface AgenteRepository extends JpaRepository<Agente, Integer>{

}
