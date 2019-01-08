package com.test.util;

public class TripFare {
	public static double weekdayCharge(int noOfStations){
		return 7*noOfStations;
	}
	
	public static double weekendCharge(int noOfStation){
		return 5.5*noOfStation;
	}

}
