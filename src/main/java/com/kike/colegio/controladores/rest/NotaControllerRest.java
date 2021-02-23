package com.kike.colegio.controladores.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.kike.colegio.entities.NotaEntity;

import com.kike.colegio.repositorios.NotaRepository;

@RestController
@RequestMapping("/v1")
public class NotaControllerRest {

	
	@Autowired
	private NotaRepository notaRepository;
	
	
	@GetMapping("/notas")
	public Iterable<NotaEntity> listarNotas(){
		return notaRepository.findAll();
	}
	
}
