/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Services.UserService;
import entities.Mail;
import entities.MailConstruction;
import entities.User;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ForgotPasswordController implements Initializable {

    @FXML
    private TextField tfUserName;
    @FXML
    private TextField tfEmail;
    @FXML
    private Button envoyer;
    URL url;
    Mail mail = new Mail();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void envoyerMailAction(MouseEvent event) {
        envoyer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UserService us=new UserService();
                User user = us.chercherUserParEmail(tfEmail.getText());
                String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
                StringBuilder sb = new StringBuilder();
                Random random = new Random();
                for(int i=0;i<7;i++)
                {
                    sb.append(candidateChars.charAt(random.nextInt(candidateChars
                            .length())));
                }
                String password=sb.toString();
                user.setPassword(password);
                us.modifierUser(user, tfEmail.getText());
                mail.setMailAddressRecipient(tfEmail.getText());
                mail.setPwd("myspotpass");
                mail.setMailAddressSender("myspot3A12@gmail.com");
                mail.setMailSubject("Forgot Password");
                mail.setMailObject("Votre nouveau mot de passe est: "+password);
                MailConstruction mc = new MailConstruction();
                mc.getMailProperties();
                mc.getMailMessage(mail);
                mc.SendMessage();
                try {
                    switchScreen("Connexion.fxml");
                } catch (IOException ex) {
                    Logger.getLogger(ForgotPasswordController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }
    public void switchScreen(String screen) throws IOException {
        Parent root = FXMLLoader.load(getClass()
                .getResource(screen));
        Scene scene = new Scene(root) ;
        Stage stage = (Stage) envoyer.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    
}
}
