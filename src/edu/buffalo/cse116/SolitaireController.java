package edu.buffalo.cse116;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class SolitaireController {
	private SolitaireView solitaireView;

	public void selectBorder(StackPane stackPane) {
		DropShadow dropShadow = new DropShadow(25, Color.YELLOW);
			//Creating the mouse event handler 
			EventHandler<MouseEvent> eventHandler = 
			   new EventHandler<MouseEvent>() {    
			   @Override 
			   public void handle(MouseEvent e) { 
			      stackPane.setEffect(dropShadow);           
			   } 
			};    
			stackPane.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);	
	}
	
	
	
	
	

	public void highLightBorder(StackPane stackPane) {
		DropShadow dropShadow = new DropShadow(25, Color.YELLOW);
			//Creating the mouse event handler 
		EventHandler<MouseEvent> eventHandler = 
			   new EventHandler<MouseEvent>() {    
			   @Override 
			   public void handle(MouseEvent e) { 
			      stackPane.setEffect(dropShadow);
			   } 
			};  	
			stackPane.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);	
		
	}
}

	







