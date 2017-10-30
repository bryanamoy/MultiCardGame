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
	private ArrayList<StackPane> stacksforBD = new ArrayList<StackPane>();
	private ArrayList<StackPane> boxesforFC = new ArrayList<StackPane>();

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

	public ArrayList<StackPane> getStackforBD() {
		return stacksforBD;
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

	public BorderPane startBakersDozenGame() {
		
		BorderPane window = new BorderPane();
		setCardImages("bakersdozen");
		
		VBox box1 = new VBox();
		VBox box2 = new VBox();
		VBox box3 = new VBox();
		
		HBox mainhbox = new HBox();
		
		StackPane stack = new StackPane();
		StackPane stack2 = new StackPane();
		StackPane stack3 = new StackPane();
		StackPane stack4 = new StackPane();
		StackPane stack5 = new StackPane();
		
		
		HashMap<Card, ImageView> Images = getCardImages();
		ArrayList<Card> cards = new ArrayList<Card>();
		ArrayList<ImageView> pics = new ArrayList<ImageView>();

		for (ArrayList<Card> pile : bd.getTableauPiles_List().values()) {
			for (int i = 0; i < 4; i++) {
				cards.add(pile.get(i));
			}
		}
		for (ImageView image : Images.values()) {
			image.setFitHeight(80);
			image.setFitWidth(50);
			
		}

		int cursor = 0;
		for (int x = 0; x < 13; x++) {
			if (cursor % 4 == 0) {
				StackPane  n = new StackPane();
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
				stacksforBD.add(n);
			}
			cursor += 4;
		}

		BackgroundFill fill = new BackgroundFill(Color.AQUA, null, null);
		Background background = new Background(fill);
		Rectangle test = new Rectangle(50, 80, Color.RED);
		Rectangle test2 = new Rectangle(50, 80, Color.BLACK);
		Rectangle test3 = new Rectangle(50, 80, Color.RED);
		Rectangle test4 = new Rectangle(50, 80, Color.BLACK);

		Label title = new Label("Baker's Dozen- to the DEATH");
		window.setAlignment(title, Pos.TOP_CENTER);
		// Setting the font of the text
		title.setFont(Font.font(null, FontWeight.BOLD, 15));

		// Setting the color of the text
		title.setTextFill(Color.CRIMSON);
		// gridpane grid layout..

		box1.getChildren().addAll(stacksforBD.get(0),stacksforBD.get(1),stacksforBD.get(2),stacksforBD.get(3));
		box2.getChildren().addAll(stacksforBD.get(4),stacksforBD.get(5),stacksforBD.get(6),stacksforBD.get(7));
		box3.getChildren().addAll(stacksforBD.get(8),stacksforBD.get(9),stacksforBD.get(10),stacksforBD.get(11));
		
		
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
		stack.getChildren().add(test);
		stack2.getChildren().add(test2);
		stack3.getChildren().add(test3);
		stack4.getChildren().add(test4);
		stack5.getChildren().add(stacksforBD.get(12));
		
		
		mainhbox.getChildren().addAll(stack,stack2,stack3,stack4,stack5);
	
		window.setTop(mainhbox);
		window.setAlignment(newGame, Pos.BOTTOM_LEFT);
		window.setAlignment(quitNoD, Pos.BOTTOM_RIGHT);
		window.setLeft(box1);
		window.setCenter(box2);
		window.setRight(box3);
		
		window.setBackground(background);
		
		Media sound = new Media("http://www.mfiles.co.uk/mp3-downloads/02.The%20calm%20sea%20floating%20mirage.mp3");
		playMusic(sound);

		return window;
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
			image.setFitHeight(60);
			image.setFitWidth(45);
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
			HBox box = new HBox();
			
			if (cursor % 7 == 0 && cursor < 28) {
				
				List<ImageView> images = pics.subList(cursor, cursor + 7);
				for (int ind = 0; ind < 7; ind++) {
					box.getChildren().add(images.get(ind));
					
				}
			
				boxesforFC.add(box);
				cursor += 7;
			} 
			else if (cursor % 6 > 0 && cursor < 52) {
				
				List<ImageView> images = pics.subList(cursor, cursor + 6);
				for (int ind = 0; ind < 6; ind++) {
					box.getChildren().add(images.get(ind));
					
				}
			
				boxesforFC.add(box);
				cursor += 6;
			}
		}
	       
	       
		BackgroundFill fill = new BackgroundFill(Color.LIGHTGREEN, null, null);
		Background background = new Background(fill);
		
		Rectangle fc1 = new Rectangle(25, 40, Color.RED);
		Rectangle fc2 = new Rectangle(25, 40, Color.RED);
		Rectangle fc3 = new Rectangle(25, 40, Color.RED);
		Rectangle fc4 = new Rectangle(25, 40, Color.RED);
		Rectangle hc1 = new Rectangle(25, 40, Color.YELLOW);
		Rectangle hc2 = new Rectangle(25, 40, Color.YELLOW);
		Rectangle hc3 = new Rectangle(25, 40, Color.YELLOW);
		Rectangle hc4 = new Rectangle(25, 40, Color.YELLOW);

		Label title = new Label("Freecell- to the DEATH");
		stackPane.setAlignment(title, Pos.TOP_CENTER);
		// Setting the font of the text
		title.setFont(Font.font(null, FontWeight.BOLD, 15));

		// Setting the color of the text
		title.setTextFill(Color.CRIMSON);

		GridPane gridpane = new GridPane();

		// gridpane grid layout..

		gridpane.setPadding(new Insets(50));
		gridpane.setHgap(25);
		gridpane.setVgap(25);
		
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
		row6.setPercentHeight(12.5);
		RowConstraints row7 = new RowConstraints();
		row7.setPercentHeight(12.5);
		RowConstraints row8 = new RowConstraints();
		row8.setPercentHeight(12.5);
		gridpane.getRowConstraints().addAll(row1, row2, row3, row4, row5, row6, row7, row8);

	
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
		
		// homecell pile locations
		gridpane.add(fc1, 2, 0);
		gridpane.add(fc2, 3, 0);
		gridpane.add(fc3, 4, 0);
		gridpane.add(fc4, 5, 0);
		
		// tableau pile 1 location
		gridpane.add(hc1, 2, 1);
		gridpane.add(hc2, 3, 1);
		gridpane.add(hc3, 4, 1);
		gridpane.add(hc4, 5, 1);

		gridpane.add(boxesforFC.get(0), 2, 2);
		gridpane.add(boxesforFC.get(1), 2, 3);
		gridpane.add(boxesforFC.get(2), 2, 4);
		gridpane.add(boxesforFC.get(3), 2, 5);
		gridpane.add(boxesforFC.get(4), 4, 2);
		gridpane.add(boxesforFC.get(5), 4, 3);
		gridpane.add(boxesforFC.get(6), 4, 4);
		gridpane.add(boxesforFC.get(7), 4, 5);

		// Homecell and tableau Labels

		GridPane.setHalignment(newGame, HPos.CENTER);
		gridpane.add(newGame, 1, 8);
		GridPane.setHalignment(quitWD, HPos.LEFT);
		gridpane.add(quitWD, 4, 8);

		root.setCenter(gridpane);
		stackPane.setBackground(background);
		stackPane.getChildren().addAll(root,gridpane);

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
