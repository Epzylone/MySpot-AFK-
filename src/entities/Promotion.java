/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author Fares
 */
public class Promotion {
  private int idPromotion;
  private String descriptionPromotion;
  private Date dateDebut;
  private Date dateFin;
  private int reduction;
  private int nombreSignalement;
  private String photoPromotion;
  private int idProduit;

    public Promotion( String descriptionPromotion, Date dateDebut, Date dateFin, int reduction, int nombreSignalement, String photoPromotion, int idProduit) {
       
        this.descriptionPromotion = descriptionPromotion;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.reduction = reduction;
        this.nombreSignalement = nombreSignalement;
        this.photoPromotion = photoPromotion;
        this.idProduit = idProduit;
    }

   

    public void setIdPromotion(int idPromotion) {
        this.idPromotion = idPromotion;
    }

    public void setDescriptionPromotion(String descriptionPromotion) {
        this.descriptionPromotion = descriptionPromotion;
    }

    public int getIdPromotion() {
        return idPromotion;
    }

    public String getDescriptionPromotion() {
        return descriptionPromotion;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public int getReduction() {
        return reduction;
    }

    public int getNombreSignalement() {
        return nombreSignalement;
    }

    public String getPhotoPromotion() {
        return photoPromotion;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public void setReduction(int reduction) {
        this.reduction = reduction;
    }

    public void setNombreSignalement(int nombreSignalement) {
        this.nombreSignalement = nombreSignalement;
    }

    public void setPhotoPromotion(String photoPromotion) {
        this.photoPromotion = photoPromotion;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    @Override
    public String toString() {
        return "Promotion{" + "descriptionPromotion=" + descriptionPromotion + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", reduction=" + reduction + ", nombreSignalement=" + nombreSignalement + ", photoPromotion=" + photoPromotion + ", idProduit=" + idProduit + '}';
    }
   
}
