package com.scaler.ParkingLot.Services;

import com.scaler.ParkingLot.Factories.SlotAllocationStrategyFactory;
import com.scaler.ParkingLot.Models.*;
import com.scaler.ParkingLot.Repositories.InMemoryRepository;

import java.util.Date;
import java.util.List;

public class TicketService {
    InMemoryRepository<Operator> operatorRepository;
    InMemoryRepository<ParkingSlot> parkingSlotRepository;
    InMemoryRepository<Ticket> ticketRepository;
    VehicleService vehicleService;

    public TicketService(InMemoryRepository<Operator> operatorRepository, InMemoryRepository<ParkingSlot> parkingSlotRepository, InMemoryRepository<Ticket> ticketRepository, VehicleService vehicleService) {
        this.operatorRepository = operatorRepository;
        this.parkingSlotRepository = parkingSlotRepository;
        this.ticketRepository = ticketRepository;
        this.vehicleService = vehicleService;
    }

    public Ticket issueTicket(Long operatorId, String regNumber, String ownerName, String ownerNumber, VehicleType vehicleType){
        // TODO: Creating ticket logic goes here
        // Fetch the operator from Id
        // Check if operator exists
        Operator operator = operatorRepository.getById(operatorId); // Optional - HW -  Update the findById function to return an Optional<T>
        if(operator == null) throw new RuntimeException("Operator not found");

        // Fetch the gate from the operator
        // Check if gate exists & gate should be an entry gate and should be operational and open
        Gate gate = operator.getGate();
        if(gate == null) throw new RuntimeException("Gate not found");
        if(gate.getType().equals(GateType.EXIT)) throw new IllegalArgumentException("Invalid gate for ticket creation");
        // HW - Add the gate status check

        // Find or create a vehicle
        Vehicle vehicle = vehicleService.findOrCreate(regNumber, ownerName, ownerNumber, vehicleType);

        // Fetch parking lot from gate
        ParkingLot parkingLot = gate.getParkingLot();
        // HW - Before fetching all slots, you can loop through floors and rule out the ones which has not allowedVehicle capacity left(filled for the given vehicle type)

        // Fetch all slots
        List<ParkingSlot> allParkingSlots = parkingSlotRepository.findAll();  // findAllByParkingLotAndVehicleType

        // Available slot - SlotAllocationStrategy - ParkingLot
        ParkingSlot availableSlot = SlotAllocationStrategyFactory
                .getStrategy(parkingLot.getSlot_allocation_type())
                .findAvailableSlot(allParkingSlots, vehicle.getVehicleType());
        if(availableSlot == null){
            throw new RuntimeException("Slot not available");
        }
        // Update the available slot to filled
        availableSlot.setStatus(ParkingSlotStatus.FILLED);
        availableSlot = parkingSlotRepository.save(availableSlot);

        // Create and return a ticket
        Ticket ticket = new Ticket();
        ticket.setParkingSlot(availableSlot);
        ticket.setGate(gate);
        ticket.setVehicle(vehicle);
        ticket.setOperator(operator);
        ticket.setEntryTime(new Date());
        return ticketRepository.save(ticket);
    }
}

// operator -  id | name | etc... | gateId  (We have to query gate table with gateID)
// ORM handles it - id | name | etc... | gateId(makes an internal call to gate table and also fetches to gate object and populates operator object)
