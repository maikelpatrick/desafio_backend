package com.desafio.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Regiao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String sigla;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Agente agente;

	public Regiao() {
	}
	
	public Regiao(Regiao regiao) {
		this.sigla = regiao.getSigla();
		this.agente = regiao.getAgente();
	}

	public Regiao(Integer id, String sigla, Agente agente) {
		super();
		this.id = id;
		this.sigla = sigla;
		this.agente = agente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}
	

	
	
	
}
