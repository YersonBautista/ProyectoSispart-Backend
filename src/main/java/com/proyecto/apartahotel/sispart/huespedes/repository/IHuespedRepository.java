package com.proyecto.apartahotel.sispart.huespedes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.apartahotel.sispart.huespedes.entity.Huesped;
import com.proyecto.apartahotel.sispart.tipDocumento.entity.TipoDocumento;

@Repository
public interface IHuespedRepository extends JpaRepository<Huesped, Integer> {

	Optional<Huesped> findByIdTipoDocumentoAndNumDocumento(TipoDocumento idTipoDocumento, Long numDocumento);

	Optional<Huesped> findByIdTipoDocumento(TipoDocumento idTipoDocumento);

	boolean existsByIdTipoDocumento(TipoDocumento idtipoDocumento);

	boolean existsByIdTipoDocumentoAndNumDocumento(TipoDocumento idTipoDocumento, Long numDocumento);

	void deleteByIdTipoDocumentoAndNumDocumento(TipoDocumento idTipoDocumento, Long numDocumento);

}
