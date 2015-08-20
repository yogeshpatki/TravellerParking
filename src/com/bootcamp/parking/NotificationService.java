package com.bootcamp.parking;

import java.util.HashMap;
import java.util.HashSet;

public class NotificationService {

	HashMap<Integer, HashSet<Subscriber>> subscribersForParking = new HashMap<Integer, HashSet<Subscriber>>();
	HashMap<Integer, HashSet<Subscriber>> subscribersForUnParking = new HashMap<Integer, HashSet<Subscriber>>();

	public NotificationService(HashMap<Integer, HashSet<Subscriber>> subscribersForParking,HashMap<Integer, HashSet<Subscriber>> subscribersForUnParking) {
		this.subscribersForParking = subscribersForParking;
		this.subscribersForUnParking = subscribersForUnParking;
	}

	public void notifyWhenParking(Integer occupiedSize,ParkingLot lot) {
	
			HashSet<Subscriber> subscribersToNotify = subscribersForParking.get(occupiedSize);
			if (subscribersToNotify != null) {
				for (Subscriber subscriber : subscribersToNotify) {
					System.out.println(subscriber.toString());
					subscriber.notifySubscriber(lot);
				}

			}

		

	}

	public void notifyWhenUnparking(Integer occupiedSize,ParkingLot lot) {
		
		HashSet<Subscriber> subscribersToNotify = subscribersForUnParking.get(occupiedSize);
		if (subscribersToNotify != null) {
			for (Subscriber subscriber : subscribersToNotify) {
				subscriber.notifySubscriber(lot);
				
			}

		}

	}

	public void addSubscriber(NotificationCriteria criteria, int capacity, Subscriber subscriber,WhenToNotify when) {
		
		int cap = (int) Math.floor((capacity * (criteria.getCriteriaInPercent() * 0.01)));
		System.out.println(cap);
		switch(when.getWhen()){
		case 0:
			putSubscriberInMap(this.subscribersForParking,subscriber,cap);
			break;
		case 1:
			putSubscriberInMap(this.subscribersForUnParking,subscriber,cap);
			break;
		case 2:
			putSubscriberInMap(this.subscribersForParking,subscriber,cap);
			putSubscriberInMap(this.subscribersForUnParking,subscriber,cap);
			break;
		default:
			break;
		
		}
		
	}
	
	public void putSubscriberInMap(HashMap<Integer, HashSet<Subscriber>> subscribers ,Subscriber subscriber, int cap){
		if (subscribers.get(cap) != null) {
			subscribers.get(cap).add(subscriber);
		} else {
			HashSet<Subscriber> subs = new HashSet<Subscriber>();
			subs.add(subscriber);
			subscribers.put(cap, subs);
		}
		
	}

}
