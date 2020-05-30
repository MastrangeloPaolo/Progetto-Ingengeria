package it.uniba.main.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import it.uniba.main.Pawn;
import it.uniba.main.Position;

class PawnTest {

	private Boolean color=false;
	private Pawn pawn = new Pawn(0,0,color);
	
	@Test
	void testName() {
		Pawn pawn = new Pawn(0,0,color=false);
		assertTrue(pawn.getName() == 'P');
		Pawn pawn1 = new Pawn(0,0,color=true);
		assertTrue(pawn1.getName() == 'p');
	}
	
	@Test
	void testSetPositionX() {
	    pawn.setPositionX(2);
	    pawn.setPositionY(2);
	    assertEquals(pawn.getPosition(), (new Position(2,2)));
	  }
	
	@Test
	void testGetFirsStep() {
		assertTrue(pawn.getFirstStep());
	}
	
	@AfterEach
	void testsetFirsStep() {
		pawn.setFirstStep(false);
		assertFalse(pawn.getFirstStep());
	}

	
}
