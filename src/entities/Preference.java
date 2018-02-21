/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ASUS
 */
public class Preference {
    private int idPreference;
    private String nomPreference;
    
    public Preference(){
        
    }

    public Preference(String nomPreference) {
        this.nomPreference = nomPreference;
    }

    public int getIdPreference() {
        return idPreference;
    }

    public void setIdPreference(int idPreference) {
        this.idPreference = idPreference;
    }

    public String getNomPreference() {
        return nomPreference;
    }

    public void setNomPreference(String nomPreference) {
        this.nomPreference = nomPreference;
    }

    @Override
    public String toString() {
        return nomPreference;
    }
    
    
    
    
}
