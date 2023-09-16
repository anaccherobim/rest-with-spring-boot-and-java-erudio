package br.com.cherobim.erudio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMethOperationException extends RuntimeException {

	public UnsupportedMethOperationException(String ex) {
		super(ex);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;}