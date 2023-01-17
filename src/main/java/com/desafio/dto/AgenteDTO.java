package com.desafio.dto;

import java.io.Serializable;
import java.util.List;

public class AgenteDTO implements Serializable {

    private static final long serialVersionUID = 1L;
	
	private String codigo;

	private String data;
	
	private List<RegiaoDTO> regioes;
	
	public AgenteDTO() {		
	}

	public AgenteDTO(String codigo, String data, List<RegiaoDTO> regioes) {
		super();
		this.codigo = codigo;
		this.data = data;
		this.regioes = regioes;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<RegiaoDTO> getRegioes() {
		return regioes;
	}

	public void setRegioes(List<RegiaoDTO> regioes) {
		this.regioes = regioes;
	}


	
}

