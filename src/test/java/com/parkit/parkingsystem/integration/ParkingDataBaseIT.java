package com.parkit.parkingsystem.integration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.parkit.parkingsystem.dao.ParkingSpotDAO;
import com.parkit.parkingsystem.dao.TicketDAO;
import com.parkit.parkingsystem.integration.config.DataBaseTestConfig;
import com.parkit.parkingsystem.integration.service.DataBasePrepareService;
import com.parkit.parkingsystem.service.ParkingService;
import com.parkit.parkingsystem.util.InputReaderUtil;


@ExtendWith(MockitoExtension.class)
public class ParkingDataBaseIT {
	
	private static DataBaseTestConfig dataBaseTestConfig = new DataBaseTestConfig();
    private static ParkingSpotDAO parkingSpotDAO;
    private static TicketDAO ticketDAO;
    
    private static DataBasePrepareService dataBasePrepareService;

    @Mock
    private static InputReaderUtil inputReaderUtil;

    @BeforeAll
    private static void setUp() throws Exception{
        parkingSpotDAO = new ParkingSpotDAO();
        parkingSpotDAO.dataBaseConfig = dataBaseTestConfig;
        ticketDAO = new TicketDAO();

        ticketDAO.dataBaseConfig = dataBaseTestConfig;
        dataBasePrepareService = new DataBasePrepareService();
    }

    @BeforeEach
    private void setUpPerTest() throws Exception {
        when(inputReaderUtil.readSelection()).thenReturn(1);
        when(inputReaderUtil.readVehicleRegistrationNumber()).thenReturn("ABCDEF");
        /*
         * This command cleans all input in DB before each test
         * to make sure is okay
         * However, if you want to test the display of 5% discount
         * you have to deactivate this method
         */
        dataBasePrepareService.clearDataBaseEntries();
    }

    @AfterAll
    private static void tearDown(){

    }

    @Test
    public void testParkingACar() throws Exception{
    //TODO: check that a ticket is currently saved in DB and Parking table is updated with availability
    //GIVEN
    //...
    	
    //WHEN
    ParkingService parkingService = new ParkingService(inputReaderUtil, parkingSpotDAO, ticketDAO);
    parkingService.processIncomingVehicle();   	
        
        
    //THEN
    assertThat(ticketDAO.getTicket(parkingService.getVehichleRegNumber())).isNotNull();
    assertThat(ticketDAO.getTicket(parkingService.getVehichleRegNumber()).getParkingSpot().isAvailable()).isFalse();

    } 
    
    @Test
    public void testParkingLotExit() throws Exception{
    //TODO: check that the fare generated and out time are populated correctly in the database
    //GIVEN
    //...
    	
    //WHEN
    testParkingACar();
    ParkingService parkingService = new ParkingService(inputReaderUtil, parkingSpotDAO, ticketDAO);
    parkingService.processExitingVehicle();
        
        
    //THEN
    assertThat(ticketDAO.getTicket(parkingService.getVehichleRegNumber()).getPrice()).isNotNull();
    assertThat(ticketDAO.getTicket(parkingService.getVehichleRegNumber()).getOutTime()).isNotNull();
        
    }
    
}
