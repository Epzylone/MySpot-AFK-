/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Services.PreferenceService;
import Services.PreferenceUserService;
import entities.Preference;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class PreferenceUserController implements Initializable {

    @FXML
    private ListView<String> fieldPreferenceNo;
    @FXML
    private ListView<String> fieldPreferenceYes;
    public ObservableList<String> selectedItems = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PreferenceService pf = new PreferenceService();
        List<Preference> L= pf.consulterPreference();
        ObservableList<String> list = FXCollections.observableArrayList();
        PreferenceUserService pus= new PreferenceUserService();
       
        fieldPreferenceNo.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        for(int i=0;i<L.size();i++)
        {
            if(pus.estAffectee(NewFXMain.user,L.get(i).getNomPreference()))
              {selectedItems.add(L.get(i).getNomPreference());}
            else{ list.add(L.get(i).getNomPreference());}
        }
        fieldPreferenceNo.setItems(list);
        fieldPreferenceYes.setItems(selectedItems);
        
        fieldPreferenceNo.setOnMouseClicked(new EventHandler<Event>() {
                    @Override
                    public void handle(Event event) {
                        
                        if(fieldPreferenceNo.getSelectionModel().getSelectedItems().get(0)!=null)
                        {
                            selectedItems.add(fieldPreferenceNo.getSelectionModel().getSelectedItems().get(0));
                            fieldPreferenceYes.setItems(selectedItems);
                            pus.affecterPreference(NewFXMain.user,fieldPreferenceNo.getSelectionModel().getSelectedItems().get(0));
                            list.remove(fieldPreferenceNo.getSelectionModel().getSelectedItems().get(0));
                            fieldPreferenceNo.setItems(list);
                        }
                    }
        }  );
        fieldPreferenceYes.setOnMouseClicked(new EventHandler<Event>() {
                    @Override
                    public void handle(Event event) {
                        if(fieldPreferenceYes.getSelectionModel().getSelectedItems().get(0)!=null)
                        {
                            list.add(fieldPreferenceYes.getSelectionModel().getSelectedItems().get(0));
                            fieldPreferenceNo.setItems(list);
                            pus.supprimerAffectation(NewFXMain.user,fieldPreferenceYes.getSelectionModel().getSelectedItems().get(0));
                            selectedItems.remove(fieldPreferenceYes.getSelectionModel().getSelectedItems().get(0));
                            fieldPreferenceYes.setItems(selectedItems);
                        }
                    }
        }  );        
    
    
}
}