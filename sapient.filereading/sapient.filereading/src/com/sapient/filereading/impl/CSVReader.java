package com.sapient.filereading.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.sapient.filereading.constant.FileConstant;
import com.sapient.filereading.endpoint.FileReader;
import com.sapient.filereading.helper.ConversionHelper;
import com.sapient.filereading.model.CurrencyConversion;
import com.sapient.filereading.model.CurrencyDto;

public class CSVReader implements FileReader {

	@Override
	public List<CurrencyDto> getFileReaderType(String fileType) {
		File file = new File(fileType);
		List<CurrencyDto> CurrencyDtoList= new ArrayList<CurrencyDto>();
		try {
		BufferedReader br= new BufferedReader( new InputStreamReader( new FileInputStream(file)));
		 
		while(true){
			
				String dta= br.readLine();
				if(dta==null)
					break;
				if(dta.contains("City"))
				continue;
				String[] splitData = dta.split(FileConstant.COMMA_SEPARATOr);
			CurrencyDto 	currencyDto= setData(splitData);
			CurrencyDtoList.add(currencyDto);
				
			}} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		// TODO Auto-generated method stub
		return CurrencyDtoList;
	}

	private CurrencyDto setData(String[] splitData) {
		DecimalFormat dc= new DecimalFormat("0.00");
		// TODO Auto-generated method stub
		CurrencyDto dto= new CurrencyDto();
		dto.setCity(splitData[0]);
		dto.setCountry(splitData[1]);
		dto.setGender(splitData[2]);
		dto.setCurrency(splitData[3]);
		dto.setAvgIncome(Double.parseDouble(dc.format(ConversionHelper.getConversion(CurrencyConversion.valueOf(dto.getCurrency()), Double.parseDouble(splitData[4])))));
		return dto;
	}

}
