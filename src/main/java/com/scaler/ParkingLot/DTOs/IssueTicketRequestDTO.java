package com.scaler.ParkingLot.DTOs;

import com.scaler.ParkingLot.Models.VehicleType;

public class IssueTicketRequestDTO {
    private Long operatorId;
    private String regNumber;
    private String ownerName;
    private String ownerNumber;
    private VehicleType vehicleType;

    public IssueTicketRequestDTO(Long operatorId, String regNumber, String ownerName, String ownerNumber, VehicleType vehicleType) {
        this.operatorId = operatorId;
        this.regNumber = regNumber;
        this.ownerName = ownerName;
        this.ownerNumber = ownerNumber;
        this.vehicleType = vehicleType;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerNumber() {
        return ownerNumber;
    }

    public void setOwnerNumber(String ownerNumber) {
        this.ownerNumber = ownerNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
