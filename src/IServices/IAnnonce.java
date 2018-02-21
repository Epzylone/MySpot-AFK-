/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;
import entities.Annonce;
/**
 *
 * @author Fares
 */
public interface IAnnonce {
    public void ajouterAnnonce(Annonce a);
     public void supprimerAnnonce(Annonce a);
     public void modifierAnnonce(Annonce a, String Nom);
     public Annonce chercherAnnonce(String nom);
}
