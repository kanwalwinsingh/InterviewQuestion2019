package com.sapient.processingfeecalculator.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date formatDateMMDDYYYY(String date) throws ProcessingFeeException{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date transdate;
		try {
			transdate = sdf.parse(date);
		} catch (ParseException e) {
			throw new ProcessingFeeException("Trans date mentiond in file is not in valid format");
		}
		
		return transdate;
	}
	
}
