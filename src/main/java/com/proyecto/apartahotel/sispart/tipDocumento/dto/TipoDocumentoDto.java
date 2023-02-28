package com.proyecto.apartahotel.sispart.tipDocumento.dto;

import javax.validation.constraints.NotBlank;

public class TipoDocumentoDto {

	@NotBlank
	private String tipDocumento;

	public TipoDocumentoDto() {

	}

	public TipoDocumentoDto(@NotBlank String tipDocumento) {

		this.tipDocumento = tipDocumento;
	}

	public String getTipDocumento() {
		return tipDocumento;
	}

	public void setTipDocumento(String tipDocumento) {
		this.tipDocumento = tipDocumento;
	}

}
