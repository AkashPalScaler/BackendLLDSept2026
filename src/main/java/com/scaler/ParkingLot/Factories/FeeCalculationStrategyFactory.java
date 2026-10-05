package com.scaler.ParkingLot.Factories;

import com.scaler.ParkingLot.Models.FeeCalculationType;
import com.scaler.ParkingLot.Models.VehicleType;
import com.scaler.ParkingLot.Strategies.FeeCalculationStrategy;
import com.scaler.ParkingLot.Strategies.HourlyFeeCalculationStrategy;

public class FeeCalculationStrategyFactory {
    public static FeeCalculationStrategy getStrategy(FeeCalculationType type) {
        if(type.equals(FeeCalculationType.HOURLY)){
            return new HourlyFeeCalculationStrategy();
        }else{
            throw new IllegalArgumentException("Invalid FeeCalculationType");
        }
    }
}
