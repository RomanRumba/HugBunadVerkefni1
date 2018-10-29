package project.persistance.entities;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ErrorResponder {
	private List<Map<String, Object>> errors;
	private Map<String, Object> error;
	
	public ErrorResponder() {
		errors = new ArrayList<Map<String, Object>>();
		error = new HashMap<>();
	}
	

	public List<Map<String, Object>> getErrors() {
		return errors;
	}

	public void setErrors(String key, Object value) {
		Map<String, Object> x = new HashMap<>();
		x.put(key, value);
		this.errors.add(x);
	}

	public Map<String, Object> getError() {
		return error;
	}

	public void setError(String e) {
		this.error.put("error", e);
	}
	
	
}