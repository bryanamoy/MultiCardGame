package edu.buffalo.cse116;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.ImageIcon;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

public class SolitaireView {

	private HashMap<Card, ImageView> cardImages = new HashMap<Card, ImageView>();
	private ArrayList<Card> cards = new ArrayList<Card>();
	private BakersDozen bd;
	private Freecell fc;
	private MediaPlayer mediaPlayer;
	private ArrayList<HBox> boxesforBD = new ArrayList<HBox>();
	private ArrayList<VBox> boxesforFC = new ArrayList<VBox>();

	public SolitaireView() {

	}

	public HashMap<Card, ImageView> setCardImages(String game) {

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
							FileInputStream inputstream;
							try {
								inputstream = new FileInputStream("moderncards/" + cardImageFile + ".png");
								Image image = new Image(inputstream);
								ImageView imageView = new ImageView(image);
								cardImages.put(card, imageView);
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

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
							FileInputStream inputstream;
							try {
								inputstream = new FileInputStream("moderncards/" + cardImageFile + ".png");
								Image image = new Image(inputstream);
								ImageView imageView = new ImageView(image);
								cardImages.put(card, imageView);
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}
				}

			}

		}

		return cardImages;
	}

	public HashMap<Card, ImageView> getCardImages() {
		return cardImages;
	}

	public ArrayList<HBox> getBoxesforBD() {
		return boxesforBD;
	}

	public ImageView getImageViewOfCard(Card c) {
		ImageView rtn = null;

		for (Card check : getCardImages().keySet()) {
			if (check.toString().equals(c.toString())) {
				rtn = getCardImages().get(check);

			}
		}
		return rtn;

	}

	public MediaPlayer getMediaPlayer() {
		return mediaPlayer;
	}

	public StackPane startBakersDozenGame() {
		StackPane stackPane = new StackPane();

		BorderPane root = new BorderPane();
		setCardImages("bakersdozen");

		HashMap<Card, ImageView> Images = getCardImages();
		ArrayList<Card> cards = new ArrayList<Card>();
		ArrayList<ImageView> pics = new ArrayList<ImageView>();

		for (ArrayList<Card> pile : bd.getTableauPiles_List().values()) {
			for (int i = 0; i < 4; i++) {
				cards.add(pile.get(i));
			}
		}
		for (ImageView image : Images.values()) {
			image.setFitHeight(50);
			image.setFitWidth(40);
		}

		int cursor = 0;
		for (int x = 0; x < 13; x++) {
			if (cursor % 4 == 0) {
				HBox n = new HBox(10);
				for (int h = 0; h < cards.size(); h++) {
					for (Card c : Images.keySet()) {
						if (cards.get(h).toString().equals(c.toString())) {
							pics.add(Images.get(c));
						}
					}
				}
				List<ImageView> images = pics.subList(cursor, cursor + 4);
				for (int ind = 0; ind < 4; ind++) {

					n.getChildren().add(images.get(ind));
				}
				boxesforBD.add(n);
			}
			cursor += 4;
		}

		BackgroundFill fill = new BackgroundFill(Color.AQUA, null, null);
		Background background = new Background(fill);
		Rectangle test = new Rectangle(25, 40, Color.RED);
		Rectangle test2 = new Rectangle(25, 40, Color.BLACK);
		Rectangle test3 = new Rectangle(25, 40, Color.RED);
		Rectangle test4 = new Rectangle(25, 40, Color.BLACK);

		Label title = new Label("Baker's Dozen- to the DEATH");
		stackPane.setAlignment(title, Pos.TOP_CENTER);
		// Setting the font of the text
		title.setFont(Font.font(null, FontWeight.BOLD, 15));

		// Setting the color of the text
		title.setTextFill(Color.CRIMSON);

		GridPane gridpane = new GridPane();

		// gridpane grid layout..

		gridpane.setPadding(new Insets(40));
		gridpane.setHgap(20);
		gridpane.setVgap(20);
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth(12.5);
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setPercentWidth(12.5);
		ColumnConstraints column3 = new ColumnConstraints();
		column3.setPercentWidth(12.5);
		ColumnConstraints column4 = new ColumnConstraints();
		column4.setPercentWidth(12.5);
		ColumnConstraints column5 = new ColumnConstraints();
		column5.setPercentWidth(12.5);
		ColumnConstraints column6 = new ColumnConstraints();
		column6.setPercentWidth(12.5);
		ColumnConstraints column7 = new ColumnConstraints();
		column7.setPercentWidth(12.5);
		ColumnConstraints column8 = new ColumnConstraints();
		column8.setPercentWidth(12.5);
		gridpane.getColumnConstraints().addAll(column1, column2, column3, column4, column5, column6, column7, column8);

		RowConstraints row1 = new RowConstraints();
		row1.setPercentHeight(12.5);
		RowConstraints row2 = new RowConstraints();
		row2.setPercentHeight(12.5);
		RowConstraints row3 = new RowConstraints();
		row3.setPercentHeight(12.5);
		RowConstraints row4 = new RowConstraints();
		row4.setPercentHeight(12.5);
		RowConstraints row5 = new RowConstraints();
		row5.setPercentHeight(12.5);
		RowConstraints row6 = new RowConstraints();
		row5.setPercentHeight(12.5);
		RowConstraints row7 = new RowConstraints();
		row5.setPercentHeight(12.5);
		RowConstraints row8 = new RowConstraints();
		row5.setPercentHeight(12.5);
		gridpane.getRowConstraints().addAll(row1, row2, row3, row4, row5, row6, row7, row8);

		Label Lbl1 = new Label("Homecell Piles-^");
		Label Lbl2 = new Label("^- Tableau Piles -^");

		Button newGame = new Button("New Game");
		newGame.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				mediaPlayer.stop();
				restart("bakersdozen");
			}
		});

		Button quitNoD = new Button("Just Quit");
		quitNoD.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// Closes the application
				Platform.exit();
			}
		});

		// homecell pile locations

		gridpane.add(test, 1, 0);
		gridpane.add(test2, 2, 0);
		gridpane.add(test3, 3, 0);
		gridpane.add(test4, 4, 0);
		// tableau pile 1 location

		gridpane.add(boxesforBD.get(12), 6, 0);
		gridpane.add(boxesforBD.get(0), 1, 2);
		gridpane.add(boxesforBD.get(1), 1, 3);
		gridpane.add(boxesforBD.get(2), 1, 4);
		gridpane.add(boxesforBD.get(3), 1, 5);
		gridpane.add(boxesforBD.get(4), 3, 2);
		gridpane.add(boxesforBD.get(5), 3, 3);
		gridpane.add(boxesforBD.get(6), 3, 4);
		gridpane.add(boxesforBD.get(7), 3, 5);
		gridpane.add(boxesforBD.get(8), 5, 2);
		gridpane.add(boxesforBD.get(9), 5, 3);
		gridpane.add(boxesforBD.get(10), 5, 4);
		gridpane.add(boxesforBD.get(11), 5, 5);

		// Homecell and tableau Labels

		GridPane.setHalignment(Lbl2, HPos.CENTER);
		gridpane.add(Lbl1, 2, 1); // homecell
		gridpane.add(Lbl2, 3, 7); // tableau

		GridPane.setHalignment(newGame, HPos.CENTER);
		gridpane.add(newGame, 1, 8);

		GridPane.setHalignment(quitNoD, HPos.CENTER);
		gridpane.add(quitNoD, 4, 8);

		root.setCenter(gridpane);
		stackPane.setBackground(background);
		stackPane.getChildren().addAll(root, title, gridpane);
		Media sound = new Media("http://www.mfiles.co.uk/mp3-downloads/02.The%20calm%20sea%20floating%20mirage.mp3");
		playMusic(sound);

		return stackPane;
	}

	public StackPane startfreeCellGame() {

		StackPane stackPane = new StackPane();
		setCardImages("freecell");
		BorderPane root = new BorderPane();

		HashMap<Card, ImageView> Images = getCardImages();
		ArrayList<Card> cards = new ArrayList<Card>();
		ArrayList<ImageView> pics = new ArrayList<ImageView>();

		for (Integer pile : fc.getTableauMap().keySet()) {
			if (pile < 5) {
				for (int x = 0; x < 7; x++) {
					cards.add(fc.getTableauMap().get(pile).get(x));
				}
			} else {
				for (int ind = 0; ind < 6; ind++) {
					cards.add(fc.getTableauMap().get(pile).get(ind));
				}
			}
		}

		for (ImageView image : Images.values()) {
			image.setFitHeight(50);
			image.setFitWidth(40);
		}
		
		for (int size = 0; size < 52; size++) {
			for (Card c : Images.keySet()) {
				if (cards.get(size).toString().equals(c.toString())) {
					pics.add(Images.get(c));
				}
			}
		}
		
		int cursor = 0;
		for (int x = 0; x < 8; x++) {
			
			if (cursor % 7 == 0 && cursor < 28) {
				VBox box1 = new VBox(5);
				List<ImageView> images = pics.subList(cursor, cursor + 7);
				for (int ind = 0; ind < 7; ind++) {
					box1.getChildren().add(images.get(ind));
				}

				boxesforFC.add(box1);

				cursor += 7;
			} else if (cursor % 6 > 0 && cursor < 52) {
				VBox box1 = new VBox(5);
				List<ImageView> images = pics.subList(cursor, cursor + 6);
				for (int ind = 0; ind < 6; ind++) {
					box1.getChildren().add(images.get(ind));
				}
				boxesforFC.add(box1);
				cursor += 6;
			}

		}

		Rectangle r = new Rectangle(900, 500, Color.LIGHTGREEN);
		Rectangle fc1 = new Rectangle(25, 40, Color.RED);
		Rectangle fc2 = new Rectangle(25, 40, Color.RED);
		Rectangle fc3 = new Rectangle(25, 40, Color.RED);
		Rectangle fc4 = new Rectangle(25, 40, Color.RED);
		Rectangle hc1 = new Rectangle(25, 40, Color.YELLOW);
		Rectangle hc2 = new Rectangle(25, 40, Color.YELLOW);
		Rectangle hc3 = new Rectangle(25, 40, Color.YELLOW);
		Rectangle hc4 = new Rectangle(25, 40, Color.YELLOW);
		Rectangle t1 = new Rectangle(25, 40, Color.GREEN);
		Rectangle t2 = new Rectangle(25, 40, Color.RED);
		Rectangle t3 = new Rectangle(25, 40, Color.YELLOW);
		Rectangle t4 = new Rectangle(25, 40, Color.RED);
		Rectangle t5 = new Rectangle(25, 40, Color.YELLOW);
		Rectangle t6 = new Rectangle(25, 40, Color.RED);
		Rectangle t7 = new Rectangle(25, 40, Color.YELLOW);
		Rectangle t8 = new Rectangle(25, 40, Color.RED);

		Label title = new Label("Freecell- to the DEATH");
		stackPane.setAlignment(title, Pos.TOP_CENTER);
		// Setting the font of the text
		title.setFont(Font.font(null, FontWeight.BOLD, 15));

		// Setting the color of the text
		title.setTextFill(Color.CRIMSON);

		GridPane gridpane = new GridPane();

		ObservableList list = stackPane.getChildren();
		list.addAll(r, title, gridpane);

		// gridpane grid layout..

		gridpane.setPadding(new Insets(40));
		gridpane.setHgap(20);
		gridpane.setVgap(20);
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth(10);
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setPercentWidth(10);
		ColumnConstraints column3 = new ColumnConstraints();
		column3.setPercentWidth(10);
		ColumnConstraints column4 = new ColumnConstraints();
		column4.setPercentWidth(10);
		ColumnConstraints column5 = new ColumnConstraints();
		column5.setPercentWidth(10);
		ColumnConstraints column6 = new ColumnConstraints();
		column6.setPercentWidth(10);
		ColumnConstraints column7 = new ColumnConstraints();
		column7.setPercentWidth(10);
		ColumnConstraints column8 = new ColumnConstraints();
		column8.setPercentWidth(10);
		ColumnConstraints column9 = new ColumnConstraints();
		column9.setPercentWidth(10);
		ColumnConstraints column10 = new ColumnConstraints();
		column10.setPercentWidth(10);
		gridpane.getColumnConstraints().addAll(column1, column2, column3, column4, column5, column6, column7, column8);
		RowConstraints row1 = new RowConstraints();
		row1.setPercentHeight(12.5);
		RowConstraints row2 = new RowConstraints();
		row2.setPercentHeight(12.5);
		RowConstraints row3 = new RowConstraints();
		row3.setPercentHeight(12.5);
		RowConstraints row4 = new RowConstraints();
		row4.setPercentHeight(12.5);
		RowConstraints row5 = new RowConstraints();
		row5.setPercentHeight(12.5);
		RowConstraints row6 = new RowConstraints();
		row5.setPercentHeight(12.5);
		RowConstraints row7 = new RowConstraints();
		row5.setPercentHeight(12.5);
		RowConstraints row8 = new RowConstraints();
		row5.setPercentHeight(12.5);
		gridpane.getRowConstraints().addAll(row1, row2, row3, row4, row5, row6, row7, row8);

		Label Lbl1 = new Label("Homecell Piles-^");
		Label Lbl2 = new Label("^- Tableau Piles -^");

		Button newGame = new Button("New Game");
		newGame.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				mediaPlayer.stop();
				startfreeCellGame();
			}
		});
		Button quitWD = new Button("Quit with dignity");
		quitWD.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// Closes the application
				Platform.exit();
			}
		});
		Button quitNoD = new Button("Just Quit");
		quitNoD.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// Closes the application
				Platform.exit();
			}
		});
		// homecell pile locations
		gridpane.add(fc1, 1, 0);
		gridpane.add(fc2, 2, 0);
		gridpane.add(fc3, 3, 0);
		gridpane.add(fc4, 4, 0);
		// tableau pile 1 location
		gridpane.add(hc1, 6, 0);
		gridpane.add(hc2, 7, 0);
		gridpane.add(hc3, 8, 0);
		gridpane.add(hc4, 9, 0);

		gridpane.add(boxesforFC.get(0), 1, 3);
		gridpane.add(boxesforFC.get(1), 2, 3);
		gridpane.add(boxesforFC.get(2), 3, 3);
		gridpane.add(boxesforFC.get(3), 4, 3);
		gridpane.add(boxesforFC.get(4), 5, 3);
		gridpane.add(boxesforFC.get(5), 6, 3);
		gridpane.add(boxesforFC.get(6), 7, 3);
		gridpane.add(boxesforFC.get(7), 8, 3);

		// Homecell and tableau Labels

		GridPane.setHalignment(Lbl2, HPos.CENTER);
		gridpane.add(Lbl1, 2, 1); // homecell
		gridpane.add(Lbl2, 3, 7); // tableau

		GridPane.setHalignment(newGame, HPos.CENTER);
		gridpane.add(newGame, 1, 8);
		GridPane.setHalignment(quitWD, HPos.LEFT);
		gridpane.add(quitWD, 4, 8);
		GridPane.setHalignment(quitNoD, HPos.CENTER);
		gridpane.add(quitNoD, 7, 8);

		root.setCenter(gridpane);
		stackPane.getChildren().add(root);

		Media sound = new Media("http://www.mfiles.co.uk/mp3-downloads/02.The%20calm%20sea%20floating%20mirage.mp3");
		playMusic(sound);

		return stackPane;
	}

	public void playMusic(Media song) {
		mediaPlayer = new MediaPlayer(song);
		mediaPlayer.setOnEndOfMedia(new Runnable() {
			@Override
			public void run() {
				mediaPlayer.seek(Duration.ZERO);
				mediaPlayer.play();
			}
		});
	}

	public void restart(String game) {
		getCardImages().clear();
		if (game.equals("bakersdozen")) {
			startBakersDozenGame();
		} else if (game.equals("freecell")) {
			startfreeCellGame();
		}

	}

	public static void main(String[] args) {

	}
}

