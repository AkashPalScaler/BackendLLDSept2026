package com.scaler.ParkingLot.Services;

import com.scaler.ParkingLot.Models.Vehicle;
import com.scaler.ParkingLot.Models.VehicleType;
import com.scaler.ParkingLot.Repositories.InMemoryRepository;

import java.util.List;

public class VehicleService {
    InMemoryRepository<Vehicle> vehicleRepository;
    public VehicleService(InMemoryRepository<Vehicle> vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }
    public Vehicle findOrCreate(String regNumber, String ownerName, String ownerNumber, VehicleType vehicleType) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        for(Vehicle vehicle : vehicles){
            if(vehicle.getReg_number().equals(regNumber)){
                return  vehicle;
            }
        }
        Vehicle vehicle = new Vehicle(regNumber, ownerName, ownerNumber, vehicleType);
        return vehicleRepository.save(vehicle);
    }
}
