package br.com.cherobim.erudio.exceptions.hendler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.cherobim.erudio.exceptions.ExceptionsResponse;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionsResponse> handleAllException(Exception ex, WebRequest request) {
		ExceptionsResponse exceptionresponse = new ExceptionsResponse(new Date(), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<>(exceptionresponse, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(UnsupportedOperationException.class)
	public final ResponseEntity<ExceptionsResponse> handleBadRequestExceptions(Exception ex, WebRequest request) {

		ExceptionsResponse exceptionresponse = new ExceptionsResponse(new Date(), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<>(exceptionresponse, HttpStatus.BAD_REQUEST);

	}

}
