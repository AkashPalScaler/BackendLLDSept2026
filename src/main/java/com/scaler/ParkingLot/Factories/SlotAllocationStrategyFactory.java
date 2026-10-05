package com.scaler.ParkingLot.Factories;

import com.scaler.ParkingLot.Models.ParkingLot;
import com.scaler.ParkingLot.Models.SlotAllocationType;
import com.scaler.ParkingLot.Strategies.RandomSlotAllocationStrategy;
import com.scaler.ParkingLot.Strategies.SlotAllocationStrategy;

public class SlotAllocationStrategyFactory {
    public static SlotAllocationStrategy getStrategy(SlotAllocationType type) {
        if(type.equals(SlotAllocationType.RANDOM)){
            return new RandomSlotAllocationStrategy();
        }else{
            throw new  IllegalArgumentException("Invalid SlotAllocationType");
        }
    }
}
