package com.proyecto.apartahotel.sispart.tipDocumento.controller;



import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.apartahotel.sispart.mensaje.Mensaje;
import com.proyecto.apartahotel.sispart.tipDocumento.dto.TipoDocumentoDto;
import com.proyecto.apartahotel.sispart.tipDocumento.entity.TipoDocumento;
import com.proyecto.apartahotel.sispart.tipDocumento.service.ITipoDocumentoService;




@RestController
@RequestMapping("/tipoDocumento")
public class TipoDocumentoController {

	@Autowired
	private ITipoDocumentoService tipoDocumentoService;

	@GetMapping("/listarTipoDocumentos")
	public ResponseEntity<List<TipoDocumento>> findAll() {
		List<TipoDocumento> findAll = tipoDocumentoService.findAll();
		return new ResponseEntity<List<TipoDocumento>>(findAll, HttpStatus.OK);
	}

	@GetMapping("/verTipoDocumento/{id}")
	public ResponseEntity<TipoDocumento> getById(@PathVariable("id") int id) {

		if (!tipoDocumentoService.existsById(id))

			return new ResponseEntity(new Mensaje("No existe ese tipo de documento"), HttpStatus.NOT_FOUND);
		TipoDocumento tipDocumento = tipoDocumentoService.getOne(id).get();

		return new ResponseEntity<TipoDocumento>(tipDocumento, HttpStatus.OK);
	}

	@PostMapping("/registrarTipoDocumento")
	public ResponseEntity<?> createNacionalidades(@RequestBody TipoDocumentoDto tipoDocumentoDto) {

		if (StringUtils.isBlank(tipoDocumentoDto.getTipDocumento()))
			return new ResponseEntity(new Mensaje("El campo tipo de documento es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (tipoDocumentoService.existsByTipDocumento(tipoDocumentoDto.getTipDocumento()))
			return new ResponseEntity(new Mensaje("El tipo documento que intenta ingresar ya se encuentra registrado."),
					HttpStatus.BAD_REQUEST);

		TipoDocumento tipoDocumento = new TipoDocumento(tipoDocumentoDto.getTipDocumento());
		tipoDocumentoService.save(tipoDocumento);
		return new ResponseEntity(new Mensaje("El tipo de documento  ha sido registrado"), HttpStatus.OK);

	}

	@PutMapping("/actualizarTipoDocumento/{id}")
	public ResponseEntity<?> updateNacionalidades(@PathVariable("id") int id,
			@RequestBody TipoDocumentoDto tipoDocumentoDto) {

		if (!tipoDocumentoService.existsById(id))
			return new ResponseEntity(new Mensaje("No existe el tipo de documento que desea actualizar"),
					HttpStatus.NOT_FOUND);

		if (tipoDocumentoService.existsByTipDocumento(tipoDocumentoDto.getTipDocumento()) && tipoDocumentoService
				.getByTipDocumento(tipoDocumentoDto.getTipDocumento()).get().getIdTipDocumento() != id)
			return new ResponseEntity(new Mensaje(
					"No es posible actualizar el tipo documento, ya que existe otro registro con el mismo tipo de docmuento"),
					HttpStatus.NOT_FOUND);

		if (StringUtils.isBlank(tipoDocumentoDto.getTipDocumento()))
			return new ResponseEntity(new Mensaje("El campo tipo de documento es obligatorio."),
					HttpStatus.BAD_REQUEST);

		TipoDocumento tipoDocumento = tipoDocumentoService.getOne(id).get();
		tipoDocumento.setTipDocumento(tipoDocumentoDto.getTipDocumento());
		tipoDocumentoService.save(tipoDocumento);

		return new ResponseEntity(new Mensaje("El tipo de documento ha sido actualizado"), HttpStatus.OK);

	}

	@DeleteMapping("/deleteTipoDocumento/{id}")
	public ResponseEntity<?> deleteHuespedes(@PathVariable("id") int id) {
		if (!tipoDocumentoService.existsById(id))

			return new ResponseEntity(new Mensaje("No existe el tipo documento que desea eliminar "),
					HttpStatus.NOT_FOUND);

		tipoDocumentoService.delete(id);
		return new ResponseEntity(new Mensaje(" el tipo documento ha sido eliminado "), HttpStatus.OK);
	}
}
