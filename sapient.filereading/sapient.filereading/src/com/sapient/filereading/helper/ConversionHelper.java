package com.sapient.filereading.helper;

import com.sapient.filereading.model.CurrencyConversion;

public class ConversionHelper {

	public static double getConversion(CurrencyConversion cc, double value) {
		return cc.getValue() * value;
	}
}
