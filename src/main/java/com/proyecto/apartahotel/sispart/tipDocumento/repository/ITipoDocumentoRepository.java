package com.proyecto.apartahotel.sispart.tipDocumento.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.apartahotel.sispart.tipDocumento.entity.TipoDocumento;



@Repository
public interface ITipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer> {

	Optional<TipoDocumento> findByTipDocumento(String tipDocumento);

	boolean existsByTipDocumento(String tipDocumento);
}
