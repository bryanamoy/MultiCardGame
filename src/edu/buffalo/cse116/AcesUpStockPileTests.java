package edu.buffalo.cse116;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

public class AcesUpStockPileTests {

	Card ace = new Card(Suit.CLUBS, Rank.ACE);
	Card spades = new Card(Suit.SPADES, Rank.EIGHT);
	Card clubs = new Card(Suit.CLUBS, Rank.SEVEN);
	ArrayList<Card> testCards = new ArrayList<Card>();
	BakersDozen test = new BakersDozen();
	
	AcesUp auTest = new AcesUp(); //to be changed
	
	@Test
	public void testStockPileInitial() {
		auTest.initialSetup();
		assertEquals("Stock pile should initiate with 48 cards", 48, auTest.getStockPile_List().size());
	}
	
	@Test
	public void testAddingStockPileAlwaysIllegal() {
		auTest.initialSetup();
		assertFalse("Should always be false, adding not allowed", auTest.addto("stock", 0, 0));	
	}
	
	@Test
	public void testRemovingTopCardAlwaysLegalSPile() {
		
		auTest.initialSetup();
		testCards.add(ace);
		boolean removeTest = auTest.removeFrom("stock", 0);
		assertTrue("Should be an legal removal, returned" + removeTest, removeTest);
	}
	
	@Test
	public void testComplex() {
		
		auTest.initialSetup();

		ArrayList<Card> complex = auTest.getStockPile_List();
		assertEquals("Stock pile should initiate with 48 cards", 48, complex.size());
		complex.add(ace);
		complex.add(ace);
		complex.add(ace);
		complex.add(ace);
		HashMap<Integer, ArrayList<Card>> complex2 = auTest.getTableauPiles_List();
		// not finished;
		
		
		
	}
	
	
	
}
