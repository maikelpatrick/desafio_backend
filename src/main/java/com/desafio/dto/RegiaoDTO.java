package com.desafio.dto;

import com.desafio.domain.Agente;

public class RegiaoDTO {

	private String Sigla;
	
	private Agente agente;
	
	public RegiaoDTO() {
		
	}

	public RegiaoDTO(String sigla, Agente agenteDTO) {
		super();
		Sigla = sigla;
		this.agente = agenteDTO;
	}

	public String getSigla() {
		return Sigla;
	}

	public void setSigla(String sigla) {
		Sigla = sigla;
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	
	
	
}
	
	