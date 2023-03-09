package com.proyecto.apartahotel.sispart.facturacion.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.apartahotel.sispart.facturacion.entity.TipoDocLegal;




public interface ITipoDocLegalesService {
	
	public List<TipoDocLegal> findAll();

	public Optional<TipoDocLegal> getOne(int idTipoDocLegal);

	public void save(TipoDocLegal tipoDocLegal);

	public void delete (int idTipoDocLegal);

	public boolean existsById(int idTipoDocLegal);

}
