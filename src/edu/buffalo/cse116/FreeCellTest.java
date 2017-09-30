package edu.buffalo.cse116;

import static org.junit.Assert.*;

import org.junit.Test;

public class FreeCellTest {

	FreeCell test = new FreeCell();
	@Test
	public void testFreeCellPiles(){
		
		//Tableau piles in Freecell initially hold 6 or 7 cards
		int sizeCheck = test.getTableauSize();
		assertEquals("Should return 6 or 7 cards initially for each tableau pile", sizeCheck, 6|7);
	}
	
	@Test // Freecell tableau pile correctly determines if adding a specific card is legal or illegal
	public void testIllegalAdditionToTableau() {
		boolean illegal = test.getLegal();
		int sizeCheck = test.getTableauSize();
 		assertFalse("Should be false but was true, check that move is illegal,",illegal);
		assertEquals("Size of tableau should be the same",sizeCheck,6|7);
	}
	
	//Freecell tableau pile correctly returns if removing top card is legal or illegal (e.g., if the tableau pile is NOT empty)
	@Test 
	public void testLegalAdditionToTableau() {
		boolean legal = test.getLegal();
		int sizeCheck = test.getTableauSize();
 		assertTrue("Should be true but was false,",legal);	
 		assertEquals("Size of tableau should be increase",sizeCheck,3);
	}
	//Adding card to Freecell tableau pile increases its number of cards and results in that card being the tableau pile's new top card
	@Test // 
	public void testLegalAdditionToEmptyTableau() {
		boolean legal = test.getLegal();
		int sizeCheck = test.getTableauSize();
 		assertTrue("Should be true but was false,",legal);
 		assertEquals("Size of tableau should be the increase",sizeCheck,6|7);
	
 	//Removing card from Freecell tableau pile decreases its number of cards and results in following card being the new top card 	
 		@Test
 		public void testRemoveFromTableau() {
 			boolean removeTest = test.removalIllegal();
 			boolean removeTest2 = test.remove();
 			int sizeCheck = test.getTableauSize();
 			assertFalse("Should be an illegal removal but returned" + removeTest,removeTest);
 			assertTrue("Should be an legal removal but returned" + removeTest2,removeTest2);
 			assertEquals("Number of cards should be decreased by 1",sizeCheck,3);
 		}

	
	}
