package it.uniba.main.test;

import it.uniba.main.Bishop;
import it.uniba.main.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    private Position pos;
    private Position pos2;

    @BeforeEach
    void setUp() {
        pos = new Position(2,2);
    }

    @Test
    void getPosX() {
        assertEquals(pos.getPosX(), 2);
    }

    @Test
    void getPosY() {
        assertEquals(pos.getPosY(), 2);
    }

    @Test
    void setPosX() {
        pos.setPosX(3);
        assertEquals(pos.getPosX(), 3);
    }

    @Test
    void setPosY() {
        pos.setPosY(4);
        assertEquals(pos.getPosY(), 4);
    }

    @Test
    void testEquals_SamePos() {
        pos2 = new Position(2,2);
        assertEquals(pos.equals(pos2), true);
    }

    @Test
    void testEquals_NotSamePos() {
        pos2 = new Position(3,5);
        assertEquals(pos.equals(pos2), false);
    }

    @Test
    void testEquals_NotSamePosY() {
        pos2 = new Position(2,5);
        assertEquals(pos.equals(pos2), false);
    }

    @Test
    void testEquals_DifferentClass() {
        assertEquals(pos.equals(new Bishop(6,5,false)), false);
    }

    @Test
    void testEquals_NullObj() {
        assertEquals(pos.equals(null), false);
    }

    @Test
    void testHashCode() {
        assertEquals(pos.hashCode(), 2);
    }

    @Test
    void testToString() {
        assertEquals(pos.toString(), "2 2");
    }
}