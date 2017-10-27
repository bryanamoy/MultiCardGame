package edu.buffalo.cse116;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class SolitaireController2 extends Application{
	private MainMenu gui;
	private SolitaireView view;
	private BakersDozen bd;
	private Freecell fc;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		BakersDozen bd = new BakersDozen(); //create new BakersDozen game
		bd.initialSetup();					//set up bakersdozen game
		
		Freecell fc = new Freecell(8,4,4); //create new freecell game
		fc.initialSetup();				  //set up freecell game
		
		bd.removeFromHomecell(); //returns illegal move
		
		//try and catch for when a move to tableau pile is illegal. displayErrorMessage is for
		//for the bullet point asking to display error message for the move
		try{
			bd.addToHomecell(card, Pile);	
		}
		catch(IllegalHomecellCardException hex){
			view.displayErrorMessage("Card needs to be identical suit and one rank above current top card");
		}
		
		//try and catch for when a move to homecell pile is illegal
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
	public static void main(String args[]){ 
	      launch(args); 
	   } 
}
