package com.scaler.ParkingLot.Models;

import java.util.Date;
import java.util.List;

public class Bill extends BaseClass {
    private Integer billNo;
    private Double amount;
    private Date exit_time;
    private List<Payment> payments;
    private Ticket ticket;
    private Operator operator;
    private Gate gate;
    private BillStatus status;
    private static Integer counter = 0;
    public Bill() {
        this.billNo = counter++; // InvoiceGenerator
        this.status = BillStatus.UNPAID;
    }

    public Bill(Integer billNo) {
        this.billNo = billNo;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getExit_time() {
        return exit_time;
    }

    public void setExit_time(Date exit_time) {
        this.exit_time = exit_time;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public BillStatus getStatus() {
        return status;
    }

    public void setStatus(BillStatus status) {
        this.status = status;
    }
}


// Cash - 90 UPI - 10