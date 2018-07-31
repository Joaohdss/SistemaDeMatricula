package com.SistemaDeMatricula.SistemaDeMatricula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SistemaDeMatricula.SistemaDeMatricula.models.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	
}