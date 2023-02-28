package com.proyecto.apartahotel.sispart.tipDocumento.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.apartahotel.sispart.tipDocumento.entity.TipoDocumento;
import com.proyecto.apartahotel.sispart.tipDocumento.repository.ITipoDocumentoRepository;


@Service
@Transactional
public class TipoDocumentoServiceImpl implements ITipoDocumentoService {

	@Autowired
	private ITipoDocumentoRepository tipoDocumentoRepository;

	@Override
	public List<TipoDocumento> findAll() {

		return tipoDocumentoRepository.findAll();
	}

	@Override
	public Optional<TipoDocumento> getOne(int id) {

		return tipoDocumentoRepository.findById(id);
	}

	@Override
	public void save(TipoDocumento tipDocumento) {

		tipoDocumentoRepository.save(tipDocumento);
	}

	@Override
	public void delete(int id) {

		tipoDocumentoRepository.deleteById(id);

	}

	@Override
	public boolean existsById(int id) {

		return tipoDocumentoRepository.existsById(id);
	}

	@Override
	public Optional<TipoDocumento> getByTipDocumento(String tipDocumento) {

		return tipoDocumentoRepository.findByTipDocumento(tipDocumento);
	}

	@Override
	public boolean existsByTipDocumento(String tipDocumento) {

		return tipoDocumentoRepository.existsByTipDocumento(tipDocumento);
	}

	/**/

}
