/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_ecole;

import java.util.ArrayList;

import connexion.*;
import java.awt.EventQueue;
import mise_a_jour.*;
import vue.*;
/**
 *
 * @author pierr
 */
public class Gestion_ecole {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     /*   try{
        Connexion connexion = new Connexion("gestion_ecole","root","AMAZON");
      //  connexion.ajouterRequeteMaj("CREATE TABLE test");
     //   connexion.executeUpdate("CREATE TABLE pierre (pierre BIGINT)");
        //  connexion.executeUpdate("SELECT * FROM anneescolaire");
          ArrayList<String> list=new ArrayList<>();
        
         list=connexion.remplirChampsRequete("SELECT * FROM anneescolaire");
         String p;
         p=list.get(0);
         
         System.out.print(p);
     
       Maj maj=new Maj();
       maj.ajoutpersonne("Libbon", "Richard", "élève"); 
        }
        catch (Exception e)
        {
          System.out.print("erreur");
        }
*/
        Recherche_info inf=new Recherche_info();
        ArrayList<String> liste= inf.affichage_personne();
        
       for(int i=0;i<liste.size();i++)
       {
       System.out.println(liste.get(i));
       
       }
       SimpleMenuEx ex = new SimpleMenuEx();
            ex.setVisible(true);
       
               }
}
