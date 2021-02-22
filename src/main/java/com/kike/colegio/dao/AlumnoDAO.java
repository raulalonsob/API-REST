package com.kike.colegio.dao;

import java.util.List;

import com.kike.colegio.dtos.AlumnoDTO;
import com.kike.colegio.entities.AlumnoEntity;

public interface AlumnoDAO {
	List<AlumnoDTO> obtenerAlumnosporIdyNombre(Integer id, String nombre);
	Integer insertarAlumno(Integer id, String nombre, Integer idMunicipio, Integer famNumerosa);
	Integer actualizaralumno(Integer id, String nombre, Integer idMunicipio, Integer famNumerosa);
	Integer eliminarAlumno(Integer id);
	boolean esFamiliaNumerosa(Integer idAlumno);
}
