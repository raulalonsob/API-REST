package com.kike.colegio.controladores.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kike.colegio.dao.ComboDAO;
import com.kike.colegio.dtos.ComboDTO;


@RestController
@RequestMapping("/v1")
public class ComboControllerRest {
	
	@Autowired
	private ComboDAO comboDAO;
	
	@GetMapping(value = "/combos/alumnos")
	public List<ComboDTO> comboAlumnos() {
		return comboDAO.comboAlumnos();
	}
	
	@GetMapping(value = "/combos/asignaturas")
	public List<ComboDTO> comboAsignaturas() {
		return comboDAO.comboAsignaturas();
	}
	
	@GetMapping(value = "/combos/municipios")
	public List<ComboDTO> comboMunicipios() {
		return comboDAO.comboMunicipios();
	}

}
