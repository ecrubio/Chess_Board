package utep.cs3331.lab5.chess;

class Rook extends Piece {
	
	public Rook() {
		super();
	}
	
	public Rook(String startType, String startColor, char startX, int startY, char startUserX, int startUserY) {
		super(startType, startColor, startX, startY, startUserX, startUserY);
	}
	
	@Override
	public boolean validate() {
		
		if(getX() == getUserX()) {
			if(getY() == getUserY()) {
				return false;
			}
		}
		
		if(Math.abs(getXDiff()) == 0){
			return true;
		}
		else if(Math.abs(getYDiff()) == 0){
			return true;
		}
		else {
			return false;
		}
	}
}
