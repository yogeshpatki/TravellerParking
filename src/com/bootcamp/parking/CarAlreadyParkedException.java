package com.bootcamp.parking;

@SuppressWarnings("serial")
public class CarAlreadyParkedException extends Exception{
	CarAlreadyParkedException(String s){
		super(s);
	}
}
