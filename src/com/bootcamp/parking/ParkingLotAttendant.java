package com.bootcamp.parking;

import java.util.ArrayList;
import java.util.HashSet;

public class ParkingLotAttendant implements Subscriber {

	private HashSet<ParkingLot> parkingLots = new HashSet<ParkingLot>();
	private ArrayList<ParkingLot> freeParkingLots = new ArrayList<>();

	public void addParkingLot(ParkingLot lot) {
		this.parkingLots.add(lot);
		if(!lot.isParkingLotFull())
			freeParkingLots.add(lot);
	}

	public ParkingLot directToParkingLot() throws NoParkingLotsAvailableException {

		if(freeParkingLots.isEmpty())
		throw new NoParkingLotsAvailableException();
		else
		{
			return freeParkingLots.get(0);
		}
	}

	@Override
	public void notifySubscriber(ParkingLot lot) {
		if(lot.isParkingLotFull())
			freeParkingLots.remove(lot);
		else{
			if(!freeParkingLots.contains(lot))
			freeParkingLots.add(lot);
		}
	}
}
