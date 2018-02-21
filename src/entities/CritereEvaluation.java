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
public class CritereEvaluation {
    private int idCritere;
    private String nomCritere;
   

    public CritereEvaluation() {
    }

    public CritereEvaluation(int idCritere, String nomCritere) {
        this.idCritere = idCritere;
        this.nomCritere = nomCritere;
    }

    public int getIdCritere() {
        return idCritere;
    }

    public void setIdCritere(int idCritere) {
        this.idCritere = idCritere;
    }

    public String getNomCritere() {
        return nomCritere;
    }

    public void setNomCritere(String nomCritere) {
        this.nomCritere = nomCritere;
    }

    @Override
    public String toString() {
        return nomCritere;
    }
    
}
