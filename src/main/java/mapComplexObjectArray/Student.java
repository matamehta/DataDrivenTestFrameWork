package mapComplexObjectArray;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Student {

	private int id;
	
	private List<Integer> marks= new ArrayList<Integer>();
	private List<Integer> values= new ArrayList<Integer>();
	
	public List<Integer> getValues() {
		return values;
	}
	public void setValues(List<Integer> values) {
		this.values = values;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Integer> getMarks() {
		return marks;
	}

	public void setMarks(List<Integer> marks) {
		this.marks = marks;
	}

	
}
