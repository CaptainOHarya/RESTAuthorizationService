package ru.netology.autorizationservice.exception;

public class UnauthorizedUser extends RuntimeException{
    public UnauthorizedUser(String msg) {
        super(msg);

    }
}
