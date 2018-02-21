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
public class CategorieCritere {
    private int idCategorie;
    private int idCritere;
    private int idCategorieCritere;

    public CategorieCritere() {
    }

    public CategorieCritere(int idCategorie, int idCritere, int idCategorieCritere) {
        this.idCategorie = idCategorie;
        this.idCritere = idCritere;
        this.idCategorieCritere = idCategorieCritere;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public int getIdCritere() {
        return idCritere;
    }

    public void setIdCritere(int idCritere) {
        this.idCritere = idCritere;
    }

    public int getIdCategorieCritere() {
        return idCategorieCritere;
    }

    public void setIdCategorieCritere(int idCategorieCritere) {
        this.idCategorieCritere = idCategorieCritere;
    }
    
    
}
