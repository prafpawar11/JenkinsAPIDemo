package BaseAPILayer;

import Reader.PropertyReader;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseAPI {
	
	
	public static RequestSpecification setUp()
	{
		RestAssured.baseURI=PropertyReader.getProperty("BASEURI");
		
		return RestAssured
				.given()
				.and()
				.log()
				.all();
	}

}
