package com.bootcamp.parking;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestsForParkingCar {

	@Test
	public void shouldParkSucessfullyIfLotIsNotFull(){
		Car car=new Car();
		ParkingLot parkingLotA= new ParkingLot(10);
		ParkingLot parkingLotB= new ParkingLot(0);
		assertEquals(true,parkingLotA.park(car));
		assertEquals(false,parkingLotB.park(car));
	}
	
	
	
}
