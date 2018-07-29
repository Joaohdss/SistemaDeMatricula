package com.SistemaDeMatricula.SistemaDeMatricula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SistemaDeMatricula.SistemaDeMatricula.models.Coordenador;

@Repository
public interface CoordenadorRepository extends JpaRepository<Coordenador, Integer>{

}
