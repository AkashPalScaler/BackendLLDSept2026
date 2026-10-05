package com.scaler.ParkingLot.Models;

public class AllowedVehicle extends  BaseClass{
    VehicleType type; // CAR
    Integer capacity; // 20

    public AllowedVehicle(VehicleType type, Integer capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
