package com.proyecto.apartahotel.sispart.facturacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.apartahotel.sispart.facturacion.entity.TipoDocLegal;
import com.proyecto.apartahotel.sispart.facturacion.service.ITipoDocLegalesService;

@RestController
@RequestMapping("/tipoDocLegales")
public class TipoDocLegalesController {

	@Autowired
	private ITipoDocLegalesService tipoDocLegalesService;

	@GetMapping("/listarTipoDocLegales")
	public ResponseEntity<List<TipoDocLegal>> findAll() {
		List<TipoDocLegal> findAll = tipoDocLegalesService.findAll();
		return new ResponseEntity<List<TipoDocLegal>>(findAll, HttpStatus.OK);
	}

}
