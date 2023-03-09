package com.proyecto.apartahotel.sispart.checkin.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proyecto.apartahotel.sispart.habitacion.entity.Habitaciones;
import com.proyecto.apartahotel.sispart.huespedes.entity.Huesped;

public class CheckInDto {

	@NotBlank
	// private Long numDocumento;;
	private Huesped idHuesped;
	@NotBlank
	private Habitaciones idHabitacion;
	@NotBlank
	private Integer numAcompanantes;
	@NotBlank
	private Integer dias_aprox_estadia;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@JsonFormat(pattern = "dd-MM-yyyy", timezone = "GMT-5")
	@NotBlank
	private Date fechaIngreso;

	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	@JsonFormat(pattern = "HH:mm", timezone = "GMT-5")
	@NotBlank
	private Date horaIngreso;

	public CheckInDto() {

	}

	public CheckInDto(@NotBlank Huesped idHuesped, @NotBlank Habitaciones idHabitacion,
			@NotBlank Integer numAcompanantes, @NotBlank Integer dias_aprox_estadia, @NotBlank Date fechaIngreso,
			@NotBlank Date horaIngreso) {
		this.idHuesped = idHuesped;
		this.idHabitacion = idHabitacion;
		this.numAcompanantes = numAcompanantes;
		this.dias_aprox_estadia = dias_aprox_estadia;
		this.fechaIngreso = fechaIngreso;
		this.horaIngreso = horaIngreso;
	}

	public Huesped getIdHuesped() {
		return idHuesped;
	}

	public void setIdHuesped(Huesped idHuesped) {
		this.idHuesped = idHuesped;
	}

	public Habitaciones getIdHabitacion() {
		return idHabitacion;
	}

	public void setIdHabitacion(Habitaciones idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	public Integer getNumAcompanantes() {
		return numAcompanantes;
	}

	public void setNumAcompanantes(Integer numAcompanantes) {
		this.numAcompanantes = numAcompanantes;
	}

	public Integer getDias_aprox_estadia() {
		return dias_aprox_estadia;
	}

	public void setDias_aprox_estadia(Integer dias_aprox_estadia) {
		this.dias_aprox_estadia = dias_aprox_estadia;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getHoraIngreso() {
		return horaIngreso;
	}

	public void setHoraIngreso(Date horaIngreso) {
		this.horaIngreso = horaIngreso;
	}

}
