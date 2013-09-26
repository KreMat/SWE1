package at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.impl;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Request;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Uri;

public class RequestImpl implements Request {

	private String method;
	private Map<String, String> headers;
	private String contentType;
	private int contentLength;
	private Uri uri;
	private InputStream body;

	public RequestImpl() {
		headers = new HashMap<String, String>();
	}

	@Override
	public String getMethod() {
		return method;
	}

	@Override
	public void setMethod(String method) {
		this.method = method;
	}

	@Override
	public Map<String, String> getHeaders() {
		return headers;
	}

	@Override
	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
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
	public int getContentLength() {
		return contentLength;
	}

	@Override
	public void setContentLength(int length) {
		this.contentLength = length;
	}

	@Override
	public Uri getUri() {
		return uri;
	}

	@Override
	public void setUri(Uri uri) {
		this.uri = uri;
	}

	@Override
	public InputStream getBody() {
		return body;
	}

	@Override
	public void setBody(InputStream body) {
		this.body = body;
	}

	public void addToHeader(String key, String value) {
		headers.put(key, value);
	}

	public String toString() {
		StringBuilder out = new StringBuilder();
		out.append("method: " + method);
		out.append("contentType: " + contentType);
		out.append("contentLength: " + contentLength);
		// out.append("uri-Path: "+uri.getPath());
		// out.append("uri-Procotol: "+uri.getProtocol());
		out.append("method: " + method);
		out.append("method: " + method);

		for (Map.Entry<String, String> e : headers.entrySet()) {
			out.append(e.getKey() + " " + e.getValue());
		}

		return out.toString();
	}

}
