package it.uniba.main;

/**
 *Class name: Position
 *Class type: No ECB
 *Responsibilities
 *Knows:
 * Conosce le coordinate x ed y del pezzo a cui e' associato.
 *Does:
 * Permette di ottenere le coordinate.
 * Permette di impostare le coordinate.
 */

public class Position {
  private Integer posX; // posizione sull'asse x
  private Integer posY; // posizione sull'asse y

  //____________________________________________________________________________________

  /**
   * Costruttore della classe position.
   *
   * @param x colonna-x
   * @param y riga-y
   */

  public Position(final Integer x, final Integer y) {  // costruttore della classe Position
    this.posX = x;
    this.posY = y;
  }

  //____________________________________________________________________________________

  /**
   *Metodo per ottenere la colonna.
   * @return colonna-x
   */

  public Integer getPosX() { // metodo atto alla restutuzione della coordinata x
    return posX;
  }

  //____________________________________________________________________________________

  /**
   *Metodo per ottenere la riga.
   * @return riga-y
   */

  public Integer getPosY() { // metodo atto alla restituzione della coordinata  y
    return posY;
  }

  //____________________________________________________________________________________

  /**
   *Metodo per settare la colonna.
   * @param positionX colonna-x
   */

  public void setPosX(final Integer positionX) { // metodo atto a settare la coordinata x
    this.posX = positionX;
  }

  //____________________________________________________________________________________

  /**
   *Metodo per settare la riga.
   * @param positionY riga-y
   */

  public void setPosY(final Integer positionY) { // metodo atto a settare la coordinata y
    this.posY = positionY;
  }

  //____________________________________________________________________________________

  /**
   * Metodo che controlla se due posizioni sono uguali.
   */

  @Override
  public boolean equals(final Object obj) {

    if (obj == null) {
      return false;
    }

    if (this.getClass() != obj.getClass()) {
      return false;
    }

    Position pos = (Position) obj;
    return (this.getPosX().equals((pos.getPosX()))
       && (this.getPosY().equals((pos.getPosY()))));
  }

  /**
   * Metodo per far funzionare equals.
   */

  @Override
  public int hashCode() {
    return posX;
  }


  //____________________________________________________________________________________

  /**
   * Metodo che concatena x e y.
   */

  @Override
  public String toString() {
    return (posX + " " + posY);
  }
}

