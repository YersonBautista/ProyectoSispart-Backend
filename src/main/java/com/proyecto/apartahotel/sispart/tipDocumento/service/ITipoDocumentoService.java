package com.proyecto.apartahotel.sispart.tipDocumento.service;


import java.util.List;
import java.util.Optional;

import com.proyecto.apartahotel.sispart.tipDocumento.entity.TipoDocumento;



public interface ITipoDocumentoService {

	public List<TipoDocumento> findAll();

	public Optional<TipoDocumento> getOne(int id);

	public Optional<TipoDocumento> getByTipDocumento(String tipDocumento);

	public void save(TipoDocumento tipDocumento);

	public void delete(int id);

	public boolean existsById(int id);

	public boolean existsByTipDocumento(String tipDocumento);

}
