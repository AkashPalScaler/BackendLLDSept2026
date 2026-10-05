package com.scaler.ParkingLot.Models;

public class Vehicle extends BaseClass{
    private String reg_number;
    private String owner_name;
    private String owner_contact;
    private VehicleType vehicleType;

    public Vehicle(String reg_number, String owner_name, String owner_contact, VehicleType vehicleType) {
        this.reg_number = reg_number;
        this.owner_name = owner_name;
        this.owner_contact = owner_contact;
        this.vehicleType = vehicleType;
    }

    public String getReg_number() {
        return reg_number;
    }

    public void setReg_number(String reg_number) {
        this.reg_number = reg_number;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getOwner_contact() {
        return owner_contact;
    }

    public void setOwner_contact(String owner_contact) {
        this.owner_contact = owner_contact;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
