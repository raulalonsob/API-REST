package com.kike.colegio.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "matriculaciones")
public class MatriculacionEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_asignatura")
	private AsignaturaEntity asignaturas;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_alumno")
	private AlumnoEntity alumnos;
	
	@Column(name = "fecha")
	private String fecha;
	
	@Column(name = "activo")
	private Integer activo;

	public MatriculacionEntity() {
		super();
	}

	public MatriculacionEntity(Integer id, AsignaturaEntity asignaturas, AlumnoEntity alumnos, String fecha,
			Integer activo) {
		super();
		this.id = id;
		this.asignaturas = asignaturas;
		this.alumnos = alumnos;
		this.fecha = fecha;
		this.activo = activo;
	}

	public MatriculacionEntity(AsignaturaEntity asignaturas, AlumnoEntity alumnos, String fecha, Integer activo) {
		super();
		this.asignaturas = asignaturas;
		this.alumnos = alumnos;
		this.fecha = fecha;
		this.activo = activo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AsignaturaEntity getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(AsignaturaEntity asignaturas) {
		this.asignaturas = asignaturas;
	}

	public AlumnoEntity getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(AlumnoEntity alumnos) {
		this.alumnos = alumnos;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}
	
	
}	
