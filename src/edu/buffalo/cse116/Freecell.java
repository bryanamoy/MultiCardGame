package edu.buffalo.cse116;

import java.util.Collections;
import java.util.ArrayList;


public class Freecell extends Deck {
    private int tableauPiles;
    private int homecellPiles;
    private int freecellPiles;

    /**
        Make the freecell constructor get take the private fields and set them equal

   */
    public Freecell(int tp, int hp, int fp) {
        super();
        tableauPiles = tp;
        homecellPiles = hp;
        freecellPiles = fp;
    }
    public ArrayList<Card> getDeck() {
        return super.getDeck();
    }

    




    public void initialSetup() {
    
    }

    public void removeCard() {

    }

    public void addCard() {

    }


}
