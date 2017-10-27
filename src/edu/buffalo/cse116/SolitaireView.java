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

import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class SolitaireView {

	// private Card card;
	private HashMap<Card, ImageView> cardImages = new HashMap<Card, ImageView>();
	private ArrayList<Card> cards = new ArrayList<Card>();
	private BakersDozen bd;
	private Freecell fc;


	public SolitaireView() throws FileNotFoundException {
	}

	public HashMap<Card, ImageView> setCardImages(String game) throws FileNotFoundException {

		File files = new File(("moderncards"));
		File[] directoryListing = files.listFiles();

		if (game.toLowerCase().equals("bakersdozen")) {
			bd = new BakersDozen();
			bd.initialSetup();
			cards = bd.getDeck();
			if (directoryListing != null) {
				for (File child : directoryListing) {
					String cardImageFile = child.getName().substring(0, child.getName().indexOf("."));
					for (int i = 0; i < 52; i++)
						if (cardImageFile
								.equals(cards.get(i).getSuit().toString() + cards.get(i).getRank().toString())) {
							Card card = new Card(cards.get(i).getSuit(), cards.get(i).getRank());
							FileInputStream inputstream = new FileInputStream("moderncards/" + cardImageFile + ".png");
							Image image = new Image(inputstream);
							ImageView imageView = new ImageView(image);
							cardImages.put(card, imageView);

						}
				}

			}

		}

		if (game.toLowerCase().equals("freecell")) {
			fc = new Freecell();
			fc.initialSetup();
			cards = fc.getDeck();
			if (directoryListing != null) {
				for (File child : directoryListing) {
					String cardImageFile = child.getName().substring(0, child.getName().indexOf("."));
					for (int i = 0; i < 52; i++)
						if (cardImageFile
								.equals(cards.get(i).getSuit().toString() + cards.get(i).getRank().toString())) {
							Card card = new Card(cards.get(i).getSuit(), cards.get(i).getRank());
							FileInputStream inputstream = new FileInputStream("moderncards/" + cardImageFile + ".png");
							Image image = new Image(inputstream);
							ImageView imageView = new ImageView(image);
							cardImages.put(card, imageView);

						}
				}

			}

		}

		return cardImages;
	}

	public HashMap<Card, ImageView> getCardImages() {
		return cardImages;
	}
	
	
	public ImageView displayImageViewOfCard(Card c) {
		ImageView rtn = null;

		for (Card check : getCardImages().keySet()) {
			if (check.toString().equals(c.toString())) {
				rtn = getCardImages().get(check);

			}
		}
		return rtn;

	}

	public static void main(String[] args) {

	}
}
