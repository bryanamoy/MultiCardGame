package edu.buffalo.cse116;

import java.util.HashMap;
import java.util.ArrayList;

public class Freecell extends Deck {
	/**
    *   Hashmap for tableau piles. Contains the pile number and the cards of each pile.
    */
	private HashMap<Integer, ArrayList<Card>> tableauMap;
    /**
    *   Hashmap for homecell piles. Contains the pile number and the cards of each pile.
    */
	private HashMap<Integer, ArrayList<Card>> homecellMap;
    /**
    *   Hashmap for freecell piles. Contains the pile number and the cards of each pile.
    */
	private HashMap<Integer, ArrayList<Card>> freecellMap;
    /**
    *   Getter for the tableau hashmap.
    */
	public HashMap<Integer, ArrayList<Card>> getTableauMap() {
		return this.tableauMap;
	}
    /**
    *   Getter for the homecell hashmap.
    */
	public HashMap<Integer, ArrayList<Card>> getHomecellMap() {
		return this.homecellMap;
	}
    /**
    *   Getter for the freecell hashmap.
    */
	public HashMap<Integer, ArrayList<Card>> getFreecellMap() {
		return this.freecellMap;
	}
    /**
    *   The arraylist freecell_deck used as a buffer.
    */
	private ArrayList<Card> freecell_deck;
    /**
    *   The arraylist deck used as an already filled deck.
    */
	private ArrayList<Card> deck;   


	/**
     *Make the freecell constructor get take the private fields and set them equal
     *
	 */
	public Freecell(int tableauPiles, int homecellPiles, int freecellPiles) {
		super(tableauPiles, homecellPiles, freecellPiles);
	}
    
    /**
    *   Returns the deck  
    */
	public ArrayList<Card> getDeck() {
		return super.getDeck();
	}
    /**
    *   Returns the number of tableau piles
    */
	public int getTableauPiles() {
		return super.getTableauPiles();
	}

	public int getHomecellPiles() {
		return super.getHomecellPiles();
	}

	public int getFreecellPiles() {
		return super.getFreecellPiles();
	}

	public void initialSetup() {
		deck = new ArrayList<Card>(getDeck());
		freecell_deck = new ArrayList<Card>(); //Result is that all of the cards in all piles are in this deck       

		this.tableauMap = new HashMap<Integer, ArrayList<Card>>();       
		this.freecellMap =  new HashMap<Integer, ArrayList<Card>>();
		this.homecellMap = new HashMap<Integer, ArrayList<Card>>();
		
		for(int pile = 1; pile < getFreecellPiles() && pile < getHomecellPiles(); pile++) {
		freecellMap.put(pile, freecell_deck);
		homecellMap.put(pile, freecell_deck);
		}
		
		int x = 7;
		int j = 6;
		int pile = 1;
		for(int i = 0; i < getTableauPiles(); i++) {
			if(i < 4) {
				freecell_deck = new ArrayList<Card>(deck.subList(x-7, x ));
				tableauMap.put(i + 1, freecell_deck);
				pile++;
			}
			else {
				freecell_deck = new ArrayList<Card>(deck.subList(j-6, j ));
				tableauMap.put(i + 1, freecell_deck);	
			}
			x+=7;
			j+=6;
		}
	}	


	

	public boolean removeCard(String whichPile, int whichNumber) { 
        int indexOfTopCard; 
		String stringToCompare = "tableau";
		boolean compare = stringToCompare.equalsIgnoreCase(whichPile);
		if(compare == true) { 
			for(Integer key : this.tableauMap.keySet()) {
				if(whichNumber == key) {
					deck = new ArrayList<Card>(this.getTableauMap().get(whichNumber));					
					if(deck.size() > 0) {
						indexOfTopCard = deck.size() - 1;
						deck.remove(indexOfTopCard);                                        //If put doesnt work use this
						this.tableauMap.put(key, deck);                                     //this.tableauMap.replace(key,this.tableauMap.get(key), deck);
						deck.clear();
						return true;
					}                      
					else {
						//System.out.println("Can't remove anymore cards!");
						return false;
					}
				}
			}
		}

		stringToCompare = "homecell";
        compare = stringToCompare.equalsIgnoreCase(whichPile);
		if(compare == true) {
			//System.out.println("Cards cannot be removed from a homecell Pile!");
			return false;
		}
		stringToCompare = "freecell";
        compare = stringToCompare.equalsIgnoreCase(whichPile);
		if(compare = true) {   
			for(Integer key : this.freecellMap.keySet()) {
				if(whichNumber == key) {              
					deck = new ArrayList<Card>(this.freecellMap.get(whichNumber));                 
					if(deck.size() > 0) {
						indexOfTopCard = deck.size() - 1;    
						deck.remove(indexOfTopCard);                                        
						this.freecellMap.put(key, deck);                                     
						deck.clear();
						return true;
					}                                        
					else {
						
						return false;
					}
				}                                        
			}   
		}
		return false;
	}


	public boolean addCard(Card theCard, String whichPile, int whichNumber) {
		//A card can be added to a tableau pile when its value is one less than the tableau's top card AND its suit is the opposite of the top card's suit.
		//The added card becomes the tableau's new top card. ANY card CAN be added to an empty tableau.
        deck = new ArrayList<Card>();
        int rank = theCard.getRank().ordinal();
        int suit = theCard.getSuit().ordinal();


        String stringToCompare = "tableau";
		boolean compare = stringToCompare.equalsIgnoreCase(whichPile);
		
		if(compare == true) {
       	 	deck = new ArrayList<Card>(this.tableauMap.get(whichNumber));   
            if(deck.isEmpty()) {
                 deck.add(theCard);
                 this.tableauMap.put(whichNumber, deck);
                 return true;
            }
            else{
            	int topCard = deck.size() - 1;
            	if(rank > deck.get(topCard).getRank().ordinal()) {
            		
            		return false;
            	} 
            	else if(suit % 2 == 0 && deck.get(topCard).getSuit().ordinal() % 2 == 0) {
            		
            		return false;
            	} 	
            	else{            	
                deck.add(theCard);             
                this.tableauMap.put(whichNumber, deck);
                return true;
            	}
            }
        }


		stringToCompare = "homecell";
		compare = stringToCompare.equalsIgnoreCase(whichPile);
		if(compare == true) {
			deck = new ArrayList<Card>(this.homecellMap.get(whichNumber)); 
			
			if(this.homecellMap.get(whichNumber).size() > 0) {
				int topCard = this.homecellMap.get(whichNumber).size() -1;
				if(this.homecellMap.get(whichNumber).get(topCard).getSuit().ordinal() == suit) {
					if(this.homecellMap.get(whichNumber).get(topCard).getRank().ordinal() + 1 == rank) { 
						
						deck.add(theCard);
						
						this.homecellMap.put(whichNumber, this.deck);
						System.out.println(this.homecellMap.get(whichNumber));
						return true;                 
					}
				}else {
					
					return false;
				}
			} 
			else if(theCard.getRank() == Rank.ACE) {
				deck.add(theCard);
				this.homecellMap.put(whichNumber, deck);
				return true;  
			} else {
				return false;
			}

		}



        stringToCompare = "freecell";
        compare = stringToCompare.equals(whichPile);
        //Any card can be added to an EMPTY freecell pile. A card cannot be added to a freecell pile that already has a card.
        ArrayList<Card> cards1 = new ArrayList<Card>(this.freecellMap.get(whichNumber));
        if(compare == true && this.freecellMap.size() ==0) {
                cards1.add(theCard);
                freecellMap.put(whichNumber, cards1);
                return true;
        }
        	deck.clear();
        	return false;
	}
}

