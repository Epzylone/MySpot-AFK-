/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import DataStorage.MyDB;
import entities.User;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ConnexionController implements Initializable {

    @FXML
    private TextField tfUserName;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private Button forgotPassword;
    @FXML
    private Button cnx;
    @FXML
    private Button inscription;
    @FXML
    private Label userNameInvalide;
    @FXML
    private Label passwordInvalide;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userNameInvalide.setVisible(false);
        passwordInvalide.setVisible(false);
        
    }    
    Connection connexion;
    public ConnexionController() {
        connexion = MyDB.getinstance().getConnexion();
    }
    @FXML
    void forgotPasswordAction(MouseEvent event) {
        forgotPassword.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    switchScreen("ForgotPassword.fxml");
                } catch (IOException ex) {
                    Logger.getLogger(ConnexionController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    @FXML
    private void connecterAction(MouseEvent event) {
        cnx.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    String query = "SELECT * FROM user where userName='"+ tfUserName.getText() +"'";
                    Statement stm= connexion.createStatement();
                    ResultSet rst=stm.executeQuery(query);
                    String tf=tfPassword.getText();
                    if(rst.next())
                    {
                        if(String.valueOf(rst.getString("password")).equals(tf))
                        {
                            try {
                                NewFXMain.user=new User(rst.getString("userName"),rst.getString("userNom"),rst.getString("userPrenom"),rst.getString("email"),rst.getString("password"),rst.getLong("telUser"),rst.getString("photoProfile"),rst.getDate("dateNaissance"),rst.getString("descriptionUser"));
                                NewFXMain.user.setIdUser(rst.getInt("idUser"));
                                switchScreen("PreferenceUser.fxml");
                                
                            } catch (IOException ex) {
                                Logger.getLogger(ConnexionController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        else {
                            passwordInvalide.setVisible(true);
                            userNameInvalide.setVisible(false);
                        }
                    }
                    else { 
                        userNameInvalide.setVisible(true);
                    }
                      
                } catch (SQLException ex1) {
                    System.out.println("Echec de connexion");
                }
            }
        });
        
    }
    public void switchScreen(String screen) throws IOException {
        Parent root = FXMLLoader.load(getClass()
                .getResource(screen));
        Scene scene = new Scene(root) ;
        Stage stage = (Stage) cnx.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
    }
   @FXML
    void inscrireAction(MouseEvent event) {
        inscription.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    switchScreen("Inscription.fxml");
                } catch (IOException ex) {
                    Logger.getLogger(ConnexionController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }
   
}
