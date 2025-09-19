package com.Models;

public class CompteCourant extends Compte {

    private double decouvert;

    public CompteCourant(String code, float solde, double decouvert) {
        super(code, solde);
        this.decouvert = decouvert;
    }

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }

    @Override
    public boolean retirer(float montant) {
        if (montant <= 0) return false;
        if (getSolde() - montant < -decouvert) return false; //pourqoui (-decouvert)
        setSolde(getSolde() -montant);
        return true;
    }

    @Override
    public double calculerInteret() {
        return 0;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Code du compte courant " +getCode());
        System.out.println("Solde" +getSolde());
        System.out.println("Découvert autorisé est :" +decouvert);

    }
}
