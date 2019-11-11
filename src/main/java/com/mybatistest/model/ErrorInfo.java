package com.mybatistest.model;

public class ErrorInfo {
	
	private Integer errorCount;
	private String errorDescription;
	private String errorMessage;
	private String errorCode;
	private String errorField;
	private String errorObjectName;
	
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorField() {
		return errorField;
	}
	public void setErrorField(String errorField) {
		this.errorField = errorField;
	}
	public String getErrorObjectName() {
		return errorObjectName;
	}
	public void setErrorObjectName(String errorObjectName) {
		this.errorObjectName = errorObjectName;
	}
	public Integer getErrorCount() {
		return errorCount;
	}
	public void setErrorCount(Integer errorCount) {
		this.errorCount = errorCount;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	

}
