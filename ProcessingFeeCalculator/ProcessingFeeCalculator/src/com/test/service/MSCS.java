package com.test.service;

import java.util.concurrent.ConcurrentHashMap;

import com.test.model.MetroSmartCard;
import com.test.model.Station;
import com.test.model.Trip;

public class MSCS {
	private static ConcurrentHashMap<Long, Trip> tripMap = new ConcurrentHashMap<Long, Trip>();
	private static ConcurrentHashMap<Long, MetroSmartCard> cardMap = new ConcurrentHashMap<Long, MetroSmartCard>();
	private static ConcurrentHashMap<Integer, Station> stations = new ConcurrentHashMap<Integer, Station>();

	public static ConcurrentHashMap<Integer, Station> getStations() {
		return stations;
	}
	public static void setStations(ConcurrentHashMap<Integer, Station> stations) {
		MSCS.stations = stations;
	}
	public static ConcurrentHashMap<Long, Trip> getTripMap() {
		return tripMap;
	}
	public static void setTripMap(ConcurrentHashMap<Long, Trip> tripMap) {
		MSCS.tripMap = tripMap;
	}
	public static ConcurrentHashMap<Long, MetroSmartCard> getCardMap() {
		return cardMap;
	}
	public static void setCardMap(ConcurrentHashMap<Long, MetroSmartCard> cardList) {
		MSCS.cardMap = cardList;
	}

	public static boolean isValidCard(long cardNo){
		MetroSmartCard smartCard = cardMap.get(cardNo);
		if(smartCard != null){
			return smartCard.isValid();
		}
		return false;
	}
	
	public static boolean isEligibleForSwipeIn(long cardNo){
		MetroSmartCard smartCard = cardMap.get(cardNo);
		
		if(isValidCard(cardNo) && smartCard != null && smartCard.getBalance() > 5.5){
			return true;
		}
		return false;
	}
	
	public static boolean isValidTrip(Trip trip){
		if(trip.getTripId()==0)
			return false;
		return true;
	}

}
