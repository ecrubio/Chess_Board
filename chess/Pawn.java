package utep.cs3331.lab5.chess;

class Pawn extends Piece {
	
	public Pawn() {
		super();
	}
	
	public Pawn(String startType, String startColor, char startX, int startY, char startUserX, int startUserY) {
		super(startType, startColor, startX, startY, startUserX, startUserY);
	}
	
	@Override
	public boolean validate() {
		
		if(getX() == getUserX()) {
			if(getY() == getUserY()) {
				return false;
			}
		}
		
		switch(getXDiff()) {
			case 0:
				switch(getYDiff()) {
					case -1:
						if(getColor().equals("white")) {
							return true;
						}
					case 1:
						if(getColor().equals("black")) {
							return true;
						}
					case -2:
						if(getY() == 2 && getColor().equals("white")) {
							return true;
						}
					case 2:
						if(getY() == 7 && getColor().equals("black")) {
							return true;
						}
						else {
							return false;
						}
						
					default:
						return false;
				}
			default:
				return false;
		}
	}
}
