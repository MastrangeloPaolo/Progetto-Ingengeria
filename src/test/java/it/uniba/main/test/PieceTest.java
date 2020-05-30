package it.uniba.main.test;

import it.uniba.main.Bishop;
import it.uniba.main.Piece;
import it.uniba.main.Rook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {
    private Piece bish, rook, bish2;

    @BeforeEach
    void setUp() {
        bish = new Bishop(7,5,true);
        bish2 = new Bishop(7,5,true);
        rook = new Rook(6,4,false);
    }

    @Test
    void compareToNotEqual() {
        assertEquals(bish.compareTo(rook), 1);
    }

    @Test
    void compareToIsEqual() {
        assertEquals(bish.compareTo(bish2), 0);
    }
}