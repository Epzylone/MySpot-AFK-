/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Services.CategorieService;
import entities.Categorie;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Fares
 */
public class CategorieController implements Initializable {

    @FXML
    private Button ajouterCategorie;
    @FXML
    private ListView listcategorie;
    @FXML
    private TextField nomcategorie;

    CategorieService CS = new CategorieService();
    Categorie cat = new Categorie();
    @FXML
    private Button supprimercategorie;
    @FXML
    private Button modifiercategorie;
    @FXML
    private TextField msg;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println(CS.getAllCategorie());
        listcategorie.getItems().setAll(CS.getAllCategorie());
        listcategorie.getSelectionModel().selectedItemProperty()
        .addListener(new ChangeListener<Categorie>() {
            @Override
            public void changed(ObservableValue<? extends Categorie> observable, Categorie oldValue, Categorie newValue) {
                
            System.out.println("selection changed");  
            }
        });
        
        
    }    

    @FXML
    private void addCategorieAction(ActionEvent event) {
        if(CS.FindCategorieByNom(nomcategorie.getText()).getNomCategorie()!=null)
            msg.setText("Cette catégorie existe deja");
        else{
       cat.setNomCategorie(nomcategorie.getText()); 
       CS.AjouterCategorie(cat);
       listcategorie.getItems().setAll(CS.getAllCategorie());
    }
    }

    @FXML
    private void removeCategorie(ActionEvent event) {
        
        CS.SupprimerCategorie(listcategorie.getSelectionModel().selectedItemProperty().getValue().toString());
          listcategorie.getItems().setAll(CS.getAllCategorie());
    }

    @FXML
    private void modifyCategorie(ActionEvent event) {
       
        
            if(listcategorie.getSelectionModel().selectedItemProperty().getValue()==null)
            msg.setText("Selectionnez une catégorie");
            else
                 CS.ModifierCategorie(listcategorie.getSelectionModel().selectedItemProperty().getValue().toString(), nomcategorie.getText());
        listcategorie.getItems().setAll(CS.getAllCategorie());    
    }

    @FXML
    private void listviewevent(ListView.EditEvent event) {
       
    }
    
}
