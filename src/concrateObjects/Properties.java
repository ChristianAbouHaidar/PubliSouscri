package concrateObjects;

import java.io.Serializable;

public class Properties implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	void putProp(String name, boolean v)  {}
	void putProp(String name, byte v)    {}
	void putProp(String name, char v)    {}
	void putProp(String name, double v)  {}
	void putProp(String name, float v)   {}
	void putProp(String name, int v)     {}
	void putProp(String name, long v)    {}
	void putProp(String name, short v)   {}
	void putProp(String name, String v)  {}
	boolean getBooleanProp(String name)      {
		return false;}
	byte getByteProp(String name)         {
		return 0;}
	char getCharProp(String name)         {
		return 0;}
	double getDoubleProp(String name)       {
		return 0;}
	float getFloatProp(String name)        {
		return 0;}
	int getIntProp(String name)          {
		return 0;}
	long getLongProp(String name)         {
		return 0;}
	short getShortProp(String name)        {
		return 0;}
	String gaetStringProp(String name)      {
		return name;}
                                    
}
