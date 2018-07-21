package com.SistemaDeMatricula.SistemaDeMatricula.Service;

import java.util.Collection;

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
	
}
