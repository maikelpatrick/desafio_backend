package com.desafio.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Agente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String codigo;
	
	private String data;
		
	public Agente() {
		super();		
	}
	
	public Agente(Agente agente) {
		this.codigo = agente.getCodigo();
		this.data = agente.getData();
		
	}
		

	public Agente(Integer id, String codigo, String data) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.data = data;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
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

	
    
	
	

}
