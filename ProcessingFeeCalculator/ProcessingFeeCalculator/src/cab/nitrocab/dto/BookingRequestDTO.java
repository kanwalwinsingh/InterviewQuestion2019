package cab.nitrocab.dto;

import java.util.Date;

public class BookingRequestDTO {
	
	private String requestId;
	private int pickUpAreaCode;
	private int dropAreaCode;
	private String pickUpTime;
	private Date pickupDate;
	
	public BookingRequestDTO(String requestId, int pickUpAreaCode,
			int dropAreaCode, String pickUpTime,Date pickupDate) {
		super();
		this.requestId = requestId;
		this.pickUpAreaCode = pickUpAreaCode;
		this.dropAreaCode = dropAreaCode;
		this.pickUpTime = pickUpTime;
		this.pickupDate = pickupDate; 
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public int getPickUpAreaCode() {
		return pickUpAreaCode;
	}

	public void setPickUpAreaCode(int pickUpAreaCode) {
		this.pickUpAreaCode = pickUpAreaCode;
	}

	public int getDropAreaCode() {
		return dropAreaCode;
	}

	public void setDropAreaCode(int dropAreaCode) {
		this.dropAreaCode = dropAreaCode;
	}

	public String getPickUpTime() {
		return pickUpTime;
	}

	public void setPickUpTime(String pickUpTime) {
		this.pickUpTime = pickUpTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dropAreaCode;
		result = prime * result + pickUpAreaCode;
		result = prime * result
				+ ((pickUpTime == null) ? 0 : pickUpTime.hashCode());
		result = prime * result
				+ ((requestId == null) ? 0 : requestId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingRequestDTO other = (BookingRequestDTO) obj;
		if (dropAreaCode != other.dropAreaCode)
			return false;
		if (pickUpAreaCode != other.pickUpAreaCode)
			return false;
		if (pickUpTime == null) {
			if (other.pickUpTime != null)
				return false;
		} else if (!pickUpTime.equals(other.pickUpTime))
			return false;
		if (requestId == null) {
			if (other.requestId != null)
				return false;
		} else if (!requestId.equals(other.requestId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NitroBookingRequestDTO [requestId=" + requestId
				+ ", pickUpAreaCode=" + pickUpAreaCode + ", dropAreaCode="
				+ dropAreaCode + ", pickUpTime=" + pickUpTime + "]";
	}

	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}

	public Date getPickupDate() {
		return pickupDate;
	}
	
	
}
