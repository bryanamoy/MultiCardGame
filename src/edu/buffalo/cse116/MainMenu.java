package edu.buffalo.cse116;

import java.util.List;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.application.Application;
import javafx.application.Platform;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Skinnable;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * Make a Gui class using the classes I made. 
 * 
 * End Result: Use the launch method within Main.java.
 * @author coreyalm
 * 
 * TODO:Draw a rectangle above the background color and put a black circle above rectangle FINISHED
 * TODO: Click button to switch to a different scene.
 * 
 * Defines a GUI application that includes the New Game menu with menu items to ... 
 * start a game of Freecell, 
 * start a game of Baker's Dozen, 
 * and Exit
 * 
 */
public class MainMenu extends Application {

	private double mainWidth = 900;
	private double mainHeight = 500;
	
	private Stage stage;
//	private static MediaPlayer mediaPlayer;

	//All gui code can be done within the start method
	@Override
	public void start(Stage mainWindow) throws Exception {

		stage = mainWindow;

		Text text = new Text("Solitaire!");
		text.setFont(Font.font ("Verdana", 150));
		text.setFill(Color.ALICEBLUE);//
		
//		Image image = new Image("http://i0.kym-cdn.com/photos/images/original/001/169/608/a43.gif", true);  								
//		ImageView imageView = new ImageView(image);			
//		imageView.setPreserveRatio(true);  
//		imageView.fitWidthProperty().bind(mainWindow.widthProperty()); 

//		Media sound = new Media("https://www.mfiles.co.uk/mp3-downloads/gabriels-message-keyboard.mp3");
//		mediaPlayer = new MediaPlayer(sound);
//		mediaPlayer.setOnEndOfMedia(new Runnable() {
//			@Override public void run() {
//				mediaPlayer.seek(Duration.ZERO);
//			}
//		});
//		mediaPlayer.play();

		BorderPane borderPane = new BorderPane();
		SolitaireView solitaireView = new SolitaireView();
		solitaireView.setCardImages();
		
		borderPane.getChildren().add(solitaireView.getCardImages().get(new Card(Suit.CLUBS,Rank.ACE)));

		MenuItem bdMenuItm = new MenuItem("Baker's Dozen");
		bdMenuItm.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
//		    	mediaPlayer.stop();
		    	bakersDozenGame();
		    }
		});
		
		MenuItem fcMenuItm = new MenuItem("Freecell");
		fcMenuItm.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	Freecell fc = new Freecell(8, 4, 4);
		    	fc.initialSetup();
		    }
		});
		
		MenuItem quitMenuItm = new MenuItem("Quit");
		quitMenuItm.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	//Closes the application
		    	Platform.exit();
		    }
		});

		Menu menu = new Menu("New Game");
		menu.getItems().addAll(bdMenuItm, fcMenuItm, quitMenuItm);
		MenuBar menuBar = new MenuBar(menu);
		menuBar.setPrefHeight(30);
		menuBar.prefWidthProperty().bind(mainWindow.widthProperty());

		borderPane.setCenter(text);
		borderPane.setBottom(menuBar);
		
		//Prepare a Scene with the required dimensions and add the scene graph (root node of the scene graph) to it.
		//This is basically the inside window.
		//Each scene object can only have one root node.
		Scene scene = new Scene(borderPane, mainWidth, mainHeight);  //, mainWidth, mainHeight);


		//A window		
		mainWindow.setTitle("Solitaire.exe");

		//Add the scene to the stage and display the contents of the stage.		
		mainWindow.setScene(scene);

		//Actually displays the contents
		mainWindow.show();	




		//Stage				 The window (BOOK)
		//Scene				 The space within the window (like a pane). (A PAGE) 
		//					 This is supposed to be like an area within the application.
		//Root Node			 The thing to hold all of the scene graphs (The stuff that holds all of the stuff in the page)
		//Scene graph(nodes) The stuff inside the scene(buttons, color, shape and other stuff) (THE STUFF WITHIN THE PAGE)
	}

	private void bakersDozenGame() {
    	StackPane stackPane = new StackPane();
    	changeScene(stackPane); 
    	    	   	
//		Media sound = new Media("https://www.mfiles.co.uk/mp3-downloads/02.The%20calm%20sea%20floating%20mirage.mp3");
//		mediaPlayer = new MediaPlayer(sound);
//		mediaPlayer.setOnEndOfMedia(new Runnable() {
//			@Override public void run() {
//		         mediaPlayer.seek(Duration.ZERO);
//		       }
//		});
//		mediaPlayer.play(); 
		
		BakersDozen bd = new BakersDozen();
    	bd.initialSetup();
	}
	
	
	private Boolean changeScene(Pane pane){
		stage.getScene().setRoot(pane);
		if(pane == stage.getScene().getRoot()) {
			return true;
		}
		return false;
	}
	
	
	
	

	//stop() -An empty method which can be overridden, here you can write the logic to stop the application. So like when I want
	//to exit the game.

	//init() - An empty method which can be overridden, but you cannot create stage or scene in this method. Place to hold code 
	//before the start() method

	public static void main(String args[]){           
		/**
		 *      ---------APPLICATION LIFE CYCLE---------
		 *       Constructs an instance of the specified Application class
				 Calls the init() method
				 Calls the start(javafx.stage.Stage) method
				 Waits for the application to finish, which happens when either of the following occur:
				 	the application calls Platform.exit()
					the last window has been closed and the implicitExit attribute on Platform is true
				 Calls the stop() method
		 */

		/**
		 * 	
		 * 			PANE LAYERING
		Pane layer1 = new Pane();
		Rectangle rect = new Rectangle(45, 42, Color.BLUE);
		layer1.getChildren().add(rect);

		Pane layer2 = new Pane();
		Circle circle = new Circle(30, 20, 10, Color.BLACK);
		layer2.getChildren().add(circle);

		//TODO: Replace with addAll method once figured out layering. 
		//Layering occurs like this: index 0 = bottom layer, index 1 = top layer.
		basePane.getChildren().add(layer1);
		basePane.getChildren().add(layer2);

		 */	

		//Implicitly calls start()
		launch(args);      
	} 
}
