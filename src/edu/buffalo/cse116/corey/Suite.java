package edu.buffalo.cse116;

public enum Suit {
    CLUBS(1), DIAMONDS(2),
    SPADES(3) HEARTS(4);

    private int suit;

    Suite(int suit) {
      this.suit = suit;
    }

    public int getSuit() {
      return suit;
    }
  }
