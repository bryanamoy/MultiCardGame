package edu.buffalo.cse116;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class AcesUpHomecellTests {

	Card ace = new Card(Suit.CLUBS, Rank.ACE);
	Card spades = new Card(Suit.SPADES, Rank.EIGHT);
	Card clubs = new Card(Suit.CLUBS, Rank.SEVEN);
	ArrayList<Card> testCards = new ArrayList<Card>();
	
	AcesUp auTest = new AcesUp(); //to be changed
	
	@Test
	public void testEmptyHCPile() {
		auTest.initialSetup();
		assertEquals("Homecell pile should initiate with zero cards", 0, auTest.getHomecellPiles_List().size());
	}
	
	@Test
	public void testAddSpecificCardLegalOrIllegalHCPile() {
		auTest.initialSetup();
		auTest.getTableauPiles_List().get(0).clear();
		auTest.getTableauPiles_List().get(0).add(new Card(Suit.CLUBS,Rank.ACE));
		
		auTest.getTableauPiles_List().get(1).clear();
		auTest.getTableauPiles_List().get(1).add(new Card(Suit.CLUBS,Rank.EIGHT));
		auTest.removeFrom("tableau", 0);
		assertTrue(auTest.addto("homecell", 0, 0));
		assertEquals("Should only be one card ",1,auTest.getHomecellPiles_List().size());
	}
	
	@Test
	public void testRemovingTopCardAlwaysIllegalHCPile() {
		
		auTest.initialSetup();

		assertFalse("Should always be false", auTest.removeFrom("homecell", 0));
	}
	
	@Test
	public void testAddingCardIncreasesSizeAndTopCardHCPile() {
		auTest.initialSetup();
		auTest.getTableauPiles_List().get(0).clear();
		auTest.getTableauPiles_List().get(0).add(ace);
		
		auTest.getTableauPiles_List().get(1).clear();
		auTest.getTableauPiles_List().get(1).add(clubs);
		auTest.removeFrom("tableau", 0);
		auTest.addto("homecell", 0, 0);
		assertEquals("Should only be one card in homecell ",1,auTest.getHomecellPiles_List().size());
		assertEquals("Should be a clubs of ace", ace.toString(),auTest.getHomecellPiles_List().get(0).toString());
	}
	
}
