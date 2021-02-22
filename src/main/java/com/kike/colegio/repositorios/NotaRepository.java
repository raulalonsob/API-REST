package com.kike.colegio.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kike.colegio.dtos.NotaDTO;
import com.kike.colegio.entities.NotaEntity;

@Repository
public interface NotaRepository extends CrudRepository<NotaEntity, Integer>{
	@Query(value = "select new com.kike.colegio.dtos.NotaDTO (n.id, a.id, a.nombre, asig.id, asig.nombre, n.nota, n.fecha) "
			+ "FROM com.kike.colegio.entities.NotaEntity n JOIN com.kike.colegio.entities.AlumnoEntity a ON n.alumnos.id = a.id "
			+ "JOIN com.kike.colegio.entities.AsignaturaEntity asig ON n.asignaturas.id = asig.id "
			+ "WHERE (a.id LIKE CONCAT('%',:idAlumno,'%') or :idAlumno is null) "
			+ "AND a.nombre LIKE CONCAT ('%',:nombre,'%') "
			+ "AND asig.nombre LIKE CONCAT ('%',:asignatura,'%') "
			+ "AND (n.nota LIKE CONCAT ('%',:nota,'%' ) or :nota is null ) "
			+ "AND n.fecha LIKE CONCAT ('%',:fecha,'%') or :fecha is null")
			  List<NotaDTO> obtenerNotaPorIdNombreAsignaturaNotaFecha(
					  @Param("idAlumno") Integer idAlumno,
					  @Param("nombre") String nombre,
					  @Param("asignatura") String asignatura,
					  @Param("nota") Double nota,
					  @Param("fecha") String fecha);
	
	@Query(value = "select new com.kike.colegio.dtos.NotaDTO (n.id, a.id, a.nombre, asig.id, asig.nombre, n.nota, n.fecha) "
			+ "FROM com.kike.colegio.entities.NotaEntity n JOIN com.kike.colegio.entities.AlumnoEntity a ON n.alumnos.id = a.id "
			+ "JOIN com.kike.colegio.entities.AsignaturaEntity asig ON n.asignaturas.id = asig.id "
			+ "AND a.nombre LIKE CONCAT ('%',:nombre,'%') "
			+ "AND asig.nombre LIKE CONCAT ('%',:asignatura,'%') "
			+ "AND n.fecha LIKE CONCAT ('%',:fecha,'%') or :fecha is null")
			  List<NotaDTO> obtenerNotaPorNombreAsignaturaFecha(
					  @Param("nombre") String nombre,
					  @Param("asignatura") String asignatura,
					  @Param("fecha") String fecha);
}
