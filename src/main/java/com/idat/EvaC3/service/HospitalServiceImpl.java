package com.idat.EvaC3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EvaC3.model.Hospital;
import com.idat.EvaC3.repository.HospitalRepository;

@Service
public class HospitalServiceImpl implements HospitalService {
	
	@Autowired
	private HospitalRepository repositorio;

	@Override
	public void guardar(Hospital hospital) {
		repositorio.save(hospital);

	}

	@Override
	public void actualizar(Hospital hospital) {
		repositorio.saveAndFlush(hospital);

	}

	@Override
	public void eliminar(Integer id) {
		repositorio.deleteById(id);

	}

	@Override
	public List<Hospital> listar() {
		return repositorio.findAll();
	}

	@Override
	public Hospital obtener(Integer id) {
		return repositorio.findById(id).orElse(null);
	}

}
