package toJson;

import java.io.FileInputStream;
import java.io.IOException;




import mapObjectArray.Numbers;
import mappers.TimeStamps;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
public class ReadObjectArrayJson {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		 //Read from file
		ObjectMapper mapper = new ObjectMapper();
		 mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		 
		 Numbers values = mapper.readValue(new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/ObjectArray.json"), Numbers.class );
		 System.out.println(values.getNumbers1().get(0));
		 
		 for(int i=0;i<values.getNumbers1().size();i++){
			 System.out.println("Values from "+(i+1) +"array is");
			 for(long j: values.getNumbers1().get(i)){
				 System.out.println(j);
			 }
		 }

	}
	
	
	}