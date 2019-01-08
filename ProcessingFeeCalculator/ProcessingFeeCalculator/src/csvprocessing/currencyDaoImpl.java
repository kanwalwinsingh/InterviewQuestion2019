package csvprocessing;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class currencyDaoImpl implements CurrencyDao{

	private List<CurrencyDTO> currencyDtoList=new ArrayList<CurrencyDTO>();
	public List<CurrencyDTO> getCurrencyDtoList() {
		return currencyDtoList;
	}

	public void setCurrencyDtoList(List<CurrencyDTO> currencyDtoList) {
		this.currencyDtoList = currencyDtoList;
	}

	@Override
	public void readCSVFile(String filePath) {
		try{
			FileReader f=new FileReader(filePath);
			BufferedReader reader =new BufferedReader(f);
			String line=null;
			boolean firstLine=true;
			while((line=reader.readLine())!=null){
				if(firstLine){
					if(line.startsWith("City")){
						firstLine=false;
						continue;
					}
				}
				
				String[] attrib=line.split(",");
				CurrencyDTO dt=new CurrencyDTO();
				dt.setCity(attrib[0]);
				dt.setCountry(attrib[1]);
				dt.setGender(attrib[2]);
				dt.setCurrencyCode(attrib[3]);
				dt.setAvgIncome(Integer.parseInt(attrib[4]));
				currencyDtoList.add(dt);
				//System.out.println(line);
				//line=reader.readLine();
				
			}
			reader.close();
			//System.out.println("size-"+currencyDtoList.size());
		}catch(Exception e){
			System.out.println("Not found");
		}
	}
	
	public List<CurrencyDTO> getList(){
		return this.getCurrencyDtoList();
	}
		
}
