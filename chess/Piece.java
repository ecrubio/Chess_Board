package utep.cs3331.lab5.chess;

public class Piece {

	//Attributes
		private String type;
		private String color;
		private char x;
		private int y;
		private char userX;
		private int userY;
		
		//empty constructor
		public Piece() {
		}
		
		//constructor that sets the given items into the attributes
		public Piece(String startType, String startColor, char startX, int startY, char startUserX, int startUserY) {
			type = startType;
			color = startColor;
			x = startX;
			y = startY;
			userX = startUserX;
			userY = startUserY;
		}
		
		//getters	
		public String getType() {
			return type;
		}
		
		public String getColor() {
			return color;
		}
		
		public char getX() {
			return x;
		}
		
		public int getY() {
			return y;
		}
		
		public char getUserX() {
			return userX;
		}
		
		public int getUserY() {
			return userY;
		}
		
		public int getXDiff() {
			return (int)x - (int)userX;
		}
		
		public int getYDiff() {
			return y - userY;
		}
		
		//method that is overriden
		public boolean validate() {
			return false;
		}
		
		/*public void isValid() {
			//System.out.println(this.type + " at " + this.x + ", " + this.y + " can move to " + this.userX + ", " + this.userY);
		}*/
		
		/*public void isNotValid() {
			return;
			//System.out.println(this.type + " at " + this.x + ", " + this.y + " can NOT move to " + this.userX + ", " + this.userY);
		}*/
		
		//validity of the move inside bounds
		public void inBoard() {
			if (userX < 'a' || userX > 'h') {
				System.out.println("Not valid coordinates");
				System.exit(0);
			}
			if (userY < 1 || userY > 8) {
				System.out.println("Not valid coordinates");
				System.exit(0);
			}
		}
}
