package edu.buffalo.cse116;

import static org.junit.Assert.*;
import java.util.ArrayList;
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
	
	/*(Bryan's code)
	 * This Test case checks the intial homecell pile in baker's dozen game.  The initial size of
	 * the homecell pile should equal zero.
	 */
	@Test 
	public void bakersdozenIntial(){
		ArrayList<HomecellPiles> homecell = BakersDozen.getHomecell();
		assertEquals(0, getHomecell.size());
}
	/*
	 * This Test case checks if adding to an empty homecell pile in baker's dozen is legal.  If the homecell pile is 
	 * empty the only cards that can be added is an ace.  If it is a card higher than rank 1 then it cannot be added
	 * to the pile.
	 */
	@Test 
	public void homecelladdBD(){
		HomecellPiles homecell = BakersDozen.getHomecell().get(0);
		Card first = new Card("Diamond", 1);
		Card second = new Card("Spade", 8);
		homecell.add(first);
		homecell.add(second);
		assertTrue("legal", homecell.canAdd(first, bakersdozen));
		assertFalse("illegal", homecell.canAdd(second, bakersdozen));
	}

	/*
	 * This test case checks if removing a card from the homecell pile in baker's dozen is legal.
	 * It is illegal to remove a card from the pile thus it should be false if removing is tried.
	 */
	@Test
	public void homecellremoveBD{
		HomecellPiles homecell = BakersDozen.getHomecell().get(1);
		assertFalse("illegal", homecell.remove(homecell));
}
	/*
	 * This test case checks the function of adding cards on top of each other in baker's dozen game.
	 * In this test I created 2 cards of chronological order to see if the top card is the last card added.
	 * 
	 */
	@Test
	public void homecelltopBD{
		HomecellPiles homecell = BakersDozen.getHomecell().get(2);
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