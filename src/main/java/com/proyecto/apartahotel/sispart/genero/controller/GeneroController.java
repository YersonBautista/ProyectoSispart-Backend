package com.proyecto.apartahotel.sispart.genero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.apartahotel.sispart.genero.entity.Genero;
import com.proyecto.apartahotel.sispart.genero.service.IGeneroService;

@RestController
@RequestMapping("/genero")
public class GeneroController {

	@Autowired
	private IGeneroService generoService;

	@GetMapping("/listarGenero")
	public ResponseEntity<List<Genero>> findAll() {
		List<Genero> findAll = generoService.findAll();
		return new ResponseEntity<List<Genero>>(findAll, HttpStatus.OK);
	}

}
