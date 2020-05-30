package it.uniba.main;

/**
 *Class name: King
 *Class type: Entity
 *Responsibilities
 *Knows:
 *  Conosce la sua posizione e il suo colore.
 *Does:
 *  Fornisce informazioni su se stesso.
 *  Fornisce la possibile posizione del re sulla scacchiera.
 */

public class King extends Piece {
  private static final int LIMIT = 7;
  private static final int EIGHT = 8;
  private static final int ZERO = 8;
  private Position kingPosition = new Position(0, 0);
  private Boolean firstStep = null;

  //____________________________________________________________________________________________
  /**
   * Costruttore del pezzo re.
   * Crea un pezzo re con delle cordinate di partenza, un
   * colore e un nome dato in automatico a partire dal colore
   * 
   * @param coordX colonna di partenza
   * @param coordY riga di partenza
   * @param color colore del pezzo
   */
  public King(final Integer coordX, final Integer coordY, final Boolean color) { // costruttore
    super(color, name(color));
    kingPosition.setPosX(coordX);
    kingPosition.setPosY(coordY);
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
      name = 'r';
    } else {
      name = 'R';
    }
    return name;
  }

  //____________________________________________________________________________________

  /**
   * Metodo per verificare se il re si e' mosso.
   * @return true se non e' mosso, altriemnti false
   */

  public Boolean getFirstStep() { // ritorna first step
    return this.firstStep;
  }

  //____________________________________________________________________________________

  /**
   * Metodo per settare se il re si e' mosso.
   * @param value mosso/non mosso
   */

  public void setFirstStep(final boolean value) { // setta il valore di first step
    this.firstStep = value;
  }

  //____________________________________________________________________________________________

  /**
   * Metodo per sapere la posizione del re.
   * @return posizione desiderata
   */

  public Position getPosition() { // ritorna la posizione
    return this.kingPosition;
  }

  //_____________________________________________________________________________________

  /**
   * Metodo che setta la posizione x del re.
   *
   * @param positionX x da settare
   */

  public void setPositionX(final Integer positionX) {
    this.kingPosition.setPosX(positionX);
  }

  //___________________________________________________________________________________

  /**
   * Metodo che setta la posizione y del re.
   *
   * @param positionY y da settare
   */

  public void setPositionY(final Integer positionY) {
    this.kingPosition.setPosY(positionY);
  }

  //____________________________________________________________________________________________

  /**
   * Metodo per trovare i re nella scacchiera.
   * Prende una scacchiera da analizzare partendo dalla
   * posizione di arrivo si guarda intorno e vede se e'
   * presente il proprio re nelle vicinanze
   *
   * @param  stepXC colonna di arrivo
   * @param  stepYC colonna di partenza
   * @param  board scacchiera da analizzare
   * @param  piece re da cercare
   * @return posizione iniziale del re
   * @exception IllegalArgumentException se non e' stato trovato il re viene chiamata eccezione
   */

  public static Position findPosition(final int stepXC,
      final int stepYC, final Board board, final char piece) { //cerca pos
    Position actual = new Position(0, 0);
    if (stepXC == 0 && stepYC == 0) { //caso limite scacchiera
      actual = King.control00(board, stepXC, stepYC, piece);
    } else if (stepXC == 0 && stepYC == LIMIT) { //caso limite scacchiera
      actual = King.control07(board, stepXC, stepYC, piece);
    } else if (stepXC == LIMIT && stepYC == 0) { //caso limite scacchiera
      actual = King.control70(board, stepXC, stepYC, piece);
    } else if (stepXC == LIMIT && stepYC == LIMIT) { //caso limite scacchiera
      actual = King.control77(board, stepXC, stepYC, piece);
    } else if (stepYC == 0) { //caso limite scacchiera
      if (Boolean.FALSE.equals(board.isEmpty(stepXC - 1, stepYC))
          && board.getPieceName(stepXC - 1, stepYC) == piece) {
        actual.setPosX(stepXC - 1);
        actual.setPosY(stepYC);
      } else if (Boolean.FALSE.equals(board.isEmpty(stepXC - 1, stepYC + 1))
          && board.getPieceName(stepXC - 1, stepYC + 1) == piece) {
        actual.setPosX(stepXC - 1);
        actual.setPosY(stepYC + 1);
      } else if (Boolean.FALSE.equals(board.isEmpty(stepXC, stepYC + 1))
          && board.getPieceName(stepXC, stepYC + 1) == piece) {
        actual.setPosX(stepXC);
        actual.setPosY(stepYC + 1);
      } else if (Boolean.FALSE.equals(board.isEmpty(stepXC + 1, stepYC + 1))
          && board.getPieceName(stepXC + 1, stepYC + 1) == piece) {
        actual.setPosX(stepXC + 1);
        actual.setPosY(stepYC + 1);
      } else if (Boolean.FALSE.equals(board.isEmpty(stepXC + 1, stepYC))
          && board.getPieceName(stepXC + 1, stepYC) == piece) {
        actual.setPosX(stepXC + 1);
        actual.setPosY(stepYC);
      } else {
        throw new IllegalArgumentException("Mossa non valida.");
      }
    } else if (stepXC == 0) { //caso limite scacchiera
      if (Boolean.FALSE.equals(board.isEmpty(stepXC, stepYC + 1))
          && board.getPieceName(stepXC, stepYC + 1) == piece) {
        actual.setPosX(stepXC);
        actual.setPosY(stepYC + 1);
      } else if (Boolean.FALSE.equals(board.isEmpty(stepXC + 1, stepYC + 1))
          && board.getPieceName(stepXC + 1, stepYC + 1) == piece) {
        actual.setPosX(stepXC + 1);
        actual.setPosY(stepYC + 1);
      } else if (Boolean.FALSE.equals(board.isEmpty(stepXC + 1, stepYC))
          && board.getPieceName(stepXC + 1, stepYC) == piece) {
        actual.setPosX(stepXC + 1);
        actual.setPosY(stepYC);
      } else if (Boolean.FALSE.equals(board.isEmpty(stepXC + 1, stepYC - 1))
          && board.getPieceName(stepXC + 1, stepYC - 1) == piece) {
        actual.setPosX(stepXC + 1);
        actual.setPosY(stepYC - 1);
      } else if (Boolean.FALSE.equals(board.isEmpty(stepXC, stepYC - 1))
          && board.getPieceName(stepXC, stepYC - 1) == piece) {
        actual.setPosX(stepXC);
        actual.setPosY(stepYC - 1);
      } else {
        throw new IllegalArgumentException("Mossa non valida.");
      }

    } else if (stepYC == LIMIT) { //caso limite scacchiera
      if (Boolean.FALSE.equals(board.isEmpty(stepXC - 1, stepYC))
            && board.getPieceName(stepXC - 1, stepYC) == piece) {
        actual.setPosX(stepXC - 1);
        actual.setPosY(stepYC);
      } else if (Boolean.FALSE.equals(board.isEmpty(stepXC - 1, stepYC - 1))
          && board.getPieceName(stepXC - 1, stepYC - 1) == piece) {
        actual.setPosX(stepXC - 1);
        actual.setPosY(stepYC - 1);
      } else if (Boolean.FALSE.equals(board.isEmpty(stepXC, stepYC - 1))
          && board.getPieceName(stepXC, stepYC - 1) == piece) {
        actual.setPosX(stepXC);
        actual.setPosY(stepYC - 1);
      } else if (Boolean.FALSE.equals(board.isEmpty(stepXC + 1, stepYC - 1))
          && board.getPieceName(stepXC + 1, stepYC - 1) == piece) {
        actual.setPosX(stepXC + 1);
        actual.setPosY(stepYC - 1);
      } else if (Boolean.FALSE.equals(board.isEmpty(stepXC + 1, stepYC))
          && board.getPieceName(stepXC + 1, stepYC) == piece) {
        actual.setPosX(stepXC + 1);
        actual.setPosY(stepYC);
      } else {
        throw new IllegalArgumentException("Mossa non valida.");
      }

    } else if (stepXC == LIMIT) { //caso limite scacchiera
      if (Boolean.FALSE.equals(board.isEmpty(stepXC, stepYC - 1))
          && board.getPieceName(stepXC, stepYC - 1) == piece) {
        actual.setPosX(stepXC);
        actual.setPosY(stepYC - 1);
      } else if (Boolean.FALSE.equals(board.isEmpty(stepXC - 1, stepYC - 1))
          && board.getPieceName(stepXC - 1, stepYC - 1) == piece) {
        actual.setPosX(stepXC - 1);
        actual.setPosY(stepYC - 1);
      } else if (Boolean.FALSE.equals(board.isEmpty(stepXC - 1, stepYC))
          && board.getPieceName(stepXC - 1, stepYC) == piece) {
        actual.setPosX(stepXC - 1);
        actual.setPosY(stepYC);
      } else if (Boolean.FALSE.equals(board.isEmpty(stepXC - 1, stepYC + 1))
          && board.getPieceName(stepXC - 1, stepYC + 1) == piece) {
        actual.setPosX(stepXC - 1);
        actual.setPosY(stepYC + 1);
      } else if (Boolean.FALSE.equals(board.isEmpty(stepXC, stepYC + 1))
          && board.getPieceName(stepXC, stepYC + 1) == piece) {
        actual.setPosX(stepXC);
        actual.setPosY(stepYC + 1);
      } else {
        throw new IllegalArgumentException("Mossa non valida.");
      }

    } else { //caso posizione centrale
      actual = King.controlbase(board, stepXC, stepYC, piece);
    }

    return actual;
  }

  /**
   * Metodo che controlla il caso 00 del findposition.
   *
   * @param board sacchiera di gioco
   * @param stepXC colonna di arrivo
   * @param stepYC riga di arrivo
   * @param piece pezzo da cercare
   * @return posizione del re se trovata
   * @exception IllegalArgumentException se non e' presente alcun re chiama l'eccezione
   */

  public static Position control00(final Board board, final int stepXC, final int stepYC,
      final char piece) {
    Position actual = new Position(0, 0);
    if (Boolean.FALSE.equals(board.isEmpty(stepXC, stepYC + 1))
        && board.getPieceName(stepXC, stepYC + 1) == piece) {
      actual.setPosX(stepXC);
      actual.setPosY(stepYC + 1);
    } else if (Boolean.FALSE.equals(board.isEmpty(stepXC + 1, stepYC))
        && board.getPieceName(stepXC + 1, stepYC) == piece) {
      actual.setPosX(stepXC + 1);
      actual.setPosY(stepYC);
    } else if (Boolean.FALSE.equals(board.isEmpty(stepXC + 1, stepYC + 1))
        && board.getPieceName(stepXC + 1, stepYC + 1) == piece) {
      actual.setPosX(stepXC + 1);
      actual.setPosY(stepYC + 1);
    } else {
      throw new IllegalArgumentException("Mossa non valida.");
    }

    return actual;
  }

  /**
   * Metodo che controlla il caso 07 del findposition.
   *
   * @param board sacchiera di gioco
   * @param stepXC colonna di arrivo
   * @param stepYC riga di arrivo
   * @param piece pezzo da cercare
   * @return posizione del re se trovata
   * @exception IllegalArgumentException se non e' presente alcun re chiama l'eccezione
   */

  public static Position control07(final Board board, final int stepXC, final int stepYC,
      final char piece) {
    Position actual = new Position(0, 0);
    if (Boolean.FALSE.equals(board.isEmpty(stepXC, stepYC - 1))
        && board.getPieceName(stepXC, stepYC - 1) == piece) {
      actual.setPosX(stepXC);
      actual.setPosY(stepYC - 1);
    } else if (Boolean.FALSE.equals(board.isEmpty(stepXC + 1, stepYC))
        && board.getPieceName(stepXC + 1, stepYC) == piece) {
      actual.setPosX(stepXC + 1);
      actual.setPosY(stepYC);
    } else if (Boolean.FALSE.equals(board.isEmpty(stepXC + 1, stepYC - 1))
        && board.getPieceName(stepXC + 1, stepYC - 1) == piece) {
      actual.setPosX(stepXC + 1);
      actual.setPosY(stepYC - 1);
    } else {
      throw new IllegalArgumentException("Mossa non valida.");
    }
    return actual;
  }

  /**
   * Metodo che controlla il caso 70 del findposition.
   *
   * @param board sacchiera di gioco
   * @param stepXC colonna di arrivo
   * @param stepYC riga di arrivo
   * @param piece pezzo da cercare
   * @return posizione del re se trovata
   * @exception IllegalArgumentException se non e' presente alcun re chiama l'eccezione
   */

  public static Position control70(final Board board, final int stepXC, final int stepYC,
      final char piece) {
    Position actual = new Position(0, 0);
    if (Boolean.FALSE.equals(board.isEmpty(stepXC - 1, stepYC))
         && board.getPieceName(stepXC - 1, stepYC) == piece) {
      actual.setPosX(stepXC - 1);
      actual.setPosY(stepYC);
    } else if (Boolean.FALSE.equals(board.isEmpty(stepXC, stepYC + 1))
        && board.getPieceName(stepXC, stepYC + 1) == piece) {
      actual.setPosX(stepXC);
      actual.setPosY(stepYC + 1);
    } else if (Boolean.FALSE.equals(board.isEmpty(stepXC - 1, stepYC + 1))
        && board.getPieceName(stepXC - 1, stepYC + 1) == piece) {
      actual.setPosX(stepXC - 1);
      actual.setPosY(stepYC + 1);
    } else {
      throw new IllegalArgumentException("Mossa non valida.");
    }
    return actual;
  }

  /**
   * Metodo che controlla il caso 77 del findposition.
   *
   * @param board sacchiera di gioco
   * @param stepXC colonna di arrivo
   * @param stepYC riga di arrivo
   * @param piece pezzo da cercare
   * @return posizione del re se trovata
   * @exception IllegalArgumentException se non e' presente alcun re chiama l'eccezione
   */

  public static Position control77(final Board board, final int stepXC, final int stepYC,
      final char piece) {
    Position actual = new Position(0, 0);
    if (Boolean.FALSE.equals(board.isEmpty(stepXC, stepYC - 1))
        && board.getPieceName(stepXC, stepYC - 1) == piece) {
      actual.setPosX(stepXC);
      actual.setPosY(stepYC - 1);
    } else if (Boolean.FALSE.equals(board.isEmpty(stepXC - 1, stepYC - 1))
        && board.getPieceName(stepXC - 1, stepYC - 1) == piece) {
      actual.setPosX(stepXC - 1);
      actual.setPosY(stepYC - 1);
    } else if (Boolean.FALSE.equals(board.isEmpty(stepXC - 1, stepYC))
        && board.getPieceName(stepXC - 1, stepYC) == piece) {
      actual.setPosX(stepXC - 1);
      actual.setPosY(stepYC);
    } else {
      throw new IllegalArgumentException("Mossa non valida.");
    }
    return actual;
  }

  /**
   * Metodo che controlla il caso base del findposition.
   *
   * @param board sacchiera di gioco
   * @param stepXC colonna di arrivo
   * @param stepYC riga di arrivo
   * @param piece pezzo da cercare
   * @return posizione del re se trovata
   * @exception IllegalArgumentException se non e' presente alcun re chiama l'eccezione
   */

  public static Position controlbase(final Board board, final int stepXC, final int stepYC,
      final char piece) {
    Position actual = new Position(0, 0);
    if (Boolean.FALSE.equals(board.isEmpty(stepXC - 1, stepYC - 1))
        && board.getPieceName(stepXC - 1, stepYC - 1) == piece) {
      actual.setPosX(stepXC - 1);
      actual.setPosY(stepYC - 1);
    } else if (Boolean.FALSE.equals(board.isEmpty(stepXC - 1, stepYC))
        && board.getPieceName(stepXC - 1, stepYC) == piece) {
      actual.setPosX(stepXC - 1);
      actual.setPosY(stepYC);
    } else if (Boolean.FALSE.equals(board.isEmpty(stepXC - 1, stepYC + 1))
        && board.getPieceName(stepXC - 1, stepYC + 1) == piece) {
      actual.setPosX(stepXC - 1);
      actual.setPosY(stepYC + 1);
    } else if (Boolean.FALSE.equals(board.isEmpty(stepXC, stepYC + 1))
        && board.getPieceName(stepXC, stepYC + 1) == piece) {
      actual.setPosX(stepXC);
      actual.setPosY(stepYC + 1);
    } else if (Boolean.FALSE.equals(board.isEmpty(stepXC + 1, stepYC + 1))
        && board.getPieceName(stepXC + 1, stepYC + 1) == piece) {
      actual.setPosX(stepXC + 1);
      actual.setPosY(stepYC + 1);
    } else if (Boolean.FALSE.equals(board.isEmpty(stepXC + 1, stepYC))
        && board.getPieceName(stepXC + 1, stepYC) == piece) {
      actual.setPosX(stepXC + 1);
      actual.setPosY(stepYC);
    } else if (Boolean.FALSE.equals(board.isEmpty(stepXC + 1, stepYC - 1))
        && board.getPieceName(stepXC + 1, stepYC - 1) == piece) {
      actual.setPosX(stepXC + 1);
      actual.setPosY(stepYC - 1);
    } else if (Boolean.FALSE.equals(board.isEmpty(stepXC, stepYC - 1))
        && board.getPieceName(stepXC, stepYC - 1) == piece) {
      actual.setPosX(stepXC);
      actual.setPosY(stepYC - 1);
    } else {
      throw new IllegalArgumentException("Mossa non valida.");
    }
    return actual;
  }

  /**
   * Metodo che controlla se un movimento e' valido o mette sotto scacco il re.
   * Prende il pezzo che si sta spostando e analizza la nuova scacchiera
   * per controllare se il tutto e' valido
   *
   * @param start posizione iniziale del pezzo da analizzare
   * @param end posizione finale del pezzo da analizzare
   * @param board scacchiera di gioco
   * @param turn turno in corso
   * @return true se valido, altrimenti false
   */

  public static boolean controlCheck(final Position start, final Position end,
         final Board board, final boolean turn) {
    char type;
    boolean flag = false; //controlla se il movimento e' valido
    Position king = new Position(ZERO, ZERO);
    if (turn) {
      type = 'R';
    } else {
      type = 'r';
    }
    for (int i = 0; i < EIGHT; i++) {
      for (int j = 0; j < EIGHT; j++) {
        if (!board.isEmpty(i, j)) {
          Piece piece = board.getPiece(i, j);
          if (piece.getName() == type) {
            king = new Position(i, j);
          }
        }
      }
    }
    if (!king.equals(new Position(ZERO, ZERO))) {
      Piece piece = board.getPiece(start.getPosX(), start.getPosY()); //pezzo da riposizionare
      Board board1 = new Board();
      for (int i = 0; i < EIGHT; i++) {
        for (int j = 0; j < EIGHT; j++) {
          if (!board.isEmpty(i, j)) {
            Piece piece1 = board.getPiece(i, j);
            board1.setPiece(new Position(i, j), piece1);
          }
        }
      }
      board1.setEmpty(start.getPosX(), start.getPosY());
      board1.setPiece(end, piece);
      if (CheckLegalMove.legalKing(king, turn, board1)) {
        flag = true;
      }
    } else {
      flag = true;
    }
    return flag;
  }
}
