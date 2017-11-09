/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magiemagie;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public class Joueur {
    
    protected String nom ;
    
    protected List<Carte> cartes = new ArrayList<> () ;

    public Joueur() {
    }
    
    public Joueur(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Carte> getCartes() {
        return cartes;
    }

    public void setCartes(List<Carte> cartes) {
        this.cartes = cartes;
    }

    

    @Override
    public String toString() {
        return "Joueur{" + "nom=" + nom + ", cartes=" + cartes + '}';
    }

   
    
    

    
    
      
    
}
