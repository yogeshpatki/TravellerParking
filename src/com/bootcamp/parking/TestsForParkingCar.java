package com.bootcamp.parking;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.HashMap;
import java.util.HashSet;

import org.junit.Test;

public class TestsForParkingCar {

/*	@Test
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
*/
	@Test
	public void testIfOwnerIsNotifiedWhenLotIsFullOnce() {
		Car car = new Car("mh12");
		Car car2 = new Car("mh13");
		int capacity = 2;
		ParkingLotOwner owner = mock(ParkingLotOwner.class);
		NotificationService notService = new NotificationService(new HashMap<Integer, HashSet<Subscriber>>(),new HashMap<Integer, HashSet<Subscriber>>());
		notService.addSubscriber(NotificationCriteria.HALF_FULL,capacity, owner,WhenToNotify.WhenUnParking);
		ParkingLot parkingLotA = new ParkingLot(capacity,owner,notService);
	try{
		
		ParkingTicket parkTicket = parkingLotA.park(car);
		parkTicket = parkingLotA.park(car2);
		parkingLotA.unPark(parkTicket);
		//parkingLotA.unPark(parkTicket);
	
		
	}catch(Exception e){
		
		}finally{
			verify(owner , times(1)).notifySubscriber();		
			}
	}
	
	@Test
	public void testIfSpaceAvailabilityIsNotifiedToOwner(){
		Car car = new Car("mh12");
		Car car2 = new Car("mh13");
		int capacity = 2;
		ParkingLotOwner owner = mock(ParkingLotOwner.class);
		
		NotificationService notService = new NotificationService(new HashMap<Integer, HashSet<Subscriber>>(),new HashMap<Integer, HashSet<Subscriber>>());
		notService.addSubscriber(NotificationCriteria.ALMOST_FULL,capacity, owner,WhenToNotify.WhenUnParking);
		ParkingLot parkingLotA = new ParkingLot(capacity,owner,notService);
	try{
		
		ParkingTicket parkTicket = parkingLotA.park(car);
		parkTicket = parkingLotA.park(car2);
		parkingLotA.unPark(parkTicket);

	}catch(Exception e){
		
		}finally{
			verify(owner , times(1)).notifySubscriber();		
			}
	}

		
	@Test
	public void fbiAgentShouldBeNotifiedWhenParkingLotAlmostFull(){
		FbiAgent fbiAgent = mock(FbiAgent.class);
		Car car = new Car("mh12");
		Car car2 = new Car("mh13");
		Car car3 = new Car("mh14");
		ParkingLotOwner owner = mock(ParkingLotOwner.class);
		NotificationService notifyService = new NotificationService(new HashMap<Integer, HashSet<Subscriber>>(),new HashMap<Integer, HashSet<Subscriber>>());
		notifyService.addSubscriber(NotificationCriteria.ALMOST_FULL,2, fbiAgent,WhenToNotify.WhenParking);
		ParkingLot parkingLotA = new ParkingLot(3,owner,notifyService);
	try{
		
		ParkingTicket parkTicket = parkingLotA.park(car);
		parkTicket = parkingLotA.park(car2);
		parkTicket = parkingLotA.park(car3);
		parkingLotA.unPark(parkTicket);
		
		
	}catch(Exception e){
		
		}finally{
			verify(fbiAgent,times(1)).notifySubscriber();		
			}
	
	}
}
