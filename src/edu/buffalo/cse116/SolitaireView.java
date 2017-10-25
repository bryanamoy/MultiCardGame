package edu.buffalo.cse116;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.ImageIcon;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SolitaireView {

	//private Card card;
	private HashMap<Card, ImageView> cardImages = new HashMap<Card,ImageView>();
	private ArrayList<Card> cards = new ArrayList<Card>();

	public SolitaireView() throws FileNotFoundException {
	}

	public HashMap<Card, ImageView> setCardImages() throws FileNotFoundException {
		File files = new File(("moderncards"));
		File[] directoryListing = files.listFiles();
		
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				Card add = new Card(suit, rank);
				cards.add(add);
			}
		}
	
		if (directoryListing != null) {
			for (File child : directoryListing) {
				String cardImageFile = child.getName().substring(0, child.getName().indexOf("."));
				
				for (int i = 0; i < 52; i++)
					if (cardImageFile.equals(cards.get(i).getSuit().toString() + cards.get(i).getRank().toString())) {
						Card card = new Card(cards.get(i).getSuit(),cards.get(i).getRank());
						FileInputStream inputstream = new FileInputStream("moderncards/"+ cardImageFile + ".png"); 
						//System.out.println(inputstream);
						Image image = new Image(inputstream);
						ImageView imageView = new ImageView(image);
						cardImages.put(card, imageView);
						
					}
			}
		}
		return cardImages;
	}

	public HashMap<Card, ImageView> getCardImages() {
		return cardImages;
	}

	public static void main(String[] args) throws FileNotFoundException {
		SolitaireView n = new SolitaireView();
		n.setCardImages();
		System.out.println(n.getCardImages().size());
	}
}
