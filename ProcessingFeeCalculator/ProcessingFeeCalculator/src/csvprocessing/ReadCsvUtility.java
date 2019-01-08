package csvprocessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCsvUtility {

	public List<CurrencyDTO> readCSVFile(String filePath) throws IOException {

		final List<CurrencyDTO> objectList = new ArrayList<CurrencyDTO>();
		final File file = new File(filePath);
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
			if (file.exists()) {
				String line = null;
				boolean firstLine = true;
				while ((line = bufferedReader.readLine()) != null) {
					if (firstLine) {
						if (line.startsWith("City")) {
							firstLine = false;
							continue;
						}
					}
					final String[] rowValue = line.split(ApplicationConstants.CSV_SEPARATOR);
					final CurrencyDTO currencyDTO = this.setObjectValue(rowValue);
					objectList.add(currencyDTO);
				}
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		return objectList;
	}

	private CurrencyDTO setObjectValue(String[] rowValue) {
		final CurrencyDTO currencyDTO = new CurrencyDTO();
		currencyDTO.setCity(rowValue[0]);
		currencyDTO.setCountry(rowValue[1]);
		currencyDTO.setGender(rowValue[2]);
		currencyDTO.setCurrencyCode(rowValue[3]);
		currencyDTO.setAvgIncome(Integer.parseInt(rowValue[4]));
		return currencyDTO;

	}

	public static void main(String[] args) throws IOException {
		readDataFromCsv(ApplicationConstants.FILE_PATH);
	}

	public static void readDataFromCsv(String filepath) throws IOException {

		File file = new File(filepath);
		System.out.println(file.exists());
		int increament = 0;
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			
			if (file.exists()) {
				String line = null;
				while ((line = bufferedReader.readLine()) != null) {
					if (increament == 0) {
						increament++;
							continue;
					}
					final String[] rowValue = line.split(ApplicationConstants.CSV_SEPARATOR);
					System.out.println(rowValue[0]);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
