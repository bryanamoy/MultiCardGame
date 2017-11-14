package edu.buffalo.cse116;

import static org.junit.Assert.*;

import org.junit.Test;

public class AcesUpTableauTest {

	@Test
	public void intialSetup() {
		AcesUp au = new AcesUp();
		au.initialSetup();
		assertEquals(1, au.getSizeOfTableau());
	}
	@Test
	public void legalAdd() {
		AcesUp au = new AcesUp();
		au.initialSetup();
		Card card = new Card(Suit.SPADES, Rank.ACE);
		assertTrue("legal", au.addto(Tableau, 1, Homecell));
	}
	@Test
	public void legalRemove(){
		AcesUp au = new AcesUp();
		au.initialSetup();
		Card card = new Card(Suit.CLUBS, Rank.EIGHT);
		assertTrue("legal", au.removeFrom(tableau, 2));
	}
	@Test
	public void addIncreaseSize(){
		AcesUp au = new AcesUp();
		au.initialSetup();
		Card card = new Card(Suit.CLUBS, Rank.FOUR);
		au.addto(Tableau, 1, Tableau);
		assertEquals(2, au.sizeOfTableau);
	}
	@Test 
	public void removeDecreaseSize(){
		AcesUp au = new AcesUp();
		au.initialSetup();
		Card card = new Card(Suit.HEARTS, Rank.NINE);
		au.removeFrom(Tableau, 1);
		assertEquals(0, au.getSizeOfTableau());
	}
}
