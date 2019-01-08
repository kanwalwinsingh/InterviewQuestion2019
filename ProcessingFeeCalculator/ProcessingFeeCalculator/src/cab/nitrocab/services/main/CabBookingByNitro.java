package cab.nitrocab.services.main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import cab.nitrocab.bo.NitroCabBO;
import cab.nitrocab.dto.CnfrmationDetailsDTO;
import cab.nitrocab.dto.BookingRequestDTO;
import cab.nitrocab.dto.CabDetailDTO;
import cab.nitrocab.services.BookingService;
import cab.nitrocab.services.impl.BookingServiceImpl;

public class CabBookingByNitro {
	
	public static void main(String[] args){
		
		NitroCabBO bookingService = new NitroCabBO();
		
		List<CabDetailDTO> cabDetails = new ArrayList<CabDetailDTO>();
		cabDetails.add(new CabDetailDTO("DL01HB001", 100020));
		cabDetails.add(new CabDetailDTO("DL01HB002", 100040));
		cabDetails.add(new CabDetailDTO("DL01HB003", 100060));
		cabDetails.add(new CabDetailDTO("DL01HB004", 100080));
		DateFormat format =  new SimpleDateFormat("dd-MMM-yyyy");

		
		
		//Request1
		String dt="18-JUN-2015";
		Date date;
		try {
			date = format.parse(dt);
		
			BookingRequestDTO bookingReq1 = new BookingRequestDTO("BR001", 100025, 100036, "10am",date);
			CnfrmationDetailsDTO cabBook1 = bookingService.bookCab(bookingReq1, cabDetails);
			if(!nullCheck(cabBook1)  && (cabBook1.getErrorCode()==null || cabBook1.getErrorCode()==0)){
				printDetails(cabBook1);
			}
			else if(cabBook1.getErrorCode()>0)
				printErrorMessage(cabBook1.getErrorMessage());
			
			//Request2
			BookingRequestDTO bookingReq2 = new BookingRequestDTO("BR002", 100056, 100042, "11am",date);
			CnfrmationDetailsDTO cabBook2 = bookingService.bookCab(bookingReq2, cabDetails);
			if(!nullCheck(cabBook2) && (cabBook2.getErrorCode()==null || cabBook2.getErrorCode()==0)){
				printDetails(cabBook2);
			}
			else if(cabBook2.getErrorCode()>0)
				printErrorMessage(cabBook2.getErrorMessage());
			
			//Request3
			BookingRequestDTO bookingReq3 = new BookingRequestDTO("BR003", 100044, 100056, "12am",date);
			CnfrmationDetailsDTO cabBook3 = bookingService.bookCab(bookingReq3, cabDetails);
			if(!nullCheck(cabBook3) && (cabBook3.getErrorCode()==null || cabBook3.getErrorCode()==0)){
				printDetails(cabBook3);
			}
			
			else if(cabBook3.getErrorCode()>0)
				printErrorMessage(cabBook3.getErrorMessage());
			
			//Request4
			BookingRequestDTO bookingReq4 = new BookingRequestDTO("BR004", 100028, 100038, "3pm",date);
			CnfrmationDetailsDTO cabBook4 = bookingService.bookCab(bookingReq4, cabDetails);
			if(!nullCheck(cabBook4)  && (cabBook4.getErrorCode()==null || cabBook4.getErrorCode()==0)){
				printDetails(cabBook4);
			}
			
			else if(cabBook4.getErrorCode()>0)
				printErrorMessage(cabBook4.getErrorMessage());
			
			//Request5 -- Error Test Request
			BookingRequestDTO bookingReq5 = new BookingRequestDTO("BR005", 28, 38, "5pm",date);
			CnfrmationDetailsDTO cabBook5 = bookingService.bookCab(bookingReq5, cabDetails);
			if(!nullCheck(cabBook5)  && (cabBook5.getErrorCode()==null || cabBook5.getErrorCode()==0)){
				printDetails(cabBook5);
			}
			
			else if(cabBook5.getErrorCode()>0)
				printErrorMessage(cabBook5.getErrorMessage());
			
			//Request6 -- null Booking request
			CnfrmationDetailsDTO cabBook6 = bookingService.bookCab(null, cabDetails);
			if(!nullCheck(cabBook6)  && (cabBook6.getErrorCode()==null || cabBook6.getErrorCode()==0)){
				printDetails(cabBook6);
			}
			
			else if(cabBook6.getErrorCode()>0)
				printErrorMessage(cabBook6.getErrorMessage());
			
			//Request7 -- Future Date Booking request
			String dt1="19-JUL-2015";
			Date date1 = format.parse(dt1);
			BookingRequestDTO bookingReq7 = new BookingRequestDTO("BR006", 100028, 100038, "5pm",date1);
			CnfrmationDetailsDTO cabBook7 = bookingService.bookCab(bookingReq7, cabDetails);
			if(!nullCheck(cabBook7)  && (cabBook7.getErrorCode()==null || cabBook7.getErrorCode()==0)){
				printDetails(cabBook7);
			}
			
			else if(cabBook7.getErrorCode()>0)
				printErrorMessage(cabBook7.getErrorMessage());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void printDetails(CnfrmationDetailsDTO nitroBookingCnfrmDetails){
		System.out.println("Your Cab has been booked, Here are the details :");
		System.out.println("Cab Id : "+nitroBookingCnfrmDetails.getCabId());
		System.out.println("Travel Cost : "+nitroBookingCnfrmDetails.getCabFare());
		System.out.println("Cab Earn : "+nitroBookingCnfrmDetails.getCabProfit());
		System.out.println("Travel Distance : "+nitroBookingCnfrmDetails.getTotalRouteDistance());
		System.out.println("Request Id : "+nitroBookingCnfrmDetails.getCabRequestDetails().getRequestId());
		System.out.println("Pick Up Location : "+nitroBookingCnfrmDetails.getCabRequestDetails().getPickUpAreaCode());
		System.out.println("Drop Location : "+nitroBookingCnfrmDetails.getCabRequestDetails().getDropAreaCode());
		System.out.println("PickUp Timing : "+nitroBookingCnfrmDetails.getCabRequestDetails().getPickUpTime());
		
		System.out.println();
	}
	
	public static boolean nullCheck(CnfrmationDetailsDTO nitroBookingCnfrmDetails){
		if(null == nitroBookingCnfrmDetails){
			System.out.println("Sorry for Inconvievence , we have an error in the system. Please try later.");
			return true;
		}
		return false;
	}
	
	public static void printErrorMessage(String message) {
		System.out.println("Error While Booking : " + message);
	}
	

}
