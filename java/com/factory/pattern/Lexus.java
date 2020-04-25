package com.factory.pattern;

public class Lexus extends Car {

	@Override
	public void viewCar() {
		System.out.println("Xem các loại xe của dòng xe Lexus");
		
	}

	@Override
	public String getCarName() {
		String Lexustype = "570 - 350 - ...";
		return Lexustype;
	}

}
