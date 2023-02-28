package com.proyecto.apartahotel.sispart.nacionalidad.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "naciones")
public class Nacionalidad implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	
	
	public Nacionalidad() {
		
	}
	
	public Nacionalidad(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public Nacionalidad(String nombre) {
		this.nombre = nombre;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	private static final long serialVersionUID = -7295422866713030848L;

}
