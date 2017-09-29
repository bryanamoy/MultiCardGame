package edu.buffalo.cse116;

import static org.junit.Assert.*;

import org.junit.Test;

public class HomecellPilesTest {
/*
 * This Test case checks the initial homecell pile in freecell.  The initial size of the 
 * homecell pile should equal to zero.
 */
	@Test
	public void freecellInitial() {
		ArrayList<Homecell> homecell = freecell.getHomecell();
		assertEquals(0, getHomecell.size());
//	Homecell intialsetupFC = new Homecell.intial();
//	assertEquals(0, intialsetupFC.size());
	}
	/*
	 * This Test case checks the intial homecell pile in baker's dozen game.  The initial size of
	 * the homecell pile should equal zero.
	 */
	@Test 
	public void bakersdozenIntial(){
		ArrayList<Homecell> homecell = bakersdozen.getHomecell();
		assertEquals(0, getHomecell.size());
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
		Homecell homecell = freecell.getHomecell().get(0);
		Card first = new Card("Diamond", 1);
		Card second = new Card("Spade", 8);
		homecell.add(first);
		homecell.add(second);
		assertTrue("legal", homecell.add(first, homecell));
		assertFalse("illegal", homecell.add(second, homecell));
	}
	/*
	 * This Test case checks if adding to an empty homecell pile in baker's dozen is legal.  If the homecell pile is 
	 * empty the only cards that can be added is an ace.  If it is a card higher than rank 1 then it cannot be added
	 * to the pile.
	 */
	@Test 
	public void homecelladdBD(){
		Homecell homecell = bakersdozen.getHomecell().get(0);
		Card first = new Card("Diamond", 1);
		Card second = new Card("Spade", 8);
		homecell.add(first);
		homecell.add(second);
		assertTrue("legal", homecell.add(first, bakersdozen));
		assertFalse("illegal", homecell.add(second, bakersdozen));
	}
	/*
	 * This test case checks if removing a card from the homecell pile in freecell is legal.
	 * In freecell you cannot remove a card from the homecell pile, so it is illegal.
	 */
	@Test
	public void homecellremoveFC{
		Homecell homecell = freecell.getHomecell().get(1);
		assertFalse("illegal", homecell.remove(homecell));
		
	}
	/*
	 * This test case checks if removing a card from the homecell pile in baker's dozen is legal.
	 * It is illegal to remove a card from the pile thus it should be false if removing is tried.
	 */
	@Test
	public void homecellremoveBD{
		Homecell homecell = bakersdozen.getHomecell().get(1);
		assertFalse("illegal", homecell.remove(homecell));
}
	/*
	 * This test case checks the function of adding cards on top of each other in freecell game.  The card added to the pile
	 * will be the new top card.  Essentially, the card top card number ranking should be equivalent to the 
	 * number of elements in the pile (size()).
	 */
	@Test
	public void homecelltopFC{
		Homecell homecell = freecell.getHomecell().get(2);
		Card first = new Card("Diamond", 1);
		Card second = new Card("Diamond", 2);
		homecell.add(first);
		assertEquals("new top card", homecell.top(), first);
		assertEquals("size of pile", homecell.size(), 1);
		homecell.add(second);
		assertEquals("new top card", homecell.top(), second);
		assertEquals("size of pile", homecell.size(), 2);
		
	}
	/*
	 * This test case checks the function of adding cards on top of each other in baker's dozen game.
	 * In this test I created 2 cards of chronological order to see if the top card is the last card added.
	 * 
	 */
	@Test
	public void homecelltopBD{
		Homecell homecell = bakersdozen.getHomecell().get(2);
		Card first = new Card("Diamond", 1);
		Card second = new Card("Diamond", 2);
		homecell.add(first);
		assertEquals("new top card", homecell.top(), first);
		assertEquals("size of pile", homecell.size(), 1);
		homecell.add(second);
		assertEquals("new top card", homecell.top(), second);
		assertEquals("size of pile", homecell.size(), 2);
	}