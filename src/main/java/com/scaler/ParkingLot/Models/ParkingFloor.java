package com.scaler.ParkingLot.Models;

import java.util.List;

public class ParkingFloor extends BaseClass{
    private Integer floor_number;
    private ParkingFloorStatus status;
    private List<ParkingSlot> parkingSlots;
    private List<AllowedVehicle> allowedVehicles; // {BIKE: 20, CAR: 10}

    public ParkingFloor(Integer floor_number, ParkingFloorStatus status) {
        this.floor_number = floor_number;
        this.status = status;
    }

    public Integer getFloor_number() {
        return floor_number;
    }

    public void setFloor_number(Integer floor_number) {
        this.floor_number = floor_number;
    }

    public ParkingFloorStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingFloorStatus status) {
        this.status = status;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public List<AllowedVehicle> getAllowedVehicles() {
        return allowedVehicles;
    }

    public void setAllowedVehicles(List<AllowedVehicle> allowedVehicles) {
        this.allowedVehicles = allowedVehicles;
    }
}
