/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;
import entities.Promotion;
/**
 *
 * @author Fares
 */
public interface IPromotion {
     public void ajouterPromotion(Promotion p);
     public void supprimerPromotion(Promotion p);
     public void modifierPromotion(Promotion p, String Nom);
     public Promotion chercherPropriete(String nom);
}
