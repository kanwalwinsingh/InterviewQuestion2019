package com.sapient.filereading.impl;

import com.sapient.filereading.endpoint.FileReader;

public class FileReaderFactory {
	
	public static FileReader getFileType(String FileType){
	
	if(FileType.contains("csv"))
		return new CSVReader();
	else if(FileType.contains("txt"))
		return new TXTReader();
	else if(FileType.contains("xml"))
		return new XMLReader();
	else return null;

}}
