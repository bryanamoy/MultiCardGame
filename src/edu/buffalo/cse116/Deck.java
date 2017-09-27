package edu.buffalo.cse116;

/**
* <h1>Deck class</h1> 
* Defines Deck class which has 52 Card instances.
* <p>
* @author Corey Almonte 
* @version 0.5
* @since   2017-09-27
*/
public class Deck {
  
  public Deck() {

    for (Suite s : Suite.values()){
        for(Rank r : Rank.values()) {
            this[52] = new Deck[s][r];
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












































