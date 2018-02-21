/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author Fares
 */
public class SwitchScreen {
    public void switchScreen(String screen, Button next) throws IOException {
        Parent root = FXMLLoader.load(getClass()
                .getResource(screen));
        Scene scene = new Scene(root) ;
        Stage stage = (Stage) next.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
    }
}
