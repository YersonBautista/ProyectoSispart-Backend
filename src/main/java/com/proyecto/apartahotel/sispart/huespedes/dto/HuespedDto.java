package com.proyecto.apartahotel.sispart.huespedes.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.proyecto.apartahotel.sispart.nacionalidad.entity.Nacionalidad;
import com.proyecto.apartahotel.sispart.tipDocumento.entity.TipoDocumento;

public class HuespedDto {

	@NotBlank
	private String nombre;
	@NotBlank
	private String apellido;
	@NotBlank
	private String direccion;
	@NotBlank
	private Long numCelular;
	@Email
	private String correo;
	@NotBlank
	private TipoDocumento idTipoDocumento;
	@NotBlank
	private Long numDocumento;
	@NotBlank
	private Nacionalidad idNacionalidad;
	@NotBlank
	private String lugarOrigen;
	
	private String nomContactoEmergencia;
	private Long numContactoEmergencia;
	private boolean estadoHuesped = true;

	public HuespedDto() {

	}

	public HuespedDto(@NotBlank String nombre, @NotBlank String apellido, @NotBlank String direccion,
			@NotBlank Long numCelular, @Email String correo, @NotBlank TipoDocumento idTipoDocumento,
			@NotBlank Long numDocumento, @NotBlank Nacionalidad idNacionalidad, @NotBlank String lugarOrigen,
			String nomContactoEmergencia, Long numContactoEmergencia, boolean estadoHuesped) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.numCelular = numCelular;
		this.correo = correo;
		this.idTipoDocumento = idTipoDocumento;
		this.numDocumento = numDocumento;
		this.idNacionalidad = idNacionalidad;
		this.lugarOrigen = lugarOrigen;
		this.nomContactoEmergencia = nomContactoEmergencia;
		this.numContactoEmergencia = numContactoEmergencia;
		this.estadoHuesped = estadoHuesped;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Long getnumCelular() {
		return numCelular;
	}

	public void setnumCelular(Long numCelular) {
		this.numCelular = numCelular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public TipoDocumento getidTipoDocumento() {
		return idTipoDocumento;
	}

	public void setidTipoDocumento(TipoDocumento idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public Long getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(Long numDocumento) {
		this.numDocumento = numDocumento;
	}

	public Nacionalidad getidNacionalidad() {
		return idNacionalidad;
	}

	public void setidNacionalidad(Nacionalidad idNacionalidad) {
		this.idNacionalidad = idNacionalidad;
	}

	public String getlugarOrigen() {
		return lugarOrigen;
	}

	public void setlugarOrigen(String lugarOrigen) {
		this.lugarOrigen = lugarOrigen;
	}

	public String getnomContactoEmergencia() {
		return nomContactoEmergencia;
	}

	public void setnomContactoEmergencia(String nomContactoEmergencia) {
		this.nomContactoEmergencia = nomContactoEmergencia;
	}

	public Long getnumContactoEmergencia() {
		return numContactoEmergencia;
	}

	public void setnumContactoEmergencia(Long numContactoEmergencia) {
		this.numContactoEmergencia = numContactoEmergencia;
	}

	public boolean getEstadoHuesped() {
		return estadoHuesped;
	}

	public void setEstadoHuesped(boolean estadoHuesped) {
		this.estadoHuesped = estadoHuesped;
	}

}
