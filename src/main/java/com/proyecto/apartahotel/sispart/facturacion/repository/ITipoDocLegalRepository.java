package com.proyecto.apartahotel.sispart.facturacion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.apartahotel.sispart.facturacion.entity.TipoDocLegal;

@Repository
public interface ITipoDocLegalRepository extends JpaRepository<TipoDocLegal, Integer> {

	Optional<TipoDocLegal> findByTipDocLegal(String tipDocLegal);

	boolean existsByTipDocLegal(String tipDocLegal);
}
