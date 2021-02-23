package com.kike.colegio.controladores.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kike.colegio.dao.MatriculacionDAO;
import com.kike.colegio.dtos.MatriculacionDTO;
import com.kike.colegio.entities.MatriculacionEntity;
import com.kike.colegio.entities.NotaEntity;
import com.kike.colegio.negocio.INegocio;
import com.kike.colegio.repositorios.MatriculaRepository;

@RestController
@RequestMapping("/v1")
public class MatriculacionControllerRest {
	

	@Autowired
	private MatriculaRepository matriculaRepository;
	@Autowired
	private MatriculacionDAO matriculacionDAO;
	
	
	@GetMapping("/matriculas")
	public Iterable<MatriculacionEntity> listarTodasMatriculas(){
		return matriculaRepository.findAll();
	}
	
	@GetMapping(value = "/matriculas/{id}")
	public Optional<MatriculacionEntity> buscarMatriculaId(@PathVariable("id") Integer id) {
		return matriculaRepository.findById(id);
	}
	
	@GetMapping(value = "/matriculas",params= {"idAsig","nombreAsig","idAlum","nombreAlum","fecha"} )
	public List<MatriculacionDTO> listarMatriculasporParametros(
			@RequestParam(value ="idAsig", required = false) Integer idAsignatura,
			@RequestParam(value ="nombreAsig", required = false) String nombreAsignatura,
			@RequestParam(value ="idAlum", required = false) Integer idAlumno,
			@RequestParam(value ="nombreAlum",required=false) String nombreAlumno, 
			@RequestParam(value = "fecha",required=false) String fecha) {
		return matriculacionDAO.obtenerMatriculacionesPorIdasigNombreAsigIdalumNombrealumFechaActivo(idAsignatura, nombreAsignatura, idAlumno, nombreAlumno, fecha, idAlumno);
	}
	
	@DeleteMapping(value = "/matriculas/{id}")
	public ResponseEntity<String> BorraMatriculas(@PathVariable("id") Integer id) {
		matriculaRepository.deleteById(id);
		return new ResponseEntity<>("Borrado con Exito", HttpStatus.OK);
	}
	
}
