package edu.buffalo.cse116;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import edu.buffalo.cse116.BakersDozen;

public class BakersDozenTest {
	BakersDozen test = new BakersDozen();
	Card ace = new Card(Suit.CLUBS, Rank.ACE);
	Card spades = new Card(Suit.SPADES, Rank.EIGHT);
	Card clubs = new Card(Suit.CLUBS, Rank.SEVEN);
	ArrayList<Card> testCards = new ArrayList<Card>();

	@Test // Making sure tableau piles holds 4 cards
	public void testTableauPiles() {

		test.initialSetup();
		for (Integer i : test.getTableauPiles_List().keySet()) {
			ArrayList<Card> check = new ArrayList<Card>(test.getTableauPiles_List().get(i));
			int sizeCheck = check.size();
			assertEquals("Should return 4 cards initially for each tableau pile", sizeCheck, 4);
		}

	}

	@Test // If adding card is legal or illegal and increases number of cards in
			// tableau pile
	public void testIllegalAdditionToTableau() {

		HashMap<Integer, ArrayList<Card>> test2 = new HashMap<Integer, ArrayList<Card>>();
		testCards.add(spades);
		test2.put(2, testCards);
		Card check = new Card(Suit.HEARTS, Rank.FIVE);
		test.setTableauPiles_List(test2);
		int sizeCheck = test.getTableauPileSize(2);
		boolean illegal = test.addCard(check, 2);
		assertFalse("Should be false but was true, check that move is illegal,", illegal);
		assertEquals("Size of tableau should be the same", sizeCheck, 1);
	}

	@Test // If adding card is legal or illegal and increases number of cards in
			// tableau pile
	public void testLegalAdditionToTableau() {
		BakersDozen test2 = new BakersDozen();
		HashMap<Integer, ArrayList<Card>> check = new HashMap<Integer, ArrayList<Card>>();
		Card clubs = new Card(Suit.CLUBS, Rank.SEVEN);
		testCards.add(spades);
		check.put(3, testCards);
		test2.setTableauPiles_List(check);
		boolean legal = test2.addCard(clubs, 3);
		int sizeCheck = test2.getTableauPileSize(3);
		assertTrue("Should be true but was " + legal, legal);
		assertEquals("Size of tableau pile should be 2", sizeCheck, 2);
		assertEquals("Top card should be clubs", test2.getTableauPiles_List().get(3).get(sizeCheck - 1), clubs);

	}

	@Test // Tests to see if it can add to empty tableau which is always false
	public void testAdditionToEmptyTableau() {
		test.initialSetup();
		test.resetTableau();
		boolean illegal = test.addCard(spades, 0);
		assertFalse("Returned " + illegal + " when it should be false", illegal);

	}

	@Test // If removing card is legal or illegal and decreases number of cards
			// in tableau pile
	public void testIllegalRemoveFromTableau() {
		test.initialSetup();
		boolean removeTest = test.removeCard(spades, 7);
		assertFalse("Should be an illegal removal but returned" + removeTest, removeTest);
	}

	@Test
	public void testRemoveFromTableau() {

		BakersDozen cards = new BakersDozen();
		HashMap<Integer, ArrayList<Card>> t = new HashMap<Integer, ArrayList<Card>>();
		testCards.add(spades);
		testCards.add(ace);
		t.put(0, testCards);
		cards.setTableauPiles_List(t);
		boolean legal = cards.removeCard(ace, 0);
		int sizeCheck = cards.getTableauPileSize(0);
		Card cardCheck = cards.getTableauPiles_List().get(0).get(0);
		assertTrue("Returned " + legal, legal);
		assertEquals(sizeCheck, 1);
		assertEquals(cardCheck, spades);
	}

	@Test
	public void testHomecellPiles() {
		test.initialSetup();
		for (Integer i : test.getHomecellPiles_List().keySet()) {
			ArrayList<Card> check = new ArrayList<Card>(test.getHomecellPiles_List().get(i));
			int sizeCheck = check.size();
			assertEquals("Should return 4 cards initially for each tableau pile", sizeCheck, 0);
		}
	}

	/*
	 * This Test case checks if adding to an empty homecell pile in baker's
	 * dozen is legal. If the homecell pile is empty the only cards that can be
	 * added is an ace. If it is a card higher than rank 1 then it cannot be
	 * added to the pile.
	 */
	@Test
	public void testhomecelladdEmptyBD() {
		test.initialSetup();
		test.getHomecellPiles_List();
		Card first = new Card(Suit.DIAMONDS, Rank.ACE);
		Card second = new Card(Suit.SPADES, Rank.EIGHT);
		boolean legal = test.addToHomecell(first, 2);
		boolean illegal = test.addToHomecell(second, 2);
		int sizeofPile = test.getHomecellPileSize(2);
		assertTrue("legal", legal);
		assertFalse("illegal", illegal);
		assertEquals("Should be 1 but returned" + sizeofPile, sizeofPile, 1);
	}

	@Test
	public void homecelltopBD() {
		BakersDozen topBD = new BakersDozen();
		topBD.initialSetup();
		Card first = new Card(Suit.DIAMONDS, Rank.ACE);
		Card second = new Card(Suit.DIAMONDS, Rank.TWO);
		topBD.addToHomecell(first, 3);
		topBD.addToHomecell(second, 3);
		assertEquals("new top card", topBD.getHomecellPiles_List().get(3).get(1), second);
		assertEquals("size of pile", topBD.getHomecellPiles_List().get(3).size(), 2);

	}

	@Test
	public void testRemoveFromHomecell() {
		test.initialSetup();
		assertFalse("Should always be false", test.removeFromHomecell());

	}

}
