package com.proyecto.apartahotel.sispart.nacionalidad.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.apartahotel.sispart.nacionalidad.entity.Nacionalidad;


public interface INacionalidadRepository extends JpaRepository<Nacionalidad, Integer> {

	Optional<Nacionalidad> findByNombre(String nombre);

	boolean existsByNombre(String nombre);

}
