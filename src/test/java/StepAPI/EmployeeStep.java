package StepAPI;

import java.io.File;

import org.hamcrest.Matchers;

import com.fasterxml.jackson.core.JsonProcessingException;

import BaseAPILayer.BaseAPI;
import Constant.CustomerEndpoints;
import Constant.EmployeeEndpoints;
import Payload.CustomerPayload;
import Payload.EmployeePayload;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class EmployeeStep extends BaseAPI {
	RequestSpecification httpRequest;
	Response response;
	ValidatableResponse validateResponse;
	static String EMPID;
	static String custId;

	@Given("user get the RequestSpecification object")
	public void user_get_the_request_specification_object() {
		httpRequest = BaseAPI.setUp();

	}

	@Given("user add Request Path Path Parameter for employee Endpoints")
	public void user_add_request_path_path_parameter_for_employee_endpoints() {
		httpRequest.pathParam("EMPID", EMPID);
	}

	@Given("user request Header as {string} and {string}")
	public void user_request_header_as_and(String key, String value) {
		httpRequest.header(key, value);
	}

	@Given("user add request payload from json file by passing {string} node name")
	public void user_add_request_payload_from_json_file_by_passing_node_name(String JsonNodeName)
			throws JsonProcessingException {
		httpRequest.body(EmployeePayload.getRequestPayload(JsonNodeName));
	}

	@When("user Select HTTP {string} for Employee Endpoints")
	public void user_select_http_for_employee_endpoints(String RequestType) {

		if (RequestType.equalsIgnoreCase("POST")) {
			response = httpRequest.post(EmployeeEndpoints.POST);
		} else if (RequestType.equalsIgnoreCase("GET")) {
			response = httpRequest.get(EmployeeEndpoints.GET);
		} else if (RequestType.equalsIgnoreCase("PUT")) {
			response = httpRequest.put(EmployeeEndpoints.PUT);
		} else if (RequestType.equalsIgnoreCase("PATCH")) {
			response = httpRequest.patch(EmployeeEndpoints.PATCH);
		} else if (RequestType.equalsIgnoreCase("DELETE")) {
			response = httpRequest.delete(EmployeeEndpoints.DELETE);
		}
	}

	@Then("user validate status code as {int}")
	public void user_validate_status_code_as(Integer code) {
		validateResponse = response.then().assertThat().statusCode(Matchers.equalTo(code));
	}

	@Then("user validate status line as {string}")
	public void user_validate_status_line_as(String line) {
		validateResponse.statusLine(Matchers.containsString(line));
	}

	@Then("user validate latency should below {int} ms")
	public void user_validate_latency_should_below_ms(Integer time) {
		validateResponse.time(Matchers.lessThan((long) time));
	}

	@Then("user validate {string} and {string} and {string}")
	public void user_validate_and_and(String firstName, String lastName, String address) {
		validateResponse.body(firstName, Matchers.equalTo(EmployeePayload.emp.getFirstName()));

		validateResponse.body(lastName, Matchers.equalTo(EmployeePayload.emp.getLastName()));

		validateResponse.body(address, Matchers.equalTo(EmployeePayload.emp.getAddress()));

	}

	@Then("user validate json Schema from {string}")
	public void user_validate_json_schema_from(String JsoSchemaFileName) {

		String path = System.getProperty("user.dir") + "//src//test//resources//JsonSchema//";

		File f = new File(path + JsoSchemaFileName + ".json");

		validateResponse.body(JsonSchemaValidator.matchesJsonSchema(f));

	}

	@Then("user generate response log")
	public void user_generate_response_log() {
		validateResponse.log().all();
	}

	@Then("user extract id from response payload")
	public void user_extract_id_from_response_payload() {
		EMPID = validateResponse.extract().body().jsonPath().getString("id");

	}

	@Given("user add Request Path Path Parameter for customer Endpoints")
	public void user_add_request_path_path_parameter_for_customer_endpoints() {
		httpRequest.pathParam("CUSTID", custId);
	}

	@Given("user add request customer payload from json file by passing {string} node name")
	public void user_add_request_customer_payload_from_json_file_by_passing_node_name(String jsonNodeName)
			throws JsonProcessingException {
		httpRequest.body(CustomerPayload.getRequestPayload(jsonNodeName));

	}

	@When("user Select HTTP {string} for Customer Endpoints")
	public void user_select_http_for_customer_endpoints(String RequestType) {

		if (RequestType.equalsIgnoreCase("POST")) {
			response = httpRequest.post(CustomerEndpoints.POST);
		}
		else if (RequestType.equalsIgnoreCase("GET")) {
			response = httpRequest.get(CustomerEndpoints.GET);
		} 
		else if (RequestType.equalsIgnoreCase("PUT")) {
			response = httpRequest.put(CustomerEndpoints.PUT);
		} 
		else if (RequestType.equalsIgnoreCase("PATCH")) {
			response = httpRequest.patch(CustomerEndpoints.PATCH);
		} else if (RequestType.equalsIgnoreCase("DELETE")) {
			response = httpRequest.delete(CustomerEndpoints.DELETE);
		}
	}

	@Then("user validate {string} and {string}")
	public void user_validate_and(String product_Name, String product_Discount) {

		validateResponse.body(product_Name, Matchers.equalTo(CustomerPayload.customer.getProduct_Name()));

		validateResponse.body(product_Discount, Matchers.equalTo(CustomerPayload.customer.getProduct_Discount()));

	}

	@Then("user extract id from customer response payload")
	public void user_extract_id_from_customer_response_payload() {
		custId = validateResponse.extract().body().jsonPath().getString("id");

	}

}
