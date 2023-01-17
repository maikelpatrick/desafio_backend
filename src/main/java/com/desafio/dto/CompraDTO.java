package com.desafio.dto;

import com.desafio.domain.Compra;
import com.desafio.domain.Regiao;

public class CompraDTO {
	
	private String compra;
	
	private Regiao regiao;
	
	public CompraDTO() {
		
	}

	public CompraDTO(String compra, Regiao regiao) {
		super();
		this.compra = compra;
		this.regiao = regiao;
	}
	

	public CompraDTO(Compra com) {
		super();
		this.compra = com.getCompra();
		this.regiao = com.getRegiao();
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}

	public String getCompra() {
		return compra;
	}

	public void setCompra(String compra) {
		this.compra = compra;
	}

	
	
	
}
