/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import entities.Categorie;
import java.util.Date;
/**
 *
 * @author Fares
 */
  
public class Propriete {
   
    private int idPropriete;
    private String nomPropriete;
    private String adressePropriete;
    private long telPropriete;
    private String ville;
    private double latitude;
    private double longitude;
    private String jourOuverture;
    private int notePropriete;
    private String description;
    private int fourchetteDePrix;
    private Date dateAjout;
    private boolean livraison;
    private Categorie categorie;
    private int idUser;

   

    public Propriete() {
    }

    public Propriete(String nomPropriete, int fourchetteDePrix, boolean livraison) {
        this.nomPropriete = nomPropriete;
        this.fourchetteDePrix = fourchetteDePrix;
        this.livraison = livraison;
    }

   
    public Propriete(String nomPropriete, String adressePropriete, long telPropriete, String ville, double latitude, double longitude, String jourOuverture, int notePropriete, String description, int fourchetteDePrix, Date dateAjout, boolean livraison, Categorie categorie) {
        
        this.nomPropriete = nomPropriete;
        this.adressePropriete = adressePropriete;
        this.telPropriete = telPropriete;
        this.ville = ville;
        this.latitude = latitude;
        this.longitude = longitude;
        this.jourOuverture = jourOuverture;
        this.notePropriete = notePropriete;
        this.description = description;
        this.fourchetteDePrix = fourchetteDePrix;
        this.dateAjout = dateAjout;
        this.livraison = livraison;
        this.categorie = categorie;
    }

    public Propriete(int idPropriete, String nomPropriete, String adressePropriete, long telPropriete, String ville, double latitude, double longitude, String jourOuverture, int notePropriete, String description, int fourchetteDePrix, Date dateAjout, boolean livraison, Categorie categorie) {
        this.idPropriete = idPropriete;
        this.nomPropriete = nomPropriete;
        this.adressePropriete = adressePropriete;
        this.telPropriete = telPropriete;
        this.ville = ville;
        this.latitude = latitude;
        this.longitude = longitude;
        this.jourOuverture = jourOuverture;
        this.notePropriete = notePropriete;
        this.description = description;
        this.fourchetteDePrix = fourchetteDePrix;
        this.dateAjout = dateAjout;
        this.livraison = livraison;
        this.categorie = categorie;
    }
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public void setIdProptiete(int idProptiete) {
        this.idPropriete = idProptiete;
    }

    public int getIdPropriete() {
        return idPropriete;
    }

    public String getNomPropriete() {
        return nomPropriete;
    }

    public String getAdressePropriete() {
        return adressePropriete;
    }

    public long getTelPropriete() {
        return telPropriete;
    }

    public String getVille() {
        return ville;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getJourOuverture() {
        return jourOuverture;
    }

    public int getNotePropriete() {
        return notePropriete;
    }

    public String getDescription() {
        return description;
    }

    public int getFourchetteDePrix() {
        return fourchetteDePrix;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public boolean isLivraison() {
        return livraison;
    }

    public void setNomPropriete(String nomPropriete) {
        this.nomPropriete = nomPropriete;
    }

    public void setAdressePropriete(String adressePropriete) {
        this.adressePropriete = adressePropriete;
    }

    public void setTelPropriete(long telPropriete) {
        this.telPropriete = telPropriete;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setJourOuverture(String jourOuverture) {
        this.jourOuverture = jourOuverture;
    }

    public void setNotePropriete(int notePropriete) {
        this.notePropriete = notePropriete;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFourchetteDePrix(int fourchetteDePrix) {
        this.fourchetteDePrix = fourchetteDePrix;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

    public void setLivraison(boolean livraison) {
        this.livraison = livraison;
    }

    @Override
    public String toString() {
        return "Propriete{" + "idProptiete=" + idPropriete + ", nomPropriete=" + nomPropriete + ", adressePropriete=" + adressePropriete + ", telPropriete=" + telPropriete + ", ville=" + ville + ", latitude=" + latitude + ", longitude=" + longitude + ", jourOuverture=" + jourOuverture + ", notePropriete=" + notePropriete + ", description=" + description + ", fourchetteDePrix=" + fourchetteDePrix + ", dateAjout=" + dateAjout + ", livraison=" + livraison + ", Categorie= " + categorie.toString() + ") ";
    }

   
    
}
