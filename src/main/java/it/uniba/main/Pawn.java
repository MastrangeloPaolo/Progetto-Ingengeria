package it.uniba.main;

/**
 *Class name: Sottoclasse di Piece chiamata Pawn
 *Class type: Entity
 *Responsabilities
 *Knows:
 * Conosce la sua posizione e il suo colore.
 *Does:
 * Fornisce informazioni su se stesso.
 */

public class Pawn extends Piece  {
  private Position pawnPosition = new Position(0, 0);
  private Boolean firstStep = null;

  //____________________________________________________________________________________

  /**
   * Costruttore del pezzo pedone.
   * Crea un pezzo pedone con delle cordinate di partenza, un
   * colore e un nome dato in automatico a partire dal colore
   *
   *
   * @param coordX colonna di partenza
   * @param coordY riga di partenza
   * @param color colore del pezzo
   */

  public Pawn(final Integer coordX, final Integer coordY, final Boolean color) { // costruttore
    super(color, name(color));
    pawnPosition.setPosX(coordX);
    pawnPosition.setPosY(coordY);
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
      name = 'p';
    } else {
      name = 'P';
    }
    return name;
  }

  //_____________________________________________________________________________________

  /**
   * Metodo per impostare colonna di partenza.
   * @param positionX colonna impostata
   */

  public void setPositionX(final Integer positionX) {
    this.pawnPosition.setPosX(positionX);
  }

  //___________________________________________________________________________________

  /**
   * Metodo per impostare riga di partenza.
   * @param positionY riga impostata
   */

  public void setPositionY(final Integer positionY) {
    this.pawnPosition.setPosY(positionY);
  }

  //____________________________________________________________________________________

  /**
   * Metodo per verificare se il pedone si e' mosso.
   * @return true se non e' mosso, altriemnti false
   */

  public Boolean getFirstStep() { // ritorna first step
    return this.firstStep;
  }

  //____________________________________________________________________________________

  /**
   * Metodo per settare se il pedone si e' mosso.
   * @param value mosso/non mosso
   */

  public void setFirstStep(final boolean value) { // setta il valore di first step
    this.firstStep = value;
  }

  //____________________________________________________________________________________

  /**
   * Metodo per ottenere posizione del pezzo.
   * @return posizione del pezzo
   */

  public Position getPosition() { // ritorna la posizione
    return this.pawnPosition;
  }
}



