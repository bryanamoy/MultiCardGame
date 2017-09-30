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

    protected int getTableauPiles() {
        return super.getTableauPiles();
    }


    //get private piles from the super class. Then according to each pile deal the cards by calling getDeck onto a deck arrayList and dealing them out.
    public void initialSetup() {
        ArrayList<Card> deck = new ArrayList<Card>(getDeck());
        ArrayList<Card> freecell_deck = new ArrayList<Card>();
        int pile = 1;
        tableauPiles_List = new HashMap<Integer, ArrayList<Card>>();      
        
        while(pile <= getTableauPiles()){
            for(int cardNum = 0; cardNum < 12; cardNum++) {
                if(pile <=  getTableauPiles() / 2) {                    
                    freecell_deck.add(deck.get(cardNum)); 
                    if(freecell_deck.size() ==  7) {    
                        tableauPiles_List.put(pile,freecell_deck);
                        System.out.println("The first 4 tab piles will have 7 cards " + pile + " " + freecell_deck);                    
                    }   
                } 
                else if(pile > getTableauPiles() &&  cardNum > 6) {
                    freecell_deck.add(deck.get(cardNum));  
                }
            }
            pile++;
        }

        homecellPiles_List = new HashMap<Integer, ArrayList<Card>>();
        freecellPiles_List =  new HashMap<Integer, ArrayList<Card>>();

//        for(int numOfPile = 1; numOfPile <= tableauPiles; numOfPile++) {
//           tableauPiles_List.put(numOfPile, getDeck());
//        }
    }

    public void removeCard() {

    }

    public void addCard() {

    }


}
