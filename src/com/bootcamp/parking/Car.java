package com.bootcamp.parking;

public class Car {
	private String regNo;

	public Car(String regNo) {
		super();
		this.regNo = regNo;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Car){
			Car car = (Car) obj;
			if(this.regNo == car.regNo)
				return true;
			else
				return false;
				
		}else
			return false;
	}


}
