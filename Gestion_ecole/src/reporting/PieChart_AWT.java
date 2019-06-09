/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting;

/**
 *
 * @author pierr
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import vue.SimpleMenuEx;
 
public class PieChart_AWT extends ApplicationFrame implements ActionListener {
    JMenuItem eMenuItem2 = new JMenuItem("Menu"); // contrairement au exit on est obligé de passer par un attribut pour ensuite gerer l'event dans le Actionperformed
   
    /**
     * construct surchargé 
     * set la taille , create la menu bar et appelle createdemopanel pour le contenu de la fenetre 
     * @param title :titre du camembert  
     */
   public PieChart_AWT( String title ) {
      super( title ); 
      createMenuBar();
      this.setSize( 560 , 367 );    
      setContentPane(createDemoPanel( ));
   }
   
   private static PieDataset createDataset( ) {
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue( "IPhone 5s" , new Double( 20 ) );  
      dataset.setValue( "SamSung Grand" , new Double( 20 ) );   
      dataset.setValue( "MotoG" , new Double( 40 ) );    
      dataset.setValue( "Nokia Lumia" , new Double( 10 ) );  
      return dataset;         
   }
   
   @Override
public void actionPerformed(ActionEvent e){
    Object source = e.getSource();
    if (source==eMenuItem2) // RETOUR MENU
    {
        System.out.print("Retour menu");
        SimpleMenuEx gobacktomenu=new SimpleMenuEx();
        this.dispose();
        gobacktomenu.setVisible(true);
    }
}
   private static JFreeChart createChart( PieDataset dataset ) {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Mobile Sales",   // chart title 
         dataset,          // data    
         true,             // include legend   
         true, 
         false);

      return chart;
   }
   
   public static JPanel createDemoPanel( ) {
      JFreeChart chart = createChart(createDataset( ) );  
      return new ChartPanel( chart ); 
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

   public static void main( String[ ] args ) {
      PieChart_AWT demo = new PieChart_AWT( "Mobile Sales" );  
      demo.setSize( 560 , 367 );    
      RefineryUtilities.centerFrameOnScreen( demo );    
      demo.setVisible( true ); 
   }
}