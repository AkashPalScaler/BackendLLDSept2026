package com.scaler.ParkingLot;

import com.scaler.ParkingLot.Controllers.TicketController;
import com.scaler.ParkingLot.DTOs.IssueTicketRequestDTO;
import com.scaler.ParkingLot.DTOs.IssueTicketResponseDTO;
import com.scaler.ParkingLot.Models.*;
import com.scaler.ParkingLot.Repositories.InMemoryRepository;
import com.scaler.ParkingLot.Services.TicketService;
import com.scaler.ParkingLot.Services.VehicleService;

public class Client {
    public static void main(String[] args) {
        InMemoryRepository<Operator> operatorRepository = new InMemoryRepository<>();
        InMemoryRepository<ParkingSlot> parkingSlotRepository= new InMemoryRepository<>();;
        InMemoryRepository<Gate> gateRepository= new InMemoryRepository<>();;
        InMemoryRepository<ParkingLot> parkingLotRepository= new InMemoryRepository<>();;
        InMemoryRepository<ParkingFloor> parkingFloorRepository= new InMemoryRepository<>();;
        InMemoryRepository<AllowedVehicle> allowedVehicleRepository= new InMemoryRepository<>();
        InMemoryRepository<Ticket> ticketRepository= new InMemoryRepository<>();
        InMemoryRepository<Vehicle> vehicleRepository= new InMemoryRepository<>();

        DataGenerator dataGenerator = new DataGenerator(operatorRepository, parkingSlotRepository, gateRepository, parkingLotRepository, parkingFloorRepository, allowedVehicleRepository);

        dataGenerator.generateData();
        VehicleService vehicleService = new VehicleService(vehicleRepository);
        TicketService ticketService = new TicketService(operatorRepository, parkingSlotRepository, ticketRepository, vehicleService);
        TicketController controller =new TicketController(ticketService);

        IssueTicketRequestDTO requestDTO = new IssueTicketRequestDTO(5L, "12312", "Akas", "090872823312", VehicleType.BIKE);

        IssueTicketResponseDTO responseDTO = controller.issueTicket(requestDTO);
        System.out.println(responseDTO.getMessage() + " | Ticket Id:"+ responseDTO.getTicketNumber());

        requestDTO = new IssueTicketRequestDTO(5L, "12342", "Akashpal", "090872823312", VehicleType.BIKE);
        responseDTO = controller.issueTicket(requestDTO);
        System.out.println(responseDTO.getMessage() + " | Ticket Id:"+ responseDTO.getTicketNumber());

        requestDTO = new IssueTicketRequestDTO(5L, "12343", "Sam", "090872823312", VehicleType.BIKE);
        responseDTO = controller.issueTicket(requestDTO);
        System.out.println(responseDTO.getMessage() + " | Ticket Id:"+ responseDTO.getTicketNumber());
    }
}
