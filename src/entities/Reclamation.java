/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Reclamation {
    private int idReclamation;
    private EtatReclamation etatReclamation;
    private Date dateReclamation;
    private TypeReclamation typeReclamation;
    private int idSignalement;

    public Reclamation() {
    }
    public Reclamation(EtatReclamation etatReclamation, Date dateReclamation, TypeReclamation typeReclamation, int idSignalement) {
        this.etatReclamation = etatReclamation;
        this.dateReclamation = dateReclamation;
        this.typeReclamation = typeReclamation;
        this.idSignalement = idSignalement;
    }

    public int getIdReclamation() {
        return idReclamation;
    }

    public void setIdReclamation(int idReclamation) {
        this.idReclamation = idReclamation;
    }

    public EtatReclamation getEtatReclamation() {
        return etatReclamation;
    }

    public void setEtatReclamation(EtatReclamation etatReclamation) {
        this.etatReclamation = etatReclamation;
    }

    public Date getDateReclamation() {
        return dateReclamation;
    }

    public void setDateReclamation(Date dateReclamation) {
        this.dateReclamation = dateReclamation;
    }

    public TypeReclamation getTypeReclamation() {
        return typeReclamation;
    }

    public void setTypeReclamation(TypeReclamation typeReclamation) {
        this.typeReclamation = typeReclamation;
    }

    public int getIdSignalement() {
        return idSignalement;
    }

    public void setIdSignalement(int idSignalement) {
        this.idSignalement = idSignalement;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "etatReclamation=" + etatReclamation + ", dateReclamation=" + dateReclamation + ", typeReclamation=" + typeReclamation + ", idSignalement=" + idSignalement + '}';
    }
    
    
    
}
