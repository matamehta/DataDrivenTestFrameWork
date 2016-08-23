package toJson;

import java.io.FileInputStream;
import java.io.IOException;


import mapComplexObjectArray.Pojoss;
import mapComplexObjectArray.Student;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
public class ReadComplexObjectArrayJson {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		 //Read from file
		ObjectMapper mapper = new ObjectMapper();
		 mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		 
		 Pojoss obj = mapper.readValue(new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/ComplexObjectArray.json"), Pojoss.class);
		 System.out.println((Student)obj.getStudent().get(0));
		/* Student readValue = mapper.readValue(obj.getStudent().get(0).toString(), Student.class);
		 System.out.println(readValue.getId());*/

	}
	
	
	}