package com.test.model;

public class Station {
	private int stationCode;
	private String stationName;
	private int distanceFromRef;
	private long footFall;
	public int getStationCode() {
		return stationCode;
	}
	public void setStationCode(int stationCode) {
		this.stationCode = stationCode;
	}
	public long getFootFall() {
		return footFall;
	}
	public void setFootFall(long footFall) {
		this.footFall = footFall;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public int getDistanceFromRef() {
		return distanceFromRef;
	}
	public void setDistanceFromRef(int distanceFromRef) {
		this.distanceFromRef = distanceFromRef;
	}

}
