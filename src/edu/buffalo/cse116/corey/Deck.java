package edu.buffalo.cse116;

import java.util.HashMap;

/**
* <h1>Deck class</h1> 
* Defines Deck class which has 52 Card instances.
* <p>
* @author Corey Almonte 
* @version 1.0
* @since   2017-09-27
*/
public class Deck extends Card {
  private Suite suite;
  private Rank rank;
  private Card card;  

  private HashMap<Suite, Rank> deck;

  public Deck() {
    this.deck = new HashMap<Suite, Rank>();
    for(int i = 1; i <= 4; i++) {
      for(int j = 1; j <= 13; j++) {
        suite = suite.values()[i];
        rank = rank.values()[j];
        card = new Card(suite, rank);    //{@code} This part is interesting. s.values() loops through s. s.values()[i]. It
        this.deck.add(card); 
      }
    }
  }

/**






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
}












































