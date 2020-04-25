package com.factory.pattern;

public class Huyndai extends Car{

	@Override
	public void viewCar() {
		System.out.println("Xem các loại xe của dòng xe Huyndai");
		
	}

	@Override
	public String getCarName() {
		String Huyndaitype = "Tucson - Santafe - ...";
		return Huyndaitype;
	}

}
