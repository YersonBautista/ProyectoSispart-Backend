package com.proyecto.apartahotel.sispart.checkin.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.apartahotel.sispart.checkin.entity.CheckIn;
import com.proyecto.apartahotel.sispart.huespedes.entity.Huesped;



@Repository
public interface ICheckInRepository extends JpaRepository<CheckIn, Integer> {

	List<CheckIn> findByIdHuesped(int idHuesped);

	boolean existsByIdHuesped(int idHuesped);

	void deleteByIdHuesped(int idHuesped);
}
