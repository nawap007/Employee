package com.pawan.utility;

public class ResponseWrapper {
	
	private boolean status;
	private String statusCode;
	private Object data;
	private String responseMessage;
	
	
	
	
	
	public ResponseWrapper() {
		super();
	}
	public ResponseWrapper(boolean status, String statusCode, String responseMessage) {
		super();
		this.status = status;
		this.statusCode = statusCode;
		this.responseMessage = responseMessage;
	}
	public ResponseWrapper(boolean status, String statusCode, Object data, String responseMessage) {
		super();
		this.status = status;
		this.statusCode = statusCode;
		this.data = data;
		this.responseMessage = responseMessage;
	}
	
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	
	

}
