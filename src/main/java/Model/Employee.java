package Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee {
	
	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("address")
	private String address;

	@JsonProperty("mobileNumber")
	private long mobileNumber;

	@JsonProperty("gender")
	private String gender;

}
