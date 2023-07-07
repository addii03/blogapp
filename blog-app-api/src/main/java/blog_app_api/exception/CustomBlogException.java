package blog_app_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (value = HttpStatus.NOT_FOUND)
public class CustomBlogException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomBlogException(String message)
	{
		super(message);
	}
	
}
