package com.proyecto.apartahotel.sispart.checkin.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.apartahotel.sispart.checkin.entity.CheckIn;
import com.proyecto.apartahotel.sispart.huespedes.entity.Huesped;



public interface ICheckInService {

	public List<CheckIn> findAll();

	public List<CheckIn> findByIdHuesped(int idHuesped);

	public Optional<CheckIn> getOne(int id);

	public void save(CheckIn checkIn);

	public void delete(int codigoCheckIn);

	public boolean existsById(int id);

	public boolean existsByIdHuesped(int idHuesped);

}
