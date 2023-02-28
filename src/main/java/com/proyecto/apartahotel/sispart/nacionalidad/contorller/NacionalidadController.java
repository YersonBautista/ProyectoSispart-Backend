package com.proyecto.apartahotel.sispart.nacionalidad.contorller;

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
import com.proyecto.apartahotel.sispart.nacionalidad.dto.NacionalidadDto;
import com.proyecto.apartahotel.sispart.nacionalidad.entity.Nacionalidad;
import com.proyecto.apartahotel.sispart.nacionalidad.service.INacionalidadService;


@RestController
@RequestMapping("/nacionalidad")
public class NacionalidadController {

	@Autowired
	private INacionalidadService nacionalidadService;

	@GetMapping("/listarNacionalidades")
	public ResponseEntity<List<Nacionalidad>> findAll() {
		List<Nacionalidad> findAll = nacionalidadService.findAll();
		return new ResponseEntity<List<Nacionalidad>>(findAll, HttpStatus.OK);
	}

	@GetMapping("/verNacionalidad/{id}")
	public ResponseEntity<Nacionalidad> getById(@PathVariable("id") int id) {

		if (!nacionalidadService.existsById(id))

			return new ResponseEntity(new Mensaje("No existe la nacionalidad"), HttpStatus.NOT_FOUND);
		Nacionalidad nacionalidad = nacionalidadService.getOne(id).get();

		return new ResponseEntity<Nacionalidad>(nacionalidad, HttpStatus.OK);
	}

	@PostMapping("/registrarNacionalidad")
	public ResponseEntity<?> createNacionalidades(@RequestBody NacionalidadDto nacionalidadDto) {

		if (StringUtils.isBlank(nacionalidadDto.getNombre()))
			return new ResponseEntity(new Mensaje("El campo nombre es obligatorio."), HttpStatus.BAD_REQUEST);

		if (nacionalidadService.existsByNombre(nacionalidadDto.getNombre()))
			return new ResponseEntity(new Mensaje("La nacionalidad que intenta ingresar ya se encuentra registrada."),
					HttpStatus.BAD_REQUEST);

		Nacionalidad nacionalidad = new Nacionalidad(nacionalidadDto.getNombre());
		nacionalidadService.save(nacionalidad);
		return new ResponseEntity(new Mensaje("La nacionalidad ha sido registrada"), HttpStatus.OK);

	}

	@PutMapping("/actualizarNacionalidad/{id}")
	public ResponseEntity<?> updateNacionalidades(@PathVariable("id") int id,
			@RequestBody NacionalidadDto nacionalidadDto) {

		if (!nacionalidadService.existsById(id))
			return new ResponseEntity(new Mensaje("No existe la nacionalidad que desea actualizar"),
					HttpStatus.NOT_FOUND);

		if (nacionalidadService.existsByNombre(nacionalidadDto.getNombre())
				&& nacionalidadService.getByNombre(nacionalidadDto.getNombre()).get().getId() != id)
			return new ResponseEntity(new Mensaje(
					"No es posible actualizar la nacionalidad con ese nombre, ya que existe otro registro con el mismo nombre"),
					HttpStatus.NOT_FOUND);

		if (StringUtils.isBlank(nacionalidadDto.getNombre()))
			return new ResponseEntity(new Mensaje("El campo nombre es obligatorio."), HttpStatus.BAD_REQUEST);

		Nacionalidad nacionalidad = nacionalidadService.getOne(id).get();
		nacionalidad.setNombre(nacionalidadDto.getNombre());
		nacionalidadService.save(nacionalidad);

		return new ResponseEntity(new Mensaje("La nacionalidad ha sido actualizada"), HttpStatus.OK);

	}

	@DeleteMapping("/deleteNacionalidad/{id}")
	public ResponseEntity<?> deleteNacionalidad(@PathVariable("id") int id) {
		if (!nacionalidadService.existsById(id))

			return new ResponseEntity(new Mensaje("No existe la nacionalidad que desea eliminar "),
					HttpStatus.NOT_FOUND);

		nacionalidadService.delete(id);
		return new ResponseEntity(new Mensaje(" La nacionalidad ha sido eliminada "), HttpStatus.OK);
	}

}
