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
public class Maj {
    
    /*
    FONCTION INCOMPLETE il faudra sans doute rajouter la personne dans d'autres tables 
    */
    public void ajoutpersonne(String nom, String prenom, String type) // on fait un throws ou on return un boolean ? 
    {
    //On attribue l'id aléatoirement en espérant ne pas tomber sur le même
    Random rand = new Random();
    // Obtain a number between [0 - 50000].
    double id = rand.nextInt(50000);
        try{
    Connexion connexion = new Connexion("gestion_ecole","root","AMAZON");
    connexion.executeUpdate("INSERT INTO  personne (`id_personne`, `type`, `nom`, `prenom`) VALUES ("+id+",'"+type+"','"+nom+"','"+prenom+"')"); // ATTENTION pas d'apostrophes devant les nombres 
        }
        catch(Exception e)
        {
        System.out.println("Erreur dans l'ajout");
        }          
    }
    
    // on ajoute un élève à un la table inscription
    // on le met dans une classe (td 8) par exemple 
    public void inscrire_eleve(int id_eleve,int id_classe) 
    {
        //On attribue l'id aléatoirement en espérant ne pas tomber sur le même
    Random rand = new Random();
    // Obtain a number between [0 - 50000].
    double id = rand.nextInt(50000);
        try{
            Connexion connexion = new Connexion("gestion_ecole","root","AMAZON");
            connexion.executeUpdate("INSERT INTO  inscription (`id_inscription`, `id_classe`, `id_personne`) VALUES ("+id+",'"+id_classe+"','"+id_eleve+"')");
        }
        catch(Exception e){
            System.out.println("Erreur dans l'inscription");
        }
    
    }
    /**
     * inscris une note à l'eleve dont on rentre l'id, il faut mentionner la discipline appreciation et note bien evidemment
     * @param id_eleve
     * @param discipline
     * @param appreciation
     * @param note 
     */
    public void inscrire_note(double id_eleve,String discipline,String appreciation,int note){
           //On attribue l'id aléatoirement en espérant ne pas tomber sur le même
    ArrayList<String> detailbulletin=new ArrayList();
    ArrayList<String> id_discipline=new ArrayList();
    // Obtain a number between [0 - 50000].
    Random rand = new Random();
    double id_evaluation = rand.nextInt(50000);
        try{
            Connexion connexion = new Connexion("gestion_ecole","root","AMAZON");
                              
            //System.out.print(result);
            detailbulletin=connexion.remplirChampsRequete("SELECT detailbulletin.id_detail FROM detailbulletin,personne,inscription,bulletin,discipline,enseignement WHERE personne.id_personne="+id_eleve+" and personne.id_personne=inscription.id_personne AND inscription.id_inscription=bulletin.id_inscription AND bulletin.id_bulletin=detailbulletin.id_bulletin and detailbulletin.id_enseignement=enseignement.id_enseignement and enseignement.id_discipline=discipline.id_discipline and discipline.nom='"+discipline+"' GROUP BY detailbulletin.id_detail");
            connexion.executeUpdate("INSERT INTO  evaluation (`id_evaluation`, `id_detail`, `note`,`appreciation`) VALUES ("+id_evaluation+",'"+detailbulletin.get(0)+"','"+note+"','"+appreciation+"')");
            
        }
        catch(Exception e){
            System.out.println("erreur exception");
        }
    }
            
}
