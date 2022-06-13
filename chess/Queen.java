package utep.cs3331.lab5.chess;

class Queen extends Piece {
	
	public Queen() {
		super();
	}
	
	public Queen(String startType, String startColor, char startX, int startY, char startUserX, int startUserY) {
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
		else if(Math.abs(getXDiff()) == 0){
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
