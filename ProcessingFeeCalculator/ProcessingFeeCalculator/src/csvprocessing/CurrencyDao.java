package csvprocessing;

import java.util.List;

public interface CurrencyDao {
	
	public List<CurrencyDTO> getList();

	public void readCSVFile(String filePath);
}
