package mappers;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Tags {
	@JsonProperty("results")
	private List<Results> results = new ArrayList<Results>();
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("stats")
	private Stats statobj;
	
	public Tags(){
		
	}
	
	public Tags(String name, List<Results> results,Stats statobj ){
		this.name=name;
		this.results=results;
		this.statobj=statobj;
		
	}
	
	public Stats getStatobj() {
		return statobj;
	}
	public void setStatobj(Stats statobj) {
		this.statobj = statobj;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Results> getResults() {
		return results;
	}
	public void setResults(List<Results> results) {
		this.results = results;
	}
	
}
