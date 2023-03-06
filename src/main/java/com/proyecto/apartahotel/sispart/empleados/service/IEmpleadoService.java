package com.proyecto.apartahotel.sispart.empleados.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.apartahotel.sispart.empleados.entity.Empleado;
import com.proyecto.apartahotel.sispart.tipDocumento.entity.TipoDocumento;

public interface IEmpleadoService {

	public List<Empleado> findAll();

	public Optional<Empleado> getOne(int idEmpleado);

	public Optional<Empleado> getByIdTipoDocumentoAndNumDocumento(TipoDocumento idTipoDocumento,Long numDocumento);

	public void save(Empleado empleado);

	public void delete(int idEmpelado);

	public boolean existsById(int idEmpleado);

	public boolean existsByIdTipoDocumentoAndNumDocumento(TipoDocumento idTipoDocumento,Long numDocumento);

}
