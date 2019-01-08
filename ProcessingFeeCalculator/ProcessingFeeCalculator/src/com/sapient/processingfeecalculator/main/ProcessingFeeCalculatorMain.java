package com.sapient.processingfeecalculator.main;

import java.util.List;

import com.sapient.processingfeecalculator.bean.ProcessingFeeBean;
import com.sapient.processingfeecalculator.service.ProcessingFeeCalculatorService;
import com.sapient.processingfeecalculator.util.ProcessingFeeException;
import com.sapient.processingfeecalculator.util.ProcessingTypeEnum;
import com.sapient.processingfeecalculator.util.ReadTransFileCSV;

public class ProcessingFeeCalculatorMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//E:\eclipse_kepler\workspace\ProcessingFeeCalculator\src\SampleFiles
		
		String filePath = "F:\\Recovered data\\intQuesAnsBooks\\InterviewQuestion2019\\ProcessingFeeCalculator\\ProcessingFeeCalculator\\src\\SampleFiles\\SampleData.csv";
		String filePathReport = "F:\\Recovered data\\intQuesAnsBooks\\InterviewQuestion2019\\ProcessingFeeCalculator\\ProcessingFeeCalculator\\src\\SampleFiles\\SampleDataReport.csv";
		try {
		
			List<ProcessingFeeBean> processingFeebeanList = ReadTransFileCSV.readFile(filePath);
			
			ProcessingFeeCalculatorService objService = new ProcessingFeeCalculatorService();
			
			objService.calculateProcessingFee(processingFeebeanList, ProcessingTypeEnum.INTRADAY);
			
			System.out.println(processingFeebeanList);
			
			objService.generateReportCSV(processingFeebeanList, filePathReport);
			
		} catch (ProcessingFeeException e) {
			System.out.println("Exception is : " + e.getMessage());
		}
	}
	
	
	
}
