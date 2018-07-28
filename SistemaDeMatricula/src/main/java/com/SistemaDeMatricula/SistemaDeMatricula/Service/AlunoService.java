package com.SistemaDeMatricula.SistemaDeMatricula.Service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaDeMatricula.SistemaDeMatricula.Util.Util;
import com.SistemaDeMatricula.SistemaDeMatricula.models.Aluno;
import com.SistemaDeMatricula.SistemaDeMatricula.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	AlunoRepository alunoRepository;
	@Autowired
	Util util;
	
	public Aluno add(Aluno aluno) throws Exception {
		Aluno alunoAdd = null;
		
		String senhaS = aluno.getSenha();
		aluno.setSenha(util.criptografar(senhaS));
		
		if(util.validaEmailAluno(aluno.getEmail()) && util.validaNomeAluno(aluno.getNome())) {
			if (existe(aluno.getEmail(), aluno.getMatricula()) == false)
				alunoAdd = alunoRepository.save(aluno);
		}
		return alunoAdd;
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
		newAluno.setSenha(util.criptografar(aluno.getSenha()));
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
	
	public boolean existe(String email, Long matricula) throws Exception {
		boolean status = false;
		if (buscaEmail(email) != null || BuscaId(matricula) != null) 
			status = true;
		return status;
	}
}