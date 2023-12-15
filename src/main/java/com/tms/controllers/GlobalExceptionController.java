package com.tms.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.tms.exceptions.TerminalAlreadyExistException;
import com.tms.exceptions.TerminalNotRegisteredException;
import com.tms.models.reponse.ErrorRes;

@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(value = TerminalNotRegisteredException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorRes handleException(TerminalNotRegisteredException ex) {
		return new ErrorRes(HttpStatus.NOT_FOUND, ex.getMessage());
	}


	@ExceptionHandler(value = TerminalAlreadyExistException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorRes handleException(TerminalAlreadyExistException ex) {
		return new ErrorRes(HttpStatus.BAD_REQUEST, ex.getMsg());
	}
}
