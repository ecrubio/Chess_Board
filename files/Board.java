package utep.cs3331.lab5.files;

import java.util.ArrayList;
import java.util.HashMap;

import utep.cs3331.lab5.chess.Piece;

public class Board {
	
	//Empty board that is then updated when you add pieces
	Singleton mainBoard = Singleton.getInstance();
	
	public void setUp(ArrayList<Piece> white, ArrayList<Piece> black) {
		
		white.forEach((n) -> mainBoard.addArray(n));
		black.forEach((k) -> mainBoard.addArray(k));
		
	}
	
	public void check() {
		
		ArrayList<Piece> tempTraverse = mainBoard.getArray();
		HashMap<String, Piece> validPieces = new HashMap<>();
		tempTraverse
			.stream()
			.filter(e -> e.validate() == true)
			.forEach(e -> validPieces.put(e.getType(), e));
		
		System.out.println("Piece that can move to that spot: ");
		validPieces.forEach((pieceName,pieceValue) -> System.out.println(pieceName));
	}
}
