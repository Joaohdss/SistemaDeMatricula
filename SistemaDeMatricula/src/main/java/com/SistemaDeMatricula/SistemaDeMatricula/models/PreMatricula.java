package com.SistemaDeMatricula.SistemaDeMatricula.models;

/**
 * Classe que faz a conexão entre Aluno e Disciplina
 *
 */
public class PreMatricula {
	private Aluno aluno;
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
	
}
