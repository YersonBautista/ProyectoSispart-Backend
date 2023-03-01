package com.proyecto.apartahotel.sispart.tiposangre.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.proyecto.apartahotel.sispart.tiposangre.entity.TipoSangre;

@Repository
public interface ITipoSangreRepository extends JpaRepository<TipoSangre, Integer> {
	Optional<TipoSangre> findByTipoSangre(String tipSangre);

	boolean existsByTipoSangre(String tipoSangre);
}
