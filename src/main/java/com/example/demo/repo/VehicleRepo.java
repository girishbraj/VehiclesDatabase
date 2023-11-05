package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.module.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {
	
	@Query(value = "select * from Vehicle where vcolor=?1", nativeQuery = true)
	Vehicle findBycolor(String vcolor);
	
	@Query(value = "select * from Vehicle where vprice>=?1", nativeQuery = true)
	List<Vehicle> findVehicleByMoreThanequalPrice(Double vprice);
	
	@Query(value = "select * from Vehicle order by vcolor asc", nativeQuery = true)
	List<Vehicle> allVehicleDeatailsSortByColor();
	
	@Query(value = "select * from Vehicle", nativeQuery = true)
	List<Vehicle> displayAllVehicle();
	
	@Query(value = "select * from Vehicle order by vprice asc", nativeQuery = true)
	List<Vehicle> displayAllVehicleSortByPrice();
	
	@Query(value = "select * from Vehicle order by vprice asc", nativeQuery = true)
	List<Vehicle> displayAllVehicleSortByColorIfPriceSame();
}
	
	

