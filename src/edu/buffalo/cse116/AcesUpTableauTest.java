package edu.buffalo.cse116;

import static org.junit.Assert.*;

import org.junit.Test;

public class AcesUpTableauTest {
/*
 * Tests for the single card in each Tableau Pile at the initial start of the game
 */
	@Test
	public void intialSetupTablaeuPile1() {
		AcesUp au = new AcesUp();
		au.initialSetup();
		assertEquals(1, au.getSizeOfTableau());
	}
	@Test
	public void initialSetupTableauPile2(){
		AcesUp au = new AcesUp();
		au.initialSetup();
		assertEquals(1, au.getSizeOfTableau());
	}
	@Test
	public void initialSetupTableauPile3(){
		AcesUp au = new AcesUp();
		au.initialSetup();
		assertEquals(1, au.getSizeOfTableau());
	}
	@Test
	public void initialSetupTableauPile4(){
		AcesUp au = new AcesUp();
		au.initialSetup();
		assertEquals(1, au.getSizeOfTableau());
	}
	/*
	 * Testing that there are 4 Tableau Piles
	 */
	@Test
	public void initialSetup4TableauPiles(){
		AcesUp au = new AcesUp();
		au.initialSetup();
		assertEquals(4, au.getTableauPiles());
	}
	/*
	 * Testing if card is legal to add to Tableau Pile
	 */
	@Test
	public void legalAdd() {
		AcesUp au = new AcesUp();
		au.initialSetup();
		Card card = new Card(Suit.SPADES, Rank.ACE);
		assertTrue("legal", au.addto(Tableau, 1, au.getTableauPiles()));
	}
	/*
	 * Testing if card is legal to remove from Tableau Pile
	 */
	@Test
	public void legalRemove(){
		AcesUp au = new AcesUp();
		au.initialSetup();
		Card card = new Card(Suit.CLUBS, Rank.EIGHT);
		assertTrue("legal", au.removeFrom(au.getTableauPiles_List(), 2));
	}
	/*
	 * Testing that the size of the Tableau Pile increases when card is added and the new card is
	 * the Tableau Pile's new top card
	 */
	@Test
	public void addIncreaseSize(){
		AcesUp au = new AcesUp();
		au.initialSetup();
		Card card = new Card(Suit.CLUBS, Rank.FOUR);
		au.addto(Tableau, 1, Tableau);
		assertEquals(2, au.sizeOfTableau);
	}
	/*
	 * Testing that the size of the Tableau Pile decreases when a card is removed and the next card
	 * is the Tableau Pile's new top card
	 */
	@Test 
	public void removeDecreaseSize(){
		AcesUp au = new AcesUp();
		au.initialSetup();
		Card card = new Card(Suit.HEARTS, Rank.NINE);
		Card card2 = new Card(Suit.SPADES, Rank.TEN);
		au.addto(HEARTSNINE, 2, 2);
		au.addto(SPADESTEN, 2, 2);
		au.removeFrom(Tableau, 2);
		assertEquals(2, au.getSizeOfTableau());
		assertEquals(HEARTSNINE, au.getTableauPiles_List());
	}
}
