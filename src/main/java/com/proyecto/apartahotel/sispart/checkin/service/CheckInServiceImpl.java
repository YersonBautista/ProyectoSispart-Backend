package com.proyecto.apartahotel.sispart.checkin.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.apartahotel.sispart.checkin.entity.CheckIn;
import com.proyecto.apartahotel.sispart.checkin.repository.ICheckInRepository;
import com.proyecto.apartahotel.sispart.huespedes.entity.Huesped;

@Service
@Transactional
public class CheckInServiceImpl implements ICheckInService {

	@Autowired
	private ICheckInRepository checkInRepository;

	@Override
	public List<CheckIn> findAll() {

		return checkInRepository.findAll();
	}

	@Override
	public List<CheckIn> findByIdHuesped(Huesped idHuesped) {

		return checkInRepository.findByIdHuesped(idHuesped);

	}

	@Override
	public Optional<CheckIn> getOne(int id) {

		return checkInRepository.findById(id);
	}

	@Override
	public Optional<CheckIn> findByIdHuespedAndfechaIngreso(Huesped idHuesped, Date fechaIngreso) {

		return checkInRepository.findByIdHuespedAndFechaIngreso(idHuesped, fechaIngreso);
	}

	@Override
	public void save(CheckIn checkIn) {

		checkInRepository.save(checkIn);

	}

	@Override
	public void delete(int codigoCheckIn) {

		checkInRepository.deleteById(codigoCheckIn);

	}

	@Override
	public boolean existsById(int id) {

		return checkInRepository.existsById(id);
	}

	@Override
	public boolean existsByIdHuesped(Huesped idHuesped) {

		return checkInRepository.existsByIdHuesped(idHuesped);
	}

}
