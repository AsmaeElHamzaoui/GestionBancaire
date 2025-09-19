package com.Models;

import java.util.Date;

public class Retrait extends Operation {
    private String destination;
    public Retrait(float montant, String destination){
        super(montant);
        this.destination=destination;
    }

    public String getDestination(){
        return destination;
    }
    public void setDestination(String destination){
        this.destination=destination;
    }

    public  String recupererType(){
        return "Retrait ("+destination+")";
    };
}
