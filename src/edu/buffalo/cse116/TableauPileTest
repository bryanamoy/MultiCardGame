package edu.buffalo.cse116;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

public class TableauPileTest {
	BakersDozen test = new BakersDozen();
	Card ace = new Card(Suit.CLUBS, Rank.ACE);
	Card spades = new Card(Suit.SPADES, Rank.EIGHT);
	Card clubs = new Card(Suit.CLUBS, Rank.SEVEN);
	ArrayList<Card> testCards = new ArrayList<Card>();
	@Test
	public void testFreeCellPilesHoldSixOrSeven(){
		
	//tableau pile tests, Bullet 1: Tableau piles in Freecell initially hold 6 or 7 cards
		Freecell fe = new Freecell(8, 4, 4);
		fe.initialSetup();
		assertEquals("Should return 6 or 7 cards initially for each tableau pile", 7, fe.getTableauMap().get(3).size());
		assertEquals("Should return 6 or 7 cards initially for each tableau pile", 6, fe.getTableauMap().get(8).size());	
	}
    // Bullet 2: Making sure tableau piles holds 4 cards
	@Test
	public void testTableauPilesInBDHoldFour() {
		BakersDozen test = new BakersDozen();
		test.initialSetup();
		for (Integer i : test.getTableauPiles_List().keySet()) {
			ArrayList<Card> check = new ArrayList<Card>(test.getTableauPiles_List().get(i));
			int sizeCheck = check.size();
			assertEquals("Should return 4 cards initially for each tableau pile", 4,sizeCheck);
		}
		}
	//Bullet 3: Freecell tableau pile correctly determines if adding a specific card is legal or illegal
	@Test
	public void testFCTableauCanAddCard(){
		Freecell legal = new Freecell(8,4,4);
		legal.initialSetup();
		Card first = new Card(Suit.DIAMONDS, Rank.FIVE);
		Card second = new Card(Suit.SPADES, Rank.FOUR);
		ArrayList<Card> test = new ArrayList<Card>();
		test.add(first);
		legal.getTableauMap().get(1).clear();
		legal.getTableauMap().put(1, test);
		assertTrue("Legal Can Add", legal.addCard(second, "Tableau", 1));
	}
	
	// Bullet 4 and 8: Baker's Dozen: If adding card is legal or illegal and increases number of cards in tableau pile
	@Test
	public void testBDLegalAdditionToTableau() {
		BakersDozen test2 = new BakersDozen();
		ArrayList<Card> testCards = new ArrayList<Card>();
		HashMap<Integer, ArrayList<Card>> check = new HashMap<Integer, ArrayList<Card>>();
		Card clubs = new Card(Suit.CLUBS, Rank.SEVEN);
		testCards.add(spades);
		check.put(3, testCards);
		test2.setTableauPiles_List(check);	
		boolean legal = test2.addCard(clubs, 3);
		int sizeCheck = test2.getTableauPileSize(3);
		assertTrue("Should be true but was " + legal, legal);
		assertEquals("Size of tableau pile should be 2", sizeCheck, 2);
		assertEquals("Top card should be clubs", clubs,test2.getTableauPiles_List().get(3).get(sizeCheck - 1));

}
	//Bullet 5: Freecell tableau pile correctly returns if removing top card is legal or illegal (e.g., if the tableau pile is NOT empty)
	@Test 
	public void testRemoveTableauPileinFC() {
			Freecell fe = new Freecell(8, 4, 4);
			fe.initialSetup();
			assertEquals("Doesnt remove if freecell is empty", true, fe.removeCard("tableau", 3));
		}
	
    //Bullet 6: Baker's Dozen tableau pile correctly returns if removing top card is legal or illegal (e.g., if the tableau pile is NOT empty) [4 points]
	@Test
	public void testIllegalRemoveFromTableau() {
	test.initialSetup();
	boolean removeTest = test.removeCard(spades, 7);
	assertFalse("Should be an illegal removal but returned" + removeTest, removeTest);
}

	//bullet 7: Adding card to Freecell tableau pile increases its number of cards and results in that card being the tableau pile's new top card
	@Test 
	public void testSizeofTableauFCAfterAdding() {
		Freecell fe = new Freecell(8, 4, 4);
		Card givenCard = new Card(Suit.DIAMONDS, Rank.SEVEN);
		
		fe.initialSetup();
		fe.getTableauMap().get(4).clear();
	
		Card topCard = new Card(Suit.CLUBS, Rank.EIGHT);
		ArrayList<Card> testTop = new ArrayList<Card>();
		
		testTop.add(topCard);
		fe.getTableauMap().put(4, testTop);
		
		fe.addCard(givenCard, "tableau", 4);
		assertEquals("Adding card to Freecell tableau pile increases its number of cards and results in that card being the tableau pile's new top card", 2, fe.getTableauMap().get(4).size());
}

	//Bullet 9: Removing card from Freecell tableau pile decreases its number of cards and results in following card being the new top card 	
		@Test
	public void testRemoveFromFCTableau() {
			Freecell fe = new Freecell(8,4,4);
			fe.initialSetup();	
			fe.removeCard("TAblEaU", 1);
			fe.removeCard("TAblEaU", 5);
			
			assertEquals("The size of the pile should be 5 when removing a card from a tableau pile", 6,  fe.getTableauMap().get(1).size());
			assertEquals("The size of the pile should be 6 when removing a card from a tableau pile", 6,  fe.getTableauMap().get(1).size());
	}
	
	//bullet 10: Removing card from Baker's Dozen tableau pile decreases its number of cards and results in following card being the new top card [4 points]
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
	assertEquals(1,sizeCheck);
	assertEquals(spades,cardCheck);
}	
	
	
	
}
