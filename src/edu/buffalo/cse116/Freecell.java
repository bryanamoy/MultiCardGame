package edu.buffalo.cse116;

import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;

public class Freecell extends Deck {
    //Check to see if duplicating cards. Make a proccess to stop duplication or repeated deletion of the same card.
    private HashMap<Integer, ArrayList<Card>> tableauMap;
    private HashMap<Integer, ArrayList<Card>> homecellMap;
    private HashMap<Integer, ArrayList<Card>> freecellMap;
    
    static ArrayList<Card> freecell_deck = new ArrayList<Card>();   //The deck to fill
    static ArrayList<Card> deck;   //The normal 52 deck
    
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

    //Change this so that the pilesList can be called from Main class.
    public void initialSetup(HashMap<Integer,ArrayList<Card>> tableauMap, HashMap<Integer,ArrayList<Card>> homecellMap, 
        HashMap<Integer,ArrayList<Card>> freecellMap ) {
         deck = new ArrayList<Card>(getDeck());
        this.tableauMap = new HashMap<Integer, ArrayList<Card>>();       
        this.freecellMap =  new HashMap<Integer, ArrayList<Card>>();
        this.homecellMap = new HashMap<Integer, ArrayList<Card>>();

        int trade = 0;
        int pile = 1;

        while(pile <= getTableauPiles() && pile <= getHomecellPiles() && pile <= getFreecellPiles()) {  
            for(int cardNum = 0; cardNum < 12; cardNum++) {
                if(pile <=  (getTableauPiles() / 2) && cardNum <= 6) {                    
                    freecell_deck.add(deck.get(trade)); 
                    deck.remove(trade);
                } else {
                    this.tableauMap.put(pile, freecell_deck);
                }
                if(cardNum > 6 && pile > (getTableauPiles() / 2)) { 
                    freecell_deck.add(deck.get(trade));  
                    deck.remove(trade);
                } else {
                    this.tableauMap.put(pile, freecell_deck);
                }
            }
            homecellMap.put(pile, deck);
            freecellMap.put(pile, deck);
            pile++;
        }
        tableauMap = this.tableauMap;   
        freecellMap = this.freecellMap;
        homecellMap = this.homecellMap;
    }

    public void removeCard(HashMap<Integer, ArrayList<Card>> pilesMap, int pileNumber) { 
        int indexOfTopCard;
        if(pilesMap == this.tableauMap) {
                for(Integer key : this.tableauMap.keySet()) {
                    if(pileNumber == key) {
                        deck = new ArrayList<Card>(this.tableauMap.get(key));                 //Holy fuck is this some HARD thinking
                        indexOfTopCard = deck.size() - 1;
                        deck.remove(indexOfTopCard);                                        //If put doesnt work use this
                        this.tableauMap.put(key, deck);                                     //this.tableauMap.replace(key,this.tableauMap.get(key), deck);
                        deck.clear();                                     
                    }
                }
        }
        if(pilesMap == freecellMap) {
            System.out.println("Cards cannot be removed from a freecell Pile!");    
        }
                
        if(pilesMap == homecellMap) {
           //Any card within the homecellpile can be removed!   
            for(Integer key : this.homecellMap.keySet()) {
                if(pileNumber == key) {              
                    deck = new ArrayList<Card>(this.homecellMap.get(key));                 
                    indexOfTopCard = deck.size() - 1;    
                    deck.remove(indexOfTopCard);                                        
                    this.homecellMap.put(key, deck);                                     
                    deck.clear();                                        
                }                                        
            }   
        }        
    }

    public void addCard() {

    }
}

