package com.test.api;

import java.util.Calendar;

import com.test.model.MetroSmartCard;
import com.test.model.Station;
import com.test.model.Trip;
import com.test.service.MSCS;
import com.test.service.Swipe;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MetroSmartCard smartCard = new MetroSmartCard(112, true, false, 123456);
		Trip t = new Trip();
		t.setBalance(23);
		Station src = new Station();
		src.setDistanceFromRef(2);
		src.setFootFall(0);
		src.setStationCode(22);
		src.setStationName("station1");
		Swipe s=new Swipe();
		if(s.swipeIn(smartCard, src))
		{
			Station dest = new Station();
			dest.setDistanceFromRef(7);
			dest.setFootFall(0);
			dest.setStationCode(21);
			dest.setStationName("station2");
			t.setDestinationStation(dest);
			t.setFare(10);
			t.setJourneyDate(Calendar.getInstance().getTime());
			t.setSmartCard(smartCard);
			t.setSourceStation(src);
			t.setTripId(1003);
			Boolean b=s.swipeOut(smartCard, dest, t);
					if(!b)
					{
						System.out.println("You Cant Exit from The Metro");
					}
					else
						System.out.println("Card Number-:"+smartCard.getCardNo()+" "+"SourceStation:-" +src.getStationName()+" "+"DestinationStation-:" +dest.getStationName()+" "+"Fare-:"+t.getFare()+" "+"Balance-:"+t.getBalance());
			
		}
		else
		{
			System.out.println("You have insufficeint Balance");
		}
				
		

	}

}
