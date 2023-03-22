package com.epic_energy_services.gestione.clienti_fatture.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(EntityExistsException.class)
	protected ResponseEntity<String> manageEntityExistsException(EntityExistsException e){
		return new ResponseEntity<String>(e.getMessage() + " MyExceptionHandler!", HttpStatus.FOUND);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	protected ResponseEntity<String> manageEntityNotFoundException(EntityNotFoundException e){
		return new ResponseEntity<String>(e.getMessage() + " MyExceptionHandler!", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	protected ResponseEntity<String> manageIllegalArgumentException(IllegalArgumentException e){
		return new ResponseEntity<String>("Errore nel formato dei dati" + " MyExceptionHandler!", HttpStatus.NOT_FOUND);
	}
}
