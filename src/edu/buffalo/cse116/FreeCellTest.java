package edu.buffalo.cse116;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;

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

 		/* (Bryan's code)
 		 * This Test case checks the initial homecell pile in freecell.  The initial size of the 
 		 * homecell pile should equal to zero..
 		 */
 			@Test
 			public void freecellInitial() {
 				ArrayList<HomecellPiles> homecell = Freecell.getHomecell();
 				assertEquals(0, getHomecell.size());
	
 				/*
 				 * This Test case checks if adding to an empty homecell pile in freecell is legal when the
 				 * pile is empty.  The card should only be able to be added when the pile is empty if the card is an ace.
 				 * If the card is not an ace and the pile is empty, then it should be illegal.
 				 */
 				@Test
 				public void homecelladdFC(){
 					HomecellPiles homecell = Freecell.getHomecell().get(0);
 					Card first = new Card("Diamond", 1);
 					Card second = new Card("Spade", 8);
 					homecell.add(first);
 					homecell.add(second);
 					assertTrue("legal", homecell.canAdd(first, homecell));
 					assertFalse("illegal", homecell.canAdd(second, homecell));
 				}
 				/*
 				 * This test case checks if removing a card from the homecell pile in freecell is legal.
 				 * In freecell you cannot remove a card from the homecell pile, so it is illegal.
 				 */
 				@Test
 				public void homecellremoveFC{
 					HomecellPiles homecell = Freecell.getHomecell().get(1);
 					assertFalse("illegal", homecell.remove(homecell));
 					
 				}
 				/*
 				 * This test case checks the function of adding cards on top of each other in freecell game.  The card added to the pile
 				 * will be the new top card.  Essentially, the card top card number ranking should be equivalent to the 
 				 * number of elements in the pile (size()).
 				 */
 				@Test
 				public void homecelltopFC{
 					HomecellPiles homecell = Freecell.getHomecell().get(2);
 					Card first = new Card("Diamond", 1);
 					Card second = new Card("Diamond", 2);
 					homecell.add(first);
 					assertEquals("new top card", homecell.top(), first);
 					assertEquals("size of pile", homecell.size(), 1);
 					homecell.add(second);
 					assertEquals("new top card", homecell.top(), second);
 					assertEquals("size of pile", homecell.size(), 2);
 					
 				}
 				
	}
