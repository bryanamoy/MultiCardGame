package edu.buffalo.cse116;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class SolitaireController {
	private MainMenu gui;
	private SolitaireView view;
	private BakersDozen bd;
	private Freecell fc;
	private DropShadow shadow = new DropShadow(15, Color.BLACK);
	public SolitaireController(MainMenu gui, SolitaireView view, BakersDozen bd, Freecell fc){
		this.gui = gui;
		this.view = view;
		this.bd = bd;
		this.fc = fc;
		
	}		
	                  
	
	public void selectCard(ImageView image){
		image.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				image.setEffect(shadow);
				
			}
			});
		
	}
	public void unselectCard(ImageView border){
		border.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>(){
		@Override
		public void handle(MouseEvent e){
		border.setEffect(null);
	}
		});
	}

	public void BakersDozenGame(ActionEvent event){
		BakersDozen bd = new BakersDozen(); //create new BakersDozen game
		bd.initialSetup(); //set up bakersdozen game
		view.setCardImages(bd);
	}
	public void FreecellGame(ActionEvent event){
		Freecell fc = new Freecell(8,4,4); //create new freecell game
		fc.initialSetup();	//set up freecell game
		view.setCardImages(fc);
	}
	public void removeHomecell(ActionEvent event){
		bd.removeFromHomecell(); //returns illegal move
		fc.removeCard(whichPile, whichNumber);
	}
		
	public void addCardHC(ActionEvent event){	
		
	if(bd.addToHomecell(card, Pile) == true){ //test if card adding to homecell is legal
		bd.getHomecellPiles_List(); //get top card 
		bd.setHomecellPiles_List(bd.getHomecellPiles_List()); //add card to pile
		view.getImageViewOfCard(c); //update card "c"
	}
	else{
		System.out.println("Card to be added must be one rank up the current top card and identical suit");
	}
	if(fc.addCard(theCard, whichPile, whichNumber) == true){
		view.getImageViewOfCard(c);
	}
	else{
		System.out.println("Card to be added must be one rank up the current top card and identical suit");
	}
	public void addCardT(ActionEvent event){
		if(bd.addCard(add, Pile) == true){
			bd.getTableauPiles_List();
			bd.setTableauPiles_List(bd.getTableauPiles_List());
			view.getImageViewOfCard(c);
		}
		else{
			System.out.println("Card to be added must be one less rank of current top card");
		}
		if(fc.addCard(theCard, whichPile, whichNumber) == true){
			fc.getTableauMap();
			view.getImageViewOfCard(c);
		}
		else{
			System.out.println("Card to be added must be one less rank of current top card and opposite suit");
		}
	}

	public void setTableauPile(HashMap<Integer, ArrayList<Card>> tableauPiles_List){
		bd.setTableauPiles_List(tableauPiles_List);
		
	}
	public void setHomecellPile(HashMap<Integer, ArrayList<Card>> HomcellPiles_List){
		bd.setHomecellPiles_List(HomcellPiles_List);
	}
	
	//EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>();
		
	public void clickCard(ActionEvent event){
		if(bd.addCard(add, Pile) == true){
			bd.getTableauPiles_List();
			//update top card 
		}
	}
	public void ButtonClicked(Image image){
	image.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				view.getImageViewOfCard(c);
				event.getButton();
				bd.getHomecellPiles_List().get(event);
				bd.getTableauPiles_List().get(event);
		}
		});
	}
	
		public void updateSolitaireView(){
		view.getCardImages();
	}



	   
		
		
}
