package project.persistance.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * This class is for wrapping data in json objects
 * @author Vilhelml
 * @since 20.10.18
 *
 */
public class UserResponder {
	protected String username;
	protected String displayName;
	
	public UserResponder(User user) {
		this.username = user.getUsername();
		this.displayName = user.getDisplayName();
	}
	
	/**
	 * constructor notað af spring controller til að vinna með json objects
	 * @param username
	 * @param password
	 * @param displayName
	 * @param email
	 */
	public UserResponder(String username, String displayName) {
		this.username = username;
		this.displayName = displayName;
	}
	
	/**
	 * wrap the response
	 * @return wrapped response
	 */
	public Object wrapResponse() {
		Map<String, UserResponder> wrapper = new HashMap<>();
		wrapper.put("GoodResp", this);
		return wrapper;
	}
	
	// getters

	public String getUsername() {
		return username;
	}


	public String getDisplayName() {
		return displayName;
	}	
	
}
