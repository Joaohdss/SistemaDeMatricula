package com.SistemaDeMatricula.SistemaDeMatricula.Service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaDeMatricula.SistemaDeMatricula.models.Disciplina;
import com.SistemaDeMatricula.SistemaDeMatricula.repository.DisciplinaRepository;

@Service
public class DisciplinaService {
	
	@Autowired
	DisciplinaRepository disciplinaRepository;

	public Disciplina add(Disciplina disciplina) {
		return disciplinaRepository.save(disciplina);
	}
	
	public Collection<Disciplina> buscarTodos() {
		return disciplinaRepository.findAll();
	}
	
	public Disciplina BuscaId(Integer id) throws Exception {
		Optional<Disciplina> opDisciplina = disciplinaRepository.findById(id);
		
		if(!opDisciplina.isPresent()) {
			throw new Exception("ERROR!!");
		}
		Disciplina materia = opDisciplina.get();
		return materia;
	}

	public Disciplina excluir(Integer id) throws Exception{
		Optional<Disciplina> opDisciplina = disciplinaRepository.findById(id);
		
		if(!opDisciplina.isPresent()) {
			throw new Exception("ERROR!!");
		}
		Disciplina materia = opDisciplina.get();
		disciplinaRepository.delete(materia);
		
		return materia;
	}
	
	public Disciplina alterar(Disciplina disciplina) {
		return disciplinaRepository.save(disciplina);
	}
	
	public Disciplina update(Disciplina disciplina, int id) throws Exception {
		Optional<Disciplina> optDisciplina = disciplinaRepository.findById(id);
		if (!optDisciplina.isPresent()) {
			throw new Exception("Todo don't exists");
		}
		Disciplina newDisciplina = optDisciplina.get();
		newDisciplina.setNome(disciplina.getNome());
		
		disciplinaRepository.save(newDisciplina);
		
		return newDisciplina;
	}
}
