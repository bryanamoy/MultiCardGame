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
 * Make it so that can get and set both instances for suite and rank.
 */

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }


    public Suit getSuit() {
        return this.suit;
    }

    public Rank getRank() {
        return this.rank;
    }
     @Override
    	public String toString() {
    		// TODO Auto-generated method stub
    		return getSuit() + " of " + getRank();
    	}
}
