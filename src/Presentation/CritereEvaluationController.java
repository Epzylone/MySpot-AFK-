/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Services.CategorieCritereService;
import Services.CategorieService;
import Services.CritereEvaluationService;
import entities.Categorie;
import entities.CritereEvaluation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Fares
 */
public class CritereEvaluationController implements Initializable {

    @FXML
    private Button ajoutercritere;
    @FXML
    private TextField critere;
    @FXML
    private Button modifiercritere;
    @FXML
    private ListView listcritere;
    @FXML
    private TextField msg;
    CritereEvaluation CE = new CritereEvaluation();
    CritereEvaluationService CES = new CritereEvaluationService();
    @FXML
    private ComboBox listcategorie;
    CategorieService CS = new CategorieService();
    Categorie C = new Categorie();
     
       CategorieCritereService CCS = new CategorieCritereService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        System.out.println(CS.getAllCategorie().size());
        listcategorie.getItems().setAll(CS.getAllCategorie());
        
        listcategorie.getSelectionModel().selectedItemProperty()
        .addListener(new ChangeListener<Categorie>() {
            @Override
            public void changed(ObservableValue<? extends Categorie> observable, Categorie oldValue, Categorie newValue) {
            System.out.println("selection changed");  
                System.out.println(listcategorie.getSelectionModel().selectedItemProperty().getValue().toString());
                System.out.println(CES.getallCritere(CS.FindCategorieByNom(listcategorie.getSelectionModel().selectedItemProperty().getValue().toString()).getIdCategorie()));
            listcritere.getItems().setAll(CES.getallCritere(CS.FindCategorieByNom(listcategorie.getSelectionModel().selectedItemProperty().getValue().toString()).getIdCategorie()));
            
            }

            
        });
    }    

    @FXML
    private void addCritere(ActionEvent event) {
       // CS.FindCategorieByNom(typePropriete.getValue().toString())
      CritereEvaluation C = new CritereEvaluation();
       C.setNomCritere(critere.getText());
        if(listcategorie.getSelectionModel().selectedItemProperty().getValue()!=null)
        {
            CES.ajouterCritereEvaluation(C);
            CCS.AffecterCategorieCritere(CS.FindCategorieByNom(listcategorie.getSelectionModel().selectedItemProperty().getValue().toString()).getIdCategorie(),CES.getcriterebynom(critere.getText()).getIdCritere());    
        }
          listcritere.getItems().setAll(CES.getallCritere(CS.FindCategorieByNom(listcategorie.getSelectionModel().selectedItemProperty().getValue().toString()).getIdCategorie()));
    }

    @FXML
    private void removeCritere(ActionEvent event) {
        
        CritereEvaluation C = new CritereEvaluation();
        if(listcategorie.getSelectionModel().selectedItemProperty().getValue()!=null)
        {
            CES.supprimerCritereEvaluation(listcritere.getSelectionModel().selectedItemProperty().getValue().toString());
            //CCS.AffecterCategorieCritere(CS.FindCategorieByNom(listcategorie.getSelectionModel().selectedItemProperty().getValue().toString()).getIdCategorie(),CES.getcriterebynom(critere.getText()).getIdCritere());    
        }  
          listcritere.getItems().setAll(CES.getallCritere(CS.FindCategorieByNom(listcategorie.getSelectionModel().selectedItemProperty().getValue().toString()).getIdCategorie()));
    }

   
    
    
}
