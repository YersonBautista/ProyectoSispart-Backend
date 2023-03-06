package com.proyecto.apartahotel.sispart.huespedes.controller;

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

import com.proyecto.apartahotel.sispart.huespedes.dto.HuespedDto;
import com.proyecto.apartahotel.sispart.huespedes.entity.Huesped;
import com.proyecto.apartahotel.sispart.huespedes.service.IHuespedService;
import com.proyecto.apartahotel.sispart.mensaje.Mensaje;
import com.proyecto.apartahotel.sispart.tipDocumento.entity.TipoDocumento;
import com.proyecto.apartahotel.sispart.tipDocumento.service.ITipoDocumentoService;

@RestController
@RequestMapping("/huespedes")
public class HuespedController {

	@Autowired
	private IHuespedService huespedesService;

	@GetMapping("/listarHuespedes")
	public ResponseEntity<List<Huesped>> findAll() {
		List<Huesped> findAll = huespedesService.findAll();

		if (findAll.isEmpty())
			return new ResponseEntity(new Mensaje("No hay huespedes para listar"), HttpStatus.NOT_FOUND);

		return new ResponseEntity<List<Huesped>>(findAll, HttpStatus.OK);
	}

	@GetMapping("/verHuespedes/{idHuesped}")
	public ResponseEntity<Huesped> getById(@PathVariable("idHuesped") int idHuesped) {

		if (!huespedesService.existsById(idHuesped))

			return new ResponseEntity(new Mensaje("No existe el huesped"), HttpStatus.NOT_FOUND);

		Huesped huespedes = huespedesService.getOne(idHuesped).get();
		return new ResponseEntity<Huesped>(huespedes, HttpStatus.OK);
	}

	@GetMapping("/detalleHuesped/{numDocumento}/{idTipoDocumento}")
	public ResponseEntity<Huesped> getByIdTipoDocumentoAndNumDocumento(@PathVariable("numDocumento") Long numDocumento,
			@PathVariable("idTipoDocumento") TipoDocumento idTipoDocumento) {

		if (!huespedesService.existsByIdTipoDocumentoAndNumDocumento(idTipoDocumento, numDocumento))

			return new ResponseEntity(new Mensaje("No existe el huesped con ese numero de documento"),
					HttpStatus.NOT_FOUND);

		Huesped huespedes = huespedesService.getByIdTipoDocumentoAndNumDocumento(idTipoDocumento, numDocumento).get();
		return new ResponseEntity<Huesped>(huespedes, HttpStatus.OK);
	}

	@PostMapping("/registrarHuesped")
	public ResponseEntity<?> createHuespedes(@RequestBody HuespedDto huespedesDto) {

		if (StringUtils.isBlank(huespedesDto.getNombre()))
			return new ResponseEntity(new Mensaje("El campo nombre es obligatorio."), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(huespedesDto.getApellido()))
			return new ResponseEntity(new Mensaje("El campo apellido es obligatorio."), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(huespedesDto.getDireccion()))
			return new ResponseEntity(new Mensaje("El campo direccion es obligatorio."), HttpStatus.BAD_REQUEST);

		if (huespedesDto.getnumCelular() == null)
			return new ResponseEntity(new Mensaje("El campo numero de celular es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(huespedesDto.getCorreo()))
			return new ResponseEntity(
					new Mensaje(
							"El campo correo es obligatorio en caso de no tener correo llenar el campo con 'N/A'. "),
					HttpStatus.BAD_REQUEST);

		if (huespedesDto.getidTipoDocumento() == null)
			return new ResponseEntity(new Mensaje("El campo tipo de documento es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (huespedesDto.getNumDocumento() == null || huespedesDto.getNumDocumento() <= 0)
			return new ResponseEntity(new Mensaje("El campo numero de documento es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (huespedesDto.getidNacionalidad() == null)
			return new ResponseEntity(new Mensaje("El campo nacionalidad es obligatorio."), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(huespedesDto.getlugarOrigen()))
			return new ResponseEntity(new Mensaje("El campo lugar de origen es obligatorio."), HttpStatus.BAD_REQUEST);

		if (huespedesService.existsByIdTipoDocumentoAndNumDocumento(huespedesDto.getidTipoDocumento(),
				huespedesDto.getNumDocumento()))
			return new ResponseEntity(
					new Mensaje("El huesped con el documento " + huespedesDto.getidTipoDocumento().getTipDocumento()
							+ ": " + huespedesDto.getNumDocumento() + " ya se enecuentra registrado. "),
					HttpStatus.BAD_REQUEST);

		Huesped huesped = new Huesped(huespedesDto.getNombre(), huespedesDto.getApellido(), huespedesDto.getDireccion(),
				huespedesDto.getnumCelular(), huespedesDto.getCorreo(), huespedesDto.getidTipoDocumento(),
				huespedesDto.getNumDocumento(), huespedesDto.getidNacionalidad(), huespedesDto.getlugarOrigen(),
				huespedesDto.getnomContactoEmergencia(), huespedesDto.getnumContactoEmergencia(),
				huespedesDto.getEstadoHuesped());
		huespedesService.save(huesped);
		return new ResponseEntity(new Mensaje("El huesped ha sido registrado"), HttpStatus.OK);

	}

	@PutMapping("/actualizarHuesped/{idHuesped}")
	public ResponseEntity<?> updateHuespedes(@PathVariable("idHuesped") int idHuesped,
			@RequestBody HuespedDto huespedesDto) {

		if (!huespedesService.existsById(idHuesped))

			return new ResponseEntity(new Mensaje("No existe el huesped con el identificador " + idHuesped),
					HttpStatus.NOT_FOUND);

		if (huespedesService.existsByIdTipoDocumentoAndNumDocumento(huespedesDto.getidTipoDocumento(),
				huespedesDto.getNumDocumento())
				&& huespedesService.getByIdTipoDocumentoAndNumDocumento(huespedesDto.getidTipoDocumento(),
						huespedesDto.getNumDocumento()).get().getidHuesped() != idHuesped)

			return new ResponseEntity(
					new Mensaje("No es posible actualizar el huesped con documento: "
							+ huespedesDto.getidTipoDocumento().getTipDocumento() + ": "
							+ huespedesDto.getNumDocumento() + " porqué ya cuenta con un registro "),
					HttpStatus.NOT_FOUND);

		if (StringUtils.isBlank(huespedesDto.getNombre()))
			return new ResponseEntity(new Mensaje("El campo nombre es obligatorio."), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(huespedesDto.getApellido()))
			return new ResponseEntity(new Mensaje("El campo apellido es obligatorio."), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(huespedesDto.getDireccion()))
			return new ResponseEntity(new Mensaje("El campo direccion es obligatorio."), HttpStatus.BAD_REQUEST);

		if (huespedesDto.getnumCelular() == null)
			return new ResponseEntity(new Mensaje("El campo numero de celular es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(huespedesDto.getCorreo()))
			return new ResponseEntity(
					new Mensaje(
							"El campo correo es obligatorio en caso de no tener correo llenar el campo con 'N/A'. "),
					HttpStatus.BAD_REQUEST);

		if (huespedesDto.getidTipoDocumento() == null)
			return new ResponseEntity(new Mensaje("El campo tipo de documento es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (huespedesDto.getNumDocumento() == null)
			return new ResponseEntity(new Mensaje("El campo numero de documento es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (huespedesDto.getidNacionalidad() == null)
			return new ResponseEntity(new Mensaje("El campo nacionalidad es obligatorio."), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(huespedesDto.getlugarOrigen()))
			return new ResponseEntity(new Mensaje("El campo lugar de origen es obligatorio."), HttpStatus.BAD_REQUEST);

		Huesped huesped = huespedesService.getOne(idHuesped).get();
		huesped.setNombre(huespedesDto.getNombre());
		huesped.setApellido(huespedesDto.getApellido());
		huesped.setDireccion(huesped.getDireccion());
		huesped.setnumCelular(huespedesDto.getnumCelular());
		huesped.setCorreo(huespedesDto.getCorreo());
		huesped.setIdTipDocumento(huespedesDto.getidTipoDocumento());
		huesped.setNumDocumento(huespedesDto.getNumDocumento());
		huesped.setidNacionalidad(huespedesDto.getidNacionalidad());
		huesped.setlugarOrigen(huespedesDto.getlugarOrigen());
		huesped.setnomContactoEmergencia(huespedesDto.getnomContactoEmergencia());
		huesped.setnumContactoEmergencia(huespedesDto.getnumContactoEmergencia());
		huesped.setEstadoHuesped(huespedesDto.getEstadoHuesped());

		huespedesService.save(huesped);
		return new ResponseEntity(new Mensaje(" El registro del huesped ha sido actualizado"), HttpStatus.OK);

	}

	@DeleteMapping("/deleteHuespedes/{numDocumento}/{idTipoDocumento}")
	public ResponseEntity<?> deleteHuespedes(@PathVariable("numDocumento") Long numDocumento,
			@PathVariable("idTipoDocumento") TipoDocumento idTipoDocumento) {
		if (!huespedesService.existsByIdTipoDocumentoAndNumDocumento(idTipoDocumento, numDocumento))

			return new ResponseEntity(new Mensaje("No existe el huesped con el documento " + numDocumento),
					HttpStatus.NOT_FOUND);

		huespedesService.deleteByIdTipoDocumentoNumDocumento(idTipoDocumento, numDocumento);

		return new ResponseEntity(new Mensaje(" El registro del huesped ha sido eliminado"), HttpStatus.OK);
	}

}
