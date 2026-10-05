package com.scaler.ParkingLot.Strategies;

import com.scaler.ParkingLot.Models.VehicleType;

import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HourlyFeeCalculationStrategy implements FeeCalculationStrategy {
    // CAR - 100, BIKE - 50 , TRUCK - 200
    Map<VehicleType, Double>  feesPerVehicle;
    public HourlyFeeCalculationStrategy() {
        feesPerVehicle = new HashMap<>();
//        feesPerVehicle.put(VehicleType.BIKE, env.get(BIKE_HOURLY_RATE));
        feesPerVehicle.put(VehicleType.BIKE, 50.0);
        feesPerVehicle.put(VehicleType.CAR, 100.0);
        feesPerVehicle.put(VehicleType.TRUCK, 200.0);
    }

    public Double calculateFee(Date entryTime, Date exitTime, VehicleType vehicleType) {
        Long durationInhours = Duration.between(entryTime.toInstant(), exitTime.toInstant()).toHours();
        return feesPerVehicle.get(vehicleType)*durationInhours;
    }
}
