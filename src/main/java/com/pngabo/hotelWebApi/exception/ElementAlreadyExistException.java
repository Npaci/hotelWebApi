package com.pngabo.hotelWebApi.exception;

public class ElementAlreadyExistException extends RuntimeException{
    public ElementAlreadyExistException() {
        super("Ce client existe déjà!");
    }
}
