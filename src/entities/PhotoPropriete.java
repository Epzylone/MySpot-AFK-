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
public class PhotoPropriete {
    private int idPhotoPropriete;
    private String URLphoto;
    private int idPropriete;

    @Override
    public String toString() {
        return "PhotoPropriete{" + "idPhotoPropriete=" + idPhotoPropriete + ", URLphoto=" + URLphoto + ", idPropriete=" + idPropriete + '}';
    }

    public PhotoPropriete() {
    }

    public PhotoPropriete(int idPhotoPropriete, String URLphoto, int idPropriete) {
        this.idPhotoPropriete = idPhotoPropriete;
        this.URLphoto = URLphoto;
        this.idPropriete = idPropriete;
    }

    public int getIdPhotoPropriete() {
        return idPhotoPropriete;
    }

    public void setIdPhotoPropriete(int idPhotoPropriete) {
        this.idPhotoPropriete = idPhotoPropriete;
    }

    public String getURLphoto() {
        return URLphoto;
    }

    public void setURLphoto(String URLphoto) {
        this.URLphoto = URLphoto;
    }

    public int getIdPropriete() {
        return idPropriete;
    }

    public void setIdPropriete(int idPropriete) {
        this.idPropriete = idPropriete;
    }
    

}
