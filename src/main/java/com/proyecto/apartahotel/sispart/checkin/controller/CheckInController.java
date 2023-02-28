package com.proyecto.apartahotel.sispart.checkin.controller;

import java.util.List;
import java.util.Optional;

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

import com.proyecto.apartahotel.sispart.checkin.dto.CheckInDto;
import com.proyecto.apartahotel.sispart.checkin.entity.CheckIn;
import com.proyecto.apartahotel.sispart.checkin.service.ICheckInService;
import com.proyecto.apartahotel.sispart.huespedes.entity.Huesped;
import com.proyecto.apartahotel.sispart.mensaje.Mensaje;

@RestController
@RequestMapping("/checkIn")
public class CheckInController {

	@Autowired
	private ICheckInService checkInService;

	@GetMapping("/listarCheckIn")
	public ResponseEntity<List<CheckIn>> findAll() {

		List<CheckIn> findAll = checkInService.findAll();
		return new ResponseEntity<List<CheckIn>>(findAll, HttpStatus.OK);
	}

	@GetMapping("/checkInByHuesped/{idHuesped}")
	public ResponseEntity<List<CheckIn>> getByIdHuesped(@PathVariable("idHuesped") int idHuesped) {

		List<CheckIn> checkIn = checkInService.findByIdHuesped(idHuesped);
		return new ResponseEntity<List<CheckIn>>(checkIn, HttpStatus.OK);
	}

	@GetMapping("/verCheckIn/{id}")
	public ResponseEntity<CheckIn> getById(@PathVariable("id") int id) {

		if (!checkInService.existsById(id))

			return new ResponseEntity(new Mensaje("No existe el check-in"), HttpStatus.NOT_FOUND);
		CheckIn checkIn = checkInService.getOne(id).get();

		return new ResponseEntity<CheckIn>(checkIn, HttpStatus.OK);
	}

	@PostMapping("/crearCheckIn")
	public ResponseEntity<?> createCheckIn(@RequestBody CheckInDto checkInDto) {

		if (checkInDto.getIdHuesped().getNumDocumento() == null)
			return new ResponseEntity(new Mensaje("El numero de documento del huesped es obligatorio"),
					HttpStatus.BAD_REQUEST);

		if (checkInDto.getnumAcompanantes() == null)
			return new ResponseEntity(
					new Mensaje("El numero de acompañantes es obligatorio, de no tener acompañantes por favor poner 0"),
					HttpStatus.BAD_REQUEST);

		if (checkInDto.getDias_aprox_estadia() == null)
			return new ResponseEntity(
					new Mensaje("Por favor ingresar el numero de dias aproximado de la estadia del huesped"),
					HttpStatus.BAD_REQUEST);

		if (checkInDto.getFecha_ingreso() == null)
			return new ResponseEntity(new Mensaje("Por favor ingresar la fecha en la que ingreso el huesped"),
					HttpStatus.BAD_REQUEST);

		if (checkInDto.getHora_ingreso() == null)
			return new ResponseEntity(
					new Mensaje("Por favor ingresar la fecha en la hora en la que ingreso el huesped "),
					HttpStatus.BAD_REQUEST);

		CheckIn checkIn = new CheckIn(checkInDto.getIdHuesped(), checkInDto.getIdHabitacion(),
				checkInDto.getnumAcompanantes(), checkInDto.getDias_aprox_estadia(), checkInDto.getFecha_ingreso(),
				checkInDto.getHora_ingreso());
		checkInService.save(checkIn);

		return new ResponseEntity(new Mensaje("El huesped ya puede ingresar"), HttpStatus.OK);
	}

	@PutMapping("/modificarCheckIn/{id}")
	public ResponseEntity<?> updateCheckIn(@PathVariable("id") int id, @RequestBody CheckInDto checkInDto) {

		if (!checkInService.existsById(id))

			return new ResponseEntity(new Mensaje("No existe el check-In que desea modificar"), HttpStatus.NOT_FOUND);

		if (checkInDto.getIdHuesped().getNumDocumento() == null)
			return new ResponseEntity(new Mensaje("El numero de documento del huesped es obligatorio"),
					HttpStatus.BAD_REQUEST);

		if (checkInDto.getIdHabitacion().getNumHabitacion() == null)
			return new ResponseEntity(new Mensaje("El numero de habitacion es obligatorio"), HttpStatus.BAD_REQUEST);

		if (checkInDto.getnumAcompanantes() == null)
			return new ResponseEntity(
					new Mensaje("El numero de acompañantes es obligatorio, de no tener acompañantes por favor poner 0"),
					HttpStatus.BAD_REQUEST);

		if (checkInDto.getDias_aprox_estadia() == null)
			return new ResponseEntity(
					new Mensaje("Por favor ingresar el numero de dias aproximado de la estadia del huesped"),
					HttpStatus.BAD_REQUEST);

		if (checkInDto.getFecha_ingreso() == null)
			return new ResponseEntity(new Mensaje("Por favor ingresar la fecha en la que ingreso el huesped"),
					HttpStatus.BAD_REQUEST);

		if (checkInDto.getHora_ingreso() == null)
			return new ResponseEntity(
					new Mensaje("Por favor ingresar la fecha en la hora en la que ingreso el huesped "),
					HttpStatus.BAD_REQUEST);

		CheckIn checkIn = checkInService.getOne(id).get();
		checkIn.setIdHabitacion(checkInDto.getIdHabitacion());
		checkIn.setnumAcompanantes(checkInDto.getnumAcompanantes());
		checkIn.setDias_aprox_estadia(checkInDto.getDias_aprox_estadia());
		checkIn.setFecha_ingreso(checkInDto.getFecha_ingreso());
		checkIn.setHora_ingreso(checkInDto.getHora_ingreso());
		checkInService.save(checkIn);

		return new ResponseEntity(new Mensaje("El huesped ya puede ingresar"), HttpStatus.OK);
	}

	@DeleteMapping("/deleteCheckIn/{codigoCheckIn}")
	public ResponseEntity<?> deleteCheckIn(@PathVariable("codigoCheckIn") int codigoCheckIn) {
		if (!checkInService.existsById(codigoCheckIn))

			return new ResponseEntity(new Mensaje("No se puede eliminar el check-In ya que no se encuentra "),
					HttpStatus.NOT_FOUND);

		checkInService.delete(codigoCheckIn);
		return new ResponseEntity(new Mensaje(" El check-in ha sido eliminado"), HttpStatus.OK);
	}

}
