package edu.buffalo.cse116;

import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;
/**
* <h1>Deck Class</h1> 
* Defines Deck class which has 52 Card instances.
* <p>
* @author Corey Almonte 
* @version 2.5
* @since   2017-10-1
*/
public abstract class Deck {
    /**
    *Instance of card.
    */
    protected Card card;
    /**
    *Initial number of tableau piles.
    */
    protected int tableauPiles;
    /**
    *Initial number of homecell piles.
    */
    protected int homecellPiles;
    /**
    *Initial number of freecell piles.
    */     
    protected int freecellPiles; 
    /**
    *Arraylist to hold 52 instances of card
    */
    private ArrayList<Card> deck;
    
    /**
    *The constructor for the deck class sets it to number of piles for tableau,homecell, and freecell.
    *Also initializes arraylist of cards to hold 52 cards
    *@param tableauPiles    Number of tableauPiles
    *@param homecellPiles   Number of homecellPiles
    *@param freecellPiles   Number of freecellPiles
    */
    public Deck(int tableauPiles, int homecellPiles, int freecellPiles) {
        this.tableauPiles = tableauPiles;
        this.homecellPiles = homecellPiles;
        this.freecellPiles = freecellPiles;
        this.deck = new ArrayList<Card>();

        for(Suit suit : Suit.values()) {
            for(Rank rank : Rank.values()) {
                card = new Card(suit, rank); //{@code} This part is interesting. s.values()[i] is iterable.
                this.deck.add(card);
                System.out.println("The cards that are in this deck are " + rank + " of " + suit); 
            }
        }
        shuffleDeck(deck); 
    }
    /**
    *Method used to shuffle deck
    *@param ArrayList<Card> deck    Represents the deck after having been shuffled. TRUERANDOM IS TO SHUFFLE 5 TIMES!!!
    */
    public void shuffleDeck(ArrayList<Card> deck) {
        for(int trueRandom = 0; trueRandom < 5; trueRandom++) {
            Collections.shuffle(deck);
        }
    }
    /**
    *Getter for deck of 52 card instances.
    */
    public ArrayList<Card> getDeck() {
        return deck;
    }
    /**
    *Getter for number of tableau Piles
    */
    protected int getTableauPiles() {
        return tableauPiles;
    }
    /**
    * Getter for number of homecell piles
    */
    protected int getHomecellPiles() {
        return homecellPiles;
    }
    /**
    *Getter for number of freecell piles
    */
    protected int getFreecellPiles() {
        return freecellPiles;
    }
    /**
    *   Abstract method for initial setup
    */
    protected abstract void initialSetup();

}

