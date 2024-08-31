package Payload;

import com.fasterxml.jackson.core.JsonProcessingException;

import Model.Employee;
import Reader.JsonReader;
import UtilityLayer.Serialization;

public class EmployeePayload {
	public static Employee emp;
	
	public static String getRequestPayload(String JsonNodeName) throws JsonProcessingException {

		// call JsonReader method Reader Package
		emp = JsonReader.readJsonFile("employeeTestData", JsonNodeName, Employee.class);

		String requestPayload = Serialization.convertToJsonOfString(emp);
		return requestPayload;
	}
	
	
	

}
