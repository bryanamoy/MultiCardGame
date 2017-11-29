package edu.buffalo.cse116;

import static org.junit.Assert.*;

import org.junit.Test;

public class AcesUpTableauTest {
	Card ace = new Card(Suit.CLUBS, Rank.ACE);
	Card spades = new Card(Suit.SPADES, Rank.EIGHT);
	Card clubs = new Card(Suit.CLUBS, Rank.SEVEN);
/*
 * Tests for the single card in each Tableau Pile at the initial start of the game
 */
	@Test
	public void intialSetupTablaeuPile1() {
		AcesUp au = new AcesUp();
		au.initialSetup();
		assertEquals(1, au.getSizeOfTableau(0));
	}
	@Test
	public void initialSetupTableauPile2(){
		AcesUp au = new AcesUp();
		au.initialSetup();
		assertEquals(1, au.getSizeOfTableau(1));
	}
	@Test
	public void initialSetupTableauPile3(){
		AcesUp au = new AcesUp();
		au.initialSetup();
		assertEquals(1, au.getSizeOfTableau(2));
	}
	@Test
	public void initialSetupTableauPile4(){
		AcesUp au = new AcesUp();
		au.initialSetup();
		assertEquals(1, au.getSizeOfTableau(3));
	}
	/*
	 * Testing that there are 4 Tableau Piles
	 */
	@Test
	public void initialSetup4TableauPiles(){
		AcesUp au = new AcesUp();
		au.initialSetup();
		assertEquals(4, au.getTableauPiles_List().size());
	}
	/*
	 * Testing if card is legal to add to Tableau Pile(Only can add to empty tableau pile)
	 */
	@Test
	public void legalAdd() {
		AcesUp au = new AcesUp();
		au.initialSetup();
		au.getTableauPiles_List().get(0).clear();
		assertTrue("legal", au.addto("tableau", 1, 0));
	}
	/*
	 * Testing if card is legal to remove from Tableau Pile
	 */
	@Test
	public void legalRemove(){
		AcesUp au = new AcesUp();
		au.initialSetup();
		au.getTableauPiles_List().get(0).clear();
		au.getTableauPiles_List().get(0).add(ace);
		au.getTableauPiles_List().get(1).clear();
		au.getTableauPiles_List().get(1).add(clubs);
		assertTrue("legal", au.removeFrom("tableau", 0));
	}
	/*
	 * Testing that the size of the Tableau Pile increases when card is added and the new card is
	 * the Tableau Pile's new top card
	 */
	@Test
	public void addIncreaseSize(){
		AcesUp au = new AcesUp();
		au.initialSetup();
		au.getTableauPiles_List().get(0).clear();
		au.getTableauPiles_List().get(1).clear();
		au.getTableauPiles_List().get(1).add(ace);
		Card checktop = au.getTableauPiles_List().get(1).get(0);
		au.addto("tableau", 1, 0);
		assertEquals("Size should be one",1,au.getTableauPiles_List().get(0).size());
		assertEquals("Should be aces",checktop,au.getTableauPiles_List().get(0).get(0));
	}
	/*
	 * Testing that the size of the Tableau Pile decreases when a card is removed and the next card
	 * is the Tableau Pile's new top card
	 */
	@Test 
//	Still needs work
	public void removeDecreaseSize(){
		AcesUp au = new AcesUp();
		au.initialSetup();
		au.initialSetup();
		au.getTableauPiles_List().get(0).clear();
		au.getTableauPiles_List().get(0).add(ace);
		au.getTableauPiles_List().get(1).clear();
		au.getTableauPiles_List().get(1).add(clubs);
		 au.removeFrom("tableau", 0);
		assertEquals(0, au.getTableauPiles_List().get(0).size());
	}
}
