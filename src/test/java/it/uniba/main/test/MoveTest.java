package it.uniba.main.test;

import static org.junit.jupiter.api.Assertions.*;

import it.uniba.main.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;


class MoveTest {

    @Nested
    class MovePawnTest {
        private Board board;
        private King k2;
        private Piece piece;
        private Bishop b1;
        private Pawn p2;

        @BeforeEach
        void initialization() {
            board = new Board();
        }

        @Test
        void testMovePawn() {
            board.fillBoard();
            Move.movePawn("a3", board, true);
            piece = board.getPiece(5, 0);
            assertTrue(piece.getName() == 'P');
        }

        @Test
        void test1MovePawn() {
            board.fillBoard();
            Move.movePawn("a6", board, false);
            piece = board.getPiece(2, 0);
            assertTrue(piece.getName() == 'p');
        }

        @Test
        void test2MovePawn() {
            board.fillBoard();
            k2 = new King(5, 0, false);       //set pezzi bianchi
            board.setPiece(k2.getPosition(), k2);
            assertThrows(IllegalArgumentException.class, () -> Move.movePawn("a3", board, true));
        }

        @Test
        void test3MovePawn() {
            assertThrows(IllegalArgumentException.class, () -> Move.movePawn("a3", board, true));
        }

        @Test
        void test4MovePawn() {
            board.fillBoard();
            k2 = new King(6, 0, false);       //set pezzi bianchi
            board.setPiece(k2.getPosition(), k2);
            assertThrows(IllegalArgumentException.class, () -> Move.movePawn("a3", board, true));
        }

        @Test
        void test5MovePawn() {
            board.fillBoard();
            b1 = new Bishop(4, 1, true);
            board.setPiece(b1.getPosition(), b1);
            assertThrows(IllegalArgumentException.class, () -> Move.movePawn("d3", board, true));
        }

        @Test
        void test6MovePawn() {
            board.fillBoard();
            Move.movePawn("a4", board, true);
            piece = board.getPiece(4, 0);
            assertTrue(piece.getName() == 'P');
        }

        @Test
        void test7MovePawn() {
            board.fillBoard();
            k2 = new King(4, 0, false);       //set pezzi bianchi
            board.setPiece(k2.getPosition(), k2);
            assertThrows(IllegalArgumentException.class, () -> Move.movePawn("a4", board, true));
        }

        @Test
        void test8MovePawn() {
            board.fillBoard();
            Pawn k2 = new Pawn(4, 0, false);
            board.setPiece(k2.getPosition(), k2);
            assertThrows(IllegalArgumentException.class, () -> Move.movePawn("a6", board, true));
        }

        @Test
        void test9MovePawn() {
            k2 = new King(6, 0, false);
            board.setPiece(k2.getPosition(), k2);
            assertThrows(IllegalArgumentException.class, () -> Move.movePawn("a4", board, true));
        }

        @Test
        void test10MovePawn() {
            board.fillBoard();
            b1 = new Bishop(4, 1, true);
            board.setPiece(b1.getPosition(), b1);
            assertThrows(IllegalArgumentException.class, () -> Move.movePawn("d4", board, true));
        }

        @Test
        void test11MovePawn() {
            board.fillBoard();
            assertThrows(IllegalArgumentException.class, () -> Move.movePawn("c1", board, true));
        }

        @Test
        void test12MovePawn() {
            board.fillBoard();
            k2 = new King(5, 1, true);
            board.setPiece(k2.getPosition(), k2);
            Move.movePawn("axb3", board, true);
            piece = board.getPiece(5, 1);
            assertTrue(piece.getName() == 'P');
        }

        @Test
        void test15MovePawn() {
            board.fillBoard();
            k2 = new King(5, 0, true);
            board.setPiece(k2.getPosition(), k2);
            Move.movePawn("bxa3", board, true);
            piece = board.getPiece(5, 0);
            assertTrue(piece.getName() == 'P');
        }

        @Test
        void test13MovePawn() {
            board.fillBoard();
            k2 = new King(2, 1, true);
            board.setPiece(k2.getPosition(), k2);
            assertThrows(IllegalArgumentException.class, () -> Move.movePawn("axb6", board, false));
        }

        @Test
        void test14MovePawn() {
            board.fillBoard();
            k2 = new King(5, 3, true);
            board.setPiece(k2.getPosition(), k2);
            assertThrows(IllegalArgumentException.class, () -> Move.movePawn("bxd3", board, true));
        }

        @Test
        void test16MovePawn() {
            board.fillBoard();
            k2 = new King(4, 2, true);
            board.setPiece(k2.getPosition(), k2);
            King k1 = new King(5, 1, true);
            board.setPiece(k1.getPosition(), k1);
            assertThrows(IllegalArgumentException.class, () -> Move.movePawn("bxc4", board, true));
        }

        @Test
        void test17MovePawn() {
            board.fillBoard();
            k2 = new King(3, 3, true);
            board.setPiece(k2.getPosition(), k2);
            assertThrows(IllegalArgumentException.class, () -> Move.movePawn("cxd5", board, true));
        }

        @Test
        void test18MovePawn() {
            board.fillBoard();
            Bishop k2 = new Bishop(4, 1, true);
            board.setPiece(k2.getPosition(), k2);
            King k1 = new King(5, 4, true);
            board.setPiece(k1.getPosition(), k1);
            assertThrows(IllegalArgumentException.class, () -> Move.movePawn("dxe3", board, true));
        }

        @Test
        void test19MovePawn() {
            Pawn k2 = new Pawn(4, 0, true);
            board.setPiece(k2.getPosition(), k2);
            p2 = new Pawn(6, 1, false);
            board.setPiece(p2.getPosition(), p2);
            Move.movePawn("b4", board, true);
            Move.movePawn("axb3", board, false);
            piece = board.getPiece(5, 1);
            assertTrue(piece.getName() == 'p');
        }

        @Test
        void test20MovePawn() {
            assertThrows(IllegalArgumentException.class, () -> Move.movePawn("axb3", board, true));
        }

        @Test
        void test21MovePawn() {
            assertThrows(IllegalArgumentException.class, () -> Move.movePawn("axb3", board, false));
        }

        @Test
        void test22MovePawn() {
            Pawn p2 = new Pawn(4, 0, false);
            board.setPiece(p2.getPosition(), p2);
            assertThrows(IllegalArgumentException.class, () -> Move.movePawn("axb3", board, false));
        }

        @Test
        void test23MovePawn() {
            p2 = new Pawn(4, 0, true);
            board.setPiece(p2.getPosition(), p2);
            assertThrows(IllegalArgumentException.class, () -> Move.movePawn("axb3", board, false));
        }

        @Test
        void test24MovePawn() {
            Pawn k2 = new Pawn(4, 0, true);
            board.setPiece(k2.getPosition(), k2);
            p2 = new Pawn(6, 3, false);
            board.setPiece(p2.getPosition(), p2);
            Pawn p1 = new Pawn(4, 1, false);
            board.setPiece(p1.getPosition(), p1);
            Move.movePawn("d4", board, true);
            assertThrows(IllegalArgumentException.class, () -> Move.movePawn("axb3", board, false));
        }

        @Test
        void test25MovePawn() {
            Rook r3 = new Rook(7, 0, false); //torre bianca
            board.setPiece(r3.getPosition(), r3);
            King k1 = new King(0, 0, true);      //re neri
            board.setPiece(k1.getPosition(), k1);
            Pawn a2 = new Pawn(4, 0, true);
            board.setPiece(a2.getPosition(), a2);
            p2 = new Pawn(6, 1, false);
            board.setPiece(p2.getPosition(), p2);
            Move.movePawn("b4", board, true);
            assertThrows(IllegalArgumentException.class, () -> Move.movePawn("axb3", board, false));
        }

        @Test
        void test26MovePawn() {
            Pawn k2 = new Pawn(1, 1, true);
            board.setPiece(k2.getPosition(), k2);
            p2 = new Pawn(3, 0, false);
            board.setPiece(p2.getPosition(), p2);
            Move.movePawn("b5", board, false);
            Move.movePawn("axb6", board, true);
            piece = board.getPiece(2, 1);
            assertTrue(piece.getName() == 'P');
        }

        @Test
        void test27MovePawn() {
            assertThrows(IllegalArgumentException.class, () -> Move.movePawn("b1", board, false));
        }

        @Test
        void test28MovePawn() {
            p2 = new Pawn(1, 0, true);
            board.setPiece(p2.getPosition(), p2);
            assertThrows(IllegalArgumentException.class, () -> Move.movePawn("a8", board, false));
        }
    }

    @Nested
    class moveCastlingTest {
        private Board board;
        private Rook r3;
        private King k1;
        private Piece piece;

        @BeforeEach
        void initialization() {
            board = new Board();
        }

        @Test
        void testMoveCastling() {
            r3 = new Rook(7, 7, false); //torre bianca
            board.setPiece(r3.getPosition(), r3);
            k1 = new King(7, 4, false);      //re bianco
            board.setPiece(k1.getPosition(), k1);
            Move.moveCastling("0-0", board, true);
            piece = board.getPiece(7, 6);
            assertTrue(piece.getName() == 'R');
        }

        @Test
        void test1MoveCastling() {
            r3 = new Rook(0, 7, true);
            board.setPiece(r3.getPosition(), r3);
            k1 = new King(0, 4, true);
            board.setPiece(k1.getPosition(), k1);
            Move.moveCastling("o-o", board, false);
            piece = board.getPiece(0, 6);
            assertTrue(piece.getName() == 'r');
        }

        @Test
        void test2MoveCastling() {
            r3 = new Rook(0, 0, true);
            board.setPiece(r3.getPosition(), r3);
            k1 = new King(0, 4, true);
            board.setPiece(k1.getPosition(), k1);
            Move.moveCastling("0-0-0", board, false);
            piece = board.getPiece(0, 2);
            assertTrue(piece.getName() == 'r');
        }

        @Test
        void test3MoveCastling() {
            r3 = new Rook(7, 4, true);
            board.setPiece(r3.getPosition(), r3);
            assertThrows(IllegalArgumentException.class, () -> Move.moveCastling("0-0", board, true));
        }

        @Test
        void test4MoveCastling() {
            assertThrows(IllegalArgumentException.class, () -> Move.moveCastling("0-0", board, true));
        }

        @Test
        void test5MoveCastling() {
            k1 = new King(7, 4, false);
            board.setPiece(k1.getPosition(), k1);
            k1.setFirstStep(false);
            assertThrows(IllegalArgumentException.class, () -> Move.moveCastling("0-0", board, true));
        }

        @Test
        void test6MoveCastling() {
        	r3 = new Rook(0, 4, true);
            board.setPiece(r3.getPosition(), r3);
            k1 = new King(7, 4, false);
            board.setPiece(k1.getPosition(), k1);
            assertThrows(IllegalArgumentException.class, () -> Move.moveCastling("0-0", board, true));
        }

        @Test
        void test7MoveCastling() {
            k1 = new King(7, 4, false);
            board.setPiece(k1.getPosition(), k1);
            assertThrows(IllegalArgumentException.class, () -> Move.moveCastling("0-0", board, true));
        }

        @Test
        void test8MoveCastling() {
            King r3 = new King(7, 7, true);
            board.setPiece(r3.getPosition(), r3);
            k1 = new King(7, 4, false);
            board.setPiece(k1.getPosition(), k1);
            assertThrows(IllegalArgumentException.class, () -> Move.moveCastling("0-0", board, true));
        }

        @Test
        void test9MoveCastling() {
            r3 = new Rook(7, 7, false);
            board.setPiece(r3.getPosition(), r3);
            r3.setFirstStep(false);
            k1 = new King(7, 4, false);
            board.setPiece(k1.getPosition(), k1);
            assertThrows(IllegalArgumentException.class, () -> Move.moveCastling("0-0", board, true));
        }

        @Test
        void test10MoveCastling() {
            r3 = new Rook(7, 7, false);
            board.setPiece(r3.getPosition(), r3);
            k1 = new King(7, 4, false);
            board.setPiece(k1.getPosition(), k1);
            Pawn r1 = new Pawn(7, 5, true);
            board.setPiece(r1.getPosition(), r1);
            assertThrows(IllegalArgumentException.class, () -> Move.moveCastling("0-0", board, true));
        }

        @Test
        void test11MoveCastling() {
            r3 = new Rook(7, 7, false);
            board.setPiece(r3.getPosition(), r3);
            k1 = new King(7, 4, false);
            board.setPiece(k1.getPosition(), k1);
            Pawn r2 = new Pawn(7, 6, true);
            board.setPiece(r2.getPosition(), r2);
            assertThrows(IllegalArgumentException.class, () -> Move.moveCastling("0-0", board, true));
        }

        @Test
        void test12MoveCastling() {
            r3 = new Rook(7, 7, false);
            board.setPiece(r3.getPosition(), r3);
            k1 = new King(7, 4, false);
            board.setPiece(k1.getPosition(), k1);
            Rook r2 = new Rook(6, 5, true);
            board.setPiece(r2.getPosition(), r2);
            assertThrows(IllegalArgumentException.class, () -> Move.moveCastling("0-0", board, true));
        }
    }

    @Nested
    class MoveQueenTest {
        private Integer ZERO = 0;
        private Integer ONE = 1;
        private Integer THREE = 3;
        private Integer FOUR = 4;
        private Integer FIVE = 5;
		private Integer SEVEN = 7;

        private Board board;
        private King k1;
        private Queen q1;
        private Queen q2;
        private Pawn p1;

		@BeforeEach
        void initialization() {
            board = new Board();
        }

        @Test
        void testMoveTop() {
            q2 = new Queen(SEVEN, THREE, false);
            board.setPiece(q2.getPosition(), q2);
            Move.moveQueen("Dd3", board, true);
            assertEquals(board.getPieceName(FIVE, THREE), 'D');
        }

        @Test
        void testMoveBottom() {
            q2 = new Queen(THREE, THREE, false);
            board.setPiece(q2.getPosition(), q2);
            Move.moveQueen("Dd3", board, true);
            assertEquals(board.getPieceName(FIVE, THREE), 'D');
        }

        @Test
        void testMoveRight() {
            q2 = new Queen(THREE, THREE, false);
            board.setPiece(q2.getPosition(), q2);
            Move.moveQueen("Df5", board, true);
            assertEquals(board.getPieceName(THREE, FIVE), 'D');
        }

        @Test
        void testMoveLeft() {
            q2 = new Queen(THREE, THREE, false);
            board.setPiece(q2.getPosition(), q2);
            Move.moveQueen("Db5", board, true);
            assertEquals(board.getPieceName(THREE, ONE), 'D');
        }

        @Test
        void testMoveDiagonalTopRight() {
            q2 = new Queen(THREE, THREE, false);
            board.setPiece(q2.getPosition(), q2);
            Move.moveQueen("Df7", board, true);
            assertEquals(board.getPieceName(ONE, FIVE), 'D');
        }

        @Test
        void testMoveDiagonalTopLeft() {
            q2 = new Queen(THREE, THREE, false);
            board.setPiece(q2.getPosition(), q2);
            Move.moveQueen("Db7", board, true);
            assertEquals(board.getPieceName(ONE, ONE), 'D');
        }

        @Test
        void testMoveDiagonalBottomRight() {
            q2 = new Queen(THREE, THREE, false);
            board.setPiece(q2.getPosition(), q2);
            Move.moveQueen("Df3", board, true);
            assertEquals(board.getPieceName(FIVE, FIVE), 'D');
        }

        @Test
        void testMoveDiagonalBottomLeft() {
            q2 = new Queen(THREE, THREE, false);
            board.setPiece(q2.getPosition(), q2);
            Move.moveQueen("Db3", board, true);
            assertEquals(board.getPieceName(FIVE, ONE), 'D');
        }

        @Test
        void testCaptureTop() {
            p1 = new Pawn(FIVE, THREE, true);
            q2 = new Queen(SEVEN, THREE, false);
            board.setPiece(p1.getPosition(), p1);
            board.setPiece(q2.getPosition(), q2);
            Move.moveQueen("Dxd3", board, true);
            assertEquals(board.getPieceName(FIVE, THREE), 'D');
        }

        @Test
        void testCaptureBottom() {
            p1 = new Pawn(FIVE, THREE, true);
            q2 = new Queen(THREE, THREE, false);
            board.setPiece(p1.getPosition(), p1);
            board.setPiece(q2.getPosition(), q2);
            Move.moveQueen("Dxd3", board, true);
            assertEquals(board.getPieceName(FIVE, THREE), 'D');
        }

        @Test
        void testCaptureRight() {
            p1 = new Pawn(THREE, FIVE, true);
            q2 = new Queen(THREE, THREE, false);
            board.setPiece(q2.getPosition(), q2);
            board.setPiece(p1.getPosition(), p1);
            Move.moveQueen("Dxf5", board, true);
            assertEquals(board.getPieceName(THREE, FIVE), 'D');
        }

        @Test
        void testCaptureLeft() {
            p1 = new Pawn(THREE, ONE, true);
            q2 = new Queen(THREE, THREE, false);
            board.setPiece(p1.getPosition(), p1);
            board.setPiece(q2.getPosition(), q2);
            Move.moveQueen("Dxb5", board, true);
            assertEquals(board.getPieceName(THREE, ONE), 'D');
        }

        @Test
        void testCaptureTopRight() {
			Integer SIX = 6;
			p1 = new Pawn(FOUR, SIX, true);
            q2 = new Queen(SEVEN, THREE, false);
            board.setPiece(p1.getPosition(), p1);
            board.setPiece(q2.getPosition(), q2);
            Move.moveQueen("Dxg4", board, true);
            assertEquals(board.getPieceName(FOUR, SIX), 'D');
        }

        @Test
        void testCaptureTopLeft() {
            p1 = new Pawn(FIVE, ONE, true);
            q2 = new Queen(SEVEN, THREE, false);
            board.setPiece(p1.getPosition(), p1);
            board.setPiece(q2.getPosition(), q2);
            Move.moveQueen("Dxb3", board, true);
            assertEquals(board.getPieceName(FIVE, ONE), 'D');
        }


        @Test
        void testCaptureBottomRight() {
            p1 = new Pawn(FIVE, FIVE, true);
            q2 = new Queen(THREE, THREE, false);
            board.setPiece(p1.getPosition(), p1);
            board.setPiece(q2.getPosition(), q2);
            Move.moveQueen("Dxf3", board, true);
            assertEquals(board.getPieceName(FIVE, FIVE), 'D');
        }

        @Test
        void testCaptureBottomLeft() {
            p1 = new Pawn(FIVE, ONE, false);
            q2 = new Queen(THREE, THREE, true);
            board.setPiece(p1.getPosition(), p1);
            board.setPiece(q2.getPosition(), q2);
            Move.moveQueen("Dxb3", board, false);
            assertEquals(board.getPieceName(FIVE, ONE), 'd');
        }

        @Test
        void testNoMoveRoad() { //Strada occupata da un'altro pezzo
            p1 = new Pawn(FIVE, THREE, false);
            q2 = new Queen(SEVEN, THREE, true);
            board.setPiece(p1.getPosition(), p1);
            board.setPiece(q2.getPosition(), q2);
            assertThrows(IllegalArgumentException.class, () -> Move.moveQueen("Dd4", board, false));
        }

        @Test
        void testNoMoveOccu() { //Posizione finale occupata da un altro pezzo
            p1 = new Pawn(FOUR, THREE, false);
            q2 = new Queen(SEVEN, THREE, true);
            board.setPiece(p1.getPosition(), p1);
            board.setPiece(q2.getPosition(), q2);
            assertThrows(IllegalArgumentException.class, () -> Move.moveQueen("Dd4", board, false));
        }

        @Test
        void testNoMovPos() {  //La posizione iniziale corrisponde con quella finale
            q2 = new Queen(SEVEN, THREE, true);
            board.setPiece(q2.getPosition(), q2);
            assertThrows(IllegalArgumentException.class, () -> Move.moveQueen("Dd1", board, false));
        }

        @Test
        void testNoMoveDied() { //La regina non Ã¨ presente nella scacchiera
            assertThrows(IllegalArgumentException.class, () -> Move.moveQueen("Dd1", board, false));
        }

        @Test
        void testNoCaptureRoad() { //Strada occupata da altro pezzo
            p1 = new Pawn(FOUR, THREE, false);
			Pawn p2 = new Pawn(FIVE, THREE, false);
            q2 = new Queen(SEVEN, THREE, true);
            board.setPiece(p1.getPosition(), p1);
            board.setPiece(p2.getPosition(), p2);
            board.setPiece(q2.getPosition(), q2);
            assertThrows(IllegalArgumentException.class, () -> Move.moveQueen("Dxd4", board, false));
        }

        @Test
        void testNoCaptureOccu() { //Posizione finale occupata da un pezzo che non e' dell'avversario
            p1 = new Pawn(FOUR, THREE, true);
            q2 = new Queen(SEVEN, THREE, true);
            board.setPiece(p1.getPosition(), p1);
            board.setPiece(q2.getPosition(), q2);
            assertThrows(IllegalArgumentException.class, () -> Move.moveQueen("Dxd4", board, false));
        }

        @Test
        void testNoCaptureEmpty() { //La casella di arrivo risulta vuota
            q2 = new Queen(SEVEN, THREE, true);
            board.setPiece(q2.getPosition(), q2);
            assertThrows(IllegalArgumentException.class, () -> Move.moveQueen("Dxd4", board, false));
        }

        @Test
        void testNoCapturePos() { //Posizione di partenza uguale a quella di arrivo
            q2 = new Queen(SEVEN, THREE, true);
            board.setPiece(q2.getPosition(), q2);
            assertThrows(IllegalArgumentException.class, () -> Move.moveQueen("Dxd1", board, false));
        }

        @Test
        void testNoCapture() { //Posizione di partenza uguale a quella di arrivo
            q2 = new Queen(SEVEN, THREE, true);
            board.setPiece(q2.getPosition(), q2);
            assertThrows(IllegalArgumentException.class, () -> Move.moveQueen("Dxd1", board, false));
        }

        @Test
        void testNoMoveEmpty() { //La regina non Ã¨ presente nella scacchiera
            assertThrows(IllegalArgumentException.class, () -> Move.moveQueen("Dxb8", board, false));
        }

        @Test
        void TestCheckMove() { //Controllo del proprio re sotto scacco
            k1 = new King(ZERO, ZERO, true);
            q1 = new Queen(FOUR, ZERO, false);
            q2 = new Queen(ONE, ZERO, true);
            board.setPiece(k1.getPosition(), k1);
            board.setPiece(q1.getPosition(), q1);
            board.setPiece(q2.getPosition(), q2);
            assertThrows(IllegalArgumentException.class, () -> Move.moveQueen("Db7", board, false));
        }

        @Test
        void TestCheckCapture() { //Controllo del proprio re sotto scacco
            k1 = new King(ZERO, ZERO, false);
            q1 = new Queen(FOUR, ZERO, true);
            q2 = new Queen(ONE, ZERO, false);
            p1 = new Pawn(ONE, ONE, true);
            board.setPiece(k1.getPosition(), k1);
            board.setPiece(p1.getPosition(), p1);
            board.setPiece(q1.getPosition(), q1);
            board.setPiece(q2.getPosition(), q2);
            assertThrows(IllegalArgumentException.class, () -> Move.moveQueen("Dxb7", board, true));
        }
        
        @Test
        void testdefault() {
        	q2 = new Queen(ONE, ZERO, false);
        	board.setPiece(q2.getPosition(), q2);
            assertThrows(IllegalArgumentException.class, () -> Move.moveQueen("0-0", board, true));
        }
    }

    @Nested
    class MoveKingTest {
        private Board board;
        private King king;
        Piece piece;

        @BeforeEach
        void initialization() {
            board = new Board();
        }

        @Test
        void testMoveKing() {
            king = new King(3, 3, true);
            board.setPiece(king.getPosition(), king);
            Move.moveKing("Rd6", board, false);
            piece = board.getPiece(2, 3);
            assertEquals(piece.getName(), 'r');
        }

        @Test
        void testMoveKing1() {
            king = new King(3, 3, false);
            board.setPiece(king.getPosition(), king);
            Move.moveKing("Re5", board, true);
            piece = board.getPiece(3, 4);
            assertEquals(piece.getName(), 'R');
        }

        @Test
        void testMoveKing2() {
            king = new King(3, 3, false);
            board.setPiece(king.getPosition(), king);
            Pawn pawn = new Pawn(3, 2, true);
            board.setPiece(pawn.getPosition(), pawn);
            Move.moveKing("Rxc5", board, true);
            piece = board.getPiece(3, 2);
            assertEquals(piece.getName(), 'R');
        }

        @Test
        void testMoveKing3() {
            assertThrows(IllegalArgumentException.class, () -> Move.moveKing("0-0", board, true));
        }

        @Test
        void testMoveKing4() {
            Pawn pawn = new Pawn(5, 3, true);
            board.setPiece(pawn.getPosition(), pawn);
            assertThrows(IllegalArgumentException.class, () -> Move.moveKing("Rd3", board, true));
        }

        @Test
        void testMoveKing5() {
            king = new King(3, 3, false);
            board.setPiece(king.getPosition(), king);
            Queen Queen = new Queen(2, 4, true);
            board.setPiece(Queen.getPosition(), Queen);
            assertThrows(IllegalArgumentException.class, () -> Move.moveKing("Rd6", board, true));
        }

        @Test
        void testMoveKing6() {
            king = new King(3, 3, false);
            board.setPiece(king.getPosition(), king);
            assertThrows(IllegalArgumentException.class, () -> Move.moveKing("Rxd6", board, true));
        }

        @Test
        void testMoveKing7() {
            king = new King(3, 3, false);
            board.setPiece(king.getPosition(), king);
            Queen Queen = new Queen(2, 3, false);
            board.setPiece(Queen.getPosition(), Queen);
            assertThrows(IllegalArgumentException.class, () -> Move.moveKing("Rxd6", board, true));
        }

        @Test
        void testMoveKing8() {
            king = new King(3, 3, false);
            board.setPiece(king.getPosition(), king);
            Queen Queen = new Queen(3, 4, true);
            board.setPiece(Queen.getPosition(), Queen);
            Queen Queen1 = new Queen(3, 5, true);
            board.setPiece(Queen1.getPosition(), Queen1);
            assertThrows(IllegalArgumentException.class, () -> Move.moveKing("Rxe5", board, true));
        }

    }

    @Nested
    class MoveRookTest {
        private Board board;
        private Rook r1, r2, r3, r4;
        private King king;
        private Piece piece;
        private Pawn pawn;
        private Rook rook, rook1, rook2;

        @BeforeEach
        void initialization() {
            board = new Board();
        }

        @Test
        void testMoveCaptureAmbigueRook() {
            r1 = new Rook(7, 0, false);
            board.setPiece(r1.getPosition(), r1);
            r2 = new Rook(0, 7, false);
            board.setPiece(r2.getPosition(), r2);
            Move.moveRook("Tah1", board, true);
            piece = board.getPiece(7, 7);
            assertTrue(piece.getName() == 'T');
        }

        @Test
        void test2MoveCaptureAmbigueRook() {
            r1 = new Rook(7, 0, false);
            board.setPiece(r1.getPosition(), r1);
            r2 = new Rook(0, 7, false);
            board.setPiece(r2.getPosition(), r2);
            Move.moveRook("T1h1", board, true);
            piece = board.getPiece(7, 7);
            assertTrue(piece.getName() == 'T');
        }

        @Test
        void test3MoveCaptureAmbigueRook() {
            r2 = new Rook(0, 7, false);
            board.setPiece(r2.getPosition(), r2);
            assertThrows(IllegalArgumentException.class, () -> Move.moveRook("Tah1", board, true));
        }

        @Test
        void test4MoveCaptureAmbigueRook() {
            r1 = new Rook(7, 0, false);
            board.setPiece(r1.getPosition(), r1);
            r2 = new Rook(7, 7, false);
            board.setPiece(r2.getPosition(), r2);
            Move.moveRook("Tad1", board, true);
            piece = board.getPiece(7, 3);
            assertTrue(piece.getName() == 'T');
        }

        @Test
        void test5MoveCaptureAmbigueRook() {
            r1 = new Rook(0, 0, false);
            board.setPiece(r1.getPosition(), r1);
            r2 = new Rook(7, 0, false);
            board.setPiece(r2.getPosition(), r2);
            Move.moveRook("T1a4", board, true);
            piece = board.getPiece(4, 0);
            assertTrue(piece.getName() == 'T');
        }

        @Test
        void test6MoveCaptureAmbigueRook() {
            r1 = new Rook(3, 5, false);
            board.setPiece(r1.getPosition(), r1);
            r2 = new Rook(1, 3, false);
            board.setPiece(r2.getPosition(), r2);
            Move.moveRook("Tdd5", board, true);
            piece = board.getPiece(3, 3);
            assertTrue(piece.getName() == 'T');
        }

        @Test
        void test7MoveCaptureAmbigueRook() {
            r1 = new Rook(7, 0, false);
            board.setPiece(r1.getPosition(), r1);
            r2 = new Rook(7, 7, false);
            board.setPiece(r2.getPosition(), r2);
            Move.moveRook("Thd1", board, true);
            piece = board.getPiece(7, 3);
            assertTrue(piece.getName() == 'T');
        }

        @Test
        void test8MoveCaptureAmbigueRook() {
            r1 = new Rook(7, 0, false);
            board.setPiece(r1.getPosition(), r1);
            r2 = new Rook(7, 7, false);
            board.setPiece(r2.getPosition(), r2);
            assertThrows(IllegalArgumentException.class, () -> Move.moveRook("Tbh1", board, true));
        }

        @Test
        void test9MoveCaptureAmbigueRook() {
            r1 = new Rook(0, 0, false);
            board.setPiece(r1.getPosition(), r1);
            r2 = new Rook(7, 0, false);
            board.setPiece(r2.getPosition(), r2);
            Move.moveRook("T8a4", board, true);
            piece = board.getPiece(4, 0);
            assertTrue(piece.getName() == 'T');
        }

        @Test
        void test10MoveCaptureAmbigueRook() {
            r1 = new Rook(0, 0, false);
            board.setPiece(r1.getPosition(), r1);
            r2 = new Rook(7, 0, false);
            board.setPiece(r2.getPosition(), r2);
            assertThrows(IllegalArgumentException.class, () -> Move.moveRook("T3a4", board, true));
        }


        @Test
        void test11MoveCaptureAmbigueRook() {
            r1 = new Rook(3, 5, false);
            board.setPiece(r1.getPosition(), r1);
            r2 = new Rook(1, 3, false);
            board.setPiece(r2.getPosition(), r2);
            assertThrows(IllegalArgumentException.class, () -> Move.moveRook("T3a4", board, true));
        }

        @Test
        void test12MoveCaptureAmbigueRook() {
            r1 = new Rook(3, 5, false);
            board.setPiece(r1.getPosition(), r1);
            r2 = new Rook(1, 3, false);
            board.setPiece(r2.getPosition(), r2);
            Move.moveRook("T7d5", board, true);
            piece = board.getPiece(3, 3);
            assertTrue(piece.getName() == 'T');
        }

        @Test
        void test13MoveCaptureAmbigueRook() {
            r1 = new Rook(4, 0, false);
            board.setPiece(r1.getPosition(), r1);
            r2 = new Rook(4, 4, false);
            board.setPiece(r2.getPosition(), r2);
            r3 = new Rook(7, 4, true);
            board.setPiece(r3.getPosition(), r3);
            King king = new King(0, 4, false);
            board.setPiece(king.getPosition(), king);
            assertThrows(IllegalArgumentException.class, () -> Move.moveRook("Teb4", board, true));
        }

        @Test
        void test14MoveCaptureAmbigueRook() {
            r1 = new Rook(0, 0, false);
            board.setPiece(r1.getPosition(), r1);
            r2 = new Rook(7, 0, false);
            board.setPiece(r2.getPosition(), r2);
            r3 = new Rook(4, 0, true);
            board.setPiece(r3.getPosition(), r3);
            Move.moveRook("T1xa4", board, true);
            piece = board.getPiece(4, 0);
            assertTrue(piece.getName() == 'T');
        }

        @Test
        void test15MoveCaptureAmbigueRook() {
            r1 = new Rook(0, 0, false);
            board.setPiece(r1.getPosition(), r1);
            r2 = new Rook(7, 0, false);
            board.setPiece(r2.getPosition(), r2);
            r3 = new Rook(4, 0, true);
            board.setPiece(r3.getPosition(), r3);
            assertThrows(IllegalArgumentException.class, () -> Move.moveRook("T1xb4", board, true));
        }

        @Test
        void test16MoveCaptureAmbigueRook() {
            r1 = new Rook(0, 0, false);
            board.setPiece(r1.getPosition(), r1);
            r2 = new Rook(7, 0, false);
            board.setPiece(r2.getPosition(), r2);
            king = new King(4, 0, false);
            board.setPiece(king.getPosition(), king);
            assertThrows(IllegalArgumentException.class, () -> Move.moveRook("T1xa4", board, true));
        }

        @Test
        void test17MoveCaptureAmbigueRook() {
            r1 = new Rook(0, 0, false);
            board.setPiece(r1.getPosition(), r1);
            r2 = new Rook(7, 0, false);
            board.setPiece(r2.getPosition(), r2);
            king = new King(4, 0, true);
            board.setPiece(king.getPosition(), king);
            r3 = new Rook(6, 0, true);
            board.setPiece(r3.getPosition(), r3);
            assertThrows(IllegalArgumentException.class, () -> Move.moveRook("T1xa4", board, true));
        }

        @Test
        void test18MoveCaptureAmbigueRook() {
            r1 = new Rook(0, 0, false);
            board.setPiece(r1.getPosition(), r1);
            r2 = new Rook(7, 0, false);
            board.setPiece(r2.getPosition(), r2);
            king = new King(4, 0, true);
            board.setPiece(king.getPosition(), king);
            r3 = new Rook(6, 0, true);
            board.setPiece(r3.getPosition(), r3);
            assertThrows(IllegalArgumentException.class, () -> Move.moveRook("T1xa4", board, true));
        }

        @Test
        void test19MoveCaptureAmbigueRook() {
            r1 = new Rook(4, 0, false);
            board.setPiece(r1.getPosition(), r1);
            r2 = new Rook(4, 7, false);
            board.setPiece(r2.getPosition(), r2);
            king = new King(7, 7, false);
            board.setPiece(king.getPosition(), king);
            r3 = new Rook(0, 7, true);
            board.setPiece(r3.getPosition(), r3);
            r4 = new Rook(4, 2, true);
            board.setPiece(r4.getPosition(), r4);
            assertThrows(IllegalArgumentException.class, () -> Move.moveRook("Thxc4", board, true));
        }

        @Test  //BIANCHI
        void testRookMoveTopWhites() {
            rook = new Rook(6, 7, false);
            board.setPiece(rook.getPosition(), rook);
            Move.moveRook("Th4", board, true);
            assertEquals(board.getPieceName(4, 7), 'T');
        }

        @Test
        void testRookMoveBottomWhites() {
            rook = new Rook(5, 3, false);
            board.setPiece(rook.getPosition(), rook);
            Move.moveRook("Tf3", board, true);
            assertEquals(board.getPieceName(5, 5), 'T');
        }

        @Test
        void testRookMoveRightWhites() {
            rook = new Rook(4, 4, false);
            board.setPiece(rook.getPosition(), rook);
            Move.moveRook("Tg4", board, true);
            assertEquals(board.getPieceName(4, 6), 'T');
        }

        @Test
        void testRookMoveLeftWhites() {
            rook = new Rook(5, 7, false);
            board.setPiece(rook.getPosition(), rook);
            Move.moveRook("Tf3", board, true);
            assertEquals(board.getPieceName(5, 5), 'T');
        }

        @Test
        void testRookCaptureTopWhites() {
            pawn = new Pawn(4, 6, true);
            rook = new Rook(6, 6, false);
            board.setPiece(pawn.getPosition(), pawn);
            board.setPiece(rook.getPosition(), rook);
            Move.moveRook("Txg4", board, true);
            assertEquals(board.getPieceName(4, 6), 'T');
        }

        @Test
        void testRookCaptureBottomWhites() {
            pawn = new Pawn(6, 6, true);
            rook = new Rook(4, 6, false);
            board.setPiece(pawn.getPosition(), pawn);
            board.setPiece(rook.getPosition(), rook);
            Move.moveRook("Txg2", board, true);
            assertEquals(board.getPieceName(6, 6), 'T');
        }

        @Test
        void testRookCaptureRightWhites() {
            pawn = new Pawn(4, 6, true);
            rook = new Rook(4, 5, false);
            board.setPiece(pawn.getPosition(), pawn);
            board.setPiece(rook.getPosition(), rook);
            Move.moveRook("Txg4", board, true);
            assertEquals(board.getPieceName(4, 6), 'T');
        }

        @Test
        void testRookCaptureLeftWhites() {
            pawn = new Pawn(4, 4, true);
            rook = new Rook(4, 6, false);
            board.setPiece(pawn.getPosition(), pawn);
            board.setPiece(rook.getPosition(), rook);
            Move.moveRook("Txe4", board, true);
            assertEquals(board.getPieceName(4, 4), 'T');
        }

        @Test
        void testRookNoMoveWhites() {
            pawn = new Pawn(4, 5, true);
            rook = new Rook(4, 6, false);
            board.setPiece(pawn.getPosition(), pawn);
            board.setPiece(rook.getPosition(), rook);
            assertThrows(IllegalArgumentException.class, () ->  Move.moveRook("Tf4", board, true));
                
        }

       @Test
        void testRookException1() {
            assertThrows(IllegalArgumentException.class, () ->  Move.moveRook("Tf4", board, true));
               
        }

        @Test
        void testRookException2Whites() {  //Re sotto scacco
            king = new King(2, 3, true);
            rook = new Rook(3, 3, true);
            rook1 = new Rook(4, 3, false);
            board.setPiece(king.getPosition(), king);
            board.setPiece(rook.getPosition(), rook);
            board.setPiece(rook1.getPosition(), rook1);
            assertThrows(IllegalArgumentException.class, () -> Move.moveRook("Te5", board, false));
        }

        @Test
        void testRookException2WhitesCapt() {  //Re sotto scacco
            king = new King(2, 3, true);
            rook = new Rook(3, 3, true);
            rook1 = new Rook(4, 3, false);
            pawn = new Pawn(3, 4, false);
            board.setPiece(king.getPosition(), king);
            board.setPiece(rook.getPosition(), rook);
            board.setPiece(rook1.getPosition(), rook1);
            board.setPiece(pawn.getPosition(), pawn);
            assertThrows(IllegalArgumentException.class, () -> Move.moveRook("Txe5", board, false));
        }

        @Test
        void testRookException3Whites() {
            rook = new Rook(4, 2, false);
            rook1 = new Rook(3, 3, false);
            rook2 = new Rook(4, 4, false);
            pawn = new Pawn(4, 3, true);
            board.setPiece(rook.getPosition(), rook);
            board.setPiece(rook1.getPosition(), rook);
            board.setPiece(rook2.getPosition(), rook);
            board.setPiece(pawn.getPosition(), pawn);
            assertThrows(IllegalArgumentException.class, () -> Move.moveRook("Txd4", board, true));
        }

        @Test
        void testRookException4Capt(){
            pawn = new Pawn(3, 3, false);
            board.setPiece(pawn.getPosition(), pawn);
            assertThrows(IllegalArgumentException.class, () -> Move.moveRook("Txd5", board, false));
        }

    /*@Test
    void testmoveCaptureAmbigueRook1(){
        rook = new Rook(5, 0, false);
        rook1 = new Rook(7, 7, false);
        board.setPiece(rook.getPosition(), rook);
        board.setPiece(rook1.getPosition(), rook1);
        Move.moveRook("Thh3", board, true);
        assertFalse(board.getPiece(5,7).equals("T"));
    }

    @Test
    void testmoveCaptureAmbigueRook2(){
        rook = new Rook(5, 0, false);
        rook1 = new Rook(7, 7, false);
        pawn = new Pawn(5, 7, true);
        board.setPiece(rook.getPosition(), rook);
        board.setPiece(rook1.getPosition(), rook1);
        board.setPiece(pawn.getPosition(), pawn);
        Move.moveRook("Txhh3", board, true);
        assertFalse(board.getPiece(5,7).equals("T"));
    }*/

        @Test  //NERI
        void testRookMoveTopBlacks() {
            rook = new Rook(2, 0, true);
            board.setPiece(rook.getPosition(), rook);
            Move.moveRook("Ta4", board, false);
            assertEquals(board.getPieceName(4, 0), 't');
        }

        @Test
        void testRookMoveBottomBlacks() {
            rook = new Rook(4, 7, true);
            board.setPiece(rook.getPosition(), rook);
            Move.moveRook("Th6", board, false);
            assertEquals(board.getPieceName(2, 7), 't');
        }

        @Test
        void testRookMoveRightBlacks() {
            rook = new Rook(2, 0, true);
            board.setPiece(rook.getPosition(), rook);
            Move.moveRook("Tc6", board, false);
            assertEquals(board.getPieceName(2, 2), 't');
        }

        @Test
        void testRookMoveLeftBlacks() {
            rook = new Rook(2, 7, true);
            board.setPiece(rook.getPosition(), rook);
            Move.moveRook("Tf6", board, false);
            assertEquals(board.getPieceName(2, 5), 't');
        }

        @Test
        void testRookCaptureTopBlacks() {
            pawn = new Pawn(6, 3, false);
            rook = new Rook(4, 3, true);
            board.setPiece(pawn.getPosition(), pawn);
            board.setPiece(rook.getPosition(), rook);
            Move.moveRook("Txd2", board, false);
            assertEquals(board.getPieceName(6, 3), 't');
        }

        @Test
        void testRookCaptureBottomBlacks() {
            pawn = new Pawn(4, 3, false);
            rook = new Rook(6, 3, true);
            board.setPiece(pawn.getPosition(), pawn);
            board.setPiece(rook.getPosition(), rook);
            Move.moveRook("Txd4", board, false);
            assertEquals(board.getPieceName(4, 3), 't');
        }

        @Test
        void testRookCaptureRightBlacks() {
            pawn = new Pawn(6, 3, false);
            rook = new Rook(4, 3, true);
            board.setPiece(pawn.getPosition(), pawn);
            board.setPiece(rook.getPosition(), rook);
            Move.moveRook("Txd2", board, false);
            assertEquals(board.getPieceName(6, 3), 't');
        }

        @Test
        void testRookCaptureLeftBlacks() {
            pawn = new Pawn(2, 5, false);
            rook = new Rook(2, 7, true);
            board.setPiece(pawn.getPosition(), pawn);
            board.setPiece(rook.getPosition(), rook);
            Move.moveRook("Txf6", board, false);
            assertEquals(board.getPieceName(2, 5), 't');
        }

        @Test
        void testRookNoCaptureBlacks() {
            pawn = new Pawn(4, 4, false);
            rook = new Rook(5, 5, true);
            board.setPiece(pawn.getPosition(), pawn);
            board.setPiece(rook.getPosition(), rook);
            assertThrows(IllegalArgumentException.class, () ->  Move.moveRook("Txe4", board, true));
        }

        @Test
        void testRookException1Capt() {
            assertThrows(IllegalArgumentException.class, () ->  Move.moveRook("Txf4", board, true));
        }

        @Test
        void testRookException2Blacks() {  //Re sotto scacco
            king = new King(2, 3, false);
            rook = new Rook(3, 3, false);
            rook1 = new Rook(4, 3, true);
            board.setPiece(king.getPosition(), king);
            board.setPiece(rook.getPosition(), rook);
            board.setPiece(rook1.getPosition(), rook1);
            assertThrows(IllegalArgumentException.class, () -> Move.moveRook("Te5", board, true));
        }

        @Test
        void testRookException2BlacksCapt() {  //Re sotto scacco
            king = new King(2, 3, false);
            rook = new Rook(3, 3, false);
            rook1 = new Rook(4, 3, true);
            pawn = new Pawn(3, 4, true);
            board.setPiece(king.getPosition(), king);
            board.setPiece(rook.getPosition(), rook);
            board.setPiece(rook1.getPosition(), rook1);
            board.setPiece(pawn.getPosition(), pawn);
            assertThrows(IllegalArgumentException.class, () -> Move.moveRook("Txe5", board, true));
        }

        @Test
        void testRookException3Blacks() {
            rook = new Rook(5, 2, true);
            rook1 = new Rook(5, 5, true);
            board.setPiece(rook.getPosition(), rook);
            board.setPiece(rook1.getPosition(), rook1);
            assertThrows(IllegalArgumentException.class, () -> Move.moveRook("Td3", board, false));
        }
    }

    @Nested
    class MoveBishopTest {
        private Board board;

        @BeforeEach
        void setUp() {
            board = new Board();
            board.fillBoard();
        }

        @Test
        void moveBishop_BishopMove() {
            Move.movePawn("g3", board, true);
            Move.moveBishop("Ah3", board, true);
            assertEquals(board.getPieceName(5,7), 'A');
        }

        @Test
        void moveBishop_BishopCapture() {
            Move.movePawn("g3", board, true);
            board.setPiece(new Position(5,7), board.getPiece(1,7));
            Move.moveBishop("Axh3", board, true);
            assertEquals(board.getPieceName(5,7), 'A');
        }

        @Test
        void moveBishop_NoBishops() {
            board.setEmpty(7,2);
            board.setEmpty(7,5);
            assertThrows(IllegalArgumentException.class, () -> Move.moveBishop("Af3", board, true));
        }

        @Test
        void moveBishop_SamePositionsTwoBishops() {
            assertThrows(IllegalArgumentException.class, () -> Move.moveBishop("Ac1", board, true));
        }

        @Test
        void moveBishop_SamePositionsOneBishop() {
            board.setEmpty(0,2);
            assertThrows(IllegalArgumentException.class, () -> Move.moveBishop("Af8", board, false));
        }

        @Test
        void moveBishop_OneBishopMoveNotFreeDiagonal() {
            board.setEmpty(7,2);
            assertThrows(IllegalArgumentException.class, () -> Move.moveBishop("Ah3", board, true));
        }

        @Test
        void moveBishop_BishopMoveAnotherPieceFound() {
            assertThrows(IllegalArgumentException.class, () -> Move.moveBishop("Ab2", board, true));
        }

        @Test
        void moveBishop_BishopCaptureSameColor() {
            assertThrows(IllegalArgumentException.class, () -> Move.moveBishop("Axb2", board, true));
        }

        @Test
        void moveBishop_BishopCaptureEmptySpace() {
            Move.movePawn("b3", board, true);
            assertThrows(IllegalArgumentException.class, () -> Move.moveBishop("Axa3", board, true));
        }

        @Test
        void moveBishop_BishopMoveKingCheck() {
            board.setEmpty(6,4);
            Move.moveBishop("Ae2", board, true);
            board.setPiece(new Position(5,4), board.getPiece(0,3));
            assertThrows(IllegalArgumentException.class, () -> Move.moveBishop("Af3", board, true));
        }

        @Test
        void moveBishop_BishopCaptureKingCheck() {
            board.setEmpty(6,4);
            Move.moveBishop("Ae2", board, true);
            board.setPiece(new Position(5,4), board.getPiece(0,3));
            board.setPiece(new Position(5,5), board.getPiece(1,5));
            assertThrows(IllegalArgumentException.class, () -> Move.moveBishop("Axf3", board, true));
        }

        @Test
        void moveBishop_DefaultCase() {
            assertThrows(IllegalArgumentException.class, () -> Move.moveBishop("play", board, true));
        }

        @Test
        void moveBishop_BishopCaptureNotFreeDiagonal() {
            board.setPiece(new Position(5,7), board.getPiece(1,7));
            assertThrows(IllegalArgumentException.class, () -> Move.moveBishop("Axh3", board, true));
        }
    }

	@Nested
	class MoveKnightTest {
		Board boardTest=new Board();
		Board boardResult=new Board();
		Knight knight;
		
		Knight secondKnight;

		@Test
		void testMoveWhiteKnightOne() { // mossa valida il cavallo giunge in C6
			knight = new Knight(0,1,true);
			secondKnight = new Knight(2,2,true);
			boardTest.setPiece(knight.getPosition(), knight);
			Move.moveKnight("Cc6", boardTest, false);
			assertEquals(secondKnight.getPosition(),knight.getPosition());
		}
		@Test
		void testMoveWhiteKnightConflitto() { // conflitto con due cavalli bianchi
			knight = new Knight(0,1,true);
			secondKnight = new Knight(0,3,true);
			boardTest.setPiece(knight.getPosition(), knight);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Cc6", boardTest, true));
		}
		@Test
		void testMoveWhiteKnightFintoConflitto() { // due cavalli uno solo si puo' muovere
			knight = new Knight(0,1,true);
			secondKnight = new Knight(0,0,true);
			Position pos = new Position(2,2);
			boardTest.setPiece(knight.getPosition(), knight);
			Move.moveKnight("Cc6", boardTest, false);
			assertEquals(pos,knight.getPosition());
		}
		@Test
		void testMoveWhiteKnightFintoConflitto2() { // due cavalli uno solo si puo' muovere
			knight = new Knight(0,1,true);
			secondKnight = new Knight(0,2,true);
			Position pos = new Position(2,2);
			boardTest.setPiece(knight.getPosition(), knight);
			Move.moveKnight("Cc6", boardTest, false);
			assertEquals(pos,knight.getPosition());
		}
		@Test
		void testMoveWhiteKnightFintoConflitto3() { // due cavalli uno solo si puo' muovere
			knight = new Knight(0,1,true);
			secondKnight = new Knight(0,2,false);
			Position pos = new Position(2,2);
			boardTest.setPiece(knight.getPosition(), knight);
			Move.moveKnight("Cc6", boardTest, false);
			assertEquals(pos,knight.getPosition());
		}
		@Test
		void testMoveWhiteKnightFintoConflitto4() { // due cavalli uno solo si puo' muovere
			knight = new Knight(0,1,true);
			secondKnight = new Knight(0,0,false);
			Position pos = new Position(2,2);
			boardTest.setPiece(knight.getPosition(), knight);
			Move.moveKnight("Cc6", boardTest, false);
			assertEquals(pos,knight.getPosition());
		}
		@Test
		void testMoveWhiteKnightFintoConflittoColonna() { // due cavalli uno solo si puo' muovere
			knight = new Knight(1,0,true);
			secondKnight = new Knight(3,0,false);
			Position pos = new Position(2,2);
			boardTest.setPiece(knight.getPosition(), knight);
			Move.moveKnight("Cc6", boardTest, false);
			assertEquals(pos,knight.getPosition());
		}
		@Test
		void testMoveWhiteKnightFintoConflittoColonna2() { // due cavalli uno solo si puo' muovere
			knight = new Knight(1,0,true);
			secondKnight = new Knight(3,0,true);
			boardTest.setPiece(knight.getPosition(), knight);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Cc6", boardTest, true));
		}
		@Test
		void testMoveWhiteKnightFintoConflittoColonna3() { // due cavalli uno solo si puo' muovere
			knight = new Knight(1,0,true);
			secondKnight = new Knight(5,0,false);
			Position pos = new Position(2,2);
			boardTest.setPiece(knight.getPosition(), knight);
			Move.moveKnight("Cc6", boardTest, false);
			assertEquals(pos,knight.getPosition());
		}
		@Test
		void testMoveWhiteKnightFintoConflittoColonna4() { // due cavalli nessuno si puo' muovere
			knight = new Knight(1,0,true);
			secondKnight = new Knight(5,0,false);
			boardTest.setPiece(knight.getPosition(), knight);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Cd6", boardTest, true));
		}
		@Test
		void testMoveWhiteKnightVuota() { // scacchiera vuota
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Cc6", boardTest, true));
		}
		@Test
		void testMoveWhiteKnightCattura() { // cattura di un cavallo
			knight = new Knight(0,1,true);
			secondKnight = new Knight(2,2,false);
			Position pos = new Position(2,2);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("Cxc6", boardTest, false);
			assertEquals(pos,knight.getPosition());
		}
		@Test
		void testMoveWhiteKnightCattura2() { // cattura errata
			knight = new Knight(0,1,true);
			secondKnight = new Knight(2,2,true);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Cxc6", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightCattura3() { // cattura errata nulla da mangiare
			knight = new Knight(0,1,true);
			secondKnight = new Knight(2,3,true);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Cxc6", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightCattura4() { // cattura errata conflitto
			knight = new Knight(0,1,true);
			secondKnight = new Knight(0,3,true);
			Knight knightT = new Knight(2,2,false);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			boardTest.setPiece(knightT.getPosition(), knightT);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Cxc6", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightCattura5() { // cattura 
			knight = new Knight(0,1,true);
			secondKnight = new Knight(0,3,false);
			Knight knightT = new Knight(2,2,false);
			Position pos = new Position(2,2);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			boardTest.setPiece(knightT.getPosition(), knightT);
			Move.moveKnight("Cxc6", boardTest, false);
			assertEquals(pos,knight.getPosition());
		}
		@Test
		void testMoveWhiteKnightCattura6() { // cattura errata nulla da mangiare
			knight = new Knight(0,1,true);
			secondKnight = new Knight(0,4,true);
			Knight knightT = new Knight(2,2,false);
			Position pos = new Position(2,2);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			boardTest.setPiece(knightT.getPosition(), knightT);
			Move.moveKnight("Cxc6", boardTest, false);
			assertEquals(pos,knight.getPosition());
		}
		@Test
		void testMoveWhiteKnightCattura7() { // cattura errata nulla da mangiare
			knight = new Knight(0,0,true);
			secondKnight = new Knight(0,3,true);
			Knight knightT = new Knight(2,2,false);
			Position pos = new Position(2,2);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			boardTest.setPiece(knightT.getPosition(), knightT);
			Move.moveKnight("Cxc6", boardTest, false);
			assertEquals(pos,secondKnight.getPosition());
		}
		
		//________________________________Test con conflitto_________________________________
		
		@Test
		void testMoveWhiteKnightCatturaConflitto1() {
			knight = new Knight(0,1,true);
			secondKnight = new Knight(0,3,true);
			Knight knightT = new Knight(2,2,false);
			Position pos = new Position(2,2);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			boardTest.setPiece(knightT.getPosition(), knightT);
			Move.moveKnight("Cbxc6", boardTest, false);
			assertEquals(pos,knight.getPosition());
		}
		@Test
		void testMoveWhiteKnightCatturaConflitto2() {
			knight = new Knight(0,1,true);
			secondKnight = new Knight(0,3,true);
			Knight knightT = new Knight(2,2,false);
			Position pos = new Position(2,2);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			boardTest.setPiece(knightT.getPosition(), knightT);
			Move.moveKnight("Cdxc6", boardTest, false);
			assertEquals(pos,secondKnight.getPosition());
		}
		@Test
		void testMoveWhiteKnightConflitto1() {
			knight = new Knight(0,1,true);
			secondKnight = new Knight(0,3,true);
			Position pos = new Position(2,2);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("Cdc6", boardTest, false);
			assertEquals(pos,secondKnight.getPosition());
		}
		@Test
		void testMoveWhiteKnightConflitto2() {
			knight = new Knight(0,1,true);
			secondKnight = new Knight(0,3,true);
			Position pos = new Position(2,2);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("Cbc6", boardTest, false);
			assertEquals(pos,knight.getPosition());
		}
		@Test
		void testMoveWhiteKnightCatturaConFintoConflitto() {
			knight = new Knight(0,1,true);
			secondKnight = new Knight(0,3,false);
			Knight knightT = new Knight(2,2,false);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			boardTest.setPiece(knightT.getPosition(), knightT);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Cbxc6", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightCatturaConFintoConflitto2() {
			knight = new Knight(0,1,false);
			secondKnight = new Knight(0,3,true);
			Knight knightT = new Knight(2,2,false);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			boardTest.setPiece(knightT.getPosition(), knightT);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Cdxc6", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightCatturaConFintoConflitto3() {
			knight = new Knight(0,1,false);
			secondKnight = new Knight(0,3,true);
			Knight knightT = new Knight(2,2,false);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			boardTest.setPiece(knightT.getPosition(), knightT);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Ccxc6", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightCatturaConflittoColonna() { // mossa conflitto su colonne
			knight = new Knight(1,0,true);
			secondKnight = new Knight(3,0,true);
			Knight knightT = new Knight(2,2,false);
			Position pos = new Position(2,2);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			boardTest.setPiece(knightT.getPosition(), knightT);
			Move.moveKnight("C7xc6", boardTest, false);
			assertEquals(pos,knight.getPosition());
		}
		@Test
		void testMoveWhiteKnightCatturaConflittoColonna2() { // mossa conflitto su colonne
			knight = new Knight(1,0,true);
			secondKnight = new Knight(3,0,true);
			Knight knightT = new Knight(2,2,false);
			Position pos = new Position(2,2);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			boardTest.setPiece(knightT.getPosition(), knightT);
			Move.moveKnight("C5xc6", boardTest, false);
			assertEquals(pos,secondKnight.getPosition());
		}
		@Test
		void testMoveWhiteKnightCatturaConflittoColonna3() { // mossa conflitto su colonne
			knight = new Knight(1,0,true);
			secondKnight = new Knight(3,0,true);
			Knight knightT = new Knight(2,2,false);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			boardTest.setPiece(knightT.getPosition(), knightT);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("C6xc6", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightCatturaConflittoColonna4() { // mossa conflitto su colonne
			knight = new Knight(1,0,true);
			secondKnight = new Knight(3,0,true);
			Position pos = new Position(2,2);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("C7c6", boardTest, false);
			assertEquals(pos,knight.getPosition());
		}
		@Test
		void testMoveWhiteKnightCatturaConflittoColonna5() { // mossa conflitto su colonne
			knight = new Knight(1,0,true);
			secondKnight = new Knight(3,0,true);
			Position pos = new Position(2,2);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("C5c6", boardTest, false);
			assertEquals(pos,secondKnight.getPosition());
		}
		@Test
		void testMoveWhiteKnightCatturaConflittoColonna6() { // mossa conflitto su colonne
			knight = new Knight(1,1,true);
			secondKnight = new Knight(1,3,true);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Cc6", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightCatturaConflittoColonna7() { // mossa conflitto su colonne
			knight = new Knight(1,1,true);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(knight.getPosition(), knight);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Cc6", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightKing() { // mossa conflitto su colonne
			knight = new Knight(2,3,true);
			Rook rook = new Rook(1,3,false);
			King king = new King(3,3,true);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(rook.getPosition(), rook);
			boardTest.setPiece(king.getPosition(), king);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Ce8", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightKing2() { // mossa conflitto su colonne
			knight = new Knight(2,3,true);
			Knight secondKnight = new Knight(0,4,false);
			Rook rook = new Rook(1,3,false);
			King king = new King(3,3,true);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(rook.getPosition(), rook);
			boardTest.setPiece(king.getPosition(), king);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			boardTest.setPiece(rook.getPosition(), rook);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Cxe8", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightKing3() { // mossa conflitto su colonne
			knight = new Knight(2,3,true);
			Knight secondKnight = new Knight(0,4,true);
			Rook rook = new Rook(1,3,false);
			King king = new King(3,3,true);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(rook.getPosition(), rook);
			boardTest.setPiece(king.getPosition(), king);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			boardTest.setPiece(rook.getPosition(), rook);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Ce8", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightKing4() { // mossa conflitto su colonne
			knight = new Knight(2,3,true);
			Knight secondKnight = new Knight(0,4,true);
			Rook rook = new Rook(1,3,false);
			King king = new King(3,3,true);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(rook.getPosition(), rook);
			boardTest.setPiece(king.getPosition(), king);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Ce8", boardTest, false));
		}
		@Test
		void testMoveWhiteKnight() { // mossa conflitto su colonne
			knight = new Knight(3,2,true);
			Rook rook = new Rook(1,0,true);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(rook.getPosition(), rook);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Ccxa6", boardTest, false));
		}
		@Test
		void testMoveWhiteKnight2() { // mossa conflitto su colonne
			knight = new Knight(2,2,true);
			Knight secondKnight = new Knight(1,0,false);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Ccxa6", boardTest, false));

		}
		@Test
		void testMoveWhiteKnight3() { // mossa conflitto su colonne
			knight = new Knight(2,2,true);
			Knight secondKnight = new Knight(2,0,false);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Cab8", boardTest, false));

		}
		@Test
		void testMoveWhiteKnightKing5() { // mossa conflitto su colonne
			knight = new Knight(4,2,true);
			Knight secondKnight = new Knight(3,4,true);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Ced7", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightKing6() { // mossa conflitto su colonne
			knight = new Knight(3,2,true);
			Knight secondKnight = new Knight(4,4,true);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Ced7", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightKing7() { // mossa conflitto su colonne
			knight = new Knight(3,2,true);
			Knight secondKnight = new Knight(3,4,true);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Cdd7", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightKing8() { // mossa conflitto su colonne
			knight = new Knight(3,4,true);
			Knight secondKnight = new Knight(5,4,true);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("C5g7", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightKing9() { // mossa conflitto su colonne
			knight = new Knight(3,3,true);
			Knight secondKnight = new Knight(5,4,true);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("C5g7", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightKing10() { // mossa conflitto su colonne
			knight = new Knight(3,4,true);
			Knight secondKnight = new Knight(5,3,true);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("C5g7", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightKing11() { // mossa conflitto su colonne
			knight = new Knight(3,2,true);
			Knight secondKnight = new Knight(2,3,true);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Cdb7", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightKing12() { // mossa conflitto su colonne
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Cdb7", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightKing13() { // mossa conflitto su colonne
			knight = new Knight(3,2,true);
			Knight secondKnight = new Knight(3,4,true);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Cdd3", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightKing14() { // mossa conflitto su colonne
			knight = new Knight(3,2,false);
			Knight secondKnight = new Knight(3,4,true);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Cdd3", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightKing15() { // mossa conflitto su colonne
			knight = new Knight(3,2,true);
			Knight secondKnight = new Knight(3,4,false);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Cdd3", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightKingcattura() { 
			knight = new Knight(3,2,false);
			Knight secondKnight = new Knight(3,4,true);
			Knight knightT = new Knight(5,3,false);
			boardTest.setPiece(knightT.getPosition(), knightT);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Cdd3", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightKingcattura2() { 
			knight = new Knight(3,2,true);
			Knight secondKnight = new Knight(3,4,true);
			Rook rook = new Rook(2,2,false);
			King king = new King(4,2,true);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(king.getPosition(), king);
			boardTest.setPiece(rook.getPosition(), rook);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Ccd3", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightKingcattura3() { 
			knight = new Knight(3,2,true);
			Knight secondKnight = new Knight(3,4,true);
			Knight knightT = new Knight(5,3,true);
			boardTest.setPiece(knightT.getPosition(), knightT);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Ccxd3", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightKingcattura4() { 
			knight = new Knight(3,2,true);
			Knight secondKnight = new Knight(3,4,true);
			Knight knightT = new Knight(5,3,false);
			Rook rook = new Rook(2,2,false);
			King king = new King(4,2,true);
			boardTest.setPiece(knightT.getPosition(), knightT);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(king.getPosition(), king);
			boardTest.setPiece(rook.getPosition(), rook);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Ccxd3", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightKingcattura5() { 
			knight = new Knight(3,2,true);
			Knight secondKnight = new Knight(3,4,true);
			Rook rook = new Rook(2,2,false);
			King king = new King(4,2,true);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(king.getPosition(), king);
			boardTest.setPiece(rook.getPosition(), rook);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Ccxd3", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightKingcattura6() { 
			knight = new Knight(1,2,true);
			Knight secondKnight = new Knight(3,4,true);
			Rook rook = new Rook(2,2,false);
			King king = new King(4,2,true);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(king.getPosition(), king);
			boardTest.setPiece(rook.getPosition(), rook);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Ccxd3", boardTest, false));
		}
		@Test
		void testMoveWhiteKnight1() { // mossa conflitto
			knight = new Knight(4,1,false);
			boardTest.setPiece(knight.getPosition(), knight);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("C1a3", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightDefault() { // mossa conflitto
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("o-o", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightKingcattura7() { 
			knight = new Knight(1,2,true);
			Knight secondKnight = new Knight(1,4,true);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Cbd5", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightKingCol() { 
			knight = new Knight(6,1,true);
			Knight secondKnight = new Knight(6,3,true);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Cab4", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightKingCol1() { 
			knight = new Knight(6,6,true);

			boardTest.setPiece(knight.getPosition(), knight);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Cbe4", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightKingCol2() { 
			knight = new Knight(6,5,true);
			Knight secondKnight = new Knight(6,3,true);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Cdr3", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightKingCol3() { 
			knight = new Knight(1,3,true);
			Knight secondKnight = new Knight(1,5,true);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("Che4", boardTest, false));
		}
		@Test
		void testMoveWhiteKnightKingCol4() { 
			knight = new Knight(2,5,true);
			Knight secondKnight = new Knight(4,5,true);
			Position pos = new Position(3,7);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("C4h5", boardTest, false);
			assertEquals(pos,secondKnight.getPosition());
		}
		@Test
		void testMoveWhiteKnightKingCol5() { 
			knight = new Knight(5,3,true);
			Knight secondKnight = new Knight(5,5,true);
			Position pos = new Position(7,4);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("Cfe1", boardTest, false);
			assertEquals(pos,secondKnight.getPosition());
		}
		@Test
		void testMoveWhiteKnightKingCol6() { 
			knight = new Knight(5,3,true);
			Knight secondKnight = new Knight(5,5,true);
			Position pos = new Position(7,4);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("Cfe1", boardTest, false);
			assertEquals(pos,secondKnight.getPosition());
		}@Test
		void testMoveWhiteKnightKingCol7() { 
			knight = new Knight(2,2,true);
			Knight secondKnight = new Knight(4,2,true);
			Position pos = new Position(3,0);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("C6a5", boardTest, false);
			assertEquals(pos,knight.getPosition());
		}
		@Test
		void testMoveWhiteKnightKingCol8() { 
			knight = new Knight(5,3,true);
			Knight secondKnight = new Knight(5,5,true);
			Position pos = new Position(7,4);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("Cfe1", boardTest, false);
			assertEquals(pos,secondKnight.getPosition());
		}
		@Test
		void testMoveWhiteKnightKingCol9() { 
			knight = new Knight(5,3,true);
			Knight secondKnight = new Knight(5,5,true);
			Position pos = new Position(7,4);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("Cfe1", boardTest, false);
			assertEquals(pos,secondKnight.getPosition());
		}
		@Test
		void testMoveWhiteKnightKingCol10() { 
			knight = new Knight(2,2,true);
			Knight secondKnight = new Knight(4,2,true);
			Position pos = new Position(3,0);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("C6a5", boardTest, false);
			assertEquals(pos,knight.getPosition());
		}
		@Test
		void testMoveWhiteKnightKingCol11() { 
			knight = new Knight(2,3,true);
			Knight secondKnight = new Knight(2,5,true);
			Position pos = new Position(0,4);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("Cde8", boardTest, false);
			assertEquals(pos,knight.getPosition());
		}
		@Test
		void testMoveWhiteKnightKingCol12() { 
			knight = new Knight(2,5,true);
			Knight secondKnight = new Knight(4,5,true);
			Position pos = new Position(3,7);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("C4h5", boardTest, false);
			assertEquals(pos,secondKnight.getPosition());
		}
		@Test
		void testMoveWhiteKnightKingcol13() { 
			knight = new Knight(5,3,true);
			Knight secondKnight = new Knight(5,5,true);
			Position pos = new Position(7,4);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("Cfe1", boardTest, false);
			assertEquals(pos,secondKnight.getPosition());
		}
		@Test
		void testMoveWhiteKnightKingCol14() { 
			knight = new Knight(5,3,true);
			Knight secondKnight = new Knight(5,5,true);
			Position pos = new Position(7,4);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("Cfe1", boardTest, false);
			assertEquals(pos,secondKnight.getPosition());
		}@Test
		void testMoveWhiteKnightKingCol15() { 
			knight = new Knight(2,2,true);
			Knight secondKnight = new Knight(4,2,true);
			Position pos = new Position(3,0);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("C6a5", boardTest, false);
			assertEquals(pos,knight.getPosition());
		}
		@Test
		void testMoveWhiteKnightKingCol16() { 
			knight = new Knight(5,3,true);
			Knight secondKnight = new Knight(5,5,true);
			Position pos = new Position(7,4);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("Cfe1", boardTest, false);
			assertEquals(pos,secondKnight.getPosition());
		}
		@Test
		void testMoveWhiteKnightKingR1() { 
			knight = new Knight(5,3,true);
			Knight secondKnight = new Knight(5,5,true);
			Position pos = new Position(7,4);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("Cfe1", boardTest, false);
			assertEquals(pos,secondKnight.getPosition());
		}
		@Test
		void testMoveWhiteKnightKingR2() { 
			knight = new Knight(2,2,true);
			Knight secondKnight = new Knight(4,2,true);
			Position pos = new Position(3,0);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("C6a5", boardTest, false);
			assertEquals(pos,knight.getPosition());
		}
		@Test
		void testMoveWhiteKnightKingR3() { 
			knight = new Knight(6,0,true);
			Knight secondKnight = new Knight(6,2,true);
			Position pos = new Position(4,1);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("Cab4", boardTest, false);
			assertEquals(pos,knight.getPosition());
		}
		@Test
		void testMoveWhiteKnightKingR4() { 
			knight = new Knight(6,5,true);
			Knight secondKnight = new Knight(6,7,true);
			Position pos = new Position(4,6);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("Chg4", boardTest, false);
			assertEquals(pos,secondKnight.getPosition());
		}
		@Test
		void testMoveWhiteKnightKingcattura10() { 
			knight = new Knight(6,4,true);
			Knight secondKnight = new Knight(6,2,true);
			Position pos = new Position(4,3);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("Ccd4", boardTest, false);
			assertEquals(pos,secondKnight.getPosition());
		}
		@Test
		void testMoveWhiteKnightKingRow11() { 
			knight = new Knight(2,3,true);
			Knight secondKnight = new Knight(2,5,true);
			Position pos = new Position(0,4);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("Cde8", boardTest, false);
			assertEquals(pos,knight.getPosition());
		}
		@Test
		void testMoveWhiteKnightKingRow12() { 
			knight = new Knight(2,5,true);
			Knight secondKnight = new Knight(4,5,true);
			Position pos = new Position(3,7);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("C4h5", boardTest, false);
			assertEquals(pos,secondKnight.getPosition());
		}
		@Test
		void testMoveWhiteKnightKingRow13() { 
			knight = new Knight(5,3,true);
			Knight secondKnight = new Knight(5,5,true);
			Position pos = new Position(7,4);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("Cfe1", boardTest, false);
			assertEquals(pos,secondKnight.getPosition());
		}
		@Test
		void testMoveWhiteKnightKingRow14() { 
			knight = new Knight(5,3,true);
			Knight secondKnight = new Knight(5,5,true);
			Position pos = new Position(7,4);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("Cfe1", boardTest, false);
			assertEquals(pos,secondKnight.getPosition());
		}@Test
		void testMoveWhiteKnightKingRow15() { 
			knight = new Knight(2,2,true);
			Knight secondKnight = new Knight(4,2,true);
			Position pos = new Position(3,0);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("C6a5", boardTest, false);
			assertEquals(pos,knight.getPosition());
		}
		@Test
		void testMoveWhiteKnightKingRow16() { 
			knight = new Knight(5,3,true);
			Knight secondKnight = new Knight(5,5,true);
			Position pos = new Position(7,4);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("Cfe1", boardTest, false);
			assertEquals(pos,secondKnight.getPosition());
		}
		@Test
		void testMoveWhiteKnightKingRow17() { 
			knight = new Knight(5,3,true);
			Knight secondKnight = new Knight(5,5,true);
			Position pos = new Position(7,4);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("Cfe1", boardTest, false);
			assertEquals(pos,secondKnight.getPosition());
		}
		@Test
		void testMoveWhiteKnightKingRow18() { 
			knight = new Knight(2,2,true);
			Knight secondKnight = new Knight(4,2,true);
			Position pos = new Position(3,0);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("C6a5", boardTest, false);
			assertEquals(pos,knight.getPosition());
		}
		@Test
		void testMoveWhiteKnightKingRow() { 
			knight = new Knight(2,3,true);
			Knight secondKnight = new Knight(2,5,true);
			Position pos = new Position(0,4);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("Cde8", boardTest, false);
			assertEquals(pos,knight.getPosition());
		}
		@Test
		void testMoveWhiteKnightKingRow2() { 
			knight = new Knight(2,5,true);
			Knight secondKnight = new Knight(4,5,true);
			Position pos = new Position(3,7);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("C4h5", boardTest, false);
			assertEquals(pos,secondKnight.getPosition());
		}
		@Test
		void testMoveWhiteKnightKingRow3() { 
			knight = new Knight(5,3,true);
			Knight secondKnight = new Knight(5,5,true);
			Position pos = new Position(7,4);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("Cfe1", boardTest, false);
			assertEquals(pos,secondKnight.getPosition());
		}
		@Test
		void testMoveWhiteKnightKingRow4() { 
			knight = new Knight(5,3,true);
			Knight secondKnight = new Knight(5,5,true);
			Position pos = new Position(7,4);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("Cfe1", boardTest, false);
			assertEquals(pos,secondKnight.getPosition());
		}@Test
		void testMoveWhiteKnightKingRow5() { 
			knight = new Knight(2,2,true);
			Knight secondKnight = new Knight(4,2,true);
			Position pos = new Position(3,0);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("C6a5", boardTest, false);
			assertEquals(pos,knight.getPosition());
		}
		@Test
		void testMoveWhiteKnightKingRow6() { 
			knight = new Knight(5,3,true);
			Knight secondKnight = new Knight(5,5,true);
			Position pos = new Position(7,4);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("Cfe1", boardTest, false);
			assertEquals(pos,secondKnight.getPosition());
		}
		@Test
		void testMoveWhiteKnightKingRow7() { 
			knight = new Knight(5,3,true);
			Knight secondKnight = new Knight(5,5,true);
			Position pos = new Position(7,4);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("Cfe1", boardTest, false);
			assertEquals(pos,secondKnight.getPosition());
		}
		@Test
		void testMoveWhiteKnightKingRow8() { 
			knight = new Knight(2,2,true);
			Knight secondKnight = new Knight(4,2,true);
			Position pos = new Position(3,0);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			Move.moveKnight("C6a5", boardTest, false);
			assertEquals(pos,knight.getPosition());
		}
		@Test
		void testMoveWhiteKnightKingRow9() { 
			knight = new Knight(6,0,true);
			Knight secondKnight = new Knight(6,2,true);
			Knight tKnight = new Knight(4,1,true);
			boardTest.setPiece(knight.getPosition(), knight);
			boardTest.setPiece(secondKnight.getPosition(), secondKnight);
			boardTest.setPiece(tKnight.getPosition(), tKnight);
			assertThrows(IllegalArgumentException.class, () -> Move.moveKnight("C3b4", boardTest, false));
		}
	}
}
