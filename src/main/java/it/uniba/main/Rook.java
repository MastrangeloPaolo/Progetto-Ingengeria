package it.uniba.main;

import java.util.ArrayList;

/**
 *Class name: Sottoclasse di Piece chiamata Rook
 *Class type: Entity
 *Responsabilities
 *Knows:
 * Conosce la sua posizione e il suo colore.
 *Does:
 * Fornisce informazioni su se stesso.
 * Fornisce la lista delle possibili posizioni delle torri sulla scacchiera.
 */

public class Rook extends Piece {
  private Position rookPosition = new Position(0, 0);
  private Boolean firstStep = null; // boolean usato per controllare lo stato della mossa
  private static final int LUNGROW = 8;

  //____________________________________________________________________________________

  /**
   * Costruttore del pezzo torre.
   * Crea un pezzo torre con delle cordinate di partenza, un
   * colore e un nome dato in automatico a partire dal colore
   *
   *
   * @param coordX colonna di partenza
   * @param coordY riga di partenza
   * @param color colore del pezzo
   */


  public Rook(final Integer coordX, final Integer coordY, final Boolean color) { // costruttore
    super(color, name(color));
    rookPosition.setPosX(coordX);
    rookPosition.setPosY(coordY);
    firstStep = true;
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
      name = 't';
    } else {
      name = 'T';
    }
    return name;
  }

  //___________________________________________________________________________________

  /**
   *Metodo per settare la colonna.
   * @param positionX colonna-x
   */

  public void setPositionX(final Integer positionX) {
    this.rookPosition.setPosX(positionX);
  }

  //___________________________________________________________________________________

  /**
   *Metodo per settare la riga.
   * @param positionY riga-y
   */

  public void setPositionY(final Integer positionY) {
    this.rookPosition.setPosY(positionY);
  }

  //____________________________________________________________________________________

  /**
   * Metodo per sapere se la torre si e' mai mossa.
   * @return true se non si e' mai mossa, alrimenti false
   */

  public Boolean getFirstStep() { // ritorna first step
    return this.firstStep;
  }

  //____________________________________________________________________________________

  /**
   * Metodo per settare se la torre si e' mossa.
   * @param value true se si e' mossa, altrimenti false
   */

  public void setFirstStep(final boolean value) { // setta il valore di first step
    this.firstStep = value;
  }

  //____________________________________________________________________________________

  /**
   * Metodo per ottenere posizione del pezzo.
   * @return posizione del pezzo
   */

  public Position getPosition() { // ritorna la posizione del pezzo
    return this.rookPosition;
  }

  //____________________________________________________________________________________

  /**
   * Metodo per trovare le torri nella scacchiera.
   * Prende una scacchiera da analizzare e il turno in corso
   * la scorre e salva le coordinate delle torri del
   * proprio colore che trova
   *
   * @param  board scacchiera da analizzare
   * @param  turn turno in corso
   * @return array contenente la posizione delle torri
   */

  public static ArrayList<Position> findRooks(final Board board, final Boolean turn) {
    ArrayList<Position> rooks = new ArrayList<>();
    char rookCh;

    if (turn) {
      rookCh = 'T';
    } else {
      rookCh = 't';
    }
    for (int i = 0; i < LUNGROW; i++) {
      for (int j = 0; j < LUNGROW; j++) {
        if (!board.isEmpty(i, j)) {
          Piece piece = board.getPiece(i, j);
          if (piece.getName() == rookCh) {
            rooks.add(new Position(i, j));
          }
        }
      }
    }
    return rooks;
  }
}


