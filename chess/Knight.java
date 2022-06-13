package utep.cs3331.lab5.chess;

class Knight extends Piece {
	
	public Knight() {
		super();
	}
	
	public Knight(String startType, String startColor, char startX, int startY, char startUserX, int startUserY) {
		super(startType, startColor, startX, startY, startUserX, startUserY);
	}
	
	@Override
	public boolean validate() {
		
		if(getX() == getUserX()) {
			if(getY() == getUserY()) {
				return false;
			}
		}
		
		switch(Math.abs(getXDiff())) {
			case 1:
				switch(Math.abs(getYDiff())) {
					case 2:
						return true;
					default:
						return false;
				}
			case 2:
				switch(Math.abs(getYDiff())) {
					case 1:
						return true;
					default:
						return false;
				}
			default:
				return false;
		}
	}
}
