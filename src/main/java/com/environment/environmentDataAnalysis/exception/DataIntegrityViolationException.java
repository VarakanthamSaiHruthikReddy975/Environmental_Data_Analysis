package com.environment.environmentDataAnalysis.exception;

import javax.xml.crypto.Data;

public class DataIntegrityViolationException extends RuntimeException{

    public DataIntegrityViolationException(String message){
        super(message);
    }

    public DataIntegrityViolationException(String message, Throwable cause){
        super(message, cause);
    }
}
