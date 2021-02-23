package com.kike.colegio.controladores.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kike.colegio.dao.NotaDAO;
import com.kike.colegio.dtos.NotaDTO;
import com.kike.colegio.entities.NotaEntity;

import com.kike.colegio.repositorios.NotaRepository;

@RestController
@RequestMapping("/v1")
public class NotaControllerRest {

	
	@Autowired
	private NotaRepository notaRepository;
	
	@Autowired
	private NotaDAO notaDAO;
	
	
	@GetMapping("/notas")
	public Iterable<NotaEntity> listarTodasNotas(){
		return notaRepository.findAll();
	}
	
	@GetMapping(value = "/notas/{id}")
	public Optional<NotaEntity> buscarNotasporId(@PathVariable("id") Integer id) {
		return notaRepository.findById(id);
	}
	
	@GetMapping(value = "/notas", params= {"idAlumno","nombre","asignatura","nota","fecha"} )
	public List<NotaDTO> listarNotasporParametros(
			@RequestParam(value ="idAlumno", required = false) Integer idAlumno,
			@RequestParam(value ="nombre", required = false) String nombre,
			@RequestParam(value ="asignatura", required = false) String asignatura,
			@RequestParam(value ="nota", required = false) Double nota,
			@RequestParam(value ="fecha", required = false) String fecha) {
		
		return notaDAO.obtenerNotaPorIdNombreAsignaturaNotaFecha(idAlumno, nombre, asignatura, nota, fecha);
	}
	
	@DeleteMapping(value = "/notas/{id}")
	public ResponseEntity<String> MostrarFormularioBorraAlumnos(@PathVariable("id") Integer id) {
		notaRepository.deleteById(id);
		return new ResponseEntity<>("Borrado con Exito", HttpStatus.OK);
	}
	
	
	
}
