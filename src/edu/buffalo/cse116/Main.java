package edu.buffalo.cse116;
import java.util*;


public class Main {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Freecell fe = new Freecell(8,0,0);  //Starts the constructor of Deck
    HashMap<Integer,ArrayList<Card>> tableauMap = new HashMap<Integer,ArrayList<Card>>();
    HashMap<Integer,ArrayList<Card>> homecellMap = new HashMap<Integer,ArrayList<Card>>();
    HashMap<Integer,ArrayList<Card>> freecellMap = new HashMap<Integer,ArrayList<Card>>();
    fe.initialSetup(tableauMap, homecellMap, freecellMap); //Gets the deck of the super class
    
    System.out.println(tableauMap.size());
    System.out.println(homecellMap.size());
    System.out.println(freecellMap.size());
    
    fe.initialSetup(tableauMap, homecellMap, freecellMap);
    System.out.println(tableauMap.size());
    System.out.println(homecellMap.size());
    System.out.println(freecellMap.size());
  }
}