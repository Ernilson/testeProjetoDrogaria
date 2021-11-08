/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pro.delfino.drogaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author S60254831168
 */
@Entity
public class Estado extends GenericDomain {
	@Column(length = 2, nullable = false)
	private String sigla;
	
	@Column(length = 50, nullable = false)
	private String nome;

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
