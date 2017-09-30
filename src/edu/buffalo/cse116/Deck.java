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
    private Card card;
    private suit suit;
    private Rank rank;

    private ArrayList<Card> deck;
    
    //The Deck() constructor takes an arrayList an already defined and makes a deck. HashMap boi
    public Deck() {
        this.deck = new ArrayList<Card>();
        for(suit suit : suit.values()) {
            for(Rank rank : rank.values()) {
                card = new Card(suit, rank); //{@code} This part is interesting. s.values() loops through s. s.values()[i]. It
                this.deck.add(card); 
            }
        }
    }

    void shuffleDeck(ArrayList<Card> deck) { 
        Collections.shuffle(deck);       
    }

    abstract void initialSetup();

    abstract void removeCard();


    abstract void addACard();

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













































