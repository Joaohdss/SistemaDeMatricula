package com.SistemaDeMatricula.SistemaDeMatricula.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.SistemaDeMatricula.SistemaDeMatricula.Service.AlunoService;
import com.SistemaDeMatricula.SistemaDeMatricula.models.Aluno;

@Controller
public class AlunoController {
	
	@Autowired
	AlunoService alunoService;
	
	@RequestMapping(value = "/api/aluno/post", method = RequestMethod.POST)
	public ResponseEntity<Aluno> add(@RequestBody Aluno aluno) {
		return new ResponseEntity<>(alunoService.add(aluno),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/aluno/get", method = RequestMethod.GET)
	public ResponseEntity<Collection<Aluno>> getAluno() {
		Collection<Aluno> alunos = alunoService.buscarTodos();
		return new ResponseEntity<>(alunos, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/aluno/matricula/{matricula}", method = RequestMethod.GET)
	public ResponseEntity<Aluno> buscaMatricula(@PathVariable("matricula") Long matricula) throws Exception {
		return new ResponseEntity<>(alunoService.BuscaId(matricula), HttpStatus.OK);
	}
	@RequestMapping(value = "/api/aluno/get/email/{email}", method = RequestMethod.GET)
	public ResponseEntity<Aluno> buscaEmail(@PathVariable("email") String email){
		return new ResponseEntity<>(alunoService.buscaEmail(email), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/aluno/put/{matricula}", method = RequestMethod.PUT)
	public ResponseEntity<Aluno> setAluno(@PathVariable("matricula") Long matricula, @RequestBody Aluno aluno) throws Exception {
		Aluno alunoAlterado = alunoService.update(aluno, matricula);
		return new ResponseEntity<>(alunoAlterado,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/aluno/delete/{matricula}", method = RequestMethod.DELETE)
	public ResponseEntity<Aluno> deleteAluno(@PathVariable("matricula") Long matricula) throws Exception {
		return new ResponseEntity<>(alunoService.excluir(matricula), HttpStatus.OK);
	}
}