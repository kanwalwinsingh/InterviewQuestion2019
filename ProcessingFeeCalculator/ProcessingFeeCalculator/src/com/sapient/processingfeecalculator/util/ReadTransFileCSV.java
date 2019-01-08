package com.sapient.processingfeecalculator.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sapient.processingfeecalculator.bean.ProcessingFeeBean;

public class ReadTransFileCSV {

	public static void main(String args[]) {
		String path = "E:\\eclipse_kepler\\workspace\\ProcessingFeeCalculator\\src\\SampleFiles//SampleData.csv";

		try {
			readFile(path);
			readDataFromCsv(path);
		} catch (ProcessingFeeException e) {
			e.printStackTrace();
		}

	}

	public static List<ProcessingFeeBean> readDataFromCsv(String path)
			throws ProcessingFeeException {
		System.out.println("Start");
		List<ProcessingFeeBean> processingBeanList = new ArrayList<ProcessingFeeBean>() ;
		File file = new File(path);
		if(file.exists()){
			BufferedReader br = null;
			FileReader fileReader =null;
			try{
				fileReader = new FileReader(file);
				br = new BufferedReader(fileReader);
				String s = "";
				while((s = br.readLine()) != null){
					String arr[] = s.split(ProcessingFeeConstants.CSV_DELIM);
					if(arr != null && arr.length == 7){
						System.out.println(arr);
						processingBeanList.add(setData(arr));
					}
				}
			}catch(FileNotFoundException e){
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (Exception e) {
				throw new ProcessingFeeException("Some exception occured");
			} finally {
				try {
					br.close();
				} catch (IOException e) {
					throw new ProcessingFeeException(
							"Error occured while closing File");
				}
				try {
					fileReader.close();
				} catch (IOException e) {
					throw new ProcessingFeeException(
							"Error occured while closing File");
				}
			}
		}
		return processingBeanList;
	}

	public static List<ProcessingFeeBean> readFile(String filePath)
			throws ProcessingFeeException {

		ArrayList<ProcessingFeeBean> processingBeanList = new ArrayList<ProcessingFeeBean>();

		File file = new File(filePath);
		if (file.exists()) {
			BufferedReader br = null;
			FileReader fr = null;
			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				String s = "";
				while ((s = br.readLine()) != null) {
					String arr[] = s.split(ProcessingFeeConstants.CSV_DELIM);

					if (arr != null && arr.length == 7) {

						ProcessingFeeBean objProcessingFeebean = new ProcessingFeeBean();
						objProcessingFeebean.setExtTransId(arr[0]);
						objProcessingFeebean.setClientId(arr[1]);
						objProcessingFeebean.setSecurityId(arr[2]);
						objProcessingFeebean.setTransType(arr[3]);

						Date transdate = DateUtil.formatDateMMDDYYYY(arr[4]);
						objProcessingFeebean.setTransDate(transdate);

						try {
							double marketValue = Double.parseDouble(arr[5]);
							objProcessingFeebean.setMarketValue(marketValue);
						} catch (Exception e) {
							throw new ProcessingFeeException(
									"Provided market value should be double value");
						}
						objProcessingFeebean.setPriorityFlag(arr[6]
								.toUpperCase());

						processingBeanList.add(objProcessingFeebean);

					} else {
						throw new ProcessingFeeException(
								"No of parameters provided in the file does not match to required");
					}
				}

			} catch (FileNotFoundException e) {
				throw new ProcessingFeeException("File does not exists");
			} catch (IOException e) {
				throw new ProcessingFeeException("Some error occured");
			} catch (Exception e) {
				throw new ProcessingFeeException("Some exception occured");
			} finally {
				try {
					br.close();
				} catch (IOException e) {
					throw new ProcessingFeeException(
							"Error occured while closing File");
				}
				try {
					fr.close();
				} catch (IOException e) {
					throw new ProcessingFeeException(
							"Error occured while closing File");
				}
			}
		} else {
			throw new ProcessingFeeException("File does not exists");
		}

		return processingBeanList;

	}
	
	public static ProcessingFeeBean setData(String [] arr) throws ProcessingFeeException{
		ProcessingFeeBean objProcessingFeebean = new ProcessingFeeBean();
		objProcessingFeebean.setExtTransId(arr[0]);
		objProcessingFeebean.setClientId(arr[1]);
		objProcessingFeebean.setSecurityId(arr[2]);
		objProcessingFeebean.setTransType(arr[3]);

		Date transdate = DateUtil.formatDateMMDDYYYY(arr[4]);
		objProcessingFeebean.setTransDate(transdate);
		try {
			double marketValue = Double.parseDouble(arr[5]);
			objProcessingFeebean.setMarketValue(marketValue);
		} catch (Exception e) {
			throw new ProcessingFeeException(
					"Provided market value should be double value");
		}
		objProcessingFeebean.setPriorityFlag(arr[6]
				.toUpperCase());
		return objProcessingFeebean;
		
	}

}
