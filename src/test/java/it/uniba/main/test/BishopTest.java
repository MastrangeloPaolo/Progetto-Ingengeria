package it.uniba.main.test;

import it.uniba.main.Bishop;
import it.uniba.main.Board;
import it.uniba.main.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {
    private Board board;
    private Bishop bish;
    private Position testPos;
    private ArrayList<Position> positions;
    private ArrayList<Position> testPositions;

    @BeforeEach
    void setUp() {
        board = new Board();
        board.fillBoard();
        testPositions = new ArrayList<>();
    }

    @Test
    void setPositionX() {
        testPos = new Position(5,0);
        bish = (Bishop) board.getPiece(7, 5);
        bish.setPositionX(5);
        assertEquals(bish.getPosition().getPosX(), testPos.getPosX());
    }

    @Test
    void setPositionY() {
        testPos = new Position(0,3);
        bish = (Bishop) board.getPiece(7, 5);
        bish.setPositionY(3);
        assertEquals(bish.getPosition().getPosY(), testPos.getPosY());
    }

    @Test
    void getPosition() {
        testPos = new Position(7,5);
        bish = (Bishop) board.getPiece(7, 5);
        assertEquals(bish.getPosition(), testPos);
    }

    @Test
    void findBishopsCorrectPositionsW() {
        positions = Bishop.findBishops(board, true);
        testPositions.add(new Position(7,2));
        testPositions.add(new Position(7,5));
        assertEquals(positions.get(0), testPositions.get(0));
        assertEquals(positions.get(1), testPositions.get(1));
    }

    @Test
    void findBishopsOnlyOnePositionW() {
        bish = (Bishop) board.getPiece(7, 5);
        board.setEmpty(bish.getPosition().getPosX(), bish.getPosition().getPosY());
        positions = Bishop.findBishops(board, true);
        testPositions.add(new Position(7,2));
        assertEquals(positions.get(0), testPositions.get(0));
    }

    @Test
    void findBishopsNoPositionsW() {
        bish = (Bishop) board.getPiece(7, 2);
        board.setEmpty(bish.getPosition().getPosX(), bish.getPosition().getPosY());
        bish = (Bishop) board.getPiece(7, 5);
        board.setEmpty(bish.getPosition().getPosX(), bish.getPosition().getPosY());
        positions = Bishop.findBishops(board, true);
        assertEquals(positions, testPositions);
    }

    @Test
    void findBishopsCorrectPositionsB() {
        positions = Bishop.findBishops(board, false);
        testPositions.add(new Position(0,2));
        testPositions.add(new Position(0,5));
        assertEquals(positions.get(0), testPositions.get(0));
        assertEquals(positions.get(1), testPositions.get(1));
    }

    @Test
    void findBishopsOnlyOnePositionB() {
        bish = (Bishop) board.getPiece(0, 2);
        board.setEmpty(bish.getPosition().getPosX(), bish.getPosition().getPosY());
        positions = Bishop.findBishops(board, false);
        testPositions.add(new Position(0,5));
        assertEquals(positions.get(0), testPositions.get(0));
    }

    @Test
    void findBishopsNoPositionsB() {
        bish = (Bishop) board.getPiece(0, 2);
        board.setEmpty(bish.getPosition().getPosX(), bish.getPosition().getPosY());
        bish = (Bishop) board.getPiece(0, 5);
        board.setEmpty(bish.getPosition().getPosX(), bish.getPosition().getPosY());
        positions = Bishop.findBishops(board, false);
        assertEquals(positions, testPositions);
    }
}