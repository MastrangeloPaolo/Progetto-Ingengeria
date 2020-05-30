package it.uniba.main.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import it.uniba.main.ParserString;
class ParserStringTest {

	@Test
	void test() {
		ParserString.convertY("h");
	}
	
	@Test
	void testconvertY() {
		ParserString.convertY("z");
	}
	
	@Test
	void testconvertX() {
		ParserString.convertX("z");
	}
	
	@Test
	void testcontrolEp1() {
		assertEquals(ParserString.controlEp("25647", 5, true), true);
	}
	
	@Test
	void testcontrolEp1a() {
		assertEquals(ParserString.controlEp("25657", 5, true), false);
	}
	
	@Test
	void testcontrolEp2() {
		assertEquals(ParserString.controlEp("45627", 5, false), true);
	}
	
	@Test
	void testcontrolEp2a() {
		assertEquals(ParserString.controlEp("45647", 5, false), false);
	}
	
	@Test
	void testcontrolEp3() {
		assertEquals(ParserString.controlEp("456274", 5, true), false);
	}
	
	@Test
	void testanalyzer() {
		assertTrue(ParserString.analyzer("help").equals(4));
	}
	
	@Test
	void testanalyzer1() {
		assertTrue(ParserString.analyzer("quit").equals(5));
	}
	
	@Test
	void testanalyzer2() {
		assertTrue(ParserString.analyzer("moves").equals(6));
	}
	
	@Test
	void testanalyzer3() {
		assertTrue(ParserString.analyzer("captures").equals(7));
	}
	
	@Test
	void testanalyzer4() {
		assertTrue(ParserString.analyzer("board").equals(8));
	}
	
	@Test
	void testanalyzer5() {
		assertTrue(ParserString.analyzer("play").equals(9));
	}
	
	@Test
	void testanalyzer6() {
		assertTrue(ParserString.analyzer("0-0").equals(14));
	}
	
	@Test
	void testanalyzer6a() {
		assertTrue(ParserString.analyzer("O-O").equals(14));
	}
	
	@Test
	void testanalyzer6b() {
		assertTrue(ParserString.analyzer("o-o").equals(14));
	}
	
	@Test
	void testanalyzer7() {
		assertTrue(ParserString.analyzer("0-0-0").equals(15));
	}
	
	@Test
	void testanalyzer7a() {
		assertTrue(ParserString.analyzer("O-O-O").equals(15));
	}

	@Test
	void testanalyzer7c() {
		assertTrue(ParserString.analyzer("o-o-o").equals(15));
	}
	
	@Test
	void testanalyzer8() {
		assertTrue(ParserString.analyzer("axb1e.p.").equals(3));
	}
	
	@Test
	void testanalyzer9() {
		assertTrue(ParserString.analyzer("C1a1").equals(12));
	}
	
	@Test
	void testanalyzer10() {
		assertTrue(ParserString.analyzer("C1xa1").equals(13));
	}

	@Test
	void testanalyzer11() {
		assertFalse(ParserString.analyzer("").equals(15));
	}

}
