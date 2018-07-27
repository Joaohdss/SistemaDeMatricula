package com.SistemaDeMatricula.SistemaDeMatricula.Service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaDeMatricula.SistemaDeMatricula.models.Coordenador;
import com.SistemaDeMatricula.SistemaDeMatricula.repository.CoordenadorRepository;

@Service
public class CoordenadorService {
	
	@Autowired
	CoordenadorRepository coordenadorRepository;
	
	public Coordenador add(Coordenador coordenador) {
		return coordenadorRepository.save(coordenador);
	}
	
	public Collection<Coordenador> buscarTodos(){
		return coordenadorRepository.findAll();
	}
	
	public Coordenador excluir(Integer id) throws Exception{
		Optional<Coordenador> opCoordenador = coordenadorRepository.findById(id);
		
		if(!opCoordenador.isPresent()) {
			throw new Exception("ERROR!!");
		}
		Coordenador coord = opCoordenador.get();
		coordenadorRepository.delete(coord);
		
		return coord;
	}
	public Coordenador atualizarSenha(Coordenador coordenador,Integer id) throws Exception {
		Optional<Coordenador> opCoordenador = coordenadorRepository.findById(id);
		if (!opCoordenador.isPresent()) {
			throw new Exception("Todo don't exists");
		}
		Coordenador newCoord = opCoordenador.get();
		newCoord.setSenha(coordenador.getSenha());
		
		coordenadorRepository.save(newCoord);
		
		return newCoord;
	}
	public Integer encontrarIdPorEmail(String email) {
		Collection<Coordenador> coordenadores = coordenadorRepository.findAll();
		for (Coordenador coordenador : coordenadores) {
			if(coordenador.getEmail().equalsIgnoreCase(email)) {
				return coordenador.getIdCoordenador();
			}
		}
		return -1;
	}
}
