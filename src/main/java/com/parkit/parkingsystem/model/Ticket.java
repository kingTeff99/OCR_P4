package com.parkit.parkingsystem.model;

import java.util.Date;

public class Ticket {
    private int id;
    private ParkingSpot parkingSpot;
    private String vehicleRegNumber;
    private double price;
    private Date inTime;
    private Date outTime;
    private boolean recurrentUser;

//    public Ticket() {
//    	super();
//		this.id = id;
//		this.parkingSpot = parkingSpot;
//		this.vehicleRegNumber = vehicleRegNumber;
//		this.price = price;
//		this.inTime = inTime;
//		this.outTime = outTime;
//		this.recurrentUser = recurrentUser;
//	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public String getVehicleRegNumber() {
        return vehicleRegNumber;
    }

    public void setVehicleRegNumber(String vehicleRegNumber) {
        this.vehicleRegNumber = vehicleRegNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime2) {
        this.inTime = inTime2;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime2) {
        this.outTime = outTime2;
    }

	public boolean isRecurrentUser() {
		return recurrentUser;
	}

	public void setRecurrentUser(boolean recurrentUser) {
		this.recurrentUser = recurrentUser;
	}
}
