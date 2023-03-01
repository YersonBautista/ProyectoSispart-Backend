package com.proyecto.apartahotel.sispart.genero.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.apartahotel.sispart.genero.entity.Genero;
import com.proyecto.apartahotel.sispart.genero.repository.IGeneroRepository;

@Service
@Transactional
public class GeneroServiceImpl implements IGeneroService {

	@Autowired
	private IGeneroRepository generoRepository;

	@Override
	public List<Genero> findAll() {

		return generoRepository.findAll();
	}

}
