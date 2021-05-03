package com.parkit.parkingsystem.constants;

public class DBConstants {
	
	/**
     * The constant GET_NEXT_PARKING_SPOT.
     */
    public static final String GET_NEXT_PARKING_SPOT = "select min(PARKING_NUMBER) from parking where AVAILABLE = true and TYPE = ?";
    /**
     * The constant UPDATE_PARKING_SPOT.
     */
    public static final String UPDATE_PARKING_SPOT = "update parking set available = ? where PARKING_NUMBER = ?";
    /**
     * The constant SAVE_TICKET.
     */
    public static final String SAVE_TICKET = "insert into ticket(PARKING_NUMBER, VEHICLE_REG_NUMBER, PRICE, IN_TIME, OUT_TIME, RECURRENT_USER) values(?,?,?,?,?,?)";
    /**
     * The constant UPDATE_TICKET .
     */
    public static final String UPDATE_TICKET = "update ticket set PRICE=?, OUT_TIME=? where ID=?";
    /**
     * The constant GET_TICKET.
     */
    public static final String GET_TICKET = "select t.PARKING_NUMBER, t.ID, t.PRICE, t.IN_TIME, t.OUT_TIME, p.TYPE from ticket t,parking p where p.parking_number = t.parking_number and t.VEHICLE_REG_NUMBER=? order by t.IN_TIME  limit 1";
    /**
     * The constant OLD_TICKETS.A Utiliser pour la reduction de 5%.
     */
    public static final String OLD_TICKETS = "select count(*) as nbVisitsUser from ticket where VEHICLE_REG_NUMBER=? and OUT_TIME is not null";

}


