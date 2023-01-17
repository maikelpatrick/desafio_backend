package com.desafio.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String compra;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Regiao regiao;

	public Compra() {
	}
	
	
	public Compra(Integer id,  String compra, Regiao regiao) {
		this.id = id;
		this.compra = compra;
		this.regiao = regiao;
	}



	public Compra(Compra geracao) {
		this.compra = geracao.getCompra();
		this.regiao = geracao.getRegiao();
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
