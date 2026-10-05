package com.scaler.ParkingLot.Services;

import com.scaler.ParkingLot.Factories.FeeCalculationStrategyFactory;
import com.scaler.ParkingLot.Models.*;
import com.scaler.ParkingLot.Repositories.InMemoryRepository;

import java.util.Date;

public class BillService {
    InMemoryRepository<Operator> operatorRepository;
    InMemoryRepository<Bill>  billRepository;
    InMemoryRepository<Ticket> ticketRepository;

    public BillService(InMemoryRepository<Operator> operatorRepository, InMemoryRepository<Bill> billRepository, InMemoryRepository<Ticket> ticketRepository) {
        this.operatorRepository = operatorRepository;
        this.billRepository = billRepository;
        this.ticketRepository = ticketRepository;
    }

    public Bill createBill(Long ticketId, Long operatorId){
        // Fetch the operator and do validations
        Operator operator = operatorRepository.getById(operatorId);
        if(operator == null) throw new RuntimeException("Operator not found");
        // Fetch the gate and do validations
        Gate gate = operator.getGate();
        if(gate == null) throw new RuntimeException("Gate not found");
        // Fetch the ticket
        Ticket ticket = ticketRepository.getById(ticketId);
        if(ticket == null) throw new RuntimeException("Ticket not found");

        // Calculate the fee amount
        ParkingLot  parkingLot  = gate.getParkingLot();
        if(parkingLot == null) throw new RuntimeException("ParkingLot not found");

        Date exitTime = new Date();
        Double amount = FeeCalculationStrategyFactory.getStrategy(parkingLot.getFee_calculation_type())
                .calculateFee(ticket.getEntryTime(), exitTime, ticket.getVehicle().getVehicleType());

        // Create and return the bill
        Bill bill = new Bill();
        bill.setOperator(operator);
        bill.setGate(gate);
        bill.setTicket(ticket);
        bill.setAmount(amount);
        bill.setExit_time(exitTime);
        return billRepository.save(bill);

    }
}