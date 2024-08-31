package Reader;

import java.io.File;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReader {

	private static String path = System.getProperty("user.dir") + "//src//test//resources//TestData//";

	// create static method with dynamic POJO class return type and 3 String
	// arguments

	public static <T> T readJsonFile(String JsonFileName, String JsonNodeName, Class<T> pojoClassName) {

		File f = new File(path + JsonFileName + ".json");

		ObjectMapper mapper = new ObjectMapper();
		try 
		{
			JsonNode jsonNode = mapper.readTree(f);
			return mapper.treeToValue(jsonNode.get(JsonNodeName), pojoClassName);
		} 
		catch (Exception e) {
			e.getLocalizedMessage();
		}

		return null;
	}

}
