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
	private Date fecha_ingreso;

	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	@JsonFormat(pattern = "HH:mm", timezone = "GMT-5")
	@NotBlank
	private Date hora_ingreso;

	public CheckInDto() {

	}

	public CheckInDto(@NotNull Huesped idHuesped, Habitaciones idHabitacion, @NotNull Integer numAcompanantes,
			@NotNull Integer dias_aprox_estadia, @NotNull Date fecha_ingreso, @NotNull Date hora_ingreso) {

		this.idHuesped = idHuesped;
		this.idHabitacion = idHabitacion;
		this.numAcompanantes = numAcompanantes;
		this.dias_aprox_estadia = dias_aprox_estadia;
		this.fecha_ingreso = fecha_ingreso;
		this.hora_ingreso = hora_ingreso;

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

	public Integer getnumAcompanantes() {
		return numAcompanantes;
	}

	public void setnumAcompanantes(Integer numAcompanantes) {
		this.numAcompanantes = numAcompanantes;
	}

	public Integer getDias_aprox_estadia() {
		return dias_aprox_estadia;
	}

	public void setDias_aprox_estadia(Integer dias_aprox_estadia) {
		this.dias_aprox_estadia = dias_aprox_estadia;
	}

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public Date getHora_ingreso() {
		return hora_ingreso;
	}

	public void setHora_ingreso(Date hora_ingreso) {
		this.hora_ingreso = hora_ingreso;
	}

}
