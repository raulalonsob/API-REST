package com.kike.colegio.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kike.colegio.dao.ComboDAO;
import com.kike.colegio.dao.NotaDAO;


@Controller
public class NotaController {
	
	@Autowired
	private NotaDAO notaImpl;
	
	@Autowired
	private ComboDAO combo;
	
	//Listado notas
	@GetMapping(value = "listadonotas")
	public String FormularioListadoNotas() {
		return "vistas/notas/listadoNotas";
	}
	
	@PostMapping(value = "listadonotas")
	public String listarNotasPorIdAlumnoNombreAsignaturaNotaFecha(
			@RequestParam(value = "id", required = false) Integer idAlumno,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "asignatura") String asignatura,
			@RequestParam(value = "nota", required = false) Double nota,
			@RequestParam(value = "fecha", required = false) String fecha,
			ModelMap model){		
		
		model.addAttribute("lista", notaImpl.obtenerNotaPorIdNombreAsignaturaNotaFecha(idAlumno, nombre, asignatura, nota, fecha));
		return "vistas/notas/listadoNotas";
	}
	
	
	//Insertar notas
	@GetMapping(value = "insertarnota")
	public String insertarAsignatura(ModelMap model) {
		
		model.addAttribute("listaAlumnos", combo.comboAlumnos());
		model.addAttribute("listaAsignaturas", combo.comboAsignaturas());
		
		return "vistas/notas/insertarNotas";
	}
	
	@PostMapping(value = "insertarnota")
	public String insertarAsignatura(
			@RequestParam(value = "alumnos") Integer idAlumno, 
			@RequestParam(value = "asignaturas") Integer idAsignatura,
			@RequestParam(value = "nota",  required = false) Double nota,
			@RequestParam(value = "fecha", required = false) String fecha, 
			ModelMap model){
		
		
		model.addAttribute("resultado", notaImpl.insertarNota(idAlumno, idAsignatura, nota, fecha));
		model.addAttribute("listaAlumnos", combo.comboAlumnos());
		model.addAttribute("listaAsignaturas", combo.comboAsignaturas());
		
		return "vistas/notas/insertarNotas";
		
	}
	
	//Actualizar alumnos
	@GetMapping(value = "formularioactualizarnota")
	public String FormularioActualizarNotas() {			
		return "vistas/notas/actualizarNotas";
	}
		
	@PostMapping(value = "formularioactualizarnota")
	public String BuscarFormularioActualizarNotas(
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "asignatura") String asignatura,
			@RequestParam(value = "fecha", required = false) String fecha,
			ModelMap model) {
			
		model.addAttribute("lista", notaImpl.obtenerNotaPorNombreAsignaturaFecha(nombre, nombre, nombre));
		model.addAttribute("listaAlumnos", combo.comboAlumnos());
		model.addAttribute("listaAsignaturas", combo.comboAsignaturas());
		
		return "vistas/notas/actualizarNotas";
	}
		
	@PostMapping(value = "actualizarnota")
	public String ActualizarNotas(
			@RequestParam(value = "idNota") Integer idNota,
			@RequestParam(value = "alumnos") Integer idAlumno, 
			@RequestParam(value = "asignaturas") Integer idAsignatura,
			@RequestParam(value = "nota",  required = false) Double curso,
			@RequestParam(value = "fecha", required = false) String tasa,
			ModelMap model) {		
			
		model.addAttribute("listaAlumnos", combo.comboAlumnos());
		model.addAttribute("listaAsignaturas", combo.comboAsignaturas());
			
		model.addAttribute("resultado", notaImpl.actualizarNota(idNota, idAlumno, idAsignatura, curso, tasa));
		
		return "vistas/notas/actualizarNotas";
	}
	
	//Borrar notas
	@GetMapping(value = "formularioborrarnota")
	public String MostrarFormularioBorrarNotas() {
		return "vistas/notas/borrarNotas";
	}
		
	@PostMapping(value = "formularioborrarnota")
	public String FormularioBorrarNotas(
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "asignatura") String asignatura,
			@RequestParam(value = "fecha", required = false) String fecha,
			ModelMap model) {
			
		model.addAttribute("lista", notaImpl.obtenerNotaPorNombreAsignaturaFecha(nombre, asignatura, fecha));
		return "vistas/notas/borrarNotas";
	}
		
		@PostMapping(value = "borrarnota")
		public String BorrarNota(
				@RequestParam(value = "idNota") Integer idNota,
				ModelMap modelMap) {
			
			modelMap.addAttribute("resultado", notaImpl.eliminarNota(idNota));
			return "vistas/notas/borrarNotas";
		}
}
