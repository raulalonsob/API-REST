package com.kike.colegio.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kike.colegio.dao.ComboDAO;
import com.kike.colegio.dtos.ComboDTO;
import com.kike.colegio.entities.AlumnoEntity;
import com.kike.colegio.entities.AsignaturaEntity;
import com.kike.colegio.entities.MunicipioEntity;
import com.kike.colegio.repositorios.ComboAlumnosRepository;
import com.kike.colegio.repositorios.ComboAsignaturaRepository;
import com.kike.colegio.repositorios.MunicipioRepository;

@Service
public class ComboDAOImpl implements ComboDAO {
	
	@Autowired
	private MunicipioRepository municipioRepository;
	
	@Autowired
	private ComboAlumnosRepository comboAlumnosRepository;
	
	@Autowired
	private ComboAsignaturaRepository comboAsignaturasRepository;

	@Override
	public List<ComboDTO> comboMunicipios() {
		Iterable<MunicipioEntity> listaEntidadesMunicipios = municipioRepository.findAll();
		List<ComboDTO> listaMunicipios = mapeoEntidadMunicipioComboDTO(listaEntidadesMunicipios);
		return listaMunicipios;
	}

	@Override
	public List<ComboDTO> comboAlumnos() {
		Iterable<AlumnoEntity> listaEntidadesAlumnos = comboAlumnosRepository.findAll();
		List<ComboDTO> listaAlumnos = mapeoEntidadAlumnoComboDTO(listaEntidadesAlumnos);
		return listaAlumnos;
	}

	@Override
	public List<ComboDTO> comboAsignaturas() {
		Iterable<AsignaturaEntity> listaEntidadesAginaturas = comboAsignaturasRepository.findAll();
		List<ComboDTO> listaAsignaturas= mapeoEntidadAsignaturaComboDTO(listaEntidadesAginaturas);
		return listaAsignaturas;
	}

	//Métodos para recoger solo los campos que nos interesan de cada entidad
	private List<ComboDTO> mapeoEntidadMunicipioComboDTO(Iterable<MunicipioEntity> lista){
		List<ComboDTO> listaMunicipios = new ArrayList<ComboDTO>();
		
		for (MunicipioEntity m : lista) {
			listaMunicipios.add(new ComboDTO(m.getIdMunicipio(), m.getNombre()));
		}
		
		return listaMunicipios;
	}
	
	private List<ComboDTO> mapeoEntidadAlumnoComboDTO(Iterable<AlumnoEntity> lista){
		List<ComboDTO> listaALumnos = new ArrayList<ComboDTO>();
		
		for (AlumnoEntity m : lista) {
			listaALumnos.add(new ComboDTO(m.getId(), m.getNombre()));
		}
		
		return listaALumnos;
	}
	
	private List<ComboDTO> mapeoEntidadAsignaturaComboDTO(Iterable<AsignaturaEntity> lista){
		List<ComboDTO> listaAsignaturas = new ArrayList<ComboDTO>();
		
		for (AsignaturaEntity m : lista) {
			listaAsignaturas.add(new ComboDTO(m.getId(), m.getNombre()));
		}
		
		return listaAsignaturas;
	}
}
