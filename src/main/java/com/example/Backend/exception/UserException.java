package com.example.Backend.exception;

public class UserException extends BaseException{
    public UserException(String code){
        super("user." + code );
    }

    // user.register.email.null

    public static UserException requestNull() {
        return new UserException("register.email.null");
    }

    public static UserException emailNull() {
        return new UserException("register.email.null");
    }

    // CREATE

    public static UserException createEmailNull() {
        return new UserException("create.email.null");
    }

    public static UserException createEmailDuplicate() {
        return new UserException("create.email.duplicate");
    }

    public static UserException createPasswordNull() {
        return new UserException("create.password.null");
    }

    public static UserException createNameNull() {
        return new UserException("create.nmae.null");
    }

}
