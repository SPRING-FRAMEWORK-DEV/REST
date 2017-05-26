package com.spring.exception;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Component
public class ApplicationExceptionProcessor {

	public ApplicationExceptionProcessor() {
		super();
		// TODO Auto-generated constructor stub

	}

	@ExceptionHandler(UserAuthException.class)
	// @ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorMessage userAuthFailed(HttpServletRequest req, UserAuthException ex) {

		String errorMessage = null;

		errorMessage = ex.getMessage();

		ErrorMessage em = new ErrorMessage("11401", errorMessage);

		System.out.println("Error Handler");
		return em;
	}

}