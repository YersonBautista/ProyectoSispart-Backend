package com.proyecto.apartahotel.sispart.doclegales.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proyecto.apartahotel.sispart.doclegales.entity.TipoDocLegal;

public class DocsLegalesDto {

	@NotBlank
	private TipoDocLegal idTipDocLegal;
	@NotBlank
	private Integer numeroReferencia;
	@NotBlank
	private Integer pagoDocLegal;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@JsonFormat(pattern = "dd-MM-yyyy", timezone = "GMT-5")
	@NotBlank
	private Date fechPagoDocLegal;

	private String reciboPago;

	public DocsLegalesDto() {

	}

	public DocsLegalesDto(@NotBlank TipoDocLegal idTipDocLegal, @NotBlank Integer numeroReferencia,
			@NotBlank Integer pagoDocLegal, @NotBlank Date fechPagoDocLegal) {
		super();
		this.idTipDocLegal = idTipDocLegal;
		this.numeroReferencia = numeroReferencia;
		this.pagoDocLegal = pagoDocLegal;
		this.fechPagoDocLegal = fechPagoDocLegal;
	}

	public TipoDocLegal getIdTipDocLegal() {
		return idTipDocLegal;
	}

	public void setIdTipDocLegal(TipoDocLegal idTipDocLegal) {
		this.idTipDocLegal = idTipDocLegal;
	}

	public Integer getNumeroReferencia() {
		return numeroReferencia;
	}

	public void setNumeroReferencia(Integer numReferencia) {
		this.numeroReferencia = numReferencia;
	}

	public Integer getPagoDocLegal() {
		return pagoDocLegal;
	}

	public void setPagoDocLegal(Integer pagoDocLegal) {
		this.pagoDocLegal = pagoDocLegal;
	}

	public Date getFechPagoDocLegal() {
		return fechPagoDocLegal;
	}

	public void setFechPagoDocLegal(Date fechPagoDocLegal) {
		this.fechPagoDocLegal = fechPagoDocLegal;
	}

	public String getReciboPago() {
		return reciboPago;
	}

	public void setReciboPago(String reciboPago) {
		this.reciboPago = reciboPago;
	}

}
