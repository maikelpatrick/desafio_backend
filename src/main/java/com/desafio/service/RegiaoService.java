package com.desafio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.domain.Regiao;
import com.desafio.dto.RegiaoDTO;
import com.desafio.repositories.RegiaoRepository;

@Service
public class RegiaoService {
	
	@Autowired
	private RegiaoRepository repository;
	
	public Regiao create( RegiaoDTO obj) {
		
		
		Regiao retorno = new Regiao(null,obj.getSigla(),obj.getAgente());
		return repository.save(retorno);
					
	}

}
