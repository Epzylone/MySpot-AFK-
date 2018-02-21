/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;


import java.util.Date;
import java.util.Random;

/**
 *
 * @author ASUS
 */
public class User {
    private int idUser;
    private String userName;
    private String userNameCanonical;
    private String userNom;
    private String userPrenom;
    private String email;
    private String emailCanonical;
    private Boolean enabled;
    private String salt;
    private String password;
    private String plainPassword;
    private Date lastLogin;
    private String confirmationToken;
    private Date passwordRequestedAt;
    private long telUser;
    private Date dateInscription;
    private String photoProfile;
    private long nombreConnexion;
    private Date dateNaissance;
    private String descriptionUser;
    
    public User(){
        
    }
    public User(String userName, String userNom, String userPrenom, String email, String password, long telUser, String photoProfile, Date dateNaissance, String descriptionUser) {
        this.userName = userName;
        this.userNameCanonical = userName.toLowerCase();
        this.userNom = userNom;
        this.userPrenom = userPrenom;
        this.email = email;
        this.emailCanonical = email.toLowerCase();
        this.enabled = true;
        this.salt = null;
        this.password = password;
        this.plainPassword = null;
        this.lastLogin = new Date();
        String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i=0;i<7;i++)
        {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars
                .length())));
        }
        this.confirmationToken = sb.toString();
        this.passwordRequestedAt = null;
        this.telUser = telUser;
        this.dateInscription = new Date();
        this.photoProfile = photoProfile;
        this.nombreConnexion = 1;
        this.dateNaissance = dateNaissance;
        this.descriptionUser = descriptionUser;

    }
    
    
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNameCanonical() {
        return userNameCanonical;
    }

    public void setUserNameCanonical(String userNameCanonical) {
        this.userNameCanonical = userNameCanonical;
    }

    public String getUserNom() {
        return userNom;
    }

    public void setUserNom(String userNom) {
        this.userNom = userNom;
    }

    public String getUserPrenom() {
        return userPrenom;
    }

    public void setUserPrenom(String userPrenom) {
        this.userPrenom = userPrenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailCanonical() {
        return emailCanonical;
    }

    public void setEmailCanonical(String emailCanonical) {
        this.emailCanonical = emailCanonical;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPlainPassword() {
        return plainPassword;
    }

    public void setPlainPassword(String plainPassword) {
        this.plainPassword = plainPassword;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public Date getPasswordRequestedAt() {
        return passwordRequestedAt;
    }

    public void setPasswordRequestedAt(Date passwordRequestedAt) {
        this.passwordRequestedAt = passwordRequestedAt;
    }

    public long getTelUser() {
        return telUser;
    }

    public void setTelUser(long telUser) {
        this.telUser = telUser;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public String getPhotoProfile() {
        return photoProfile;
    }

    public void setPhotoProfile(String photoProfile) {
        this.photoProfile = photoProfile;
    }

    public Long getNombreConnexion() {
        return nombreConnexion;
    }

    public void setNombreConnexion(Long nombreConnexion) {
        this.nombreConnexion = nombreConnexion;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getDescriptionUser() {
        return descriptionUser;
    }

    public void setDescriptionUser(String descriptionUser) {
        this.descriptionUser = descriptionUser;
    }

    @Override
    public String toString() {
        return "User{" + "userNom=" + userNom + ", userPrenom=" + userPrenom + ", email=" + email + ", telUser=" + telUser + ", dateInscription=" + dateInscription + ", nombreConnexion=" + nombreConnexion + ", dateNaissance=" + dateNaissance + ", descriptionUser=" + descriptionUser + '}';
    }
    
}
