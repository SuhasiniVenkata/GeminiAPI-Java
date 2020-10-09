package com;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.exceptions.UnirestException;

import gherkin.deps.com.google.gson.JsonParser;

public class NewOrderAPI {
	private static String jsonRes;

	public static void ordersCreate(HashMap<String, String> hash, Map<ArrayList<String>, ArrayList<String>> saveHash)
			throws UnirestException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {

		String request = hash.get("request");
		String client_order_id = hash.get("client_order_id");
		String symbol = hash.get("symbol");
		String amount = hash.get("amount");
		String min_amount = hash.get("min_amount");
		String price = hash.get("price");
		String side = hash.get("side");
		String type = hash.get("type");
		String stop_price = hash.get("stop_price");
		String order_id = hash.get("order_id");
		String account = hash.get("account");
		String options = hash.get("options");
		String gemini_api_secret = hash.get("gemini_api_secret");

		String jsonRequest = null;

		String url = System.getProperty("gemini.Order.URL") + request;
		ArrayList<Header> headersList = new ArrayList<Header>();

		headersList.add(new BasicHeader("X-GEMINI-APIKEY", "account-b2XgtpnYp85X08W4qipv"));
		headersList.add(new BasicHeader("Content-Type", "text/plain"));

		Header[] headersArray = new Header[headersList.size()];
		headersArray = headersList.toArray(headersArray);

		JSONObject jsonObj = new JSONObject();
		if (order_id != null) {
			jsonObj.put("order_id", order_id);
		}

		if (isNullEmpty(options)) {
			JSONArray opt = new JSONArray();
			opt.put("maker-or-cancel");
		}
		if (request != null) {
			jsonObj.put("request", request);
		}

		jsonObj.put("nonce", getPayloadNonce());

		if (client_order_id != null) {
			jsonObj.put("client_order_id", client_order_id);
		}
		if (symbol != null) {
			jsonObj.put("symbol", symbol);
		}
		if (amount != null) {
			jsonObj.put("amount", amount);
		}
		if (min_amount != null) {
			jsonObj.put("min_amount", min_amount);
		}
		if (price != null) {
			jsonObj.put("price", price);
		}
		if (side != null) {
			jsonObj.put("side", side);
		}
		if (type != null) {
			jsonObj.put("type", type);
		}
		if (stop_price != null) {
			jsonObj.put("stop_price", stop_price);
		}
		if (options != null) {
			jsonObj.put("options", options);
		}
		if (account != null) {
			jsonObj.put("account", account);
		}

		jsonRequest = jsonObj.toString();
		byte[] payload_bytes = jsonRequest.getBytes();
		String base64Encoded = DatatypeConverter.printBase64Binary(payload_bytes);
		headersList.add(new BasicHeader("X-GEMINI-PAYLOAD", base64Encoded));
		byte[] Secret_bytes = gemini_api_secret.getBytes();

		final String message = base64Encoded;
		SecretKeySpec signingKey = new SecretKeySpec(Secret_bytes, HMAC_SHA1_ALGORITHM);
		final Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
		mac.init(signingKey);
		String signature = bytesToHex(mac.doFinal(message.getBytes()));
		headersList.add(new BasicHeader("X-GEMINI-SIGNATURE", signature));

		headersArray = headersList.toArray(headersArray);

		System.out.println("json req: " + jsonRequest);
		System.out.println("base64: " + base64Encoded);
		System.out.println("headerArray: " + headersArray.toString());
		System.out.println("headerList: " + headersList.toString());
		System.out.println("URL: " + url);

		String jsonResponse = WebServiceDriver.TMRESTCall(url, "POST", "", headersArray).toString();
		System.out.println("jsonResponse: " + jsonResponse);

		JSONObject jsonObject = new JSONObject(jsonResponse);
		System.out.println("jsonObject:" + jsonObject);
		String id = jsonObject.getString("order_id");
		System.out.println(id);
		if (isNullEmpty(id)) {
			jsonObj.put("order_id", id);
		}

	}

	public static boolean isNullEmpty(String value) {
		if (value != null && !value.trim().isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	private static final String HMAC_SHA1_ALGORITHM = "HmacSHA384";

	private static String bytesToHex(final byte[] hash) {
		final StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < hash.length; i++) {
			final String hex = Integer.toHexString(0xff & hash[i]);
			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}

	private static String getPayloadNonce() {
		return "" + Instant.now().toEpochMilli();
	}

}
