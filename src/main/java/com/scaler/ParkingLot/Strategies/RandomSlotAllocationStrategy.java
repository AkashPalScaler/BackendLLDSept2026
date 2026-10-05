package com.scaler.ParkingLot.Strategies;

import com.scaler.ParkingLot.Models.ParkingSlot;
import com.scaler.ParkingLot.Models.ParkingSlotStatus;
import com.scaler.ParkingLot.Models.VehicleType;

import java.util.List;

public class RandomSlotAllocationStrategy implements SlotAllocationStrategy {
    @Override
    public ParkingSlot findAvailableSlot(List<ParkingSlot> parkingSlots, VehicleType vehicleType) {
        for(ParkingSlot slot : parkingSlots){
            System.out.println(slot.getStatus() + " " + slot.getVehicleType() + " " + vehicleType);
            if(slot.getStatus().equals(ParkingSlotStatus.EMPTY) && slot.getVehicleType().equals(vehicleType)){
                return slot;
            }
        }
        return null;
    }
}
