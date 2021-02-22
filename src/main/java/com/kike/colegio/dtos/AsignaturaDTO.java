package com.kike.colegio.dtos;

public class AsignaturaDTO {
	private Integer id;
	private String nombre;
	private Integer curso;
	private Double tasa;
	
	/**
	 * 
	 */
	public AsignaturaDTO() {
		super();
	}
	
	
	
	/**
	 * @param id
	 * @param nombre
	 */
	public AsignaturaDTO(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}



	/**
	 * @param id
	 * @param nombre
	 * @param curso
	 */
	public AsignaturaDTO(Integer id, String nombre, Integer curso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.curso = curso;
	}
	
	

	/**
	 * @param id
	 * @param nombre
	 * @param curso
	 * @param tasa
	 */
	public AsignaturaDTO(Integer id, String nombre, Integer curso, Double tasa) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.curso = curso;
		this.tasa = tasa;
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the curso
	 */
	public Integer getCurso() {
		return curso;
	}

	/**
	 * @param curso the curso to set
	 */
	public void setCurso(Integer curso) {
		this.curso = curso;
	}



	/**
	 * @return the tasa
	 */
	public Double getTasa() {
		return tasa;
	}



	/**
	 * @param tasa the tasa to set
	 */
	public void setTasa(Double tasa) {
		this.tasa = tasa;
	}
	
	
	
}
