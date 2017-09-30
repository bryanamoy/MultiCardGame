package edu.buffalo.cse116;

import java.util.Iterator;
import java.util.Collections;
import java.util.ArrayList;

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
                shuffleDeck(deck); 
                System.out.println("The shuffled deck is now ordered like this: " + rank + " of " + suit); 
            }
        }
    }

    protected void shuffleDeck(ArrayList<Card> deck) { 
        Collections.shuffle(deck);       
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    protected int getTableauPiles() {
        return tableauPiles;
    }



    protected abstract void initialSetup();

    protected abstract void removeCard();

    protected abstract void addCard();

}



/**


public static void main(String[] args) {


}











  private int homecell_piles;
  private int tableau_piles;    
  private int freecell_piles;

    
  public Deck(int tableau_piles, int homecell_piles, int freecell_piles) {
    this.tableau_piles = tableau_piles;
    this.homecell_piles = homecell_piles;
    this.freecell_piles = freecell_piles;
  }  
  
  public int getTableauPiles() {
    return this.tableau_piles;
  }

  public int getHomecellPiles() {
    return this.homecell_piles;
  }
  public int getFreecellPiles() {
  public int getFreecellPiles() {
    return this.freecell_piles;
    return this.freecell_piles;


 **/ 













































