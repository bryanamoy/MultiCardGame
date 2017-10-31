package edu.buffalo.cse116;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

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
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SolitaireController {
	private MainMenu gui;
	private SolitaireView view = new SolitaireView();
	private BakersDozen bd;
	private Freecell fc;
	private DropShadow ds = new DropShadow(20, Color.BLACK);
	public Node whichClick;
	
	public void selected(StackPane s){
		HashMap<Card,ImageView> images = view.getCardImages();
		EventHandler<MouseEvent> mouseEntered = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				s.setEffect(ds);
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
	
	




