package com.scaler.ParkingLot.Models;

import java.util.Date;

public class Ticket extends BaseModel {
    private String number;
    private Date entry;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getEntry() {
        return entry;
    }

    public void setEntry(Date entry) {
        this.entry = entry;
    }
}
