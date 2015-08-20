package com.bootcamp.parking;

import java.util.HashMap;

public class ParkingLot {

	private final int capacity;

	private HashMap<ParkingTicket, Car> cars = new HashMap<ParkingTicket, Car>();
	private NotificationService notificationService;
	private ParkingLotOwner parkingLotOwner;

	public ParkingLot(int cap, ParkingLotOwner owner, NotificationService notificationService) {
		this.capacity = cap;
		this.parkingLotOwner = owner;
		this.notificationService = notificationService;
	}
	public ParkingLot(int cap, ParkingLotOwner owner) {
		this.capacity = cap;
		this.parkingLotOwner = owner;
		
	}

	public boolean isParkingLotFull() {

		if (cars.size() < capacity)
			return false;
		else
			return true;
	}

	public ParkingTicket park(Car car) throws ParkingLotFullException, CarAlreadyParkedException {
		if (!isParkingLotFull()) {
			if (carAlreadyParked(car))
				throw new CarAlreadyParkedException("Car Is Already Parked");
			else {
				ParkingTicket parkTicket = new ParkingTicket();
				cars.put(parkTicket, car);
				notificationService.notifyWhenParking(cars.size(),this);
				return parkTicket;
			}
		} else {
			throw new ParkingLotFullException("Parking Lot Is Full");
		}
	}

	public Car unPark(ParkingTicket parkTicket) throws CarNotFoundForGivenTicketException {

		if (cars.containsKey(parkTicket)) {
			Car car =  cars.remove(parkTicket);
			notificationService.notifyWhenUnparking(cars.size(),this);
			return car;
		} else
			throw new CarNotFoundForGivenTicketException("Invalid Ticket.");
	}

	private boolean carAlreadyParked(Car car) {
		if (cars.keySet() != null) {
			for (ParkingTicket parkTicket : cars.keySet()) {
				if (cars.get(parkTicket).equals(car)) {
					return true;
				}
			}
			return false;
		} else
			return false;

	}

}
