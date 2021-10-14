package com.pngabo.hotelWebApi.exception;

public class ElementNotFoundException extends RuntimeException{
    public ElementNotFoundException() {
        super("Ce client n'existe pas!");
    }
}
