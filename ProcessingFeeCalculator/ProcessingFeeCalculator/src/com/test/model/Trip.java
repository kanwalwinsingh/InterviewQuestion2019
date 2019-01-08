package com.test.model;

import java.util.Date;

public class Trip {
	private MetroSmartCard smartCard;
	private long tripId = 0;
	private Station sourceStation;
	private Station destinationStation;
	private double fare;
	private Date journeyDate;
	private double balance;

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Date getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}
	public MetroSmartCard getSmartCard() {
		return smartCard;
	}
	public void setSmartCard(MetroSmartCard smartCard) {
		this.smartCard = smartCard;
	}
	public long getTripId() {
		return tripId;
	}
	public void setTripId(long tripId) {
		this.tripId = tripId;
	}
	public Station getSourceStation() {
		return sourceStation;
	}
	public void setSourceStation(Station sourceStation) {
		this.sourceStation = sourceStation;
	}
	public Station getDestinationStation() {
		return destinationStation;
	}
	public void setDestinationStation(Station destinationStation) {
		this.destinationStation = destinationStation;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}

}
