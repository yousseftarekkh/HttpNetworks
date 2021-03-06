package networks.model;

import java.io.Serializable;

public class HttpRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	String method;
	String url;
	String version;
	String host;
	Formats format;
	ConnectionType connection;

	public HttpRequest() {
		method = "GET";
		version = "HTTP/1.1";
		host = "Youssef";
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Formats getFormat() {
		return format;
	}

	public void setFormat(Formats format) {
		this.format = format;
	}

	public ConnectionType getConnection() {
		return connection;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setConnection(ConnectionType connection) {
		this.connection = connection;
	}

	public String toStringCustom() {
		return getMethod() + ": " + getUrl() + "\n" + "Version: " + getVersion() + "\n" + "Host: " + getHost() + "\n"
				+ "Format: " + getFormat() + " \n" + "Connection-Type: " + getConnection();
	}

	public String toStringEih() {
		return "Method: " + getMethod() + "\n URL: " + getUrl() + "\n Version: " + getVersion() + "\n Hostname: "
				+ getHost() + "\n Format: " + getFormat() + " \n" + "Connection: " + getConnection();
	}

}
