package mapComplexObjectArray;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Pojoss {
	
	private List<Object> student= new ArrayList<Object>();

	public List<Object> getStudent() {
		return student;
	}

	public void setStudent(List<Object> student) {
		this.student = student;
	}


	
}
