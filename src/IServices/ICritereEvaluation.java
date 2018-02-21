/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;
import entities.CritereEvaluation;
import java.util.List;
/**
 *
 * @author Fares
 */
public interface ICritereEvaluation {
     public void ajouterCritereEvaluation(CritereEvaluation c);
     public void supprimerCritereEvaluation(String nomCritere);
     public void modifierCritereEvaluation(CritereEvaluation c, String Nom);
     public CritereEvaluation getcritere(int id);
     public CritereEvaluation getcriterebynom(String nom);
     public List<CritereEvaluation> getallCritere(int id);
}
