package com.desafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.domain.Geracao;
import com.desafio.dto.GeracaoDTO;
import com.desafio.repositories.GeracaoRepository;

@Service
public class GeracaoService {
	
	@Autowired
	private GeracaoRepository repository;
	
	public Geracao create( GeracaoDTO obj) {
		
		
		Geracao retorno = new Geracao(null,obj.getValor(), obj.getRegiao());
		return repository.save(retorno);
					
	}

	public List<Geracao> findAll(){
		return repository.findAll();
	}
	
}
