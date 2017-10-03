package edu.buffalo.cse116;
/**
* <h1>Suit Enum</h1>
* Is an enum representing the suit of a card. 
* <p>
* <b>Note:</b> This is to be combined with the Rank enum to form
* the card class.
*
* @author  Corey Almonte
* @version 1.5
* @since   2017-09-29
*/

public enum Suit {
    /**
    *Enumeration of suit
    */
    CLUBS(1), DIAMONDS(2),
    SPADES(3), HEARTS(4);
    /**
    *   Non-static variable for the suit
    */
    private int suit;
    /**
    *   Constructor for suit class
    *   Initializes suit  to suit
    */
    Suit(int suit) {
      this.suit = suit;
    }
    /**
    *The getter for the suit
    */
    public int getSuit() {
      return suit;
    }
  }
