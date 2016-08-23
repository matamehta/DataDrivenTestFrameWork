package toJson;

import java.io.FileInputStream;
import java.io.IOException;



import mappers.TimeStamps;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
public class ReadJSONWithObjectMapper {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		 //Read from file
		ObjectMapper mapper = new ObjectMapper();
		 mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		 
		 TimeStamps tag1s = mapper.readValue(new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/response.json"), TimeStamps.class );
		/* System.out.println(tag1s.getTags().get(0).getName());
		 System.out.println(tag1s.getTags().get(0).getResults().get(0).getGroups().get(0).getType());
		 System.out.println(tag1s.getTags().get(0).getStatobj().getRawCount());*/
		 System.out.println(tag1s.getTags().get(0).getResults().get(0).getValues().get(0).get(0));
		 System.out.println(tag1s.getTags().get(0).getResults().get(0).getValues().get(0).get(1));
		 System.out.println(tag1s.getTags().get(0).getResults().get(0).getValues().get(0).get(2));
		 //System.out.println(tag1s.getTags().get(0).getResults().get(0).getValues().size());
	}
	
	
	}