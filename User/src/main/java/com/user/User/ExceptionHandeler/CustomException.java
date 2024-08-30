package com.user.User.ExceptionHandeler;

public class CustomException extends RuntimeException{

    private String message;
    public CustomException() {
        super();
    }

    public CustomException(String message) {
        super(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
