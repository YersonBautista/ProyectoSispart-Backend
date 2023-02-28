package com.proyecto.apartahotel.sispart.nacionalidad.dto;

import javax.validation.constraints.NotBlank;

public class NacionalidadDto {

	@NotBlank
	private String nombre;

	public NacionalidadDto() {

	}

	public NacionalidadDto(@NotBlank String nombre) {

		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
