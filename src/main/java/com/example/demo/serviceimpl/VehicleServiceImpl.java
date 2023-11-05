package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.module.Vehicle;
import com.example.demo.repo.VehicleRepo;
import com.example.demo.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleRepo repo;

	@Override
	public Vehicle addVehicle(Vehicle v) {
		return repo.save(v);
	}

	@Override
	public Vehicle deleteVehicle(Integer vid) {
		Vehicle v = repo.findById(vid).orElse(null);
		if (v != null) {
			repo.deleteById(vid);
			return v;
		} else {
			throw new ResourceNotFoundException("Vehicle", "Id", vid);
		}

	}

	@Override
	public List<Vehicle> allVehicleDeatails() {
		return repo.displayAllVehicle();
	}

	@Override
	public Vehicle getVehicleById(Integer vid) {
		Vehicle v = repo.findById(vid).orElse(null);
		if (v != null) {
			return v;
		} else {
			throw new ResourceNotFoundException("Vehicle", "Id", vid);
		}

	}

	@Override
	public Vehicle getVehicleBycolor(String color) {
		return repo.findBycolor(color);

	}

	@Override
	public List<Vehicle> allVehicleDeatailsSortByPrice() {
		return repo.displayAllVehicleSortByPrice();

	}

	@Override
	public List<Vehicle> vehiclePriceMoreThan(Double vprice) {
		return repo.findVehicleByMoreThanequalPrice(vprice);
	}

	@Override
	public List<Vehicle> allVehicleDeatailsSortByColorifPriceSame() {
		return repo.allVehicleDeatailsSortByColor();
	}

	@Override
	public Vehicle updateVehicle(Vehicle v) {
		Vehicle v1 = repo.findById(v.getVid()).orElse(null);
		if (v1 != null) {
			v1.setVname(v.getVname());
			v1.setVcolor(v.getVcolor());
			v1.setVprice(v.getVprice());
			v1.setVmodel(v.getVmodel());
			return repo.save(v1);
		} else {
			throw new ResourceNotFoundException("Vehicle", "Id", v.getVid());
		}

	}

}
