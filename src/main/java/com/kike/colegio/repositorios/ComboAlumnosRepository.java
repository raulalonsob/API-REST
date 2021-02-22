package com.kike.colegio.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.kike.colegio.entities.AlumnoEntity;

public interface ComboAlumnosRepository extends CrudRepository<AlumnoEntity, Integer> {

}
