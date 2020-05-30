package it.uniba.main.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniba.main.Board;
import it.uniba.main.Knight;
import it.uniba.main.Position;

class KnightTest {

    private Knight firstKnight;
    private Board board = new Board();
    private Knight knight;
    private Knight secondKnight;
    private Position posizioneArrivo;
    private Position startPosition;
    private ArrayList<Position> risultatoTest;
    private ArrayList<Position> risultatoAtteso;
    private Integer[] risultatoParziale;
    int risultato;

    @BeforeEach
    void setUp() {
        firstKnight = new Knight(2, 2, true);
        startPosition = new Position(3, 3);
    }

    @Test
    void testKnightNotNull() {
        assertNotNull(firstKnight);
    }


    @Test
    void testCostruttorePosX() {
        assertEquals(2, firstKnight.getPosition().getPosX());
    }

    @Test
    void testCostruttorePosY() {
        assertEquals(2, firstKnight.getPosition().getPosY());
    }

    @Test
    void testCostruttoreColore() {
        assertEquals(true, firstKnight.getColor());
    }

    @Test
    void testCostruttoreColoreTwo() {
        assertNotEquals(false, firstKnight.getColor());
    }

    @Test
    void testSetPosX() {
        firstKnight.setPositionX(5);
        assertEquals(5, firstKnight.getPosition().getPosX());
    }

    @Test
    void testSetPosY() {
        firstKnight.setPositionY(5);
        assertEquals(5, firstKnight.getPosition().getPosY());
    }

    @Test
    void testGetNameWhite() {
        assertEquals('c', firstKnight.getName());
    }

    @Test
    void testGetNameBlack() {
        assertNotEquals('C', firstKnight.getName());
    }

    @Test
    void testKnightNull() {
        firstKnight = null;
        assertNull(firstKnight);
    }

    @Test
    void t() {
        firstKnight = new Knight(0, 0, false);
        assertEquals('C', firstKnight.getName());
    }

    //______________________________________________________________________________

    @Test
    void testFindKnightA1() {
        knight = new Knight(2, 1, true);
        posizioneArrivo = new Position(2, 1);
        board.setPiece(knight.getPosition(), knight);
        risultatoTest = Knight.findKnight(false, board, 0, 0, 10, 'c', "Ca1");
        risultatoAtteso = new ArrayList<Position>();
        risultatoAtteso.add(posizioneArrivo);
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightA4() {
        knight = new Knight(2, 2, true);
        posizioneArrivo = new Position(2, 2);
        board.setPiece(knight.getPosition(), knight);
        risultatoTest = Knight.findKnight(false, board, 3, 0, 10, 'c', "Ca4");
        risultatoAtteso = new ArrayList<Position>();
        risultatoAtteso.add(posizioneArrivo);
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightA8() {
        knight = new Knight(5, 1, true);
        posizioneArrivo = new Position(5, 1);
        board.setPiece(knight.getPosition(), knight);
        risultatoTest = Knight.findKnight(false, board, 7, 0, 10, 'c', "Ca8");
        risultatoAtteso = new ArrayList<Position>();
        risultatoAtteso.add(posizioneArrivo);
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightB1() {
        knight = new Knight(2, 2, true);
        posizioneArrivo = new Position(2, 2);
        board.setPiece(knight.getPosition(), knight);
        risultatoTest = Knight.findKnight(false, board, 0, 1, 10, 'c', "Cb1");
        risultatoAtteso = new ArrayList<Position>();
        risultatoAtteso.add(posizioneArrivo);
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightB4() {
        knight = new Knight(5, 2, true);
        posizioneArrivo = new Position(5, 2);
        board.setPiece(knight.getPosition(), knight);
        risultatoTest = Knight.findKnight(false, board, 3, 1, 10, 'c', "Cb4");
        risultatoAtteso = new ArrayList<Position>();
        risultatoAtteso.add(posizioneArrivo);
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightB8() {
        knight = new Knight(5, 2, true);
        posizioneArrivo = new Position(5, 2);
        board.setPiece(knight.getPosition(), knight);
        risultatoTest = Knight.findKnight(false, board, 7, 1, 10, 'c', "Cb8");
        risultatoAtteso = new ArrayList<Position>();
        risultatoAtteso.add(posizioneArrivo);
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightC1() {

        knight = new Knight(2, 3, true);
        posizioneArrivo = new Position(2, 3);
        board.setPiece(knight.getPosition(), knight);
        risultatoTest = Knight.findKnight(false, board, 0, 2, 11, 'c', "Cc1");
        risultatoAtteso = new ArrayList<Position>();
        risultatoAtteso.add(posizioneArrivo);
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightC4() {
        knight = new Knight(5, 3, false);
        posizioneArrivo = new Position(5, 3);
        board.setPiece(knight.getPosition(), knight);
        risultatoTest = Knight.findKnight(true, board, 3, 2, 10, 'C', "Cc4");
        risultatoAtteso = new ArrayList<Position>();
        risultatoAtteso.add(posizioneArrivo);
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightvuota() {
        knight = new Knight(5, 3, false);
        posizioneArrivo = new Position(5, 3);
        risultatoTest = Knight.findKnight(true, board, 3, 2, 10, 'C', "Cc4");
        risultatoAtteso = new ArrayList<Position>();
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightvuota2() {
        knight = new Knight(5, 3, false);
        posizioneArrivo = new Position(5, 3);
        risultatoTest = Knight.findKnight(true, board, 3, 2, 11, 'C', "Cc4");
        risultatoAtteso = new ArrayList<Position>();
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightvuota3() {
        knight = new Knight(5, 3, true);
        posizioneArrivo = new Position(5, 3);
        risultatoTest = Knight.findKnight(false, board, 3, 2, 10, 'c', "Cc4");
        risultatoAtteso = new ArrayList<Position>();
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightvuota4() {
        knight = new Knight(5, 3, true);
        posizioneArrivo = new Position(5, 3);
        risultatoTest = Knight.findKnight(false, board, 3, 2, 11, 'c', "Cc4");
        risultatoAtteso = new ArrayList<Position>();
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightvuota5() {
        knight = new Knight(5, 4, false);
        secondKnight = new Knight(5, 6, false);
        board.setPiece(knight.getPosition(), knight);
        board.setPiece(secondKnight.getPosition(), secondKnight);
        posizioneArrivo = new Position(5, 4);
        risultatoTest = Knight.findKnight(true, board, 3, 5, 12, 'C', "Cef5");
        risultatoAtteso = new ArrayList<Position>();
        risultatoAtteso.add(knight.getPosition());
        risultatoAtteso.add(secondKnight.getPosition());
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightvuota6() {
        knight = new Knight(5, 4, false);
        secondKnight = new Knight(5, 6, true);
        board.setPiece(knight.getPosition(), knight);
        board.setPiece(secondKnight.getPosition(), secondKnight);
        posizioneArrivo = new Position(5, 4);
        risultatoTest = Knight.findKnight(true, board, 3, 5, 12, 'C', "Cef5");
        risultatoAtteso = new ArrayList<Position>();
        risultatoAtteso.add(knight.getPosition());
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightvuota7() {
        knight = new Knight(5, 4, true);
        secondKnight = new Knight(5, 6, true);
        board.setPiece(knight.getPosition(), knight);
        board.setPiece(secondKnight.getPosition(), secondKnight);
        posizioneArrivo = new Position(5, 4);
        risultatoTest = Knight.findKnight(true, board, 3, 5, 12, 'C', "Cef5");
        risultatoAtteso = new ArrayList<Position>();
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightriga() {
        knight = new Knight(2, 3, false);
        secondKnight = new Knight(4, 3, false);
        board.setPiece(knight.getPosition(), knight);
        board.setPiece(secondKnight.getPosition(), secondKnight);
        posizioneArrivo = new Position(5, 4);
        risultatoTest = Knight.findKnight(true, board, 3, 5, 13, 'C', "C6f5");
        risultatoAtteso = new ArrayList<Position>();
        risultatoAtteso.add(knight.getPosition());
        risultatoAtteso.add(secondKnight.getPosition());
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightriga2() {
        knight = new Knight(2, 3, false);
        secondKnight = new Knight(4, 3, true);
        board.setPiece(knight.getPosition(), knight);
        board.setPiece(secondKnight.getPosition(), secondKnight);
        posizioneArrivo = new Position(5, 4);
        risultatoTest = Knight.findKnight(true, board, 3, 5, 13, 'C', "C6f5");
        risultatoAtteso = new ArrayList<Position>();
        risultatoAtteso.add(knight.getPosition());
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightriga4() {
        knight = new Knight(1, 2, false);
        secondKnight = new Knight(3, 2, true);
        board.setPiece(knight.getPosition(), knight);
        board.setPiece(secondKnight.getPosition(), secondKnight);
        posizioneArrivo = new Position(1, 2);
        risultatoTest = Knight.findKnight(true, board, 2, 0, 13, 'C', "C7a6");
        risultatoAtteso = new ArrayList<Position>();
        risultatoAtteso.add(knight.getPosition());
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightriga5() {
        knight = new Knight(1, 2, false);
        secondKnight = new Knight(3, 2, true);
        board.setPiece(knight.getPosition(), knight);
        board.setPiece(secondKnight.getPosition(), secondKnight);
        posizioneArrivo = new Position(1, 2);
        risultatoTest = Knight.findKnight(true, board, 2, 2, 13, 'C', "C7c6");
        risultatoAtteso = new ArrayList<Position>();
        risultatoAtteso.add(knight.getPosition());
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightriga3() {
        knight = new Knight(2, 3, false);
        secondKnight = new Knight(4, 3, true);
        board.setPiece(knight.getPosition(), knight);
        board.setPiece(secondKnight.getPosition(), secondKnight);
        posizioneArrivo = new Position(5, 4);
        risultatoTest = Knight.findKnight(true, board, 3, 5, 1, 'C', "C6f5");
        risultatoAtteso = new ArrayList<Position>();
        assertEquals(risultatoAtteso, risultatoTest);

    }

    @Test
    void testFindKnightC8() {
        knight = new Knight(5, 3, true);
        posizioneArrivo = new Position(5, 3);
        board.setPiece(knight.getPosition(), knight);
        risultatoTest = Knight.findKnight(false, board, 7, 2, 11, 'c', "Cc8");
        risultatoAtteso = new ArrayList<Position>();
        risultatoAtteso.add(posizioneArrivo);
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightH1() {
        knight = new Knight(2, 6, true);
        posizioneArrivo = new Position(2, 6);
        board.setPiece(knight.getPosition(), knight);
        risultatoTest = Knight.findKnight(false, board, 0, 7, 10, 'c', "Ch1");
        risultatoAtteso = new ArrayList<Position>();
        risultatoAtteso.add(posizioneArrivo);
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightH4() {
        knight = new Knight(5, 6, true);
        posizioneArrivo = new Position(5, 6);
        board.setPiece(knight.getPosition(), knight);
        risultatoTest = Knight.findKnight(false, board, 3, 7, 10, 'c', "Ch4");
        risultatoAtteso = new ArrayList<Position>();
        risultatoAtteso.add(posizioneArrivo);
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightH8() {
        knight = new Knight(5, 6, true);
        posizioneArrivo = new Position(5, 6);
        board.setPiece(knight.getPosition(), knight);
        risultatoTest = Knight.findKnight(false, board, 7, 7, 10, 'c', "Ch8");
        risultatoAtteso = new ArrayList<Position>();
        risultatoAtteso.add(posizioneArrivo);
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightG1() {
        knight = new Knight(2, 5, true);
        posizioneArrivo = new Position(2, 5);
        board.setPiece(knight.getPosition(), knight);
        risultatoTest = Knight.findKnight(false, board, 0, 6, 10, 'c', "Cg1");
        risultatoAtteso = new ArrayList<Position>();
        risultatoAtteso.add(posizioneArrivo);
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightG4() {
        knight = new Knight(5, 5, true);
        posizioneArrivo = new Position(5, 5);
        board.setPiece(knight.getPosition(), knight);
        risultatoTest = Knight.findKnight(false, board, 3, 6, 10, 'c', "Cg4");
        risultatoAtteso = new ArrayList<Position>();
        risultatoAtteso.add(posizioneArrivo);
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightG8() {
        knight = new Knight(5, 5, true);
        posizioneArrivo = new Position(5, 5);
        board.setPiece(knight.getPosition(), knight);
        risultatoTest = Knight.findKnight(false, board, 7, 6, 10, 'c', "Cg8");
        risultatoAtteso = new ArrayList<Position>();
        risultatoAtteso.add(posizioneArrivo);
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightF1() {
        knight = new Knight(2, 6, true);
        posizioneArrivo = new Position(2, 6);
        board.setPiece(knight.getPosition(), knight);
        risultatoTest = Knight.findKnight(false, board, 0, 5, 10, 'c', "Cf1");
        risultatoAtteso = new ArrayList<Position>();
        risultatoAtteso.add(posizioneArrivo);
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightF4() {
        knight = new Knight(5, 6, true);
        posizioneArrivo = new Position(5, 6);
        board.setPiece(knight.getPosition(), knight);
        risultatoTest = Knight.findKnight(false, board, 3, 5, 10, 'c', "Cf4");
        risultatoAtteso = new ArrayList<Position>();
        risultatoAtteso.add(posizioneArrivo);
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightF8() {
        knight = new Knight(5, 6, true);
        posizioneArrivo = new Position(5, 6);
        board.setPiece(knight.getPosition(), knight);
        risultatoTest = Knight.findKnight(false, board, 7, 5, 10, 'c', "Cf8");
        risultatoAtteso = new ArrayList<Position>();
        risultatoAtteso.add(posizioneArrivo);
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightE1() {
        knight = new Knight(6, 2, true);
        posizioneArrivo = new Position(6, 2);
        board.setPiece(knight.getPosition(), knight);
        risultatoTest = Knight.findKnight(false, board, 7, 4, 10, 'c', "Ce1");
        risultatoAtteso = new ArrayList<Position>();
        risultatoAtteso.add(posizioneArrivo);
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightE4() {
        knight = new Knight(5, 3, true);
        posizioneArrivo = new Position(5, 3);
        board.setPiece(knight.getPosition(), knight);
        risultatoTest = Knight.findKnight(false, board, 3, 4, 10, 'c', "Ce4");
        risultatoAtteso = new ArrayList<Position>();
        risultatoAtteso.add(posizioneArrivo);
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightE8() {
        knight = new Knight(5, 3, true);
        posizioneArrivo = new Position(5, 3);
        board.setPiece(knight.getPosition(), knight);
        risultatoTest = Knight.findKnight(false, board, 7, 4, 10, 'c', "Ce8");
        risultatoAtteso = new ArrayList<Position>();
        risultatoAtteso.add(posizioneArrivo);
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightBlack() {
        knight = new Knight(5, 3, false);
        posizioneArrivo = new Position(5, 3);
        board.setPiece(knight.getPosition(), knight);
        risultatoTest = Knight.findKnight(false, board, 7, 4, 10, 'c', "Ce8");
        risultatoAtteso = new ArrayList<Position>();
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightD1() {
        knight = new Knight(2, 2, true);
        posizioneArrivo = new Position(2, 2);
        board.setPiece(knight.getPosition(), knight);
        risultatoTest = Knight.findKnight(false, board, 0, 3, 10, 'c', "Cd1");
        risultatoAtteso = new ArrayList<Position>();
        risultatoAtteso.add(posizioneArrivo);
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightD4() {
        knight = new Knight(5, 2, true);
        posizioneArrivo = new Position(5, 2);
        board.setPiece(knight.getPosition(), knight);
        risultatoTest = Knight.findKnight(false, board, 3, 3, 10, 'c', "Cd4");
        risultatoAtteso = new ArrayList<Position>();
        risultatoAtteso.add(posizioneArrivo);
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightD8() {
        knight = new Knight(5, 2, true);
        posizioneArrivo = new Position(5, 2);
        board.setPiece(knight.getPosition(), knight);
        risultatoTest = Knight.findKnight(false, board, 7, 3, 10, 'c', "Cd8");
        risultatoAtteso = new ArrayList<Position>();
        risultatoAtteso.add(posizioneArrivo);
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightAssente() {
        knight = new Knight(7, 7, true);
        board.setPiece(knight.getPosition(), knight);
        risultatoTest = Knight.findKnight(false, board, 7, 3, 10, 'c', "Cd8");
        risultatoAtteso = new ArrayList<Position>();
        assertEquals(risultatoAtteso, risultatoTest);
    }
    //____________________________________________________________________________________

    @Test
    void testFindKnightColonnaA() {
        firstKnight = new Knight(1, 0, true);
        secondKnight = new Knight(3, 0, true);
        board.setPiece(firstKnight.getPosition(), firstKnight);
        board.setPiece(secondKnight.getPosition(), secondKnight);
        risultatoTest = Knight.findKnight(false, board, 2, 2, 12, 'c', "C7c6");
        risultatoAtteso = new ArrayList<Position>();
        risultatoAtteso.add(firstKnight.getPosition());
        risultatoAtteso.add(secondKnight.getPosition());
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightColonnaC() {
        firstKnight = new Knight(1, 4, true);
        secondKnight = new Knight(3, 4, true);
        board.setPiece(firstKnight.getPosition(), firstKnight);
        board.setPiece(secondKnight.getPosition(), secondKnight);
        risultatoTest = Knight.findKnight(false, board, 2, 2, 12, 'c', "C5c6");
        risultatoAtteso = new ArrayList<Position>();
        risultatoAtteso.add(secondKnight.getPosition());
        risultatoAtteso.add(firstKnight.getPosition());
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightRiga8() {
        firstKnight = new Knight(0, 1, true);
        secondKnight = new Knight(0, 3, true);
        board.setPiece(firstKnight.getPosition(), firstKnight);
        board.setPiece(secondKnight.getPosition(), secondKnight);
        risultatoTest = Knight.findKnight(false, board, 2, 2, 12, 'c', "Cbc6");
        risultatoAtteso = new ArrayList<Position>();
        risultatoAtteso.add(firstKnight.getPosition());
        risultatoAtteso.add(secondKnight.getPosition());
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testFindKnightRiga4() {
        firstKnight = new Knight(4, 1, true);
        secondKnight = new Knight(4, 3, true);
        board.setPiece(firstKnight.getPosition(), firstKnight);
        board.setPiece(secondKnight.getPosition(), secondKnight);
        risultatoTest = Knight.findKnight(false, board, 2, 2, 12, 'c', "Cdc6");
        risultatoAtteso = new ArrayList<Position>();
        risultatoAtteso.add(secondKnight.getPosition());
        risultatoAtteso.add(firstKnight.getPosition());
        assertEquals(risultatoAtteso, risultatoTest);
    }

    @Test
    void testValidMoveOne() {
        risultatoParziale = Knight.validMove(1, 2, startPosition);
        risultato = risultatoParziale[0] + risultatoParziale[1];
        assertEquals(-3, risultato);
    }

    @Test
    void testValidMoveOTwo() {
        risultatoParziale = Knight.validMove(1, 4, startPosition);
        risultato = risultatoParziale[0] + risultatoParziale[1];
        assertEquals(-1, risultato);
    }

    @Test
    void testValidMoveThree() {
        risultatoParziale = Knight.validMove(2, 5, startPosition);
        risultato = risultatoParziale[0] + risultatoParziale[1];
        assertEquals(1, risultato);
    }

    @Test
    void testValidMoveFour() {
        risultatoParziale = Knight.validMove(4, 5, startPosition);
        risultato = risultatoParziale[0] + risultatoParziale[1];
        assertEquals(3, risultato);
    }

    @Test
    void testValidMoveFive() {
        risultatoParziale = Knight.validMove(5, 4, startPosition);
        risultato = risultatoParziale[0] + risultatoParziale[1];
        assertEquals(3, risultato);
    }

    @Test
    void testValidMoveSix() {
        risultatoParziale = Knight.validMove(5, 2, startPosition);
        risultato = risultatoParziale[0] + risultatoParziale[1];
        assertEquals(1, risultato);
    }

    @Test
    void testValidMoveSeven() {
        risultatoParziale = Knight.validMove(4, 1, startPosition);
        risultato = risultatoParziale[0] + risultatoParziale[1];
        assertEquals(-1, risultato);
    }

    @Test
    void testValidMoveEight() {
        risultatoParziale = Knight.validMove(2, 1, startPosition);
        risultato = risultatoParziale[0] + risultatoParziale[1];
        assertEquals(-3, risultato);
    }

    @Test
    void testValidMoveZero() {
        risultatoParziale = Knight.validMove(0, 0, startPosition);
        risultato = risultatoParziale[0] + risultatoParziale[1];
        assertEquals(0, risultato);
    }

    @Test
    void testValidMoveBranchOne() {
        risultatoParziale = Knight.validMove(1, 1, startPosition);
        risultato = risultatoParziale[0] + risultatoParziale[1];
        assertEquals(0, risultato);
    }

    @Test
    void testValidMoveBranchTwo() {
        risultatoParziale = Knight.validMove(0, 2, startPosition);
        risultato = risultatoParziale[0] + risultatoParziale[1];
        assertEquals(0, risultato);
    }

    @Test
    void testValidMoveBranchThree() {
        risultatoParziale = Knight.validMove(1, 5, startPosition);
        risultato = risultatoParziale[0] + risultatoParziale[1];
        assertEquals(0, risultato);
    }

    @Test
    void testValidMoveBranchFour() {
        risultatoParziale = Knight.validMove(0, 4, startPosition);
        risultato = risultatoParziale[0] + risultatoParziale[1];
        assertEquals(0, risultato);
    }

    @Test
    void testValidMoveBranchFive() {
        risultatoParziale = Knight.validMove(5, 5, startPosition);
        risultato = risultatoParziale[0] + risultatoParziale[1];
        assertEquals(0, risultato);
    }

    @Test
    void testValidMoveBranchSix() {
        risultatoParziale = Knight.validMove(6, 4, startPosition);
        risultato = risultatoParziale[0] + risultatoParziale[1];
        assertEquals(0, risultato);
    }

    @Test
    void testValidMoveBranchSeven() {
        risultatoParziale = Knight.validMove(6, 2, startPosition);
        risultato = risultatoParziale[0] + risultatoParziale[1];
        assertEquals(0, risultato);
    }

    @Test
    void testValidMoveBranchEight() {
        risultatoParziale = Knight.validMove(5, 1, startPosition);
        risultato = risultatoParziale[0] + risultatoParziale[1];
        assertEquals(0, risultato);
    }

    @Test
    void testValidMoveBranchNine() {
        risultatoParziale = Knight.validMove(1, 3, startPosition);
        risultato = risultatoParziale[0] + risultatoParziale[1];
        assertEquals(0, risultato);
    }

    @Test
    void testValidMoveBranchTen() {
        risultatoParziale = Knight.validMove(3, 5, startPosition);
        risultato = risultatoParziale[0] + risultatoParziale[1];
        assertEquals(0, risultato);
    }

    @Test
    void testValidMoveBranchEleven() {
        risultatoParziale = Knight.validMove(5, 3, startPosition);
        risultato = risultatoParziale[0] + risultatoParziale[1];
        assertEquals(0, risultato);
    }

    @Test
    void testValidMoveBranchThirteen() {
        risultatoParziale = Knight.validMove(3, 1, startPosition);
        risultato = risultatoParziale[0] + risultatoParziale[1];
        assertEquals(0, risultato);
    }

    @Test
    void testValidMoveBranchFourteen() {
        risultatoParziale = Knight.validMove(2, 0, startPosition);
        risultato = risultatoParziale[0] + risultatoParziale[1];
        assertEquals(0, risultato);
    }

    @Test
    void testValidMoveBranchFifteen() {
        risultatoParziale = Knight.validMove(2, 2, startPosition);
        risultato = risultatoParziale[0] + risultatoParziale[1];
        assertEquals(0, risultato);
    }

    @Test
    void testValidMoveBranchSixteen() {
        risultatoParziale = Knight.validMove(2, 6, startPosition);
        risultato = risultatoParziale[0] + risultatoParziale[1];
        assertEquals(0, risultato);
    }

    @Test
    void testValidMoveBranchSeventeen() {
        risultatoParziale = Knight.validMove(2, 4, startPosition);
        risultato = risultatoParziale[0] + risultatoParziale[1];
        assertEquals(0, risultato);
    }

    @Test
    void testValidMoveBranchEighteen() {
        risultatoParziale = Knight.validMove(4, 6, startPosition);
        risultato = risultatoParziale[0] + risultatoParziale[1];
        assertEquals(0, risultato);
    }

    @Test
    void testValidMoveBranchNineteen() {
        risultatoParziale = Knight.validMove(4, 4, startPosition);
        risultato = risultatoParziale[0] + risultatoParziale[1];
        assertEquals(0, risultato);
    }

    @Test
    void testValidMoveBranchTwenty() {
        risultatoParziale = Knight.validMove(4, 0, startPosition);
        risultato = risultatoParziale[0] + risultatoParziale[1];
        assertEquals(0, risultato);
    }

    @Test
    void testValidMoveBranchTwentyone() {
        risultatoParziale = Knight.validMove(4, 2, startPosition);
        risultato = risultatoParziale[0] + risultatoParziale[1];
        assertEquals(0, risultato);
    }
}
