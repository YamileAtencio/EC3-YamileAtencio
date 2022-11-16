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

import com.idat.EvaC3.model.Hospital;
import com.idat.EvaC3.service.HospitalService;


@RestController
@RequestMapping("/hospital/v1")
public class HospitalController {
	
	@Autowired
	private HospitalService service;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Hospital>> listar(){//INTERACTUA CON HTTP
		return new ResponseEntity<List<Hospital>>(service.listar(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Hospital hospital){
		service.guardar(hospital);
		return new ResponseEntity<Void>(HttpStatus.CREATED);		
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Hospital> obtenerPorId(@PathVariable Integer id){
		
		Hospital hospital = service.obtener(id);//VALIDO QUE EXISTA
		if(hospital != null) {
			return new ResponseEntity<Hospital>(hospital, HttpStatus.OK);
		}else {
			return new ResponseEntity<Hospital>(hospital, HttpStatus.NOT_FOUND);
		}			
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Hospital hospital){
		
		Hospital h = service.obtener(hospital.getIdHospital());//VALIDO QUE EXISTA
		if(h != null) {
			service.actualizar(hospital);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		Hospital hospital = service.obtener(id);//VALIDO QUE EXISTA
		if(hospital != null) {
			service.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}

}
