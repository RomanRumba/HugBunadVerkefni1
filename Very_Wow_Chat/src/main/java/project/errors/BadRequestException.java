package project.errors;

import org.springframework.http.HttpStatus;

/**
 * A custom exception class for throwing and catching errors
 * @author Vilhelml
 *
 */
public class BadRequestException extends HttpException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7351780997818125521L;

	public BadRequestException (String msg) {
		super(msg);
		super.setStatus(HttpStatus.BAD_REQUEST);
	}
}