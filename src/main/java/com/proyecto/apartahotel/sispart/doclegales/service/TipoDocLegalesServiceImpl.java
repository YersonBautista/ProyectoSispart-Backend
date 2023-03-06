package com.proyecto.apartahotel.sispart.doclegales.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.apartahotel.sispart.doclegales.entity.TipoDocLegal;
import com.proyecto.apartahotel.sispart.doclegales.repository.ITipoDocLegalRepository;

@Service
@Transactional
public class TipoDocLegalesServiceImpl implements ITipoDocLegalesService {

	@Autowired
	private ITipoDocLegalRepository tipoDocLegalRepository;

	@Override
	public List<TipoDocLegal> findAll() {

		return tipoDocLegalRepository.findAll();
	}

	@Override
	public Optional<TipoDocLegal> getOne(int idTipoDocLegal) {

		return tipoDocLegalRepository.findById(idTipoDocLegal);
	}

	@Override
	public void save(TipoDocLegal tipoDocLegal) {

		tipoDocLegalRepository.save(tipoDocLegal);
	}

	@Override
	public void delete(int idTipoDocLegal) {

		tipoDocLegalRepository.deleteById(idTipoDocLegal);
	}

	@Override
	public boolean existsById(int idTipoDocLegal) {

		return tipoDocLegalRepository.existsById(idTipoDocLegal);
	}

}
