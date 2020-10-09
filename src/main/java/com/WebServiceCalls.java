package com;

import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.mashape.unirest.http.exceptions.UnirestException;

public class WebServiceCalls {
	public WebServiceCalls() {

	}

	public static void executeRESTAPI(String apiName, List<List<String>> tableData)
			throws InvalidKeyException, NoSuchAlgorithmException, UnirestException, UnsupportedEncodingException {
		WebServiceCalls webser = new WebServiceCalls();
		webser.loadProperties("services.properties");
		String appName = apiName.toLowerCase();
		if (appName.contains("gemini")) {
			execGeminiRESTAPI(apiName, tableData);
		}

	}

	static void execGeminiRESTAPI(String apiName, List<List<String>> tableData)
			throws InvalidKeyException, NoSuchAlgorithmException, UnirestException, UnsupportedEncodingException {

		HashMap<String, String> hash = Utilities.setDataMap(tableData);

		Map<ArrayList<String>, ArrayList<String>> saveHash = Utilities.setDuplicateKeysDataMap(tableData);
		if (apiName.toLowerCase().contains("gemini new order create and cancel")) {
			System.out.println("Gemini Orders Create and cancel");
			try {
				NewOrderAPI.ordersCreate(hash, saveHash);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

	public void loadProperties(String prpFileName) {
		try {
			java.net.URL url = this.getClass().getResource(prpFileName);
			// this.getClass().getResource(prpFileName);
			String filename = url.getFile().replace("%20", " ");
			FileInputStream propFile = new FileInputStream(filename);
			Properties p = new Properties(System.getProperties());
			p.load(propFile);
			System.setProperties(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
