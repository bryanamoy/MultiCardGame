package edu.buffalo.cse116;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import javafx.scene.paint.Color;


public class SolitaireController {
	private MainMenu gui;
	private SolitaireView view;
	private static final Border UNSELECTED_BORDER = BorderFactory.createEmptyBorder(5, 5, 5, 5);
    private static final Border SELECTED_BORDER = BorderFactory.createMatteBorder(5, 5, 5, 5,
                                                                                Color.BLUE);
	
	public SolitaireController(MainMenu gui, SolitaireView view){
		this.gui = gui;
		this.view = view;
		
	}
	public void selectCard(MainMenu border){
		border.setBorder(SELECTED_BORDER);
		border.repaint();
	}
	public void unselectCard(MainMenu border){
		border.setBorder(UNSELECTED_BORDER);
		border.repaint();
	}
	public void getTopTableu(Card card){
		
	}
	public void addTableau(Card card){
		
	}
	public boolean selectHomecell(){
		return false;
	}
	public void addHomecell(BakersDozen bd, Card card){
		if(bd.addToHomecell((card.getSuit(), card.getRank()), bd.getHomecellPiles()) == false){
			System.out.println("This move is not legal!");
		}
	}
	public void updateSolitaireView(){
		
	}
}
