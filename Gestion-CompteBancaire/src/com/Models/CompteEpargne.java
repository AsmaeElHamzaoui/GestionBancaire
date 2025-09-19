package com.Models;

public class CompteEpargne extends Compte {
    private double tauxInteret;

    public CompteEpargne(String code, float solde, double tauxInteret) {
        super(code, solde);
        this.tauxInteret = tauxInteret;
    }

    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    @Override
    public boolean retirer(float montant) {

        if (montant > 0 && getSolde() >= montant) {
            setSolde(getSolde() - montant);
            return true;
        }
        return false;
    }

    @Override
    public double calculerInteret() {
        return getSolde() * tauxInteret;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Code du Compte Epargne: " + getCode());
        System.out.println("Solde: " + getSolde());
        System.out.println("Taux d'intérêt: " + tauxInteret);
    }
}
