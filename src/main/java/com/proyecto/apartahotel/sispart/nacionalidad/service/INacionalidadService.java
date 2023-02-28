package com.proyecto.apartahotel.sispart.nacionalidad.service;



import java.util.List;
import java.util.Optional;

import com.proyecto.apartahotel.sispart.nacionalidad.entity.Nacionalidad;



public interface INacionalidadService {

	public List<Nacionalidad> findAll();

	public Optional<Nacionalidad> getOne(int id);

	public Optional<Nacionalidad> getByNombre(String nombre);

	public void save(Nacionalidad nacionalidad);

	public void delete(int id);

	public boolean existsById(int id);

	public boolean existsByNombre(String nombre);

}
