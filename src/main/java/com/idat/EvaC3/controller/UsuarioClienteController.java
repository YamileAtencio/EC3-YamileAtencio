package com.idat.EvaC3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.EvaC3.model.UsuarioCliente;
import com.idat.EvaC3.service.UsuarioService;

@RestController
@RequestMapping("/usuario/v1")
public class UsuarioClienteController {
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioCliente>> listar(){//INTERACTUA CON HTTP
		return new ResponseEntity<List<UsuarioCliente>>(service.listar(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody UsuarioCliente usuariocliente){
		service.guardar(usuariocliente);
		return new ResponseEntity<Void>(HttpStatus.CREATED);		
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioCliente> obtenerPorId(@PathVariable Integer id){
		
		UsuarioCliente usuariocliente = service.obtener(id);//VALIDO QUE EXISTA
		if(usuariocliente != null) {
			return new ResponseEntity<UsuarioCliente>(usuariocliente, HttpStatus.OK);
		}else {
			return new ResponseEntity<UsuarioCliente>(usuariocliente, HttpStatus.NOT_FOUND);
		}			
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody UsuarioCliente usuariocliente){
		
		UsuarioCliente h = service.obtener(usuariocliente.getIdUsuario());//VALIDO QUE EXISTA
		if(h != null) {
			service.actualizar(usuariocliente);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		UsuarioCliente usuariocliente = service.obtener(id);//VALIDO QUE EXISTA
		if(usuariocliente != null) {
			service.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}


}
