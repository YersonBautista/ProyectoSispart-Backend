package com.proyecto.apartahotel.sispart.empleados.entity;

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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proyecto.apartahotel.sispart.genero.entity.Genero;
import com.proyecto.apartahotel.sispart.tipDocumento.entity.TipoDocumento;
import com.proyecto.apartahotel.sispart.tiposangre.entity.TipoSangre;

@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEmpleado;

	@NotNull
	private String nombre;
	@NotNull
	private String apellido;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_tip_documento")
	private TipoDocumento idTipoDocumento;
	@NotNull
	@Column(name = "num_documento")
	private Integer numDocumento;
	@NotNull
	@Column(name = "num_telefono")
	private Long numTelefono;
	@NotNull
	@Column(unique = true)
	private String correo;

	@NotNull
	@Column(name = "fecha_nacimiento")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date fechaNacimiento;

	@NotNull
	private String direccion;
	@NotNull
	@Column(name = "nom_contacto_emergencia")
	private String nomContactoEmergencia;
	@NotNull
	@Column(name = "num_contacto_emergencia")
	private Long numContactoEmergencia;
	@NotNull
	private String eps;
	@NotNull
	private String arl;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_sexo_bio")
	private Genero idSexoBio;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_tip_sangre")
	private TipoSangre idTipoSangre;

	public Empleado() {

	}

	public Empleado(@NotNull String nombre, @NotNull String apellido, @NotNull TipoDocumento idTipoDocumento,
			@NotNull Integer numDocumento, @NotNull Long numTelefono, @NotNull String correo,
			@NotNull Date fechaNacimiento, @NotNull String direccion, @NotNull String nomContactoEmergencia,
			@NotNull Long numContactoEmergencia, @NotNull String eps, @NotNull String arl, @NotNull Genero idSexoBio,
			@NotNull TipoSangre idTipoSangre) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.idTipoDocumento = idTipoDocumento;
		this.numDocumento = numDocumento;
		this.numTelefono = numTelefono;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.nomContactoEmergencia = nomContactoEmergencia;
		this.numContactoEmergencia = numContactoEmergencia;
		this.eps = eps;
		this.arl = arl;
		this.idSexoBio = idSexoBio;
		this.idTipoSangre = idTipoSangre;
	}

	public Empleado(Integer idEmpleado, @NotNull String nombre, @NotNull String apellido,
			@NotNull TipoDocumento idTipoDocumento, @NotNull Integer numDocumento, @NotNull Long numTelefono,
			@NotNull String correo, @NotNull Date fechaNacimiento, @NotNull String direccion,
			@NotNull String nomContactoEmergencia, @NotNull Long numContactoEmergencia, @NotNull String eps,
			@NotNull String arl, @NotNull Genero idGenero, @NotNull TipoSangre idTipoSangre) {

		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.idTipoDocumento = idTipoDocumento;
		this.numDocumento = numDocumento;
		this.numTelefono = numTelefono;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.nomContactoEmergencia = nomContactoEmergencia;
		this.numContactoEmergencia = numContactoEmergencia;
		this.eps = eps;
		this.arl = arl;
		this.idSexoBio = idSexoBio;
		this.idTipoSangre = idTipoSangre;
	}

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setId(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
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

	public TipoDocumento getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(TipoDocumento idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public Integer getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(Integer numDocumento) {
		this.numDocumento = numDocumento;
	}

	public Long getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(Long numTelefono) {
		this.numTelefono = numTelefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNomContactoEmergencia() {
		return nomContactoEmergencia;
	}

	public void setNomContactoEmergencia(String nomContactoEmergencia) {
		this.nomContactoEmergencia = nomContactoEmergencia;
	}

	public Long getNumContactoEmergencia() {
		return numContactoEmergencia;
	}

	public void setNumContactoEmergencia(Long numContactoEmergencia) {
		this.numContactoEmergencia = numContactoEmergencia;
	}

	public String getEps() {
		return eps;
	}

	public void setEps(String eps) {
		this.eps = eps;
	}

	public String getArl() {
		return arl;
	}

	public void setArl(String arl) {
		this.arl = arl;
	}

	public Genero getIdSexoBio() {
		return idSexoBio;
	}

	public void setIdSexoBio(Genero idSexoBio) {
		this.idSexoBio = idSexoBio;
	}

	public TipoSangre getIdTipoSangre() {
		return idTipoSangre;
	}

	public void setIdTipoSangre(TipoSangre idTipoSangre) {
		this.idTipoSangre = idTipoSangre;
	}

	private static final long serialVersionUID = 8786858584033720428L;

}
