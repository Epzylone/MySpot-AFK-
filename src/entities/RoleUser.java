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
public class RoleUser {
    private int idRoleUser;
    private int idRole;
    private int idUser;
    
    public RoleUser(){
        
    }

    public RoleUser(int idRole, int idUser) {
        this.idRole = idRole;
        this.idUser = idUser;
    }

    public int getIdRoleUser() {
        return idRoleUser;
    }

    public void setIdRoleUser(int idRoleUser) {
        this.idRoleUser = idRoleUser;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
    
    
}
