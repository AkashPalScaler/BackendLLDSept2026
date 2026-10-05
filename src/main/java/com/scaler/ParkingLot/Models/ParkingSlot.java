package com.scaler.ParkingLot.Models;

public class ParkingSlot extends BaseClass {
    private String number;
    private ParkingSlotStatus status;
    private VehicleType vehicleType;

    public ParkingSlot(String number, ParkingSlotStatus status, VehicleType vehicleType) {
        this.number = number;
        this.status = status;
        this.vehicleType = vehicleType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ParkingSlotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingSlotStatus status) {
        this.status = status;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
