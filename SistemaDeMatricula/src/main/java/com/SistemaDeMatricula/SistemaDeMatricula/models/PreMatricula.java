package com.SistemaDeMatricula.SistemaDeMatricula.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe que faz a conexão entre Aluno e Disciplina
 *
 */
@Entity
@Table(name = "PreMatricula")
public class PreMatricula implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idPreMatricula;
	
	@ManyToOne
	@JoinColumn
	private Aluno aluno;
	
	@JoinColumn
	private Disciplina disciplina;
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Long getIdPreMatricula() {
		return idPreMatricula;
	}
	
	public void setIdPreMatricula(Long idPreMatricula) {
		this.idPreMatricula = idPreMatricula;
	}
}
