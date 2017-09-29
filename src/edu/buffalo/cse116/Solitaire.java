package edu.buffalo.cse116;

import java.util.Random;

public class Solitaire {
	
	private String face; 
	private int suit;
	private int value;
	
	private Solitaire[][] cards = new Solitaire[4][13];
	private Solitaire[] deck = new Solitaire[52];
	
	private int deckSize;
	
	
	public Solitaire(int suit, int value){
		
		this.suit = suit;
		this.value = value;
	}

	public int getSuit(){
		return suit;
	}
	
	public int getValue(){
		return value;
	}
	
public void Deck(){
		
		for(int suit=0; suit<4; suit++){
			for(int value=0; value<13; value++){
				cards[suit][value]= new Solitaire(suit+1, value+1);
				deck[suit*13+value] = cards[suit][value];
			}
		}
		deckSize=52;
		
		
}
		
	private void shuffleDeck(){
		Random x = new Random();
		int swap;
		Solitaire tempSpot;
	for(int i=0; i<deckSize; i++){
		swap = x.nextInt(deckSize);
		tempSpot = deck[swap];
		deck[swap] = deck[i];
		deck[i] = tempSpot;
	}
}
	

}
