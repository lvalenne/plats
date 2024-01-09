package me.abeilles.base.bll.models;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message){
        super(message);
    }
}
