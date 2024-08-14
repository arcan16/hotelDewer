package com.example.HotelDewer_app.infra.errors;

public class MyIntegrityValidation extends RuntimeException{

    public MyIntegrityValidation(String s){
        super(s);
    }
}
