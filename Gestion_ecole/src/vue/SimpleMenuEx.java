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
        this.add(b1);
        this.add(b2);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
    if(source == b1){
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
    else
    System.out.println("Something else");
  // a completer
    }

    private void createMenuBar() {

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
    }
    /*public static void main(String[] args) {

        

            SimpleMenuEx ex = new SimpleMenuEx();
            ex.setVisible(true);
        
    }*/
}
