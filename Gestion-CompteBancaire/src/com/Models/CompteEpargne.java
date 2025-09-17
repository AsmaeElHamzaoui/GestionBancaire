package com.Models;

public class CompteEpargne extends Compte {
    private double tauxInteret;

   public CompteEpargne(String code, float solde,double tauxInteret){
       super(code,solde);
       this.tauxInteret=tauxInteret;
   }

    public double getTauxInteret(){
       return tauxInteret;
    }
    public void setTauxInteret(double tauxInteret){
       this.tauxInteret=tauxInteret;
    }

    @Override
    public  boolean retirer(float montant){
       return true;
    }

    @Override
    public  double calculerInteret(){
          return  solde * tauxInteret;
    }

    @Override
    public void afficherDetails(){
        System.out.println("Code du Compte Epargne: " + code);
        System.out.println("Solde: " + solde);
        System.out.println("Taux d'intérêt: " + tauxInteret);
    }
}
