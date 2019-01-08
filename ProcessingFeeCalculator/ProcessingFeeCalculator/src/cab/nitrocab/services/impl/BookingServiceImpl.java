package cab.nitrocab.services.impl;

import java.util.List;

import cab.nitrocab.dto.CnfrmationDetailsDTO;
import cab.nitrocab.dto.BookingRequestDTO;
import cab.nitrocab.dto.CabDetailDTO;
import cab.nitrocab.services.BookingService;
import cab.nitrocab.services.util.CabServiceUtility;


public class BookingServiceImpl implements BookingService {

	public CnfrmationDetailsDTO bookCab(
			BookingRequestDTO bookingRequest, List<CabDetailDTO> cabDetails) {

		String cabId;
		float cabFare;
		float cabProfirMargin;
		int routeDistance;
		CnfrmationDetailsDTO confirmBookingDetail;

	
		// Get Matching Cab
		cabId = CabServiceUtility.getMatchingCab(bookingRequest, cabDetails);

		// Get Route Distance
		routeDistance = ((Math.abs(bookingRequest.getDropAreaCode() - bookingRequest.getPickUpAreaCode())) * 2);

		// Get CabFare
		cabFare = routeDistance * 10;

		// Get Profit
		cabProfirMargin = cabFare - (routeDistance * 5);

		// Booking Confirmed Details
		confirmBookingDetail = new CnfrmationDetailsDTO(cabId, cabFare,cabProfirMargin, routeDistance, bookingRequest);
		

		return confirmBookingDetail;
	}

}
