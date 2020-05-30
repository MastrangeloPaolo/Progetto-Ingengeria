package it.uniba.main;

/**
 *Class name: CheckLegalMove
 * Class type: Control
 *Responsibilities
 *Knows:
 *Does:
 * Effettua i controlli riguardanti la fattibilita' di una mossa,
 * in base al pezzo su cui viene richiamato il proprio metodo.
 * Nel caso del re, controlla anche che il movimento sia possibile
 * senza incorrere nel rischio di essere mangiato nel turno successivo.
 */

public final class CheckLegalMove {
  private static final int PAWNM2 = -2;
  private static final int PAWNM1 = -1;
  private static final int PAWN1 = 1;
  private static final int PAWN2 = 2;
  private static final int CHESSBOARDL = 8;

  private CheckLegalMove() {
  //non chiamato
  }

  /**
   * Metodo che controlla se il passo singolo del pedone e' valido.
   * Prende la posizione di arrivo e quella di partenza e vede se il movimento
   * segue le regole standard del gioco degli scacchi
   *
   * @param start posizione di partenza
   * @param end posizione di arrivo
   * @param board scacchiera con cui si sta giocando
   * @param turn turno del giocatore che vuole muovere
   * @return true se movimento valido, altrimenti false
   */

  public static boolean legalMovePawn(final Position start, final Position end,
      final Board board, final Boolean turn) {
    Boolean check = false;
    Integer startX = start.getPosX();
    Integer startY = start.getPosY();
    Integer endX = end.getPosX();
    Integer endY = end.getPosY();
    Integer x; //valore da sommare alla colonna di partenza vale +-1

    if (turn) {
      x = -1; //turno dei bianchi
    } else { //turno dei neri
      x = 1;
    }

    if (startY.equals(endY)) { //se la colonna è uguale
      if (startX + x == endX && board.isEmpty(endX, endY)) { // se la riga di arrivo e' uguale
        check = true;
      }
    }
    return check;
  }

  /**
   * Metodo che controlla se doppio passo del pedone e' valido.
   * Prende la posizione di arrivo e quella di partenza e vede se il movimento
   * segue le regole standard del gioco degli scacchi
   *
   * @param start posizione di partenza
   * @param end posizione di arrivo
   * @param board scacchiera con cui si sta giocando
   * @param turn turno del giocatore che vuole muovere
   * @return true se movimento valido, altrimenti false
   */

  public static boolean legalMove2Pawn(final Position start,
      final Position end, final Board board, final Boolean turn) {
    Boolean check = false;
    Integer startX = start.getPosX();
    Integer startY = start.getPosY();
    Integer endX = end.getPosX();
    Integer endY = end.getPosY();
    Integer x; //valore da sommare alla colonna di partenza vale +-2 in base al turno
    Integer x1; //valore da sommare alla colonna di partenza vale +-1 in base al turno


    if (turn) {
      x1 = PAWNM1;
      x = PAWNM2; //turno dei bianchi
    } else {
      x1 = PAWN1;
      x = PAWN2; //turno dei neri
    }
    Piece piece = board.getPiece(startX, startY);
    Pawn pawn = (Pawn) piece;

    if (pawn.getFirstStep()) {
      if (startY.equals(endY)) { //se la colonna è uguale
        if (startX + x == endX && board.isEmpty(startX + x1, endY) && board.isEmpty(endX, endY)) {
          check = true; // se la riga e' libera effettuo la mossa
        }
      }
    }
    return check;
  }

  /**
   * Metodo che controlla se il movimento dell'alfiere e' valido.
   * Prende la posizione di arrivo e quella di partenza e vede se il movimento
   * segue le regole standard del gioco degli scacchi
   *
   * @param start posizione di partenza
   * @param end posizione di arrivo
   * @param board scacchiera con cui si sta giocando
   * @return true se movimento valido, altrimenti false
   */

  public static Boolean legalMoveBishop(final Position start, final Position end,
      final Board board) {

    if (start.getPosX() > end.getPosX()) {
      if (start.getPosY() > end.getPosY()) {
        int x = (start.getPosX()) - 1;
        int y = (start.getPosY()) - 1;
        while ((x >= 0 && y >= 0)) {
          if (x == end.getPosX() && y == end.getPosY()) {
            return true;
          } else {
            if (!board.isEmpty(x, y)) {
              return false;
            }
          }
          x--;
          y--;
        }
      } else {
        int x = (start.getPosX()) - 1;
        int y = (start.getPosY()) + 1;
        while ((x >= 0 && y < CHESSBOARDL)) {
          if (x == end.getPosX() && y == end.getPosY()) {
            return true;
          } else {
            if (!board.isEmpty(x, y)) {
              return false;
            }
          }
          x--;
          y++;
        }
      }
    } else {
      if (start.getPosY() > end.getPosY()) {
        int x = (start.getPosX()) + 1;
        int y = (start.getPosY()) - 1;
        while ((x < CHESSBOARDL && y >= 0)) {
          if (x == end.getPosX() && y == end.getPosY()) {
            return true;
          } else {
            if (!board.isEmpty(x, y)) {
              return false;
            }
          }
          x++;
          y--;
        }
      } else {
        int x = (start.getPosX()) + 1;
        int y = (start.getPosY()) + 1;
        while ((x < CHESSBOARDL  && y < CHESSBOARDL)) {
          if (x == end.getPosX() && y == end.getPosY()) {
            return true;
          } else {
            if (!board.isEmpty(x, y)) {
              return false;
            }
          }
          x++;
          y++;
        }
      }
    }
    return false;
  }

  /**
   * Metodo che controlla se movimento della regina e' valido.
   * Prende la posizione di arrivo e quella di partenza e vede se il movimento
   * segue le regole standard del gioco degli scacchi
   *
   * @param start posizione di partenza
   * @param end posizione di arrivo
   * @param board scacchiera con cui si sta giocando
   * @return true se movimento valido, altrimenti false
   */

  public static Boolean legalMoveQueen(final Position start, final Position end,
      final Board board) {
    boolean flag = false;
    if (CheckLegalMove.legalMoveBishop(start, end, board)
        || CheckLegalMove.legalMoveRook(start, end, board)) {
      flag = true;
    }
    return flag;
  }

  /**
   * Metodo che controlla se il movimento della torre e' valido.
   * Prende la posizione di arrivo e quella di partenza e vede se il movimento
   * segue le regole standard del gioco degli scacchi
   *
   * @param start posizione di partenza
   * @param end posizione di arrivo
   * @param board scacchiera con cui si sta giocando
   * @return true se movimento valido, altrimenti false
   */

  public static Boolean legalMoveRook(final Position start, final Position end,
      final Board board) {

    Integer x = start.getPosX();
    Integer y = start.getPosY();
    boolean flag = true;

    Integer mod;
    Integer mod1;
    if (start.getPosY() < end.getPosY()) {
      mod1 = -1;
    } else {
      mod1 = 1;
    }
    if (start.getPosX() < end.getPosX()) {
      mod = -1;
    } else {
      mod = 1;
    }

    /* La Torre si muove sia orizzontalmente sia verticalmente per il numero di caselle libere  */

    if (start.getPosX().equals((end.getPosX())) || start.getPosY().equals(end.getPosY())) {
      if (start.getPosX().equals(end.getPosX())) {
        while (flag && y != end.getPosY() + mod1) {
          if (start.getPosY() < end.getPosY()) {
            y++;
          } else {
            y--;
          }
          if (board.isEmpty(x, y).equals(false)) {
            flag = false;
          }
        }
      } else if (start.getPosY().equals(end.getPosY())) {
        while (flag && x != end.getPosX() + mod) {
          if (start.getPosX() < end.getPosX()) {
            x++;
          } else {
            x--;
          }
          if (!(board.isEmpty(x, y))) {
            flag = false;
          }
        }
      }
    } else {
      flag = false;
    }
    return flag;
  }

  /**
   * Metodo che controlla se il movimento del cavallo e' valido.
   * Prende la posizione di arrivo e quella di partenza e vede se il movimento
   * segue le regole standard del gioco degli scacchi
   *
   * @param start posizione di partenza
   * @param end posizione di arrivo
   * @return true se movimento valido, altrimenti false
   */

  public static Boolean legalMoveKnight(final Position start, final Position end) {
    Boolean control = false;
    Integer stepX = end.getPosX();
    Integer stepY = end.getPosY();
    Integer actualX = start.getPosX();
    Integer actualY = start.getPosY();

    if (actualX < stepX && actualY < stepY) { //se il mio cavallo si trova nel secondo quadrante
      if (actualX + 2 == stepX && actualY + 1 == stepY) { // mossa valida uno
        control = true;
      } else if (actualX + 1 == stepX && actualY + 2 == stepY) { // mossa valida 2
        control = true;
      }
    } else if (actualX < stepX && actualY > stepY) { // se il cavallo si trova nel primo quadrante
      if (actualX + 2 == stepX && actualY - 1 == stepY) { // mossa valida 1
        control = true;
      } else if (actualX + 1 == stepX && actualY - 2 == stepY) { // mossa valida 2
        control = true;
      }
    } else if (actualX > stepX && actualY > stepY) { // se il cavallo si trova nel quarto quadrante
      if (actualX - 1 == stepX && actualY - 2 == stepY) { // mossa valida 1
        control = true;
      } else if (actualX - 2 == stepX && actualY - 1 == stepY) { // mossa valida 2
        control = true;
      }
    } else if (actualX > stepX && actualY < stepY) { // se il cavallo si trova nel terzo quadrante

      if (actualX - 1 == stepX && actualY + 2 == stepY) { // mossa valida 1
        control = true;
      } else if (actualX - 2 == stepX && actualY + 1 == stepY) {
        control = true;
      }
    } else {
      control = false;
    }
    return control;
  }

  /**
   * Metodo che controlla se la cattura del pedone e' valido.
   * Prende la posizione di arrivo e quella di partenza e vede se il movimento
   * segue le regole standard del gioco degli scacchi
   *
   * @param start posizione di partenza
   * @param end posizione di arrivo
   * @param color colore del pezzo
   * @return true se movimento valido, altrimenti false
   */

  public static boolean legalMoveCapturePawn(final Position start, final Position end,
      final boolean color) {
    Boolean flag = false;
    if (color) {
      if (start.getPosX() == (end.getPosX() - 1)
          && (start.getPosY() == (end.getPosY() - 1) || start.getPosY() == (end.getPosY() + 1))) {
        flag = true;
      }
    } else {
      if (start.getPosX() == (end.getPosX() + 1)
          && (start.getPosY() == (end.getPosY() - 1) || start.getPosY() == (end.getPosY() + 1))) {
        flag = true;
      }
    }
    return flag;
  }

  /**
   * Metodo che controlla se il movimento del re e' valido.
   * Prende la posizione di arrivo e quella di partenza e vede se il movimento
   * segue le regole standard del gioco degli scacchi
   *
   * @param start posizione di partenza
   * @param end posizione di arrivo
   * @return true se movimento valido, altrimenti false
   */

  public static boolean legalMoveKing(final Position start, final Position end) {
    boolean flag = false;
    if (start.getPosX().equals(end.getPosX() - 1) && start.getPosY().equals(end.getPosY() - 1)) {
      flag = true;
    } else if (start.getPosX().equals(end.getPosX() - 1) && start.getPosY().equals(end.getPosY())) {
      flag = true;
    } else if (start.getPosX().equals(end.getPosX() - 1)
          && start.getPosY().equals(end.getPosY() + 1)) {
      flag = true;
    } else if (start.getPosX().equals(end.getPosX()) && start.getPosY().equals(end.getPosY() + 1)) {
      flag = true;
    } else if (start.getPosX().equals(end.getPosX() + 1)
          && start.getPosY().equals(end.getPosY() + 1)) {
      flag = true;
    } else if (start.getPosX().equals(end.getPosX() + 1) && start.getPosY().equals(end.getPosY())) {
      flag = true;
    } else if (start.getPosX().equals(end.getPosX() + 1)
          && start.getPosY().equals(end.getPosY() - 1)) {
      flag = true;
    } else if (start.getPosX().equals(end.getPosX()) && start.getPosY().equals(end.getPosY() - 1)) {
      flag = true;
    }
    return flag;
  }

  /**
   * Metodo che controlla se il re si puo' muovere senza andare sotto scacco.
   * Prende la posizione di arrivo e vede se il movimento
   * segue le regole standard del gioco degli scacchi
   *
   * @param end posizione di arrivo
   * @param turn turno in corso
   * @param board scacchiera di gioco
   * @return true se movimento valido, altrimenti false
   */

  public static boolean legalKing(final Position end,  final Boolean turn,
      final Board board) {
    char typePiece;
    Position pos = new Position(0, 0);
    boolean flag = true;
    if (!(turn)) {
      for (int i = 0; i < CHESSBOARDL; i++) {
        for (int j = 0; j < CHESSBOARDL; j++) {
          if (!board.isEmpty(i, j)) {
            typePiece = board.getPieceName(i, j);
            pos.setPosX(i);
            pos.setPosY(j);
            switch (typePiece) {
              case 'T':
                if (CheckLegalMove.legalMoveRook(pos, end, board)) {
                  flag = false;
                }
                break;
              case 'C':
                if (CheckLegalMove.legalMoveKnight(pos, end)) {
                  flag = false;
                }
                break;
              case 'A':
                if (CheckLegalMove.legalMoveBishop(pos, end, board)) {
                  flag = false;
                }
                break;
              case 'D':
                if (CheckLegalMove.legalMoveQueen(pos, end, board)) {
                  flag = false;
                }
                break;
              case 'P':
                if (CheckLegalMove.legalMoveCapturePawn(pos, end, false)) {
                  flag = false;
                }
                break;
              case 'R':
                if (CheckLegalMove.legalMoveKing(pos, end)) {
                  flag = false;
                }
                break;
              default:
            }
          }
        }
      }
    } else {
      for (int i = 0; i < CHESSBOARDL; i++) {
        for (int j = 0; j < CHESSBOARDL; j++) {
          if (!(board.isEmpty(i, j))) {
            typePiece = board.getPieceName(i, j);
            pos.setPosX(i);
            pos.setPosY(j);
            switch (typePiece) {
              case 't':
                if (CheckLegalMove.legalMoveRook(pos, end, board)) {
                  flag = false;
                }
                break;
              case 'c':
                if (CheckLegalMove.legalMoveKnight(pos, end)) {
                  flag = false;
                }
                break;
              case 'a':
                if (CheckLegalMove.legalMoveBishop(pos, end, board)) {
                  flag = false;
                }
                break;
              case 'd':
                if (CheckLegalMove.legalMoveQueen(pos, end, board)) {
                  flag = false;
                }
                break;
              case 'p':
                if (CheckLegalMove.legalMoveCapturePawn(pos, end, true)) {
                  flag = false;
                }
                break;
              case 'r':
                if (CheckLegalMove.legalMoveKing(pos, end)) {
                  flag = false;
                }
                break;
              default:
            }
          }
        }
      }
    }
    return flag;
  }
}
