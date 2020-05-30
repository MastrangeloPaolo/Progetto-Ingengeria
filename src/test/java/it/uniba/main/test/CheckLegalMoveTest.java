package it.uniba.main.test;

import static org.junit.jupiter.api.Assertions.*;

import it.uniba.main.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CheckLegalMoveTest {

	@Nested
	class pawnTest {
		private Board board;
		private Position start, end;
		private boolean turn, color;
		private Knight c4;

		@Test
		void testLegalMovePawn() {
			board = new Board();
			board.fillBoard();
			turn = true;
			start = new Position(6,0);
			end = new Position(5,0);
			assertTrue(CheckLegalMove.legalMovePawn(start, end, board, turn));
		}

		@Test
		void test2LegalMovePawn() {
			board = new Board();
			board.fillBoard();
			turn = false;
			start = new Position(6,0);
			end = new Position(6,1);
			assertFalse(CheckLegalMove.legalMovePawn(start, end, board, turn));
		}

		@Test
		void test3LegalMovePawn() {
			board = new Board();
			board.fillBoard();
			turn = false;
			start = new Position(2,0);
			end = new Position(3,0);
			c4 = new Knight(3, 0, false);
			board.setPiece(c4.getPosition(), c4);
			assertFalse(CheckLegalMove.legalMovePawn(start, end, board, turn));
		}

		@Test
		void test4LegalMovePawn() {
			board = new Board();
			board.fillBoard();
			turn = false;
			start = new Position(6,0);
			end = new Position(4,0);
			assertFalse(CheckLegalMove.legalMovePawn(start, end, board, turn));
		}

		@Test
		void testLegalMove2Pawn() {
			board = new Board();
			board.fillBoard();
			turn = true;
			start = new Position(6,0);
			end = new Position(4,0);
			assertTrue(CheckLegalMove.legalMove2Pawn(start, end, board, turn));
		}

		@Test
		void test2LegalMove2Pawn() {
			board = new Board();
			board.fillBoard();
			turn = false;
			start = new Position(1,0);
			end = new Position(4,1);
			Piece piece = board.getPiece(1, 0);
			Pawn pawn = (Pawn) piece;
			pawn.setFirstStep(false);
			assertFalse(CheckLegalMove.legalMove2Pawn(start, end, board, turn));
		}

		@Test
		void test3LegalMove2Pawn() {
			board = new Board();
			board.fillBoard();
			turn = true;
			start = new Position(6,0);
			end = new Position(5,1);
			assertFalse(CheckLegalMove.legalMove2Pawn(start, end, board, turn));
		}

		@Test
		void test4LegalMove2Pawn() {
			board = new Board();
			board.fillBoard();
			turn = false;
			start = new Position(1,0);
			end = new Position(4,0);
			assertFalse(CheckLegalMove.legalMove2Pawn(start, end, board, turn));
		}

		@Test
		void test5LegalMove2Pawn() {
			board = new Board();
			board.fillBoard();
			turn = false;
			start = new Position(1,0);
			end = new Position(3,0);
			c4 = new Knight(3, 0, false);
			board.setPiece(c4.getPosition(), c4);
			assertFalse(CheckLegalMove.legalMove2Pawn(start, end, board, turn));
		}

		@Test
		void test6LegalMove2Pawn() {
			board = new Board();
			board.fillBoard();
			turn = false;
			start = new Position(1,0);
			end = new Position(3,0);
			c4 = new Knight(2, 0, false);
			board.setPiece(c4.getPosition(), c4);
			assertFalse(CheckLegalMove.legalMove2Pawn(start, end, board, turn));
		}

		@Test
		void testLegalMoveCapturePawn() {
			start = new Position(4,4);
			end = new Position(5,3);
			color = true;
			assertTrue(CheckLegalMove.legalMoveCapturePawn(start, end, color));
		}

		@Test
		void test2LegalMoveCapturePawn() {
			start = new Position(4,3);
			end = new Position(5,4);
			color = true;
			assertTrue(CheckLegalMove.legalMoveCapturePawn(start, end, color));
		}

		@Test
		void test3LegalMoveCapturePawn() {
			start = new Position(4,3);
			end = new Position(5,5);
			color = true;
			assertFalse(CheckLegalMove.legalMoveCapturePawn(start, end, color));
		}

		@Test
		void test4LegalMoveCapturePawn() {
			start = new Position(4,0);
			end = new Position(6,0);
			color = true;
			assertFalse(CheckLegalMove.legalMoveCapturePawn(start, end, color));
		}

		@Test
		void test5LegalMoveCapturePawn() {
			start = new Position(4,4);
			end = new Position(3,3);
			color = false;
			assertTrue(CheckLegalMove.legalMoveCapturePawn(start, end, color));
		}

		@Test
		void test6LegalMoveCapturePawn() {
			start = new Position(4,3);
			end = new Position(3,4);
			color = false;
			assertTrue(CheckLegalMove.legalMoveCapturePawn(start, end, color));
		}

		@Test
		void test7LegalMoveCapturePawn() {
			start = new Position(4,3);
			end = new Position(3,5);
			color = false;
			assertFalse(CheckLegalMove.legalMoveCapturePawn(start, end, color));
		}

		@Test
		void test8LegalMoveCapturePawn() {
			start = new Position(4,0);
			end = new Position(6,0);
			color = false;
			assertFalse(CheckLegalMove.legalMoveCapturePawn(start, end, color));
		}
	}

	@Nested
	class kingTest {
		private King king;
		private King king1;
		private Board board;
		private Position pos;

		@Test
		void Check1() {
			king = new King(3, 3, false);
			king1 = new King(2, 3, false);
			assertEquals(CheckLegalMove.legalMoveKing(king.getPosition(), king1.getPosition()), true);
		}

		@Test
		void Check1a() {
			king = new King(3, 3, false);
			king1 = new King(2, 7, false);
			assertEquals(CheckLegalMove.legalMoveKing(king.getPosition(), king1.getPosition()), false);
		}

		@Test
		void Check1b() {
			king = new King(3, 3, false);
			king1 = new King(7, 3, false);
			assertEquals(CheckLegalMove.legalMoveKing(king.getPosition(), king1.getPosition()), false);
		}

		@Test
		void Check2() {
			king = new King(3, 3, false);
			king1 = new King(2, 2, false);
			assertEquals(CheckLegalMove.legalMoveKing(king.getPosition(), king1.getPosition()), true);
		}

		@Test
		void Check2a() {
			king = new King(3, 3, false);
			king1 = new King(2, 7, false);
			assertEquals(CheckLegalMove.legalMoveKing(king.getPosition(), king1.getPosition()), false);
		}

		@Test
		void Check2b() {
			king = new King(3, 3, false);
			king1 = new King(7, 2, false);
			assertEquals(CheckLegalMove.legalMoveKing(king.getPosition(), king1.getPosition()), false);
		}

		@Test
		void Check3() {
			king = new King(3, 3, false);
			king1 = new King(2, 4, false);
			assertEquals(CheckLegalMove.legalMoveKing(king.getPosition(), king1.getPosition()), true);;
		}

		@Test
		void Check3a() {
			king = new King(3, 3, false);
			king1 = new King(2, 7, false);
			assertEquals(CheckLegalMove.legalMoveKing(king.getPosition(), king1.getPosition()), false);
		}

		@Test
		void Check3b() {
			king = new King(3, 3, false);
			king1 = new King(7, 4, false);
			assertEquals(CheckLegalMove.legalMoveKing(king.getPosition(), king1.getPosition()), false);
		}

		@Test
		void Check4() {
			king = new King(3, 3, false);
			king1 = new King(3, 4, false);
			assertEquals(CheckLegalMove.legalMoveKing(king.getPosition(), king1.getPosition()), true);
		}

		@Test
		void Check4a() {
			king = new King(3, 3, false);
			king1 = new King(3, 7, false);
			assertEquals(CheckLegalMove.legalMoveKing(king.getPosition(), king1.getPosition()), false);
		}

		@Test
		void Check4b() {
			king = new King(3, 3, false);
			king1 = new King(7, 4, false);
			assertEquals(CheckLegalMove.legalMoveKing(king.getPosition(), king1.getPosition()), false);
		}

		@Test
		void Check5() {
			king = new King(3, 3, false);
			king1 = new King(4, 4, false);
			assertEquals(CheckLegalMove.legalMoveKing(king.getPosition(), king1.getPosition()), true);
		}

		@Test
		void Check5a() {
			king = new King(3, 3, false);
			king1 = new King(4, 7, false);
			assertEquals(CheckLegalMove.legalMoveKing(king.getPosition(), king1.getPosition()), false);
		}

		@Test
		void Check5b() {
			king = new King(3, 3, false);
			king1 = new King(7, 4, false);
			assertEquals(CheckLegalMove.legalMoveKing(king.getPosition(), king1.getPosition()), false);
		}

		@Test
		void Check6() {
			king = new King(3, 3, false);
			king1 = new King(4, 3, false);;
			assertEquals(CheckLegalMove.legalMoveKing(king.getPosition(), king1.getPosition()), true);
		}

		@Test
		void Check6a() {
			king = new King(3, 3, false);
			king1 = new King(4, 7, false);
			assertEquals(CheckLegalMove.legalMoveKing(king.getPosition(), king1.getPosition()), false);
		}

		@Test
		void Check6b() {
			king = new King(3, 3, false);
			king1 = new King(7, 3, false);
			assertEquals(CheckLegalMove.legalMoveKing(king.getPosition(), king1.getPosition()), false);
		}

		@Test
		void Check7() {
			king = new King(3, 3, false);
			king1 = new King(4, 2, false);
			assertEquals(CheckLegalMove.legalMoveKing(king.getPosition(), king1.getPosition()), true);
		}

		@Test
		void Check7a() {
			king = new King(3, 3, false);
			king1 = new King(4, 7, false);
			assertEquals(CheckLegalMove.legalMoveKing(king.getPosition(), king1.getPosition()), false);
		}

		@Test
		void Check7b() {
			king = new King(3, 3, false);
			king1 = new King(7, 2, false);
			assertEquals(CheckLegalMove.legalMoveKing(king.getPosition(), king1.getPosition()), false);
		}

		@Test
		void Check8() {
			king = new King(3, 3, false);
			king1 = new King(3, 2, false);
			assertEquals(CheckLegalMove.legalMoveKing(king.getPosition(), king1.getPosition()), true);
		}

		@Test
		void Check8a() {
			king = new King(3, 3, false);
			king1 = new King(3, 7, false);
			assertEquals(CheckLegalMove.legalMoveKing(king.getPosition(), king1.getPosition()), false);
		}

		@Test
		void Check8b() {
			king = new King(3, 3, false);
			king1 = new King(7, 3, false);
			assertEquals(CheckLegalMove.legalMoveKing(king.getPosition(), king1.getPosition()), false);
		}
		
		@Test
		void Check9() {
			board = new Board();
			board.fillBoard();
			pos = new Position(4,0);
			assertEquals(CheckLegalMove.legalKing(pos, false, board), true);
		}
		
		@Test
		void Check10() {
			board = new Board();
			king = new King(4, 1, false);
			board.setPiece(king.getPosition(), king);
			pos = new Position(4,0);
			assertEquals(CheckLegalMove.legalKing(pos, false, board), false);
		}
		
		@Test
		void Check10a() {
			board = new Board();
			king = new King(4, 1, true);
			board.setPiece(king.getPosition(), king);
			pos = new Position(4,0);
			assertEquals(CheckLegalMove.legalKing(pos, true, board), false);
		}
		
		@Test
		void Check11() {
			board = new Board();
			Pawn pawn = new Pawn(5, 1, false);
			board.setPiece(pawn.getPosition(), pawn);
			pos = new Position(4,0);
			assertEquals(CheckLegalMove.legalKing(pos, false, board), false);
		}
		
		@Test
		void Check11a() {
			board = new Board();
			Pawn pawn = new Pawn(3, 1, true);
			board.setPiece(pawn.getPosition(), pawn);
			pos = new Position(4,0);
			assertEquals(CheckLegalMove.legalKing(pos, true, board), false);
		}
		
		@Test
		void Check12() {
			board = new Board();
			Bishop bishop = new Bishop(5, 1, false);
			board.setPiece(bishop.getPosition(), bishop);
			pos = new Position(4,0);
			assertEquals(CheckLegalMove.legalKing(pos, false, board), false);
		}
		
		@Test
		void Check12a() {
			board = new Board();
			Bishop bishop = new Bishop(5, 1, true);
			board.setPiece(bishop.getPosition(), bishop);
			pos = new Position(4,0);
			assertEquals(CheckLegalMove.legalKing(pos, true, board), false);
		}
		
		@Test
		void Check13() {
			board = new Board();
			Knight knight = new Knight(6, 1, false);
			board.setPiece(knight.getPosition(), knight);
			pos = new Position(4,0);
			assertEquals(CheckLegalMove.legalKing(pos, false, board), false);
		}
		
		@Test
		void Check13a() {
			board = new Board();
			Knight knight = new Knight(6, 1, true);
			board.setPiece(knight.getPosition(), knight);
			pos = new Position(4,0);
			assertEquals(CheckLegalMove.legalKing(pos, true, board), false);
		}
	}

	@Nested
	class queenTest {
		private final Integer ONE = 1;
		private final Integer THREE = 3;
		private final Integer FIVE = 5;

		private Queen q1;
		private Position p1;
		private Board board;
		private boolean t;
		  
		@BeforeEach
		void initialization () {
			board = new Board();
		}
		
		  @Test
		  void testMoveTop() {
			Integer SEVEN = 7;
			q1 = new Queen(SEVEN, THREE, false);
		    p1 = new Position(FIVE, THREE);
		    board.setPiece(q1.getPosition(), q1);
		    t = CheckLegalMove.legalMoveQueen(q1.getPosition(), p1, board);
		    assertEquals(t, true);
		  }

		  @Test
		  void testMoveBottom() {
		    q1 = new Queen(THREE, THREE, false);
		    p1 = new Position(FIVE, THREE);
		    board.setPiece(q1.getPosition(), q1);
		    t = CheckLegalMove.legalMoveQueen(q1.getPosition(), p1, board);
		    assertEquals(t, true);
		  }

		  @Test
		  void testMoveRight() {
		    q1 = new Queen(THREE, THREE, false);
		    p1 = new Position(THREE, FIVE);
		    board.setPiece(q1.getPosition(), q1);
		    t = CheckLegalMove.legalMoveQueen(q1.getPosition(), p1, board);
		    assertEquals(t, true);
		  }

		  @Test
		  void testMoveLeft() {
		    q1 = new Queen(THREE, THREE, false);
		    p1 = new Position(THREE, ONE);
		    board.setPiece(q1.getPosition(), q1);
		    t = CheckLegalMove.legalMoveQueen(q1.getPosition(), p1, board);
		    assertEquals(t, true);
		  }

		  @Test
		  void testMoveDiagonalTopRight() {
		    q1 = new Queen(THREE, THREE, false);
		    p1 = new Position(ONE, ONE);
		    board.setPiece(q1.getPosition(), q1);
		    t = CheckLegalMove.legalMoveQueen(q1.getPosition(), p1, board);
		    assertEquals(t, true);
		  }

		  @Test
		  void testMoveDiagonalTopLeft() {
			  q1 = new Queen(THREE, THREE, false);
			  p1 = new Position(ONE, FIVE);
			  board.setPiece(q1.getPosition(), q1);
			  t = CheckLegalMove.legalMoveQueen(q1.getPosition(), p1, board);
			  assertEquals(t, true);
		  }

		  @Test
		  void testMoveDiagonalBottomRight() {
		    q1 = new Queen(THREE, THREE, false);
		    p1 = new Position(FIVE, FIVE);
		    board.setPiece(q1.getPosition(), q1);
		    t = CheckLegalMove.legalMoveQueen(q1.getPosition(), p1, board);
		    assertEquals(t, true);
		  }

		  @Test
		  void testMoveDiagonalBottomLeft() {
			  q1 = new Queen(THREE, THREE, false);
			  p1 = new Position(FIVE, ONE);
			  board.setPiece(q1.getPosition(), q1);
			  t = CheckLegalMove.legalMoveQueen(q1.getPosition(), p1, board);
			  assertEquals(t, true);
		  }
		  
	}
	
	@Nested
	class knightTest {
		private Position posStart;
		private Position posA;
		private Boolean risultato;
		
		@BeforeEach
		void initialization () {
			posStart = new Position(3,3);
		}

		@Test
		void testLegalMoveOne() {
			posA = new Position(1,2);	
			risultato = CheckLegalMove.legalMoveKnight(posStart, posA);
			assertEquals(true,risultato);
			
		}

		@Test
		void testLegalMoveTwo() {
			posA = new Position(1,4);
			risultato = CheckLegalMove.legalMoveKnight(posStart, posA);
			assertEquals(true,risultato);		
		}

		@Test
		void testlegalMoveThree() {
			posA = new Position(2,5);
			risultato = CheckLegalMove.legalMoveKnight(posStart, posA);
			assertEquals(true,risultato);
			
		}

		@Test
		void testLegalMoveFour() {
			posA = new Position(4,5);
			risultato = CheckLegalMove.legalMoveKnight(posStart, posA);
			assertEquals(true,risultato);
			
		}

		@Test
		void testLegalMoveFive() {
			posA = new Position(5,4);
			risultato = CheckLegalMove.legalMoveKnight(posStart, posA);
			assertEquals(true,risultato);
			
		}

		@Test
		void testLegalMoveSix() {
			posA = new Position(5,2);
			risultato = CheckLegalMove.legalMoveKnight(posStart, posA);
			assertEquals(true,risultato);
			
		}

		@Test
		void testLegalMoveSeven() {
			posA = new Position(4,1);
			risultato = CheckLegalMove.legalMoveKnight(posStart, posA);
			assertEquals(true,risultato);
			
		}

		@Test
		void testLegalMoveEight() {
			posA = new Position(2,1);
			risultato = CheckLegalMove.legalMoveKnight(posStart, posA);
			assertEquals(true,risultato);
			
		}

		@Test
		void testLegalMoveFailure() {
			posA = new Position(7,4);
			risultato = CheckLegalMove.legalMoveKnight(posStart, posA);
			assertEquals(false,risultato);
			
		}
		
		@Test
		void testValidMoveZero() {
			posA = new Position(0,0);	
			risultato = CheckLegalMove.legalMoveKnight(posStart, posA);
			assertEquals(false,risultato);
		}

		@Test
		void testValidMoveBranchOne() {
			posA = new Position(1,1);	
			risultato = CheckLegalMove.legalMoveKnight(posStart, posA);
			assertEquals(false,risultato);
		}

		@Test
		void testValidMoveBranchTwo() {
			posA = new Position(0,2);	
			risultato = CheckLegalMove.legalMoveKnight(posStart, posA);
			assertEquals(false,risultato);
		}

		@Test
		void testValidMoveBranchThree() {
			posA = new Position(1,5);	
			risultato = CheckLegalMove.legalMoveKnight(posStart, posA);
			assertEquals(false,risultato);
		}

		@Test
		void testValidMoveBranchFour() {
			posA = new Position(0,4);	
			risultato = CheckLegalMove.legalMoveKnight(posStart, posA);
			assertEquals(false,risultato);
		}

		@Test
		void testValidMoveBranchFive() {
			posA = new Position(5,5);	
			risultato = CheckLegalMove.legalMoveKnight(posStart, posA);
			assertEquals(false,risultato);
		}

		@Test
		void testValidMoveBranchSix() {
			posA = new Position(6,4);	
			risultato = CheckLegalMove.legalMoveKnight(posStart, posA);
			assertEquals(false,risultato);
		}

		@Test
		void testValidMoveBranchSeven() {
			posA = new Position(6,2);	
			risultato = CheckLegalMove.legalMoveKnight(posStart, posA);
			assertEquals(false,risultato);
		}

		@Test
		void testValidMoveBranchEight() {
			posA = new Position(5,1);	
			risultato = CheckLegalMove.legalMoveKnight(posStart, posA);
			assertEquals(false,risultato);
		}

		@Test
		void testValidMoveBranchNine() {
			posA = new Position(1,3);	
			risultato = CheckLegalMove.legalMoveKnight(posStart, posA);
			assertEquals(false,risultato);
		}

		@Test
		void testValidMoveBranchTen() {
			posA = new Position(3,5);	
			risultato = CheckLegalMove.legalMoveKnight(posStart, posA);
			assertEquals(false,risultato);
		}

		@Test
		void testValidMoveBranchEleven() {
			posA = new Position(5,3);	
			risultato = CheckLegalMove.legalMoveKnight(posStart, posA);
			assertEquals(false,risultato);	
		}

		@Test
		void testValidMoveBranchThirteen() {
			posA = new Position(3,1);	
			risultato = CheckLegalMove.legalMoveKnight(posStart, posA);
			assertEquals(false,risultato);
		}

		@Test
		void testValidMoveBranchFourteen() {
			posA = new Position(2,0);	
			risultato = CheckLegalMove.legalMoveKnight(posStart, posA);
			assertEquals(false,risultato);
		}

		@Test
		void testValidMoveBranchFifteen() {
			posA = new Position(2,2);	
			risultato = CheckLegalMove.legalMoveKnight(posStart, posA);
			assertEquals(false,risultato);	
		}

		@Test
		void testValidMoveBranchSixteen() {
			posA = new Position(2,6);	
			risultato = CheckLegalMove.legalMoveKnight(posStart, posA);
			assertEquals(false,risultato);
		}

		@Test
		void testValidMoveBranchSeventeen() {
			posA = new Position(2,4);	
			risultato = CheckLegalMove.legalMoveKnight(posStart, posA);
			assertEquals(false,risultato);	
		}

		@Test
		void testValidMoveBranchEighteen() {
			posA = new Position(4,6);	
			risultato = CheckLegalMove.legalMoveKnight(posStart, posA);
			assertEquals(false,risultato);
		}

		@Test
		void testValidMoveBranchNineteen() {
			posA = new Position(4,4);	
			risultato = CheckLegalMove.legalMoveKnight(posStart, posA);
			assertEquals(false,risultato);
		}

		@Test
		void testValidMoveBranchTwenty() {
			posA = new Position(4,0);	
			risultato = CheckLegalMove.legalMoveKnight(posStart, posA);
			assertEquals(false,risultato);
		}

		@Test
		void testValidMoveBranchTwentyone() {
			posA = new Position(4,2);	
			risultato = CheckLegalMove.legalMoveKnight(posStart, posA);
			assertEquals(false,risultato);
		}
	}

	@Nested
	class bishopTest {
		private Board board;

		@BeforeEach
		void setUp() {
			board = new Board();
			board.fillBoard();
		}

		@Test
		void legalMoveBishop_XYSuccessWhite() {
			Move.movePawn("b3", board, true);
			assertEquals(CheckLegalMove.legalMoveBishop(new Position(7,2), new Position(5,0), board), true);
		}

		@Test
		void legalMoveBishop_XYInsuccessWhite() {
			assertEquals(CheckLegalMove.legalMoveBishop(new Position(7,2), new Position(5,0), board), false);
		}

		@Test
		void legalMoveBishop_XySuccessWhite() {
			Move.movePawn("b3", board, true);
			Move.moveBishop("Aa3", board, true);
			assertEquals(CheckLegalMove.legalMoveBishop(new Position(5,0), new Position(7,2), board), true);
		}

		@Test
		void legalMoveBishop_XyInsuccessWhite() {
			Move.movePawn("b3", board, true);
			Move.moveBishop("Aa3", board, true);
			assertEquals(CheckLegalMove.legalMoveBishop(new Position(5,0), new Position(7,3), board), false);
		}

		@Test
		void legalMoveBishop_xYSuccessWhite() {
			Move.movePawn("g3", board, true);
			Move.moveBishop("Ah3", board, true);
			assertEquals(CheckLegalMove.legalMoveBishop(new Position(5,7), new Position(3,5), board), true);
		}

		@Test
		void legalMoveBishop_xYInsuccessWhite() {
			Move.movePawn("g3", board, true);
			Move.moveBishop("Ah3", board, true);
			assertEquals(CheckLegalMove.legalMoveBishop(new Position(5,0), new Position(7,5), board), false);
		}

		@Test
		void legalMoveBishop_xySuccessWhite() {
			Move.movePawn("g3", board, true);
			Move.moveBishop("Ah3", board, true);
			Move.moveBishop("Ae6", board, true);
			assertEquals(CheckLegalMove.legalMoveBishop(new Position(2,4), new Position(5,7), board), true);
		}

		@Test
		void legalMoveBishop_xyInsuccessWhite() {
			Move.movePawn("g3", board, true);
			Move.moveBishop("Ah3", board, true);
			Move.moveBishop("Ae6", board, true);
			assertEquals(CheckLegalMove.legalMoveBishop(new Position(2,4), new Position(7,3), board), false);
		}


		@Test
		void legalMoveBishop_XYSuccessBlack() {
			Move.movePawn("b6", board, false);
			assertEquals(CheckLegalMove.legalMoveBishop(new Position(0,2), new Position(1,1), board), true);
		}

		@Test
		void legalMoveBishop_XYInsuccessBlack() {
			assertEquals(CheckLegalMove.legalMoveBishop(new Position(0,2), new Position(2,2), board), false);
		}

		@Test
		void legalMoveBishop_XyInSuccess() {
			assertEquals(CheckLegalMove.legalMoveBishop(new Position(5,0), new Position(4,-1), board), false);
		}

		@Test
		void legalMoveBishop_XyInSuccess3() {
			assertEquals(CheckLegalMove.legalMoveBishop(new Position(5,0), new Position(6,-1), board), false);
		}

		@Test
		void legalMoveBishop_XyInSuccess4() {
			assertEquals(CheckLegalMove.legalMoveBishop(new Position(0,0), new Position(-1,6), board), false);
		}

		@Test
		void legalMoveBishop_XyInSuccess5() {
			assertEquals(CheckLegalMove.legalMoveBishop(new Position(-1,6), new Position(0,0), board), false);
		}

		@Test
		void legalMoveBishop_InSuccess6() {
			assertEquals(CheckLegalMove.legalMoveBishop(new Position(1,6), new Position(0,0), board), false);
		}

		@Test
		void legalMoveBishop_InSuccess7() {
			assertEquals(CheckLegalMove.legalMoveBishop(new Position(1,6), new Position(1,9), board), false);
		}

		@Test
		void legalMoveBishop_InSuccess8() {
			assertEquals(CheckLegalMove.legalMoveBishop(new Position(8,8), new Position(6,9), board), false);
		}

		@Test
		void legalMoveBishop_InSuccess9() {
			assertEquals(CheckLegalMove.legalMoveBishop(new Position(-1,-1), new Position(-8,-5), board), false);
		}

		@Test
		void legalMoveBishop_InSuccess10() {
			assertEquals(CheckLegalMove.legalMoveBishop(new Position(7,8), new Position(8,-5), board), false);
		}
	}

	@Nested
	class rookTest {
		private Board board;
		private Rook rook;
		private Pawn pawn;
		private Position pos;

		@BeforeEach
		void setUp() {
			board = new Board();
		}

		@Test
		void testlegalmoveRookTop() {
			boolean flag;
			rook = new Rook(6, 7, false);
			pos = new Position(4, 7);
			board.setPiece(rook.getPosition(), rook);
			flag = CheckLegalMove.legalMoveRook(rook.getPosition(), pos, board);
			assertEquals(flag, true);
		}

		@Test
		void testRookMoveBottom() {
			boolean flag;
			rook = new Rook(4, 7, false);
			pos = new Position(6, 7);
			board.setPiece(rook.getPosition(), rook);
			flag = CheckLegalMove.legalMoveRook(rook.getPosition(), pos, board);
			assertEquals(flag, true);
		}

		@Test
		void testRookMoveRight() {
			boolean flag;
			rook = new Rook(5, 4, false);
			pos = new Position(5, 7);
			board.setPiece(rook.getPosition(), rook);
			flag = CheckLegalMove.legalMoveRook(rook.getPosition(), pos, board);
			assertEquals(flag, true);
		}

		@Test
		void testRookMoveLeft() {
			boolean flag;
			rook = new Rook(5, 4, false);
			pos = new Position(5, 7);
			board.setPiece(rook.getPosition(), rook);
			flag = CheckLegalMove.legalMoveRook(rook.getPosition(), pos, board);
			assertEquals(flag, true);
		}

		@Test
		void testFlag() {
			boolean flag;
			rook = new Rook(5, 4, false);
			pos = new Position(5, 7);
			pawn = new Pawn(5, 6, true);
			board.setPiece(rook.getPosition(), rook);
			board.setPiece(pawn.getPosition(), pawn);
			flag = CheckLegalMove.legalMoveRook(rook.getPosition(), pos, board);
			assertEquals(flag, false);
		}

		@Test
		void testFlag1() {
			boolean flag;
			rook = new Rook(4, 5, false);
			pos = new Position(7, 5);
			pawn = new Pawn(6, 5, true);
			board.setPiece(rook.getPosition(), rook);
			board.setPiece(pawn.getPosition(), pawn);
			flag = CheckLegalMove.legalMoveRook(rook.getPosition(), pos, board);
			assertEquals(flag, false);
		}

		@Test
		void testFlag2() {
			boolean flag;
			rook = new Rook(0, 0, false);
			pos = new Position(7, 7);
			board.setPiece(rook.getPosition(), rook);
			flag = CheckLegalMove.legalMoveRook(rook.getPosition(), pos, board);
			assertEquals(flag, false);
		}

	}
}
