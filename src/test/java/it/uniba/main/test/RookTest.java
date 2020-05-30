package it.uniba.main.test;

import it.uniba.main.Board;
import it.uniba.main.Position;
import it.uniba.main.Rook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {
    private Board board;
    private Rook rook;
    ArrayList<Position> rooksPos;
    ArrayList<Position> testRooksPos;

    @BeforeEach
    void setUp() {
        board = new Board();
        board.fillBoard();
        rook = new Rook(1,5,false);
        testRooksPos = new ArrayList<>();
    }

    @Test
    void setPositionX() {
        rook.setPositionX(2);
        assertEquals(rook.getPosition().getPosX(), 2);
    }

    @Test
    void setPositionY() {
        rook.setPositionY(4);
        assertEquals(rook.getPosition().getPosY(), 4);
    }

    @Test
    void getFirstStep() {
        rook.setFirstStep(false);
        assertEquals(rook.getFirstStep(), false);
    }

    @Test
    void setFirstStep() {
        rook.setFirstStep(true);
        assertEquals(rook.getFirstStep(), true);
    }

    @Test
    void getPosition() {
        assertEquals(rook.getPosition(), new Position(1,5));
    }

    @Test
    void findRooksWhites() { //BIANCHI
        rooksPos = Rook.findRooks(board, true);
        testRooksPos.add(new Position(7,0));
        testRooksPos.add(new Position(7,7));
        assertEquals(rooksPos.get(0), testRooksPos.get(0));
        assertEquals(rooksPos.get(1), testRooksPos.get(1));
    }

    @Test
    void findRooksBlacks() { //NERI
        rooksPos = Rook.findRooks(board, false);
        testRooksPos.add(new Position(0,0));
        testRooksPos.add(new Position(0,7));
        assertEquals(rooksPos.get(0), testRooksPos.get(0));
        assertEquals(rooksPos.get(1), testRooksPos.get(1));
    }
}