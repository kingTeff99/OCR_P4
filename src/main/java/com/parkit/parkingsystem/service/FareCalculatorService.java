package com.parkit.parkingsystem.service;

import com.parkit.parkingsystem.constants.Fare;
import com.parkit.parkingsystem.model.Ticket;

public class FareCalculatorService {

    public void calculateFare(Ticket ticket){
        if( (ticket.getOutTime() == null) || (ticket.getOutTime().before(ticket.getInTime())) ){
            throw new IllegalArgumentException("Out time provided is incorrect:"+ticket.getOutTime().toString());
        }

		long inHours = ticket.getInTime().getTime();

		long outHours = ticket.getOutTime().getTime();

        //TODO: Some tests are failing here. Need to check if this logic is correct
        long duration = outHours - inHours;
        
        //if 30 minutes or less
    	if(duration <= 1800000.0) {
    		ticket.setPrice(0.0);
    	}
//    	else if(recurrentUser) { // S'il est récurrent on lui applique la reduction
//    		switch (ticket.getParkingSpot().getParkingType()){
//            case CAR: {
//            		0.95 * ticket.setPrice((duration / 3600000.0) * Fare.CAR_RATE_PER_HOUR);
//                break;
//            }
//            case BIKE: {
//            		0.95 * ticket.setPrice((duration / 3600000.0) * Fare.BIKE_RATE_PER_HOUR);
//                break;
//            }
//    	}
    	else {
	        switch (ticket.getParkingSpot().getParkingType()){
	            case CAR: {
	            		ticket.setPrice((duration / 3600000.0) * Fare.CAR_RATE_PER_HOUR);
	                break;
	            }
	            case BIKE: {
	            		ticket.setPrice((duration / 3600000.0) * Fare.BIKE_RATE_PER_HOUR);
	                break;
	            }
	            default: throw new IllegalArgumentException("Unkown Parking Type");
	        }
    	}
    }
}