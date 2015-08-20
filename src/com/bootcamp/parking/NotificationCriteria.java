package com.bootcamp.parking;

public enum NotificationCriteria {
	EMPTY (0),
	FULL(100),
	ALMOST_FULL(90),
	ALMOST_EMPTY(10),
	HALF_FULL(50);
	
	private final int criteriaInPercent;
	
	private NotificationCriteria(int criteria) {
		this.criteriaInPercent = criteria;
		
	}
	public int getCriteriaInPercent() {
		return criteriaInPercent;
	}
	
	
}
