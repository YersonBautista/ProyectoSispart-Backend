package com.proyecto.apartahotel.sispart.facturacion.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tipo_doc_legal")
public class TipoDocLegal implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_tip_doc_legal")
	private Integer idtipDocLegal;

	@NotNull
	@Column(name = "tip_doc_legal")
	private String tipDocLegal;

	public TipoDocLegal() {

	}

	public TipoDocLegal(Integer idtipDocLegal, @NotNull String tipDocLegal) {

		this.idtipDocLegal = idtipDocLegal;
		this.tipDocLegal = tipDocLegal;
	}

	public TipoDocLegal(@NotNull String tipDocLegal) {

		this.tipDocLegal = tipDocLegal;
	}

	public Integer getIdtipDocLegal() {
		return idtipDocLegal;
	}

	public void setIdtipDocLegal(Integer idtipDocLegal) {
		this.idtipDocLegal = idtipDocLegal;
	}

	public String gettipDocLegal() {
		return tipDocLegal;
	}

	public void settipDocLegal(String tipDocLegal) {
		this.tipDocLegal = tipDocLegal;
	}

	private static final long serialVersionUID = -7793277197701042696L;

}
