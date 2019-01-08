package com.sapient.processingfeecalculator.util;

import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class UtilityClass {

	public static String getPropertyValue(String fileName, String key) {
		Map<String, ResourceBundle> RESOURCE_MAP = new HashMap<String, ResourceBundle>();
		String value = null;
		ResourceBundle resBundle = (ResourceBundle) RESOURCE_MAP.get(fileName);
		if (resBundle == null) {
			try {
				resBundle = ResourceBundle.getBundle(fileName);
				RESOURCE_MAP.put(fileName, resBundle);
			} catch (MissingResourceException ex) {
				resBundle = null;
			}
		}
		if (resBundle != null) {
			try {
				value = resBundle.getString(key);
			} catch (MissingResourceException ex) {
				value = null;
			}
		}
		return value;
	}

}
