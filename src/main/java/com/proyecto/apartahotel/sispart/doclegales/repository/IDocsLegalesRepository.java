package com.proyecto.apartahotel.sispart.doclegales.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proyecto.apartahotel.sispart.doclegales.entity.DocsLegales;

@Repository
public interface IDocsLegalesRepository extends JpaRepository<DocsLegales, Integer> {

	List<DocsLegales> findByNumeroReferencia(int numeroReferencia);

	Optional<DocsLegales> findByNumeroReferenciaAndFechPagoDocLegal(int numeroReferencia, Date fechPagoDocLegal);

	boolean existsByNumeroReferencia(int numeroReferencia);

	boolean existsByNumeroReferenciaAndFechPagoDocLegal(int numeroReferencia, Date fechPagoDocLegal);

}
