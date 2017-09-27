package edu.buffalo.cse116;

public enum Suite {
    CLUBS(1), DIAMONDS(2),
    HEARTS(3), SPADES(4);

    private final int suite;

    Suite(int suite) {
      this.suite = suite;
    }

    public int getSuite() {
      return suite;
    }
  }
