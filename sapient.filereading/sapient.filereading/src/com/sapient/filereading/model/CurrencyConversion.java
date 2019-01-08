package com.sapient.filereading.model;

public enum CurrencyConversion {

	 INR(1/60d),RUB(1/50d),USD(1/1d),EUR(1/25d);
	private double value;

	CurrencyConversion(double value) {
		this.value = value;
		// TODO Auto-generated constructor stub
	}

	public double getValue() {
		return this.value;
	}
}
