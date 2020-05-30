package it.uniba.main.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import it.uniba.main.Command;
import it.uniba.main.Board;

class CommandTest {

	@Test
	void testHelp() {
		Command.help();
	}

	@Test
	void testChessboardDisplay() {
		Board board = new Board();
		Command.chessboardDisplay(board);
	}
	
	@Test
	void test1ChessboardDisplay() {
		Board board = new Board();
		board.fillBoard();
		Command.chessboardDisplay(board);
	}
	
	
	@Test
	void testPrintMoves() {
		Board board = new Board();
		Command.printMoves(true, board);
	}
	
	@Test
	void test1PrintMoves() {
		Board board = new Board();
		board.setFirstTurn(false);
		board.setStoryMove("a5");
		board.setStoryMove("a6");
		board.setStoryMove("a7");
		Command.printMoves(false, board);
	}
	
	@Test
	void test2PrintMoves() {
		Board board = new Board();
		board.setFirstTurn(false);
		board.setStoryMove("a5");
		board.setStoryMove("a6");
		Command.printMoves(true, board);
	}
	
	@Test
	void test3PrintMoves() {
		Board board = new Board();
		board.setFirstTurn(false);
		board.setStoryMove("a5");
		Command.printMoves(false, board);
	}
	
	@Test
	void testPrintCapture() {
		Board board = new Board();
		Command.printCapture(board);
	}
	
	@Test
	void testplay() {
		java.io.InputStream stdin = System.in;
		System.setIn(new ByteArrayInputStream("no".getBytes()));
		Command.play();
		System.setIn(new ByteArrayInputStream("quit".getBytes()));
		System.setIn(stdin);
		System.setIn(new ByteArrayInputStream("si".getBytes()));
		System.setIn(stdin);
    }
	
	@Test
	void testQuit() {
		ByteArrayInputStream in = new ByteArrayInputStream("no".getBytes());
		System.setIn(in);
		Command.quit();
	}
}
