package com.sapient.filereading.impl;



import static org.junit.Assert.*;

import org.junit.Test;

public class FileReaderFactoryTest {
	
	@Test
	public void testgetFileType(){
		FileReaderFactory fc= new FileReaderFactory();
		assertNotNull(fc.getFileType("C:\\sample.csv"));
	}
	
}
