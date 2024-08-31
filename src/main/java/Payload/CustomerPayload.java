package Payload;

import com.fasterxml.jackson.core.JsonProcessingException;

import Model.Customer;
import Reader.JsonReader;
import UtilityLayer.Serialization;

public class CustomerPayload {

	public static Customer customer;
	
	public static String getRequestPayload(String jsonNodeName) throws JsonProcessingException {

		customer = JsonReader.readJsonFile("customerTestData", jsonNodeName, Customer.class);

		String requestPayload = Serialization.convertToJsonOfString(customer);

		return requestPayload;
	}

}
