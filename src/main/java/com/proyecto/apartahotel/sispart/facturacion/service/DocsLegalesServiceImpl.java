package com.proyecto.apartahotel.sispart.facturacion.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proyecto.apartahotel.sispart.facturacion.entity.DocsLegales;
import com.proyecto.apartahotel.sispart.facturacion.repository.IDocsLegalesRepository;

@Service
@Transactional
public class DocsLegalesServiceImpl implements IDocsLegalesService {

	@Autowired
	private IDocsLegalesRepository docsLegalesRepository;

	@Override
	public List<DocsLegales> findAll() {

		return docsLegalesRepository.findAll();
	}

	@Override
	public List<DocsLegales> findByNumeroReferencia(int numeroReferencia) {

		return docsLegalesRepository.findByNumeroReferencia(numeroReferencia);
	}

	@Override
	public Optional<DocsLegales> getOne(int idDocLegal) {

		return docsLegalesRepository.findById(idDocLegal);
	}

	@Override
	public Optional<DocsLegales> findByNumeroReferenciaAndFechPagoDocLegal(int numeroReferencia,
			Date fechPagoDocLegal) {

		return docsLegalesRepository.findByNumeroReferenciaAndFechPagoDocLegal(numeroReferencia, fechPagoDocLegal);
	}

	@Override
	public void save(DocsLegales docsLegal) {

		docsLegalesRepository.save(docsLegal);
	}

	@Override
	public boolean existsById(int idDocLegal) {

		return docsLegalesRepository.existsById(idDocLegal);
	}

	@Override
	public boolean existsByNumeroReferencia(int numeroReferencia) {

		return docsLegalesRepository.existsByNumeroReferencia(numeroReferencia);
	}

	@Override
	public boolean existsByNumeroReferenciaAndFechPagoDocLegal(int numeroReferencia, Date fechPagoDocLegal) {

		return docsLegalesRepository.existsByNumeroReferenciaAndFechPagoDocLegal(numeroReferencia, fechPagoDocLegal);
	}

	@Override
	public void delete(int idDocLegal) {

		docsLegalesRepository.deleteById(idDocLegal);

	}

}
