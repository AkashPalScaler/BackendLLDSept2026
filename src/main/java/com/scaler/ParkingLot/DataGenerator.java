package com.scaler.ParkingLot;

import com.scaler.ParkingLot.Models.*;
import com.scaler.ParkingLot.Repositories.InMemoryRepository;

import java.util.List;

public class DataGenerator {
    InMemoryRepository<Operator> operatorRepository;
    InMemoryRepository<ParkingSlot> parkingSlotRepository;
    InMemoryRepository<Gate> gateRepository;
    InMemoryRepository<ParkingLot> parkingLotRepository;
    InMemoryRepository<ParkingFloor> parkingFloorRepository;
    InMemoryRepository<AllowedVehicle> allowedVehicleRepository;

    public DataGenerator(InMemoryRepository<Operator> operatorRepository, InMemoryRepository<ParkingSlot> parkingSlotRepository, InMemoryRepository<Gate> gateRepository, InMemoryRepository<ParkingLot> parkingLotRepository, InMemoryRepository<ParkingFloor> parkingFloorRepository, InMemoryRepository<AllowedVehicle> allowedVehicleRepository) {
        this.operatorRepository = operatorRepository;
        this.parkingSlotRepository = parkingSlotRepository;
        this.gateRepository = gateRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.parkingFloorRepository = parkingFloorRepository;
        this.allowedVehicleRepository = allowedVehicleRepository;
    }

    public void generateData(){
        // 1 parking lot
        ParkingLot parkingLot = new ParkingLot("Phoenix", FeeCalculationType.HOURLY, SlotAllocationType.RANDOM);

        // 2 parking floors
        ParkingFloor parkingFloor1 = new ParkingFloor(1, ParkingFloorStatus.EMPTY);

        parkingFloor1.setAllowedVehicles(null);

        ParkingFloor parkingFloor2 = new ParkingFloor(2, ParkingFloorStatus.EMPTY);

        parkingFloor2.setAllowedVehicles(null);

        // 4 parking slots
        ParkingSlot parkingSlot1A = new ParkingSlot("1A", ParkingSlotStatus.EMPTY, VehicleType.BIKE);
        parkingSlotRepository.save(parkingSlot1A);
        ParkingSlot parkingSlot1B = new ParkingSlot("1B", ParkingSlotStatus.EMPTY, VehicleType.CAR);
        parkingSlotRepository.save(parkingSlot1B);
        ParkingSlot parkingSlot2A = new ParkingSlot("2A", ParkingSlotStatus.EMPTY, VehicleType.BIKE);
        parkingSlotRepository.save(parkingSlot2A);
        ParkingSlot parkingSlot2B = new ParkingSlot("2B", ParkingSlotStatus.EMPTY, VehicleType.CAR);
        parkingSlotRepository.save(parkingSlot2B);

        // 2 gates
        Gate entry = new Gate(1, GateType.ENTRY, GateStatus.OPEN);
        entry.setParkingLot(parkingLot);

        Gate exit = new Gate(2, GateType.EXIT, GateStatus.OPEN);
        exit.setParkingLot(parkingLot);


        // 2 operators
        Operator op1 = new Operator("OpName1", "10387128");
        op1.setGate(entry);
        operatorRepository.save(op1);
        System.out.println("Operator 1 id : " + op1.getId());
        Operator op2 = new Operator("OpName2", "10387129");
        op2.setGate(exit);
        operatorRepository.save(op2);
        System.out.println("Operator 2 id : " + op2.getId());


        // Some AllowedVehicles
        AllowedVehicle allowedVehicleParkingLotCar = new AllowedVehicle(VehicleType.CAR, 2);
        AllowedVehicle allowedVehicleParkingLotBike = new AllowedVehicle(VehicleType.BIKE, 2);


        parkingLot.setFloors(List.of(parkingFloor1, parkingFloor2));
        parkingLot.setAllowed_vehicles(List.of(allowedVehicleParkingLotCar, allowedVehicleParkingLotBike));
        parkingLot.setExit_gates(List.of(exit));
        parkingLot.setEntry_gates(List.of(entry));
        parkingLotRepository.save(parkingLot);

        parkingFloor1.setParkingSlots(List.of(parkingSlot1A, parkingSlot1B));
        parkingFloorRepository.save(parkingFloor1);

        parkingFloor2.setParkingSlots(List.of(parkingSlot2A, parkingSlot2B));
        parkingFloorRepository.save(parkingFloor2);

        entry.setOperator(op1);
        gateRepository.save(entry);

        exit.setOperator(op2);
        gateRepository.save(exit);
    }

}
