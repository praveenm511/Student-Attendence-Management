package com.learning.java.Exception;

public class EntityNotFound extends RuntimeException{

    public EntityNotFound() {
        super();
    }
    public EntityNotFound(String message) {
        super(message);
    }

    public EntityNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
