package edu.buffalo.cse116;

import java.util.ArrayList;

public class HomecellPiles {
	
	private ArrayList<HomecellPiles> pile1;
	private ArrayList<HomecellPiles> pile2;
	private ArrayList<HomecellPiles> pile3;
	private ArrayList<HomecellPiles> pile4;
		
		
	/*
	 * This method deals with whether you can remove from the homecell pile.  In both games removing
	 * a card from homecell is illegal and thus this method does not allow the removal of the card.
	 * 
	 * @return
	 */
	public boolean remove(){
		for(int i = 0; i < size; i++){
			return false;
		}
	}
	/*
	 * This method deals with whether it is legal or illegal to add a card to the Homecell pile.
	 * It is legal if the card's ranking is one above the current size of the homecell pile or in other words
	 * the current top card.  Otherwise if the card does not follow that rule it cannot be added.
	 * 
	 * @return 
	 */
	public boolean canAdd(){
		if(card == pile1.size()+1){
			add(card);
			}
		//if(card == _size+1){
		//add(card);
		//else{
		//cannot add card false
		return true;
		
	}
	/*
	 * This method returns the top card of the homecell pile
	 */
	public void topCard(){
		
	}
	/*
	 * This method if legal allows the card to be added to the top of the homecell pile.
	 */
	public void addCard(){
		
	}
	/*
	 * This method returns the size of the homecell piles.
	 */
	public void pileSize(){
		pile1.size();
		pile2.size();
		pile3.size();
		pile4.size();
	}
}
