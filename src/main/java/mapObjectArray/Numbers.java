package mapObjectArray;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Numbers {
	@JsonProperty("numbers")
	private List<List<Long>> Numbers1= new ArrayList<List<Long>>();


	public List<List<Long>> getNumbers1() {
		return Numbers1;
	}

	public void setNumbers1(List<List<Long>> numbers1) {
		Numbers1 = numbers1;
	}
}
