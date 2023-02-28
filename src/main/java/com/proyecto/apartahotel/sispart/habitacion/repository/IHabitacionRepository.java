package com.proyecto.apartahotel.sispart.habitacion.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.apartahotel.sispart.habitacion.entity.Habitaciones;



@Repository
public interface IHabitacionRepository extends JpaRepository<Habitaciones, Integer> {

	Optional<Habitaciones> findByNumHabitacion(int numHabitacion);

	boolean existsByNumHabitacion(int numHabitacion);

	void deleteByNumHabitacion(int numHabitacion);
	

}
