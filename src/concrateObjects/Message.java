package concrateObjects;

import java.io.Serializable;

import interfaces.MessageI;

public class Message implements MessageI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String URI;
	private TimeStamp ts;
	private Properties prop;
	private Serializable obj;
	
	public Message(Serializable obj) {
		this.URI = java.util.UUID.randomUUID().toString();
		this.ts = new TimeStamp();
		this.prop = new Properties();
		this.obj = obj;
	}
	
	@Override
	public String getURI() {
		return URI;
	}

	@Override
	public TimeStamp getTimeStamp() {
		return ts;
	}

	@Override
	public Properties getProperties() {
		return prop;
	}

	@Override
	public Serializable getPlayLoad() {
		return obj;
	}

}
