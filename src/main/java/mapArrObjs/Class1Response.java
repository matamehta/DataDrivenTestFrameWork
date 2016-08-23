package mapArrObjs;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;

public class Class1Response {

	private List<Class1> class1;


	public List<Class1> getClass1() {
		return class1;
	}

	@JsonCreator
	public void setClass1(List<Class1> class1) {
		this.class1 = class1;
	}
}
