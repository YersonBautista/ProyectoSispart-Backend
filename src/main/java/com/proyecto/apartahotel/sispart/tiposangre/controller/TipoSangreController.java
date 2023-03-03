package com.proyecto.apartahotel.sispart.tiposangre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.apartahotel.sispart.tiposangre.entity.TipoSangre;
import com.proyecto.apartahotel.sispart.tiposangre.service.ITipoSangreService;

@RestController
@RequestMapping("/tipoSangre")
public class TipoSangreController {

	@Autowired
	private ITipoSangreService tipoSangreService;

	@GetMapping("/listarTipoSangre")
	public ResponseEntity<List<TipoSangre>> findAll() {
		List<TipoSangre> findAll = tipoSangreService.findAll();
		return new ResponseEntity<List<TipoSangre>>(findAll, HttpStatus.OK);
	}
}
