package com.test.service;

import java.util.Calendar;

import com.test.model.MetroSmartCard;
import com.test.model.Station;
import com.test.model.Trip;
import com.test.util.TripFare;

public class Swipe {

	/*
	 * called when user swips in at source station
	 */
	public boolean swipeIn(MetroSmartCard smartCard,  Station sourceStation){
		if(!smartCard.isSwiped()&&(smartCard.getBalance()>5.5)){
			if(MSCS.getCardMap().get(smartCard.getCardNo())!=null)
				MSCS.getCardMap().get(smartCard.getCardNo()).setSwiped(true);
				Station tempst = MSCS.getStations().get(sourceStation.getStationCode());
				/*tempst.setFootFall(tempst.getFootFall()+1);*/
				Trip trip = new Trip(); 
				trip.setSourceStation(sourceStation);
				trip.setJourneyDate(Calendar.getInstance().getTime());
				trip.setSmartCard(smartCard);
				trip.setTripId(MSCS.getTripMap().size()+1);
				MSCS.getTripMap().put(trip.getTripId(), trip);
				smartCard.setSwiped(true);
				return true;
			
			
		}
		return false;
	}
	/*
	 * called when user swips out at destination station
	 */
	public boolean swipeOut(MetroSmartCard smartCard, Station destStation, Trip trip){
		if(smartCard.isSwiped()){
			Station tempst = MSCS.getStations().get(destStation.getStationCode());
			if(tempst!=null)
			tempst.setFootFall(tempst.getFootFall()+1);
			double fare;
			Calendar.getInstance();
			Calendar.getInstance();
			boolean isWeekend = (Calendar.DAY_OF_WEEK==6||Calendar.DAY_OF_WEEK==7);
			if(isWeekend){
				fare = TripFare.weekendCharge((trip.getSourceStation().getDistanceFromRef())-destStation.getDistanceFromRef());
				
			}
			else
			{
				fare = TripFare.weekdayCharge((trip.getSourceStation().getDistanceFromRef())-destStation.getDistanceFromRef());
			}
			if(fare>smartCard.getBalance())
				return false;
			smartCard.setBalance(smartCard.getBalance()+fare);
			smartCard.setSwiped(false);
			trip.setBalance(smartCard.getBalance());
			MSCS.getTripMap().put(trip.getTripId(), trip);
			return true;
			
		}
		return false;
	}

}
