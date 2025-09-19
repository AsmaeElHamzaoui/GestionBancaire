package com.Controller;

import java.util.Scanner;

import com.Models.*;

import com.util.Utils;
import java.util.HashMap;
import java.util.Map;

public class BanqueController {
    private Map<String, Compte> comptes = new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    public void commencer() {

        boolean running = true;
        while (running) {
            showMenu();
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    creerCompteCourant();
                    break;
                case "2":
                    creerCompteEpargne();
                    break;
                case "3":
                    faireVersement();
                    break;
                case "4":
                    faireRetrait();
                    break;
                case "5":
                    faireVirement();
                    break;
                case "6":
                    consulterSolde();
                    break;
                case "7":
                    listerOperations();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        }
        System.out.println("Merci pour votre viste");
    }

    private void showMenu() {
        System.out.println("\n1- Créer compte courant");
        System.out.println("2- Créer compte épargne");
        System.out.println("3- Versement");
        System.out.println("4- Retrait");
        System.out.println("5- Virment");
        System.out.println("6- Consulter solde");
        System.out.println("7- Lister opérations");
        System.out.println("0- quitter");
        System.out.println("3- Choix:");
    }

    private void creerCompteCourant() {
        System.out.print("Code (CPT-12345):");
        String code = sc.nextLine().trim();
        if (!Utils.isValidCode(code)) {
            System.out.println("Code invalide");
            return;
        }
        System.out.print("Solde initial");
        float solde = Utils.lireFloat(sc.nextLine().trim());
        System.out.print("Découvert autorisé:");
        double dec = Utils.lireFloat(sc.nextLine().trim());
        comptes.put(code, new CompteCourant(code, solde, dec));
        System.out.println("Compte courant créé .");
    }

    private void creerCompteEpargne() {
        System.out.print("Code (CPT-12345):");
        String code = sc.nextLine().trim();
        if (!Utils.isValidCode(code)) {
            System.out.println("Code invalide");
            return;
        }
        System.out.print("Solde initial");
        float solde = Utils.lireFloat(sc.nextLine().trim());
        System.out.print("Taux intéret:");
        double taux = Utils.lireFloat(sc.nextLine().trim());
        comptes.put(code, new CompteEpargne(code, solde, taux));
        System.out.println("Compte épargne créé");

    }

    private void faireVersement() {
        System.out.print("Code compte :");
        String code = sc.nextLine().trim();
        Compte c = comptes.get(code);
        if (c == null) {
            System.out.println("Compte introuvable");
            return;
        }
        System.out.print("Montant:");
        float montant = Utils.lireFloat(sc.nextLine().trim());
        System.out.print("Source:");
        String source = sc.nextLine().trim();
        c.setSolde(c.getSolde() + montant) ;
        c.addOperation(new Versement(montant, source));
        System.out.println("Versement effectué .");
    }

    private void faireRetrait() {
        System.out.print("Code compte :");
        String code = sc.nextLine().trim();
        Compte c = comptes.get(code);
        if (c == null) {
            System.out.println("Compte introuvable");
            return;
        }
        System.out.print("Montant: ");
        float montant = Utils.lireFloat(sc.nextLine().trim());
        System.out.print("Destination:");
        String dest = sc.nextLine().trim();
        if (!c.retirer(montant)) {
            System.out.println("Retrait impossible");
            return;
        }
        c.addOperation(new Retrait(montant, dest));
        System.out.println("Retrait effectué .");

    }

    private void faireVirement() {
        System.out.print("Compte source :");
        String src = sc.nextLine().trim();
        System.out.print("Compte cible :");
        String tgt = sc.nextLine().trim();
        Compte from = comptes.get(src);
        Compte to = comptes.get(tgt);
        if (from == null || to == null) {
            System.out.println("Compte introuvable");
            return;
        }
        System.out.print("Montant:");
        float montant = Utils.lireFloat(sc.nextLine().trim());
        if (!from.retirer(montant)) {
            System.out.println("Virment impossible");
            return;
        }
        to.setSolde(to.getSolde() + montant);
        from.addOperation(new Retrait(montant, "Virment vers" + tgt));
        to.addOperation(new Versement(montant, "Virment depuis" + src));
        System.out.println("Virment effectué.");
    }

    private void consulterSolde() {
        System.out.print("Code compte :");
        String code = sc.nextLine().trim();
        Compte c = comptes.get(code);
        if (c == null) {
            System.out.println("Compte introuvable");
            return;
        }
        c.afficherDetails();
    }

    private void listerOperations() {
        System.out.print("Code compte :");
        String code = sc.nextLine().trim();
        Compte c = comptes.get(code);
        if (c == null) {
            System.out.println("Compte introuvable");
            return;
        }
        if (c.getListOperation().isEmpty()) System.out.println("Acune opération");
        else c.getListOperation().forEach(System.out::println);
    }
}
