package com.idat.EvaC3.service;

import java.util.List;

import com.idat.EvaC3.model.UsuarioCliente;

public interface UsuarioService {
	
	void guardar(UsuarioCliente usuariocliente);
	void actualizar(UsuarioCliente usuariocliente);
	void eliminar(Integer id);
	List<UsuarioCliente> listar();
	UsuarioCliente obtener(Integer id);

}
