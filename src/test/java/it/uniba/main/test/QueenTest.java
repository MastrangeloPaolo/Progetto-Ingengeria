package it.uniba.main.test;

import it.uniba.main.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueenTest {
	  private static final Integer ZERO = 0;
	  private static final Integer THREE = 3;
	  private static final Integer FIVE = 5;
	  private static final Integer SIX = 6;
	  private static final Integer SEVEN = 7;
	  
	  private Queen q1;
	  private Board board;
	  
	@BeforeEach
	void initialization(){
		board = new Board();
	}
	@Test
	void testSetX() {
		q1 = new Queen(SEVEN,THREE, true);
		q1.setPositionX(SIX);
		assertEquals(q1.getPosition().getPosX(), SIX);
	}

	@Test
	void testSetY() {
		q1 = new Queen(SEVEN,THREE, true);
		q1.setPositionY(FIVE);
		assertEquals(q1.getPosition().getPosY(), FIVE);
	}
	
	@Test
	void testFindQUEEN() {
		q1 = new Queen(ZERO,ZERO, false);
		board.setPiece(q1.getPosition(), q1);
		assertEquals(Queen.findQueen(board, true), new Position(0,0));
	}
	
	@Test
	void testFindQueen() {
		q1 = new Queen(FIVE,ZERO, true);
		board.setPiece(q1.getPosition(), q1);
		assertEquals(Queen.findQueen(board, false), new Position(5,0));
	}
}
