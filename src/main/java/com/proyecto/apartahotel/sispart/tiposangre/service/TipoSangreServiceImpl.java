package com.proyecto.apartahotel.sispart.tiposangre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.apartahotel.sispart.tiposangre.entity.TipoSangre;
import com.proyecto.apartahotel.sispart.tiposangre.repository.ITipoSangreRepository;

@Service
@Transactional
public class TipoSangreServiceImpl implements ITipoSangreService {

	@Autowired
	private ITipoSangreRepository tipoSangreRepository;

	@Override
	public List<TipoSangre> findAll() {

		return tipoSangreRepository.findAll();
	}

}
