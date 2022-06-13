package utep.cs3331.lab5.chess;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueenTest {

	@BeforeEach
	void setUp() throws Exception {
		//DiagonalLeft
		//Queen queenTest = new Queen("Queen", "white", 'd', 1, 'a', 4);
		//DiagonalRight
		//Queen queenTest = new Queen("Queen", "white", 'd', 1, 'i', 5);
		//LogicalTest
		//Queen queenTest = new Queen("Queen", "white", 'd', 1, 'c', 5);
		//StraightTest
		//Queen queenTest = new Queen("Queen", "white", 'd', 1, 'd', 7);
	}

	
	
	/*@AfterEach
	void tearDown() throws Exception {
	}*/
	/*@Test
	//DiagonalLeft
	void test() {
		Queen queenTest = new Queen("Queen", "white", 'd', 1, 'a', 4);
		assertEquals(true, queenTest.validate());
	}
	
	@Test
	//DiagonalRight
	void test() {
		Queen queenTest = new Queen("Queen", "white", 'd', 1, 'i', 5);
		assertEquals(false, queenTest.validate());
	}
	
	@Test
	DiagonalRight
	void test1() {
		Queen queenTest = new Queen("Queen", "white", 'd', 1, 'i', 5);
		assertEquals(false, queenTest.inBoard('i', 5));
	}
	
	/*@Test
	//LocigalTest
	void test() {
		Queen queenTest = new Queen("Queen", "white", 'd', 1, 'c', 5);
		assertEquals(false, queenTest.validate());
	}
	
	@Test
	//DiagonalLeft
	void test() {
		Queen queenTest = new Queen("Queen", "white", 'd', 1, 'd', 8);
		assertEquals(true, queenTest.validate());
	}*/
}
