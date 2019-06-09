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
     * @return : dans l'ordre info globale de l'élève, nom de la classe, appreciation du bulletin, evaluation, listedesmatieres puis type de personne
     * @param id l'id de la personne dont on souhaite afficher les infos (prof ou eleve)
     */
    public ArrayList<ArrayList<String>> recherche_info_personne(double id){ // il va rester des choses à compléter pour cette méthode, notamment la gestion des trimestres année ... 
        ArrayList<ArrayList<String>> liste=new ArrayList<>();
        ArrayList<String> infoglobale=new ArrayList<>();
        ArrayList<String> typepersonne=new ArrayList<>();
        ArrayList<String> nomclasse=new ArrayList<>();
        ArrayList<String> appreciationbulletin=new ArrayList<>();
        ArrayList<String> evaluation=new ArrayList<>();
        ArrayList<String> listedesmatieres=new ArrayList<>();
        ArrayList<String> discipline=new ArrayList<>();
        ArrayList<String> typedepersonne=new ArrayList<>();
        
        String string="";
        try{
            Connexion connexion = new Connexion("gestion_ecole","root","AMAZON");
            // premier array de string contenant infos sur la personne
            infoglobale=connexion.remplirChampsRequete("SELECT * FROM personne WHERE id_personne="+id+""); 
            typepersonne=connexion.remplirChampsRequete("SELECT type FROM personne WHERE id_personne="+id+"");
            string=typepersonne.get(0);
            String string2="élève"+"\n";
            String string3="professeur"+"\n";
            if(string.equals(string2)) // si la personne sélectionnée eest un élève
            {
                //La liste 2 va contenir le nom de la classe de l'élève
                nomclasse=connexion.remplirChampsRequete("SELECT classe.nom FROM `classe`,`inscription`,`personne` WHERE classe.id_classe=inscription.id_classe and inscription.id_personne="+id+" GROUP BY classe.nom");
                appreciationbulletin=connexion.remplirChampsRequete("SELECT bulletin.appreciation_globale FROM `bulletin`, `inscription` WHERE bulletin.id_inscription=inscription.id_inscription and inscription.id_personne="+id+"");
                evaluation=connexion.remplirChampsRequete("SELECT evaluation.note, evaluation.appreciation,discipline.nom FROM evaluation, detailbulletin, bulletin, inscription, discipline,enseignement WHERE evaluation.id_detail=detailbulletin.id_detail and detailbulletin.id_bulletin=bulletin.id_bulletin and bulletin.id_inscription=inscription.id_inscription and inscription.id_personne="+id+" and detailbulletin.id_enseignement=enseignement.id_enseignement AND enseignement.id_discipline=discipline.id_discipline");
                listedesmatieres=connexion.remplirChampsRequete("SELECT discipline.nom FROM discipline");
                System.out.print(listedesmatieres.get(0));
            }
            if(string.equals(string3)){ // si la personne selectionnée est un prof
                discipline=connexion.remplirChampsRequete("SELECT discipline.nom FROM discipline,enseignement,personne WHERE personne.id_personne="+id+" AND enseignement.id_personne=personne.id_personne and enseignement.id_discipline=discipline.id_discipline");
                nomclasse=connexion.remplirChampsRequete("SELECT classe.nom FROM classe,enseignement,personne WHERE classe.id_classe=enseignement.id_classe AND enseignement.id_personne=personne.id_personne AND personne.id_personne="+id+"");
                // autres ? 
            }
            
        }
        catch(Exception e){
            System.out.println("Erreur dans la recherche dinfo personne");
        }
        typedepersonne.add(string);
        liste.add(infoglobale);
        liste.add(nomclasse);
        liste.add(appreciationbulletin);
        liste.add(evaluation);
        liste.add(listedesmatieres);
        liste.add(typedepersonne);
        liste.add(discipline);
        
        return liste;
    }
}
