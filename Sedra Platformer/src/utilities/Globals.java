package utilities;

public class Globals {
	
	
	public static class Orientations{
		public static final int LEFT_Orientation = 6 ;
		public static final int UP_Orientation = 5 ;
		public static final int RIGHT_Orientation = 2 ;
		public static final int DOWN_Orientation = 3 ;
		////////// This Controls the movement amount
		///////// when pressing movement buttons
		public static final int CHANGE_AMOUNT = 1;
		/////////////////////////////////////////////
	}
	
	public static class playerGlobals{
		
		
		
		
		/////////////////Constants Related to Animations /////////
		
		public static final int IDLE_Animation_Constant = 0;
		public static final int RUNNING_Animation_Constant = 1;
		public static final int JUMPING_Animation_Constant = 2;
		public static final int ATTACK1_Animation_Constant = 3;
		public static final int ATTACK2_Animation_Constant = 4;
		public static final int ATTACK3_Animation_Constant = 5;
		public static final int FALLING_Animation_Constant = 6;
		public static final int HURT_Animation_Constant = 7;
		public static final int DIE_Animation_Constant = 8;
		//////////////////////////////////////////////////////////
		
		public static int SpritePerAnimation(int Animation) {
			switch(Animation) {
			case IDLE_Animation_Constant://use idle2 animations
			case JUMPING_Animation_Constant:
			return 4; 
			case RUNNING_Animation_Constant:
			case ATTACK2_Animation_Constant:
			case ATTACK3_Animation_Constant:
			return 6;
			
			
			case ATTACK1_Animation_Constant:
			return 5;
			case FALLING_Animation_Constant:
				return 2;
			case HURT_Animation_Constant:
				return 3;
			case DIE_Animation_Constant:
				return 7;
			default :
				return 1;
				
				
				
			}
		}
	}

}
