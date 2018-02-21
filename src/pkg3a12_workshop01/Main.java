/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3a12_workshop01;

import DataStorage.MyDB;
import Services.ProprieteService;
import entities.Propriete;
import entities.CritereEvaluation;
import Services.CritereEvaluationService;
import entities.TypePropriete;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import entities.Categorie;
/**
 *
 * @author bhk
 */
public class Main {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
    Date aujourdhui = new Date();
    DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
    DateFormat.SHORT,
    DateFormat.SHORT);
   SimpleDateFormat format = new SimpleDateFormat( "MM/dd/yyyy" );  // United States style of format.
   Date myDate = format.parse( "10/10/2009" );
    Categorie cat=new Categorie(1,"Resto");
        Propriete P = new Propriete("WOLF&RABBIT","MENZAH 9",22222222,"Ariana",124.4145,4578.658,"LUNDI-DIMANCHE",9,"Un bel endroit...",3,aujourdhui,true,cat);
         Propriete P2 = new Propriete("WOLFffffffffffff","MENZAH 8",22222222,"Aaaaaaana",124.4145,4578.658,"LUNDI-DIMANCHE",9,"Un bel endroit...",3,aujourdhui,true,cat);
       // Propriete P2 = new Propriete(2,"CAFE","TESTTTCAFEEE",146545,"UNIS",124.4145,4578.658);
        //Propriete P3 = new Propriete(3,"ABCC","TEsssssttt",11345,"TIS",124.4145,4578.658);        
        //ProduitService ps= new ProduitService();
        ProprieteService PS = new ProprieteService();
        //PS.ajouterPropriete(P);
        //PS.ajouterPropriete(P2);
        //PS.ajouterPropriete(P3);
        //PS.supprimerPropriete(P);
      //  PS.modifierPropriete(P2, "WOLF&RABBIT");
        //PS.lirePropriete();
       //  for(Iterator it=PS.lirePropriete().iterator(); it.hasNext();)
         //   System.out.println(it.next()); 
         //System.out.println(PS.chercherPropriete("WOLF").toString()); 
      //  CritereEvaluation C = new CritereEvaluation(1,"Hygiene",2);
        //CritereEvaluation C2 = new CritereEvaluation(1,"MIAM MIAM",2);
        //CritereEvaluationService CES = new CritereEvaluationService();
       // CES.ajouterCritereEvaluation(C);
        //CES.supprimerCritereEvaluation("Hygiene");
     //   CES.modifierCritereEvaluation(C2,"Hygiene");
        
    }

}
