package com.kike.colegio.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kike.colegio.dao.AsignaturaDAO;

@Controller
public class AsignaturaController {
	
	@Autowired
	private AsignaturaDAO asignatura;
	
	//Listado asignaturas
	@GetMapping(value = "listadoasignaturas")
	public String listarAsignaturas() {
		return "vistas/asignaturas/listadoAsignaturas";
	}
	
	@PostMapping(value = "listadoasignaturas")
	public String listarAsignaturaPorIdNombreCursoTasa(
			@RequestParam(value = "id", required = false) Integer id , 
			@RequestParam(value = "nombre") String nombre, 
			@RequestParam(value = "curso", required = false) Integer curso,
			@RequestParam(value = "tasa", required = false) Double tasa,
			ModelMap model) {
		
		
		model.addAttribute("lista", asignatura.obtenerAsignaturaPorIdNombreCursoTasa(id, nombre, curso, tasa));
		return "vistas/asignaturas/listadoAsignaturas";
	}
	
	//Insertar asignaturas
	@GetMapping(value = "insertarasignatura")
	public String insertarAsignatura() {
		return "vistas/asignaturas/insertarAsignaturas";
	}
	
	@PostMapping(value = "insertarasignatura")
	public String insertarAsignatura(
			@RequestParam(value = "id", required = false) Integer id, 
			@RequestParam(value = "nombre") String nombre,
			@RequestParam(value = "curso",  required = false) Integer curso,
			@RequestParam(value = "tasa", required = false) Double tasa, 
			ModelMap model){
		
		
		model.addAttribute("resultado", asignatura.insertarAsignatura(id, nombre, curso, tasa));
		
		return "vistas/asignaturas/insertarAsignaturas";	
		
	}
	
	//Actualizar asignaturas
	@GetMapping(value = "formularioactualizarasignatura")
	public String formularioActualizarAsignatura() {
			
		return "vistas/asignaturas/actualizarAsignaturas";
	}
		
	@PostMapping(value = "formularioactualizarasignatura")
	public String busquedaFormularioActualizarAsignatura(
			@RequestParam(value = "id", required = false) Integer id, 
			@RequestParam(value = "nombre") String nombre,
			@RequestParam(value = "curso",  required = false) Integer curso,
			@RequestParam(value = "tasa", required = false) Double tasa, 
			ModelMap model){
			
		model.addAttribute("lista", asignatura.obtenerAsignaturaPorIdNombreCursoTasa(id, nombre, curso, tasa));
		return "vistas/asignaturas/actualizarAsignaturas";
	}
		
	@PostMapping(value = "actualizarasignatura")
	public String ActualizarAlumnos(
			@RequestParam(value = "id", required = false) Integer id, 
			@RequestParam(value = "nombre") String nombre,
			@RequestParam(value = "curso",  required = false) Integer curso,
			@RequestParam(value = "tasa", required = false) Double tasa, 
			ModelMap model) {		
				
		model.addAttribute("resultado", asignatura.actualizarAsignatura(id, nombre, curso, tasa));		
			
		return "vistas/asignaturas/actualizarAsignaturas";
	}
	
	//Borrar asignaturas
	@GetMapping(value = "formularioborrarasignatura")
	public String MostrarFormularioBorrarAsignaturas() {
		return "vistas/asignaturas/borrarAsignaturas";
	}
		
	@PostMapping(value = "formularioborrarasignatura")
	public String FormularioBorrarAlumnos(
			@RequestParam(value = "id", required = false) Integer id, 
			@RequestParam(value = "nombre") String nombre,
			@RequestParam(value = "curso",  required = false) Integer curso,
			@RequestParam(value = "tasa", required = false) Double tasa, 
			ModelMap model) {
			
		model.addAttribute("lista", asignatura.obtenerAsignaturaPorIdNombreCursoTasa(id, nombre, curso, tasa));
		return "vistas/asignaturas/borrarAsignaturas";
	}
		
	@PostMapping(value = "borrarasignatura")
	public String BorrarAlumnos(
			@RequestParam(value = "id") Integer id,
			ModelMap modelMap) {
			
		modelMap.addAttribute("resultado", asignatura.eliminarAsignatura(id));
		return "vistas/asignaturas/borrarAsignaturas";
	}
}
