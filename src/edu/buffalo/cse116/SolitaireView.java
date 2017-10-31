
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
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
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
/**
 * <h1>SolitaireView class</h1>
 * <p>
 * <b>Note:</b> This is the View part of Model-View-Controller, it handles
 * the visual aspects of the game.
 * @author Mike Nicholas & Johnathan Hercules
 * @since 2017-10-30
 */
public class SolitaireView {
	/**
 * HashMap for cardImages. Contains the images for the cards.
 */
	private HashMap<Card, ImageView> cardImages = new HashMap<Card, ImageView>();
	/**
	 * ArrayList for the cards.
	 */

	private ArrayList<Card> cards = new ArrayList<Card>();
	/**
	 * Baker's Dozen game instance, holds functions
	 */
	private BakersDozen bd;
	/**
	 * Freecell game instance, holds functions
	 */
	private Freecell fc;
	/**
	 * ArrayList for Stack Panes in Baker's Dozen game.
	 */
	private ArrayList<StackPane> stacksforBD = new ArrayList<StackPane>();
	/**
	 * ArrayList for Stack Panes in Baker's Dozen HBox's.
	 */
	private ArrayList<StackPane> stacksforBDHbox = new ArrayList<StackPane>();
	private ArrayList<StackPane> stacksforFC = new ArrayList<StackPane>();
	private ArrayList<StackPane> stacksforFCHbox = new ArrayList<StackPane>();
	/**
	 * A getter for the ArrayList of cards.
	 * @return cards
	 */
	public ArrayList<Card> getCards() {
		return cards;
	}
	/**
	 * A setter for the ArrayList of cards
	 * @param cards
	 */
	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	/**
	 * A getter for the Stack Panes in HBox's for Baker's Dozen
	 * @return stacksforBDHbox
	 */
	public ArrayList<StackPane> getStacksforBDHbox() {
		return stacksforBDHbox;
	}
	/**
	 * A setter for the Stack Panes 
	 * @param stacksforBDHbox
	 */
	public void setStacksforBDHbox(ArrayList<StackPane> stacksforBDHbox) {
		this.stacksforBDHbox = stacksforBDHbox;
	}


	public SolitaireView() {

	}
	/**
 * A setter for the Hashmap of cards and their images for both Baker's Dozen and Freecell game.  It links the card to it's image.
 * Obtains image of card from the "moderncards" folder which holds each 
 * cards image.
 * 
 * @param game
 * @return cardImages
 */
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
	/**
 * 
 * A getter for Card Images
 * 
 * @return cardImages
 */
	public HashMap<Card, ImageView> getCardImages() {
		return cardImages;
	}
	/**
 * A getter for the stack panes in the Baker's Dozen game
 * 
 * @return stacksforBD
 */
	public ArrayList<StackPane> getStacksforBD() {
		return stacksforBD;
	}
	/**
 * A setter for Stack Panes in Baker's Dozen game
 * 
 * @param stacksforBD
 */
	public void setStacksforBD(ArrayList<StackPane> stacksforBD) {
		this.stacksforBD = stacksforBD;
	}
	/**
 * A getter for Stack Panes in Freecell game
 * 
 * @return stacksforFC
 */	
	public ArrayList<StackPane> getStacksforFC() {
		return stacksforFC;
	}
	/**
 * A setter for Stack Panes in Freecell game
 * 
 * @param stacksforFC
 */
	public void setStacksforFC(ArrayList<StackPane> stacksforFC) {
		this.stacksforFC = stacksforFC;
	}

	/**
 * A getter for ImageView of card for a card. It returns the card image linked to it's card.
 * 
 * @param c
 * @return rtn
 */
	public ImageView getImageViewOfCard(Card c) {
		ImageView rtn = null;

		for (Card check : getCardImages().keySet()) {
			if (check.toString().equals(c.toString())) {
				rtn = getCardImages().get(check);

			}
		}
		return rtn;

	}

	/**
 * Sets up the interface for the Baker's Dozen game. 3 VBox's are displayed as the 3 columns in the Baker's Dozen view. 
 * 12 Tableau Piles are displayed here.  StackPanes are created to hold the cards for each pile.  Also, the labels for each
 * type of pile are created.  Depending on Freecell or Baker's Dozen, there is a different background for each game type.
 * 
 * @return window
 */
	public BorderPane startBakersDozenGame() {
		
		BorderPane window = new BorderPane();
		setCardImages("bakersdozen");
		
		VBox box1 = new VBox();
		VBox box2 = new VBox();
		VBox box3 = new VBox();
		
		HBox mainhbox = new HBox(20);
		
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
		
		stacksforBDHbox.add(stack);
		stacksforBDHbox.add(stack2);
		stacksforBDHbox.add(stack3);
		stacksforBDHbox.add(stack4);
		stacksforBDHbox.add(stack5);
		
		
		mainhbox.getChildren().addAll(stack,stack2,stack3,stack4,stack5);
	
		window.setTop(mainhbox);
		window.setMargin(mainhbox, new Insets(0,0,0,300));
		window.setLeft(box1);
		window.setMargin(box1, new Insets(20,0,0,250));
		window.setCenter(box2);
		window.setMargin(box2, new Insets(20,0,0,0));
		window.setRight(box3);
		window.setMargin(box3, new Insets(20,250,0,0));
		
		window.setBackground(background);
		Media sound = new Media("http://www.mfiles.co.uk/mp3-downloads/gabriels-message-keyboard.mp3");
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setOnEndOfMedia(new Runnable() {
			@Override public void run() {
				mediaPlayer.seek(Duration.ZERO);
			}
		});
		mediaPlayer.play();
		return window;
	}




/**
 * The interface for the Freecell Game is created.  BorderPane is used to display the whole interface.  
 * MediaPlayer is implemented to play a different song for this game mode. For each type of pile they are displayed
 * as Stack Panes for the ability to stack the cards on top of each other.  In addition, the event handlers for clicking the buttons
 * within the interface is implemented to handle an event of clicking the a menu option.
 * 
 * @return window
 */
	public BorderPane startfreeCellGame() {

	
		setCardImages("freecell");
		BorderPane window = new BorderPane();
		
		HBox hbox1 = new HBox(10);
		HBox hbox2 = new HBox(10);
		
		StackPane stack1 = new StackPane();
		StackPane stack2 = new StackPane();
		StackPane stack3 = new StackPane();
		StackPane stack4 = new StackPane();
		StackPane stack5 = new StackPane();
		StackPane stack6 = new StackPane();
		StackPane stack7 = new StackPane();
		StackPane stack8 = new StackPane();
		
		HBox vbox = new HBox(25);
		VBox v1 = new VBox();
		VBox v2 = new VBox();
		VBox v3 = new VBox();
		VBox v4 = new VBox();
		VBox v5 = new VBox();
		VBox v6 = new VBox();
		VBox v7 = new VBox();
		VBox v8 = new VBox();
		
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
			StackPane box = new StackPane();
			
			if (cursor % 7 == 0 && cursor < 28) {
				
				List<ImageView> images = pics.subList(cursor, cursor + 7);
				for (int ind = 0; ind < 7; ind++) {
					box.getChildren().add(images.get(ind));
					
				}
			
				stacksforFC.add(box);
				cursor += 7;
			} 
			else if (cursor % 6 > 0 && cursor < 52) {
				
				List<ImageView> images = pics.subList(cursor, cursor + 6);
				for (int ind = 0; ind < 6; ind++) {
					box.getChildren().add(images.get(ind));
					
				}
			
				stacksforFC.add(box);
				cursor += 6;
			}
		}
	      
		v1.getChildren().add(stacksforFC.get(0));
		v2.getChildren().add(stacksforFC.get(1));
		v3.getChildren().add(stacksforFC.get(2));
		v4.getChildren().add(stacksforFC.get(3));
		v5.getChildren().add(stacksforFC.get(4));
		v6.getChildren().add(stacksforFC.get(5));
		v7.getChildren().add(stacksforFC.get(6));
		v8.getChildren().add(stacksforFC.get(7));
	       
		BackgroundFill fill = new BackgroundFill(Color.LIGHTGREEN, null, null);
		Background background = new Background(fill);
		
		Rectangle fc1 = new Rectangle(40, 60, Color.RED);
		Rectangle fc2 = new Rectangle(40, 60, Color.RED);
		Rectangle fc3 = new Rectangle(40, 60, Color.RED);
		Rectangle fc4 = new Rectangle(40, 60, Color.RED);
		Rectangle hc1 = new Rectangle(40, 60, Color.YELLOW);
		Rectangle hc2 = new Rectangle(40, 60, Color.YELLOW);
		Rectangle hc3 = new Rectangle(40, 60, Color.YELLOW);
		Rectangle hc4 = new Rectangle(40, 60, Color.YELLOW);

		stack1.getChildren().add(hc1);
		stack2.getChildren().add(hc2);
		stack3.getChildren().add(hc3);
		stack4.getChildren().add(hc4);
		stack5.getChildren().add(fc1);
		stack6.getChildren().add(fc2);
		stack7.getChildren().add(fc3);
		stack8.getChildren().add(fc4);
		
		stacksforFCHbox.add(stack1);
		stacksforFCHbox.add(stack2);
		stacksforFCHbox.add(stack3);
		stacksforFCHbox.add(stack4);
		stacksforFCHbox.add(stack5);
		stacksforFCHbox.add(stack6);
		stacksforFCHbox.add(stack7);
		stacksforFCHbox.add(stack8);;
		
		Label title = new Label("Freecell- to the DEATH");
		window.setAlignment(title, Pos.TOP_CENTER);
		// Setting the font of the text
		title.setFont(Font.font(null, FontWeight.BOLD, 15));

		// Setting the color of the text
		title.setTextFill(Color.CRIMSON);

		// gridpane grid layout..

		Button newGame = new Button("New Game");
		newGame.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				
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
		HBox main = new HBox(20);
		hbox1.getChildren().addAll(stack1,stack2,stack3,stack4);
		hbox2.getChildren().addAll(stack5,stack6,stack7,stack8);
		main.getChildren().addAll(hbox1,hbox2);
		
		
		window.setTop(main);
		window.setMargin(main, new Insets(50,0,0,300));
		vbox.getChildren().addAll(v1,v2,v3,v4,v5,v6,v7,v8);
		window.setCenter(vbox);
		window.setMargin(vbox, new Insets(100,300,0,250));
	
		window.setBackground(background);
	

		Media sound = new Media("http://www.mfiles.co.uk/mp3-downloads/gabriels-message-keyboard.mp3");
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setOnEndOfMedia(new Runnable() {
			@Override public void run() {
				mediaPlayer.seek(Duration.ZERO);
			}
		});
		mediaPlayer.play();

		return  window;
	}

	/**
	 * Easter Egg. Somewhat lame.
	 */
	
	public StackPane startEE() {
		StackPane stackPane = new StackPane();
		BorderPane root = new BorderPane();
		
		BackgroundFill fill = new BackgroundFill(Color.RED, null, null);
		Background background = new Background(fill);
	    
	    Button button1 = new Button("Click Me!!!");
	    
	    button1.setStyle("-fx-font: 5 arial; -fx-base: #b6e7c9;");
	    button1.setOnAction(new EventHandler<ActionEvent>() {
	        @Override public void handle(ActionEvent e) {
	        	
	        	BackgroundImage myBI= new BackgroundImage(new Image("http://www-cs.canisius.edu/PICTURES/FACULTY_STAFF/small_hertz.jpg",700,700,false,true),BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
	        	          BackgroundSize.DEFAULT);
	        	stackPane.setBackground(new Background(myBI));
//	        	
//	        	Button button2 = new Button("Back");
//	        	button2.setStyle("-fx-font: 15 arial; -fx-base: #b6e7c9;");
	      
	        	}
	        });
	    
    	
	    VBox headerGraphic = new VBox();  
	    headerGraphic.setAlignment(Pos.BOTTOM_CENTER);
	    headerGraphic.getChildren().addAll(button1);
	    
		stackPane.setBackground(background);
		stackPane.getChildren().addAll(root, headerGraphic);
		return stackPane;
	        
	}	
	
	
/**
 * This method resets the game.  If the current game is Baker's Dozen then it restarts a new game of Baker's Dozen, else if current game is Freecell
 * then a new instance of Freecell game is created.
 * 
 * @param game
 */
	public void restart(String game) {
		getCardImages().clear();
		if (game.equals("bakersdozen")) {
			startBakersDozenGame();
		} else if (game.equals("freecell")) {
			startfreeCellGame();
		}
	}

/**
 * Method enabling code to run.
 * @param args
 */
	public static void main(String[] args) {

	}
}

