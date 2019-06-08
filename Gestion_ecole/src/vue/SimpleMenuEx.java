/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JLabel;
 import java.awt.*;
import javax.swing.JButton;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author pierr
 */
public class SimpleMenuEx extends JFrame implements ActionListener {
    JButton b1 = new JButton("Module : Mise à jour");
    JButton b2 = new JButton("Module : Reporting");
    JButton b3 = new JButton("Module : Recherche d'information");
    
    
    public SimpleMenuEx() {
        initUI();
    }

    private void initUI() {
        createMenuBar();
        setLayout(new FlowLayout());
        this.setTitle("Menu principal");
        this.setSize(800, 400);
        this.setLocationRelativeTo(null);
        b1.addActionListener(this); // le BadIdea1 écoute le bouton
        b2.addActionListener(this);
        b3.addActionListener(this);
        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if(source == b1){ // MISE A JOUR 
            System.out.println("Button 1 pressed");
            this.dispose(); // ON PEUT FAIRE VISIBLE FALSE POUR LA GARDER ET PAS AVOIR A LA CREER A CHAQUE FOIS 
            BadIdea1 fenetre_maj=new BadIdea1();
            fenetre_maj.set_maj();
            fenetre_maj.setVisible(true);
        }
        if(source == b2)
        {
            System.out.println("Button 2 pressed");
        }
        if(source == b3) // RECHERCHE DINFO 
        {
            System.out.println("Button 3 pressed");
            this.dispose(); // ON PEUT FAIRE VISIBLE FALSE POUR LA GARDER ET PAS AVOIR A LA CREER A CHAQUE FOIS 
            BadIdea1 fenetre_maj=new BadIdea1();
            fenetre_maj.set_recherche();
            fenetre_maj.setVisible(true);
        }
        else
            System.out.println("Something else");
            // a completer
    }

    /**
     * Methode qui créé la barre de menu avec le exit et le menu qui permettent respectivement de quitter l'application et de revenir au menu principal 
     */
    private void createMenuBar() {

        JMenuBar menuBar = new JMenuBar();
        ImageIcon exitIcon = new ImageIcon("exit.png"); // creation de l'image 

        JMenu fileMenu = new JMenu("Exit"); // creation de longlet ? 
        JMenu fileMenu2 = new JMenu("Menu");
        fileMenu.setMnemonic(KeyEvent.VK_F); // on set un event potentiel ? ...
   
        JMenuItem eMenuItem = new JMenuItem("Exit", exitIcon); // on créé un item de menu
        JMenuItem eMenuItem2 = new JMenuItem("Menu");
        eMenuItem.setMnemonic(KeyEvent.VK_E); 
        eMenuItem2.setMnemonic(KeyEvent.VK_E);
        eMenuItem.setToolTipText("Exit application"); // set le texte qui saffiche avec le curseur
        eMenuItem.addActionListener((event) -> System.exit(0));
        eMenuItem2.addActionListener(this);
        fileMenu.add(eMenuItem);
        fileMenu2.add(eMenuItem2);
        menuBar.add(fileMenu);
        menuBar.add(fileMenu2);
        this.setJMenuBar(menuBar);
    }
    /*public static void main(String[] args) {

        

            SimpleMenuEx ex = new SimpleMenuEx();
            ex.setVisible(true);
        
    }*/
}
