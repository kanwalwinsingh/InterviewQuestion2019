package cab.nitrocab.dto;

public class CabDetailDTO {
	
	private String nitroCabId;
	private int initialLocation;
	
	public CabDetailDTO(String cabId, int initialLocation) {
		super();
		this.nitroCabId = cabId;
		this.initialLocation = initialLocation;
	}

	public String getCabId() {
		return nitroCabId;
	}

	public void setCabId(String cabId) {
		this.nitroCabId = cabId;
	}

	public int getInitialLocation() {
		return initialLocation;
	}

	public void setInitialLocation(int initialLocation) {
		this.initialLocation = initialLocation;
	}	

}
