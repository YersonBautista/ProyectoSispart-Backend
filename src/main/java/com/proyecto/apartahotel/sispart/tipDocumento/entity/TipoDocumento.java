package com.proyecto.apartahotel.sispart.tipDocumento.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tipoDocumento")
public class TipoDocumento implements Serializable {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tip_documento")
	private int idTipDocumento;
	@NotNull
	private String tipDocumento;

	
	public TipoDocumento() {
		
	}


	public TipoDocumento(int idTipDocumento, String tipDocumento) {

		this.idTipDocumento = idTipDocumento;
		this.tipDocumento = tipDocumento;
	}


	public TipoDocumento(String tipDocumento) {
	
		this.tipDocumento = tipDocumento;
	}


	public int getIdTipDocumento() {
		return idTipDocumento;
	}


	public void setId_tip_documento(int idTipDocumento) {
		this.idTipDocumento = idTipDocumento;
	}


	public String getTipDocumento() {
		return tipDocumento;
	}


	public void setTipDocumento(String tipDocumento) {
		this.tipDocumento = tipDocumento;
	}
	
	
	
	private static final long serialVersionUID = 1L;
	

}