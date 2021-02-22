package com.kike.colegio.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kike.colegio.dao.NotaDAO;
import com.kike.colegio.dtos.NotaDTO;
import com.kike.colegio.entities.AlumnoEntity;
import com.kike.colegio.entities.AsignaturaEntity;
import com.kike.colegio.entities.NotaEntity;
import com.kike.colegio.repositorios.AlumnoRepository;
import com.kike.colegio.repositorios.AsignaturaRepository;
import com.kike.colegio.repositorios.NotaRepository;

@Service
public class NotaDAOImpl implements NotaDAO {

	@Autowired
	private NotaRepository notaRepository;
	
	@Autowired 
	private AlumnoRepository alumnoRepository;
	
	@Autowired 
	private AsignaturaRepository asignaturaRepository;
	
	@Override
	public List<NotaDTO> obtenerNotaPorIdNombreAsignaturaNotaFecha(Integer idAlumno, String nombre, String asignatura,
			Double nota, String fecha) {
		
		return notaRepository.obtenerNotaPorIdNombreAsignaturaNotaFecha(idAlumno, nombre, asignatura, nota, fecha);
	}

	@Override
	public List<NotaDTO> obtenerNotaPorNombreAsignaturaFecha(String nombre, String asignatura, String fecha) {
		
		return notaRepository.obtenerNotaPorNombreAsignaturaFecha(nombre, asignatura, fecha);
	}

	@Override
	public Integer insertarNota(Integer idAlumno, Integer idAsignatura, Double nota, String fecha) {
		if (fecha == "") {
			Date cDate = new Date();
		    fecha = new SimpleDateFormat("yyyy-MM-dd").format(cDate);
		}
		
		Optional<AlumnoEntity> a = alumnoRepository.findById(idAlumno);
		AlumnoEntity alumno = a.get();
		
		Optional<AsignaturaEntity> asig = asignaturaRepository.findById(idAsignatura);
		AsignaturaEntity asignatura = asig.get();
		
		NotaEntity n = new NotaEntity(alumno, asignatura, nota, fecha);
		notaRepository.save(n);
		
		return 1;
	}

	@Override
	public Integer actualizarNota(Integer idNota, Integer idAlumno, Integer idAsignatura, Double nota, String fecha) {
		
		Optional<AlumnoEntity> a = alumnoRepository.findById(idAlumno);
		AlumnoEntity alumno = a.get();
		
		Optional<AsignaturaEntity> asig = asignaturaRepository.findById(idAsignatura);
		AsignaturaEntity asignatura = asig.get();
		
		NotaEntity n = new NotaEntity(idNota, alumno, asignatura, nota, fecha);
		notaRepository.save(n);
		
		return 1;
	}

	@Override
	public Integer eliminarNota(Integer id) {
		notaRepository.deleteById(id);
		return 1;
	}

}
