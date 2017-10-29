/**
 * <h1>Baker's Dozen game Superclass</h1>
 * <p>
 * @author Jonathan Hercules
 * @version 3.0
 * @since 2017-10-02
 * 
 */

package edu.buffalo.cse116;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BakersDozen extends Solitaire{
	/**
	 * Initial setup 
	 * @param sizeOfTableau
	 * @param tableauPiles_List
	 * @param homecellPiles_List
	 * @param freecellPiles_List
	 * @param deck
	 */
	
    int sizeOfTableau; // Number of tableau piles
    private HashMap<Integer, ArrayList<Card>> tableauPiles_List;	// Storage for tableau piles
    private HashMap<Integer, ArrayList<Card>> homecellPiles_List;	// Storage for homecell piles
    private HashMap<Integer, ArrayList<Card>> freecellPiles_List;	// Storage for freecell piles (Never used)
    
    private ArrayList<Card> deck;
    
    /**
     * Defines Superclass
     */
    
	public BakersDozen() {
		super(13, 4, 0);
		
	}
	
	/**
	 * 	A getter for the tableau hashmap
	 * @return tableauPiles_List
	 */
	
	public HashMap<Integer, ArrayList<Card>> getTableauPiles_List() {
		return tableauPiles_List;
	}

	/**
	 * 	A setter for the tableau hashmap
	 */
	
	public void setTableauPiles_List(HashMap<Integer, ArrayList<Card>> tableauPiles_List) {
		this.tableauPiles_List = tableauPiles_List;
	}
	
	/**
	 * 	A getter for the homecell hashmap
	 * @return homecellPiles_List
	 */

	public HashMap<Integer, ArrayList<Card>> getHomecellPiles_List() {
		return homecellPiles_List;
	}

	/**
	 * 	A setter for the homecell hashmap
	 */
	
	public void setHomecellPiles_List(HashMap<Integer, ArrayList<Card>> homecellPiles_List) {
		this.homecellPiles_List = homecellPiles_List;
	}
	
	/**
	 * 	A getter for the freecell hashmap
	 * @return freecellPiles_List
	 */

	public HashMap<Integer, ArrayList<Card>> getFreecellPiles_List() {
		return freecellPiles_List;
	}

	/**
	 * 	A setter for the freecell hashmap
	 */
	
	public void setFreecellPiles_List(HashMap<Integer, ArrayList<Card>> freecellPiles_List) {
		this.freecellPiles_List = freecellPiles_List;
	}
	
	/**
	 * Initial setup: When the game begins each tableau pile should 
	 * be dealt 4 cards and each homecell piles should be empty. 
	 * After dealing is completed, any Kings should 
	 * be moved to the bottom of their tableau. 
	 * 
	 */
	protected void initialSetup() {
		
		tableauPiles_List = new HashMap<Integer,ArrayList<Card>>();
		ArrayList<Card> deck = new ArrayList<Card>(getDeck());
	
		shuffleDeck();
		Rank king = Rank.KING;
		
	   	int cursor = 52;
		
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
				
				if(Pile.get(x).getRank() == Rank.KING){
					Card replace = Pile.get(x);
					Card back = Pile.get(0);
					Pile.set(0, replace);
					Pile.set(x, back);
				}
			}
			
		}
		
		homecellPiles_List = new HashMap<Integer, ArrayList<Card>>();
		for(int h =0;h<4;h++){
			ArrayList<Card> put = new ArrayList<Card>();
			homecellPiles_List.put(h,put);
		}
	
	}

	/**
	 * This method is used for tableau piles. The card that is currently at the top of the tableau pile can be removed. 
	 * Once a card is removed, the card following it in the pile becomes the top card and can be removed.
	 * 
	 * @param c	Represents a card that the user wants to remove
	 * @param Pile	Represents the pile that user wants to remove from
	 * @return		If the user was able to remove card, returns true, if not false.
	 */
	public boolean removeCard(Card c, int Pile) {
		int sizeofPile = tableauPiles_List.get(Pile).size() - 1;
		Card top = tableauPiles_List.get(Pile).get(sizeofPile);

		if (c.equals(top)) {
			tableauPiles_List.get(Pile).remove(top);
			return true;

		} else {
			return false;
		}

	}
	
	/**
	 * A card can be added to a tableau pile when its value is one less than 
	 * the tableau's top card (suits do not matter). However, can't add card if
	 * tableau pile is empty.
	 * 
	 * @param add	Represents the card that the user wants to add
	 * @param Pile	Represents the pile that the user wants to add the card to
	 * @return		Returns true if card was added, if not return false.
	 */
	public boolean addCard(Card add, int Pile) {
		
		Rank check = add.getRank();
		ArrayList<Card> PileCards = new ArrayList<Card>(tableauPiles_List.get(Pile));
		int sizeofPile = PileCards.size();

		if (sizeofPile == 0) {
			return false;
		} else if (PileCards.get(sizeofPile - 1).getRank().ordinal() == check.ordinal() + 1) {

			tableauPiles_List.get(Pile).add(add);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * A card can be added to a homecell pile if it has the identical suit 
	 * and a value one more than the homecell's top card. Only Aces can be 
	 * added to a empty homecell pile
	 * 
	 * @param card	Represents the card that the user wants to add to a homecell pile
	 * @param Pile	Represents the homecell pile that the user wants to add to
	 * @return		Returns true if a card is added, if not returns false
	 */
	public boolean addToHomecell(Card card, int Pile) {
		ArrayList<Card> this_card = new ArrayList<Card>();
		int sizeofPile = getHomecellPiles_List().get(Pile).size();
		Card top;

		int i = 0;
		if (homecellPiles_List.get(Pile).size() == 0 && card.getRank() == Rank.ACE) {
			this_card.add(card);
			homecellPiles_List.put(Pile, this_card);
			return true;
		}

		else {
			top = homecellPiles_List.get(Pile).get(sizeofPile - 1);
			;
			if (card.getSuit() == top.getSuit() && card.getRank().ordinal() == top.getRank().ordinal() + 1) {
				while (i < sizeofPile) {
					this_card.add(homecellPiles_List.get(Pile).get(i));
					this_card.add(card);
					i++;
				}
				homecellPiles_List.put(Pile, this_card);
				return true;
			}
		}

		return false;

	}
	/**
	 * @return	 If user tries to remove from Homecell, this method returns false.
	 */
	public boolean removeFromHomecell(){
		
		return false;
	}
	/**
	 * @return	Gives back the number of tableau piles
	 */
	public int getTableauSize(){
		
		return sizeOfTableau;
	}
	/**
	 * 	Used for testing empty tableau files 
	 */
	public void resetTableau(){
		for(Integer i : tableauPiles_List.keySet()){
			for(int x =0;x<tableauPiles_List.get(i).size();x++){
					tableauPiles_List.get(i).clear();;
					
			}
		}
	}
	
	/**
	 * @param Pile	Represents the pile that user wants to access from homecell
	 * @return	Returns the number of cards in the given homecell pile
	 */
	public int getHomecellPileSize(int Pile){
		int size = 0;
		for(int x =0;x<4;x++){
			if(x == Pile){
				size =getHomecellPiles_List().get(x).size();
			}
		}
		return size;
		
	}
	/**
	 * @param Pile	Represents the pile that user wants to access from tableau
	 * @return	Returns the number of cards in the given tableau pile
	 */
	public int getTableauPileSize(int Pile){
		int size = 0;
		for(int x =0;x<13;x++){
			if(x == Pile){
				size = getTableauPiles_List().get(x).size();
			}
		}
		return size;
		
	}
	
	


	
}
