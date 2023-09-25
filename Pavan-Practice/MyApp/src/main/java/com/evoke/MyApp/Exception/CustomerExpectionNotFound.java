package com.evoke.MyApp.Exception;

public class CustomerExpectionNotFound extends RuntimeException{
    public CustomerExpectionNotFound(String message) {
        super(message);
    }

    public CustomerExpectionNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerExpectionNotFound(Throwable cause) {
        super(cause);
    }
}
