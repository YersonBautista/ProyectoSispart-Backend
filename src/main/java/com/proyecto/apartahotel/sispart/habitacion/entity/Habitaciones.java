package com.proyecto.apartahotel.sispart.habitacion.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "habitaciones")
public class Habitaciones implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdHabitacion;

	private String imagenHabitacion;
	@NotNull
	private String nombreHabitacion;
	@NotNull
	private String descripHabitacion;
	@NotNull
	private Integer numHabitacion;
	@NotNull
	private Integer pisoHabitacion;
	@NotNull
	private Integer maxPersonasDisponibles;
	@NotNull
	private Integer precioHabitacion;

	private String estadoHabitacion;

	public Habitaciones() {

	}

	public Habitaciones(Integer idHabitacion, String imagenHabitacion, @NotNull String nombreHabitacion,
			@NotNull String descripHabitacion, @NotNull Integer maxPersonasDisponibles, @NotNull Integer numHabitacion,
			@NotNull Integer pisoHabitacion, @NotNull Integer precioHabitacion, String estadoHabitacion) {

		IdHabitacion = idHabitacion;
		this.imagenHabitacion = imagenHabitacion;
		this.nombreHabitacion = nombreHabitacion;
		this.descripHabitacion = descripHabitacion;
		this.maxPersonasDisponibles = maxPersonasDisponibles;
		this.numHabitacion = numHabitacion;
		this.pisoHabitacion = pisoHabitacion;
		this.precioHabitacion = precioHabitacion;
		this.estadoHabitacion = estadoHabitacion;
	}

	public Habitaciones(String imagenHabitacion, @NotNull String nombreHabitacion, @NotNull String descripHabitacion,
			@NotNull Integer maxPersonasDisponibles, @NotNull Integer numHabitacion, @NotNull Integer pisoHabitacion,
			@NotNull Integer precioHabitacion, String estadoHabitacion) {

		this.imagenHabitacion = imagenHabitacion;
		this.nombreHabitacion = nombreHabitacion;
		this.descripHabitacion = descripHabitacion;
		this.maxPersonasDisponibles = maxPersonasDisponibles;
		this.numHabitacion = numHabitacion;
		this.pisoHabitacion = pisoHabitacion;
		this.precioHabitacion = precioHabitacion;
		this.estadoHabitacion = estadoHabitacion;
	}

	public Integer getIdHabitacion() {
		return IdHabitacion;
	}

	public void setIdHabitacion(Integer idHabitacion) {
		IdHabitacion = idHabitacion;
	}

	public String getImagenHabitacion() {
		return imagenHabitacion;
	}

	public void setImagenHabitacion(String imagenHabitacion) {
		this.imagenHabitacion = imagenHabitacion;
	}

	public String getNombreHabitacion() {
		return nombreHabitacion;
	}

	public void setNombreHabitacion(String nombreHabitacion) {
		this.nombreHabitacion = nombreHabitacion;
	}

	public String getDescripHabitacion() {
		return descripHabitacion;
	}

	public void setDescripHabitacion(String descripHabitacion) {
		this.descripHabitacion = descripHabitacion;
	}

	public Integer getMaxPersonasDisponibles() {
		return maxPersonasDisponibles;
	}

	public void setMaxPersonasDisponibles(Integer maxPersonasDisponibles) {
		this.maxPersonasDisponibles = maxPersonasDisponibles;
	}

	public Integer getNumHabitacion() {
		return numHabitacion;
	}

	public void setNumHabitacion(Integer numHabitacion) {
		this.numHabitacion = numHabitacion;
	}

	public Integer getPisoHabitacion() {
		return pisoHabitacion;
	}

	public void setPisoHabitacion(Integer pisoHabitacion) {
		this.pisoHabitacion = pisoHabitacion;
	}

	public Integer getPrecioHabitacion() {
		return precioHabitacion;
	}

	public void setPrecioHabitacion(Integer precioHabitacion) {
		this.precioHabitacion = precioHabitacion;
	}

	public String getEstadoHabitacion() {
		return estadoHabitacion;
	}

	public void setEstadoHabitacion(String estadoHabitacion) {
		this.estadoHabitacion = estadoHabitacion;
	}

	private static final long serialVersionUID = -2387612310708709239L;
}
