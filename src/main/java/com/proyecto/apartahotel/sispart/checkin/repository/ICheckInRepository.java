package com.proyecto.apartahotel.sispart.checkin.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.apartahotel.sispart.checkin.entity.CheckIn;
import com.proyecto.apartahotel.sispart.huespedes.entity.Huesped;

@Repository
public interface ICheckInRepository extends JpaRepository<CheckIn, Integer> {

	List<CheckIn> findByIdHuesped(Huesped idHuesped);

	Optional<CheckIn> findByIdHuespedAndFechaIngreso(Huesped idHuesped, Date fechaIngreso);

	void deleteByIdHuesped(Huesped idHuesped);

	boolean existsByIdHuesped(Huesped idHuesped);
}
