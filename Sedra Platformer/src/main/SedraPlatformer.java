package main;

import java.awt.Graphics;

import things.Protagonist;

public class SedraPlatformer implements
Runnable
{
	
	private MainWindow mainWindow;
	private MainPanel mainPanel;
	private Thread Platformer;
	private final int FPS_REQUIRED = 120;
	private final int UPS_REQUIRED = 200;
	
	private Protagonist protagonist;
	
	
	
	public SedraPlatformer(){
		startComponents();
		mainPanel = new MainPanel(this);
		mainWindow = new MainWindow(mainPanel);
		mainPanel.
		requestFocus();//Make the window listen to panel events
		
		MultiThreadedGameLoop();
		
		
		
	}
	
	private void startComponents() {
		protagonist = new Protagonist(200,200);
	}

	private void MultiThreadedGameLoop() {
		Platformer = new Thread(this);
		Platformer.start();
		
		
	}
	
	
	public void refresh() {
		protagonist.refresh();
	}
	
	public void show(Graphics Graphic_Element) {
		protagonist.show(Graphic_Element);
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		double frameTime = 1000000000.0/FPS_REQUIRED;
		double updateTime = 1000000000.0/UPS_REQUIRED;
		long passedTime_U = System.nanoTime()	;
		double differenceU = 0;
		double differenceF = 0;
		int frameCount = 0;
		int updateCount = 0;
	
		long previousTime_Check = System.currentTimeMillis();
		for(;;) {
			
			
			
			long currentTime_U = System.nanoTime();
			
			differenceU += (currentTime_U - passedTime_U)/updateTime;
			differenceF +=(currentTime_U - passedTime_U)/frameTime;
			passedTime_U = currentTime_U;
			
			
			
			  if(differenceU>= 1) { 
				  refresh();
				  updateCount++; 
				  differenceU--;
			  
			  }
			  
			  if(differenceF>=1) {
				  mainPanel.repaint();
					
					frameCount++;
					differenceF--;
			  }
			 
			
				/*
				 * if(currentTime - previousTime >= frameTime ) { // reflect this change in the
				 * //actually painted component // this is a recursive call //the repaint calls
				 * PaintComponent mainPanel.repaint(); previousTime = currentTime; frameCount++;
				 * 
				 * 
				 * 
				 * }
				 */
			if(System.currentTimeMillis() - previousTime_Check >= 1000) {
				previousTime_Check = System.currentTimeMillis();
				System.out.println("fps: "+frameCount +" ups: "+updateCount);
				frameCount = 0;
				updateCount = 0;
			}
	}
		
		
		
		
	}
	public Protagonist getProtagonist() {
		return protagonist;
	}

	public void ResetInActive() {
		protagonist.resetBoolList();
		
	}

}
