package edu.buffalo.cse116;

public class Solitare {
	
	private String face; 
	private int suit;
	private int value;
	
	private Solitare[][] cards = new Solitare[4][13];
	private Solitare[] deck = new Solitare[52];
	
	private int deckSize;
	
	
	public Solitare(int suit, int value){
		
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
				cards[suit][value]= new Solitare(suit+1, value+1);
				deck[suit*13+value] = cards[suit][value];
			}
		}
		deckSize=52;
		
		// shuffle method will go here
	
	
	
}
}
