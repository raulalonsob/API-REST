package com.kike.colegio.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "asignaturas")
public class AsignaturaEntity {
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "curso")
	private Integer curso;
	
	@Column(name = "tasa")
	private Double tasa;
	
	

	public AsignaturaEntity() {
		super();
	}

	


	public AsignaturaEntity(Integer id) {
		super();
		this.id = id;
	}




	public AsignaturaEntity(Integer id, String nombre, Integer curso, Double tasa) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.curso = curso;
		this.tasa = tasa;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Integer getCurso() {
		return curso;
	}



	public void setCurso(Integer curso) {
		this.curso = curso;
	}



	public Double getTasa() {
		return tasa;
	}



	public void setTasa(Double tasa) {
		this.tasa = tasa;
	}
	
	
	
}
