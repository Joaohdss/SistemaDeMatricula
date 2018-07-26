package com.SistemaDeMatricula.SistemaDeMatricula.Service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaDeMatricula.SistemaDeMatricula.models.Aluno;
import com.SistemaDeMatricula.SistemaDeMatricula.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	public Aluno add(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	public Collection<Aluno> buscarTodos(){
		return alunoRepository.findAll();
	}

	public Aluno BuscaId(Long matricula) throws Exception {
		Optional<Aluno> optAluno = alunoRepository.findById(matricula);
		if(!optAluno.isPresent()) {
			throw new Exception("ERROR!!");
		}
		Aluno aluno = optAluno.get();
		
		return aluno;
	}
	public Aluno buscaEmail(String email) {
		Collection<Aluno> alunos = alunoRepository.findAll();
		for (Aluno aluno : alunos) {
			if(aluno.getEmail().equalsIgnoreCase(email)) {
				return aluno;
			}
		}
		return null;
		
	}
	public Aluno update(Aluno aluno, Long matricula) throws Exception {
		Optional<Aluno> optAluno = alunoRepository.findById(matricula);
		if (!optAluno.isPresent()) {
			throw new Exception("Aluno don't exists");
		}
		Aluno newAluno = optAluno.get();
		newAluno.setNome(aluno.getNome());
		alunoRepository.save(newAluno);
		
		return newAluno;
	}
	
	public Aluno excluir(Long matricula) throws Exception{
		Optional<Aluno> optAluno = alunoRepository.findById(matricula);
		if(!optAluno.isPresent()) {
			throw new Exception("ERROR!!");
		}
		Aluno aluno = optAluno.get();
		alunoRepository.delete(aluno);
		
		return aluno;
	}
	
}