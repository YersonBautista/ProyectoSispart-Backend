package com.proyecto.apartahotel.sispart.facturacion.dto;

import javax.validation.constraints.NotBlank;

public class TipoDocLegalesDto {

	@NotBlank
	private String tipDocLegal;

	public TipoDocLegalesDto() {

	}

	public TipoDocLegalesDto(String tipDocLegal) {
		this.tipDocLegal = tipDocLegal;
	}

	public String getTipDocLegal() {
		return tipDocLegal;
	}

	public void setTipDocLegal(String tipDocLegal) {
		this.tipDocLegal = tipDocLegal;
	}

}
