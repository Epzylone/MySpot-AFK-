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
public class PreferenceUser {
    private int idPreferenceUser;
    private int idUser;
    private int idPreference;
    
    public PreferenceUser(){
        
    }

    public PreferenceUser(int idUser, int idPreference) {
        this.idUser = idUser;
        this.idPreference = idPreference;
    }

    public int getIdPreferenceUser() {
        return idPreferenceUser;
    }

    public void setIdPreferenceUser(int idPreferenceUser) {
        this.idPreferenceUser = idPreferenceUser;
    }
    
    
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdPreference() {
        return idPreference;
    }

    public void setIdPreference(int idPreference) {
        this.idPreference = idPreference;
    }
    
}