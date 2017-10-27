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

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

public class SolitaireView {

	// private Card card;
	private HashMap<Card, ImageView> cardImages = new HashMap<Card, ImageView>();
	private ArrayList<Card> cards = new ArrayList<Card>();
	private BakersDozen bd;
	private Freecell fc;
	private MediaPlayer mediaPlayer;
	private StackPane stackPane = new StackPane();
	
	
	public SolitaireView()  {
		
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
	
	public MediaPlayer getMediaPlayer() {
		return mediaPlayer;
	}

	public StackPane  startbdGame() {
		
		stackPane = new StackPane();
    	BorderPane root = new BorderPane();
    	Rectangle r = new Rectangle(900, 500, Color.AQUA);
    	Rectangle test = new Rectangle(25,40, Color.RED);
    	Rectangle test2 = new Rectangle(25,40, Color.YELLOW);
    	Rectangle test3 = new Rectangle(25,40, Color.RED);
    	Rectangle test4 = new Rectangle(25,40, Color.YELLOW);
    	Rectangle test6 = new Rectangle(25,40, Color.GREEN);
    	Rectangle t2 = new Rectangle(25,40, Color.RED);
    	Rectangle t3 = new Rectangle(25,40, Color.YELLOW);
    	Rectangle t4 = new Rectangle(25,40, Color.RED);
    	Rectangle t5 = new Rectangle(25,40, Color.YELLOW);
    	Rectangle t6 = new Rectangle(25,40, Color.RED);
    	Rectangle t7 = new Rectangle(25,40, Color.YELLOW);
    	Rectangle t8 = new Rectangle(25,40, Color.RED);
    	Rectangle t9 = new Rectangle(25,40, Color.YELLOW);
    	Rectangle t10 = new Rectangle(25,40, Color.RED);
    	Rectangle t11 = new Rectangle(25,40, Color.YELLOW);
    	Rectangle t12 = new Rectangle(25,40, Color.RED);
    	Rectangle t13 = new Rectangle(25,40, Color.YELLOW);
    	
    	Label title = new Label("Baker's Dozen- to the DEATH");
    	stackPane.setAlignment(title, Pos.TOP_CENTER);
    	//Setting the font of the text 
        title.setFont(Font.font(null, FontWeight.BOLD, 15));     
        
        //Setting the color of the text 
        title.setTextFill(Color.CRIMSON); 
        
        GridPane gridpane = new GridPane();
        
    	ObservableList list = stackPane.getChildren(); 
		list.addAll(r, title, gridpane);
		
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
	     gridpane.getColumnConstraints().addAll(column1, column2, column3, column4,column5,column6,column7,column8);
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
	     gridpane.getRowConstraints().addAll(row1, row2, row3, row4,row5,row6,row7,row8);
	     
	    Label Lbl1 = new Label("Homecell Piles-^");
	    Label Lbl2 = new Label("^- Tableau Piles -^");
	    
	    Button newGame = new Button("New Game");
	    newGame.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	mediaPlayer.stop();
		    	startbdGame();
		    }
		});
	    Button quitWD = new Button("Quit with dignity");
	    quitWD.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	//Closes the application
		    	Platform.exit();
		    }
		});
	    Button quitNoD = new Button("Just Quit");
	    quitNoD.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	//Closes the application
		    	Platform.exit();
		    }
		});
	   // homecell pile locations
	    gridpane.add(test, 1, 0);
	    gridpane.add(test2, 2, 0);
	    gridpane.add(test3, 3, 0);
	    gridpane.add(test4, 4, 0);
	   // tableau pile 1 location
	    gridpane.add(test6, 6, 0);
	    
	    gridpane.add(t2, 3, 3);
	    gridpane.add(t3, 3, 2);
	    gridpane.add(t4, 3, 4);
	    gridpane.add(t5, 3, 6);
	    gridpane.add(t6, 4, 3);
	    gridpane.add(t7, 4, 2);
	    gridpane.add(t8, 4, 4);
	    gridpane.add(t9, 4, 6);
	    gridpane.add(t10, 5, 3);
	    gridpane.add(t11, 5, 2);
	    gridpane.add(t12, 5, 4);
	    gridpane.add(t13, 5, 6);
	    
	   // Homecell and tableau Labels
	    
	    GridPane.setHalignment(Lbl2, HPos.CENTER);
	    gridpane.add(Lbl1, 2, 1); //homecell
	    gridpane.add(Lbl2, 3, 7); //tableau
	 
	    GridPane.setHalignment(newGame, HPos.CENTER);
		gridpane.add(newGame, 1, 8);
		GridPane.setHalignment(quitWD, HPos.LEFT);
		gridpane.add(quitWD, 4, 8);
		GridPane.setHalignment(quitNoD, HPos.CENTER);
		gridpane.add(quitNoD, 7, 8);
		
		root.setCenter(gridpane);
		stackPane.getChildren().add(root);
	
		Media sound = new Media("http://www.mfiles.co.uk/mp3-downloads/02.The%20calm%20sea%20floating%20mirage.mp3");
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setOnEndOfMedia(new Runnable() {
			@Override public void run() {
		         mediaPlayer.seek(Duration.ZERO);
		       }
		});
		mediaPlayer.play(); 
		
		return stackPane;
	}
	
	
	

	public void playMusic(Media song){
		mediaPlayer = new MediaPlayer(song);
		mediaPlayer.setOnEndOfMedia(new Runnable() {
			@Override public void run() {
				mediaPlayer.seek(Duration.ZERO);
				mediaPlayer.play();
			}
		});
		
		
	}
	
	
	

	public static void main(String[] args) {

	}
}
