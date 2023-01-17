package com.desafio.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Geracao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String valor;
		
	private String precoMedio;
	
		
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Regiao regiao;

	public Geracao() {
	}
	
	
	public Geracao(Integer id, String valor, Regiao regiao) {
		this.id = id;
		this.valor = valor;
		this.precoMedio = "";
		this.regiao = regiao;
	}



	public Geracao(Geracao geracao) {
		this.valor = geracao.getValor();
		this.precoMedio = "";
		this.regiao = geracao.getRegiao();
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getPrecoMedio() {
		return precoMedio;
	}


	public void setPrecoMedio(String precoMedio) {
		this.precoMedio = precoMedio;
	}
	
	
	
}
