package it.uniba.main;

import java.util.ArrayList;

/**
 *Class name: Sottoclasse di Piece chiamata Bishop
 *Class type: Entity
 *Responsibilities
 *Knows:
 * Conosce la sua posizione e il suo colore.
 *Does:
 * Fornisce informazioni su se stesso.
 * Fornisce la lista delle possibili posizioni degli alfieri sulla scacchiera.
 */

public class Bishop extends Piece {
  private static final int SCACCHIERA = 7;
  private static final  int SCACCHIERA1 = 8;
  private Position bishopPosition = new Position(0, 0);

  /**
   * Costruttore del pezzo alfiere.
   * Crea un pezzo alfiere con delle cordinate di partenza, un
   * colore e un nome dato in automatico a partire dal colore
   *
   *
   * @param coordX colonna di partenza
   * @param coordY riga di partenza
   * @param color colore del pezzo
   */

  public Bishop(final Integer coordX, final Integer coordY, final Boolean color) { // costruttore
    super(color, name(color));
    bishopPosition.setPosX(coordX);
    bishopPosition.setPosY(coordY);
  }

  //____________________________________________________________________________________
  /**
   * Metodo per sapere il nome del pezzo.
   * @param color colore del pezzo
   * @return nome del pezzo in base al colore
   */
  private static char name(final boolean color) {
    char name;
    if (color) {
      name = 'a';
    } else {
      name = 'A';
    }
    return name;
  }

  //_____________________________________________________________________________________

  /**
   * Metodo che setta la posizione x dell'alfiere.
   *
   * @param positionX x da settare
   */

  public void setPositionX(final Integer positionX) {
    this.bishopPosition.setPosX(positionX);
  }

  //___________________________________________________________________________________

  /**
   * Metodo che setta la posizione y dell'alfiere.
   *
   * @param positionY y da settare
   */

  public void setPositionY(final Integer positionY) {
    this.bishopPosition.setPosY(positionY);
  }

  //____________________________________________________________________________________

  /**
   * Metodo che restituisce la posizione dell'alfiere.
   * @return posizione alfiere
   */

  public Position getPosition() { // ritorna la posizione del pezzo
    return this.bishopPosition;
  }

  //____________________________________________________________________________________

  /**
   * Metodo per trovare gli alfieri nella scacchiera.
   * Prende una scacchiera da analizzare e il turno in corso
   * la scorre e salva le cordinate degli alfieri del
   * proprio colore che trova
   *
   * @param  board scacchiera da analizzare
   * @param  turn turno in corso
   * @return array contenente la posizione degli alfieri
   */

  public static ArrayList<Position> findBishops(final Board board, final Boolean turn) {
    ArrayList<Position> bishops = new ArrayList<>();
    Character bishopChr = null;

    if (turn) {
      bishopChr = 'A';
    } else {
      bishopChr = 'a';
    }

    if (turn) {
      for (int x = SCACCHIERA; x >= 0; x--) {
        for (int y = 0; y < SCACCHIERA1; y++) {
          if (!board.isEmpty(x, y) && board.getPieceName(x, y) == bishopChr) {
            bishops.add(new Position(x, y));
          }
          if (bishops.size() == 2) {
            return bishops;
          }
        }
      }
    } else {
      for (int x = 0; x < SCACCHIERA1; x++) {
        for (int y = 0; y < SCACCHIERA1; y++) {
          if (!board.isEmpty(x, y) && board.getPieceName(x, y).equals(bishopChr)) {
            bishops.add(new Position(x, y));
          }
          if (bishops.size() == 2) {
            return bishops;
          }
        }
      }
    }
    return bishops;
  }
}
