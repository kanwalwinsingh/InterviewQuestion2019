package com.sapient.filereading.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import com.sapient.filereading.constant.FileConstant;
import com.sapient.filereading.endpoint.FileReader;
import com.sapient.filereading.model.CurrencyDto;
import com.sapient.filereading.model.CurrencyExternal;

public class FileReaderFactoryDemo {

	public static void main(String a[]) throws IOException {
		FileReader fileReader = FileReaderFactory
				.getFileType(FileConstant.FILE_NAME);
		if (fileReader == null)
			System.out.println("File is not present");
		else {
			List<CurrencyDto> currencyDtoList = fileReader
					.getFileReaderType(FileConstant.FILE_NAME);
			Map<String, Map<String, Double>> groupData = currencyDtoList
					.stream()
					.collect(
							Collectors.groupingBy(
									dto -> dto.getCountry().equals("") ? dto
											.getCity() : dto.getCountry(),
									Collectors.groupingBy(
											CurrencyDto::getGender,
											Collectors
													.averagingDouble(CurrencyDto::getAvgIncome))));
			System.out.println(groupData);
			List<CurrencyExternal> list = GroupBydata(groupData);
			list.forEach(dto -> System.out.println(dto));
			 FileWriter fw= new FileWriter("C:\\rudra.csv");
			 fw.write("CountryOrCity "+","+"Gender"+","+"Income"+"\n");
			 for (CurrencyExternal currencyExternal : list) {
				fw.write(currencyExternal.getCountryorCity()+","+currencyExternal.getGender()+","+currencyExternal.getAvgincome()+"\n");
			}
			 fw.close();
		}
	}

	private static List<CurrencyExternal> GroupBydata(
			Map<String, Map<String, Double>> groupData) {
		List<CurrencyExternal> list = new ArrayList<CurrencyExternal>();
		Set<Entry<String, Map<String, Double>>> entryset11 = groupData
				.entrySet();
		for (Entry<String, Map<String, Double>> entry1 : entryset11) {
			String city = entry1.getKey();
			Map<String, Double> entryset1 = entry1.getValue();

			for (Entry<String, Double> entry2 : entryset1.entrySet()) {
				CurrencyExternal ce = new CurrencyExternal();
				ce.setCountryorCity(city);
				ce.setGender(entry2.getKey());
				ce.setAvgincome(entry2.getValue());

				list.add(ce);

			}
		}
		Collections.sort(list);
		// TODO Auto-generated method stub
		return list;
	}
}
