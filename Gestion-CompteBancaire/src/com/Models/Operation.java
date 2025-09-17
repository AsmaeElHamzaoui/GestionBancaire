package com.Models;
// import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.UUID;

public abstract class Operation {
    protected String numero;
    protected LocalDate date ;
    protected float montant;

    public Operation(float montant){
        this.numero=UUID.randomUUID().toString();
        this.date=LocalDate.now();
        this.montant=montant;
    }

    public String getNumero(){
        return numero;
    }
    public void setNumero(String numero){
        this.numero=numero;
    }
    public LocalDate getDate(){
        return date;
    }
    public void setDate(LocalDate date){
        this.date=date;
    }
    public float getMontant(){
        return montant;
    }
    public void setMontant(float montant){
        this.montant=montant;
    }

    public abstract String récupérerType();

    @Override
    public String toString(){
        return String.format("[%s]%s-%.2fDH-%s",date,numero,montant,récupérerType());
    }

}


