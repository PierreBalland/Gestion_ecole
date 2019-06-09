/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

/**
 *
 * @author pierr
 * Classe inspiree du cours ActionListener
 */

import mise_a_jour.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import java.util.*;
import javax.swing.JLabel;


public class BadIdea1 extends JFrame implements ActionListener, WindowListener {
    
JButton b1 = new JButton("Button 1");
JButton b2 = new JButton("Button 2");
JButton b3 = new JButton("Button 3");
JButton b4 = new JButton("Button 4");
JButton b5 = new JButton("Button 5");
JButton b6 = new JButton("Button 6");
JButton b7 = new JButton("Button 7");
JMenuItem eMenuItem2 = new JMenuItem("Menu"); // astuce de l'ajouter en attribut pour les actionlistener (retour menu a chaque fois)
JTextField textbox1=new JTextField(); // les 3 textbox
JTextField textbox2=new JTextField();
JTextField textbox3=new JTextField();
JTextField textbox4=new JTextField();

public BadIdea1()
{
    setLayout(new FlowLayout());
    this.addWindowListener(this); // le BadIdea1 s'écoute lui-même!
    this.setSize(800,400);
    this.setLocationRelativeTo(null);
    
    createMenuBar();
        
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

private void createMenuBar() {

        JMenuBar menuBar = new JMenuBar();
        ImageIcon exitIcon = new ImageIcon("exit.png"); // creation de l'image 

        JMenu fileMenu = new JMenu("Exit"); // creation de longlet ? 
        JMenu fileMenu2 = new JMenu("Menu");
        fileMenu.setMnemonic(KeyEvent.VK_F); // on set un event potentiel ? ...
   
        JMenuItem eMenuItem = new JMenuItem("Exit", exitIcon); // on créé un item de menu
        
        eMenuItem.setMnemonic(KeyEvent.VK_E); 
        
        eMenuItem.setToolTipText("Exit application"); // set le texte qui saffiche avec le curseur
        eMenuItem.addActionListener((event) -> System.exit(0));
        eMenuItem2.addActionListener(this);
        
        
        fileMenu.add(eMenuItem);
        fileMenu2.add(eMenuItem2);
        menuBar.add(fileMenu);
        menuBar.add(fileMenu2);
        this.setJMenuBar(menuBar);
    }
/**
 * fonction pour le module mise a jour 
 */
public void set_maj() // pour la fenetre du module maj
{
        this.setTitle("Menu de mise à jour");
        b1.addActionListener(this); // le BadIdea1 écoute le bouton
        b1.setText("Ajouter personne");
        b4.addActionListener(this);
        b4.setText("Delete Personne");
        b6.addActionListener(this);
        b6.setText("Inscrire une note à un élève");
        this.add(b1);
        this.add(b4);
        this.add(b6);
}

public void set_inscrire_note(){
    this.setTitle("Inscription de note");
    this.textbox1.setText("id_eleve");
    this.textbox2.setText("discipline");
    this.textbox3.setText("appreciation");
    this.textbox4.setText("note");
    this.b7.addActionListener(this);
    
    b7.setText("Inscrire la note");
    this.add(this.textbox1);
    this.add(this.textbox2);
    this.add(this.textbox3);
    this.add(this.textbox4);
    this.add(b7);
}

/**
 * fonction pour le module recherche informations 
 */
public void set_recherche(){
    
    this.setTitle("Recherche d'informations");
    b3.addActionListener(this);
    b3.setText("Voir toutes les personnes");
    this.add(b3);
    b5.setText("Voir les infos d'une personne");
    b5.addActionListener(this);
    this.add(b5);
    JTextField textbox1=new JTextField("Rentrez l'id de la personne à rechercher",20);
    this.textbox1=textbox1;
    this.getContentPane().add(this.textbox1);
    
}
public void voir_info_personne(double id)
{
    this.setTitle("Voir info personne");
    setLayout(new FlowLayout());
    Recherche_info recherche=new Recherche_info();
    ArrayList<ArrayList<String>> arraydinformations=recherche.recherche_info_personne(id);
    if(arraydinformations.get(5).get(0).equals("élève"+"\n"))
   // for(int i=0;i<arraydinformations.size();i++)
   // {
    {
        JLabel j=new JLabel("Info générale de l'élève : ");
        this.getContentPane().add(j);
        for(int u=0;u<arraydinformations.get(0).size();u++)
        {
        JTextField textbox=new JTextField();
        textbox.setText(arraydinformations.get(0).get(u));
        this.getContentPane().add(textbox);
        }
        JLabel j2=new JLabel("Classe : ");
        this.getContentPane().add(j2);
        for(int u=0;u<arraydinformations.get(1).size();u++)
        {
        JTextField textbox=new JTextField();
        textbox.setText(arraydinformations.get(1).get(u));
        this.getContentPane().add(textbox);
        }
        JLabel j3=new JLabel("Appreciation du bulletin : ");
        this.getContentPane().add(j3);
        for(int u=0;u<arraydinformations.get(2).size();u++)
        {
        JTextField textbox=new JTextField();
        textbox.setText(arraydinformations.get(2).get(u));
        this.getContentPane().add(textbox);
        }
        JLabel j4=new JLabel("Evaluations : ");
        this.getContentPane().add(j4);
        for(int u=0;u<arraydinformations.get(3).size();u++)
        {
       // JLabel matiere=new JLabel();
        JTextField textbox=new JTextField();
       // matiere.setText("("+arraydinformations.get(4).get(u)+")");
        textbox.setText(arraydinformations.get(3).get(u));
        //this.getContentPane().add(matiere);
        this.getContentPane().add(textbox);
        }
    }
    if(arraydinformations.get(5).get(0).equals("professeur"+"\n"))
    {
        JLabel j=new JLabel("Info générale du professeur : ");
        this.getContentPane().add(j);
        for(int u=0;u<arraydinformations.get(0).size();u++)
        {
        JTextField textbox=new JTextField();
        textbox.setText(arraydinformations.get(0).get(u));
        this.getContentPane().add(textbox);
        }
        JLabel j2=new JLabel("Enseigne dans le/les classes : ");
        this.getContentPane().add(j2);
        for(int u=0;u<arraydinformations.get(1).size();u++)
        {
        JTextField textbox=new JTextField();
        textbox.setText(arraydinformations.get(1).get(u));
        this.getContentPane().add(textbox);
        }
        JLabel j4=new JLabel("Enseignant en : ");
        this.getContentPane().add(j4);
        for(int u=0;u<arraydinformations.get(6).size();u++)
        {
        JTextField textbox=new JTextField();
        textbox.setText(arraydinformations.get(6).get(u));
        this.getContentPane().add(textbox);
        }
    }
        /*
        // on créé un textbox pour chaque row de personnes
        for(int k=0;k<arraydinformations.get(i).size();k++)
        {
        JTextField textbox=new JTextField();
        textbox.setText(arraydinformations.get(i).get(k));
        this.getContentPane().add(textbox);
        }*/
   // }
   

}
/**
 * fonction pour la recherche de personne depuis module recherche informations
 */
public void set_recherche_personne(){
    this.setTitle("Affichage des personnes");
    Recherche_info recherche=new Recherche_info();
    ArrayList<String> arraydepersonnes=recherche.affichage_personne();
    for(int i=0;i<arraydepersonnes.size();i++)
    {
        JTextField textbox=new JTextField(); // on créé un textbox pour chaque row de personnes
        textbox.setText(arraydepersonnes.get(i));
        this.getContentPane().add(textbox);
    }
  
}
/**
 * fonction pour l'ajout de personne dans la bdd , module maj
 */
public void set_ajout_personne()
{
  this.setTitle("Ajout d'un élève/professeur");
  JTextField textbox1=new JTextField("Nom",10); // les 3 textobox
  JTextField textbox2=new JTextField("Prenom",10);
  JTextField textbox3=new JTextField("Type",10);
  this.textbox1=textbox1;
  this.textbox2=textbox2;
  this.textbox3=textbox3;
  //bouton pour envoyer l'ajout
  b2.addActionListener(this); // le BadIdea1 écoute le bouton
  b2.setText("Ajouter la personne");
  
  this.add(b2);
  
  this.getContentPane().add(this.textbox1);
  this.getContentPane().add(this.textbox2);
  this.getContentPane().add(this.textbox3);
  
}
// TOUTES LES ACTIONS ICI
@Override
public void actionPerformed(ActionEvent e)
{
    //on recupere la source 
    Object source = e.getSource();  
    if(source == b1)
    {
        System.out.println("Button 1 pressed");
        this.dispose(); // ON PEUT FAIRE VISIBLE FALSE POUR LA GARDER ET PAS AVOIR A LA CREER A CHAQUE FOIS 
        BadIdea1 fenetre_maj=new BadIdea1();
        fenetre_maj.set_ajout_personne();
        fenetre_maj.setVisible(true);
    }
    else if(source == b2) // bouton ajout personne
    {
        System.out.println("Button 2 pressed");
        Maj maj=new Maj();
        if(this.textbox1.getText()!="Nom" && this.textbox2.getText()!="Prenom" &&(this.textbox3.getText().equals("élève") || this.textbox3.getText().equals("professeur")))
        {
            maj.ajoutpersonne(this.textbox1.getText(), this.textbox2.getText(), this.textbox3.getText());
        }
        else
        {
            //on go back au menu si on a mal rempli l'ajout
            this.dispose();
            SimpleMenuEx gobacktomenu=new SimpleMenuEx();
            gobacktomenu.setVisible(true);
        }
    }
    if (source == b3) //RECHERCHE PERSONNE
    {
        System.out.println("Button 3 pressed");
        this.dispose(); // ON PEUT FAIRE VISIBLE FALSE POUR LA GARDER ET PAS AVOIR A LA CREER A CHAQUE FOIS 
        BadIdea1 fenetre=new BadIdea1();
        fenetre.set_recherche_personne();
        fenetre.setVisible(true);
    }
    if(source==b4) // DELETE PERSONNE 
    {
        System.out.println("Button 4 pressed");
        this.dispose(); // ON PEUT FAIRE VISIBLE FALSE POUR LA GARDER ET PAS AVOIR A LA CREER A CHAQUE FOIS 
        BadIdea1 fenetre=new BadIdea1();
        fenetre.set_recherche_personne();
        fenetre.setVisible(true);
    }
    if (source==eMenuItem2) // RETOUR MENU
    {
        System.out.print("Retour menu");
        SimpleMenuEx gobacktomenu=new SimpleMenuEx();
        this.dispose();
        gobacktomenu.setVisible(true);
    }
    if (source==b5) //VOIR INFO DUNE PERSONNE
    {
        System.out.println("Button 5 pressed");
        this.dispose(); // ON PEUT FAIRE VISIBLE FALSE POUR LA GARDER ET PAS AVOIR A LA CREER A CHAQUE FOIS 
        BadIdea1 fenetre=new BadIdea1();
        try{
        fenetre.voir_info_personne(Double.parseDouble(this.textbox1.getText()));
        fenetre.setVisible(true);
        }
        catch(Exception exception){
            System.out.println("Erreur dans l'id demandé : retour menu");
            SimpleMenuEx retourmenu=new SimpleMenuEx();
            retourmenu.setVisible(true);
        }  
    }
    if (source==b6){ // ALLER VERS LINSCRIPTION DE NOTE
        System.out.println("Button 6 pressed");
        this.dispose(); // ON PEUT FAIRE VISIBLE FALSE POUR LA GARDER ET PAS AVOIR A LA CREER A CHAQUE FOIS 
        BadIdea1 fenetre=new BadIdea1();
        fenetre.set_inscrire_note();
        fenetre.setVisible(true);
    }
    if (source==b7){ // INSCRIPTION NOTE
        System.out.println("Button 7 pressed");
        Maj maj=new Maj();
        if(this.textbox1.getText()!="id_eleve" && this.textbox2.getText()!="note" && this.textbox3.getText()!="appreciation" && this.textbox4.getText()!="discipline")
        {
            maj.inscrire_note(Double.parseDouble(this.textbox1.getText()), this.textbox2.getText(), this.textbox3.getText(),Integer.parseInt(this.textbox4.getText()));
        }
        else
        {
            //on go back au menu si on a mal rempli l'ajout
            this.dispose();
            SimpleMenuEx gobacktomenu=new SimpleMenuEx();
            gobacktomenu.setVisible(true);
        }
    }
    else
        System.out.println("Something else");
}

@Override
public void windowClosing(WindowEvent e) {
System.out.println("Window Closing");
System.exit(0);
}
// définitions à vide des méthodes de l'interface
// WindowListener: c'est fastidieux!
@Override
public void windowClosed(WindowEvent e) {}
@Override
public void windowDeiconified(WindowEvent e) {}
@Override
public void windowIconified(WindowEvent e) {}
@Override
public void windowActivated(WindowEvent e) {}
@Override
public void windowDeactivated(WindowEvent e) {}
@Override
public void windowOpened(WindowEvent e) {}


} 