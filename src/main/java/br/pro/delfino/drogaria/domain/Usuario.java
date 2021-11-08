/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pro.delfino.drogaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 *
 * @author S60254831168
 */
@Entity
public class Usuario extends GenericDomain {
	private String senha;

	private Character tipo;

	private Boolean ativo;

	private Pessoa pessoa;

        @Column(length = 32, nullable = false)
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

        @Column(nullable = false)
	public Character getTipo() {
		return tipo;
	}

	@Transient
	public String getTipoFormatado() {
		String tipoFormatado = null;

		if (tipo == 'A') {
			tipoFormatado = "Administrador";
		} else if (tipo == 'B') {
			tipoFormatado = "Balconista";
		} else if (tipo == 'G') {
			tipoFormatado = "Gerente";
		}
		
		return tipoFormatado;
	}

	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}

        @Column(nullable = false)
	public Boolean getAtivo() {
		return ativo;
	}
	
	@Transient
	public String getAtivoFormatado(){
		String ativoFormatado = "Não";
		
		if(ativo){
			ativoFormatado = "Sim";
		}
		
		return ativoFormatado;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

        @OneToOne
        @JoinColumn(nullable = false)
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
