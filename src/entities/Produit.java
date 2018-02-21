/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Fares
 */
public class Produit {
    public enum TypeProduit{entree, plat, dessert, boisson;}
    private int idProduit;
    private String nomProduit;
    private TypeProduit typeProduit;
    private double prixProduit;
    private String description;
    private double prixPromo;
    private int idPropriete;

    public Produit( String nomProduit, TypeProduit typeProduit, double prixProduit, String description, double prixPromo, int idPropriete) {
       
        this.nomProduit = nomProduit;
        this.typeProduit = typeProduit;
        this.prixProduit = prixProduit;
        this.description = description;
        this.prixPromo = prixPromo;
        this.idPropriete = idPropriete;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }
     
    

    public String getNomProduit() {
        return nomProduit;
    }

    public TypeProduit getTypeProduit() {
        return typeProduit;
    }

    public double getPrixProduit() {
        return prixProduit;
    }

    public String getDescription() {
        return description;
    }

    public double getPrixPromo() {
        return prixPromo;
    }

    public int getIdPropriete() {
        return idPropriete;
    }

   

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public void setTypeProduit(TypeProduit typeProduit) {
        this.typeProduit = typeProduit;
    }

    public void setPrixProduit(double prixProduit) {
        this.prixProduit = prixProduit;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrixPromo(double prixPromo) {
        this.prixPromo = prixPromo;
    }

    public void setIdPropriete(int idPropriete) {
        this.idPropriete = idPropriete;
    }

    @Override
    public String toString() {
        return "Produit{" + "nomProduit=" + nomProduit + ", typeProduit=" + typeProduit + ", prixProduit=" + prixProduit + ", description=" + description + ", prixPromo=" + prixPromo + ", idPropriete=" + idPropriete + '}';
    }

    
    
}
