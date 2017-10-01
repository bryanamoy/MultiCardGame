package edu.buffalo.cse116;

import java.util.Iterator;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;
/**
* <h1>Deck class</h1> 
* Defines Deck class which has 52 Card instances.
* <p>
* @author Corey Almonte 
* @version 1.5
* @since   2017-09-29
*/
public abstract class Deck {

    protected Card card;

    protected int tableauPiles;
    protected int homecellPiles;       
    protected int freecellPiles;

    private ArrayList<Card> deck;
    
    //The Deck() constructor takes an arrayList an already defined and makes a deck. HashMap boi
    public Deck(int tabbleauPiles, int homecellPiles, int freecellPiles) {
        this.tableauPiles = tableauPiles;
        this.homecellPiles = homecellPiles;
        this.freecellPiles = freecellPiles;
        this.deck = new ArrayList<Card>();

        for(Suit suit : Suit.values()) {
            for(Rank rank : Rank.values()) {
                card = new Card(suit, rank); //{@code} This part is interesting. s.values() loops through s. s.values()[i]. It
                this.deck.add(card);
                System.out.println("The cards that are in this deck are " + rank + " of " + suit); 
            }
        }
        shuffleDeck(deck); 
    }

    public void shuffleDeck(ArrayList<Card> deck) { 
        for(int trueRandom = 0; trueRandom < 5; trueRandom++) {
            Collections.shuffle(deck);       
        }
    }
 
    public ArrayList<Card> getDeck() {
        return deck;
    }

    protected int getTableauPiles() {
        return tableauPiles;
    }

    protected int getHomecellPiles() {
        return homecellPiles;
    }

    protected int getFreecellPiles() {
        return freecellPiles;
    }

    protected abstract void initialSetup(HashMap<Integer,ArrayList<Card>> tableauMap, HashMap<Integer,ArrayList<Card>> homecellMap,
        HashMap<Integer,ArrayList<Card>> freecellMap );

    protected abstract void removeCard(HashMap<Integer, ArrayList<Card>> pilesMap, int pileNumber);

    protected abstract void addCard(HashMap<Integer, ArrayList<Card>> pilesMap, int pileNumber);

}































