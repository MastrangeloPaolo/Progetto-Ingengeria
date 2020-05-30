package it.uniba.main.test;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniba.main.King;
import it.uniba.main.Board;
import it.uniba.main.Position;
import static org.junit.jupiter.api.Assertions.assertThrows;


class KingTest {

    private Board board;
    private King king;
    private King king1;
    private King king2;
   
    
  @BeforeEach
  public void beforeFunction(){
	  board = new Board();
  }
  
    @Test
    void findposition74() {
    	king = new King(7, 3, false);     	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(7, 3);
        Position test = King.findPosition(7, 4, board, 'R');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition64() {
    	king = new King(7, 3, false);     	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(7, 3);
        Position test = King.findPosition(6, 4, board, 'R');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition63() {
    	king = new King(7, 3, false);     	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(7, 3);
        Position test = King.findPosition(6, 3, board, 'R');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition62() {
    	king = new King(7, 3, false);     	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(7, 3);
        Position test = King.findPosition(6, 2, board, 'R');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition72() {
    	king = new King(7, 3, false);     	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(7, 3);
        Position test = King.findPosition(7, 2, board, 'R');
        assertEquals(arrive, test);
    }


    
    @Test
    void findposition01() {
    	king = new King(0, 0, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(0, 0);
        Position test = King.findPosition(0, 1, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition11() {
    	king = new King(0, 0, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(0, 0);
        Position test = King.findPosition(1, 1, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition10() {
    	king = new King(0, 0, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(0, 0);
        Position test = King.findPosition(1, 0, board, 'r');
        assertEquals(arrive, test);
    }
    
    
    @Test
    void findposition04() {
    	king = new King(0, 3, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(0, 3);
        Position test = King.findPosition(0, 4, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition14() {
    	king = new King(0, 3, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(0, 3);
        Position test = King.findPosition(1, 4, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition13() {
    	king = new King(0, 3, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(0, 3);
        Position test = King.findPosition(1, 3, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition12() {
    	king = new King(0, 3, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(0, 3);
        Position test = King.findPosition(1, 2, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition02() {
    	king = new King(0, 3, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(0, 3);
        Position test = King.findPosition(0, 2, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition06() {
    	king = new King(0, 7, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(0, 7);
        Position test = King.findPosition(0, 6, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition16() {
    	king = new King(0, 7, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(0, 7);
        Position test = King.findPosition(1, 6, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition17() {
    	king = new King(0, 7, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(0, 7);
        Position test = King.findPosition(1, 7, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition40() {
    	king = new King(3, 0, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(3, 0);
        Position test = King.findPosition(4, 0, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition41() {
    	king = new King(3, 0, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(3, 0);
        Position test = King.findPosition(4, 1, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition31() {
    	king = new King(3, 0, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(3, 0);
        Position test = King.findPosition(3, 1, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition21() {
    	king = new King(3, 0, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(3, 0);
        Position test = King.findPosition(2, 1, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition20() {
    	king = new King(3, 0, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(3, 0);
        Position test = King.findPosition(2, 0, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition22() {
    	king = new King(3, 3, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(3, 3);
        Position test = King.findPosition(2, 2, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition22e() {
    	king = new King(3, 3, false);   	
        board.setPiece(king.getPosition(), king);
        assertThrows(IllegalArgumentException.class, () -> King.findPosition(2, 2, board, 'r'));
    }
    
    @Test
    void findposition23() {
    	king = new King(3, 3, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(3, 3);
        Position test = King.findPosition(2, 3, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition23e() {
    	king = new King(3, 3, false);   	
        board.setPiece(king.getPosition(), king);
        assertThrows(IllegalArgumentException.class, () -> King.findPosition(2, 3, board, 'r'));
    }
    
    @Test
    void findposition24() {
    	king = new King(3, 3, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(3, 3);
        Position test = King.findPosition(2, 4, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition24e() {
    	king = new King(3, 3, false);   	
        board.setPiece(king.getPosition(), king);
        assertThrows(IllegalArgumentException.class, () -> King.findPosition(2, 4, board, 'r'));
    }
    
    @Test
    void findposition34() {
    	king = new King(3, 3, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(3, 3);
        Position test = King.findPosition(3, 4, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition34e() {
    	king = new King(3, 3, false);   	
        board.setPiece(king.getPosition(), king);
        assertThrows(IllegalArgumentException.class, () -> King.findPosition(3, 4, board, 'r'));
    }
    
    @Test
    void findposition44() {
    	king = new King(3, 3, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(3, 3);
        Position test = King.findPosition(4, 4, board, 'r');
        assertEquals(arrive, test);
    }
    
    
    @Test
    void findposition44e() {
    	king = new King(3, 3, false);   	
        board.setPiece(king.getPosition(), king);
        assertThrows(IllegalArgumentException.class, () -> King.findPosition(4, 4, board, 'r'));
    }
    
    @Test
    void findposition43() {
    	king = new King(3, 3, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(3, 3);
        Position test = King.findPosition(4, 3, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition43e() {
    	king = new King(3, 3, false);   	
        board.setPiece(king.getPosition(), king);
        assertThrows(IllegalArgumentException.class, () -> King.findPosition(4, 3, board, 'r'));
    }
    
    @Test
    void findposition42() {
    	king = new King(3, 3, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(3, 3);
        Position test = King.findPosition(4, 2, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition42e() {
    	king = new King(3, 3, false);   	
        board.setPiece(king.getPosition(), king);
        assertThrows(IllegalArgumentException.class, () -> King.findPosition(4, 2, board, 'r'));
    }
    
    @Test
    void findposition32() {
    	king = new King(3, 3, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(3, 3);
        Position test = King.findPosition(3, 2, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition32e() {
    	king = new King(3, 3, false);   	
        board.setPiece(king.getPosition(), king);
        assertThrows(IllegalArgumentException.class, () -> King.findPosition(3, 2, board, 'r'));
    }
    
    @Test
    void findposition27() {
    	king = new King(3, 7, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(3, 7);
        Position test = King.findPosition(2, 7, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition26() {
    	king = new King(3, 7, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(3, 7);
        Position test = King.findPosition(2, 6, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition36() {
    	king = new King(3, 7, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(3, 7);
        Position test = King.findPosition(3, 6, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition46() {
    	king = new King(3, 7, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(3, 7);
        Position test = King.findPosition(4, 6, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition47() {
    	king = new King(3, 7, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(3, 7);
        Position test = King.findPosition(4, 7, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition67() {
    	king = new King(7, 7, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(7, 7);
        Position test = King.findPosition(6, 7, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition66() {
    	king = new King(7, 7, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(7, 7);
        Position test = King.findPosition(6, 6, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition76() {
    	king = new King(7, 7, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(7, 7);
        Position test = King.findPosition(7, 6, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition71() {
    	king = new King(7, 0, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(7, 0);
        Position test = King.findPosition(7, 1, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition61() {
    	king = new King(7, 0, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(7, 0);
        Position test = King.findPosition(6, 1, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition60() {
    	king = new King(7, 0, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(7, 0);
        Position test = King.findPosition(6, 0, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition00a() {
    	king = new King(0, 1, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(0, 1);
        Position test = King.findPosition(0, 0, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition00a1() {
    	king = new King(0, 1, false);   	
        board.setPiece(king.getPosition(), king);
        assertThrows(IllegalArgumentException.class, () -> King.findPosition(0, 0, board, 'r'));
}

    
    @Test
    void findposition00b() {
    	king = new King(1, 1, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(1, 1);
        Position test = King.findPosition(0, 0, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition00b1() {
    	king = new King(1, 1, false);   	
        board.setPiece(king.getPosition(), king);
        assertThrows(IllegalArgumentException.class, () -> King.findPosition(0, 0, board, 'r'));
}
    
    @Test
    void findposition00c() {
    	king = new King(1, 0, true);   	
        board.setPiece(king.getPosition(), king);
    	Position arrive = new Position(1, 0);
        Position test = King.findPosition(0, 0, board, 'r');
        assertEquals(arrive, test);
    }
    
    @Test
    void findposition00c1() {
    	king = new King(1, 0, false);   	
        board.setPiece(king.getPosition(), king);
        assertThrows(IllegalArgumentException.class, () -> King.findPosition(0, 0, board, 'r'));
    }  
    
    @Test
    void findposition07a() {
    	king = new King(1, 7, true);   	
        board.setPiece(king.getPosition(), king);
        Position arrive = new Position(1, 7);
        Position test = King.findPosition(0, 7, board, 'r');
        assertEquals(arrive, test);
    	
    } 
    
    @Test
    void findposition07a1() {
    	king = new King(1, 7, false);   	
        board.setPiece(king.getPosition(), king);
        assertThrows(IllegalArgumentException.class, () -> King.findPosition(0, 7, board, 'r'));
    	
    } 
    
    @Test
    void findposition07b() {
    	king = new King(1, 6, true);   	
        board.setPiece(king.getPosition(), king);
        Position arrive = new Position(1, 6);
        Position test = King.findPosition(0, 7, board, 'r');
        assertEquals(arrive, test);
    	
    } 
    
    @Test
    void findposition07b1() {
    	king = new King(1, 6, false);   	
        board.setPiece(king.getPosition(), king);
        assertThrows(IllegalArgumentException.class, () -> King.findPosition(0, 7, board, 'r'));
    	
    } 
    
    @Test
    void findposition07c() {
    	king = new King(0, 6, true);   	
        board.setPiece(king.getPosition(), king);
        Position arrive = new Position(0, 6);
        Position test = King.findPosition(0, 7, board, 'r');
        assertEquals(arrive, test);
    	
    } 
    
    @Test
    void findposition07c1() {
    	king = new King(0, 6, false);   	
        board.setPiece(king.getPosition(), king);
        assertThrows(IllegalArgumentException.class, () -> King.findPosition(0, 7, board, 'r'));
    	
    }
    
    
    @Test
    void findposition70a() {
    	king = new King(6, 0, true);   	
        board.setPiece(king.getPosition(), king);
        Position arrive = new Position(6, 0);
        Position test = King.findPosition(7, 0, board, 'r');
        assertEquals(arrive, test);
    	
    } 
    
    @Test
    void findposition70a1() {
    	king = new King(6, 0, false);   	
    	board.setPiece(king.getPosition(), king);
    	assertThrows(IllegalArgumentException.class, () -> King.findPosition(7, 0, board, 'r'));
    	
    } 
    
    @Test
    void findposition70b() {
    	king = new King(6, 1, true);   	
        board.setPiece(king.getPosition(), king);
        Position arrive = new Position(6, 1);
        Position test = King.findPosition(7, 0, board, 'r');
        assertEquals(arrive, test);
    	
    } 
    
    @Test
    void findposition70b1() {
    	king = new King(6, 1, false);   	
    	board.setPiece(king.getPosition(), king);
    	assertThrows(IllegalArgumentException.class, () -> King.findPosition(7, 0, board, 'r'));
    	
    }
    
    @Test
    void findposition70c() {
    	king = new King(7, 1, true);   	
        board.setPiece(king.getPosition(), king);
        Position arrive = new Position(7, 1);
        Position test = King.findPosition(7, 0, board, 'r');
        assertEquals(arrive, test);
    	
    }
    
    @Test
    void findposition70c1() {
    	king = new King(7, 1, false);   	
    	board.setPiece(king.getPosition(), king);
    	assertThrows(IllegalArgumentException.class, () -> King.findPosition(7, 0, board, 'r'));
    	
    }
    
    @Test
    void findposition77a() {
    	king = new King(7, 6, true);   	
        board.setPiece(king.getPosition(), king);
        Position arrive = new Position(7, 6);
        Position test = King.findPosition(7, 7, board, 'r');
        assertEquals(arrive, test);
    	
    }
    
    @Test()
    void findposition77a1() {
    	king = new King(7, 6, false);   	
    	board.setPiece(king.getPosition(), king);
    	assertThrows(IllegalArgumentException.class, () -> King.findPosition(7, 7, board, 'r'));
    	
    }
    
    @Test
    void findposition77b() {
    	king = new King(6, 6, true);   	
        board.setPiece(king.getPosition(), king);
        Position arrive = new Position(6, 6);
        Position test = King.findPosition(7, 7, board, 'r');
        assertEquals(arrive, test);
    	
    }
    
    
    @Test
    void findposition77b1(){
    	king = new King(6, 6, false);   	
    	board.setPiece(king.getPosition(), king);
    	assertThrows(IllegalArgumentException.class, () -> King.findPosition(7, 7, board, 'r'));
    	
    }
    
    @Test
    void findposition77c() {
    	king = new King(6, 7, true);   	
        board.setPiece(king.getPosition(), king);
        Position arrive = new Position(6, 7);
        Position test = King.findPosition(7, 7, board, 'r');
        assertEquals(arrive, test);
    	
    }
    
    @Test
    void findposition77c1() {
    	king = new King(6, 7, false);   	
    	board.setPiece(king.getPosition(), king);
    	assertThrows(IllegalArgumentException.class, () -> King.findPosition(7, 7, board, 'r'));
    	
    }
    
    @Test
    void findposition30a() {
    	king = new King(2, 0, true);   	
        board.setPiece(king.getPosition(), king);
        Position arrive = new Position(2, 0);
        Position test = King.findPosition(3, 0, board, 'r');
        assertEquals(arrive, test);
    	
    }
    
    @Test
    void findposition30a1() {
    	king = new King(2, 0, false);   	
        board.setPiece(king.getPosition(), king);
        assertThrows(IllegalArgumentException.class, () -> King.findPosition(3, 0, board, 'r'));
    	
    }
    
    @Test
    void findposition30b() {
    	king = new King(2, 1, true);   	
        board.setPiece(king.getPosition(), king);
        Position arrive = new Position(2, 1);
        Position test = King.findPosition(3, 0, board, 'r');
        assertEquals(arrive, test);
    	
    }
    
    @Test
    void findposition30b1() {
    	king = new King(2, 1, false);   	
        board.setPiece(king.getPosition(), king);
        assertThrows(IllegalArgumentException.class, () -> King.findPosition(3, 0, board, 'r'));
    	
    }
    
    @Test
    void findposition30c() {
    	king = new King(3, 1, true);   	
        board.setPiece(king.getPosition(), king);
        Position arrive = new Position(3, 1);
        Position test = King.findPosition(3, 0, board, 'r');
        assertEquals(arrive, test);
    	
    }
    
    @Test
    void findposition30c1() {
    	king = new King(3, 1, false);   	
        board.setPiece(king.getPosition(), king);
        assertThrows(IllegalArgumentException.class, () -> King.findPosition(3, 0, board, 'r'));
    	
    }
    
    @Test
    void findposition30d() {
    	king = new King(4, 1, true);   	
        board.setPiece(king.getPosition(), king);
        Position arrive = new Position(4, 1);
        Position test = King.findPosition(3, 0, board, 'r');
        assertEquals(arrive, test);
    	
    }
    
    @Test
    void findposition30d1() {
    	king = new King(4, 1, false);   	
        board.setPiece(king.getPosition(), king);
        assertThrows(IllegalArgumentException.class, () -> King.findPosition(3, 0, board, 'r'));
    	
    }
    
    @Test
    void findposition30e() {
    	king = new King(4, 0, true);   	
        board.setPiece(king.getPosition(), king);
        Position arrive = new Position(4, 0);
        Position test = King.findPosition(3, 0, board, 'r');
        assertEquals(arrive, test);
    	
    }
    
    @Test
    void findposition30e1() {
    	king = new King(4, 0, false);   	
        board.setPiece(king.getPosition(), king);
        assertThrows(IllegalArgumentException.class, () -> King.findPosition(3, 0, board, 'r'));
    	
    }
    
    @Test
    void findposition37a() {
    	king = new King(2, 7, true);   	
        board.setPiece(king.getPosition(), king);
        Position arrive = new Position(2, 7);
        Position test = King.findPosition(3, 7, board, 'r');
        assertEquals(arrive, test);
    	
    }
    
    @Test
    void findposition37a1() {
    	king = new King(2, 7, false);   	
        board.setPiece(king.getPosition(), king);
        assertThrows(IllegalArgumentException.class, () -> King.findPosition(3, 7, board, 'r'));
    	
    }
    
    @Test
    void findposition37b() {
    	king = new King(2, 6, true);   	
        board.setPiece(king.getPosition(), king);
        Position arrive = new Position(2, 6);
        Position test = King.findPosition(3, 7, board, 'r');
        assertEquals(arrive, test);
    	
    }
    
    @Test
    void findposition37b1() {
    	king = new King(2, 6, false);   	
        board.setPiece(king.getPosition(), king);
        assertThrows(IllegalArgumentException.class, () -> King.findPosition(3, 7, board, 'r'));
    	
    }
    
    @Test
    void findposition37c() {
    	king = new King(3, 6, true);   	
        board.setPiece(king.getPosition(), king);
        Position arrive = new Position(3, 6);
        Position test = King.findPosition(3, 7, board, 'r');
        assertEquals(arrive, test);
    	
    }
    
    @Test
    void findposition37c1() {
    	king = new King(3, 6, false);   	
        board.setPiece(king.getPosition(), king);
        assertThrows(IllegalArgumentException.class, () -> King.findPosition(3, 7, board, 'r'));
    	
    }
    
    @Test
    void findposition37d() {
    	king = new King(4, 6, true);   	
        board.setPiece(king.getPosition(), king);
        Position arrive = new Position(4, 6);
        Position test = King.findPosition(3, 7, board, 'r');
        assertEquals(arrive, test);
    	
    }
    
    @Test
    void findposition37d1() {
    	king = new King(4, 6, false);   	
        board.setPiece(king.getPosition(), king);
        assertThrows(IllegalArgumentException.class, () -> King.findPosition(3, 7, board, 'r'));
    	
    }
    
    @Test
    void findposition37e() {
    	king = new King(4, 7, true);   	
        board.setPiece(king.getPosition(), king);
        Position arrive = new Position(4, 7);
        Position test = King.findPosition(3, 7, board, 'r');
        assertEquals(arrive, test);
    	
    }
    
    @Test
    void findposition37e1() {
    	king = new King(4, 7, false);   	
        board.setPiece(king.getPosition(), king);
        assertThrows(IllegalArgumentException.class, () -> King.findPosition(3, 7, board, 'r'));
    	
    }
    
    @Test
    void findposition03a() {
    	king = new King(0, 2, true);   	
        board.setPiece(king.getPosition(), king);
        Position arrive = new Position(0, 2);
        Position test = King.findPosition(0, 3, board, 'r');
        assertEquals(arrive, test);
    	
    }
    
    @Test
    void findposition03a1() {
    	king = new King(0, 2, false);   	
        board.setPiece(king.getPosition(), king);
        assertThrows(IllegalArgumentException.class, () -> King.findPosition(0, 3, board, 'r'));
    	
    }
    
    @Test
    void findposition03b() {
    	king = new King(1, 2, true);   	
        board.setPiece(king.getPosition(), king);
        Position arrive = new Position(1, 2);
        Position test = King.findPosition(0, 3, board, 'r');
        assertEquals(arrive, test);
    	
    }
    
    @Test
    void findposition03b1() {
    	king = new King(1, 2, false);   	
        board.setPiece(king.getPosition(), king);
        assertThrows(IllegalArgumentException.class, () -> King.findPosition(0, 3, board, 'r'));
    	
    }
    
    @Test
    void findposition03c() {
    	king = new King(1, 3, true);   	
        board.setPiece(king.getPosition(), king);
        Position arrive = new Position(1, 3);
        Position test = King.findPosition(0, 3, board, 'r');
        assertEquals(arrive, test);
    	
    }
    
    @Test
    void findposition03c1() {
    	king = new King(1, 3, false);   	
        board.setPiece(king.getPosition(), king);
        assertThrows(IllegalArgumentException.class, () -> King.findPosition(0, 3, board, 'r'));
    	
    }
    
    @Test
    void findposition03d() {
    	king = new King(1, 4, true);   	
        board.setPiece(king.getPosition(), king);
        Position arrive = new Position(1, 4);
        Position test = King.findPosition(0, 3, board, 'r');
        assertEquals(arrive, test);
    	
    }
    
    @Test
    void findposition03d1() {
    	king = new King(1, 4, false);   	
        board.setPiece(king.getPosition(), king);
        assertThrows(IllegalArgumentException.class, () -> King.findPosition(0, 3, board, 'r'));
    	
    }
    
    @Test
    void findposition03e() {
    	king = new King(0, 4, true);   	
        board.setPiece(king.getPosition(), king);
        Position arrive = new Position(0, 4);
        Position test = King.findPosition(0, 3, board, 'r');
        assertEquals(arrive, test);
    	
    }
    
    @Test
    void findposition03e1() {
    	king = new King(0, 4, false);   	
        board.setPiece(king.getPosition(), king);
        assertThrows(IllegalArgumentException.class, () -> King.findPosition(0, 3, board, 'r'));
    	
    }
    
    @Test
    void findposition73a() {
    	king = new King(7, 2, true);   	
        board.setPiece(king.getPosition(), king);
        Position arrive = new Position(7, 2);
        Position test = King.findPosition(7, 3, board, 'r');
        assertEquals(arrive, test);
    	
    }
    
    @Test
    void findposition73a1() {
    	king = new King(7, 2, false);   	
        board.setPiece(king.getPosition(), king);
        assertThrows(IllegalArgumentException.class, () -> King.findPosition(7, 3, board, 'r'));
    	
    }
    
    @Test
    void findposition73b() {
    	king = new King(6, 2, true);   	
        board.setPiece(king.getPosition(), king);
        Position arrive = new Position(6, 2);
        Position test = King.findPosition(7, 3, board, 'r');
        assertEquals(arrive, test);
    	
    }
    
    @Test
    void findposition73b1() {
    	king = new King(6, 2, false);   	
        board.setPiece(king.getPosition(), king);
        assertThrows(IllegalArgumentException.class, () -> King.findPosition(7, 3, board, 'r'));
    	
    }
    
    @Test
    void findposition73c() {
    	king = new King(6, 3, true);   	
        board.setPiece(king.getPosition(), king);
        Position arrive = new Position(6, 3);
        Position test = King.findPosition(7, 3, board, 'r');
        assertEquals(arrive, test);
    	
    }
    
    @Test
    void findposition73c1() {
    	king = new King(6, 3, false);   	
        board.setPiece(king.getPosition(), king);
        assertThrows(IllegalArgumentException.class, () -> King.findPosition(7, 3, board, 'r'));
    	
    }
    
    @Test
    void findposition73d() {
    	king = new King(6, 4, true);   	
        board.setPiece(king.getPosition(), king);
        Position arrive = new Position(6, 4);
        Position test = King.findPosition(7, 3, board, 'r');
        assertEquals(arrive, test);
    	
    }
    
    @Test
    void findposition73d1() {
    	king = new King(6, 4, false);   	
        board.setPiece(king.getPosition(), king);
        assertThrows(IllegalArgumentException.class, () -> King.findPosition(7, 3, board, 'r'));
    	
    }
    
    @Test
    void findposition73e() {
    	king = new King(7, 4, true);   	
        board.setPiece(king.getPosition(), king);
        Position arrive = new Position(7, 4);
        Position test = King.findPosition(7, 3, board, 'r');
        assertEquals(arrive, test);
    	
    }
    
    @Test
    void findposition73e1() {
    	king = new King(7, 4, false);   	
        board.setPiece(king.getPosition(), king);
        assertThrows(IllegalArgumentException.class, () -> King.findPosition(7, 3, board, 'r'));
    	
    }
    
    @Test
    void setposX() {
    	King king = new King(0, 0, true);
    	king.setPositionX(2);
    	assertEquals(king.getPosition().getPosX(), 2);
    	
    }
    
    @Test
    void setposY() {
    	King king = new King(0, 0, true);
    	king.setPositionY(3);
    	assertEquals(king.getPosition().getPosY(), 3);
    	
    }
    
    @Test
    void setfirststep() {
    	King king = new King(0, 0, true);
    	king.setFirstStep(true);
    	assertEquals(king.getFirstStep(), true);
    	
    }
    
    @Test
    void getfirststep() {
    	King king = new King(0, 0, true);
    	Boolean b = king.getFirstStep();
    	assertTrue(b);
    	
    }
    
    @Test
    void Check1() {
    	King king = new King(0, 0, true);
    	King.controlCheck(king.getPosition(), new Position(1,1), board, true);
    	
    }
    
    @Test
    void Check2() {
    	king = new King(0, 0, true);
    	board.setPiece(king.getPosition(), king);
    	king1 = new King(1, 0, true);
    	board.setPiece(king1.getPosition(), king1);
    	assertTrue(King.controlCheck(king.getPosition(), king1.getPosition(),board, false));
    	
    }
    
    @Test
    void Check3() {
    	king = new King(0, 0, true);
    	board.setPiece(king.getPosition(), king);
    	king1 = new King(1, 0, true);
    	board.setPiece(king1.getPosition(), king1);
    	king2 = new King(0, 1, false);
    	board.setPiece(king2.getPosition(), king2);
    	assertTrue(King.controlCheck(king.getPosition(), king2.getPosition(), board, false));
    	
    }
    
}
