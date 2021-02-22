package com.kike.colegio.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kike.colegio.dao.MatriculacionDAO;
import com.kike.colegio.dtos.MatriculacionDTO;
import com.kike.colegio.entities.AlumnoEntity;
import com.kike.colegio.entities.AsignaturaEntity;
import com.kike.colegio.entities.CajaEntity;
import com.kike.colegio.entities.MatriculacionEntity;
import com.kike.colegio.repositorios.AlumnoRepository;
import com.kike.colegio.repositorios.AsignaturaRepository;
import com.kike.colegio.repositorios.CajaRepository;
import com.kike.colegio.repositorios.MatriculaRepository;

@Service
public class MatriculacionDAOImpl implements MatriculacionDAO {
	
	@Autowired
	private MatriculaRepository matriculacionRepository;
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	@Autowired
	private CajaRepository cajaRepository;

	@Override
	public List<MatriculacionDTO> obtenerMatriculacionesPorIdasigNombreAsigIdalumNombrealumFechaActivo(Integer idAsig,
			String nombreAsig, Integer idAlum, String nombreAlum, String fecha, Integer activo) {
		
		return matriculacionRepository.obtenerMatriculacionesPorIdasigNombreAsigIdalumNombrealumFechaActivo(idAsig, nombreAsig, idAlum, nombreAlum, fecha, activo);
	}

	@Override
	public Integer insertarMatriculacion(Integer idAlumno , Integer idAsignatura , Double tasa, String fecha) {
		if (fecha == "") {
			Date cDate = new Date();
		    fecha = new SimpleDateFormat("yyyy-MM-dd").format(cDate);
		}
		
		Optional<AlumnoEntity> a = alumnoRepository.findById(idAlumno);
		AlumnoEntity alumno = a.get();
		
		Optional<AsignaturaEntity> asig = asignaturaRepository.findById(idAsignatura);
		AsignaturaEntity asignatura = asig.get();
		
		MatriculacionEntity matriculacion = new MatriculacionEntity(asignatura, alumno, fecha, 1);
		
		CajaEntity caja = new CajaEntity(matriculacion, 10.10);
		
		matriculacionRepository.save(matriculacion);
		cajaRepository.save(caja);
		
		return 1;
	}

	@Override
	public Integer borrarMatriculacion(Integer idMatricula) {
		cajaRepository.deleteById(idMatricula);
		matriculacionRepository.deleteById(idMatricula);
		return 1;
	}

}
