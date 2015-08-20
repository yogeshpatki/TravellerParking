package com.bootcamp.parking;

public enum WhenToNotify {
	WhenParking (0),
	WhenUnParking(1),
	Always(2);
	
	
	private final int when;
	
	private WhenToNotify(int when) {
		this.when = when;
		
	}
	public int getWhen() {
		return when;
	}
}
