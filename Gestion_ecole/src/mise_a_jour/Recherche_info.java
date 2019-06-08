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
    /**
     * La fonction renvoie un array d'array contenant toutes les infos de la personne 
     * @param id l'id de la personne dont on souhaite afficher les infos (prof ou eleve)
     */
    public void recherche_info_personne(double id){ // il va rester des choses à compléter pour cette méthode, notamment la gestion des trimestres année ... 
        ArrayList<String> infoglobale=new ArrayList<>();
        ArrayList<String> typepersonne=new ArrayList<>();
        ArrayList<String> nomclasse=new ArrayList<>();
        ArrayList<String> appreciationbulletin=new ArrayList<>();
        try{
            Connexion connexion = new Connexion("gestion_ecole","root","AMAZON");
            // premier array de string contenant infos sur la personne
            infoglobale=connexion.remplirChampsRequete("SELECT * FROM personne WHERE id_personne="+id+""); 
            typepersonne=connexion.remplirChampsRequete("SELECT type FROM personne WHERE id_personne="+id+"");
            String string=typepersonne.get(0);
            String string2="élève"+"\n";
            if(string.equals(string2)) // si la personne sélectionnée eest un élève
            {
                //La liste 2 va contenir le nom de la classe de l'élève
                nomclasse=connexion.remplirChampsRequete("SELECT classe.nom FROM `classe`,`inscription`,`personne` WHERE classe.id_classe=inscription.id_classe and inscription.id_personne="+id+" GROUP BY classe.nom");
                appreciationbulletin=connexion.remplirChampsRequete("SELECT bulletin.appreciation_globale FROM `bulletin`, `inscription` WHERE bulletin.id_inscription=inscription.id_inscription and inscription.id_personne="+id+"");
              //  appreciationbulletin=connexion.remplirChampsRequete("");
            }
            else
                System.out.print("NON");
        }
        catch(Exception e){
            System.out.println("Erreur dans la recherche dinfo personne");
        }
    }
}
