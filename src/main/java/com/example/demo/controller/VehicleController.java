package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.module.Vehicle;
import com.example.demo.service.VehicleService;

import jakarta.persistence.criteria.CriteriaBuilder.In;
import jakarta.servlet.http.HttpSession;

@RestController
public class VehicleController {
	@Autowired
	VehicleService service;

	// localhost:8080/addVehicle
	@PostMapping("/addVehicle")
	ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle v) {
		return new ResponseEntity<Vehicle>(service.addVehicle(v), HttpStatus.CREATED);
	}

	// localhost:8080/deleteVehicle 
	@DeleteMapping("/deleteVehicle")
	ResponseEntity<Vehicle> deleteVehicle(@RequestParam Integer vid) {
		return new ResponseEntity<Vehicle>(service.deleteVehicle(vid), HttpStatus.OK);
	}

	// localhost:8080/allVehicleDetails 
	@GetMapping("/allVehicleDetails")
	ResponseEntity<List<Vehicle>> allVehicleDetails() {
		return new ResponseEntity<List<Vehicle>>(service.allVehicleDeatails(),HttpStatus.FOUND);
	}

	// localhost:8080/getVehicleById
	@GetMapping("/getVehicleById")
	ResponseEntity<Vehicle> getVehicleByID(@RequestHeader Integer vid) {
		return new ResponseEntity<Vehicle>(service.getVehicleById(vid), HttpStatus.FOUND);
	}

	// localhost:8080/getVehicleByColorIfPriceSame
	@GetMapping("/getVehicleByColorIfPriceSame")
	ResponseEntity<List<Vehicle>> getAllVehicleDeatailsSortByColor() {
		return new ResponseEntity<List<Vehicle>>(service.allVehicleDeatailsSortByColorifPriceSame(),HttpStatus.FOUND);
	}

	// localhost:8080/getAllVehicleSortByPrice
	@GetMapping("/getAllVehicleSortByPrice")
	ResponseEntity<List<Vehicle>> getallVehicleSortByPrice() {
		return new ResponseEntity<List<Vehicle>>(service.allVehicleDeatailsSortByPrice(),HttpStatus.FOUND);
	}

	// localhost:8080/displayVehiclePriceMoreThanEqual
	@GetMapping("/displayVehiclePriceMoreThanEqual")
	ResponseEntity<List<Vehicle>> vehiclePriceMoreThanOrEqual(@RequestHeader Double vprice) {
		return new ResponseEntity<List<Vehicle>>(service.vehiclePriceMoreThan(vprice), HttpStatus.FOUND);
	}

	
	@PutMapping("/updateVehicle")
	ResponseEntity<Vehicle> upadteVehicle(@RequestBody Vehicle v) {
		return new ResponseEntity<Vehicle>(service.updateVehicle(v), HttpStatus.OK);
	}

}
