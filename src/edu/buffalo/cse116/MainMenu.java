package edu.buffalo.cse116;

import java.util.List;

import javax.swing.ImageIcon;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.application.Application;
import javafx.application.Platform;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Skinnable;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
	private static MediaPlayer mediaPlayer;

	//All gui code can be done within the start method
	@Override
	public void start(Stage mainWindow) throws Exception {

		stage = mainWindow;

		Text text = new Text("Solitaire!");
		text.setFont(Font.font ("Verdana", 150));
		text.setFill(Color.ALICEBLUE);//
		
	Image image = new Image("http://i0.kym-cdn.com/photos/images/original/001/169/608/a43.gif", true);  								
		ImageView imageView = new ImageView(image);			
		imageView.setPreserveRatio(true);  
		imageView.fitWidthProperty().bind(mainWindow.widthProperty()); 

		Media sound = new Media("https://www.mfiles.co.uk/mp3-downloads/gabriels-message-keyboard.mp3");
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setOnEndOfMedia(new Runnable() {
			@Override public void run() {
				mediaPlayer.seek(Duration.ZERO);
			}
		});
		mediaPlayer.play();

		BorderPane borderPane = new BorderPane();
		borderPane.getChildren().add(imageView);
//		SolitaireView solitaireView = new SolitaireView();
//		solitaireView.setCardImages();
		
//		borderPane.getChildren().add(solitaireView.getCardImages().get(new Card(Suit.CLUBS,Rank.ACE)));

		MenuItem bdMenuItm = new MenuItem("Baker's Dozen");
		bdMenuItm.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	mediaPlayer.stop();
		    	bakersDozenGame();
		    }
		});
		
		MenuItem fcMenuItm = new MenuItem("Freecell");
		fcMenuItm.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	mediaPlayer.stop();
		    	Freecell fc = new Freecell(8, 4, 4);
		    	fc.initialSetup();
		    	freeCellGame();
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
    	Image ace = new Image("file:CLUBSACE.png");
    	
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
		    	bakersDozenGame();
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
	
		Media sound = new Media("https://www.mfiles.co.uk/mp3-downloads/02.The%20calm%20sea%20floating%20mirage.mp3");
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setOnEndOfMedia(new Runnable() {
			@Override public void run() {
		         mediaPlayer.seek(Duration.ZERO);
		       }
		});
		mediaPlayer.play(); 
		
		BakersDozen bd = new BakersDozen();
    	bd.initialSetup();
	}
	
	public void freeCellGame(){
		
		StackPane stackPane = new StackPane();
    	changeScene(stackPane); 
    	Image ace = new Image("file:CLUBSACE.png");
    	
    	BorderPane root = new BorderPane();
    	Rectangle r = new Rectangle(900, 500, Color.LIGHTGREEN);
    	
    	Rectangle fc1 = new Rectangle(25,40, Color.RED);
    	Rectangle fc2 = new Rectangle(25,40, Color.RED);
    	Rectangle fc3 = new Rectangle(25,40, Color.RED);
    	Rectangle fc4 = new Rectangle(25,40, Color.RED);
    	Rectangle hc1 = new Rectangle(25,40, Color.YELLOW);
    	Rectangle hc2 = new Rectangle(25,40, Color.YELLOW);
    	Rectangle hc3 = new Rectangle(25,40, Color.YELLOW);
    	Rectangle hc4 = new Rectangle(25,40, Color.YELLOW);
    	Rectangle t1 = new Rectangle(25,40, Color.GREEN);
    	Rectangle t2 = new Rectangle(25,40, Color.RED);
    	Rectangle t3 = new Rectangle(25,40, Color.YELLOW);
    	Rectangle t4 = new Rectangle(25,40, Color.RED);
    	Rectangle t5 = new Rectangle(25,40, Color.YELLOW);
    	Rectangle t6 = new Rectangle(25,40, Color.RED);
    	Rectangle t7 = new Rectangle(25,40, Color.YELLOW);
    	Rectangle t8 = new Rectangle(25,40, Color.RED);
    	
    	Label title = new Label("Freecell- to the DEATH");
    	stackPane.setAlignment(title, Pos.TOP_CENTER);
    	//Setting the font of the text 
        title.setFont(Font.font(null, FontWeight.BOLD, 15));     
        
        //Setting the color of the text 
        title.setTextFill(Color.CRIMSON); 
        
        GridPane gridpane = new GridPane();
        
    	ObservableList list = stackPane.getChildren(); 
		list.addAll(r, title, gridpane);
		
		// gridpane grid layout..
		
		gridpane.setPadding(new Insets(25));
	    gridpane.setHgap(5);
	    gridpane.setVgap(25);
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
		    	bakersDozenGame();
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
	    gridpane.add(fc1, 1, 0);
	    gridpane.add(fc2, 2, 0);
	    gridpane.add(fc3, 3, 0);
	    gridpane.add(fc4, 4, 0);
	   // tableau pile 1 location
	    gridpane.add(hc1, 6, 0);
	    gridpane.add(hc2, 7, 0);
	    gridpane.add(hc3, 8, 0);
	    gridpane.add(hc4, 9, 0);
	    
	    gridpane.add(t1, 1, 3);
	    gridpane.add(t2, 2, 3);
	    gridpane.add(t3, 3, 3);
	    gridpane.add(t4, 4, 3);
	    gridpane.add(t5, 5, 3);
	    gridpane.add(t6, 6, 3);
	    gridpane.add(t7, 7, 3);
	    gridpane.add(t8, 8, 3);
	    
	    
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
	
		Media sound = new Media("https://www.mfiles.co.uk/mp3-downloads/02.The%20calm%20sea%20floating%20mirage.mp3");
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setOnEndOfMedia(new Runnable() {
			@Override public void run() {
		         mediaPlayer.seek(Duration.ZERO);
		       }
		});
		mediaPlayer.play(); 
		
		Freecell fc = new Freecell(8, 4, 4);
    	fc.initialSetup();
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
