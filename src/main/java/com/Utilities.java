package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utilities {

	private static ArrayList<String> keys = new ArrayList<String>();
	private static ArrayList<String> values = new ArrayList<String>();

	public static HashMap<String, String> setDataMap(List<List<String>> tableData) {

		HashMap<String, String> dataMap = new HashMap<String, String>();

		for (List<String> row : tableData) {
			int i = 0;
			String value = row.get(i + 1);
			System.out.print(value);
			int rs = row.size();
			System.out.print(rs);
			while (i < rs) {
				String field = row.get(i);
				dataMap.put(field.toLowerCase(), value);
				i += 2;
			}
		}
		return dataMap;
	}

	public static Map<ArrayList<String>, ArrayList<String>> setDuplicateKeysDataMap(List<List<String>> tableData) {

		Map<ArrayList<String>, ArrayList<String>> multiMap = new HashMap<ArrayList<String>, ArrayList<String>>();

		keys.clear();
		values.clear();

		for (List<String> row : tableData) {
			int i = 0;
			while (i < row.size()) {
				keys.add(row.get(i));
				values.add(row.get(i + 1));
				i += 2;
			}
		}
		multiMap.put(keys, values);

		return multiMap;
	}

	
	

}
