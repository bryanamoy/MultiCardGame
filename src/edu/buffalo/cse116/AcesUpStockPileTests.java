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
	public void testRemovefromStockPile() {
		
		auTest.initialSetup();
		
		auTest.removeFrom("stock", 0);
		for(int i =0;i<4;i++){
			assertEquals("Each tableau pile should have 2 cards",2,auTest.getTableauPiles_List().get(i).size());
		}
		auTest.getStockPile_List().clear();
		boolean check = auTest.removeFrom("stock", 0);
		assertFalse("If the stockpile is empty it should return false",check);

		
	}
	
	
	
}
