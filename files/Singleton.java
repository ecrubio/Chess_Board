package utep.cs3331.lab5.files;

import java.util.ArrayList;

import utep.cs3331.lab5.chess.Piece;

public class Singleton {
	
    private static Singleton singletonInst;
    private ArrayList<Piece> piecesBoard = null;
  
    private Singleton() 
    {
    	piecesBoard = new ArrayList<Piece>();
    } 
  
    public static Singleton getInstance() 
    { 
        if (singletonInst == null)
        	singletonInst = new Singleton(); 
  
        return singletonInst; 
    } 
    
    public ArrayList<Piece> getArray(){
    	return this.piecesBoard;
    }
    
    public void addArray(Piece piece) {
        piecesBoard.add(piece);
    }
    
}
