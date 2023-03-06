package com.proyecto.apartahotel.sispart.doclegales.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.apartahotel.sispart.doclegales.dto.DocsLegalesDto;
import com.proyecto.apartahotel.sispart.doclegales.entity.DocsLegales;

import com.proyecto.apartahotel.sispart.doclegales.service.IDocsLegalesService;
import com.proyecto.apartahotel.sispart.huespedes.dto.HuespedDto;
import com.proyecto.apartahotel.sispart.mensaje.Mensaje;
import com.proyecto.apartahotel.sispart.tipDocumento.entity.TipoDocumento;

@RestController
@RequestMapping("/docsLegales")
public class DocsLegalesController {

	@Autowired
	private IDocsLegalesService docsLegalesService;

	@GetMapping("/listarDocsLegales")
	public ResponseEntity<List<DocsLegales>> findAll() {
		List<DocsLegales> findAll = docsLegalesService.findAll();
		return new ResponseEntity<List<DocsLegales>>(findAll, HttpStatus.OK);
	}

	@GetMapping("/verDocsLegales/{idDocLegal}")
	public ResponseEntity<DocsLegales> getById(@PathVariable("idDocLegal") int idDocLegal) {

		if (!docsLegalesService.existsById(idDocLegal))

			return new ResponseEntity(new Mensaje("No existe el documento"), HttpStatus.NOT_FOUND);

		DocsLegales docsLegales = docsLegalesService.getOne(idDocLegal).get();
		return new ResponseEntity<DocsLegales>(docsLegales, HttpStatus.OK);
	}

	@PostMapping("/crearDocsLegales")
	public ResponseEntity<?> createDocsLegales(@RequestBody DocsLegalesDto docsLegalesDto) {

		if (docsLegalesDto.getIdTipDocLegal() == null)
			return new ResponseEntity(new Mensaje("Es obligatorio escoger el documento legal."),
					HttpStatus.BAD_REQUEST);

		if (docsLegalesDto.getNumeroReferencia() == null || docsLegalesDto.getNumeroReferencia() <= 0)
			return new ResponseEntity(new Mensaje("El campo numero de referencia es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (docsLegalesDto.getPagoDocLegal() == null)
			return new ResponseEntity(new Mensaje("El campo valor del pago  es obligatorio."), HttpStatus.BAD_REQUEST);

		if (docsLegalesDto.getFechPagoDocLegal() == null)
			return new ResponseEntity(new Mensaje("El campo  fecha de pago es obligatorio."), HttpStatus.BAD_REQUEST);

		if (docsLegalesService.existsByNumeroReferenciaAndFechPagoDocLegal(docsLegalesDto.getNumeroReferencia(),
				docsLegalesDto.getFechPagoDocLegal()))
			return new ResponseEntity(
					new Mensaje("El  documento" + docsLegalesDto.getIdTipDocLegal().gettipDocLegal()
							+ " con numero de referencia " + docsLegalesDto.getNumeroReferencia() + " y fecha de pago "
							+ docsLegalesDto.getFechPagoDocLegal() + " ya se encuentra registrado"),
					HttpStatus.BAD_REQUEST);

		DocsLegales docsLegales = new DocsLegales(docsLegalesDto.getIdTipDocLegal(),
				docsLegalesDto.getNumeroReferencia(), docsLegalesDto.getPagoDocLegal(),
				docsLegalesDto.getFechPagoDocLegal());

		docsLegalesService.save(docsLegales);
		return new ResponseEntity(new Mensaje(" El registro del documento ha sido creado"), HttpStatus.OK);
	}

	@PutMapping("/actualizarDocsLegales/{idDocLegal}")
	public ResponseEntity<?> updateDocsLegales(@PathVariable("idDocLegal") int idDocLegal,
			@RequestBody DocsLegalesDto docsLegalesDto) {

		if (!docsLegalesService.existsById(idDocLegal))

			return new ResponseEntity(new Mensaje("No existe el documento con el identificador " + idDocLegal),
					HttpStatus.NOT_FOUND);

		if (docsLegalesService.existsByNumeroReferenciaAndFechPagoDocLegal(docsLegalesDto.getNumeroReferencia(),
				docsLegalesDto.getFechPagoDocLegal())
				&& docsLegalesService.findByNumeroReferenciaAndFechPagoDocLegal(docsLegalesDto.getNumeroReferencia(),
						docsLegalesDto.getFechPagoDocLegal()).get().getIdDocLegal() != idDocLegal)

			return new ResponseEntity(
					new Mensaje("No es posible actualizar el documento "
							+ docsLegalesDto.getIdTipDocLegal().gettipDocLegal()
							+ ", porque existe otro documento con la misma fecha de pago ya creado "),
					HttpStatus.NOT_FOUND);

		if (docsLegalesDto.getIdTipDocLegal() == null)
			return new ResponseEntity(new Mensaje("Es obligatorio escoger el documento legal."),
					HttpStatus.BAD_REQUEST);

		if (docsLegalesDto.getNumeroReferencia() == null || docsLegalesDto.getNumeroReferencia() <= 0)
			return new ResponseEntity(new Mensaje("El campo numero de referencia es obligatorio."),
					HttpStatus.BAD_REQUEST);

		if (docsLegalesDto.getPagoDocLegal() == null)
			return new ResponseEntity(new Mensaje("El campo valor del pago  es obligatorio."), HttpStatus.BAD_REQUEST);

		if (docsLegalesDto.getFechPagoDocLegal() == null)
			return new ResponseEntity(new Mensaje("El campo  fecha de pago es obligatorio."), HttpStatus.BAD_REQUEST);

		DocsLegales docsLegales = docsLegalesService.getOne(idDocLegal).get();
		docsLegales.setIdTipDocLegal(docsLegalesDto.getIdTipDocLegal());
		docsLegales.setNumeroReferencia(docsLegalesDto.getNumeroReferencia());
		docsLegales.setPagoDocLegal(docsLegalesDto.getPagoDocLegal());
		docsLegales.setFechPagoDocLegal(docsLegales.getFechPagoDocLegal());

		docsLegalesService.save(docsLegales);

		return new ResponseEntity(new Mensaje(" El registro del documento ha sido actualizado"), HttpStatus.OK);

	}

	@DeleteMapping("/deleteDocsLegales/{idDocLegal}")
	public ResponseEntity<?> deleteDocslegal(@PathVariable("idDocLegal") int idDocLegal) {
		if (!docsLegalesService.existsById(idDocLegal))

			return new ResponseEntity(new Mensaje("No existe  el documento " + idDocLegal), HttpStatus.NOT_FOUND);

		docsLegalesService.delete(idDocLegal);

		return new ResponseEntity(new Mensaje(" El registro del documento ha sido eliminado"), HttpStatus.OK);
	}

	@PostMapping("/crearDocsLegales/uploadDocsLegal")
	public ResponseEntity<?> uploadDocsLegal(@RequestParam("archivo") MultipartFile archivo,
			@RequestParam("idDocLegal") int idDocLegal) {

		DocsLegales docsLegales = docsLegalesService.getOne(idDocLegal).get();

		if (!archivo.isEmpty()) {
			String nombreArchivo = UUID.randomUUID().toString() + "-" + archivo.getOriginalFilename().replace(" ", "");
			Path rutaArchivo = Paths.get("uploadsDocsLegal").resolve(nombreArchivo).toAbsolutePath();

			try {
				Files.copy(archivo.getInputStream(), rutaArchivo);
			} catch (IOException e) {

				return new ResponseEntity(new Mensaje("Error al subir la imagen" + nombreArchivo),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}

			docsLegales.setReciboPago(nombreArchivo);

			docsLegalesService.save(docsLegales);

		}

		return new ResponseEntity(new Mensaje("Se ha subido el comprobante de pago exitosamente"), HttpStatus.OK);

	}

	@GetMapping("/uploadDocsLegal/img/{nombreArchivo:.+}")
	public ResponseEntity<Resource> verArchivo(@PathVariable String nombreArchivo) {
		Path rutaArchivo = Paths.get("uploadsDocsLegal").resolve(nombreArchivo).toAbsolutePath();
		Resource recurso = null;

		try {
			recurso = new UrlResource(rutaArchivo.toUri());
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}

		if (!recurso.exists() && !recurso.isReadable()) {
			throw new RuntimeException("Error no se pudo cargar la imagen: " + nombreArchivo);
		}
		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");

		return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);

	}

}
