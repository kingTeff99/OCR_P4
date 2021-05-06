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
    	} else {
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
	     /*
	      * Application of 5% discount on normal fare
	      */
	     if(ticket.isRecurrentUser() == true) {
	        ticket.setPrice(ticket.getPrice() * Fare.DISCOUNT_FOR_RECURRENT_USER);
	      }
    	}
 }
