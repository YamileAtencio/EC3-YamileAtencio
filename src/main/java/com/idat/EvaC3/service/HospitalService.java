package com.idat.EvaC3.service;

import java.util.List;

import com.idat.EvaC3.model.Hospital;


public interface HospitalService {
	
	void guardar(Hospital hospital);
	void actualizar(Hospital hospital);
	void eliminar(Integer id);
	List<Hospital> listar();
	Hospital obtener(Integer id);

}
