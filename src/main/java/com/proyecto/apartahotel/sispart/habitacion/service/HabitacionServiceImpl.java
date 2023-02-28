package com.proyecto.apartahotel.sispart.habitacion.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.apartahotel.sispart.habitacion.entity.Habitaciones;
import com.proyecto.apartahotel.sispart.habitacion.repository.IHabitacionRepository;


@Service
@Transactional
public class HabitacionServiceImpl implements IHabitacionService {

	@Autowired
	private IHabitacionRepository habitacionRepository;

	@Override
	public List<Habitaciones> findAll() {

		return habitacionRepository.findAll();
	}

	@Override
	public Optional<Habitaciones> getOne(int id) {

		return habitacionRepository.findById(id);
	}

	@Override
	public Optional<Habitaciones> getByNumHabitacion(int numHabitacion) {

		return habitacionRepository.findByNumHabitacion(numHabitacion);
	}

	@Override
	public void save(Habitaciones habitacion) {

		habitacionRepository.save(habitacion);
	}

	@Override
	public void delete(int numHabitacion) {

		habitacionRepository.deleteByNumHabitacion(numHabitacion);
	}

	@Override
	public boolean existsById(int id) {

		return habitacionRepository.existsById(id);
	}

	@Override
	public boolean existsByNumHabitacion(int numHabitacion) {

		return existsByNumHabitacion(numHabitacion);
	}

}
