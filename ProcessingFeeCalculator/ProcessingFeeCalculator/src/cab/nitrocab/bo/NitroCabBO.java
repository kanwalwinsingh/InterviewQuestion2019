package cab.nitrocab.bo;

import java.util.List;

import cab.nitrocab.dto.CnfrmationDetailsDTO;
import cab.nitrocab.dto.BookingRequestDTO;
import cab.nitrocab.dto.CabDetailDTO;
import cab.nitrocab.services.BookingService;
import cab.nitrocab.services.impl.BookingServiceImpl;
import cab.nitrocab.services.util.CabServiceUtility;

public class NitroCabBO {

	
	public CnfrmationDetailsDTO bookCab(
			BookingRequestDTO bookingRequest, List<CabDetailDTO> cabDetails) {
		
		CnfrmationDetailsDTO confirmBookingDetail;
		BookingService bookingService = new BookingServiceImpl();
		
		if (bookingRequest == null || cabDetails.isEmpty()) {
			confirmBookingDetail=new CnfrmationDetailsDTO("",0.0f,0.0f,0,null);
			confirmBookingDetail.setErrorCode(102);
			confirmBookingDetail.setErrorMessage(CabServiceUtility.getErrorMessage(102));
		}
		else if (!CabServiceUtility.checkAreaCode(bookingRequest.getPickUpAreaCode()) && !CabServiceUtility.checkAreaCode(bookingRequest.getDropAreaCode()))
		{
			confirmBookingDetail=new CnfrmationDetailsDTO("",0.0f,0.0f,0,null);
			confirmBookingDetail.setErrorCode(101);
			confirmBookingDetail.setErrorMessage(CabServiceUtility.getErrorMessage(101));
		}
		
		else if (!CabServiceUtility.isCurrentDate(bookingRequest.getPickupDate())){
			confirmBookingDetail=new CnfrmationDetailsDTO("",0.0f,0.0f,0,null);
			confirmBookingDetail.setErrorCode(103);
			confirmBookingDetail.setErrorMessage(CabServiceUtility.getErrorMessage(103));
		}
			
		
		else
			confirmBookingDetail = bookingService.bookCab(bookingRequest, cabDetails);
		
		return confirmBookingDetail;
		
	}
}
