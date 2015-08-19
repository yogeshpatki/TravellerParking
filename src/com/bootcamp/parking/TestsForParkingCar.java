package com.bootcamp.parking;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class TestsForParkingCar {

	@Test
	public void shouldParkACarIfLotIsNotFull() throws ParkingLotFullException, CarAlreadyParkedException{
		Car car = new Car("mh12");
		ParkingLotOwner owner = mock(ParkingLotOwner.class);
		ParkingLot parkingLotA = new ParkingLot(10,owner);
		assertTrue(parkingLotA.park(car) instanceof ParkingTicket);
	}
	
	@Test
	public void shouldUnparkAParkedCar()
			throws ParkingLotFullException, CarAlreadyParkedException, CarNotFoundForGivenTicketException {
		Car car = new Car("mh12");
		ParkingLotOwner owner = mock(ParkingLotOwner.class);
		ParkingLot parkingLotA = new ParkingLot(10,owner);
		
		ParkingTicket parkTicket = parkingLotA.park(car);
		assertEquals(car, parkingLotA.unPark(parkTicket));
	}

	@Test
	public void shouldNotParkSameCarTwice() throws ParkingLotFullException {
		Car car = new Car("mh12");
		ParkingLotOwner owner = mock(ParkingLotOwner.class);
		ParkingLot parkingLotA = new ParkingLot(10,owner);
		try {
			ParkingTicket partTicket = parkingLotA.park(car);
			assertEquals(partTicket, parkingLotA.park(car));
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	@Test
	public void testIfOwnerIsNotifiedWhenLotIsFullOnce() {
		Car car = new Car("mh12");
		ParkingLotOwner owner = mock(ParkingLotOwner.class);
	try{
		ParkingLot parkingLotA = new ParkingLot(1,owner);
		ParkingTicket parkTicket = parkingLotA.park(car);
		parkTicket = parkingLotA.park(car);
		
	}catch(Exception e){
		
		}finally{
			verify(owner , times(1)).attentionRequired();
		}
	}
	
	@Test
	public void testIfSpaceAvailabilityIsNotifiedToOwner(){
		Car car = new Car("mh12");
		ParkingLotOwner owner = mock(ParkingLotOwner.class);
	try{
		ParkingLot parkingLotA = new ParkingLot(1,owner);
		ParkingTicket parkTicket = parkingLotA.park(car);
		parkingLotA.unPark(parkTicket);
					  
	}catch(Exception e){
		
		}finally{
			verify(owner , times(1)).spaceIsNowAvailableInParkingLot();	
		}
	
	}

	@Test
	public void testIfSpaceAvailabilityIsNotifiedToOwnerOnlyOnce(){
		Car car = new Car("mh12");
		Car car2 = new Car("mh13");
		ParkingLotOwner owner = mock(ParkingLotOwner.class);
	try{
		ParkingLot parkingLotA = new ParkingLot(2,owner);
		ParkingTicket parkTicket = parkingLotA.park(car);
		ParkingTicket parkTicket1 = parkingLotA.park(car2);
		parkingLotA.unPark(parkTicket);
		parkingLotA.unPark(parkTicket1);
					  
	}catch(Exception e){
		
		}
	finally{
		verify(owner , times(1)).spaceIsNowAvailableInParkingLot();
	}
	}
}
