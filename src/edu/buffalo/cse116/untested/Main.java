package edu.buffalo.cse116;

import javax.swing.*;
import java.awt.*;

public class Main {

	
	 private JFrame f;
	 private JPanel p;
	 private JButton b1, b2, b3;
	 private JLabel lab;
	 
	 public Main() {
	 gui(); 
	 }
	 
	 public void gui(){
		 f = new JFrame("ERROR_404 Solitaire!!!!");
		 f.setVisible(true);
		 f.setSize(800, 600);
		 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 p = new JPanel();
		 p.setBackground(Color.GREEN);
		 
		 b1 = new JButton("Freecell");
		 b2 = new JButton("Baker's Dozen");
		 b3 = new JButton("EXIT");
		 lab = new JLabel("Solitaire Games");
		 
		 p.add(b1);
		 p.add(b2);
		 p.add(b3);
		 p.add(lab);
		 
		 f.add(p);
		 
	 }
	 
	
  public static void main(String[] args) {
    // TODO Auto-generated method stub
   Freecell fe = new Freecell(8,4,4);
    fe.initialSetup();
    new Main();
    
  }

}
