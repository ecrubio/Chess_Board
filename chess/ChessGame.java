// Elizabeth Rubio
// CS3331
// Lab 5

/* This program consist of moving a chess piece across the board and validating the move.
 * The superclass now contains the essentials that control the rest of the
 * classes using super and declaring the items as the specific type that uses super to
 * declare the data. The updated version of lab 3 which now contain the singleton pattern.
 * Applying the singleton pattern in the class board which now adds the combinations of both
 * Parties pieces.
 * */

//changelog
//[4/29/20] [Elizabeth Rubio] updated lab 3 to different packages
//[5/1/20] [Elizabeth Rubio] added the class Players to sign in player
//[5/3/20] [Elizabeth Rubio] added the other players pieces
//[5/4/20] [Elizabeth Rubio] updated the arrays to different collections
//[5/4/20] [Elizabeth Rubio] created the singleton class and board class
//[5/5/20] [Elizabeth Rubio] traversed the collections
//[5/6/20] [Elizabeth Rubio] Junit testing

package utep.cs3331.lab5.chess;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import utep.cs3331.lab5.files.Board;
import utep.cs3331.lab5.players.Players;

public class ChessGame {

	public static void main(String[] args) throws FileNotFoundException {
		
		//There will be a list of names and if the user has entered the same name as one in the
		//hashset then they will be signed in to that account with their information.
		HashSet<Players> userName = new HashSet<Players>();
		userName = userInfo();
		
		//This create an ArrayList for the users white pieces
		String fileName1 = "input.txt";
		String[] chessPieces = readFile(fileName1);
		
		String[] tempArr = printMenu();
		char tempXCoord = tempArr[0].charAt(0);
		int tempYCoord = Integer.parseInt(tempArr[1]);
		
		//this holds all the pieces which will then be removed as the game progresses
		ArrayList<Piece> arrayPieces = new ArrayList<Piece>();
		arrayPieces = storingArray(chessPieces, tempXCoord, tempYCoord);
		
		//initialize the other player
		String fileName2 = "input2.txt";
		String[] chessPieces2 = readFile(fileName2);
		
		ArrayList<Piece> cpPieces = new ArrayList<Piece>();
		cpPieces = storingArray(chessPieces2, tempXCoord, tempYCoord);
		
		//Starting board
		Board strBoard = new Board();
		strBoard.setUp(arrayPieces, cpPieces);
		
		strBoard.check();
	}
	
	public static String[] readFile(String text) throws FileNotFoundException {
		
		//Instead of asking for the name of the file the file is assumed to be named input
		//per request of the IA.
		Scanner input = new Scanner(new File(text));
		
		//Storing the file into a string that will read one line and add it to the string followed by a
		//new line and continues until there's no more lines in the file. Then it's split by new lines.
		String chessPiecesFile = "";
		while(input.hasNextLine()) {
			chessPiecesFile = chessPiecesFile.concat(input.nextLine() + "\n");
		}
		String[] chessPieces = chessPiecesFile.split("\\r?\\n");
	
		return chessPieces;
	}
	
	public static String[] printMenu() {
		
		Scanner input = new Scanner(System.in);
		
		//User input for x
		System.out.print("Please input x-coordinates between a and h(use lowercase letters): ");
		String xCoord = input.nextLine();
		
		//User input for y
		System.out.print("Please input y-coordinates between 1 and 8: ");
		String yCoord = input.nextLine();
		
		String userInp[] = {xCoord, yCoord};
		return userInp;		
	}
	

	public static ArrayList<Piece> storingArray(String[] chessPieces, char tempXCoord, int tempYCoord) {
		
		if(chessPieces.length > 16) {
		System.out.println("More pieces than necessary.");
		System.exit(0);
		}
		//creating the array of pieces followed by splitting each line from the passed array
		//after creating the piece based off their name then they are stored into the new array of piece type
		ArrayList<Piece> arrayPieces = new ArrayList<Piece>(chessPieces.length);
		String[] tempSplitItem;
		String typePiece;
		
		for(int i = 0; i < chessPieces.length; i++) {
			tempSplitItem = chessPieces[i].split(", ");
			typePiece = tempSplitItem[0].substring(0, tempSplitItem[0].length() - 2);
			switch(typePiece) {
			case "King":
				King pieceKing = new King(tempSplitItem[0], tempSplitItem[1], tempSplitItem[2].charAt(0), Integer.parseInt(tempSplitItem[3].trim()), tempXCoord, tempYCoord);
				arrayPieces.add(pieceKing);
				pieceKing.inBoard();
				break;
			case "Queen":
				Queen pieceQueen = new Queen(tempSplitItem[0], tempSplitItem[1], tempSplitItem[2].charAt(0), Integer.parseInt(tempSplitItem[3].trim()), tempXCoord, tempYCoord);
				arrayPieces.add(pieceQueen);
				break;
			case "Rook":
				Rook pieceRook = new Rook(tempSplitItem[0], tempSplitItem[1], tempSplitItem[2].charAt(0), Integer.parseInt(tempSplitItem[3].trim()), tempXCoord, tempYCoord);
				arrayPieces.add(pieceRook);
				break;
			case "Bishop":
				Bishop pieceBishop = new Bishop(tempSplitItem[0], tempSplitItem[1], tempSplitItem[2].charAt(0), Integer.parseInt(tempSplitItem[3].trim()), tempXCoord, tempYCoord);
				arrayPieces.add(pieceBishop);
				break;
			case "Knight":
				Knight pieceKnight = new Knight(tempSplitItem[0], tempSplitItem[1], tempSplitItem[2].charAt(0), Integer.parseInt(tempSplitItem[3].trim()), tempXCoord, tempYCoord);
				arrayPieces.add(pieceKnight);
				break;
			case "Pawn":
				Pawn piecePawn = new Pawn(tempSplitItem[0], tempSplitItem[1], tempSplitItem[2].charAt(0), Integer.parseInt(tempSplitItem[3].trim()), tempXCoord, tempYCoord);
				arrayPieces.add(piecePawn);
				break;
			default:
				System.out.print("Not a valid piece provided");
				System.exit(0);
			}
		}
		return arrayPieces;
	}
	
	public static HashSet<Players> userInfo() {
		
		HashSet<Players> userName = new HashSet<Players>();
		//Dummy node to make sure that the while loop does initialize
		Players dummy = new Players(" ", " ", " ");
		userName.add(dummy);
		
		System.out.println("Insert username: ");
		Scanner scan = new Scanner(System.in);
		String user = scan.nextLine();
		//Temp check to compare the values
		Players tempCheck = new Players(user, " ", " ");
		
		//this would act as the checker so there are no users with the same name using iterator to
		//traverse the collection hashset
		Iterator<Players> iter = userName.iterator(); 
		while (iter.hasNext()) {
			if(iter == tempCheck) {
				System.out.println("Signing in.");
				return userName;
			}
			else {
				System.out.println("Creating new user.");
				System.out.println("Enter expertise(novice, medium, advance, master): ");
				String expertise = scan.nextLine();
				System.out.println("Enter color(white or balck): ");
				String color = scan.nextLine();
				
				Players newPlayer = new Players(user, expertise, color);
				userName.add(newPlayer);
				return userName;
			}
		}
		return userName;
	}
}
