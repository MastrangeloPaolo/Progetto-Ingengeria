package it.uniba.main;

/**
 *Class name: Piece
 *Class type: Entity
 *Responsibilities
 *Knows:
 * Conosce la tipologia di pezzo e il suo colore.
 *Does:
 * Fornisce informazioni su se stesso.
 */

public abstract class Piece implements Comparable<Piece> { // classe astratta di pezzi
  private Boolean color = null; // color black = false , else white = true
  private Character name; // nome (maiuscolo) se e' bianco, altrimenti (minuscolo) se e' sero

  //____________________________________________________________________________________
  /**
   * Costruttore classe Piece.
   * Crea un pezzo con un nome ed un colore
   * @param colors colore del pezzo
   * @param names nome del pezzo
   */
  public Piece(final Boolean colors, final char names) {
    color = colors;
    name = names;
  }
  //____________________________________________________________________________________

  /**
   * Metodo per ottenere colore del cavallo.
   * @return colore del pezzo
   */

  public Boolean getColor() { // metodo astratto atto alla restituzione del colore
    return this.color;
  }
  /**
   * Metodo per ottenere nome del pezzo.
   * @return nome del pezzo MAIUSCOLO/minuscolo
   */

  public Character getName() {  // metodo atto alla restituzione del nome del pezzo
    return this.name;
  }

  //____________________________________________________________________________________

  /**
   * Metodo che compara due pezzi.
   * Utilizza equals per comparare due pezzi
   *
   *
   * @param secondPiece pezzo con cui comparare
   * @return 0 se uguale 1 se diverso
   */

  public int compareTo(final Piece secondPiece) {
    if (this.name.equals(secondPiece.name)) {
      return 0;
    } else {
      return 1;
    }
  }
}

