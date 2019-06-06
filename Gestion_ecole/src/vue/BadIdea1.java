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
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class BadIdea1 extends JFrame implements ActionListener, WindowListener {
    
JButton b1 = new JButton("Button 1");
JButton b2 = new JButton("Button 2");

public BadIdea1()
{
setLayout(new FlowLayout());
this.addWindowListener(this); // le BadIdea1 s'écoute lui-même!
this.setSize(800,400);
this.setLocationRelativeTo(null);

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
       
//b1.addActionListener(this); // le BadIdea1 écoute le bouton
//b2.addActionListener(this); // le BadIdea1 écoute le bouton
//this.add(b1);
//this.add(b2);
}

public void set_maj() // pour la fenetre du module maj
{
        b1.addActionListener(this); // le BadIdea1 écoute le bouton
        b1.setText("Ajouter personne");
        this.add(b1);
       

}
// relents de programmation procédurale
@Override
public void actionPerformed(ActionEvent e)
{
Object source = e.getSource();
if(source == b1)
System.out.println("Button 1 pressed");
else if(source == b2)
System.out.println("Button 2 pressed");
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


public static void main(String[] args) {
JFrame f = new BadIdea1();
f.setSize(300,200);
f.setVisible(true);
}

} 