package csvprocessing;

public class CurrencyDTO {

	private String city;
	private String country;
	private String gender;
	private String currencyCode;
	private Integer avgIncome;
	private Integer totlaIncome;
	private String keyfield;

	public String getKeyfield() {
		this.keyfield = this.country + "_" + this.gender;
		return keyfield;
	}

	public void setKeyfield(String keyfield) {
		this.keyfield = keyfield;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Integer getAvgIncome() {
		return avgIncome;
	}

	public void setAvgIncome(Integer avgIncome) {
		this.avgIncome = avgIncome;
	}

	public Integer getTotlaIncome() {
		return totlaIncome;
	}

	public void setTotlaIncome(Integer totlaIncome) {
		this.totlaIncome = totlaIncome;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + this.country + "] - [" + this.city + "] - [" + this.currencyCode + "] - [" + this.gender + "] - ["
				+ this.avgIncome + "]";
	}

}
