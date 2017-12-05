package edu.buffalo.cse116;

/**
* <h1>Card Class<h1>
* Each Card instance is a combination of suite & rank.
* <p>
* @author Corey Almonte
* @version 0.5
* @since 2017-09-27
*/
public class Card {
    /**
    *An instance variable from the Suit enum.
    */
    private Suit suit;

    /**
    *An instance variable from the Rank enum.
    */
    private Rank rank;

    /**
    *Initializes Card with suit and rank
    *@param
    */
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
    *   The getter for the suit 
    */
    public Suit getSuit() {
        return this.suit;
    }
    /**
    *   The getter for the rank
    */
    public Rank getRank() {
        return this.rank;
    }
    
    
    public String getImageFileName() {
		return ("" + this.getSuit()) + ("" + this.getRank());
	}
    /**
    *   Overrides the toString method
    */
     @Override
    	public String toString() {
    		// TODO Auto-generated method stub
    		return getSuit() + " of " + getRank();
    	}
}
