package utep.cs3331.lab5.chess;

class Bishop extends Piece {
	
	public Bishop() {
		super();
	}
	
	public Bishop(String startType, String startColor, char startX, int startY, char startUserX, int startUserY) {
		super(startType, startColor, startX, startY, startUserX, startUserY);
	}
	
	@Override
	public boolean validate() {
		
		if(getX() == getUserX()) {
			if(getY() == getUserY()) {
				return false;
			}
		}
		
		if(Math.abs(getXDiff()) == Math.abs(getYDiff())) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
