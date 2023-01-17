package com.desafio.dto;

import java.io.Serializable;

public class AgentesDTO implements Serializable {

    private static final long serialVersionUID = 1L;
		
	private AgenteDTO agente;

	public AgentesDTO(AgenteDTO agente) {
		
		this.agente = agente;
	}
	
	public AgenteDTO getAgente() {
		return agente;
	}

	public void setAgente(AgenteDTO agente) {
		this.agente = agente;
	}

	
	
	
}
