package com.proyecto.apartahotel.sispart.checkin.entity;

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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.proyecto.apartahotel.sispart.habitacion.entity.Habitaciones;
import com.proyecto.apartahotel.sispart.huespedes.entity.Huesped;

@Entity
@Table(name = "Check_In")
public class CheckIn implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_check_in")
	private Integer codigoCheckIn;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_huesped")
	private Huesped idHuesped;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_habitacion")
	private Habitaciones idHabitacion;
	@NotNull
	private Integer numAcompanantes;
	@NotNull
	private Integer dias_aprox_estadia;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@JsonFormat(pattern = "dd-MM-yyyy", timezone = "GMT-5")
	@NotNull
	private Date fecha_ingreso;

	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	@JsonFormat(pattern = "HH:mm", timezone = "GMT-5")
	@NotNull
	private Date hora_ingreso;

	public CheckIn() {

	}

	public CheckIn(@NotNull Huesped idHuesped, @NotNull Habitaciones idHabitacion, @NotNull Integer numAcompanantes,
			@NotNull Integer dias_aprox_estadia, @NotNull Date fecha_ingreso, @NotNull Date hora_ingreso,
			Integer codigoCheckIn) {

		this.codigoCheckIn = codigoCheckIn;
		this.idHuesped = idHuesped;
		this.idHabitacion = idHabitacion;
		this.numAcompanantes = numAcompanantes;
		this.dias_aprox_estadia = dias_aprox_estadia;
		this.fecha_ingreso = fecha_ingreso;
		this.hora_ingreso = hora_ingreso;
	}

	public CheckIn(@NotNull Huesped idHuesped, @NotNull Habitaciones idHabitacion, @NotNull Integer numAcompanantes,
			@NotNull Integer dias_aprox_estadia, @NotNull Date fecha_ingreso, @NotNull Date hora_ingreso) {

		this.idHuesped = idHuesped;
		this.idHabitacion = idHabitacion;
		this.numAcompanantes = numAcompanantes;
		this.dias_aprox_estadia = dias_aprox_estadia;
		this.fecha_ingreso = fecha_ingreso;
		this.hora_ingreso = hora_ingreso;
	}

	public Integer getcodigoCheckIn() {
		return codigoCheckIn;
	}

	public void setcodigoCheckIn(Integer codigoCheckIn) {
		this.codigoCheckIn = codigoCheckIn;
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

	private static final long serialVersionUID = 5451699424516695779L;

}
