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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
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
	private SolitaireView view;
	Stage stage;
	BorderPane borderPane1;
	BorderPane borderPane2;
	/**
 * This method creates the user interface to the Main Menu using JavaFx.  Within this set up, the background image and media sound is set when the interface opens.
 * The New Game button is created, listing the menu items for opening a Baker's Dozen game, Freecell game, or the option of quitting and closing the window.
 * 
 */
	@Override
	public void start(Stage mainWindow) throws Exception {

		stage = mainWindow;
		view = new SolitaireView();
		
		Text text = new Text("Solitaire!");
		text.setFont(Font.font ("Verdana", 150));
		text.setFill(Color.ALICEBLUE);//
		
		Image image = new Image("http://i0.kym-cdn.com/photos/images/original/001/169/608/a43.gif", true);  								
		ImageView imageView = new ImageView(image);
		imageView.setPreserveRatio(true);
		imageView.fitWidthProperty().bind(stage.widthProperty());
		
		Media sound = new Media("https://www.mfiles.co.uk/mp3-downloads/gabriels-message-keyboard.mp3");
				MediaPlayer mediaPlayer = new MediaPlayer(sound);
				mediaPlayer.setOnEndOfMedia(new Runnable() {
					@Override public void run() {
						mediaPlayer.seek(Duration.ZERO);
					}
				});
				mediaPlayer.play();
			borderPane1 = new BorderPane();
		borderPane1.getChildren().add(imageView);

		MenuItem bdMenuItm = new MenuItem("Baker's Dozen");
		bdMenuItm.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	mediaPlayer.stop();
		    	changeScene(view.startBakersDozenGame());
		    }
		});
		
		MenuItem fcMenuItm = new MenuItem("Freecell");
		fcMenuItm.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	mediaPlayer.stop();
		    	changeScene(view.startfreeCellGame());
		    }
		});
		
		MenuItem quitMenuItm = new MenuItem("Quit");
		quitMenuItm.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	Platform.exit();
		    }
		});
		
		MenuItem extras = new MenuItem("Extras");
		extras.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	mediaPlayer.stop();
		    	changeScene(view.startEE());
		    }
		});
		

		Menu menu = new Menu("New Game");
		menu.getItems().addAll(bdMenuItm, fcMenuItm, quitMenuItm);

		Menu m = new Menu("Options");
		MenuBar menuBar = new MenuBar(menu, m);
		menuBar.setPrefHeight(30);
		menuBar.prefWidthProperty().bind(mainWindow.widthProperty());
		m.getItems().addAll(extras);
		
		borderPane1.setCenter(text);
		borderPane1.setBottom(menuBar);
		
		Scene scene1 = new Scene(borderPane1, mainWidth, mainHeight);  //, mainWidth, mainHeight);
		//Scene scene2 = new Scene(borderPane2, 700, 700);
		
		//A window		
		mainWindow.setTitle("Solitaire.exe");

		//Add the scene to the stage and display the contents of the stage.		
		mainWindow.setScene(scene1);
		mainWindow.show();	

	}
	/**
	 * When a game is selected, the scene of the window is changed to the display of that game.
	 * 
	 * @param pane
	 * @return boolean value, false
	 */
	Boolean changeScene(Pane pane){
		stage.getScene().setRoot(pane);
		if(pane == stage.getScene().getRoot()) {
			return true;
		}
		return false;
	}
	
	public BorderPane getBorderPane(){
		return this.borderPane1;
	}

	
	/**
 * This method enables the interface is start, by implicitly calling start.
 * @param args
 */
	public static void main(String args[]){           
		
		launch(args);      
	} 
}
