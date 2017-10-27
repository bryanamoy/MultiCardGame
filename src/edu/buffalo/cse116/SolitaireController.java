package edu.buffalo.cse116;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class SolitaireController {
	private MainMenu gui;
	private SolitaireView view;
	private BakersDozen bd;
	private Freecell fc;
//	private static final Border UNSELECTED_BORDER = BorderFactory.createEmptyBorder(5, 5, 5, 5);
//    private static final Border SELECTED_BORDER = BorderFactory.createMatteBorder(5, 5, 5, 5,
//                                                                                Color.BLUE);
//	
	public SolitaireController(MainMenu gui, SolitaireView view, BakersDozen bd, Freecell fc){
		this.gui = gui;
		this.view = view;
		this.bd = bd;
		this.fc = fc;
		
		this.view.addSolitaireListener(new SolitaireListener());
		
	}		
	                  
	
		public void selectCard(MainMenu border){
			border.setBorder(SELECTED_BORDER);
			border.repaint();
		}
		public void unselectCard(MainMenu border){
			border.setBorder(UNSELECTED_BORDER);
			border.repaint();
		}
	public void BakersDozenGame(ActionEvent event){
		BakersDozen bd = new BakersDozen(); //create new BakersDozen game
		bd.initialSetup();					//set up bakersdozen game
	}
	public void FreecellGame(ActionEvent event){
		Freecell fc = new Freecell(8,4,4); //create new freecell game
		fc.initialSetup();				  //set up freecell game
	}
	public void removeHomecell(ActionEvent event){
	bd.removeFromHomecell(); //returns illegal move
		fc.removeCard(whichPile, whichNumber);
	}
		
	public void addCard(ActionEvent event){	
		//try and catch for when a move to homecell pile is illegal
	try{
			bd.addToHomecell(card, Pile);	
		}
		catch(IllegalHomecellCardException hex){
			view.displayErrorMessage("Card needs to be identical suit and one rank above current top card");
		}
		
	/*	
	try and catch for when a move to tableau pile is illegal. displayErrorMessage is for
	for the bullet point asking to display error message for the move	
	*/
	try{
			bd.addCard(add, Pile);
		}
		catch(IllegalCardTableauCardException tex){
			view.displayErrorMessage("Card needs to be one less rank than current top card");
		}
		
		try{
			fc.addCard(theCard, whichPile, whichNumber);
		}
		catch(IllegalMoveException ex){
			view.displayErrorMessage("Error Message");
		}
	

	}
	public void setTableauPile(HashMap<Integer, ArrayList<Card>> tableauPiles_List){
		bd.setTableauPiles_List(tableauPiles_List);
		
	}
	public void setHomecellPile(HashMap<Integer, ArrayList<Card>> HomcellPiles_List){
		bd.setHomecellPiles_List(HomcellPiles_List);
	}
	
	//EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>();
		
	
		public void updateSolitaireView(){
		view.getCardImages();
	}



	   
		
		
}
