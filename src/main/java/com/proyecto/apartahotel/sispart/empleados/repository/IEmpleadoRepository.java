package com.proyecto.apartahotel.sispart.empleados.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.apartahotel.sispart.empleados.entity.Empleado;
import com.proyecto.apartahotel.sispart.tipDocumento.entity.TipoDocumento;

;

@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer> {

	Optional<Empleado> findByIdTipoDocumentoAndNumDocumento(TipoDocumento idTipoDocumento,int numDocumento);

	boolean existsByIdTipoDocumentoAndNumDocumento(TipoDocumento idTipoDocumento,int numDocumento);

	void deleteByNumDocumento(int numDocumento);

}
