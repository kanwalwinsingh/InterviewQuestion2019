package cab.nitrocab.dto;

public class CnfrmationDetailsDTO {
	
	private String cabId;
	private float cabFare;
	private float cabProfit;
	private int routeDistance;
	BookingRequestDTO cabRequestDetails;
	private Integer errorCode;
	private String errorMessage;
	
	
	public CnfrmationDetailsDTO(String cabId, float cabFare,
			float cabProfit, int totalRouteDistance,
			BookingRequestDTO cabRequestDetails) {
		super();
		this.cabId = cabId;
		this.cabFare = cabFare;
		this.cabProfit = cabProfit;
		this.routeDistance = totalRouteDistance;
		this.cabRequestDetails = cabRequestDetails;
	}

	public String getCabId() {
		return cabId;
	}

	public void setCabId(String cabId) {
		this.cabId = cabId;
	}

	public float getCabFare() {
		return cabFare;
	}

	public void setCabFare(float cabFare) {
		this.cabFare = cabFare;
	}

	public float getCabProfit() {
		return cabProfit;
	}

	public void setCabProfit(float cabProfit) {
		this.cabProfit = cabProfit;
	}

	public int getTotalRouteDistance() {
		return routeDistance;
	}

	public void setTotalRouteDistance(int totalRouteDistance) {
		this.routeDistance = totalRouteDistance;
	}

	public BookingRequestDTO getCabRequestDetails() {
		return cabRequestDetails;
	}

	public void setCabRequestDetails(BookingRequestDTO cabRequestDetails) {
		this.cabRequestDetails = cabRequestDetails;
	}

	@Override
	public String toString() {
		return "NitroBookingCnfrmDetailsDTO [cabId=" + cabId + ", cabFare="
				+ cabFare + ", cabProfit=" + cabProfit + ", routeDistance="
				+ routeDistance + ", cabRequestDetails=" + cabRequestDetails
				+ "]";
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}	
	
	
	
}
