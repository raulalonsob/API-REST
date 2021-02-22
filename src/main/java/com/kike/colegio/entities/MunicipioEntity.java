package com.kike.colegio.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "municipios")
public class MunicipioEntity {
	
	@Id
	@Column(name = "id_municipio")
	private int idMunicipio;
	
	@Column(name = "id_provincia")
	private int idProvincia;
	
	@Column(name = "nombre")
	private String nombre;
	
	

	public MunicipioEntity() {
		super();
	}



	public MunicipioEntity(int idMunicipio, int idProvincia, String nombre) {
		super();
		this.idMunicipio = idMunicipio;
		this.idProvincia = idProvincia;
		this.nombre = nombre;
	}



	public int getIdMunicipio() {
		return idMunicipio;
	}



	public void setIdMunicipio(int idMunicipio) {
		this.idMunicipio = idMunicipio;
	}



	public int getIdProvincia() {
		return idProvincia;
	}



	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
}
