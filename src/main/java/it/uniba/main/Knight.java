package it.uniba.main;

import java.util.ArrayList;

/**
 *Class name: Knight
 *Class type: Entity
 *Responsibilities
 *Knows:
 * Conosce la sua posizione e il suo colore.
 *Does:
 * Fornisce informazioni su se stesso.
 * Fornisce la lista delle possibili posizioni dei cavalli sulla scacchiera.
 */

public class Knight extends Piece {
  private Position knightPosition = new Position(0, 0);

  private static final int ZERO = 0;
  private static final int ONE = 1;
  private static final int TWO = 2;
  private static final int THREE = 3;
  private static final int FOUR = 4;

  private static final int SIX = 6;
  private static final int SEVEN = 7;
  private static final int EIGHT = 8;

  private static final int TEN = 10;
  private static final int ELEVEN = 11;
  private static final int TWELVE = 12;
  private static final int THIRTEEN = 13;


  //____________________________________________________________________________________________

  /**
   * Costruttore del pezzo cavallo.
   * Crea un pezzo cavallo con delle cordinate di partenza, un
   * colore e un nome dato in automatico a partire dal colore
   *
   *
   * @param coordX colonna di partenza
   * @param coordY riga di partenza
   * @param color colore del pezzo
   */

  public Knight(final Integer coordX, final Integer coordY, final Boolean color) { // costruttore
    super(color, name(color));
    knightPosition.setPosX(coordX);
    knightPosition.setPosY(coordY);
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
      name = 'c';
    } else {
      name = 'C';
    }
    return name;
  }

  //____________________________________________________________________________________

  /**
   * Metodo per impostare colonna di partenza.
   * @param positionX colonna impostata
   */

  public void setPositionX(final Integer positionX) {
    this.knightPosition.setPosX(positionX);
  }

  //_____________________________________________________________________________________

  /**
   * Metodo per impostare riga di partenza.
   * @param positionY riga impostata
   */

  public void setPositionY(final Integer positionY) {
    this.knightPosition.setPosY(positionY);
  }

  //____________________________________________________________________________________

  /**
   * Metodo per ottenere posizione del pezzo.
   * @return posizione del pezzo
   */

  public Position getPosition() { // ritorna la posizione del pezzo
    return this.knightPosition;
  }

  //_____________________________________________________________________________________

  /**
   * Metodo che controlla se il movimento del cavallo e' valido.
   * prende la posizione di arrivo e quella di partenza e controlla
   * se il movimento e' valido seguendo le regole degli scacchi
   *
   * @param stepX colonna di partenza
   * @param stepY riga di partenza
   * @param posKnight posizione di arrivo
   * @return mossa valida o no
   */

  public static Integer[] validMove(final Integer stepX,
      final Integer stepY, final Position posKnight) {
    Integer[] array = {0, 0};
    Integer actualX = posKnight.getPosX();    // actualX avrà la posizione su X del cavallo
    Integer actualY = posKnight.getPosY();    // actualY avrà la posizione su Y del cavallo

    if (actualX < stepX && actualY < stepY) { //se il mio cavallo si trova nel secondo quadrante
      if (actualX + 2 == stepX && actualY + 1 == stepY) {    // mossa valida uno
        array[0] = +TWO;
        array[1] = +ONE;
      } else if (actualX + 1 == stepX && actualY + 2 == stepY) {    // mossa valida 2
        array[0] = +ONE;
        array[1] = +TWO;
      }
    } else if (actualX < stepX && actualY > stepY) { // se il cavallo si trova nel primo quadrante
      if (actualX + 2 == stepX && actualY - 1 == stepY) {    // mossa valida 1
        array[0] = +TWO;
        array[1] = -ONE;
      } else if (actualX + 1 == stepX && actualY - 2 == stepY) {    // mossa valida 2
        array[0] = +ONE;
        array[1] = -TWO;
      }
    } else if (actualX > stepX && actualY > stepY) { // se il cavallo si trova nel quarto quadrante
      if (actualX - 1 == stepX && actualY - 2 == stepY) {    // mossa valida 1
        array[0] = -ONE;
        array[1] = -TWO;
      } else if (actualX - 2 == stepX && actualY - 1 == stepY) { // mossa valida 2
        array[0] = -TWO;
        array[1] = -ONE;
      }
    } else if (actualX > stepX && actualY < stepY) { // se il cavallo si trova nel terzo quadrante
      if (actualX - 1 == stepX && actualY + 2 == stepY) {    // mossa valida 1
        array[0] = -ONE;
        array[1] = +TWO;
      } else if (actualX - 2 == stepX && actualY + 1 == stepY) {
        array[0] = -TWO;
        array[1] = +ONE;
      }
    } else { // rutorna 0,0 se il cavallo non si puo' muovere
      array[0] = ZERO;
      array[1] = ZERO;
    }
    return array;
  }

  //__________________________________________________________________________________________

  /**
  * Metodo per trovare i cavalli nella scacchiera.
  * Prende una scacchiera da analizzare e il turno in corso
  * la scorre e salva le cordinate dei cavalli del
  * proprio colore che trova
  *
  * @param  board scacchiera da analizzare
  * @param  turn turno in corso
  * @param  stepX colonna di arrivo
  * @param  stepY riga di arrivo
  * @param  move tipo di movimento
  * @param  pieceName nome del pezzo
  * @param  stringInput stringa in notazione algebrica
  * @return array contenente la posizione dei cavalli
  */

  public static ArrayList<Position> findKnight(final Boolean turn, final Board board,
      final Integer stepX, final Integer stepY, final Integer move, final Character pieceName,
      final String stringInput) {
    ArrayList<Position> knightList = new ArrayList<>();
    Byte endWhile = 0; // fine del ciclo while
    Integer col = 0; // colonna
    Byte countWhile = 0;

    if (move == TEN || move == ELEVEN) {
      if (stepY == ZERO) { // se la colonna di destinazione � A
        col = ONE;
        endWhile = TWO;
      } else if (stepY == ONE) { // altrimenti se la colonna di destinazione � B
        col = ZERO;
        endWhile = THREE;
      } else if (stepY == SEVEN) { // altrimenti se la colonna di destinazione � H
        col = SIX;
        endWhile = TWO;
      } else if (stepY == SIX) { // altrimenti se la colonna di destinazione � G
        col = SEVEN;
        endWhile = THREE;
      } else {
        col = stepY - TWO;
        endWhile = FOUR;
      }

      do {
        for (Integer i = 0; i < EIGHT; i++) { // ciclo su tutta la colonna
          if (!board.isEmpty(i, col)) {
            if (board.getPieceName(i, col).compareTo(pieceName) == 0) {
              knightList.add(new Position(i, col));
            }
          }
        }
        if (stepY == 0) { // se la colonna di destinazione � A incremento colonna di uno
          col++;
        } else if (stepY == 1) { // altrimenti se la colonna di destinazione � B
          if (col == 0) { // se mi trovo su a allora incremento di 2 per saltare la colonna B
            col += 2;
          } else {
            col++; // se non sono su A allora incremento di uno solo
          }
        } else if (stepY == SEVEN) { // altrimenti se la colonna di destinazione � H
          col--; // se sono su H decremento di 1
        } else if (stepY == SIX) { // altrimenti se la colonna di destinazione � G
          if (col == SEVEN) { // se sono su H allora decremento di 2 saltando la G
            col -= 2;
          } else { // altrimenti decremento di 1
            col--;
          }
        } else {
          if (col == stepY - 1) {
            col += 2;
          } else { // altrimenti la incremento solo di q
            col++;
          }
        }
        countWhile++;
      } while (!countWhile.equals(endWhile));
    } else if (move == TWELVE || move == THIRTEEN) {
      if (stringInput.substring(1, 2).matches("[a-z]")) {
        col = ParserString.convertY(stringInput.substring(1, 2));
        do {
          for (Integer i = 0; i < EIGHT; i++) { // ciclo su tutta la colonna
            if (!board.isEmpty(i, col)) {
              if (board.getPieceName(i, col).compareTo(pieceName) == 0) {
                knightList.add(new Position(i, col));
              }
            }
          }
          if (col < stepY) {
            col = col + 2;
            countWhile++;
          } else if (col > stepY) {
            col = col - 2;
            countWhile++;
          }
        } while (countWhile < 2); // ciclo per due colonne
      } else {
        col = ParserString.convertX(stringInput.substring(1, 2));
        do {
          for (Integer i = 0; i < EIGHT; i++) { // ciclo su tutta la riga
            if (!board.isEmpty(col, i)) {
              if (board.getPieceName(col, i).compareTo(pieceName) == 0) {
                knightList.add(new Position(col, i));
              }
            }
          }
          if (col < stepX) {
            col = col + 2;
            countWhile++;
          } else if (col > stepX) {
            col = col - 2;
            countWhile++;
          }

        } while (countWhile < TWO); // ciclo per due colonne
      }
    }
    return knightList;
  }
}
