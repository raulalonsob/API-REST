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
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;



@Entity
@Table(name="notas")
public class NotaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_alumnos") // Como se llama en la tabla notas
	private AlumnoEntity alumnos;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_asignaturas") // Como se llama en la tabla notas
	private AsignaturaEntity asignaturas;
	
	
	@Column(name = "nota")
	private Double nota;
	
	@Column(name = "fecha")
	private String fecha;

	public NotaEntity() {
		super();
	}

	public NotaEntity(Integer id, AlumnoEntity alumnos, AsignaturaEntity asignaturas, Double nota, String fecha) {
		super();
		this.id = id;
		this.alumnos = alumnos;
		this.asignaturas = asignaturas;
		this.nota = nota;
		this.fecha = fecha;
	}
	
	

	public NotaEntity(AlumnoEntity alumnos, AsignaturaEntity asignaturas, Double nota, String fecha) {
		super();
		this.alumnos = alumnos;
		this.asignaturas = asignaturas;
		this.nota = nota;
		this.fecha = fecha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AlumnoEntity getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(AlumnoEntity alumnos) {
		this.alumnos = alumnos;
	}

	public AsignaturaEntity getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(AsignaturaEntity asignaturas) {
		this.asignaturas = asignaturas;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	

}
