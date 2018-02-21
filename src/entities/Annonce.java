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
public class Annonce {
    private int idAnnonce;
    private String descriptionAnnonce;
    private int idPropriete;

    public Annonce(String descriptionAnnonce, int idPropriete) {
        this.descriptionAnnonce = descriptionAnnonce;
        this.idPropriete = idPropriete;
    }

    public void setIdAnnonce(int idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    public int getIdAnnonce() {
        return idAnnonce;
    }

    public String getDescriptionAnnonce() {
        return descriptionAnnonce;
    }

    public int getIdPropriete() {
        return idPropriete;
    }

    public void setDescriptionAnnonce(String descriptionAnnonce) {
        this.descriptionAnnonce = descriptionAnnonce;
    }

    public void setIdPropriete(int idPropriete) {
        this.idPropriete = idPropriete;
    }

    @Override
    public String toString() {
        return "Annonce{" + "descriptionAnnonce=" + descriptionAnnonce + ", idPropriete=" + idPropriete + '}';
    }
    
}
