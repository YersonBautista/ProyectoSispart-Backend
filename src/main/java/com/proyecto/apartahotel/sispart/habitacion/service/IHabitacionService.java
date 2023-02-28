package com.proyecto.apartahotel.sispart.habitacion.service;



import java.util.List;
import java.util.Optional;

import com.proyecto.apartahotel.sispart.habitacion.entity.Habitaciones;


public interface IHabitacionService {

	public List<Habitaciones> findAll();

	public Optional<Habitaciones> getOne(int id);

	public Optional<Habitaciones> getByNumHabitacion(int numHabitacion);

	public void save(Habitaciones habitacion);

	public void delete(int numHabitacion);

	public boolean existsById(int id);
	
	public boolean existsByNumHabitacion(int numHabitacion);
}
