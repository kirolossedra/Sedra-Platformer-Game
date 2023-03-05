package main;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;


public class MainWindow  {
	private JFrame myFrame; // we will use this as the frame for the game window
	public static final int MAX_FRAME_X = 1280;
	public static final int MAX_FRAME_Y = 800;
	public static final int MIN_FRAME_X = 0 ;
	public static final int MIN_FRAME_Y = 0;
	
	public MainWindow(MainPanel mainPanel)
	{
		myFrame = new JFrame();
		
		
	
		myFrame.setDefaultCloseOperation
		(JFrame.EXIT_ON_CLOSE); // this terminates the program on closing the window
		
		myFrame.
		add(mainPanel); //Linking the created Panel to the window
		
		myFrame.
		setLocationRelativeTo
		(null); // setting the location to null
		//initializes the window in the middle 
		//of the screen
		
		myFrame.setResizable(false);
		myFrame.pack();
		
		// The perfect Location for setting it visible is at the end
		// |    |
		// v    v
		// after all the settings has been applied
		myFrame.setVisible
		(true); //makes the window appear on running (in default it doesn't open)
		myFrame.addWindowFocusListener(new WindowFocusListener() {
			
			@Override
			public void windowLostFocus(WindowEvent e) {
				mainPanel.getSedraPlatformer().ResetInActive();
				
			}
			
			@Override
			public void windowGainedFocus(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
