package it.uniba.main;

/**
 *Class name: Sottoclasse di Piece chiamata Queen
 *Class type: Entity
 *Responsabilities
 *Knows:
 * Conosce la sua posizione e il suo colore.
 *Does:
 * Fornisce informazioni su se stesso.
 * Fornisce la posizione della regina sulla scacchiera.
 */

public class Queen extends Piece {
  private Position queenPosition = new Position(0, 0);
  private static final int EIGHT = 8;
  private static final int SEVEN = 7;

  //____________________________________________________________________________________

  /**
   * Costruttore del pezzo regina.
   * Crea un pezzo regina con delle cordinate di partenza, un
   * colore e un nome dato in automatico a partire dal colore
   *
   *
   * @param coordX colonna di partenza
   * @param coordY riga di partenza
   * @param color colore del pezzo
   */

  public Queen(final Integer coordX, final Integer coordY, final Boolean color) { // costruttore
    super(color, name(color));
    queenPosition.setPosX(coordX);
    queenPosition.setPosY(coordY);
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
      name = 'd';
    } else {
      name = 'D';
    }
    return name;
  }

  //_____________________________________________________________________________________
  /**
   *Metodo per settare la colonna.
   * @param positionX colonna-x
   */

  public void setPositionX(final Integer positionX) {
    this.queenPosition.setPosX(positionX);
  }

  //___________________________________________________________________________________
  /**
   *Metodo per settare la riga.
   * @param positionY riga-y
   */

  public void setPositionY(final Integer positionY) {
    this.queenPosition.setPosY(positionY);
  }

  //____________________________________________________________________________________

  /**
   * Metodo per ottenere la posizione del pezzo.
   * @return posizione regina
   */

  public Position getPosition() { // ritorna la posizione del pezzo
    return this.queenPosition;
  }

  //____________________________________________________________________________________

  /**
   * Metodo per trovare la regina nella scacchiera.
   * Prende una scacchiera da analizzare e il turno in corso
   * la scorre e salva le cordinate della regina del
   * proprio colore
   *
   * @param  board scacchiera da analizzare
   * @param  turn turno in corso
   * @return posizione della regina
   */

  public static Position findQueen(final Board board, final boolean turn) {
    Position posQueen = new Position(null, null);
    Integer i;
    Integer j = 0;
    Character queen;
    boolean flag = false; //flag per vedere se e' stata trovata la regina
    if (turn) {
      i = EIGHT - 1;
      queen = 'D';
    } else {
      i = 0;
      queen = 'd';
    }

    while (i >= 0 && i < EIGHT && !flag) {
      j = SEVEN;
      while (j >= 0 && !flag) {
        if (!board.isEmpty(i, j)) {
          if (board.getPieceName(i, j).equals(queen)) {
            flag = true;
          }
        }
        if (!flag) {
          j--;
        }
      }
      if (!flag) {
        if (turn) {
          i--;
        } else {
          i++;
        }
      }
    }
    if (flag) {
      posQueen.setPosX(i);
      posQueen.setPosY(j);
    }
    return posQueen;
  }
}
