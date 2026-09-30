package com.scaler.ParkingLot.Controllers;

import com.scaler.ParkingLot.DTOs.IssueTicketRequestDTO;
import com.scaler.ParkingLot.DTOs.IssueTicketResponseDTO;
import com.scaler.ParkingLot.DTOs.ResponseStatus;
import com.scaler.ParkingLot.Models.Ticket;
import com.scaler.ParkingLot.Models.Vehicle;
import com.scaler.ParkingLot.Models.VehicleType;
import com.scaler.ParkingLot.Services.TicketService;

public class TicketController {
    TicketService ticketService;
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }
    IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO requestDTO){
        IssueTicketResponseDTO responseDTO = new IssueTicketResponseDTO();
        try{
            // Input Validation on the request DTO
            Ticket ticket = ticketService.issueTicket(
                    requestDTO.getOperatorId(),
                    requestDTO.getRegNumber(),
                    requestDTO.getOwnerName(),
                    requestDTO.getOwnerNumber(),
                    requestDTO.getVehicleType());

            responseDTO.setTicketId(ticket.getId());
            responseDTO.setTicketNumber(ticket.getNumber());
            responseDTO.setEntryTime(ticket.getEntry());
            responseDTO.setMessage("Ticket issued successfully!");
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);

        }catch (Exception e){
            System.out.println("Error in issuing ticket : " + e.getMessage());
            e.printStackTrace();
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage(e.getMessage());
        }

        return responseDTO;
    }
}
