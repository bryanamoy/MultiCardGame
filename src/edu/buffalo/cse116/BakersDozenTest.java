package edu.buffalo.cse116;

import static org.junit.Assert.*;

import org.junit.Test;

public class BakersDozenTest {
	BakersDozen test = new BakersDozen();
	@Test // Making sure tableau piles holds 4 cards
	public void testTableauPiles() {
	
		int sizeCheck = test.getTableauSize();
		assertEquals("Should return 4 cards initially for each tableau pile",sizeCheck ,4);
		
	}
	
	@Test // If adding card is legal or illegal and increases number of cards in tableau pile
	public void testIllegalAdditionToTableau() {
		boolean illegal = test.getLegal();
		int sizeCheck = test.getTableauSize();
 		assertFalse("Should be false but was true, check that move is illegal,",illegal);
		assertEquals("Size of tableau should be the same",sizeCheck,4);
	}
	
	@Test // If adding card is legal or illegal and increases number of cards in tableau pile
	public void testLegalAdditionToTableau() {
		boolean legal = test.getLegal();
		int sizeCheck = test.getTableauSize();
 		assertTrue("Should be true but was false,",legal);	
 		assertEquals("Size of tableau should be increase",sizeCheck,3);
	}
	
	@Test // If adding card is legal or illegal and increases number of cards in tableau pile
	public void testLegalAdditionToEmptyTableau() {
		boolean legal = test.getLegal();
		int sizeCheck = test.getTableauSize();
 		assertTrue("Should be true but was false,",legal);
 		assertEquals("Size of tableau should be the increase",sizeCheck,4);
 		
	}
	
	@Test // If removing card is legal or illegal and decreases number of cards in tableau pile
	public void testRemoveFromTableau() {
		boolean removeTest = test.removalIllegal();
		boolean removeTest2 = test.remove();
		int sizeCheck = test.getTableauSize();
		assertFalse("Should be an illegal removal but returned" + removeTest,removeTest);
		assertTrue("Should be an legal removal but returned" + removeTest2,removeTest2);
		assertEquals("Number of cards should be decreased by 1",sizeCheck,3);
	}
	
	

}
