package utep.cs3331.lab5.chess;

class King extends Piece {
	
	//super() calls Piece and sets items
	public King() {
		super();
	}
	
	public King(String startType, String startColor, char startX, int startY, char startUserX, int startUserY) {
		super(startType, startColor, startX, startY, startUserX, startUserY);
	}
	
	//overriding and checking validity
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
					case 1:
						return true;
					case 0:
						return true;
					default:
						return false;
				}
			case 0:
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