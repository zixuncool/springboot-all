package com.rumo.exception;

import java.util.Map;

public class ParameterException extends RuntimeException {    
    
    /** serialVersionUID */    
    private static final long serialVersionUID = 6417641452178955756L;    
    
    private Map<String, String> errors ;
    
    public ParameterException() {    
        super();    
    }    
    
    public ParameterException(String message) {    
        super(message);    
    }    
    
    public ParameterException(String message,Map<String, String> maps) {    
    	super(message);    
    	this.errors = maps;
    }    
    
    public ParameterException(Throwable cause) {    
        super(cause);    
    }    
    
    public ParameterException(String message, Throwable cause) {    
        super(message, cause);    
    }

	public Map<String, String> getErrors() {
		return errors;
	}    
}  