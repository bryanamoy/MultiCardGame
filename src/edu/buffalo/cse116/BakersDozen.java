package edu.buffalo.cse116;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BakersDozen extends Deck{
	int sizeOfTableau;
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

	@Override
	protected void initialSetup() {
		//Creates deck with getDeck method
		tableauPiles_List = new HashMap<Integer,ArrayList<Card>>();
		ArrayList<Card> deck = new ArrayList<Card>(getDeck());
		shuffleDeck(deck);
		// Makes arraylist of cards 
		Rank king = Rank.KING;
	   int cursor = 52;
		// Runs through 13 times for 13 piles
		for(int i =0;i<13;i++){
	
				if(cursor % 4 == 0 ){
						ArrayList<Card> cards = new ArrayList<Card>( deck.subList(cursor-4, cursor));
						tableauPiles_List.put(i, cards);
					}
					cursor-=4;
					sizeOfTableau++;
		}
		
		for(Integer i: tableauPiles_List.keySet()){
			ArrayList<Card> Pile = tableauPiles_List.get(i);
			for(int x =0;x<4;x++){
				if(Pile.get(x).getRank() == king){
					Card replace = tableauPiles_List.get(i).get(x);
					tableauPiles_List.get(i).set(3, replace);
				}
			}
		}
		
		homecellPiles_List = new HashMap<Integer, ArrayList<Card>>();
		for(int h =0;h<4;h++){
			ArrayList<Card> put = new ArrayList<Card>();
			homecellPiles_List.put(h,put);
		}
	
	}

	

	@Override
	protected boolean removeCard(Card c,int Pile) {
		Card top = tableauPiles_List.get(Pile).get(0);
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
