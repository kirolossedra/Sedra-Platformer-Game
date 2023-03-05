package things;

import static utilities.Globals.Orientations.*;

import static utilities.Globals.playerGlobals.*;

import static utilities.Globals.playerGlobals.SpritePerAnimation;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Protagonist extends Character {
	
	private BufferedImage [][] AnimationGrid;
	private int currentOrientation = -1;
	private  boolean isMoving = false ;
	private boolean isUp , isDown , isRight , isLeft ,isAttacking ;
	private float speed = 2.0f;
	
	private int AnimationTimer , AnimationSelector
	, TimeToRefreshAnimation = 15;
	private int playerAnimation = 
			RUNNING_Animation_Constant;

	public Protagonist(float x, float y) {
		super(x, y);
		formAnimations();
	}
	public void refresh() {
		alterPosition();
		refreshAnimation();
		
		alterAnimation();
		
		
	}
	public void show(Graphics Graphic_Element) {
		
		

		Graphic_Element.drawImage(AnimationGrid
				[playerAnimation]
				[AnimationSelector]
				,(int)x, (int)y,135,100, null);
		
		
		
	}
	
	


	public void alterPosition() {
		isMoving = false;
		if(isLeft && !isRight) {
			x-=speed;
			isMoving=true;
			
		}
		else if(isRight && !isLeft) {
			x+=speed;
			isMoving=true;
		}
		if (isUp && !isDown) {
			y-=speed;
			isMoving=true;
		}
		if(isDown && !isUp) {
			y+=speed;
			isMoving=true;
		}
	
	}
	
	
	private void alterAnimation() {
		
		int initialAnimation = playerAnimation;
		if(isMoving) {
			playerAnimation = RUNNING_Animation_Constant;
		}
		else {
			playerAnimation = IDLE_Animation_Constant;
		}
		if(isAttacking) {
			playerAnimation = ATTACK1_Animation_Constant;
		}
		if(!(initialAnimation== playerAnimation)) {
			clearAnimation();
		}
	}
	
	
	private void clearAnimation() {
		AnimationSelector=0;
		AnimationTimer=0;
		
	}
	private void refreshAnimation() {
		
		AnimationTimer++;
		if(AnimationTimer >= TimeToRefreshAnimation) {
			AnimationTimer = 0;
			AnimationSelector++;
			if(AnimationSelector >= SpritePerAnimation(playerAnimation)) {
				AnimationSelector = 0;
				isAttacking = false;
			}
		}
		
		
	}
private void formAnimations() {
	
	
	
	InputStream I_S = 
			getClass().getResourceAsStream(
					
					"/main.png"
					);
	
	
	try {
		 BufferedImage TEST_IMG =ImageIO.read(I_S);
		
		

		AnimationGrid = new BufferedImage[9][7];
		
		
		////////////////////////////////////////
		// Animation for Idle RowConstant = 0; //
		////////////////////////////////////////
		AnimationGrid[0][0] =TEST_IMG.getSubimage(3*50, 5*37, 50, 37);
		AnimationGrid[0][1] =TEST_IMG.getSubimage(4*50, 5*37, 50, 37);
		AnimationGrid[0][2] =TEST_IMG.getSubimage(5*50, 5*37, 50, 37);
		AnimationGrid[0][3] =TEST_IMG.getSubimage(6*50, 5*37, 50, 37);
		////////////////////////////////////////
		
		
		
		///////////////////////////////////////////
		// Animation for Running RowConstant = 1 //
		//////////////////////////////////////////
		AnimationGrid[1][0] =TEST_IMG.getSubimage(1*50, 1*37, 50, 37);
		AnimationGrid[1][1] =TEST_IMG.getSubimage(2*50, 1*37, 50, 37);
		AnimationGrid[1][2] =TEST_IMG.getSubimage(3*50, 1*37, 50, 37);
		AnimationGrid[1][3] =TEST_IMG.getSubimage(4*50, 1*37, 50, 37);
		AnimationGrid[1][4] =TEST_IMG.getSubimage(5*50, 1*37, 50, 37);
		AnimationGrid[1][5] =TEST_IMG.getSubimage(6*50, 1*37, 50, 37);
		///////////////////////////////////////////
		
		
		
		////////////////////////////////////////////
		// Animation for JUMPING RowConstant = 2 //
		//////////////////////////////////////////
		AnimationGrid[2][0] =TEST_IMG.getSubimage(0*50, 2*37, 50, 37);
		AnimationGrid[2][1] =TEST_IMG.getSubimage(1*50, 2*37, 50, 37);
		AnimationGrid[2][2] =TEST_IMG.getSubimage(2*50, 2*37, 50, 37);
		AnimationGrid[2][3] =TEST_IMG.getSubimage(3*50, 2*37, 50, 37);
		//////////////////////////////////////////
		
		
		////////////////////////////////////////////
		// Animation for Attack1 RowConstant = 3 //
		//////////////////////////////////////////
		AnimationGrid[3][0] =TEST_IMG.getSubimage(0*50, 6*37, 50, 37);
		AnimationGrid[3][1] =TEST_IMG.getSubimage(1*50, 6*37, 50, 37);
		AnimationGrid[3][2] =TEST_IMG.getSubimage(2*50, 6*37, 50, 37);
		AnimationGrid[3][3] =TEST_IMG.getSubimage(3*50, 6*37, 50, 37);
		AnimationGrid[3][4] =TEST_IMG.getSubimage(4*50, 6*37, 50, 37);
		//////////////////////////////////////////
		
		
		////////////////////////////////////////////
		// Animation for Attack2 RowConstant = 4 //
		//////////////////////////////////////////
		AnimationGrid[4][0] =TEST_IMG.getSubimage(5*50, 6*37, 50, 37);
		AnimationGrid[4][1] =TEST_IMG.getSubimage(6*50, 6*37, 50, 37);
		AnimationGrid[4][2] =TEST_IMG.getSubimage(0*50, 7*37, 50, 37);
		AnimationGrid[4][3] =TEST_IMG.getSubimage(1*50, 7*37, 50, 37);
		AnimationGrid[4][4] =TEST_IMG.getSubimage(2*50, 7*37, 50, 37);
		AnimationGrid[4][5] =TEST_IMG.getSubimage(3*50, 7*37, 50, 37);
		//////////////////////////////////////////
		
		
		
		
		////////////////////////////////////////////
		// Animation for Attack3 RowConstant = 5 //
		//////////////////////////////////////////
		AnimationGrid[5][0] =TEST_IMG.getSubimage(4*50, 7*37, 50, 37);
		AnimationGrid[5][1] =TEST_IMG.getSubimage(5*50, 7*37, 50, 37);
		AnimationGrid[5][2] =TEST_IMG.getSubimage(6*50, 7*37, 50, 37);
		AnimationGrid[5][3] =TEST_IMG.getSubimage(0*50, 8*37, 50, 37);
		AnimationGrid[5][4] =TEST_IMG.getSubimage(1*50, 8*37, 50, 37);
		AnimationGrid[5][5] =TEST_IMG.getSubimage(2*50, 8*37, 50, 37);
		//////////////////////////////////////////
		
		
		////////////////////////////////////////////
		// Animation for Falling RowConstant = 6 //
		//////////////////////////////////////////
		AnimationGrid[6][0] =TEST_IMG.getSubimage(1*50, 3*37, 50, 37);
		AnimationGrid[6][1] =TEST_IMG.getSubimage(2*50, 3*37, 50, 37);
		
		//////////////////////////////////////////
		
		
		

		////////////////////////////////////////////
		// Animation for HURT RowConstant = 7 //
		//////////////////////////////////////////
		AnimationGrid[7][0] =TEST_IMG.getSubimage(3*50, 8*37, 50, 37);
		AnimationGrid[7][1] =TEST_IMG.getSubimage(4*50, 8*37, 50, 37);
		AnimationGrid[7][2] =TEST_IMG.getSubimage(5*50, 8*37, 50, 37);
	
		//////////////////////////////////////////
		
		
		
		////////////////////////////////////////////
		// Animation for DIE RowConstant = 8 	 //
		//////////////////////////////////////////
		AnimationGrid[8][0] =TEST_IMG.getSubimage(6*50, 8*37, 50, 37);
		AnimationGrid[8][1] =TEST_IMG.getSubimage(0*50, 9*37, 50, 37);
		AnimationGrid[8][2] =TEST_IMG.getSubimage(1*50, 9*37, 50, 37);
		AnimationGrid[8][3] =TEST_IMG.getSubimage(2*50, 9*37, 50, 37);
		AnimationGrid[8][4] =TEST_IMG.getSubimage(3*50, 9*37, 50, 37);
		AnimationGrid[8][5] =TEST_IMG.getSubimage(4*50, 9*37, 50, 37);
		AnimationGrid[8][6] =TEST_IMG.getSubimage(5*50, 9*37, 50, 37);
		//////////////////////////////////////////
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		try {
			I_S.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		
		
		
		

		
}
public boolean isUp() {
	return isUp;
}
public void setUp(boolean isUp) {
	this.isUp = isUp;
}
public boolean isDown() {
	return isDown;
}
public void setDown(boolean isDown) {
	this.isDown = isDown;
}
public boolean isRight() {
	return isRight;
}
public void setRight(boolean isRight) {
	this.isRight = isRight;
}
public boolean isLeft() {
	return isLeft;
}
public void setLeft(boolean isLeft) {
	this.isLeft = isLeft;
}
public void resetBoolList() {
	isDown=false;
	isMoving=false;
	isUp=false;
	isRight=false;
	isLeft=false;
	
}
public boolean isAttacking() {
	return isAttacking;
}
public void setAttacking(boolean isAttacking) {
	this.isAttacking = isAttacking;
	
}



	

}
