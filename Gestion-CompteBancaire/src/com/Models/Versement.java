package com.Models;

import java.time.LocalDate;

public class Versement extends Operation {
    private String source ;

    public Versement(float montant,String source){
        super(montant);
        this.source=source;
    }
    public String getSource(){
        return source;
    }
    public void setSource(String source){
        this.source=source;
    }

    public  String recupererType(){
        return "Versement ("+source+")";
    }
}
