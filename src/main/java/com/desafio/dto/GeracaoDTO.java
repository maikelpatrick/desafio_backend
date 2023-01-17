package com.desafio.dto;

import com.desafio.domain.Geracao;
import com.desafio.domain.Regiao;

public class GeracaoDTO {

	private String valor;
	
	private String compra;
	
	private Regiao regiao;
	
	public GeracaoDTO() {
		
	}

	public GeracaoDTO(String valor, Regiao regiao) {
		super();
		this.valor = valor;
		this.regiao = regiao;
	}
	

	public GeracaoDTO(Geracao ge) {
		super();
		this.valor = ge.getValor();
		this.regiao = ge.getRegiao();
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
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
