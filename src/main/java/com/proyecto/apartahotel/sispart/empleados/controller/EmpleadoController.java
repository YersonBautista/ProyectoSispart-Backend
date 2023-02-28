package com.proyecto.apartahotel.sispart.empleados.controller;

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

import com.proyecto.apartahotel.sispart.empleados.dto.EmpleadoDto;
import com.proyecto.apartahotel.sispart.empleados.entity.Empleado;
import com.proyecto.apartahotel.sispart.empleados.service.IEmpleadoService;
import com.proyecto.apartahotel.sispart.mensaje.Mensaje;
import com.proyecto.apartahotel.sispart.tipDocumento.entity.TipoDocumento;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

	@Autowired
	private IEmpleadoService empleadoService;

	@GetMapping("/listarEmpleados")
	public ResponseEntity<List<Empleado>> findAll() {
		List<Empleado> findAll = empleadoService.findAll();
		return new ResponseEntity<List<Empleado>>(findAll, HttpStatus.OK);
	}

	@GetMapping("/verEmpleado/{id}")
	public ResponseEntity<Empleado> getById(@PathVariable("id") int id) {

		if (!empleadoService.existsById(id))
			return new ResponseEntity(new Mensaje("No existe el empleado con ese id "), HttpStatus.NOT_FOUND);

		Empleado empleado = empleadoService.getOne(id).get();
		return new ResponseEntity<Empleado>(empleado, HttpStatus.OK);

	}

	@GetMapping("/detalleEmpleado/{idTipoDocumento}/{numDocumento}")
	public ResponseEntity<Empleado> getByTipoDocumentoAndNumDocumento(
			@PathVariable("idTipoDocumento") TipoDocumento idTipoDocumento,
			@PathVariable("numDocumento") int numDocumento) {

		if (!empleadoService.existsByIdTipoDocumentoAndNumDocumento(idTipoDocumento, numDocumento))
			return new ResponseEntity(new Mensaje("No existe el empleado con el documento "
					+ idTipoDocumento.getTipDocumento() + ": " + numDocumento), HttpStatus.NOT_FOUND);

		Empleado empleado = empleadoService.getByIdTipoDocumentoAndNumDocumento(idTipoDocumento, numDocumento).get();
		return new ResponseEntity<Empleado>(empleado, HttpStatus.OK);

	}

	@PostMapping("/registrarEmpleado")
	public ResponseEntity<?> createEmpleado(@RequestBody EmpleadoDto empleadoDto) {

		if (StringUtils.isBlank(empleadoDto.getNombre()))
			return new ResponseEntity(new Mensaje("El campo nombre es obligatorio."), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(empleadoDto.getApellido()))
			return new ResponseEntity(new Mensaje("El campo apellido es obligatorio."), HttpStatus.BAD_REQUEST);

		if (empleadoDto.getIdTipoDocumento() == null)
			return new ResponseEntity(new Mensaje("El campo tipo de documento es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (empleadoDto.getNumDocumento() == null)
			return new ResponseEntity(new Mensaje("El campo numero de documento es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (empleadoDto.getNumTelefono() == null)
			return new ResponseEntity(new Mensaje("El campo numero de telefono es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(empleadoDto.getCorreo()))
			return new ResponseEntity(new Mensaje("El campo correo es obligatorio."), HttpStatus.BAD_REQUEST);

		if (empleadoDto.getFechaNacimiento() == null)
			return new ResponseEntity(new Mensaje("El campo fecha nacimiento es obligatorio."), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(empleadoDto.getDireccion()))
			return new ResponseEntity(new Mensaje("El campo direccion es obligatorio."), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(empleadoDto.getNomContactoEmergencia()))
			return new ResponseEntity(new Mensaje("El campo nombre contacto de emergencia es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (empleadoDto.getNumContactoEmergencia() == null)
			return new ResponseEntity(new Mensaje("El campo numero contacto de emergencia es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(empleadoDto.getEps()))
			return new ResponseEntity(new Mensaje("El campo eps es obligatorio."), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(empleadoDto.getArl()))
			return new ResponseEntity(new Mensaje("El campo arl es obligatorio."), HttpStatus.BAD_REQUEST);

		if (empleadoDto.getIdSexoBio() == null)
			return new ResponseEntity(new Mensaje("El campo genero es obligatorio."), HttpStatus.BAD_REQUEST);

		if (empleadoDto.getIdTipoSangre() == null)
			return new ResponseEntity(new Mensaje("El campo tipo de sangre es obligatorio."), HttpStatus.BAD_REQUEST);

		if (empleadoService.existsByIdTipoDocumentoAndNumDocumento(empleadoDto.getIdTipoDocumento(),
				empleadoDto.getNumDocumento()))
			return new ResponseEntity(
					new Mensaje("El empleado con el documento " + empleadoDto.getIdTipoDocumento().getTipDocumento()
							+ ": " + empleadoDto.getNumDocumento() + " ya se enecuentra registrado. "),
					HttpStatus.BAD_REQUEST);

		Empleado empleado = new Empleado(empleadoDto.getNombre(), empleadoDto.getApellido(),
				empleadoDto.getIdTipoDocumento(), empleadoDto.getNumDocumento(), empleadoDto.getNumTelefono(),
				empleadoDto.getCorreo(), empleadoDto.getFechaNacimiento(), empleadoDto.getDireccion(),
				empleadoDto.getNomContactoEmergencia(), empleadoDto.getNumContactoEmergencia(), empleadoDto.getEps(),
				empleadoDto.getArl(), empleadoDto.getIdSexoBio(), empleadoDto.getIdTipoSangre());

		empleadoService.save(empleado);
		return new ResponseEntity(new Mensaje("El empleado ha sido registrado"), HttpStatus.OK);

	}

	@PutMapping("/actualizarEmpleado/{idEmpleado}")
	public ResponseEntity<?> updateEmpleado(@PathVariable("idEmpleado") int idEmpleado,
			@RequestBody EmpleadoDto empleadoDto) {

		if (!empleadoService.existsByIdTipoDocumentoAndNumDocumento(empleadoDto.getIdTipoDocumento(),
				empleadoDto.getNumDocumento()))
			return new ResponseEntity(new Mensaje("No existe el empleado con el documento "
					+ empleadoDto.getIdTipoDocumento().getTipDocumento() + ": " + empleadoDto.getNumDocumento()),
					HttpStatus.NOT_FOUND);

		if (empleadoService.existsByIdTipoDocumentoAndNumDocumento(empleadoDto.getIdTipoDocumento(),
				empleadoDto.getNumDocumento())
				&& empleadoService.getByIdTipoDocumentoAndNumDocumento(empleadoDto.getIdTipoDocumento(),
						empleadoDto.getNumDocumento()).get().getIdEmpleado() != idEmpleado)
			return new ResponseEntity(new Mensaje("No es posible actualizar, el empleado con el documento "
					+ empleadoDto.getIdTipoDocumento().getTipDocumento() + ": " + empleadoDto.getNumDocumento()
					+ " ya se encuentra registrado en otro empleado. "), HttpStatus.NOT_FOUND);

		if (StringUtils.isBlank(empleadoDto.getNombre()))
			return new ResponseEntity(new Mensaje("El campo nombre es obligatorio."), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(empleadoDto.getApellido()))
			return new ResponseEntity(new Mensaje("El campo apellido es obligatorio."), HttpStatus.BAD_REQUEST);

		if (empleadoDto.getIdTipoDocumento() == null)
			return new ResponseEntity(new Mensaje("El campo tipo de documento es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (empleadoDto.getNumDocumento() == null)
			return new ResponseEntity(new Mensaje("El campo numero de documento es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (empleadoDto.getNumTelefono() == null)
			return new ResponseEntity(new Mensaje("El campo numero de telefono es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(empleadoDto.getCorreo()))
			return new ResponseEntity(new Mensaje("El campo correo es obligatorio."), HttpStatus.BAD_REQUEST);

		if (empleadoDto.getFechaNacimiento() == null)
			return new ResponseEntity(new Mensaje("El campo fecha nacimiento es obligatorio."), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(empleadoDto.getDireccion()))
			return new ResponseEntity(new Mensaje("El campo direccion es obligatorio."), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(empleadoDto.getNomContactoEmergencia()))
			return new ResponseEntity(new Mensaje("El campo nombre contacto de emergencia es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (empleadoDto.getNumContactoEmergencia() == null)
			return new ResponseEntity(new Mensaje("El campo numero contacto de emergencia es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(empleadoDto.getEps()))
			return new ResponseEntity(new Mensaje("El campo eps es obligatorio."), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(empleadoDto.getArl()))
			return new ResponseEntity(new Mensaje("El campo arl es obligatorio."), HttpStatus.BAD_REQUEST);

		if (empleadoDto.getIdSexoBio() == null)
			return new ResponseEntity(new Mensaje("El campo genero es obligatorio."), HttpStatus.BAD_REQUEST);

		if (empleadoDto.getIdTipoSangre() == null)
			return new ResponseEntity(new Mensaje("El campo tipo de sangre es obligatorio."), HttpStatus.BAD_REQUEST);

		Empleado empleado = empleadoService.getOne(idEmpleado).get();
		empleado.setNombre(empleadoDto.getNombre());
		empleado.setApellido(empleadoDto.getApellido());
		empleado.setIdTipoDocumento(empleadoDto.getIdTipoDocumento());
		empleado.setNumDocumento(empleadoDto.getNumDocumento());
		empleado.setNumTelefono(empleadoDto.getNumTelefono());
		empleado.setCorreo(empleadoDto.getCorreo());
		empleado.setDireccion(empleadoDto.getDireccion());
		empleado.setNomContactoEmergencia(empleadoDto.getNomContactoEmergencia());
		empleado.setNumContactoEmergencia(empleadoDto.getNumContactoEmergencia());
		empleado.setEps(empleadoDto.getEps());
		empleado.setArl(empleadoDto.getArl());
		empleado.setIdSexoBio(empleadoDto.getIdSexoBio());

		empleadoService.save(empleado);
		return new ResponseEntity(new Mensaje("Los datos del empleado han sido actualizados"), HttpStatus.OK);

	}

	@DeleteMapping("/deleteEmpleado/{idEmpleado}")
	public ResponseEntity<?> deleteEmpleados(@PathVariable("idEmpleado") int idEmpleado) {
		if (!empleadoService.existsById(idEmpleado))

			return new ResponseEntity(new Mensaje("No existe el huesped con el identificador "), HttpStatus.NOT_FOUND);

		empleadoService.delete(idEmpleado);
		return new ResponseEntity(new Mensaje(" El registro del huesped ha sido eliminado"), HttpStatus.OK);
	}
	/** 7 */

}
