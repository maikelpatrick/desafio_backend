package com.desafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.domain.Compra;
import com.desafio.dto.CompraDTO;
import com.desafio.repositories.CompraRepository;

@Service
public class CompraService {
	
	@Autowired
	private CompraRepository repository;
	
	public Compra create( CompraDTO obj) {
		
		
		Compra retorno = new Compra(null,obj.getCompra(), obj.getRegiao());
		return repository.save(retorno);
					
	}

	public List<Compra> findAll(){
		return repository.findAll();
	}
	
}
