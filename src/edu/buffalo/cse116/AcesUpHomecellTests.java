package edu.buffalo.cse116;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class AcesUpHomecellTests {

	Card ace = new Card(Suit.CLUBS, Rank.ACE);
	Card spades = new Card(Suit.SPADES, Rank.EIGHT);
	Card clubs = new Card(Suit.CLUBS, Rank.SEVEN);
	ArrayList<Card> testCards = new ArrayList<Card>();
	BakersDozen test = new BakersDozen();
	
	AcesUp auTest = new AcesUp(); //to be changed
	
	@Test
	public void testEmptyHCPile() {
		auTest.initialSetup();
		assertEquals("Homecell pile should initiate with zero cards", 0, auTest.getHomecellPiles_List().get(0));
	}
	
	@Test
	public void testAddSpecificCardLegalOrIllegalHCPile() {
		auTest.initialSetup();
		
		assertTrue("Should always be true", auTest.addto("homecell", 0, 0));
		
	}
	
	@Test
	public void testRemovingTopCardAlwaysIllegalHCPile() {
		
		auTest.initialSetup();

		assertFalse("Should always be false", auTest.removeFrom("homecell", 0));
	}
	
	@Test
	public void testAddingCardIncreasesSizeAndTopCardHCPile() {
		
		auTest.initialSetup();

		Card first = new Card(Suit.DIAMONDS, Rank.ACE);
		Card second = new Card(Suit.DIAMONDS, Rank.TWO);
		auTest.addToHomecell(first, 0);
		auTest.addToHomecell(second, 0);
		assertEquals("new top card", first, auTest.getHomecellPiles_List().get(0).get(0));
		assertEquals("size of pile", 2, auTest.getHomecellPiles_List().get(0).size());

		
	}
	
}
