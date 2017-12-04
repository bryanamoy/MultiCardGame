package edu.buffalo.cse116;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class AcesUp extends Solitaire {

	private HashMap<Integer, ArrayList<Card>> tableauPiles_List; // Storage for
																	// tableau
																	// piles
	private ArrayList<Card> homecellPiles_List; // Storage for
												// homecell
												// piles
	private ArrayList<Card> stockPile_List; // Storage for
											// stockpile
	private ArrayList<Card> discarded;

	public ArrayList<Card> getDiscarded() {
		return discarded;
	}

	public void setDiscarded(ArrayList<Card> discarded) {
		this.discarded = discarded;
	}

	private boolean checkdiscard;

	public HashMap<Integer, ArrayList<Card>> getTableauPiles_List() {
		return tableauPiles_List;
	}

	public void setTableauPiles_List(HashMap<Integer, ArrayList<Card>> tableauPiles_List) {
		this.tableauPiles_List = tableauPiles_List;
	}

	public ArrayList<Card> getHomecellPiles_List() {
		return homecellPiles_List;
	}

	public void setHomecellPiles_List(ArrayList<Card> homecellPiles_List) {
		this.homecellPiles_List = homecellPiles_List;
	}

	public ArrayList<Card> getStockPile_List() {
		return stockPile_List;
	}

	public void setStockPile_List(ArrayList<Card> stockPile_List) {
		this.stockPile_List = stockPile_List;
	}

	public int getSizeOfTableau(int pile) {
		int size = 0;
		for (Integer i : getTableauPiles_List().keySet()) {
			if (i.equals(pile)) {
				size = getTableauPiles_List().get(pile).size();
			}
		}
		return size;
	}

	private ArrayList<Card> deck = getDeck();

	/*
	 * Freecell pile is treated as the StockPile since no freecell piles can be
	 * used in aces's up
	 */
	public AcesUp() {
		super(4, 1, 1);

	}

	@Override
	protected void initialSetup() {
		tableauPiles_List = new HashMap<Integer, ArrayList<Card>>();
		stockPile_List = new ArrayList<Card>();
		homecellPiles_List = new ArrayList<Card>();

		Random rand = new Random();
		int random = 0;
		ArrayList<Card> restofDeck = deck;

		for (int i = 0; i < 4; i++) {
			random = rand.nextInt(deck.size());
			ArrayList<Card> Arr = new ArrayList<Card>();
			Arr.add(deck.get(random));
			tableauPiles_List.put(i, Arr);
			restofDeck.remove(random);
		}
		stockPile_List.addAll(restofDeck);

		discarded = new ArrayList<Card>();
		checkdiscard = false;
	}

	public Card getCard(int pileNumber){
		Card selected = null;
		if(tableauPiles_List.get(pileNumber).isEmpty()){
			return null;
		}
		for(Integer i : tableauPiles_List.keySet()){
			if(pileNumber == i){
					int size = tableauPiles_List.get(pileNumber).size()-1;
					selected = tableauPiles_List.get(i).get(size);
			}
		}
		return selected;
	}

	public boolean addto(String p, int pilenumber, int piletoadd) {

		int sizeofPile = getTableauPiles_List().get(pilenumber).size()-1;
		if (p.equalsIgnoreCase("stock")) {
			return false;
		} else if (p.equalsIgnoreCase("homecell")) {
			if (checkdiscard == true) {
				Card top = discarded.get(0);
				homecellPiles_List.add(top);
				discarded.remove(0);
				checkdiscard = false;
				return true;
			}
		} else if (p.equalsIgnoreCase("tableau")) {
			Card top = getCard(pilenumber);
			if (tableauPiles_List.get(piletoadd).isEmpty()) {
				tableauPiles_List.get(piletoadd).add(top);
				tableauPiles_List.get(pilenumber).remove(sizeofPile);
				return true;
			}

		}
		return false;
	}

	public boolean removeFrom(String p, int pilenumber) {

		if (p.equalsIgnoreCase("homecell")) {
			return false;
		} else if (p.equalsIgnoreCase("stock")) {
			ArrayList<Card> addtoTab = new ArrayList<Card>();
			if (stockPile_List.isEmpty()) {
				return false;
			} else {
				int size = stockPile_List.size() - 1;
				for (int x = size; x > size - 4; x--) {
					addtoTab.add(stockPile_List.get(x));
					stockPile_List.remove(x);
				}
				for (int x = 0; x < 4; x++) {
					tableauPiles_List.get(x).add(addtoTab.get(x));
				}
				return true;

			}
		} else if (p.equalsIgnoreCase("tableau")) {
			if (tableauPiles_List.get(pilenumber).isEmpty()) {
				return false;
			} else {
				int size = tableauPiles_List.get(pilenumber).size() - 1;
				Card top = getCard(pilenumber);
				for (ArrayList<Card> pile : tableauPiles_List.values()) {
					int topofpile = pile.size() - 1;
					if (pile.get(topofpile).getSuit().equals(top.getSuit())
							&& pile.get(topofpile).getRank().getRank() > top.getRank().getRank()) {
						discarded.add(top);
						tableauPiles_List.get(pilenumber).remove(size);
						checkdiscard = true;
						return true;
					}
				}
			}
		}

		return false;

	}
	
	

	public static void main(String[] args) {

	}

}
