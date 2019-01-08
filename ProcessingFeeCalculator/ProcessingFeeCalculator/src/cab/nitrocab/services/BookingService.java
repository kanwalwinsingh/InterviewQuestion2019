package cab.nitrocab.services;

import java.util.List;

import cab.nitrocab.dto.CnfrmationDetailsDTO;
import cab.nitrocab.dto.BookingRequestDTO;
import cab.nitrocab.dto.CabDetailDTO;


public interface BookingService {
	
	public CnfrmationDetailsDTO bookCab(
			BookingRequestDTO bookingRequest, List<CabDetailDTO> cabDetails);

}
