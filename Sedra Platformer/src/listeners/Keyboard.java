package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.MainPanel;
import static utilities.Globals.playerGlobals.*;
import static utilities.Globals.Orientations.*;

public class Keyboard implements KeyListener {
	
	
	

	
	private MainPanel mainPanel;
	public Keyboard(MainPanel mainPanel) {
		
		this.mainPanel=mainPanel;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		switch(e.getKeyCode()) {
		case KeyEvent.VK_A:
			mainPanel.getSedraPlatformer().getProtagonist().setLeft(true);
			break;
		case KeyEvent.VK_S:
			mainPanel.getSedraPlatformer().getProtagonist().setDown(true);
			break;
		case KeyEvent.VK_D:
			mainPanel.getSedraPlatformer().getProtagonist().setRight(true);
			break;
		case KeyEvent.VK_W:
			mainPanel.getSedraPlatformer().getProtagonist().setUp(true);
			break;
		
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_A:
			mainPanel.getSedraPlatformer().getProtagonist().setLeft(false);
			break;
		case KeyEvent.VK_S:
			mainPanel.getSedraPlatformer().getProtagonist().setDown(false);
			break;
		case KeyEvent.VK_D:
			mainPanel.getSedraPlatformer().getProtagonist().setRight(false);
			break;
		case KeyEvent.VK_W:
			mainPanel.getSedraPlatformer().getProtagonist().setUp(false);
			break;
		
		}
		
		
	}
	

}
