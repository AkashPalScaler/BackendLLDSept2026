package com.scaler.ParkingLot.Models;

import java.util.Date;
import java.util.UUID;

// 1716320-ashg973801-qwdg72381-1287eq
public class Ticket extends BaseClass {
    String number;
    Date entryTime;
    Gate gate;
    Operator operator;
    ParkingSlot parkingSlot;
    Vehicle vehicle;
    private static Integer count = 0;

    public Ticket() {
        setNumber(String.valueOf(++count)); // Unique number generator
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
