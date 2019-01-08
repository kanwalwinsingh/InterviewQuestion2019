package csvprocessing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestMainClass {

	public static void main(String[] args) throws IOException {

		final ReadCsvUtility readCsvUtility = new ReadCsvUtility();
		// reading data from csv file
		final List<CurrencyDTO> objectList = readCsvUtility.readCSVFile(ApplicationConstants.FILE_PATH);
		// objectList.stream().forEach(System.out::println);

		final Map<String, List<CurrencyDTO>> hmap = new HashMap<>();

		List<CurrencyDTO> tempList = null;
		for (CurrencyDTO obj : objectList) {
			final String key = obj.getCountry();
			if (hmap.containsKey(obj.getCountry())) {
				tempList = hmap.get(key);
				tempList.add(obj);
			} else {
				tempList = new ArrayList<>();
				tempList.add(obj);
				hmap.put(key, tempList);
			}
		}
		System.out.println("**** " + hmap.size());
		for (String key : hmap.keySet()) {
			int total_income = getTotalIncome(hmap.get(key));
			System.out.println("Total income for key [" + key + "] = " + total_income);
		}

		System.out.println(getTotalSalaryByCountryMapWithJava8().get("Russia"));
		System.out.println(getTotalSalaryByCountryAndCityMapWithJava8().get("India_Delhi"));
	}

	private static int getTotalIncome(final List<CurrencyDTO> list) {
		int total_income = 0;
		for (CurrencyDTO object : list) {
			total_income = total_income + object.getAvgIncome();
		}
		return total_income;
	}

	public static Map<String, Integer> getTotalSalaryByCountryMapWithJava8() throws IOException {

		final ReadCsvUtility readCsvUtility = new ReadCsvUtility();
		// read data from csv file
		final List<CurrencyDTO> objectList = readCsvUtility.readCSVFile(ApplicationConstants.FILE_PATH);

		final Map<String, Integer> mapResponse = objectList.stream().collect(
				Collectors.groupingBy(CurrencyDTO::getCountry, Collectors.summingInt(CurrencyDTO::getAvgIncome)));
		System.out.println(mapResponse);
		return mapResponse;
	}

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public static Map<String, Integer> getTotalSalaryByCountryAndCityMapWithJava8() throws IOException {

		final ReadCsvUtility readCsvUtility = new ReadCsvUtility();
		// read data from csv file
		final List<CurrencyDTO> objectList = readCsvUtility.readCSVFile(ApplicationConstants.FILE_PATH);

		Map<Object, Integer> mapValueList = objectList.stream().collect(Collectors
				.groupingBy(p -> Arrays.asList(p.getCountry()), Collectors.summingInt(p -> p.getAvgIncome())));
		System.out.println("print value =" + mapValueList);

		final Map<String, Integer> mapResponse = objectList.stream().collect(
				Collectors.groupingBy(CurrencyDTO::getCountry, Collectors.summingInt(CurrencyDTO::getAvgIncome)));
		System.out.println(mapResponse);

		Map<String, Integer> treeMap = new TreeMap<String, Integer>(mapResponse);
		System.out.println("treemap = " + treeMap);
		return mapResponse;
	}

	private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {

		// 1. Convert Map to List of Map
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

		// 2. Sort list with Collections.sort(), provide a custom Comparator
		// Try switch the o1 o2 position for a different order
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		// 3. Loop the sorted list and put it into a new insertion order Map
		// LinkedHashMap
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		/*
		 * //classic iterator example for (Iterator<Map.Entry<String, Integer>>
		 * it = list.iterator(); it.hasNext(); ) { Map.Entry<String, Integer>
		 * entry = it.next(); sortedMap.put(entry.getKey(), entry.getValue()); }
		 */

		return sortedMap;
	}
}
