package com;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import com.mashape.unirest.http.exceptions.UnirestException;

import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;

public class Stepformat {

	@Then("^I call '(.*)' webservice$")
	public void callWebServicesAPI(String apiName, DataTable table)
			throws InvalidKeyException, NoSuchAlgorithmException, UnirestException, UnsupportedEncodingException {
		WebServiceCalls.executeRESTAPI(apiName, table.cells());
	}

}
