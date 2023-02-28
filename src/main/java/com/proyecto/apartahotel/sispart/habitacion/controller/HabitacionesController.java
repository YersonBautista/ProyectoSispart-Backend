package com.proyecto.apartahotel.sispart.habitacion.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.apartahotel.sispart.habitacion.dto.HabitacionesDto;
import com.proyecto.apartahotel.sispart.habitacion.entity.Habitaciones;
import com.proyecto.apartahotel.sispart.habitacion.service.IHabitacionService;
import com.proyecto.apartahotel.sispart.mensaje.Mensaje;

@RestController
@RequestMapping("/habitaciones")
public class HabitacionesController {

	@Autowired
	private IHabitacionService habitacionesService;

	@GetMapping("/listarHabitaciones")
	public ResponseEntity<List<Habitaciones>> findAll() {
		List<Habitaciones> findAll = habitacionesService.findAll();
		return new ResponseEntity<List<Habitaciones>>(findAll, HttpStatus.OK);
	}

	@GetMapping("/verHabitaciones/{id}")
	public ResponseEntity<Habitaciones> getById(@PathVariable("id") int id) {

		if (!habitacionesService.existsById(id))

			return new ResponseEntity(new Mensaje("No existe la habitacion "), HttpStatus.NOT_FOUND);

		Habitaciones habitaciones = habitacionesService.getOne(id).get();
		return new ResponseEntity<Habitaciones>(habitaciones, HttpStatus.OK);
	}

	@GetMapping("/detalleHabitaciones/{numHabitacion}")
	public ResponseEntity<Habitaciones> getByNumHabitacion(@PathVariable("numHabitacion") int numHabitacion) {

		if (!habitacionesService.existsByNumHabitacion(numHabitacion))

			return new ResponseEntity(
					new Mensaje("No existe la habitacion o el numero de habitacion no se encuentra registrado "),
					HttpStatus.NOT_FOUND);

		Habitaciones habitacion = habitacionesService.getByNumHabitacion(numHabitacion).get();
		return new ResponseEntity<Habitaciones>(habitacion, HttpStatus.OK);
	}

	public ResponseEntity<?> createHabitaciones(@RequestBody HabitacionesDto habitacionesDto) {

		if (StringUtils.isBlank(habitacionesDto.getNombreHabitacion()))
			return new ResponseEntity(new Mensaje("El  nombre de la habitacion es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(habitacionesDto.getDescripHabitacion()))
			return new ResponseEntity(new Mensaje("La descripcion de la  habitacion es obligatoria."),
					HttpStatus.BAD_REQUEST);

		if (habitacionesDto.getMaxPersonasDisponibles() == null)
			return new ResponseEntity(new Mensaje("El campo numero de habitacion es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (habitacionesDto.getNumHabitacion() == null)
			return new ResponseEntity(new Mensaje("El campo numero de habitacion es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (habitacionesDto.getPisoHabitacion() == null)
			return new ResponseEntity(new Mensaje("El piso donde se encuentra ubicada la habitacion es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (habitacionesDto.getPrecioHabitacion() == null)
			return new ResponseEntity(new Mensaje("El precio de  la habitacion es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (habitacionesService.existsByNumHabitacion(habitacionesDto.getNumHabitacion()))
			return new ResponseEntity(new Mensaje(
					"El numero de habitacion " + habitacionesDto.getNumHabitacion() + " ya se encuentra registrado. "),
					HttpStatus.BAD_REQUEST);

		Habitaciones habitacion = new Habitaciones(habitacionesDto.getImagenHabitacion(),
				habitacionesDto.getNombreHabitacion(), habitacionesDto.getDescripHabitacion(),
				habitacionesDto.getMaxPersonasDisponibles(), habitacionesDto.getNumHabitacion(),
				habitacionesDto.getPisoHabitacion(), habitacionesDto.getPrecioHabitacion(),
				habitacionesDto.getEstadoHabitacion());
		habitacionesService.save(habitacion);
		return new ResponseEntity(new Mensaje("El habitacion ha sido creada exitosamente"), HttpStatus.OK);

	}

	@PutMapping("/actualizarHabitacion/{numHabitacion}")
	public ResponseEntity<?> updateHabitaciones(@PathVariable("numHabitacion") int numHabitacion,
			@RequestBody HabitacionesDto habitacionesDto) {

		if (!habitacionesService.existsByNumHabitacion(numHabitacion))

			return new ResponseEntity(new Mensaje("No existe el numero de habitacion " + numHabitacion),
					HttpStatus.NOT_FOUND);

		if (habitacionesService.existsByNumHabitacion(habitacionesDto.getNumHabitacion()) && habitacionesService
				.getByNumHabitacion(habitacionesDto.getNumHabitacion()).get().getNumHabitacion() != numHabitacion)
			return new ResponseEntity(new Mensaje(
					"No es posible actualizar la habiatacion , existe otra habitacion creada con el mismo numero de habitacion"),
					HttpStatus.NOT_FOUND);

		if (StringUtils.isBlank(habitacionesDto.getNombreHabitacion()))
			return new ResponseEntity(new Mensaje("El  nombre de la habitacion es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(habitacionesDto.getDescripHabitacion()))
			return new ResponseEntity(new Mensaje("La descripcion de la  habitacion es obligatoria."),
					HttpStatus.BAD_REQUEST);

		if (habitacionesDto.getMaxPersonasDisponibles() == null)
			return new ResponseEntity(new Mensaje("El  numero maximo de personas en la  habitacion es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (habitacionesDto.getNumHabitacion() == null)
			return new ResponseEntity(new Mensaje("El campo numero de habitacion es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (habitacionesDto.getPisoHabitacion() == null)
			return new ResponseEntity(new Mensaje("El piso donde se encuentra ubicada la habitacion es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (habitacionesDto.getPrecioHabitacion() == null)
			return new ResponseEntity(new Mensaje("El precio de  la habitacion es obligatorio."),
					HttpStatus.BAD_REQUEST);

		Habitaciones habitacion = habitacionesService.getByNumHabitacion(numHabitacion).get();
		habitacion.setImagenHabitacion(habitacionesDto.getImagenHabitacion());
		habitacion.setNombreHabitacion(habitacionesDto.getNombreHabitacion());
		habitacion.setDescripHabitacion(habitacionesDto.getDescripHabitacion());
		habitacion.setMaxPersonasDisponibles(habitacionesDto.getMaxPersonasDisponibles());
		habitacion.setNumHabitacion(habitacionesDto.getNumHabitacion());
		habitacion.setPisoHabitacion(habitacionesDto.getPisoHabitacion());
		habitacion.setPrecioHabitacion(habitacionesDto.getPrecioHabitacion());
		habitacionesDto.setEstadoHabitacion(habitacionesDto.getEstadoHabitacion());

		habitacionesService.save(habitacion);
		return new ResponseEntity(new Mensaje("La habitacion ha sido actualizada"), HttpStatus.OK);

	}

	@DeleteMapping("/deleteHabitacion/{numHabitacion}")
	public ResponseEntity<?> deleteHabitacion(@PathVariable("numHabitacion") int numHabitacion) {
		if (!habitacionesService.existsByNumHabitacion(numHabitacion))

			return new ResponseEntity(
					new Mensaje(" ELIMINACION FALLIDA. No existe la habitacion con el numero " + numHabitacion),
					HttpStatus.NOT_FOUND);

		habitacionesService.delete(numHabitacion);
		return new ResponseEntity(new Mensaje(" El registro de la habitacion  ha sido eliminado"), HttpStatus.OK);
	}

}
