package com.scaler.ParkingLot.Strategies;

import com.scaler.ParkingLot.Models.ParkingLot;
import com.scaler.ParkingLot.Models.VehicleType;

import java.util.Date;

public interface FeeCalculationStrategy {
    public Double calculateFee(Date entryTime, Date exitTime, VehicleType vehicleType);
}
