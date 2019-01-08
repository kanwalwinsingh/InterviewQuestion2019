package com.sapient.processingfeecalculator.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.sapient.processingfeecalculator.bean.ProcessingFeeBean;
import com.sapient.processingfeecalculator.util.DateUtil;
import com.sapient.processingfeecalculator.util.ProcessingFeeBeanComparator;
import com.sapient.processingfeecalculator.util.ProcessingFeeConstants;
import com.sapient.processingfeecalculator.util.ProcessingFeeException;
import com.sapient.processingfeecalculator.util.ProcessingTypeEnum;

public class ProcessingFeeCalculatorService {

	public List<ProcessingFeeBean> calcNormalTransProcessFee(List<ProcessingFeeBean> objList) throws ProcessingFeeException{
		
		Iterator<ProcessingFeeBean> itr = objList.iterator();
		while(itr.hasNext()){
			ProcessingFeeBean objProcessFeeBean = itr.next();
			double transCharge = 0;
			if(objProcessFeeBean.getPriorityFlag().equals("Y")){
				transCharge = 500;
			}
			else if(objProcessFeeBean.getPriorityFlag().equals("N")){
				if(objProcessFeeBean.getTransType().equals(ProcessingFeeConstants.SELL) || objProcessFeeBean.getTransType().equals(ProcessingFeeConstants.WITHDRAW)){
					transCharge = 100;
				}
			}
			else if(objProcessFeeBean.getPriorityFlag().equals("N")){
				if(objProcessFeeBean.getTransType().equals(ProcessingFeeConstants.BUY) || objProcessFeeBean.getTransType().equals(ProcessingFeeConstants.DEPOSIT)){
					transCharge = 50;
				}
			}
			else{
				throw new ProcessingFeeException("Transaction does not meet any condition");
			}
			
			objProcessFeeBean.setTransCharge(transCharge);
			
		}
		
		return objList;
	}
	
	public List<ProcessingFeeBean> calcIntraTransProcessFee(List<ProcessingFeeBean> objList) throws ProcessingFeeException{
		
		Iterator<ProcessingFeeBean> itr = objList.iterator();
		while(itr.hasNext()){
			ProcessingFeeBean objProcessFeeBean = itr.next();
			if(objProcessFeeBean.getTransCharge() != 0 ){
				continue;
			}
			Date currentDate = new Date();
			currentDate.setHours(0);
			currentDate.setMinutes(0);
			currentDate.setSeconds(0); 
			currentDate = DateUtil.formatDateMMDDYYYY("01/06/2019");
			
			int dateCompare = currentDate.compareTo(objProcessFeeBean.getTransDate());
			
			if(dateCompare == 0){
				
				if(objProcessFeeBean.getTransType().equalsIgnoreCase(ProcessingFeeConstants.BUY)){
					
					ProcessingFeeBean objNewBean = new ProcessingFeeBean();
					objNewBean.setClientId(objProcessFeeBean.getClientId());
					objNewBean.setSecurityId(objProcessFeeBean.getSecurityId());
					objNewBean.setTransDate(objProcessFeeBean.getTransDate());
					objNewBean.setTransType(ProcessingFeeConstants.SELL);
					if(objList.indexOf(objNewBean) != -1){
						ProcessingFeeBean oppositBean = objList.get(objList.indexOf(objNewBean));
						oppositBean.setTransCharge(10);
						objProcessFeeBean.setTransCharge(10);
					}
					else{
						throw new ProcessingFeeException("Does not found opposite transaction for transaction id : " + objProcessFeeBean.getExtTransId());
					}
				}
				
				else if(objProcessFeeBean.getTransType().equalsIgnoreCase(ProcessingFeeConstants.SELL)){
					
					ProcessingFeeBean objNewBean = new ProcessingFeeBean();
					objNewBean.setClientId(objProcessFeeBean.getClientId());
					objNewBean.setSecurityId(objProcessFeeBean.getSecurityId());
					objNewBean.setTransDate(objProcessFeeBean.getTransDate());
					objNewBean.setTransType(ProcessingFeeConstants.BUY);
					
					if(objList.indexOf(objNewBean) != -1){
						ProcessingFeeBean oppositBean = objList.get(objList.indexOf(objNewBean));
						oppositBean.setTransCharge(10);
						objProcessFeeBean.setTransCharge(10);
					}
					else{
						throw new ProcessingFeeException("Does not found opposite transaction for transaction id : " + objProcessFeeBean.getExtTransId());
					}
					objProcessFeeBean.setTransCharge(10);
					
				}
				else if(objProcessFeeBean.getTransType().equalsIgnoreCase(ProcessingFeeConstants.WITHDRAW)){
					
					ProcessingFeeBean objNewBean = new ProcessingFeeBean();
					objNewBean.setClientId(objProcessFeeBean.getClientId());
					objNewBean.setSecurityId(objProcessFeeBean.getSecurityId());
					objNewBean.setTransDate(objProcessFeeBean.getTransDate());
					objNewBean.setTransType(ProcessingFeeConstants.DEPOSIT);
					
					if(objList.indexOf(objNewBean) != -1){
						ProcessingFeeBean oppositBean = objList.get(objList.indexOf(objNewBean));
						oppositBean.setTransCharge(10);
						objProcessFeeBean.setTransCharge(10);
					}
					else{
						throw new ProcessingFeeException("Does not found opposite transaction for transaction id : " + objProcessFeeBean.getExtTransId());
					}
					
				}
				else if(objProcessFeeBean.getTransType().equalsIgnoreCase(ProcessingFeeConstants.DEPOSIT)){
					
					ProcessingFeeBean objNewBean = new ProcessingFeeBean();
					objNewBean.setClientId(objProcessFeeBean.getClientId());
					objNewBean.setSecurityId(objProcessFeeBean.getSecurityId());
					objNewBean.setTransDate(objProcessFeeBean.getTransDate());
					objNewBean.setTransType(ProcessingFeeConstants.WITHDRAW);
					
					if(objList.indexOf(objNewBean) != -1){
						ProcessingFeeBean oppositBean = objList.get(objList.indexOf(objNewBean));
						oppositBean.setTransCharge(10);
						objProcessFeeBean.setTransCharge(10);
					}
					else{
						throw new ProcessingFeeException("Does not found opposite transaction for transaction id : " + objProcessFeeBean.getExtTransId());
					}
					
				}
			}
			else{
				System.out.println("Transaction can be processed for current date only for trans id : " + objProcessFeeBean.getExtTransId());
			}
			
		}
		
		return objList;
		
	}
	
	public void calculateProcessingFee(List<ProcessingFeeBean> objList, ProcessingTypeEnum objEnum) throws ProcessingFeeException{
		
		ProcessingFeeCalculatorService objservice = new ProcessingFeeCalculatorService();
		
		if(objEnum == ProcessingTypeEnum.INTRADAY){
			objservice.calcIntraTransProcessFee(objList);
		}
		else if(objEnum == ProcessingTypeEnum.NORMAL){
			objservice.calcNormalTransProcessFee(objList);
		}
		
	}
	
	public void generateReportCSV(List<ProcessingFeeBean> objBean, String filePath) throws ProcessingFeeException{
		
		Collections.sort(objBean, new ProcessingFeeBeanComparator());
		
		File file = new File(filePath);
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file));
			
			StringBuilder headerRow = new StringBuilder("");
			headerRow.append("Client Id"+"\t");
			headerRow.append("Trans Type"+"\t");
			headerRow.append("Trans Date"+"\t");
			headerRow.append("Priority Flag"+"\t");
			headerRow.append("Trans Charge"+"\t");
			
			bw.write(headerRow.toString());
			
			bw.newLine();
			
			
			Iterator<ProcessingFeeBean> objItr = objBean.iterator();
			while(objItr.hasNext()){
				ProcessingFeeBean objProcessingFeeBean = objItr.next();
				StringBuilder row = new StringBuilder("");
				row.append(objProcessingFeeBean.getClientId()+"\t");
				row.append(objProcessingFeeBean.getTransType()+"\t");
				row.append(objProcessingFeeBean.getTransDate()+"\t");
				row.append(objProcessingFeeBean.getPriorityFlag()+"\t");
				row.append(objProcessingFeeBean.getTransCharge()+"\t");
				
				bw.write(row.toString());
				
				bw.newLine();
				
			}
			 
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				bw.close();
			} catch (IOException e) {
				throw new ProcessingFeeException("Exception occurent while closing write operation.");
			}
		}
		
	}
	
	
}
