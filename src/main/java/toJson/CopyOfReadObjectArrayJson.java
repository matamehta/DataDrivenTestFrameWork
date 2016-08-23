package toJson;

import java.io.FileInputStream;
import java.io.IOException;






import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import copyMapObjectArray.Numbers;
public class CopyOfReadObjectArrayJson {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		 //Read from file
		ObjectMapper mapper = new ObjectMapper();
		 mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		 
		 Numbers values = mapper.readValue(new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/Copy of ObjectArray.json"), Numbers.class );
		 System.out.println(values.getNumbers());
		 
		 for(int i=0;i<values.getNumbers().size();i++){
			 System.out.println("Values from "+(i+1) +"array is");
				 System.out.println(values.getNumbers().get(i));
			 }
		 System.out.println(values.getNumber1());
		 
		 for(int i=0;i<values.getNumber1().size();i++){
			 System.out.println("Values from "+(i+1) +"array is");
			 System.out.println(values.getNumber1().get(i));
			 }
		 
		 System.out.println(values.getStudent());
		 }
	
	 

	}
	
