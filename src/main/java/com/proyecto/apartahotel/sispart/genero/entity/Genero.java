package com.proyecto.apartahotel.sispart.genero.entity;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sexo_biologico")
public class Genero implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sexo_bio")
	private Integer idSexoBio;

	@NotNull
	private String sexoBio;

	public Genero() {

	}

	public Genero(@NotNull String sexoBio) {

		this.sexoBio = sexoBio;
	}

	public Genero(Integer id, @NotNull String sexoBio) {

		this.idSexoBio = id;
		this.sexoBio = sexoBio;
	}

	public Integer getIdSexoBio() {
		return idSexoBio ;
	}

	public void setId(Integer idSexoBio) {
		this.idSexoBio = idSexoBio;
	}

	public String getSexoBio() {
		return sexoBio;
	}

	public void setSexoBio(String sexoBio) {
		this.sexoBio = sexoBio;
	}

	private static final long serialVersionUID = 3909671778259252550L;
}
