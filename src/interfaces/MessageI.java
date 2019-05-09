package interfaces;

import java.io.Serializable;

import concrateObjects.Properties;
import concrateObjects.TimeStamp;

public interface MessageI extends Serializable {
	public String getURI();
	public TimeStamp getTimeStamp();
	public Properties getProperties();
	public Serializable getPlayLoad();
	
}
