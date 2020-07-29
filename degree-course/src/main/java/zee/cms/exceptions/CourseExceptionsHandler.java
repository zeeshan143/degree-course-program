package zee.cms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CourseExceptionsHandler {

	@ExceptionHandler // For CourseNotFoundException
	public ResponseEntity<CourseErrorResponse> handleException(CourseNotFoundException exc) {
		CourseErrorResponse error = new CourseErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value()); // We are setting the response class fields. 
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	 }
	@ExceptionHandler // For any other exception in Course
	public ResponseEntity<CourseErrorResponse> handleExceptionCourse(Exception exc) {
		CourseErrorResponse error = new CourseErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
