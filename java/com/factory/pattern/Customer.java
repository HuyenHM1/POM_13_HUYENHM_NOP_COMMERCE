package com.factory.pattern;

public class Customer {
	public static void main (String[] args) {
		CarFactory carFactory = new CarFactory();
		carFactory.viewCar("Huyndai");
		carFactory.viewCar("Honda");
		carFactory.viewCar("Lexus");
	}
}

