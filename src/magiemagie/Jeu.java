/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magiemagie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import magiemagie.Carte.TypeCarte;

/**
 *
 * @author Administrateur
 */
public class Jeu {

    private Carte carteBaveDeCrapaud = new Carte();
    private Carte carteMandragore = new Carte();
    private Carte carteLapisLazuli = new Carte();
    private Carte carteCorneDeLicorne = new Carte();
    private Carte carteAileChauveSouris = new Carte();
    private List<Joueur> joueurs = new ArrayList<>();
    private int n = 0;
    private Joueur joueurEnCours = new Joueur();
    private boolean quitter = false;

    public Jeu() {
        this.joueurs = new ArrayList<>();
    }

    public void afficheMenuPrincipal() {

        while (quitter == false) {
            //Afficher le menu principal
            System.out.println("---------------------MENU PRINCIPAL---------------------");
            System.out.println();
            System.out.println("1) Nouveau Joueur ");
            System.out.println("2) Démarrer Partie");
            System.out.println("3) Quitter");
            System.out.println("L) Liste des Joueurs");
            System.out.println("R) Régles du jeu et infos sur le jeu");
            System.out.println();

            //Rentrer le choix du menu
            Scanner sc1 = new Scanner(System.in);

            System.out.print("Choisissez votre action :");
            String choix = sc1.next();

            switch (choix) {
                case "1":
                    afficheMenuNouveauJoueur();
                    break;

                case "2":
                    quitter = true;
                    demarrerPartie();
                    break;

                case "3":
                    quitter = true;
                    System.out.println("Au revoir");
                    break;
                case "L":
                    afficheJoueurs();
                    break;
                case "R":
                    System.out.println("Une bande de sorcières s'affrontent à tour de rôle en se jettant des sorts\n"
                            + "pour devenir la Reine des Sorcières.\n"
                            + "Il ne doit en rester qu'une !\n" + "");
                    break;
            }
        }
    }

    public void afficheMenuNouveauJoueur() {
        while (quitter == false) {
            System.out.println("---------------------MENU NOUVEAU JOUEUR---------------------");
            System.out.println();
            System.out.println("1) Créer Nouveau Joueur ");
            System.out.println("2) Retour Menu Principal");
            Scanner sc1 = new Scanner(System.in);
            System.out.print("Choisissez votre action :");
            String choix = sc1.next();
            switch (choix) {
                case "1":
                    Scanner sc2 = new Scanner(System.in);
                    System.out.print("Choissisez votre nom : ");
                    String NomJoueur = sc2.nextLine();
                    Joueur j1 = new Joueur(NomJoueur);
                    this.joueurs.add(j1);
                    System.out.print(NomJoueur);
                    System.out.print(" a bien été créé(e).");
                    System.out.println();
                    System.out.println();
                    break;
                case "2":

                    afficheMenuPrincipal();
                    break;
            }
        }
    }

    public void cartesAléatoires() {

        for (Joueur joueurs : joueurs) {
            //Ditribue 7 cartes pour tous les joueurs
            for (int i = 0; i < 7; i++) {
                Carte carte = new Carte();
                Random random = new Random();
                //Distribue 7 cartes pour un joueurs
                int nombreAleatoire = random.nextInt(5);
                switch (nombreAleatoire) {
                    case 0:
                        carte.setTypes(TypeCarte.LAPIS_LAZULI);
                        break;
                    case 1:
                        carte.setTypes(TypeCarte.AILE_DE_CHAUVE_SOURIS);
                        break;
                    case 2:
                        carte.setTypes(TypeCarte.BAVE_DE_CRAPAUD);
                        break;
                    case 3:
                        carte.setTypes(TypeCarte.CORNE_DE_LICORNE);
                        break;
                    case 4:
                        carte.setTypes(TypeCarte.MANDRAGORE);
                        break;
                }
                joueurs.getCartes().add(carte);
            }
        }
    }

    public void afficheJoueurs() {

        System.out.println("Participants:");
        for (Joueur joueur : joueurs) {
            System.out.println(joueur.getNom());
            System.out.println(joueur.getCartes());
        }
    }

    public void demarrerPartie() {
        if (joueurs.size() == 1) {
            System.out.println("Requis plus de joueurs afin de lancer la partie");

        } else {
            cartesAléatoires();
            assignationDuJoueurActuel();
            partieGagnée();

        }
    }

    public void assignationDuJoueurActuel() {
        joueurEnCours = joueurs.get(n);
    }

    public void partieGagnée() {
        if (joueurs.size() == 1) {
            System.out.println("Vous avez gagnée !!! Bravo\n" + " Tu as de grosses BOOOOOOOOOOOOOOOOOOOOOOOLS");
            quitter = true;

        } else {
            afficheMenuAction();
        }
    }

    public void lancerInvisibilite() {

    }

    public void afficheMenuAction() {
        while (joueurEnCours != null) {

            for (Joueur j : joueurs) {
                Scanner sc = new Scanner(System.in);
                System.out.println("---------------------Menu D'action---------------------");
                System.out.println();
                System.out.print(joueurEnCours.getNom() + " à vous de jouez\n");
                System.out.println("Voici vos cartes: " + j.getCartes());
                System.out.println("1) Lancez un sorts");
                System.out.println("2) Passez son tours");
                System.out.println();
                System.err.print("Choix : ");
                String choix = sc.nextLine();
                switch (choix) {
                    case ("1"):
                        lancerSort();

                        break;
                    case ("2"):
                        passezTours(j);

                        break;
                }
                if (n + 1 == joueurs.size()) {
                    assignationDuJoueurActuel();
                } else {
                    n++;
                    joueurEnCours = joueurs.get(n);
                }
            }
        }
    }

    public void lancerSort() {

        //1.affiche les sorts possible pour le joueursEnCours
        carteBaveDeCrapaud.setTypes(TypeCarte.BAVE_DE_CRAPAUD);
        carteCorneDeLicorne.setTypes(TypeCarte.CORNE_DE_LICORNE);
        carteAileChauveSouris.setTypes(TypeCarte.AILE_DE_CHAUVE_SOURIS);
        carteLapisLazuli.setTypes(TypeCarte.LAPIS_LAZULI);
        carteMandragore.setTypes(TypeCarte.MANDRAGORE);

        if (this.joueurEnCours.getCartes().contains(carteAileChauveSouris) && this.joueurEnCours.getCartes().contains(carteLapisLazuli)) {
            System.out.println("1) Divination");
        }
        if (this.joueurEnCours.getCartes().contains(carteBaveDeCrapaud) && this.joueurEnCours.getCartes().contains(carteCorneDeLicorne)) {
            System.out.println("2) Invisibilité");
        }
        if (this.joueurEnCours.getCartes().contains(carteBaveDeCrapaud) && this.joueurEnCours.getCartes().contains(carteLapisLazuli)) {
            System.out.println("3) Hypnose");
        }
        if (this.joueurEnCours.getCartes().contains(carteCorneDeLicorne) && this.joueurEnCours.getCartes().contains(carteMandragore)) {
            System.out.println("4) Filtre D'amour");
        }
        if (this.joueurEnCours.getCartes().contains(carteMandragore) && this.joueurEnCours.getCartes().contains(carteAileChauveSouris)) {
            System.out.println("5) Sommeil-Profond");
        }

        //2.saisie le sort que l'ont veux lancer
        Scanner sc = new Scanner(System.in);
        String choix = sc.nextLine();

        switch (choix) {
            case "1":

                sortDivination();

                break;
            case "2":

                sortInvisibilite();
                break;

            case "3":
               
                sortHypnose();
                break;
            case "4":
               
                sortPhiltreAmour();

                break;
            case "5":
               
                sortSommeilProfond();

                break;
            default:
                System.out.println("Ce sort n'existe pas enculé");
                return;
                

        }

        //3.Lancement du sort
        //4.Supprime les cartes utilisé lors du sort
    }

    public void sortDivination() {
        if (this.joueurEnCours.getCartes().contains(carteAileChauveSouris) && this.joueurEnCours.getCartes().contains(carteLapisLazuli)) {

        }
    }

    public void sortInvisibilite() {
        if (this.joueurEnCours.getCartes().contains(carteBaveDeCrapaud) && this.joueurEnCours.getCartes().contains(carteCorneDeLicorne)) {

        }

    }

    public void sortPhiltreAmour() {
 if (this.joueurEnCours.getCartes().contains(carteCorneDeLicorne) && this.joueurEnCours.getCartes().contains(carteMandragore)) {
                }
    }

    public void sortSommeilProfond() {
 if (this.joueurEnCours.getCartes().contains(carteMandragore) && this.joueurEnCours.getCartes().contains(carteAileChauveSouris)) {
                }
    }

    public void sortHypnose() {
 if (this.joueurEnCours.getCartes().contains(carteBaveDeCrapaud) && this.joueurEnCours.getCartes().contains(carteLapisLazuli)) {

                }
    }

    public void passezTours(Joueur joueur) {

        Carte carte = new Carte();
        Random random = new Random();
        int nombreAleatoire = random.nextInt(5);
        switch (nombreAleatoire) {
            case 0:
                carte.setTypes(TypeCarte.LAPIS_LAZULI);
                break;
            case 1:
                carte.setTypes(TypeCarte.AILE_DE_CHAUVE_SOURIS);
                break;
            case 2:
                carte.setTypes(TypeCarte.BAVE_DE_CRAPAUD);
                break;
            case 3:
                carte.setTypes(TypeCarte.CORNE_DE_LICORNE);
                break;
            case 4:
                carte.setTypes(TypeCarte.MANDRAGORE);
                break;
        }
        joueur.getCartes().add(carte);
    }

    public void montrezListeingrédient() {

    }

    public List<Joueur> getJoueur() {
        return joueurs;
    }

    public void setJoueur(List<Joueur> joueur) {
        this.joueurs = joueur;
    }
}
