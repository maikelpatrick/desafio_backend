package com.desafio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.domain.Agente;
import com.desafio.dto.AgenteDTO;
import com.desafio.repositories.AgenteRepository;

@Service
public class AgenteService {
	
	@Autowired
	private AgenteRepository repository;
	
	public Agente create( AgenteDTO obj) {
		Agente agente = new Agente(null, obj.getCodigo(), obj.getData());
		return repository.save(agente);
					
	}

}
