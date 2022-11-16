package com.idat.EvaC3.service;

import java.util.List;

import com.idat.EvaC3.model.Cliente;

public interface ClienteService {
	void guardar(Cliente cliente);
	void actualizar(Cliente cliente);
	void eliminar(Integer id);
	List<Cliente> listar();
	Cliente obtener(Integer id);

}
