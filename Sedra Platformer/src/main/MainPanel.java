package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import listeners.Keyboard;
import listeners.Mouse;
import static utilities.Globals.playerGlobals.*;
import static utilities.Globals.Orientations.*;

public class MainPanel extends JPanel {
	
	private Mouse mouseEvent;
	private SedraPlatformer platformer;
	

	
	
	
	
	
	

	////////////////////////////
	// Border Controlled dynamics
	//private float xOrientation = 1.0f ; // 1 as multiplicative inverse to change direction as we cross the limit
	//private float yOrientation = 1.0f ;
	///////////////////////////
	
	
	
	
	
	
	
	private void setSize() {
		setMinimumSize(new Dimension(MainWindow.MAX_FRAME_X,
				MainWindow.MAX_FRAME_Y)
				);
		setPreferredSize(new Dimension(MainWindow.MAX_FRAME_X,
				MainWindow.MAX_FRAME_Y));
		setMaximumSize(new Dimension(MainWindow.MAX_FRAME_X,
				MainWindow.MAX_FRAME_Y));
	}
	public MainPanel(SedraPlatformer platformer) {
		this.platformer = platformer;
		
		mouseEvent = new Mouse(this);
		setSize();
		addKeyListener(new Keyboard(this));
		addMouseListener(mouseEvent);
		addMouseMotionListener(mouseEvent);
		
	
		
	}
	
	
	
	
	
	
	
	
	
@Override	
public void paintComponent(Graphics Graphic_Element) {
	super.paintComponent(Graphic_Element);
	platformer.show(Graphic_Element);
	
	
	
	
	
	

	
}

public void refresh() {

	
}

public SedraPlatformer getSedraPlatformer() {
	return platformer;
}



}
