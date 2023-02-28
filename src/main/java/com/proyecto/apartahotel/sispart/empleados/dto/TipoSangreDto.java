package com.proyecto.apartahotel.sispart.empleados.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TipoSangreDto {

	@NotBlank
	private String tipoSangre;

	public TipoSangreDto() {
	}

	public TipoSangreDto(@NotBlank String tipoSangre) {

		this.tipoSangre = tipoSangre;
	}

	public String getTipoSangre() {
		return tipoSangre;
	}

	public void setTipoSangre(String tipoSangre) {
		this.tipoSangre = tipoSangre;
	}

}
