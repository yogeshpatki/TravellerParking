package com.bootcamp.parking;

@SuppressWarnings("serial")
public class CarNotFoundForGivenTicketException extends Exception{

	CarNotFoundForGivenTicketException(String s){
		super(s);
	}
	
}
