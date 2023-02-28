package com.proyecto.apartahotel.sispart.empleados.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class GeneroDto {

	@NotBlank
	private String sexoBio;

	public GeneroDto() {

	}

	public GeneroDto(@NotBlank String sexoBio) {
		super();
		this.sexoBio = sexoBio;
	}

	public String getSexoBio() {
		return sexoBio;
	}

	public void setSexoBio(String sexoBio) {
		this.sexoBio = sexoBio;
	}

}
