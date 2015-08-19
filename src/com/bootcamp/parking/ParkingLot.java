package com.bootcamp.parking;

public class ParkingLot {

	private int capacity;
	
	public  ParkingLot(int cap){
		capacity = cap;
	}
	public boolean park(Car car){
		if(capacity>0){
			capacity--;
			return true;
			
		}else 
			return false;
	} 
}
