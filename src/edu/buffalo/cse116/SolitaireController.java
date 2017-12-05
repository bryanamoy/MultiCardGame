package edu.buffalo.cse116;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
/**
 * <h1>SolitaireController class</h1>
 * <p>
 * <b>Note:</b> This is the Controller part of the Model-View-Controller, it handles
 * the mouse events for the interface.
 * @author Corey Almonte
 * @since 2017-10-30
 */
public class SolitaireController {
	private MainMenu gui;
	/**
	 * SolitaireView instance
	 */
	private SolitaireView view = new SolitaireView();
	/**
	 * Baker's Dozen game instance
	 */
	private BakersDozen bd;
	/**
	 * Freecell game instance
	 */
	private Freecell fc;
	/**
	 * The highlight effect used when clicking a card.
	 */
	private DropShadow ds = new DropShadow(20, Color.BLACK);
	public Node whichClick;
	/**
	 * Event Handler when selecting a card by mouse press.. Easter Egg within
	 * @param s
	 */
	public void selected(StackPane s){
		HashMap<Card,ImageView> images = view.getCardImages();
		EventHandler<MouseEvent> mouseEntered = new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent e) {
				s.setEffect(ds);
				 int count = e.getClickCount();
				 if(count==5){
					 Media sound = new Media("https://www.soundjay.com/human/sounds/fart-01.mp3");
						MediaPlayer mediaPlayer = new MediaPlayer(sound);
						mediaPlayer.setOnEndOfMedia(new Runnable() {
							@Override public void run() {
								mediaPlayer.seek(Duration.ZERO);
							}
						});
						mediaPlayer.play();
						
				 }
			}
		};
		EventHandler<MouseEvent> mouseReleased = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				s.setEffect(null);
				
			}
		};
		s.setOnMousePressed(mouseEntered);
		s.setOnMouseReleased(mouseReleased);
	}
	

	
	
	
	
	
}
	
