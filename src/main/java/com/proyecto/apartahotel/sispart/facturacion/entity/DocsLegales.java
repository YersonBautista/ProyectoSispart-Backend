package com.proyecto.apartahotel.sispart.facturacion.entity;

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

@Entity
@Table(name = "documentos_legales")
public class DocsLegales implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_doc_legal")
	private Integer idDocLegal;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "cod_tip_doc_legal")
	private TipoDocLegal idTipDocLegal;
	@NotNull
	private Integer numeroReferencia;
	@NotNull
	private Integer pagoDocLegal;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@JsonFormat(pattern = "dd-MM-yyyy", timezone = "GMT-5")
	@NotNull
	private Date fechPagoDocLegal;

	private String reciboPago;

	public DocsLegales() {

	}

	public DocsLegales(Integer idDocLegal, @NotNull TipoDocLegal idTipDocLegal, @NotNull Integer numeroReferencia,
			@NotNull Integer pagoDocLegal, @NotNull Date fechPagoDocLegal) {
		super();
		this.idDocLegal = idDocLegal;
		this.idTipDocLegal = idTipDocLegal;
		this.numeroReferencia = numeroReferencia;
		this.pagoDocLegal = pagoDocLegal;
		this.fechPagoDocLegal = fechPagoDocLegal;

	}

	public DocsLegales(@NotNull TipoDocLegal idTipDocLegal, @NotNull Integer numeroReferencia,
			@NotNull Integer pagoDocLegal, @NotNull Date fechPagoDocLegal) {
		super();
		this.idTipDocLegal = idTipDocLegal;
		this.numeroReferencia = numeroReferencia;
		this.pagoDocLegal = pagoDocLegal;
		this.fechPagoDocLegal = fechPagoDocLegal;

	}

	public Integer getIdDocLegal() {
		return idDocLegal;
	}

	public void setIdDocLegal(Integer idDocLegal) {
		this.idDocLegal = idDocLegal;
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

	public void setNumeroReferencia(Integer numeroReferencia) {
		this.numeroReferencia = numeroReferencia;
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

	private static final long serialVersionUID = -5100265653585511509L;
}
