package com.proyecto.apartahotel.sispart.huespedes.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.proyecto.apartahotel.sispart.nacionalidad.entity.Nacionalidad;
import com.proyecto.apartahotel.sispart.tipDocumento.entity.TipoDocumento;

@Entity
@Table(name = "huespedes")
public class Huesped implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Huesped")
	private int idHuesped;

	@NotNull
	private String nombre;
	@NotNull
	private String apellido;
	@NotNull
	private String direccion;
	
	@NotNull
	@Column(name = "num_celular")
	private Long numCelular;
	
	@NotNull
	private String correo;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_tip_documento")
	private TipoDocumento idTipoDocumento;

	@NotNull
	@Column(name = "num_documento")
	private Long numDocumento;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_nacionalidad")
	private Nacionalidad idNacionalidad;

	@NotNull
	@Column(name = "lugar_origen")
	private String lugarOrigen;

	@Column(name = "nom_contacto_emergencia")
	private String nomContactoEmergencia;

	@Column(name = "num_contacto_emergencia")
	private Long numContactoEmergencia;

	@Column(name = "estado_Huesped")
	private boolean estadoHuesped;

	public Huesped() {

	}

	public Huesped(int idHuesped, @NotNull String nombre, @NotNull String apellido, @NotNull String direccion,
			@NotNull Long numCelular, @NotNull String correo, @NotNull TipoDocumento idTipoDocumento,
			@NotNull Long numDocumento, @NotNull Nacionalidad idNacionalidad, @NotNull String lugarOrigen,
			String nomContactoEmergencia, Long numContactoEmergencia, boolean estadoHuesped) {

		this.idHuesped = idHuesped;
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

	public Huesped(@NotNull String nombre, @NotNull String apellido, @NotNull String direccion,
			@NotNull Long numCelular, @NotNull String correo, @NotNull TipoDocumento idTipoDocumento,
			@NotNull Long numDocumento, @NotNull Nacionalidad idNacionalidad, @NotNull String lugarOrigen,
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

	public int getidHuesped() {
		return idHuesped;
	}

	public void setidHuesped(int idHuesped) {
		this.idHuesped = idHuesped;
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

	public TipoDocumento getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipDocumento(TipoDocumento idTipoDocumento) {
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

	private static final long serialVersionUID = 2426378341826782229L;
}
