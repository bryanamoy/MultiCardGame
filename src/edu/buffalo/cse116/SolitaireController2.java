package edu.buffalo.cse116;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class SolitaireController2{
	private MainMenu gui;
	private SolitaireView view;
	private BakersDozen bd;
	private Freecell fc;
		
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
	
}
