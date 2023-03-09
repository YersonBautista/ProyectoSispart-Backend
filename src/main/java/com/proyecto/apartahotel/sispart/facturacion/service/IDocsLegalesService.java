package com.proyecto.apartahotel.sispart.facturacion.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.Temporal;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proyecto.apartahotel.sispart.facturacion.entity.DocsLegales;

public interface IDocsLegalesService {

	public List<DocsLegales> findAll();

	public List<DocsLegales> findByNumeroReferencia(int numeroReferencia);

	public Optional<DocsLegales> getOne(int idDocLegal);

	public Optional<DocsLegales> findByNumeroReferenciaAndFechPagoDocLegal(int numeroReferencia, Date fechPagoDocLegal);

	public void save(DocsLegales DocLegal);

	public boolean existsById(int idDocLegal);

	public boolean existsByNumeroReferencia(int numeroReferencia);

	public boolean existsByNumeroReferenciaAndFechPagoDocLegal(int numeroReferencia, Date fechPagoDocLegal);

	public void delete(int idDocLegal);

}
