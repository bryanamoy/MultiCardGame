package edu.buffalo.cse116;

import java.util.HashMap;
import java.util.ArrayList;

public class Freecell extends Deck {
	//Check to see if duplicating cards. Make a process to stop adding an already existing card or repeated deletion of the same card.
	//If you delete a card, where does it go? If you add a card where does it go?
	//Idea to solve both problems: Make freecell_deck track what cards get added and removed!
	private HashMap<Integer, ArrayList<Card>> tableauMap;
	private HashMap<Integer, ArrayList<Card>> homecellMap;

	public HashMap<Integer, ArrayList<Card>> getTableauMap() {
		return this.tableauMap;
	}

	public HashMap<Integer, ArrayList<Card>> getHomecellMap() {
		return this.homecellMap;
	}

	public HashMap<Integer, ArrayList<Card>> getFreecellMap() {
		return this.freecellMap;
	}


	private HashMap<Integer, ArrayList<Card>> freecellMap;

	private ArrayList<Card> freecell_deck;   //The deck to fill
	private ArrayList<Card> deck;   //The normal 52 deck

	private boolean initial = true;

	/**
        Make the freecell constructor get take the private fields and set them equal
	 */
	public Freecell(int tableauPiles, int homecellPiles, int freecellPiles) {
		super(tableauPiles, homecellPiles, freecellPiles);
	}

	public ArrayList<Card> getDeck() {
		return super.getDeck();
	}

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


	//HashMap pile number, cards within each pile
	//pile number -> the pile # does not change
	//ArrayList cards

	public boolean removeCard(String whichPile, int whichNumber) { 
        int indexOfTopCard; 
		String stringToCompare = "tableau";
		boolean compare = stringToCompare.equalsIgnoreCase(whichPile);
		if(compare == true) { 
			for(Integer key : this.tableauMap.keySet()) {
				if(whichNumber == key) {
					deck = new ArrayList<Card>();					
					if(deck.size() > 0) {
						indexOfTopCard = deck.size() - 1;
						deck.remove(indexOfTopCard);                                        //If put doesnt work use this
						this.tableauMap.put(key, deck);                                     //this.tableauMap.replace(key,this.tableauMap.get(key), deck);
						deck.clear();
						return true;
					}                      
					else {
						System.out.println("Can't remove anymore cards!");
						return false;
					}
				}
			}
		}

		stringToCompare = "homecell";
        compare = stringToCompare.equalsIgnoreCase(whichPile);
		if(compare == true) {
			System.out.println("Cards cannot be removed from a homecell Pile!");
			return false;
		}
		stringToCompare = "freecell";
        compare = stringToCompare.equalsIgnoreCase(whichPile);
		if(compare = true) {   
			for(Integer key : this.freecellMap.keySet()) {
				if(whichNumber == key) {              
					deck = new ArrayList<Card>();                 
					if(deck.size() > 0) {
						indexOfTopCard = deck.size() - 1;    
						deck.remove(indexOfTopCard);                                        
						this.freecellMap.put(key, deck);                                     
						deck.clear();
						return true;
					}                                        
					else {
						System.out.println("Can't remove anymore cards!");
						return false;
					}
				}                                        
			}   
		}
		return false;
	}


	public boolean addCard(Card card, String whichPile, int whichNumber) {
		//A card can be added to a tableau pile when its value is one less than the tableau's top card AND its suit is the opposite of the top card's suit.
		//The added card becomes the tableau's new top card. ANY card CAN be added to an empty tableau.
        deck = new ArrayList<Card>();
        int rank = card.getRank().getRank();
        int suit = card.getSuit().getSuit();
        
        int pile = 1;
        int size = this.tableauMap.get(pile).size() -1 ;
//        while(pile != getTableauPiles()) {
//            for(int i =0; i <= size; i++) {
//                if(pile <= getTableauPiles()) {
//                    if(this.tableauMap.get(pile).get(i).equals(card)) {
//                        System.out.println("Cant add a card that is already in the pile!");
//                        return false;
//                    }
//                }        
//            }
//            pile++;
//        }

        String stringToCompare = "tableau";
		boolean compare = stringToCompare.equalsIgnoreCase(whichPile);
		if(compare == true) {
            int topCard = this.tableauMap.get(whichNumber).size() - 1;
            if(rank > this.tableauMap.get(whichNumber).get(topCard).getRank().getRank()) {
	            return false;
		    } 
            else if(suit % 2 == 0 && this.tableauMap.get(whichNumber).get(topCard).getSuit().getSuit() % 2 == 0) {
                return false;
            } else {
                deck = new ArrayList<Card>(this.tableauMap.get(whichNumber));   
                deck.add(card);
                this.tableauMap.put(whichNumber, deck);
                deck.clear(); 
                return true;
            }
        }
//        A card can be added to a homecell pile if it has the identical suit and a value one more than the homecell's 
//        top card. For example, the Queen of Spades can only be added to a homecell with the Jack of Spades as its top card. 
//        The added card becomes the homecell's new top card. Only the Aces can be added to an empty homecell.

        pile = 1;
        size = this.homecellMap.get(pile).size() - 1;
//        while(pile != getHomecellPiles()) {
//            for(int i =0; i <= size; i++) {
//                if(pile <= getHomecellPiles()) {
//                    if(this.homecellMap.get(pile).get(i).equals(card)) {
//                        System.out.println("Cant add a card that is already in the pile!");
//                        return false;
//                    }
//                }
//            }
//            pile++;
//        }

        stringToCompare = "homecell";
        compare = stringToCompare.equalsIgnoreCase(whichPile);
        if(compare == true) {
            int topCard = this.tableauMap.get(whichNumber).size() - 1;
            if(this.homecellMap.get(whichNumber).get(topCard).getSuit().getSuit() == suit) {
                if(this.homecellMap.get(whichNumber).get(topCard).getRank().getRank() + 1 == rank) {
                deck = new ArrayList<Card>(this.homecellMap.get(whichNumber));   
                deck.add(card);
                this.homecellMap.put(whichNumber, deck);
                deck.clear(); 

                     return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        pile = 1;
        size = this.freecellMap.get(pile).size() - 1;
//        while(pile != getFreecellPiles()) {
//            for(int i =0; i <= size; i++) {
//                if(pile <= getFreecellPiles()) {
//                    if(this.freecellMap.get(pile).get(i).equals(card)) {
//                        System.out.println("Cant add a card that is already in the pile!");
//                        return false;
//                    }
//                }
//            }
//            pile++;
//        }

        stringToCompare = "freecell";
        compare = stringToCompare.equalsIgnoreCase(whichPile);
        //Any card can be added to an EMPTY freecell pile. A card cannot be added to a freecell pile that already has a card.
        if(compare == true) {
            if(this.freecellMap.isEmpty()) {
                deck = new ArrayList<Card>(this.freecellMap.get(whichNumber));
                deck.add(card);
                this.freecellMap.put(whichNumber, deck);
                deck.clear();
                return true;
            } else {
                System.out.println("Pile already contains card!");
                return false;
            }
        }
        return false;
	}
}
