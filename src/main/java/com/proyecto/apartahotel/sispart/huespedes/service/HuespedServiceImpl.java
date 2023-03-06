package com.proyecto.apartahotel.sispart.huespedes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.apartahotel.sispart.huespedes.entity.Huesped;
import com.proyecto.apartahotel.sispart.huespedes.repository.IHuespedRepository;
import com.proyecto.apartahotel.sispart.tipDocumento.entity.TipoDocumento;

@Service
@Transactional
public class HuespedServiceImpl implements IHuespedService {

	@Autowired
	private IHuespedRepository huespedRepository;

	@Transactional(readOnly = true)
	@Override
	public List<Huesped> findAll() {

		return huespedRepository.findAll();
	}

	@Override
	public Optional<Huesped> getOne(int id) {

		return huespedRepository.findById(id);
	}

	@Override
	public Optional<Huesped> getByIdTipoDocumentoAndNumDocumento(TipoDocumento idTipoDocumento, Long numDocumento) {

		return huespedRepository.findByIdTipoDocumentoAndNumDocumento(idTipoDocumento, numDocumento);
	}

	@Override
	public void save(Huesped huesped) {

		huespedRepository.save(huesped);
	}

	@Override
	public void deleteByIdTipoDocumentoNumDocumento(TipoDocumento idTipoDocumento, Long numDocumento) {

		huespedRepository.deleteByIdTipoDocumentoAndNumDocumento(idTipoDocumento, numDocumento);
	}

	@Override
	public boolean existsById(int id) {

		return huespedRepository.existsById(id);
	}

	@Override
	public boolean existsByIdTipoDocumentoAndNumDocumento(TipoDocumento idTipoDocumento, Long numDocumento) {

		return huespedRepository.existsByIdTipoDocumentoAndNumDocumento(idTipoDocumento, numDocumento);
	}

	@Override
	public Optional<Huesped> getByIdTipoDocumento(TipoDocumento idTipoDocumento) {

		return huespedRepository.findByIdTipoDocumento(idTipoDocumento);
	}

	@Override
	public boolean existsByIdTipoDocumento(TipoDocumento idtipoDocumento) {

		return huespedRepository.existsByIdTipoDocumento(idtipoDocumento);
	}

}
