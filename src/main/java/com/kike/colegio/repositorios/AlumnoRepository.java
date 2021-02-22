package com.kike.colegio.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kike.colegio.dtos.AlumnoDTO;
import com.kike.colegio.entities.AlumnoEntity;

@Repository
public interface AlumnoRepository extends CrudRepository<AlumnoEntity, Integer>{
	
	@Query(value = "select new com.kike.colegio.dtos.AlumnoDTO (a.id, a.nombre, m.nombre, m.idMunicipio, a.famNumerosa) "
			+ "FROM com.kike.colegio.entities.AlumnoEntity a, com.kike.colegio.entities.MunicipioEntity  m "
			+ "WHERE a.idMunicipio = m.idMunicipio "
			+ "AND (a.id LIKE CONCAT('%',:id,'%') or :id is null) "
			+ "AND a.nombre LIKE CONCAT ('%',:nombre,'%') ")
			  List<AlumnoDTO>buscaAlumnoporIDyNombre(@Param("id") Integer id, @Param("nombre")String nombre);
	
}
