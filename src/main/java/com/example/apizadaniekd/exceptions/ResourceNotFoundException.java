package com.example.apizadaniekd.exceptions;


public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){
        super("Nie znaleziono zasobu!");
    }
}
