package edu.buffalo.cse116;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import edu.buffalo.cse116.Card;
import edu.buffalo.cse116.Freecell;
import edu.buffalo.cse116.Rank;
import edu.buffalo.cse116.Suit;

public class HomecellPilesTest {
/*
 * This Test case checks the initial homecell pile in freecell.  The initial size of the 
 * homecell pile should equal to zero..
 */
	
	@Test
	public void testfreecellInitial() {
		Freecell initialFC = new Freecell(8,4,4);
		initialFC.initialSetup();
		assertEquals("Empty",0, initialFC.getHomecellMap().get(1).size());
	}
	/*
	 * This Test case checks the intial homecell pile in baker's dozen game.  The initial size of
	 * the homecell pile should equal zero.
	 */
	@Test 
	public void bakersdozenInitial(){
		BakersDozen initialBD = new BakersDozen();
		initialBD.initialSetup();
		assertEquals(0, initialBD.getHomecellPileSize(1));
//		Homecell intialsetupBD = new Homecell.intial();
//		assertEquals(0, intialsetupBD, 0.1);
		
	}
	/*
	 * This Test case checks if adding to an empty homecell pile in freecell is legal when the
	 * pile is empty.  The card should only be able to be added when the pile is empty if the card is an ace.
	 * If the card is not an ace and the pile is empty, then it should be illegal.
	 */
	@Test
	public void homecelladdFC(){
		Freecell addFC = new Freecell(8,4,4);
		addFC.initialSetup();
		Card first = new Card(Suit.DIAMONDS, Rank.ACE);
		Card second = new Card(Suit.SPADES, Rank.EIGHT);
		
		
		assertTrue("legal", addFC.addCard(first, "Homecell", 1));
		assertFalse("illegal", addFC.addCard(second, "Homecell", 1));
	}
	/*
	 * This Test case checks if adding to an empty homecell pile in baker's dozen is legal.  If the homecell pile is 
	 * empty the only cards that can be added is an ace.  If it is a card higher than rank 1 then it cannot be added
	 * to the pile.
	 */
	@Test 
	public void homecelladdBD(){
		BakersDozen addBD = new BakersDozen();
		addBD.initialSetup();
		Card first = new Card(Suit.DIAMONDS, Rank.ACE);
		Card second = new Card(Suit.SPADES, Rank.EIGHT);
		
		assertTrue("legal", addBD.addToHomecell(first, 1));
		assertFalse("illegal", addBD.addToHomecell(second, 1));
	}
	/*
	 * This test case checks if removing a card from the homecell pile in freecell is legal.
	 * In freecell you cannot remove a card from the homecell pile, so it is illegal.
	 */
	@Test
	public void homecellremoveFC(){
		Freecell removeFC = new Freecell(8,4,4);
		assertFalse("illegal", removeFC.removeCard("Homecell", 1));
		
	}
	/*
	 * This test case checks if removing a card from the homecell pile in baker's dozen is legal.
	 * It is illegal to remove a card from the pile thus it should be false if removing is tried.
	 */
	@Test
	public void homecellremoveBD(){
		BakersDozen removeBD = new BakersDozen();
		assertFalse("illegal", removeBD.removeFromHomecell());
}
	/*
	 * This test case checks the function of adding cards on top of each other in freecell game.  The card added to the pile
	 * will be the new top card.  Essentially, the card top card number ranking should be equivalent to the 
	 * number of elements in the pile (size()).
	 */
	@Test
	public void homecelltopFC(){
		//Can be added if identical suit and one more than homecell top card
		Freecell topFC = new Freecell(8,4,4);
		topFC.initialSetup();
		
		Card cardInDeck= new Card(Suit.DIAMONDS, Rank.ACE);
		Card cardToAdd = new Card(Suit.DIAMONDS, Rank.TWO); 
		ArrayList<Card> test = new ArrayList<Card>();
		test.add(cardInDeck);
		topFC.getHomecellMap().put(1, test);
		
		assertTrue(topFC.addCard(cardToAdd,"hOMECELL",1)); //able to add
		int indexOfTopCard = topFC.getHomecellMap().get(1).size() - 1;
		assertEquals("Updates the top card", cardToAdd, topFC.getHomecellMap().get(1).get(indexOfTopCard));								//Is pile's top card		
		assertEquals("Increases number of cards", 2, topFC.getHomecellMap().get(1).size()); 
	}
	/*
	 * This test case checks the function of adding cards on top of each other in baker's dozen game.
	 * In this test I created 2 cards of chronological order to see if the top card is the last card added.
	 * 
	 */
	@Test
	public void homecelltopBD(){
		BakersDozen topBD = new BakersDozen();
		topBD.initialSetup();
		Card first = new Card(Suit.DIAMONDS, Rank.ACE);
		Card second = new Card(Suit.DIAMONDS, Rank.TWO);
		topBD.addToHomecell(first, 3);
		topBD.addToHomecell(second, 3);
		assertEquals("new top card", topBD.getHomecellPiles_List().get(3).get(1), second);
		assertEquals("size of pile", topBD.getHomecellPiles_List().get(3).size(), 2);
		
		
	}
}
