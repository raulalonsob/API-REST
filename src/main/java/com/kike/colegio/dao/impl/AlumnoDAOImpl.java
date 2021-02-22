package com.kike.colegio.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kike.colegio.dao.AlumnoDAO;
import com.kike.colegio.dtos.AlumnoDTO;
import com.kike.colegio.entities.AlumnoEntity;
import com.kike.colegio.repositorios.AlumnoRepository;

@Service
public class AlumnoDAOImpl implements AlumnoDAO {
	
	@Autowired
	private AlumnoRepository alumnoRepository;

	@Override
	public List<AlumnoDTO> obtenerAlumnosporIdyNombre(Integer id, String nombre) {
		return alumnoRepository.buscaAlumnoporIDyNombre(id, nombre);
	}

	@Override
	public Integer insertarAlumno(Integer id, String nombre, Integer idMunicipio, Integer famNumerosa) {
		
		famNumerosa = (famNumerosa == null) ? 0 : 1;		
		AlumnoEntity alumno = new AlumnoEntity(id, nombre, idMunicipio, famNumerosa);		
		alumnoRepository.save(alumno);
		
		return 1;  
	}

	@Override
	public Integer actualizaralumno(Integer id, String nombre, Integer idMunicipio, Integer famNumerosa) {
		famNumerosa = (famNumerosa == null) ? 0 : 1;
		
		AlumnoEntity alumno = new AlumnoEntity(id, nombre, idMunicipio, famNumerosa);	
		alumnoRepository.save(alumno);
		
		return 1;
	}

	@Override
	public Integer eliminarAlumno(Integer id) {
		alumnoRepository.deleteById(id);
		return 1;
	}

	@Override
	public boolean esFamiliaNumerosa(Integer idAlumno) {
		Optional<AlumnoEntity> a = alumnoRepository.findById(idAlumno);
		AlumnoEntity alumno = a.get();
		
		if(alumno.getFamNumerosa() == 1) {
			return true;
		}else {
			return false;
		}
	}

	



	

	
}
