package com.test.api;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.test.model.MetroSmartCard;
import com.test.model.Station;
import com.test.model.Trip;
import com.test.service.MSCS;

public class MetroReports {
	/*
	 * Generates report for total foot falls for a given station
	 */
	public void footFallReport(Station station){
		long footFallCount = 0;
		if(station != null){
			Station tempst = MSCS.getStations().get(station.getStationCode());
			if(tempst != null){
				footFallCount = tempst.getFootFall();
			}
		}
		System.out.println("Footfall so far is: "+footFallCount);
	}

	/*
	 * @param SmartCard
	 * 
	 * This method will give details of complete trip.
	 */
	public ArrayList<Trip> perCardReport(MetroSmartCard smartCard){
		ConcurrentHashMap<Long, Trip> tripMap = MSCS.getTripMap();
		ArrayList<Trip> trips = new ArrayList<Trip>();
		Set<Entry<Long, Trip>> entrySet = tripMap.entrySet();

		for(Entry<Long, Trip> entry : entrySet){
			if((entry.getValue()).getSmartCard().getCardNo() == smartCard.getCardNo()){
				Trip tempTrip = entry.getValue();
				if(tempTrip.getDestinationStation()!=null&&tempTrip.getDestinationStation().equals("")){
					trips.add(tempTrip);
					System.out.println("Card "+smartCard.getCardNo()+" used to travel from station "+tempTrip.getSourceStation()+" to station "+tempTrip.getDestinationStation()+". Fare is Rs "+tempTrip.getFare()
							+" and balance on the card is Rs"+tempTrip.getBalance());}
			}
		}
		return trips;
	}


}
