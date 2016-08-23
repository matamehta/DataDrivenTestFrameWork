package pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mappers.TimeStamps;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.impl.JsonReadContext;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonReader {
	ObjectMapper mapper;
	TimeStamps object;
	
	public JsonReader(){
		 mapper = new ObjectMapper();
		 mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		 try {
			 object = mapper.readValue(new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/response.json"), TimeStamps.class );
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getName(){
		return object.getTags().get(0).getName();
	}
	
	public Integer getRawCount(){
		return object.getTags().get(0).getStatobj().getRawCount();
	}
	
	public String getType(){
		return object.getTags().get(0).getResults().get(0).getGroups().get(0).getType();
	}
	
	public List<Long> getMilliSeconds(){
	List<List<Long>> objects=	object.getTags().get(0).getResults().get(0).getValues();
	List<Long> timeStamp= new ArrayList<Long>();
	for(int i=0;i<objects.size();i++){
		timeStamp.add(objects.get(i).get(0));
	}
	return timeStamp;
	}
	
	public List<Long> getValues(){
	List<List<Long>> objects=	object.getTags().get(0).getResults().get(0).getValues();
	List<Long> timeStamp= new ArrayList<Long>();
	for(int i=0;i<objects.size();i++){
		timeStamp.add(objects.get(i).get(1));
	}
	return timeStamp;
	}
	
	public List<Long> getStatus(){
	List<List<Long>> objects=	object.getTags().get(0).getResults().get(0).getValues();
	List<Long> timeStamp= new ArrayList<Long>();
	for(int i=0;i<objects.size();i++){
		timeStamp.add(objects.get(i).get(2));
	}
	return timeStamp;
	}
	
	public static void main(String[] args) {
		JsonReader read= new JsonReader();
		System.out.println(read.getMilliSeconds());
		System.out.println(read.getValues());
		System.out.println(read.getStatus());
		System.out.println(read.getMilliSeconds().size());
		System.out.println(read.getValues().size());
		System.out.println(read.getStatus().size());
	}
	
}
