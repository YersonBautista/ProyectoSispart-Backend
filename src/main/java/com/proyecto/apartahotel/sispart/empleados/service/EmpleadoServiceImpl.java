package com.proyecto.apartahotel.sispart.empleados.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.apartahotel.sispart.empleados.entity.Empleado;
import com.proyecto.apartahotel.sispart.empleados.repository.IEmpleadoRepository;
import com.proyecto.apartahotel.sispart.tipDocumento.entity.TipoDocumento;

@Service
@Transactional
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	private IEmpleadoRepository empleadoRepository;

	@Override
	public List<Empleado> findAll() {

		return empleadoRepository.findAll();
	}

	@Override
	public Optional<Empleado> getOne(int id) {

		return empleadoRepository.findById(id);
	}

	@Override
	public Optional<Empleado> getByIdTipoDocumentoAndNumDocumento(TipoDocumento idTipoDocumento, int numDocumento) {

		return empleadoRepository.findByIdTipoDocumentoAndNumDocumento(idTipoDocumento, numDocumento);
	}

	@Override
	public void save(Empleado empleado) {
		empleadoRepository.save(empleado);
	}

	@Override
	public void delete(int idEmpleado) {
		empleadoRepository.deleteById(idEmpleado);
		;
	}

	@Override
	public boolean existsById(int id) {

		return empleadoRepository.existsById(id);
	}

	@Override
	public boolean existsByIdTipoDocumentoAndNumDocumento(TipoDocumento idTipoDocumento, int numDocumento) {

		return empleadoRepository.existsByIdTipoDocumentoAndNumDocumento(idTipoDocumento, numDocumento);
	}

}
