package com.kike.colegio.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.kike.colegio.dtos.AsignaturaDTO;
import com.kike.colegio.entities.AsignaturaEntity;

public interface AsignaturaRepository extends CrudRepository<AsignaturaEntity, Integer>{
	@Query(value = "select new com.kike.colegio.dtos.AsignaturaDTO (a.id, a.nombre, a.curso, a.tasa) "
			+ "FROM com.kike.colegio.entities.AsignaturaEntity a "
			+ "WHERE (a.id LIKE CONCAT('%',:id,'%') or :id is null) "
			+ "AND a.nombre LIKE CONCAT ('%',:nombre,'%') "
			+ "AND (a.curso LIKE CONCAT ('%',:curso,'%' ) or :curso is null )"
			+ "AND (a.tasa LIKE CONCAT ('%',:tasa,'%') or :tasa is null )")
			  List<AsignaturaDTO>buscaAsignaturaPorIdNombreCursoTasa(
					  @Param("id") Integer id,
					  @Param("nombre") String nombre,
					  @Param("curso") Integer curso,
					  @Param("tasa") Double tasa);
	
}
