/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Services.PreferenceProprieteService;
import Services.PreferenceService;
import Services.ProprieteService;
import entities.Preference;
import entities.Propriete;
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
public class PreferenceProprieteController implements Initializable {

    @FXML
    private ListView<String> fieldPreferenceProprieteNo;
    @FXML
    private ListView<String> fieldPreferenceProprieteYes;
    public ObservableList<String> selectedItems = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PreferenceService pf = new PreferenceService();
        List<Preference> L= pf.consulterPreference();
        ObservableList<String> list = FXCollections.observableArrayList();
        PreferenceProprieteService pps= new PreferenceProprieteService();
      
        fieldPreferenceProprieteNo.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        for(int i=0;i<L.size();i++)
        {
            if(pps.estAffectee(NewFXMain.propriete,L.get(i).getNomPreference()))
              {selectedItems.add(L.get(i).getNomPreference());}
            else{ list.add(L.get(i).getNomPreference());}
        }
        fieldPreferenceProprieteNo.setItems(list);
        fieldPreferenceProprieteYes.setItems(selectedItems);
        
        fieldPreferenceProprieteNo.setOnMouseClicked(new EventHandler<Event>() {
                    @Override
                    public void handle(Event event) {
                        
                        if(fieldPreferenceProprieteNo.getSelectionModel().getSelectedItems().get(0)!=null)
                        {
                            selectedItems.add(fieldPreferenceProprieteNo.getSelectionModel().getSelectedItems().get(0));
                            fieldPreferenceProprieteYes.setItems(selectedItems);
                            pps.affecterPreference(NewFXMain.propriete,fieldPreferenceProprieteNo.getSelectionModel().getSelectedItems().get(0));
                            list.remove(fieldPreferenceProprieteNo.getSelectionModel().getSelectedItems().get(0));
                            fieldPreferenceProprieteNo.setItems(list);
                        }
                    }
        }  );
        fieldPreferenceProprieteYes.setOnMouseClicked(new EventHandler<Event>() {
                    @Override
                    public void handle(Event event) {
                        if(fieldPreferenceProprieteYes.getSelectionModel().getSelectedItems().get(0)!=null)
                        {
                            list.add(fieldPreferenceProprieteYes.getSelectionModel().getSelectedItems().get(0));
                            fieldPreferenceProprieteNo.setItems(list);
                            pps.supprimerAffectation(NewFXMain.propriete,fieldPreferenceProprieteYes.getSelectionModel().getSelectedItems().get(0));
                            selectedItems.remove(fieldPreferenceProprieteYes.getSelectionModel().getSelectedItems().get(0));
                            fieldPreferenceProprieteYes.setItems(selectedItems);
                        }
                    }
        }  );        
    }    
    
}
