package com.api.payment.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.api.payment.logger.Log;

@ControllerAdvice
public class GlobalExceptionHandler {
	public GlobalExceptionHandler() {

	}

	@Resource(name = "${log.implement.active}")
	Log logger;

	// handle specific exception
	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException e) {

		ErrorDetails error = new ErrorDetails("NOT_FOUND_ERROR", e.getMessage(), LocalDateTime.now());
		error.setStatus((HttpStatus.NOT_FOUND.value()));
		logger.logerror(e.getMessage());
		return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> handleValidationExceptions(ConstraintViolationException e) {
		List<ErrorDetails> error = new ArrayList<ErrorDetails>();
		for (ConstraintViolation cv : e.getConstraintViolations()) {
			logger.logerror(cv.getMessage());
			error.add(new ErrorDetails("VALIDATION_ERROR", cv.getMessage(), (HttpStatus.BAD_REQUEST.value()),
					LocalDateTime.now()));
		}
		return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<?> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex) {
		StringBuilder builder = new StringBuilder();
		builder.append(ex.getContentType());
		builder.append(" media type is not supported. Supported media types are ");
		ex.getSupportedMediaTypes().forEach(t -> builder.append(t).append(", "));
		ErrorDetails error = new ErrorDetails("UNSUPPORTED_MEDIA_TYPE", builder.toString(),
				(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()), LocalDateTime.now());
		logger.logerror(ex.getMessage());
		
		return new ResponseEntity(error, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<?> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {
		ErrorDetails error = new ErrorDetails("ARGUMENT_TYPE_MISMATCH", ex.getMessage(), (HttpStatus.BAD_REQUEST.value()),
				LocalDateTime.now());
		logger.logerror(ex.getMessage());
		return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	}


	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<?> handleInvalidFormatException(HttpMessageNotReadableException ex)
	{
		ErrorDetails error = new ErrorDetails("MALPERFORMED_JSON", ex.getMessage(), (HttpStatus.BAD_REQUEST.value()),
				LocalDateTime.now());
		logger.logerror(ex.getMessage());
		return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	}
//	// global exception
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> handleGlobalException(Exception e) {

		ErrorDetails error = new ErrorDetails("INTERNAL_SERVER_ERROR", e.getMessage(), LocalDateTime.now());
		error.setStatus((HttpStatus.INTERNAL_SERVER_ERROR.value()));
		logger.logerror(e.getMessage());
		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
