package com.Models;

import java.util.List;
import java.util.ArrayList;

public abstract class Compte {
    protected String code ;
    protected float solde;
    protected List<Operation> listOperation;


    public Compte(String code, float solde){
        this.code=code;
        this.solde=solde;
        this.listOperation=new ArrayList<>();
    }

    //Getters et setters (begin)

    public String getCode(){
        return code;
    }
    public void setCode(String code){
        this.code=code;
    }
    public float getSolde(){
        return solde;
    }
    public void setSolde(float solde){
        this.solde=solde;
    }
    public List<Operation> getListOperation(){
        return listOperation;
    }
    public void  setListOperation(List<Operation> listOperation){
        this.listOperation=listOperation;
    }

    //Getters et setters(end)

    //Méthodes abstraites
    public abstract boolean retirer(float montant);

    public abstract double calculerInteret();

    public abstract void afficherDetails();

}
