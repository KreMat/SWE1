package at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.impl;

import java.io.OutputStream;
import java.util.Map;

import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.StatusCode;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Response;

public class HTTPResponse implements Response {
	
	private StatusCode statusCode;
	private int contentLength;
	private String contentType;
	private OutputStream body;
	private Map<String, String> headers;

	@Override
	public StatusCode getStatusCode() {
		return statusCode;
	}

	@Override
	public void setStatusCode(StatusCode code) {
		this.statusCode = code;
	}

	@Override
	public int getContentLength() {
		return contentLength;
	}

	@Override
	public void setContentLength(int length) {
		this.contentLength = length;
	}

	@Override
	public String getContentType() {
		return contentType;
	}

	@Override
	public void setContentType(String type) {
		this.contentType = type;
	}

	@Override
	public OutputStream getBody() {
		return body;
	}

	@Override
	public void setBody(OutputStream o) {
		this.body = o;
	}

	@Override
	public Map<String, String> getHeaders() {
		return headers;
	}

	@Override
	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}
	
	public String toString(){
		StringBuilder out = new StringBuilder();
		
		return out.toString();
	}

}
