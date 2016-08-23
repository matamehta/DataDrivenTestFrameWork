package mappers;

import java.util.ArrayList;
import java.util.List;

public class Results {

	private List<Groups> groups = new ArrayList<Groups>();
	
	private List<List<Long>> values = new ArrayList<List<Long>>();


	public List<Groups> getGroups() {
		return groups;
	}

	public void setGroups(List<Groups> groups) {
		this.groups = groups;
	}

	public List<List<Long>> getValues() {
		return values;
	}

	public void setValues(List<List<Long>> values) {
		this.values = values;
	}

	

}
