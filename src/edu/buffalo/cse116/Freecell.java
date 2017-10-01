package edu.buffalo.cse116;

import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;

public class Freecell extends Deck {

    private HashMap<Integer, ArrayList<Card>> tableauPiles_List;
    private HashMap<Integer, ArrayList<Card>> homecellPiles_List;
    private HashMap<Integer, ArrayList<Card>> freecellPiles_List;
    
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
        return getFreecellPiles();
    }


    //get private piles from the super class. Then according to each pile deal the cards by calling getDeck onto a deck arrayList and dealing them out.
    public void initialSetup() {
        final ArrayList<Card> deck = new ArrayList<Card>(getDeck());   //The normal 52 deck
        final ArrayList<Card> freecell_deck = new ArrayList<Card>();   //The arraylist to fill

        tableauPiles_List = new HashMap<Integer, ArrayList<Card>>();       
        freecellPiles_List =  new HashMap<Integer, ArrayList<Card>>();
        homecellPiles_List = new HashMap<Integer, ArrayList<Card>>();

        int trade = 0;
        int pile = 1;
        while(pile <= getTableauPiles() && pile <= getHomecellPiles() && pile <= getFreecellPiles()) {  
            for(int cardNum = 0; cardNum < 12; cardNum++) {
                if(pile <=  (getTableauPiles() / 2) && cardNum <= 6) {                    
                    freecell_deck.add(deck.get(trade)); 
                    deck.remove(trade);
                } else {
                    tableauPiles_List.put(pile, freecell_deck);
                }
                if(cardNum > 6 && pile > (getTableauPiles() / 2)) { 
                    freecell_deck.add(deck.get(cardNum));  
                    deck.remove(trade);
                } else {
                    tableauPiles_List.put(pile, freecell_deck);
                }
            }
            homecellPiles_List.put(pile, deck);
            freecellPiles_List.put(pile, deck);
            pile++;
        }   
    }

    public void removeCard() {

    }

    public void addCard() {

    }


}
