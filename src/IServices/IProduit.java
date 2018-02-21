/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;
import entities.Produit;
/**
 *
 * @author Fares
 */
public interface IProduit {
    public void ajouterProduit (Produit p);
     public void supprimerProduit(Produit p);
     public void modifierPropriete(Produit p, String Nom);
     public Produit chercherProduit(String nom);
}
