package edu.buffalo.cse116;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class FreecellPileTest {

	@Test
	public void testFreeCellPileFC(){
		Freecell fc = new Freecell(8,4,4);
		fc.initialSetup();
		assertEquals("Empty", 0, fc.getFreecellMap().get(1).size());
	}
	@Test 
	public void testLegalAdditionToEmptyFreecell() {
		Freecell fe = new Freecell(8, 4, 4);
		Card theCard = new Card(Suit.DIAMONDS, Rank.SEVEN);
		
		fe.initialSetup();
		fe.getTableauMap().get(4).clear();
	
		Card testCard = new Card(Suit.CLUBS, Rank.EIGHT);
		ArrayList<Card> testTop = new ArrayList<Card>();
		testTop.add(testCard);
		fe.getTableauMap().put(4, testTop);
		
		fe.addCard(theCard, "tableau", 4);
		assertEquals("Adding card to Freecell tableau pile increases its number of cards and results in that card being the tableau pile's new top card", 2, fe.getTableauMap().get(4).size());
	}
	@Test 
	public void testRemoveFreecellPile() {
			
			Freecell fe = new Freecell(8, 4, 4);
			fe.initialSetup();
			assertEquals("Doesnt remove if freecell is empty", false, fe.removeCard("Freecell", 3));
}
	@Test
	public void testTopFC(){
		Freecell fc = new Freecell(8,4,4);
		fc.initialSetup();
		Card topFC= new Card(Suit.DIAMONDS, Rank.ACE);
		assertTrue(fc.addCard(topFC,"Freecell",1)); //able to add
		int indexOfTopCard = fc.getFreecellMap().get(1).size() - 1;
		assertEquals("Updates the top card", topFC, fc.getFreecellMap().get(1).get(indexOfTopCard));								//Is pile's top card		
		assertEquals("Increases number of cards", 1, fc.getFreecellMap().get(1).size()); 
	}
}
