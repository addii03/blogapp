package blog_app_api.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GloablExceptionHandling {

	@ExceptionHandler(CustomBlogException.class)
	public ResponseEntity<?> customExceptionHandler(CustomBlogException exception, WebRequest webRequest) {
		ErrorDetails errorDetails = new ErrorDetails(webRequest.getDescription(false), exception.getMessage(),
				new Date(0));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalException(Exception exception, WebRequest webRequest) {
		ErrorDetails errorDetails = new ErrorDetails(webRequest.getDescription(false), exception.getMessage(),
				new Date(3));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
