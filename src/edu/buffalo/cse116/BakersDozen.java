package edu.buffalo.cse116;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BakersDozen extends Deck{
    int sizeOfTableau; // Number of tableau piles
    private HashMap<Integer, ArrayList<Card>> tableauPiles_List;
    private HashMap<Integer, ArrayList<Card>> homecellPiles_List;
    private HashMap<Integer, ArrayList<Card>> freecellPiles_List;
    
	public BakersDozen() {
		super(13, 4, 0);
		// TODO Auto-generated constructor stub
	}
	
	// Getters and Setters
	public HashMap<Integer, ArrayList<Card>> getTableauPiles_List() {
		return tableauPiles_List;
	}

	public void setTableauPiles_List(HashMap<Integer, ArrayList<Card>> tableauPiles_List) {
		this.tableauPiles_List = tableauPiles_List;
	}

	public HashMap<Integer, ArrayList<Card>> getHomecellPiles_List() {
		return homecellPiles_List;
	}

	public void setHomecellPiles_List(HashMap<Integer, ArrayList<Card>> homecellPiles_List) {
		this.homecellPiles_List = homecellPiles_List;
	}

	public HashMap<Integer, ArrayList<Card>> getFreecellPiles_List() {
		return freecellPiles_List;
	}

	public void setFreecellPiles_List(HashMap<Integer, ArrayList<Card>> freecellPiles_List) {
		this.freecellPiles_List = freecellPiles_List;
	}
	/*
	Initial setup
	When the game begins each tableau pile should be dealt 4 cards. After dealing is completed, 
	any Kings should be moved to the bottom of their tableau.
	When the game begins each homecell pile should be empty.
	*/
	
	@Override
	protected void initialSetup() {
		//Creates deck with getDeck method
		tableauPiles_List = new HashMap<Integer,ArrayList<Card>>();
		ArrayList<Card> deck = new ArrayList<Card>(getDeck());
		shuffleDeck(deck);
		// Make a king rank for comparison later
		Rank king = Rank.KING;
		// Cursor for later
	   	int cursor = 52;
		// Runs through 13 times for 13 piles
		for(int i =0;i<13;i++){
				// Condition to allow 4 cards in each pile
				if(cursor % 4 == 0 ){
					// Make arraylist instance of 4 cards each time
					ArrayList<Card> cards = new ArrayList<Card>( deck.subList(cursor-4, cursor));
					// Put in tableau piles
					tableauPiles_List.put(i, cards);
					}
				
				cursor-=4;
				sizeOfTableau++;
		}
		// Function to put king card at the end of each pile
		for(Integer i: tableauPiles_List.keySet()){
			ArrayList<Card> Pile = tableauPiles_List.get(i);
			
			for(int x =0;x<4;x++){
				// Switches king card at the end of each pile
				if(Pile.get(x).getRank() == king){
					Card replace = tableauPiles_List.get(i).get(x);
					tableauPiles_List.get(i).set(3, replace);
				}
			}
		}
		// Defines the homecell piles with 4 empty arraylists
		homecellPiles_List = new HashMap<Integer, ArrayList<Card>>();
		for(int h =0;h<4;h++){
			ArrayList<Card> put = new ArrayList<Card>();
			homecellPiles_List.put(h,put);
		}
	
	}

	/*
	Removing a Card
	Only the card which is currently at the top of the tableau pile can be removed. 
	Once a card is removed, the card following it in the pile becomes the top card and can be removed.
	*/
	@Override
	protected boolean removeCard(Card c,int Pile) {
		// Get the top of the pile given
		Card top = tableauPiles_List.get(Pile).get(0);
			// If card is the top...
			if(c.equals(top)){
					tableauPiles_List.get(Pile).remove(top);
					Card replace = tableauPiles_List.get(Pile).get(1);
					tableauPiles_List.get(Pile).set(0, replace);
			}
			else{
				return false;
			}
				
		return true;
	}
	
	/*	
	Adding a Card
	A card can be added to a tableau pile when its value is one less than the tableau's top card (
	suits do not matter for this). For example, it is legal to move a Queen onto a King, 
	a 6 onto a 7, or an Ace onto a 2, but illegal to move a 4 onto a 6 or a Jack onto a 10. 
	The added card becomes the tableau's new top card. Cards cannot be added to an empty tableau.
	*/
	
	@Override
	protected boolean addCard(Card add,int Pile) {
		// TODO Auto-generated method stub
			Rank check = add.getRank();
			ArrayList<Card> top = tableauPiles_List.get(Pile);
			
			if(tableauPiles_List.get(Pile).size() == 0){
				return false;
			}
			else if(top.get(0).getRank().ordinal() == check.ordinal()+1 ){
						tableauPiles_List.get(Pile).set(0, add);
				return true;
				}
			else{
				return false;
			}
		}
	
	/*
	Adding a Card
	A card can be added to a homecell pile if it has the identical suit and a value one more than the homecell's top card. 
	For example, the Queen of Spades can only be added to a homecell with the Jack of Spades as its top card. 
	The added card becomes the homecell's new top card. Only the Aces can be added to an empty homecell.
	*/
	
	public boolean addToHomecell(Card card, int Pile){
		ArrayList<Card> this_card = new ArrayList<Card>();
		Card top;
		
		if(card.getRank() == Rank.ACE){
			this_card.add(card);
			
			if(homecellPiles_List.get(Pile).size() ==0){
					homecellPiles_List.put(Pile, this_card);
				return true;
			}
			
		}
		else{
			top = homecellPiles_List.get(Pile).get(0);
				if(card.getSuit() == top.getSuit() && card.getRank().ordinal() == top.getRank().ordinal() + 1){
					homecellPiles_List.get(Pile).set(0, card);
					return true;
				}
		}
		
		
		return false;
		
	}
	public boolean removeFromHomecell(){
		
		return false;
	}
	
	public int getTableauSize(){
		
		return sizeOfTableau;
	}
	
	public void resetTableau(){
		for(Integer i : tableauPiles_List.keySet()){
			for(int x =0;x<tableauPiles_List.get(i).size();x++){
					tableauPiles_List.get(i).clear();;
					
			}
		}
	}
	


	
}
