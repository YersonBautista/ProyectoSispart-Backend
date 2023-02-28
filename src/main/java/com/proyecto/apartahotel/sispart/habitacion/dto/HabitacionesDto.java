package com.proyecto.apartahotel.sispart.habitacion.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class HabitacionesDto {

	private String imagenHabitacion;
	@NotBlank
	private String nombreHabitacion;
	@NotBlank
	private String descripHabitacion;
	@NotBlank
	private Integer numHabitacion;
	@NotBlank
	private Integer pisoHabitacion;
	@NotBlank
	private Integer maxPersonasDisponibles;
	@NotBlank
	private Integer precioHabitacion;

	private String estadoHabitacion;

	public HabitacionesDto() {

	}

	public HabitacionesDto(String imagenHabitacion, @NotBlank String nombreHabitacion,
			@NotNull String descripHabitacion, @NotNull Integer maxPersonasDisponibles, @NotBlank Integer numHabitacion,
			@NotBlank Integer pisoHabitacion, @NotBlank Integer precioHabitacion, String estadoHabitacion) {

		this.imagenHabitacion = imagenHabitacion;
		this.nombreHabitacion = nombreHabitacion;
		this.descripHabitacion = descripHabitacion;
		this.maxPersonasDisponibles = maxPersonasDisponibles;
		this.numHabitacion = numHabitacion;
		this.pisoHabitacion = pisoHabitacion;
		this.precioHabitacion = precioHabitacion;
		this.estadoHabitacion = estadoHabitacion;
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

}
