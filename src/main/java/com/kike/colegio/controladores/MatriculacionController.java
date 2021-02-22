package com.kike.colegio.controladores;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kike.colegio.dao.ComboDAO;
import com.kike.colegio.dao.MatriculacionDAO;
import com.kike.colegio.negocio.INegocio;

@Controller
public class MatriculacionController {
	@Autowired
	private MatriculacionDAO matriculacionImpl;
	
	@Autowired
	private ComboDAO comboImpl;
	
	@Autowired 
	private INegocio negocioImpl;
	
	//Listado notas
	@GetMapping(value = "listadomatriculaciones")
	public String formularioListadoMatriculaciones() {
		return "vistas/matriculaciones/listadoMatriculaciones";
	}
	
	@PostMapping(value = "listadomatriculaciones")
	public String listadoMatriculaciones(
			@RequestParam(value = "idAsig", required = false) Integer idAsig,
			@RequestParam(value = "nombreAsig", required = false) String nombreAsig,
			@RequestParam(value = "idAlum", required = false) Integer idAlum,
			@RequestParam(value= "nombreAlum", required = false) String nombreAlum,
			@RequestParam(value = "fecha", required = false) String fecha,
			@RequestParam(value = "activo") Integer activo,
			ModelMap model) {
		
		model.addAttribute("lista", matriculacionImpl.obtenerMatriculacionesPorIdasigNombreAsigIdalumNombrealumFechaActivo(idAsig, nombreAsig, idAlum, nombreAlum, fecha, activo));
		return "vistas/matriculaciones/listadoMatriculaciones";
	}
	
	//Insertar matriculaciones
	@GetMapping(value = "insertarmatriculacion")
	public String insertarMatriculaFormulario(ModelMap model) {
			
		model.addAttribute("listaAlumnos", comboImpl.comboAlumnos());
		model.addAttribute("listaAsignaturas", comboImpl.comboAsignaturas());
			
		return "vistas/matriculaciones/insertarMatriculaciones";
	}
		
		@PostMapping(value = "insertarmatriculacion")
		public String insertarMatricula(
				@RequestParam(value = "alumnos") Integer idAlumno, 
				@RequestParam(value = "asignaturas") Integer idAsignatura,
				@RequestParam(value = "tasa",  required = false) Double tasa,
				@RequestParam(value = "fecha", required = false) String fecha, 
				ModelMap model){			
			
			model.addAttribute("resultado", matriculacionImpl.insertarMatriculacion(idAlumno, idAsignatura, tasa, fecha));
			
			model.addAttribute("listaAlumnos", comboImpl.comboAlumnos());
			model.addAttribute("listaAsignaturas", comboImpl.comboAsignaturas());
			
			return "vistas/matriculaciones/insertarMatriculaciones";
			
		}
		
		//Cálculo de la tasa 
		@PostMapping(value = "tasa")
		@ResponseBody
		public Double calculoTasa(
				@RequestParam(value = "alumnos") Integer idAlumno,
				@RequestParam(value = "asignaturas") Integer idAsignatura) {	
			
			return negocioImpl.calcularTasa(idAlumno, idAsignatura); 
		}
		
		//Borrar matrícula
		@GetMapping(value = "formularioborrarmatriculaciones")
		public String MostrarFormularioBorrarMatricula() {
			return "vistas/matriculaciones/borrarMatriculaciones";
		}
			
		@PostMapping(value = "formularioborrarmatriculaciones")
		public String FormularioBorrarMatriculaciones(
				@RequestParam(value = "idAsig", required = false) Integer idAsig,
				@RequestParam(value = "nombreAsig", required = false) String nombreAsig,
				@RequestParam(value = "idAlum", required = false) Integer idAlum,
				@RequestParam(value= "nombreAlum", required = false) String nombreAlum,
				@RequestParam(value = "fecha", required = false) String fecha,
				@RequestParam(value = "activo") Integer activo,
				ModelMap model) {
				
			model.addAttribute("lista", matriculacionImpl.obtenerMatriculacionesPorIdasigNombreAsigIdalumNombrealumFechaActivo(idAsig, nombreAsig, idAlum, nombreAlum, fecha, activo));
			return "vistas/matriculaciones/borrarMatriculaciones";
		}
			
		@PostMapping(value = "borrarmatriculaciones")
		public String BorrarMatricula(
				@RequestParam(value = "idMatricula") Integer idMatricula,
				ModelMap modelMap) {
				
			modelMap.addAttribute("resultado", matriculacionImpl.borrarMatriculacion(idMatricula));
			return "vistas/matriculaciones/borrarMatriculaciones";
		}
}
