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
@Table(name = "caja")
public class CajaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idmatricula")
	private MatriculacionEntity matricula;
	
	private Double importe;

	/**
	 * 
	 */
	public CajaEntity() {
		super();
	}

	/**
	 * @param id
	 * @param matricula
	 * @param importe
	 */
	public CajaEntity(Integer id, MatriculacionEntity matricula, Double importe) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.importe = importe;
	}
	
	

	/**
	 * @param matricula
	 * @param importe
	 */
	public CajaEntity(MatriculacionEntity matricula, Double importe) {
		super();
		this.matricula = matricula;
		this.importe = importe;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the matricula
	 */
	public MatriculacionEntity getMatricula() {
		return matricula;
	}

	/**
	 * @param matricula the matricula to set
	 */
	public void setMatricula(MatriculacionEntity matricula) {
		this.matricula = matricula;
	}

	/**
	 * @return the importe
	 */
	public Double getImporte() {
		return importe;
	}

	/**
	 * @param importe the importe to set
	 */
	public void setImporte(Double importe) {
		this.importe = importe;
	}
	
	
}
