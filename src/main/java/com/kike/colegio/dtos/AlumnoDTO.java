package com.kike.colegio.dtos;

public class AlumnoDTO {
	private int id;
	private String nombre;
	private String municipio;
	private Integer idMunicipio;
	private Integer famNumerosa;
	
	
	
	/**
	 * @param id
	 * @param nombre
	 * @param municipio
	 * @param idMunicipio
	 * @param famNumerosa
	 */
	public AlumnoDTO(int id, String nombre, String municipio, Integer idMunicipio, Integer famNumerosa) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.municipio = municipio;
		this.idMunicipio = idMunicipio;
		this.famNumerosa = famNumerosa;
	}
	/**
	 * @param id
	 * @param nombre
	 * @param municipio
	 * @param idMunicipio
	 */
	public AlumnoDTO(int id, String nombre, String municipio, Integer idMunicipio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.municipio = municipio;
		this.idMunicipio = idMunicipio;
	}
	/**
	 * @param id
	 * @param nombre
	 * @param municipio
	 */
	public AlumnoDTO(int id, String nombre, String municipio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.municipio = municipio;
	}
	/**
	 * @param id
	 * @param nombre
	 */
	public AlumnoDTO(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
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
	 * @return the municipio
	 */
	public String getMunicipio() {
		return municipio;
	}
	/**
	 * @param municipio the municipio to set
	 */
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	/**
	 * @return the idMunicipio
	 */
	public Integer getIdMunicipio() {
		return idMunicipio;
	}
	/**
	 * @param idMunicipio the idMunicipio to set
	 */
	public void setIdMunicipio(Integer idMunicipio) {
		this.idMunicipio = idMunicipio;
	}
	/**
	 * @return the famNumerosa
	 */
	public Integer getFamNumerosa() {
		return famNumerosa;
	}
	/**
	 * @param famNumerosa the famNumerosa to set
	 */
	public void setFamNumerosa(Integer famNumerosa) {
		this.famNumerosa = famNumerosa;
	}
	
	

}
