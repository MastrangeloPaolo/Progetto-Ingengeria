package it.uniba.main;

import java.util.ArrayList;
import java.util.List;


/**
 * name: Board
 *Class type: Entity
 *Responsibilities
 *Knows:
 *Conosce la posizione e il colore di ogni pezzo della scacchiera.
 *Conosce lo storico di tutte le mosse effettuate.
 *Conosce lo storico delle catture.
 *Does:
 *Inizializza la scacchiera, impostando i pezzi nelle rispettive posizioni, con i rispettivi colori.
 *Permette di aggiungere una mossa allo storico delle mosse.
 *Permette di aggiungere una cattura allo storico delle catture.
 *Permette di modificare la posizione di un pezzo.
 *Permette di ottenere un pezzo, specificandone la posizione.
 */

public class Board {
  private static final int CHESSBOARDL = 8;
  private static final int XSEVEN = 7;
  private static final int XSIX = 6;
  private static final int XZERO = 0;
  private static final int XONE = 1;
  private static final int YZERO = 0;
  private static final int YONE = 1;
  private static final int YTWO = 2;
  private static final int YTHREE = 3;
  private static final int YFOUR = 4;
  private static final int YFIVE = 5;
  private static final int YSIX = 6;
  private static final int YSEVEN = 7;
  private static final int CAPTURE0 = 0;
  private static final int CAPTURE1 = 1;
  private static final int CAPTURE2 = 2;
  private static final int CAPTURE3 = 3;
  private static final int CAPTURE4 = 4;
  private static final int CAPTURE5 = 5;
  private  Piece[][] board = new Piece[CHESSBOARDL][CHESSBOARDL];
  private  String doubleMove = null;
  private boolean firstTurn = true;

  private List<String> totalStory = new ArrayList<>();
  private int[] captureW = {0, 0, 0, 0, 0, 0}; //catture nero     | 0= pedoni |1= torre |2= cavallo|
  private int[] captureB = {0, 0, 0, 0, 0, 0}; // catture bianco  |3= alfiere |4= donna | 5= re |

  //____________________________________________________________________________

  /**
   * Costruttore scacchiera vuota.
   */

  public Board() {                                  //set scacchiera vuota
    for (int i = 0; i < CHESSBOARDL; i++) {
      for (int j = 0; j < CHESSBOARDL; j++) {
        board[i][j] = null;
      }
    }
  }

  //____________________________________________________________________________

  /**
   * Metodo che restituisce la storia delle mosse.
   * @return storia delle mosse
   */

  public List<String> getTotalStory() {
    return this.totalStory;
  }

  //____________________________________________________________________________

  /**
   * Metodo per settare le catture dei bianchi.
   * @param piece pezzo catturato
   */

  public void setCaptureW(final int piece) {
    this.captureW[piece]++;
  }

  //____________________________________________________________________________

  /**
   * Metodo per settare le catture dei neri.
   * @param piece pezzo catturato
   */

  public void setCaptureB(final int piece) {
    this.captureB[piece]++;
  }

  //____________________________________________________________________________

  /**
   * Metodo posizionare i pezzi sulla scacchiera.
   * Riempie una scacchiera vuota con tutti i pezzi
   * seguendo le regole degli scacchi, crea un pezzo attraverso
   * il suo costruttore e succesivmente lo posiziona nella scacchiara.
   */

  public void fillBoard() {

    King k2 = new King(XSEVEN, YFOUR, false);       //set pezzi bianchi
    setPiece(k2.getPosition(), k2);
    Queen q2 = new Queen(XSEVEN, YTHREE, false);
    setPiece(q2.getPosition(), q2);
    Bishop b3 = new Bishop(XSEVEN, YFIVE, false);
    setPiece(b3.getPosition(), b3);
    Bishop b4 = new Bishop(XSEVEN, YTWO, false);
    setPiece(b4.getPosition(), b4);
    Knight c3 = new Knight(XSEVEN, YONE, false);
    setPiece(c3.getPosition(), c3);
    Knight c4 = new Knight(XSEVEN, YSIX, false);
    setPiece(c4.getPosition(), c4);
    Rook r3 = new Rook(XSEVEN, YZERO, false);
    setPiece(r3.getPosition(), r3);
    Rook r4 = new Rook(XSEVEN, YSEVEN, false);
    setPiece(r4.getPosition(), r4);
    Pawn p9 = new Pawn(XSIX, YZERO, false);
    setPiece(p9.getPosition(), p9);
    Pawn p10 = new Pawn(XSIX, YONE, false);
    setPiece(p10.getPosition(), p10);
    Pawn p11 = new Pawn(XSIX, YTWO, false);
    setPiece(p11.getPosition(), p11);
    Pawn p12 = new Pawn(XSIX, YTHREE, false);
    setPiece(p12.getPosition(), p12);
    Pawn p13 = new Pawn(XSIX, YFOUR, false);
    setPiece(p13.getPosition(), p13);
    Pawn p14 = new Pawn(XSIX, YFIVE, false);
    setPiece(p14.getPosition(), p14);
    Pawn p15 = new Pawn(XSIX, YSIX, false);
    setPiece(p15.getPosition(), p15);
    Pawn p16 = new Pawn(XSIX, YSEVEN, false);
    setPiece(p16.getPosition(), p16);

    King k1 = new King(XZERO, YFOUR, true);      //set pezzi neri
    setPiece(k1.getPosition(), k1);
    Queen q1 = new Queen(XZERO, YTHREE, true);
    setPiece(q1.getPosition(), q1);
    Bishop b1 = new Bishop(XZERO, YFIVE, true);
    setPiece(b1.getPosition(), b1);
    Bishop b2 = new Bishop(XZERO, YTWO, true);
    setPiece(b2.getPosition(), b2);
    Knight c1 = new Knight(XZERO, YONE, true);
    setPiece(c1.getPosition(), c1);
    Knight c2 = new Knight(XZERO, YSIX, true);
    setPiece(c2.getPosition(), c2);
    Rook r1 = new Rook(XZERO, YSEVEN, true);
    setPiece(r1.getPosition(), r1);
    Rook r2 = new Rook(XZERO, YZERO, true);
    setPiece(r2.getPosition(), r2);
    Pawn p1 = new Pawn(XONE, YZERO, true);
    setPiece(p1.getPosition(), p1);
    Pawn p2 = new Pawn(XONE, YONE, true);
    setPiece(p2.getPosition(), p2);
    Pawn p3 = new Pawn(XONE, YTWO, true);
    setPiece(p3.getPosition(), p3);
    Pawn p4 = new Pawn(XONE, YTHREE, true);
    setPiece(p4.getPosition(), p4);
    Pawn p5 = new Pawn(XONE, YFOUR, true);
    setPiece(p5.getPosition(), p5);
    Pawn p6 = new Pawn(XONE, YFIVE, true);
    setPiece(p6.getPosition(), p6);
    Pawn p7 = new Pawn(XONE, YSIX, true);
    setPiece(p7.getPosition(), p7);
    Pawn p8 = new Pawn(XONE, YSEVEN, true);
    setPiece(p8.getPosition(), p8);
  }
  //____________________________________________________________________________________________

  /**
   * Metodo che restituisce il colore del pezzo.
   * @param x colonna del pezzo
   * @param y riga del pezzo
   * @return colore del pezzo
   */

  public Boolean getPieceColor(final Integer x, final Integer y) {    // da il colore del pezzo
    return board[x][y].getColor();                        //in un determinato punto della scacchiera
  }

  //____________________________________________________________________________________________

  /**
   * Metodo che restituisce il pezzo.
   * @param x colonna del pezzo
   * @param y riga del pezzo
   * @return pezzo selezionato
   */

  public Piece getPiece(final Integer x, final Integer y) {
    return board[x][y];
  }

  //____________________________________________________________________________________________

  /**
   * Metodo che inserisce un pezzo nella scacchiera.
   * @param pos posizione dove inserire pezzo
   * @param p1 pezzo da inserire
   */

  public void setPiece(final Position pos, final Piece p1) {   // piazzo il pezzo in posizione xy
    this.board[pos.getPosX()][pos.getPosY()] = p1;
  }

  //____________________________________________________________________________________________

  /**
   * Controlla se una determinata posizione della sacchiera e' vuota.
   * Prende la colonna e la riga da controllare e vede se all'interno
   * e' presente un pezzo.
   *
   * @param  x colonna da analizzare
   * @param  y riga da analizzare
   * @return vero se vuoto falso se pieno
   */

  public Boolean isEmpty(final Integer x, final Integer y) {
    Boolean flag = false;
    if (board[x][y] == null) {
      flag = true;
    }
    return flag;
  }

  //____________________________________________________________________________________________

  /**
   * Metodo per impostare a vuoto casella scacchiera.
   * @param x colonna selezionata
   * @param y riga selezionata
   */

  public void setEmpty(final Integer x, final Integer y) {
    this.board[x][y] = null;
  }

  //____________________________________________________________________________________________

  /**
   * Metodo che restituisce se e' il primo turno.
   * @return true se e' il primo turno, altrimenti false.
   */

  public boolean getFirstTurn() {
    return firstTurn;
  }

  //____________________________________________________________________________________________

  /**
   * Metodo per settare se e' il primo turno.
   * @param fturn true se e' il primo turno, altrimenti false.
   */

  public void setFirstTurn(final boolean fturn) {
    this.firstTurn = fturn;
  }

  //____________________________________________________________________________________________

  /**
   * Metodo per impostare che e' stato fatto un doppio passo.
   * @param dmove mossa eseguita
   */

  public void setDoubleMove(final String dmove) {
    this.doubleMove = dmove;
  }

  //____________________________________________________________________________________________

  /**
   * Metodo per ottenere il doppio passo effettuato.
   * @return ritorna il doppio passo effettuato
   */

  public String getDoubleMove() {
    return doubleMove;
  }

  //____________________________________________________________________________________________

  /**
   * Metodo che restituisce il numero di catture di un pezzo.
   * Prende il tipo di pezzo di cui si vuole coniscere il numero
   * di catture e attraverso gli appositi array ne restituisce il valore.
   *
   * @param index tipo di pezzo che si vuole analizzare
   * @param turn turno bianco/nero
   * @return restituisce il numero di pezzi catturati di quel tipo
   */

  public int getCapture(final int index, final boolean turn) {
    if (turn) {
      return captureW[index];
    } else {
      return captureB[index];
    }
  }

  //____________________________________________________________________________________________

  /**
   * Metodo per aggiungere una mossa allo storico.
   * @param move mossa da aggiungere
   */

  public void setStoryMove(final String move) {
    totalStory.add(move);
  }

  //____________________________________________________________________________________________

  /**
   * Metodo per prendere pezzo da scacchiera.
   * @param x colonna del pezzo
   * @param y riga del pezzo
   * @return pezzo selezionato
   */

  public Character getPieceName(final Integer x, final Integer y) {
    return this.getPiece(x, y).getName();
  }

  //____________________________________________________________________________________________

  /**
   * Metodo che aggiorna il numero di catture.
   * Prende il turno per sapere chi sta catturando e il pezzo
   * catturato e aggiorna l'array interessato
   *
   *
   * @param turn turno del giocatore che sta catturando
   * @param piece pezzo catturato
 */

  public void storeCaptures(final boolean turn, final Position piece) {
    if (turn) {
      switch (this.getPieceName(piece.getPosX(), piece.getPosY())) {
        case 'p':
          this.captureW[CAPTURE0]++;
          break;
        case 't':
          this.captureW[CAPTURE1]++;
          break;
        case 'c':
          this.captureW[CAPTURE2]++;
          break;
        case 'a':
          this.captureW[CAPTURE3]++;
          break;
        case 'd':
          this.captureW[CAPTURE4]++;
          break;
        case 'r':
          this.captureW[CAPTURE5]++;
          break;
        default:
          break;
      }
    } else {
      switch (this.getPieceName(piece.getPosX(), piece.getPosY())) {
        case 'P':
          this.captureB[CAPTURE0]++;
          break;
        case 'T':
          this.captureB[CAPTURE1]++;
          break;
        case 'C':
          this.captureB[CAPTURE2]++;
          break;
        case 'A':
          this.captureB[CAPTURE3]++;
          break;
        case 'D':
          this.captureB[CAPTURE4]++;
          break;
        case 'R':
          this.captureB[CAPTURE5]++;
          break;
        default:
          break;
      }
    }
  }
}


