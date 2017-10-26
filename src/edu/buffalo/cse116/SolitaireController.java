package edu.buffalo.cse116;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import javafx.scene.paint.Color;


public class SolitaireController {
	private MainMenu gui;
	private SolitaireView view;
	private BakersDozen bd;
	private Freecell fc;
	private static final Border UNSELECTED_BORDER = BorderFactory.createEmptyBorder(5, 5, 5, 5);
    private static final Border SELECTED_BORDER = BorderFactory.createMatteBorder(5, 5, 5, 5,
                                                                                Color.BLUE);
	
	public SolitaireController(MainMenu gui, SolitaireView view, BakersDozen bd, Freecell fc){
		this.gui = gui;
		this.view = view;
		this.bd = bd;
		this.fc = fc;
		
		this.view.addSolitaireListener(new SolitaireListener());
		
	}
	class SolitaireListener implements ActionListener{
		public void selectCard(MainMenu border){
			border.setBorder(SELECTED_BORDER);
			border.repaint();
		}
		public void unselectCard(MainMenu border){
			border.setBorder(UNSELECTED_BORDER);
			border.repaint();
		}
		public void getTopTableu(Card card, Card theCard, String whichPile, int whichNumber){
			bd.getTableauPiles_List();
			view.setCardImages();
			fc.addCard(theCard, whichPile, whichNumber);
			view.setCardImages();
		}
		public void addTableau(Card add, int Pile){
			bd.addCard(add, Pile);
			view.setCardImages();
		}
		public void selectHomecell(){
			bd.removeFromHomecell(); //returns false, cannot select homecell cards, can't move them
		}
		public void addHomecell(Card card, int Pile){
			try{
				bd.addToHomecell(card, Pile);
					bd.addToHomecell(card, Pile);
					view.setCardImages();
						//topHomecell = addedcard
			}
			catch(IllegalCardException ex){
				view.displayErrorMessage("Card needs to be identical suit and one rank above top card");
			}
		}
		
	}
	
	
	
	
	
	
	public void updateSolitaireView(){
		
	}
}
