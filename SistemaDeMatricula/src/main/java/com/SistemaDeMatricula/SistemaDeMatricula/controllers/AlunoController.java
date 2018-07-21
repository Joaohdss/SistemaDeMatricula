package com.SistemaDeMatricula.SistemaDeMatricula.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
}
