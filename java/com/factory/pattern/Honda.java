package com.factory.pattern;

public class Honda extends Car{

	@Override
	public void viewCar() {
		System.out.println("Xem các loại xe của dòng xe Honda");
	}

	@Override
	public String getCarName() {
		String hondaType = "CRV - HRV - ...";
		return hondaType;
	}

}
