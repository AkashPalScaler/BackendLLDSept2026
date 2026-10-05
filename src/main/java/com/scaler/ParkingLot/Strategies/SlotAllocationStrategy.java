package com.scaler.ParkingLot.Strategies;

import com.scaler.ParkingLot.Models.ParkingLot;
import com.scaler.ParkingLot.Models.ParkingSlot;
import com.scaler.ParkingLot.Models.VehicleType;

import java.util.List;

public interface SlotAllocationStrategy {
    public ParkingSlot findAvailableSlot(List<ParkingSlot> parkingSlots, VehicleType vehicleType);
}
