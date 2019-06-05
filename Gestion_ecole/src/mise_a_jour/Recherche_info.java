/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mise_a_jour;
import connexion.*;
import java.util.*;
/**
 *
 * @author pierr
 */
public class Recherche_info {
 
    
 /**
 * ça marche
 * @return un arraylist contenant les personnes (table personne de la bdd)
 */
    public ArrayList<String> affichage_personne()
            {
        //On attribue l'id aléatoirement en espérant ne pas tomber sur le même
    ArrayList<String> list=new ArrayList<>();
        try{
            Connexion connexion = new Connexion("gestion_ecole","root","AMAZON");
            list=connexion.remplirChampsRequete("SELECT * FROM personne");
           }
        catch(Exception e){
            System.out.println("Erreur dans l'inscription");
        }
    return list;
    }
}
