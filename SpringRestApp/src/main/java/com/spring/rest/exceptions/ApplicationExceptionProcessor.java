package com.spring.rest.exceptions;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger log = LoggerFactory
			.getLogger(ApplicationExceptionProcessor.class);

	public ApplicationExceptionProcessor() {
		super();
		// TODO Auto-generated constructor stub
		log.debug("RestExceptionMapper");
		;
	}

	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorMessage userNotFound(HttpServletRequest req,
			UserNotFoundException ex) {
		Locale locale = LocaleContextHolder.getLocale();
		String errorMessage = messageSource.getMessage("error.no.user.id",
				null, locale);

		errorMessage += ex.getMessage();

		ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND.toString(),
				errorMessage, "");
		printLog(ex, em);

		return em;
	}

	@ExceptionHandler(DuplicateEmailException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorMessage duplicateEmailFound(HttpServletRequest req,
			DuplicateEmailException ex) {
		Locale locale = LocaleContextHolder.getLocale();
		String errorMessage = messageSource.getMessage(
				"error.duplicate.email.key", null, locale);

		errorMessage += ex.getMessage();

		ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND.toString(),
				errorMessage, "");
		printLog(ex, em);

		return em;
	}

	@ExceptionHandler(Throwable.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorMessage genericHandler(HttpServletRequest req, Throwable ex) {
		Locale locale = LocaleContextHolder.getLocale();
		String errorMessage = messageSource.getMessage("error.internal.server",
				null, locale);

		errorMessage += ex.getMessage();

		ErrorMessage em = new ErrorMessage(
				HttpStatus.INTERNAL_SERVER_ERROR.toString(), errorMessage, "");
		printLog(ex, em);

		return em;
	}

	// print message to log file and displays in console
	private void printLog(Throwable ex, ErrorMessage em) {
		log.error(em.toString());
		log.error(ex.getMessage());
	}

}