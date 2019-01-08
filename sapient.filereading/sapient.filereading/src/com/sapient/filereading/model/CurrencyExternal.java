package com.sapient.filereading.model;

public class CurrencyExternal implements Comparable<CurrencyExternal> {

	public String getCountryorCity() {
		return countryorCity;
	}

	public void setCountryorCity(String countryorCity) {
		this.countryorCity = countryorCity;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getAvgincome() {
		return avgincome;
	}

	public void setAvgincome(double avgincome) {
		this.avgincome = avgincome;
	}

	private String countryorCity;
	private String gender;
	private double avgincome;

	@Override
	public int compareTo(CurrencyExternal o) {

		if (this.countryorCity.compareTo(o.countryorCity) == 0)
			return Double.compare(this.avgincome, o.avgincome);
		else
			return this.countryorCity.compareTo(o.countryorCity);

	}

	@Override
	public String toString() {
		return  countryorCity + "\t"
				+ gender + "\t" + avgincome ;
	}

}
