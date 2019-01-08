package com.test.api;

import java.util.Calendar;

import com.test.model.MetroSmartCard;
import com.test.model.Station;
import com.test.model.Trip;
import com.test.service.MSCS;

public class MetroReportsTest {
	public void setData() {

		MetroSmartCard smartCard = new MetroSmartCard(12, true, false, 123456);
		MSCS.getCardMap().put(smartCard.getCardNo(), smartCard);

		smartCard = new MetroSmartCard(12, true, false, 1234567);
		MSCS.getCardMap().put(smartCard.getCardNo(), smartCard);

		smartCard = new MetroSmartCard(5, true, false, 1234568);
		MSCS.getCardMap().put(smartCard.getCardNo(), smartCard);

		smartCard = new MetroSmartCard(6, true, false, 1234569);
		MSCS.getCardMap().put(smartCard.getCardNo(), smartCard);
		smartCard = new MetroSmartCard(10, true, false, 1234561);
		MSCS.getCardMap().put(smartCard.getCardNo(), smartCard);
		smartCard = new MetroSmartCard(70, true, false, 1234562);
		MSCS.getCardMap().put(smartCard.getCardNo(), smartCard);
		smartCard = new MetroSmartCard(50, true, false, 1234563);
		MSCS.getCardMap().put(smartCard.getCardNo(), smartCard);
		smartCard = new MetroSmartCard(60, false, false, 1234564);
		Trip t = new Trip();
		t.setBalance(23);

		Station src = new Station();
		src.setDistanceFromRef(5);
		src.setFootFall(0);
		src.setStationCode(22);
		src.setStationName("station1");

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
		MSCS.getTripMap().put(1L, t);

	}

}
