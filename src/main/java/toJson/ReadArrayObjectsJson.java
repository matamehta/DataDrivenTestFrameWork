package toJson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.BlockingQueue;
import java.io.FileInputStream;
import java.io.IOException;

















import mapArrObjs.Class1;
import mapArrObjs.Class1Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
public class ReadArrayObjectsJson {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		 //Read from file
		ObjectMapper mapper = new ObjectMapper();
		 mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		 
		 
		 Deque<Class1> obj = mapper.readValue(new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/ArrayOfObjects.json"),mapper.getTypeFactory().constructCollectionType(Deque.class, Class1.class));
				for(Class1 c:obj){
					System.out.println("a "+c.getA());
					System.out.println("b "+c.getB());
				}
		
/*		 Class1Response obj = mapper.readValue(new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/ArrayOfObjects.json"),mapper.getTypeFactory().constructRawCollectionLikeType(Class1Response.class));
		System.out.println(obj.getClass1().get(0).getA());*/
	}
	
	
	}