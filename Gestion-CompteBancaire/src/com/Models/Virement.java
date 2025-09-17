package com.Models;

import java.time.LocalDate;

public class Virement extends Operation {
    private String source ;

    public Virement(float montant,String source){
           super(montant);
           this.source=source;
    }
    public String getSource(){
        return source;
    }
    public void setSource(String source){
        this.source=source;
    }

    public  String récupérerType(){
        return "Versement ("+source+")";
    };
}
