package com.sapient.filereading.endpoint;

import java.util.List;

import com.sapient.filereading.model.CurrencyDto;

public interface FileReader {
	
	 public List<CurrencyDto> getFileReaderType(String fileType);
}
