package com;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Base64;

import com.mashape.unirest.http.exceptions.UnirestException;

import org.apache.http.Header;
import org.apache.http.HttpResponse;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import org.junit.Assert;

public class WebServiceDriver {

	public static int statusCode = 0;

	public static String TMRESTCall(String url, String Method, String jsonRequest, Header[] header)
			throws UnirestException {

		HttpPost postRequest = null;
		HttpResponse originalresponse = null;
		String output;
		StringBuilder result = new StringBuilder();

		try {

			CloseableHttpClient httpClient = HttpClientBuilder.create().build();
			System.out.println("httpClient :" + httpClient.toString());
			if (Method.equalsIgnoreCase("POST")) {
				postRequest = new HttpPost(url);
				StringEntity input = new StringEntity(jsonRequest);
				System.out.println("postRequest: " + postRequest);

				postRequest.setEntity(input);
				if (header != null) {
					postRequest.setHeaders(header);
					postRequest.setHeader("accept", "text/plain");
					postRequest.setHeader("Content-type", "text/plain");
				}
			}

			originalresponse = httpClient.execute(postRequest);
			String response = originalresponse.toString();
			System.out.println("response: " + response);

			statusCode = originalresponse.getStatusLine().getStatusCode();

			Assert.assertTrue("Status code : " + statusCode,
					statusCode == 200 || statusCode == 201 || statusCode == 204);

			if (statusCode == 200 || statusCode == 201 || statusCode == 204) {
				System.out.println("Passed : HTTP code : " + statusCode);
			} else {
				System.out.println("Failed : HTTP error code : " + statusCode);
			}

			if (originalresponse.getEntity() != null) {
				BufferedReader br = new BufferedReader(
						new InputStreamReader((originalresponse.getEntity().getContent())));

				while ((output = br.readLine()) != null) {
					result.append(output);
				}
				System.out.println("Result from Server: " + result.toString().trim());
			} else {
				System.out.println("Result from Server: " + response.toString().trim());
			}

			httpClient.close();

		} catch (Exception ex) {
			System.out.println("ERROR HTTP REQUEST: " + ex.getMessage());
		}

		return result.toString().trim();
	}

	public String encodeBase64(byte[] encodeMe) {
		byte[] encodedBytes = Base64.getEncoder().encode(encodeMe);
		return new String(encodedBytes);
	}

}
