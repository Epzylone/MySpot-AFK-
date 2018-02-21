/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ASUS
 */
public class Mail {
    private String mailAddressSender ;
    private String pwd ;
    private String mailAddressRecipient ; 
    private String mailObject ;
    private String mailSubject ;
    
    public Mail(){
    
    }
    public String getMailAddressSender() {
        return mailAddressSender;
    }

    public void setMailAddressSender(String mailAddressSender) {
        this.mailAddressSender = mailAddressSender;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMailAddressRecipient() {
        return mailAddressRecipient;
    }

    public void setMailAddressRecipient(String mailAddressRecipient) {
        this.mailAddressRecipient = mailAddressRecipient;
    }

    public String getMailObject() {
        return mailObject;
    }

    public void setMailObject(String mailObject) {
        this.mailObject = mailObject;
    }

    public String getMailSubject() {
        return mailSubject;
    }

    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }
}
