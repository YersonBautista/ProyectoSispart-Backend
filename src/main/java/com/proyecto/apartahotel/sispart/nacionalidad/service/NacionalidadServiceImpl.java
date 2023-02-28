package com.proyecto.apartahotel.sispart.nacionalidad.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.apartahotel.sispart.nacionalidad.entity.Nacionalidad;
import com.proyecto.apartahotel.sispart.nacionalidad.repository.INacionalidadRepository;


@Service
@Transactional
public class NacionalidadServiceImpl implements INacionalidadService {

	@Autowired
	private INacionalidadRepository nacionalidadRepository;

	@Override
	public List<Nacionalidad> findAll() {

		return nacionalidadRepository.findAll();
	}

	@Override
	public Optional<Nacionalidad> getOne(int id) {

		return nacionalidadRepository.findById(id);
	}

	@Override
	public void save(Nacionalidad nacionalidad) {

		nacionalidadRepository.save(nacionalidad);

	}

	@Override
	public void delete(int id) {

		nacionalidadRepository.deleteById(id);
	}

	@Override
	public boolean existsById(int id) {

		return nacionalidadRepository.existsById(id);
	}

	@Override
	public Optional<Nacionalidad> getByNombre(String nombre) {

		return nacionalidadRepository.findByNombre(nombre);
	}

	@Override
	public boolean existsByNombre(String nombre) {

		return nacionalidadRepository.existsByNombre(nombre);
	}

}
