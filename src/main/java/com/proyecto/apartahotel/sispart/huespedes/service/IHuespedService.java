package com.proyecto.apartahotel.sispart.huespedes.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.apartahotel.sispart.huespedes.entity.Huesped;
import com.proyecto.apartahotel.sispart.tipDocumento.entity.TipoDocumento;

public interface IHuespedService {

	public List<Huesped> findAll();

	public Optional<Huesped> getOne(int id);

	public Optional<Huesped> getByIdTipoDocumentoAndNumDocumento(TipoDocumento idTipoDocumento, Long numDocumento);

	public Optional<Huesped> getByIdTipoDocumento(TipoDocumento idTipoDocumento);

	public boolean existsByIdTipoDocumento(TipoDocumento idTipoDocumento);

	public void save(Huesped huesped);

	public void deleteByIdTipoDocumentoNumDocumento(TipoDocumento idTipoDocumento, Long numDocumento);

	public boolean existsById(int id);

	public boolean existsByIdTipoDocumentoAndNumDocumento(TipoDocumento idTipoDocumento, Long numDocumento);

}
