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
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import java.util.*;


public class BadIdea1 extends JFrame implements ActionListener, WindowListener {
    
JButton b1 = new JButton("Button 1");
JButton b2 = new JButton("Button 2");
JButton b3 = new JButton("Button 3");
JButton b4 = new JButton("Button 4");
JTextField textbox1=new JTextField(); // les 3 textbox
JTextField textbox2=new JTextField();
JTextField textbox3=new JTextField();

public BadIdea1()
{
    setLayout(new FlowLayout());
    this.addWindowListener(this); // le BadIdea1 s'écoute lui-même!
    this.setSize(800,400);
    this.setLocationRelativeTo(null);
    // Le menu avec la possibilité de sortir a tout moment
    JMenuBar menuBar = new JMenuBar();
    ImageIcon exitIcon = new ImageIcon("exit.png"); // creation de l'image 

    JMenu fileMenu = new JMenu("Exit"); // creation de longlet ? 
    fileMenu.setMnemonic(KeyEvent.VK_F); // on set un event potentiel ? ...
   
    JMenuItem eMenuItem = new JMenuItem("Exit", exitIcon); // on créé un item de menu
    eMenuItem.setMnemonic(KeyEvent.VK_E);  
    eMenuItem.setToolTipText("Exit application"); // set le texte qui saffiche avec le curseur
    eMenuItem.addActionListener((event) -> System.exit(0));

    fileMenu.add(eMenuItem);
    menuBar.add(fileMenu);

    this.setJMenuBar(menuBar);
        
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
        this.add(b1);
        this.add(b4);
}
/**
 * fonction pour le module recherche informations 
 */
public void set_recherche(){
    this.setTitle("Recherche d'informations");
    b3.addActionListener(this);
    b3.setText("Rechercher une personne");
    this.add(b3);
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