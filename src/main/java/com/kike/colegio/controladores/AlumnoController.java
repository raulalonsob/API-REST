package com.kike.colegio.controladores;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kike.colegio.dao.AlumnoDAO;
import com.kike.colegio.dao.ComboDAO;

@Controller
public class AlumnoController {
	
	@Autowired
	private ComboDAO combo;
	
	@Autowired
	private AlumnoDAO alumnoImpl;
	
	//private static final Logger logger = LoggerFactory.getILoggerFactory(AlumnoController.class);
	
	@GetMapping(value = "insertaralumno")
	public String formularioInsertarAlumno(ModelMap model) {
		model.addAttribute("listaMunicipios", combo.comboMunicipios());
		
		return "vistas/alumnos/insertarAlumnos";		
	}
	
	@PostMapping(value = "insertaralumno")
	public String InsertarAlumno(
			@RequestParam(value = "id", required = false) Integer id, 
			@RequestParam(value = "nombre") String nombre, @RequestParam(value = "municipios") Integer idMunicipio,
			@RequestParam(value = "familiaNumerosa", required = false) Integer familiaNumerosa, 
			ModelMap model){
		
		
		model.addAttribute("resultado", alumnoImpl.insertarAlumno(id, nombre, idMunicipio, familiaNumerosa));
		model.addAttribute("listaMunicipios", combo.comboMunicipios());
		
		return "vistas/alumnos/insertarAlumnos";	
		
	}
	
	//Listado alumnos
	@GetMapping(value = "listadoalumnos")
	public String FormularioListadoAlumnos(ModelMap model) {
		return "vistas/alumnos/listadoAlumnos";
	}
	
	
	@PostMapping(value = "listadoalumnos")
	public String listarAlumnos(
			@RequestParam(value = "id", required = false) Integer id , 
			@RequestParam("nombre") String nombre, 
			ModelMap model) {
		
		
		model.addAttribute("lista", alumnoImpl.obtenerAlumnosporIdyNombre(id, nombre));
		return "vistas/alumnos/listadoAlumnos";
	}
	
	//Borrar alumnos
	@GetMapping(value = "formularioeliminaralumno")
	public String MostrarFormularioBorrarAlumnos() {
		return "vistas/alumnos/eliminarAlumnos";
	}
	
	@PostMapping(value = "formularioeliminaralumno")
	public String FormularioBorrarAlumnos(
			@RequestParam(value = "id", required = false) Integer id , 
			@RequestParam("nombre") String nombre, 
			ModelMap model) {
		
		model.addAttribute("lista", alumnoImpl.obtenerAlumnosporIdyNombre(id, nombre));
		return "vistas/alumnos/eliminarAlumnos";
	}
	
	@PostMapping(value = "eliminaralumno")
	public String BorrarAlumnos(
			@RequestParam(value = "id") Integer id,
			ModelMap modelMap) {
		
		modelMap.addAttribute("resultado", alumnoImpl.eliminarAlumno(id));
		return "vistas/alumnos/eliminarAlumnos";
	}
	
	
	//Actualizar alumnos
	@GetMapping(value = "formularioactualizaralumnos")
	public String FormularioActualizarAlumnos() {
		
		return "vistas/alumnos/actualizarAlumnos";
	}
	
	@PostMapping(value = "formularioactualizaralumnos")
	public String FormularioActualizarAlumnos(
			@RequestParam(value = "id", required = false) Integer id , 
			@RequestParam("nombre") String nombre, 
			ModelMap model) {
		
		model.addAttribute("lista", alumnoImpl.obtenerAlumnosporIdyNombre(id, nombre));
		model.addAttribute("listaMunicipios", combo.comboMunicipios());
		return "vistas/alumnos/actualizarAlumnos";
	}
	
	@PostMapping(value = "actualizaralumno")
	public String ActualizarAlumnos(
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "nombre") String nombre,
			@RequestParam(value = "municipios") Integer idMunicipio,
			@RequestParam(value = "familiaNumerosa", required = false) Integer famNumerosa,
			ModelMap modelMap) {		
		
		modelMap.addAttribute("listaMunicipios", combo.comboMunicipios());		
		modelMap.addAttribute("resultado", alumnoImpl.actualizaralumno(id, nombre, idMunicipio, famNumerosa));		
		
		return "vistas/alumnos/actualizarAlumnos";
	}
}
