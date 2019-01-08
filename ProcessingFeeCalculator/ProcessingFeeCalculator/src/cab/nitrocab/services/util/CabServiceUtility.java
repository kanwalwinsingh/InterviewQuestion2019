package cab.nitrocab.services.util;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import cab.nitrocab.dto.BookingRequestDTO;
import cab.nitrocab.dto.CabDetailDTO;

public class CabServiceUtility {

	static Map<Integer, String> errorMsgData = new HashMap<Integer, String>();
	static {
		errorMsgData.put(101, "Invalid Pickup/ Arrival Code");
		errorMsgData.put(102, "Kindly pass valid Details");
		errorMsgData.put(103, "Kindly Make Current Date Booking");
		errorMsgData.put(104, "System Error");
	}

	public static String getMatchingCab(BookingRequestDTO cabBookingRequest,
			List<CabDetailDTO> cabDetails) {
		Map<Integer, CabDetailDTO> cabDetailsMap = new HashMap<Integer, CabDetailDTO>();

		for (CabDetailDTO cabDetail : cabDetails) {
			cabDetailsMap
					.put(Math.abs(cabDetail.getInitialLocation()
							- cabBookingRequest.getPickUpAreaCode()), cabDetail);
		}

		List<Integer> nearestDistanceCabs = new LinkedList<Integer>(
				cabDetailsMap.keySet());
		Collections.sort(nearestDistanceCabs);

		return cabDetailsMap.get(nearestDistanceCabs.get(0)).getCabId();

	}

	public static boolean checkAreaCode(int areaCode) {
		Boolean isValid = false;
		String codeStr = areaCode > 0 ? areaCode + "" : null;
		if (codeStr != null && codeStr.length() == 6
				&& codeStr.startsWith("100"))
			isValid = true;
		else
			isValid = false;

		return isValid;
	}

	public static String getErrorMessage(Integer errorCode) {
		return errorMsgData.get(errorCode);
	}

	public static boolean isCurrentDate(Date pickupDate) {
		boolean isCurrent = true;
		int comp = pickupDate.compareTo(new Date());
		isCurrent = comp <= 0 ? true : false;

		return isCurrent;
	}

}
