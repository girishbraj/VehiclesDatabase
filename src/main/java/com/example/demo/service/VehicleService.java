package com.example.demo.service;

import java.util.List;
import java.util.Set;

import com.example.demo.module.Vehicle;


public interface VehicleService {
Vehicle addVehicle(Vehicle v);
Vehicle deleteVehicle(Integer vid);
List<Vehicle> allVehicleDeatails();
Vehicle getVehicleById(Integer vid);
Vehicle getVehicleBycolor(String color);
List<Vehicle> allVehicleDeatailsSortByPrice();
List<Vehicle> vehiclePriceMoreThan(Double vprice);
List<Vehicle> allVehicleDeatailsSortByColorifPriceSame();
Vehicle updateVehicle(Vehicle v);
}
