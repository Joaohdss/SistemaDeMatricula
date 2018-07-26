package com.SistemaDeMatricula.SistemaDeMatricula.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Coordenador")
public class Coordenador {
	
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String senha;
	@Id
	private Integer idCoordenador;

	public String getEmail() {
		
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Integer getIdCoordenador() {
		return idCoordenador;
	}
	public void setIdCoordenador(Integer idCoordenador) {
		this.idCoordenador = idCoordenador;
	}
	

}
