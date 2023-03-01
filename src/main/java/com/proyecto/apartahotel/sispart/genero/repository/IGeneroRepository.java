package com.proyecto.apartahotel.sispart.genero.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.apartahotel.sispart.genero.entity.Genero;

@Repository
public interface IGeneroRepository extends JpaRepository<Genero, Integer> {

	Optional<Genero> findBySexoBio(String sexoBio);

	boolean existsBySexoBio(String sexoBio);
}
