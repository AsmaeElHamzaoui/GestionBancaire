package com.Controller;

import java.util.Scanner;

import static java.lang.System.out;

public class BanqueController {


    Scanner scanner=new Scanner(System.in);
    int choix;


        do {

        out.println("1- Créer un compte ");
        out.println("2- Effectuer un versement dans un compte");
        out.println("3- Effectuer un retrait d'un compte");
        out.println("4- Effectuer un virement entre comptes");
        out.println("5- Consulter le solde du compte");
        out.println("6- Consulter la liste des opérations effectuées sur un compte");
        out.println("7- quitter");

        choix=scanner.nextInt();

        switch (choix){
            case 1:
                out.println("choix1");
                break;

            case 2:
                out.println("choix2");
                break;

            case 3:
                out.println("choix3");
                break;

            case 4:
                out.println("choix4");
                break;

            case 5:
                out.println("choix5");
                break;

            case 6:
                out.println("choix6");
                break;

            case 7:
                out.println("Merci pour votre visite");
                break;
            default:
                out.println("choix incorrecte");
        }

    }while(choix>0 && choix<=6);



    /* menu des functionnalités */
}
