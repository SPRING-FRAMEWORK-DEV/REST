package com.spring.rest.exceptions;

public class ErrorMessage {
	
	private String errorCode;
	private String errorMessage;
	private String documentationLink;
	
	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorMessage(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public ErrorMessage(String errorCode, String errorMessage,
			String documentationLink) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.documentationLink = documentationLink;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getDocumentationLink() {
		return documentationLink;
	}

	public void setDocumentationLink(String documentationLink) {
		this.documentationLink = documentationLink;
	}

	@Override
	public String toString() {
		return "ErrorMessage [errorCode=" + errorCode + ", errorMessage="
				+ errorMessage + ", documentationLink=" + documentationLink
				+ "]";
	}
	
	

	
	


}
