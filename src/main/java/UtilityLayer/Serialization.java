package UtilityLayer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Serialization {

	public static String convertToJsonOfString(Object pojoClassName) throws JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();

		String requestPayload = mapper.writeValueAsString(pojoClassName);

		return requestPayload;

	}

}
