package edu.buffalo.cse116;

/**
* <h1>Rank</h1>
* Is an enum representing the values of
* a card. 
* <p>
* <b>Note:</b> This is to be combined with the Suit enum to form
* the card class.
*
* @author  Corey Almonte
* @version 1.5
* @since   2017-09-29
*/
public enum Rank {
    /**
    *Enumeration of card ranks
    */
    ACE(1), TWO(2), THREE(3), FOUR(4), 
    FIVE(5), SIX(6), SEVEN(7), EIGHT(8), 
    NINE(9), TEN(10), JACK(11), QUEEN(12),
    KING(13);  
  
    /**
    * The value of each enum value.
    */
    private int rank;
     
    /**
    *Gives back the rank of the enum
    *@param rank    Sets enum equal to the parameter rank.
    */
    Rank(int rank) {
      this.rank = rank;
    }
    /**
    *   The Getter  for the rank enum.
    */
    public int getRank() {
      return rank;
    }
    /**
    *   Overrides the toString method to get cards to print as strings.
    */
    @Override
    public String toString() {
        return getSuit() + " of " + getRank();
    }
}        

