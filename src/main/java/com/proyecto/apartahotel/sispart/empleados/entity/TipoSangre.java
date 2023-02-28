package com.proyecto.apartahotel.sispart.empleados.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tipoSangre")
public class TipoSangre implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tip_sangre")
	private Integer idTipoSangre;

	@NotNull
	private String tipoSangre;

	public TipoSangre() {

	}

	public TipoSangre(@NotNull String tipoSangre) {

		this.tipoSangre = tipoSangre;
	}

	public TipoSangre(Integer idTipoSangre, @NotNull String tipoSangre) {

		this.idTipoSangre = idTipoSangre;
		this.tipoSangre = tipoSangre;
	}

	public Integer getIdTipoSangre() {
		return idTipoSangre;
	}

	public void setIdTipoSangre(Integer idTipoSangre) {
		this.idTipoSangre = idTipoSangre;
	}

	public String getTipoSangre() {
		return tipoSangre;
	}

	public void setTipoSangre(String tipoSangre) {
		this.tipoSangre = tipoSangre;
	}

	private static final long serialVersionUID = 6652513307644902895L;

}
