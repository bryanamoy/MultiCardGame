
package edu.buffalo.cse116.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.buffalo.cse116.Freecell;

import java.util.ArrayList;

public class FreeCellTest {

	Freecell fc = new Freecell(8, 4, 4);
	
	@Test
	public void testFreeCellPiles(){
		
		//tableau pile tests, bullet 1: Tableau piles in Freecell initially hold 6 or 7 cards
		Freecell fe = new Freecell(8, 4, 4);
		fe.initialSetup();
		
		assertEquals("Should return 6 or 7 cards initially for each tableau pile", 7, fe.getTableauMap().get(3).size());
		assertEquals("Should return 6 or 7 cards initially for each tableau pile", 6, fe.getTableauMap().get(8).size());	
	}
//	
//	@Test // bullet 3: Freecell tableau pile correctly determines if adding a specific card is legal or illegal
//	public void testIllegalAdditionToTableau() {
//		boolean illegal = fc.getLegal();
//		int sizeCheck = fc.getTableauPiles();
// 		assertFalse("Should be false but was true, check that move is illegal,",illegal);
//		assertEquals("Size of tableau should be the same",sizeCheck,6|7);
//	}
//	
//	//bullet 5: Freecell tableau pile correctly returns if removing top card is legal or illegal (e.g., if the tableau pile is NOT empty)
	@Test 
	public void testLegalAdditionToTableau() {
		boolean legal = fc.getLegal();
		int sizeCheck = fc.getTableauPiles();
 		assertTrue("Should be true but was false,",legal);	
 		assertEquals("Size of tableau should be increase",sizeCheck,3);
	}
//	//bullet 7: Adding card to Freecell tableau pile increases its number of cards and results in that card being the tableau pile's new top card
	@Test // 
	public void testLegalAdditionToEmptyFreecell() {


	}
	// is this test necessary ?
	@Test
	public void testRemoveFreecellPile() {
		
		Freecell fe = new Freecell(8, 4, 4);
		fe.initialSetup();
		assertEquals("Doesnt remove if freecell is empty", false, fe.removeCard("Freecell", 3));
	}
// 	//bullet 9: Removing card from Freecell tableau pile decreases its number of cards and results in following card being the new top card 	
 		@Test
 	public void testRemoveFromTableau() {
 			Freecell fe = new Freecell(8,4,4);
 			fe.initialSetup();	
 			fe.removeCard("TAblEaU", 2);
 			fe.removeCard("TAblEaU", 5);
 			
 			int topCard = fe.getTableauMap().get(2).size() - 1;
 			assertEquals("The size of the pile should be 6 when removing a card from a tableau pile", 6,  fe.getTableauMap().get(5).size());
 			assertEquals("The size of the pile should be 5 when removing a card from a tableau pile", 7,  fe.getTableauMap().get(1).size());
 	}
//
 		/* (Bryan's code)
 		 * This Test case checks the initial freecell pile in freecell.  The initial size of the 
 		 * homecell pile should equal to zero..
 		 */
 			@Test
 			public void freecellInitial() {
 				Freecell fe = new Freecell(8, 4, 4);
 				fe.initialSetup();
 				assertEquals("This has passed!", 0, fe.getHomecellMap().get(1).size());
 			}
 				/*
 				 * This Test case checks if adding to an empty homecell pile in freecell is legal when the
 				 * pile is empty.  The card should only be able to be added when the pile is empty if the card is an ace.
 				 * If the card is not an ace and the pile is empty, then it should be illegal.
 				 */
// 				@Test
// 				public void homecelladdFC(){
// 					HomecellPiles homecell = Freecell.getHomecellPiles().get(0);
// 					Card first = new Card("Diamond", 1);
// 					Card second = new Card("Spade", 8);
// 					homecell.add(first);
// 					homecell.add(second);
// 					assertTrue("legal", homecell.canAdd(first, homecell));
// 					assertFalse("illegal", homecell.canAdd(second, homecell));
// 				}
// 				/*
// 				 * This test case checks if removing a card from the homecell pile in freecell is legal.
// 				 * In freecell you cannot remove a card from the homecell pile, so it is illegal.
// 				 */
// 				@Test
// 				public void homecellremoveFC{
// 					HomecellPiles homecell = Freecell.getHomecellPiles().get(1);
// 					assertFalse("illegal", homecell.remove(homecell));
// 					
// 				}
// 				/*
// 				 * This test case checks the function of adding cards on top of each other in freecell game.  The card added to the pile
// 				 * will be the new top card.  Essentially, the card top card number ranking should be equivalent to the 
// 				 * number of elements in the pile (size()).
// 				 */
// 				@Test
// 				public void homecelltopFC{
// 					HomecellPiles homecell = Freecell.getHomecellPiles().get(2);
// 					Card first = new Card("Diamond", 1);
// 					Card second = new Card("Diamond", 2);
// 					homecell.add(first);
// 					assertEquals("new top card", homecell.top(), first);
// 					assertEquals("size of pile", homecell.size(), 1);
// 					homecell.add(second);
// 					assertEquals("new top card", homecell.top(), second);
// 					assertEquals("size of pile", homecell.size(), 2);
// 					
// 				}
// 				
	}
