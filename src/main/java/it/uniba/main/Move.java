package it.uniba.main;

import java.util.ArrayList;

/**
 *Class name: Move
 *Class type: Control
 *Responsibilities
 *Knows:
 *Does:
 *Gestisce il movimento e la cattura dei vari pezzi sulla scacchiera
 *rispettando le regole standard degli scacchi.
 */

public final class Move {

  private static final int ZERO = 0;
  private static final int ONE = 1;
  private static final int TWO = 2;
  private static final int THREE = 3;
  private static final int FOUR = 4;
  private static final int FIVE = 5;
  private static final int SIX = 6;
  private static final int SEVEN = 7;
  private static final int TEN = 10;
  private static final int ELEVEN = 11;
  private static final int TWELVE = 12;
  private static final int THIRTEEN = 13;
  private static final int FOURTEEN = 14;

  /**
   *Costruttore classe Move.
   */

  private Move() {
    //non chiamato
  }

  //__________________________________________________________________________________________

  /**
   * Metodo per muovere il pedone.
   * Prende in input la stringa in notazione algebrica, la scacchiera
   * e il turno e controlla se il movimento e' valido seguendo le regole
   * standard degli scacchi.
   *
   * @param stringInput stringa in notazione algebrica
   * @param board scacchiera di gioco
   * @param turn turno in corso
   * @exception IllegalArgumentException se il movimento non si puo' fare viene chiamata eccezione
  */

  public static void movePawn(final String stringInput, final Board board, final Boolean turn) {
    Character name;
    Integer linemove; //linea di arrivo quando il pedone si sposta di due caselle
    Integer convert2; //converte la x di arrivo in x di partenza nel caso si sposta di 2
    Integer convert;  //converte la x di arrivo in x di partenza nel caso si sposta di 1
    Boolean isMove = false; //true= Ã¨ stato mosso un pedone
    Boolean check;  //contiene il risultato di legalMove
    Integer move = ParserString.analyzer(stringInput);
    if (turn) {
      name = 'P';       //durante il turno bianco prendo i pedoni bianchi
      linemove = FOUR;
      convert2 = TWO;
      convert = ONE;
    } else {
      name = 'p';   //durante il turno nero prendo i pezzi neri
      linemove = THREE;
      convert2 = -TWO;
      convert = -ONE;
    }
    if (stringInput.charAt(1) == 'x') {   // se Ã¨ una cattura
      Integer arriveY = ParserString.convertY(stringInput.substring(TWO, THREE));
      Integer arriveX = ParserString.convertX(stringInput.substring(THREE, FOUR));
      if (board.isEmpty(arriveX, arriveY)) {  // controlla se casella vuota, en passant
        move = THREE;
      } else {
        move = ONE;   // se no cattura semplice
      }
    }
    switch (move) {
      case ONE: // cattura
        Boolean isCaptur = false;
        Boolean color;
        Integer startYC = ParserString.convertY(stringInput.substring(ZERO, ONE));
        Integer arriveYC = ParserString.convertY(stringInput.substring(TWO, THREE));
        Integer arriveXC = ParserString.convertX(stringInput.substring(THREE, FOUR));
        if (turn) {
          color = true;   //durande il turno bianco vedo i pezzi neri
        } else {
          color = false;
        }
        if (board.getPieceColor(arriveXC, arriveYC).equals(color)) {
          if (startYC + 1 == arriveYC || startYC - 1 == arriveYC) {
            if (!board.isEmpty(arriveXC + convert, startYC)) {
              if (board.getPieceName(arriveXC + convert, startYC).equals(name)) {
                if (King.controlCheck(new Position(arriveXC + convert, startYC),
                       new Position(arriveXC, arriveYC), board, turn)) {
                  Piece piece =  board.getPiece(arriveXC + convert, startYC);
                  Pawn pawn = (Pawn) piece;
                  board.storeCaptures(turn, new Position(arriveXC, arriveYC));
                  board.setEmpty(arriveXC + convert, startYC);
                  board.setPiece(new Position(arriveXC, arriveYC), pawn);
                  pawn.setPositionX(arriveXC);
                  pawn.setPositionY(arriveYC);
                  board.setDoubleMove(null);
                  board.setStoryMove(stringInput);
                  isCaptur = true;
                } else {
                  throw new IllegalArgumentException("Mossa illegale,"
                            + " il Re verrebbe messo sotto scacco.");
                }
              }
            }
          }
        } else {
          throw new IllegalArgumentException("Il pezzo che vuoi catturare non e' dell'avversario.");
        }
        if (!isCaptur) {
          throw new IllegalArgumentException("Mossa non valida.");
        }
        break;
      case TWO:  // movimento
        try {
          Integer arriveY = ParserString.convertY(stringInput.substring(0, 1));
          Integer arriveX = ParserString.convertX(stringInput.substring(1, 2));
          Position end = new Position(arriveX, arriveY); // posizione di arrivo del pedone
          if (board.isEmpty(arriveX, arriveY)) {   //controllo casella di arrivo sia vuota
            if (!board.isEmpty(arriveX + convert, arriveY)) {
              Piece piece = board.getPiece(arriveX + convert, arriveY);
              if (piece.getName().equals(name)) {
                Position start = new Position(arriveX + convert, arriveY);
                if (King.controlCheck(start, new Position(arriveX, arriveY), board, turn)) {
                  Pawn pawn = (Pawn) piece;
                  board.setEmpty(arriveX + convert, arriveY);
                  board.setPiece(end, pawn);
                  pawn.setPositionX(arriveX);
                  pawn.setPositionY(arriveY);
                  board.setDoubleMove(null);
                  board.setStoryMove(stringInput);
                  isMove = true;
                } else {
                  throw new IllegalArgumentException("Mossa illegale,"
                            + " il Re verrebbe messo sotto scacco.");
                }
              }
            } else if (!board.isEmpty(arriveX + convert2, arriveY) && arriveX.equals(linemove)) {
              //se la casella di arrivo +o- 2 non e' vuota
              Piece piece = board.getPiece(arriveX + convert2, arriveY);
              if (piece.getName().equals(name)) {  //controllo turno
                Position start = new Position(arriveX + convert2, arriveY);
                check = CheckLegalMove.legalMove2Pawn(start, end, board, turn);
                if (check) {  //controllo check per il movimento
                  if (King.controlCheck(start, new Position(arriveX, arriveY), board, turn)) {
                    Pawn pawn = (Pawn) piece;
                    board.setEmpty(arriveX + convert2, arriveY);
                    board.setPiece(end, pawn);
                    pawn.setPositionX(arriveX);
                    pawn.setPositionY(arriveY);
                    String extendedMove = Integer.toString(arriveX + convert2)
                         + Integer.toString(arriveY) + "-" + Integer.toString(arriveX)
                         + Integer.toString(arriveY);
                    board.setDoubleMove(extendedMove);
                    board.setStoryMove(stringInput);
                    isMove = true;
                  } else {
                    throw new IllegalArgumentException("Mossa illegale,"
                               + " il Re verrebbe messo sotto scacco.");
                  }
                }
              }
            }
          } else {
            throw new IllegalArgumentException("La casella risulta occupata da un altro pezzo.");
          }
          if (!isMove) {
            throw new IllegalArgumentException("Mossa non valida.");
          }
        } catch (ArrayIndexOutOfBoundsException e) {
          throw new IllegalArgumentException("Mossa non valida.");
        }
        break;
      case THREE: //cattura en passant
        enPassant(stringInput, board, turn, name);
        break;
      default:
        break;
    }
  }

  //____________________________________________________________________________________________
  /**
   * Metodo per la mossa en passant.
   * effettua la mossa en passant
   *
   * @param stringInput stringa in notazione algebrica
   * @param board scacchiera di gioco
   * @param turn turno in corso
   * @param name nome del pezzo da muovere
   */
  private static void enPassant(final String stringInput, final Board board, final
      boolean turn, final Character name) {
    Integer startY = ParserString.convertY(stringInput.substring(ZERO, ONE));
    Integer arriveY = ParserString.convertY(stringInput.substring(TWO, THREE));
    Integer arriveX = ParserString.convertX(stringInput.substring(THREE, FOUR));
    Integer startx; // riga di partenza per l'en passant
    Integer endx;   // riga di arrivo per l'en passant
    Boolean isCapture = false; //true= Ã¨ stato catturato un pedone
    if (turn) {
      startx = THREE;
      endx = TWO;
    } else {
      startx = FOUR;
      endx = FIVE;
    }
    if (arriveX.equals(endx)) {
      if (!board.isEmpty(startx, startY)) {
        Piece piece = board.getPiece(startx, startY); //controllo pedone in e.p
        if (piece.getName().equals(name)) {
          if (board.getDoubleMove() != null) {
            if (ParserString.controlEp(board.getDoubleMove(), arriveY, turn)) {
              if (King.controlCheck(new Position(startx, startY), new Position(arriveX, arriveY),
                     board, turn)) {
                Pawn pawn = (Pawn) piece; //aggiorno la posizione del pedone
                board.setEmpty(startx, startY);
                board.setPiece(new Position(arriveX, arriveY), pawn);
                pawn.setPositionX(arriveX);
                pawn.setPositionY(arriveY);
                if  (turn) {
                  board.setCaptureW(ZERO); //aggiungo il pedone catturato
                } else {
                  board.setCaptureB(ZERO);
                }
                board.setEmpty(startx, arriveY);
                board.setDoubleMove(null);
                board.setStoryMove(stringInput);
                isCapture = true;
              } else {
                throw new IllegalArgumentException("Mossa illegale, il Re verrebbe "
                         + "messo sotto scacco.");
              }
            }
          }
        }
      }
    }
    if (!isCapture) {
      throw new IllegalArgumentException("La casella d'arrivo risulta vuota, quindi "
               + "non c'e' nulla da catturare.");
    }
  }
  //____________________________________________________________________________________________

  /**
   * Metodo per muovere l'alfiere.
   * Prende in input la stringa in notazione algebrica, la scacchiera
   * e il turno e controlla se il movimento e' valido seguendo le regole
   * standard degli scacchi.
   *
   * @param stringInput stringa in notazione algebrica
   * @param board scacchiera di gioco
   * @param turn turno in corso
   * @exception IllegalArgumentException se il movimento non si puo' fare viene chiamata eccezione
  */

  public static void moveBishop(final String stringInput, final Board board, final Boolean turn) {
    Integer move = ParserString.analyzer(stringInput);
    Position start = null;
    Position arrive = null;
    if (move == TEN) {
      arrive = new Position(ParserString.convertX(stringInput.substring(THREE, FOUR)),
              ParserString.convertY(stringInput.substring(TWO, THREE)));
    } else if (move == ELEVEN) {
      arrive = new Position(ParserString.convertX(stringInput.substring(TWO, THREE)),
              ParserString.convertY(stringInput.substring(ONE, TWO)));
    }
    boolean free = false;

    if (move == TEN || move == ELEVEN) {
      ArrayList<Position> bishops = Bishop.findBishops(board, turn);
      if (bishops.size() == 0) {
        throw new IllegalArgumentException("Tutti i tuoi alfieri sono stati mangiati.");
      } else if (bishops.size() == 1) {
        start = bishops.get(0);
        if (start.equals(arrive)) {
          throw new IllegalArgumentException("Mossa non valida.");
        }
        free = CheckLegalMove.legalMoveBishop(start, arrive, board);
      } else {
        for (Position bish : bishops) {
          if (bish.equals(arrive)) {
            throw new IllegalArgumentException("Mossa non valida.");
          }
          if (CheckLegalMove.legalMoveBishop(bish, arrive, board)) {
            start = bish;
            free = true;
            break;
          }
        }
      }
    }

    switch (move) {
      case TEN:  //Cattura
        if (free) {
          if (!board.isEmpty(arrive.getPosX(), arrive.getPosY())) {
            if (board.getPieceColor(arrive.getPosX(), arrive.getPosY()).compareTo(turn) == 0) {
              if (King.controlCheck(start, arrive, board, turn)) {
                board.storeCaptures(turn, arrive);
                Bishop bishop = (Bishop) board.getPiece(start.getPosX(), start.getPosY());
                bishop.setPositionX(arrive.getPosX());
                bishop.setPositionY(arrive.getPosY());
                board.setEmpty(arrive.getPosX(), arrive.getPosY());
                board.setPiece(bishop.getPosition(), board.getPiece(start.getPosX(),
                        start.getPosY()));
                board.setEmpty(start.getPosX(), start.getPosY());
                board.setDoubleMove(null);
                board.setStoryMove(stringInput);
              } else {
                throw new IllegalArgumentException("Mossa illegale, il Re verrebbe "
                        + "messo sotto scacco.");
              }

            } else {
              throw new IllegalArgumentException("Il pezzo che vuoi catturare "
                      + "non e' dell'avversario.");
            }
          } else {
            throw new IllegalArgumentException("La casella di arrivo risulta vuota, "
                    + "quindi non c'e' nulla da catturare.");
          }
        } else {
          throw new IllegalArgumentException("La diagonale risulta non libera.");
        }
        break;

      case ELEVEN:   //Movimento
        if (free) {
          if (board.isEmpty(arrive.getPosX(), arrive.getPosY())) {
            if (King.controlCheck(start, arrive, board, turn)) {
              Bishop bishop = (Bishop) board.getPiece(start.getPosX(), start.getPosY());
              bishop.setPositionX(arrive.getPosX());
              bishop.setPositionY(arrive.getPosY());
              board.setEmpty(arrive.getPosX(), arrive.getPosY());
              board.setPiece(bishop.getPosition(), board.getPiece(start.getPosX(),
                      start.getPosY()));
              board.setEmpty(start.getPosX(), start.getPosY());
              board.setDoubleMove(null);
              board.setStoryMove(stringInput);
            } else {
              throw new IllegalArgumentException("Mossa illegale, il Re verrebbe "
                      + "messo sotto scacco.");
            }

          } else {
            throw new IllegalArgumentException("La casella di arrivo risulta "
                    + "occupata da un altro pezzo.");
          }
        } else {
          throw new IllegalArgumentException("La diagonale risulta non libera.");
        }
        break;

      default:
        throw new IllegalArgumentException("Mossa non valida");
    }
  }

  //____________________________________________________________________________________________

  /**
   * Metodo per muovere la regina.
   * Prende in input la stringa in notazione algebrica, la scacchiera
   * e il turno e controlla se il movimento e' valido seguendo le regole
   * standard degli scacchi.
   *
   * @param stringInput stringa in notazione algebrica
   * @param board scacchiera di gioco
   * @param turn turno in corso
   * @exception IllegalArgumentException se il movimento non si puo' fare viene chiamata eccezione
  */

  public static void moveQueen(final String stringInput, final Board board, final Boolean turn) {
    Position posQueen = new Position((Queen.findQueen(board, turn)).getPosX(),
        (Queen.findQueen(board, turn)).getPosY());    //Ricerca della regina
    Position movQueen;
    Integer move = ParserString.analyzer(stringInput);
    if (posQueen.getPosX() != null) {
      switch (move) {
        case TEN:        //Cattura
          movQueen = new Position(ParserString.convertX(stringInput.substring(THREE, FOUR)),
          ParserString.convertY(stringInput.substring(TWO, THREE)));
          if (!(posQueen.getPosX().equals(movQueen.getPosX())
              && posQueen.getPosY().equals(movQueen.getPosY()))) {
            if (!board.isEmpty(movQueen.getPosX(), movQueen.getPosY())) {
              if (board.getPieceColor(movQueen.getPosX(), movQueen.getPosY()).equals(turn)) {
                if (CheckLegalMove.legalMoveQueen(posQueen, movQueen, board)) {
                  if (King.controlCheck(posQueen, movQueen, board, turn)) {
                    board.storeCaptures(turn, movQueen);
                    Queen q1 = (Queen) board.getPiece(posQueen.getPosX(), posQueen.getPosY());
                    q1.setPositionX(movQueen.getPosX());
                    q1.setPositionY(movQueen.getPosY());
                    board.setEmpty(movQueen.getPosX(), movQueen.getPosY());
                    board.setPiece(q1.getPosition(), board.getPiece(posQueen.getPosX(),
                         posQueen.getPosY()));
                    board.setEmpty(posQueen.getPosX(), posQueen.getPosY());
                    board.setDoubleMove(null);
                    board.setStoryMove(stringInput);
                  } else {
                    throw new IllegalArgumentException("Mossa illegale, il Re verrebbe"
                           + " messo sotto scacco.");
                  }
                } else {
                  throw new IllegalArgumentException("La strada tra la posizione di partenza "
                         + "e quella di arrivo non e' vuota");
                }
              } else {
                throw new IllegalArgumentException("Il pezzo che vuoi catturare "
                       + "non e' dell'avversario");
              }
            } else {
              throw new IllegalArgumentException("La casella di arrivo risulta vuota, "
                     + "quindi non c'e' nulla da catturare");
            }
          } else {
            throw new IllegalArgumentException("Mossa non valida.");
          }
          break;

        case ELEVEN:        //Movimento
          movQueen = new Position(ParserString.convertX(stringInput.substring(TWO, THREE)),
          ParserString.convertY(stringInput.substring(ONE, TWO)));
          if (!(posQueen.getPosX().equals(movQueen.getPosX())
              && posQueen.getPosY().equals(movQueen.getPosY()))) {
            if (board.isEmpty(movQueen.getPosX(), movQueen.getPosY())) {
              if (CheckLegalMove.legalMoveQueen(posQueen, movQueen, board)) {
                if (King.controlCheck(posQueen, movQueen, board, turn)) {
                  Queen queen = (Queen) board.getPiece(posQueen.getPosX(), posQueen.getPosY());
                  queen.setPositionX(movQueen.getPosX());
                  queen.setPositionY(movQueen.getPosY());
                  board.setPiece(queen.getPosition(), queen);
                  board.setPiece(queen.getPosition(), board.getPiece(posQueen.getPosX(),
                        posQueen.getPosY()));
                  board.setEmpty(posQueen.getPosX(), posQueen.getPosY());
                  board.setDoubleMove(null);
                  board.setStoryMove(stringInput);
                } else {
                  throw new IllegalArgumentException("Mossa illegale, il Re verrebbe "
                         + "messo sotto scacco.");
                }
              } else {
                throw new IllegalArgumentException("La strada tra la posizione di partenza "
                       + "e quella di arrivo non e' vuota.");
              }
            } else {
              throw new IllegalArgumentException("La casella di arrivo risuta occupata "
                     + "da un altro pezzo.");
            }
          } else {
            throw new IllegalArgumentException("Mossa non valida.");
          }
          break;
        default:
          throw new IllegalArgumentException("Mossa non valida.");
      }
    } else {
      throw new IllegalArgumentException("La regina e' stata mangiata");
    }
  }

  //____________________________________________________________________________________________

  /**
   * Metodo per muovere la torre.
   * Prende in input la stringa in notazione algebrica, la scacchiera
   * e il turno e controlla se il movimento e' valido seguendo le regole
   * standard degli scacchi.
   *
   * @param stringInput stringa in notazione algebrica
   * @param board scacchiera di gioco
   * @param turn turno in corso
   * @exception IllegalArgumentException se il movimento non si puo' fare viene chiamata eccezione
  */

  public static void moveRook(final String stringInput, final Board board, final Boolean turn) {
    Boolean color;

    if (turn) {
      color = true;
    } else {
      color = false;
    }

    Integer move = ParserString.analyzer(stringInput);
    switch (move) {
      case TEN: //cattura
        Integer stepYC = ParserString.convertY(stringInput.substring(TWO, THREE));
        Integer stepXC = ParserString.convertX(stringInput.substring(THREE, FOUR));
        if (!board.isEmpty(stepXC, stepYC)) {
          if (board.getPieceColor(stepXC, stepYC).equals(color)) {
            Position pos = new Position(stepXC, stepYC);
            ArrayList<Position> actualp = Rook.findRooks(board, turn);
            ArrayList<Position> prook = new ArrayList<>();
            if (!actualp.isEmpty()) {
              for (Position rook : actualp) {
                if (CheckLegalMove.legalMoveRook(rook, pos, board)) {
                  prook.add(rook);
                }
              }
            } else {
              throw new IllegalArgumentException("Tutte le torri sono state mangiate");
            }

            if (prook.size() == 1) {

              Piece piece = board.getPiece(prook.get(0).getPosX(), prook.get(0).getPosY());
              Rook rook = (Rook) piece;
              if (King.controlCheck(new Position(rook.getPosition().getPosX(),
                  rook.getPosition().getPosY()), new Position(stepXC, stepYC), board, turn)) {
                board.setEmpty(rook.getPosition().getPosX(), rook.getPosition().getPosY());
                board.storeCaptures(turn, new Position(stepXC, stepYC));
                board.setEmpty(stepXC, stepYC);
                rook.setPositionX(stepXC);
                rook.setPositionY(stepYC);
                rook.setFirstStep(false);
                board.setPiece(new Position(stepXC, stepYC), rook);
                board.setDoubleMove(null);
                board.setStoryMove(stringInput);
              } else {
                throw new IllegalArgumentException("Mossa illegale, il Re verrebbe "
                       + "messo sotto scacco.");
              }


            } else {
              throw new IllegalArgumentException("Mossa non valida.");
            }
          } else {
            throw new IllegalArgumentException("Il pezzo che vuoi catturare "
                   + "non e' dell'avversario");
          }
        } else {
          throw new IllegalArgumentException("La casella d'arrivo e' vuota, quindi "
                 + "non c'e' nulla da catturare");
        }
        break;

      case ELEVEN: //movimento
        Integer stepYcm = ParserString.convertY(stringInput.substring(ONE, TWO));
        Integer stepXcm = ParserString.convertX(stringInput.substring(TWO, THREE));
        if (board.isEmpty(stepXcm, stepYcm)) {
          Position pos = new Position(stepXcm, stepYcm);
          ArrayList<Position> actualp = Rook.findRooks(board, turn);
          ArrayList<Position> prook = new ArrayList<>();
          if (!actualp.isEmpty()) {
            for (Position rook : actualp) {
              if (CheckLegalMove.legalMoveRook(rook, pos, board)) {
                prook.add(rook);
              }
            }
          } else {
            throw new IllegalArgumentException("Tutte le torri sono state mangiate");
          }
          if (prook.size() == 1) {
            Piece piece = board.getPiece(prook.get(0).getPosX(), prook.get(0).getPosY());
            Rook rook = (Rook) piece;
            if (King.controlCheck(new Position(rook.getPosition().getPosX(),
                rook.getPosition().getPosY()), new Position(stepXcm, stepYcm), board, turn)) {
              board.setEmpty(rook.getPosition().getPosX(), rook.getPosition().getPosY());
              rook.setPositionX(stepXcm);
              rook.setPositionY(stepYcm);
              rook.setFirstStep(false);
              board.setPiece(new Position(stepXcm, stepYcm), rook);
              board.setDoubleMove(null);
              board.setStoryMove(stringInput);
            } else {
              throw new IllegalArgumentException("Mossa illegale, il Re "
                     + "verrebbe messo sotto scacco.");
            }


          } else {
            throw new IllegalArgumentException("Mossa non valida.");
          }
        } else {
          throw new IllegalArgumentException("La casella d'arrivo risulta "
                 + "occupata da un altro pezzo.");
        }
        break;

      case TWELVE: //ambiguitÃ  movimento
      case THIRTEEN: //ambiguitÃ  cattura
        moveCaptureAmbigueRook(stringInput, board, turn, color, move);
        break;
      default:
        break;
    }
  }

  //______________________________________________________________________________________
  /**
   * Metodo per cattura e movimento abiguo della torre.
   * 
   * @param stringInput stringa in notazione algebrica
   * @param board scacchiera di gioco
   * @param turn turno in corso
   * @param color colore del pezzo da mangiare
   * @param move se 12 chiama il caso di cattura abigua, se 13 chiama movimento ambiguo
   */
  private static void moveCaptureAmbigueRook(final String stringInput, final Board board,
       final boolean turn, final boolean color, final int move) {
    Integer stepYA;
    Integer stepXA;
    if (move == TWELVE) {
      stepYA = ParserString.convertY(stringInput.substring(TWO, THREE));
      stepXA = ParserString.convertX(stringInput.substring(THREE, FOUR));
    } else {
      stepYA = ParserString.convertY(stringInput.substring(THREE, FOUR));
      stepXA = ParserString.convertX(stringInput.substring(FOUR, FIVE));
    }
    Integer equivocalx = -1;
    Integer equivocaly = -1;
    Boolean flag = false;
    try {
      equivocalx = Integer.parseInt(stringInput.substring(ONE, TWO));
      equivocalx = ParserString.convertX(stringInput.substring(ONE, TWO));
    } catch (NumberFormatException nfex) {
      equivocaly = ParserString.convertY(stringInput.substring(ONE, TWO));
    }
    ArrayList<Position> actualp = Rook.findRooks(board, turn);
    if (actualp.size() == 2) {
      Position rookp = new Position(-1, -1);
      Position pos = actualp.get(0);
      Position pos2 = actualp.get(1);
      if (pos.getPosX().equals(pos2.getPosX()) || pos.getPosY().equals(pos2.getPosY())) {
        if (pos.getPosX().equals(pos2.getPosX())) {
          if (pos.getPosY().equals(equivocaly)) {
            rookp.setPosY(pos.getPosY());
            rookp.setPosX(pos.getPosX());
          } else if (pos2.getPosY().equals(equivocaly)) {
            rookp.setPosY(pos2.getPosY());
            rookp.setPosX(pos2.getPosX());
          }
        } else {
          if (pos.getPosX().equals(equivocalx)) {
            rookp.setPosY(pos.getPosY());
            rookp.setPosX(pos.getPosX());
          } else if (pos2.getPosX().equals(equivocalx)) {
            rookp.setPosY(pos2.getPosY());
            rookp.setPosX(pos2.getPosX());
          }
        }
      } else if (pos.getPosX().equals(equivocalx) || pos.getPosY().equals(equivocaly)) {
        rookp.setPosY(pos.getPosY());
        rookp.setPosX(pos.getPosX());
      } else if (pos2.getPosX().equals(equivocalx) || pos2.getPosY().equals(equivocaly)) {
        rookp.setPosY(pos2.getPosY());
        rookp.setPosX(pos2.getPosX());
      }
      if (move == THIRTEEN) {
        if (!board.isEmpty(stepXA, stepYA)) {
          if (board.getPieceColor(stepXA, stepYA) == color) {
            Position position = new Position(stepXA, stepYA);
            if (CheckLegalMove.legalMoveRook(rookp, position, board)) {
              Piece piece = board.getPiece(rookp.getPosX(), rookp.getPosY());
              Rook rook = (Rook) piece;
              if (King.controlCheck(new Position(rook.getPosition().getPosX(),
                     rook.getPosition().getPosY()), new Position(stepXA, stepYA), board, turn)) {
                board.setEmpty(rook.getPosition().getPosX(), rook.getPosition().getPosY());
                board.storeCaptures(turn, new Position(stepXA, stepYA));
                board.setEmpty(stepXA, stepYA);
                board.setDoubleMove(null);
                board.setStoryMove(stringInput);
                rook.setPositionX(stepXA);
                rook.setPositionY(stepYA);
                rook.setFirstStep(false);
                board.setPiece(new Position(stepXA, stepYA), rook);
                flag = true;
              } else {
                throw new IllegalArgumentException("Mossa illegale, il Re verrebbe "
                         + "messo sotto scacco.");
              }
            }
          }
        }
      } else {
        if (board.isEmpty(stepXA, stepYA)) {
          Position position = new Position(stepXA, stepYA);
          if (CheckLegalMove.legalMoveRook(rookp, position, board)) {
            Piece piece = board.getPiece(rookp.getPosX(), rookp.getPosY());
            Rook rook1 = (Rook) piece;
            if (King.controlCheck(new Position(rook1.getPosition().getPosX(),
                      rook1.getPosition().getPosY()), new Position(stepXA, stepYA), board, turn)) {
              board.setEmpty(rook1.getPosition().getPosX(), rook1.getPosition().getPosY());
              board.setEmpty(stepXA, stepYA);
              board.setDoubleMove(null);
              board.setStoryMove(stringInput);
              rook1.setPositionX(stepXA);
              rook1.setPositionY(stepYA);
              rook1.setFirstStep(false);
              board.setPiece(new Position(stepXA, stepYA), rook1);
              flag = true;
            } else {
              throw new IllegalArgumentException("Mossa illegale, il Re "
                       + "verrebbe messo sotto scacco.");
            }
          }
        }
      }
    }
    if (!flag) {
      throw new IllegalArgumentException("Mossa non valida.");
    }
  }
  //______________________________________________________________________________________

  /**
   * Metodo per muovere il cavallo.
   * Prende in input la stringa in notazione algebrica, la scacchiera
   * e il turno e controlla se il movimento e' valido seguendo le regole
   * standard degli scacchi.
   *
   * @param stringInput stringa in notazione algebrica
   * @param board scacchiera di gioco
   * @param turn turno in corso
   * @exception IllegalArgumentException se il movimento non si puo' fare viene chiamata eccezione
  */

  public static void moveKnight(final String stringInput, final Board board, final Boolean turn) {
    Integer move = ParserString.analyzer(stringInput);
    Character pieceName = ' ';
    Boolean colour = null;
    if (turn) { // turno dei bianchi
      pieceName = 'C';
      colour = false;
    } else { // turno dei neri
      pieceName = 'c';
      colour = true;
    }
    switch (move) {
      case TEN:
      case ELEVEN: // movimento semplice cavallo
        Integer stepY = 0;
        Integer stepX = 0;
        ArrayList<Position> knightList;
        Integer[] posKnightone;
        Position firstKnightPosition = new Position(0, 0);
        if (stringInput.length() == THREE) {
          stepY = ParserString.convertY(stringInput.substring(ONE, TWO));
          stepX = ParserString.convertX(stringInput.substring(TWO, THREE));
        } else if (stringInput.length() == FOUR) {
          stepY = ParserString.convertY(stringInput.substring(TWO, THREE));
          stepX = ParserString.convertX(stringInput.substring(THREE, FOUR));
        }
        knightList = Knight.findKnight(turn, board, stepX, stepY, move, pieceName, stringInput);
        Position endPosition = new Position(stepX, stepY);
        if (knightList.size() == 2) { //se ho due cavalli nella lista
          if (CheckLegalMove.legalMoveKnight(knightList.get(0), endPosition)
              && CheckLegalMove.legalMoveKnight(knightList.get(1), endPosition)) {
            throw new IllegalArgumentException("Mossa non valida.");
          } else if (CheckLegalMove.legalMoveKnight(knightList.get(0), endPosition)) {
            posKnightone = Knight.validMove(stepX, stepY, knightList.get(0));
            firstKnightPosition = knightList.get(0);
          } else if (CheckLegalMove.legalMoveKnight(knightList.get(1), endPosition)) {
            posKnightone = Knight.validMove(stepX, stepY, knightList.get(1));
            firstKnightPosition = knightList.get(1);
          } else {
            //se non ho trovato cavalli genero un ecc
            throw new IllegalArgumentException("Mossa non valida.");
          }
        } else if (knightList.size() == 1) { // se ho trovato solo un cavallo
          if (CheckLegalMove.legalMoveKnight(knightList.get(0), endPosition)) {
            posKnightone = Knight.validMove(stepX, stepY, knightList.get(0));
            firstKnightPosition = knightList.get(0);
          } else {
            throw new IllegalArgumentException("Mossa non valida.");
          }
        } else {
          throw new IllegalArgumentException("Mossa non valida.");
        }
        Piece knight = board.getPiece(firstKnightPosition.getPosX(), firstKnightPosition.getPosY());
        Knight piece = (Knight) knight;
        if (stringInput.length() == THREE
            && board.isEmpty(stepX, stepY)) { // se la destinazione e' libera muovo
          if (King.controlCheck(piece.getPosition(),
                new Position(firstKnightPosition.getPosX() + posKnightone[0],
                     firstKnightPosition.getPosY() + posKnightone[1]), board, turn)) {
            piece.setPositionX(firstKnightPosition.getPosX() + posKnightone[0]);
            piece.setPositionY(firstKnightPosition.getPosY() + posKnightone[1]);
            board.setPiece(piece.getPosition(),
                board.getPiece(firstKnightPosition.getPosX(), firstKnightPosition.getPosY()));
            board.setEmpty(firstKnightPosition.getPosX(), firstKnightPosition.getPosY());
            board.setDoubleMove(null);
            board.setStoryMove(stringInput);
          } else {
            throw new IllegalArgumentException("Mossa illegale, il Re "
                   + "verrebbe messo sotto scacco.");
          }
        } else if (stringInput.length() == FOUR
             && !board.isEmpty(stepX, stepY)) { // se si vuole fare una cattura
          if (board.getPieceColor(stepX, stepY).compareTo(colour) != 0) {
            if (King.controlCheck(piece.getPosition(),
                    new Position(firstKnightPosition.getPosX() + posKnightone[0],
                            firstKnightPosition.getPosY() + posKnightone[1]), board, turn)) {
              board.storeCaptures(turn, new Position(stepX, stepY));
              piece.setPositionX(firstKnightPosition.getPosX() + posKnightone[0]);
              piece.setPositionY(firstKnightPosition.getPosY() + posKnightone[1]);
              board.setEmpty(stepX, stepY);
              board.setPiece(piece.getPosition(),
                  board.getPiece(firstKnightPosition.getPosX(), firstKnightPosition.getPosY()));
              board.setEmpty(firstKnightPosition.getPosX(), firstKnightPosition.getPosY());
              board.setDoubleMove(null);
              board.setStoryMove(stringInput);
            } else {
              throw new IllegalArgumentException("Mossa illegale, il Re verrebbe "
                     + "messo sotto scacco.");
            }
          } else {
            throw new IllegalArgumentException("Il pezzo che vuoi catturare "
                   + "non e' dell'avversario.");
          }
        } else {
          if (board.isEmpty(stepX, stepY)) {
            throw new IllegalArgumentException("La casella d'arrivo risulta vuota"
                   + ", quindi non c'e' nulla da catturare.");
          } else {
            throw new IllegalArgumentException("Mossa non valida.");
          }
        }
        break;
      case TWELVE:
      case THIRTEEN: // movimento conflitto cavallo
        moveCaptureAmbigueKnight(stringInput, board, turn, move, pieceName, colour);
        break;
      default:
    	  throw new IllegalArgumentException("Mossa non valida.");
    }
  }

  //______________________________________________________________________________________
  /**
   * Metodo per cattura e movimento abiguo della torre.
   * 
   * @param stringInput stringa in notazione algebrica
   * @param board board scacchiera di gioco
   * @param turn turno in corso
   * @param move se 12 chiama il caso di cattura abigua, se 13 chiama movimento ambiguo
   * @param pieceName nome del pezzo
   * @param colour colore del pezzo da mangiare
   */
  private static void moveCaptureAmbigueKnight(final String stringInput, final Board board,
       final Boolean turn, final int move, final Character pieceName, final Boolean colour) {
    Boolean isColumn = false;
    Integer columN = 0;
    Integer row = 0;
    Integer stepYC = 0;
    Integer stepXC = 0;
    Position firstKnightPositioN = new Position(0, 0);
    Integer[] posKnightonE = {0, 0};
    ArrayList<Position> knightListConf = new ArrayList<>();
    Position endPositionConf = new Position(0, 0);
    if (stringInput.length() == FOUR) {
      stepYC = ParserString.convertY(stringInput.substring(TWO, THREE));
      stepXC = ParserString.convertX(stringInput.substring(THREE, FOUR));
      endPositionConf.setPosX(stepXC);
      endPositionConf.setPosY(stepYC);
    } else if (stringInput.length() == FIVE) { //se lunga 5 => cattura con conflitto
      stepYC = ParserString.convertY(stringInput.substring(THREE, FOUR));
      stepXC = ParserString.convertX(stringInput.substring(FOUR, FIVE));
      endPositionConf.setPosX(stepXC);
      endPositionConf.setPosY(stepYC);
    }
    if (stringInput.substring(ONE, TWO).matches("[a-z]")) { // se e' una colonna
      columN = ParserString.convertY(stringInput.substring(ONE, TWO));
      isColumn = true;
    } else {
      row = ParserString.convertX(stringInput.substring(ONE, TWO));
    }
    if (isColumn) {
      if (stepYC != ZERO && stepYC != SEVEN) {
        if (columN + 1 == stepYC || columN - 1 == stepYC) {
          knightListConf = Knight.findKnight(turn, board, stepXC, stepYC, move,
                    pieceName, stringInput); // cerco i o il cavallo per colonne
        }
      }
    } else  { // caso in cui vengano indicate le righe anziche' la colonna
      if (stepXC != ZERO && stepXC != SEVEN) {
        if (row + 1 == stepXC || row - 1 == stepXC) {
          knightListConf = Knight.findKnight(turn, board, stepXC, stepYC, move,
                    pieceName, stringInput); // cerco il o i cavalli per righe
        }
      }
    }
    if (knightListConf.size() == TWO) {
      if (CheckLegalMove.legalMoveKnight(knightListConf.get(0), endPositionConf)
            && CheckLegalMove.legalMoveKnight(knightListConf.get(1), endPositionConf)) {
        if (isColumn) {
          if (knightListConf.get(0).getPosY()
                .equals(ParserString.convertY(stringInput.substring(1, 2)))) {
            posKnightonE = Knight.validMove(stepXC, stepYC, knightListConf.get(0));
            firstKnightPositioN = knightListConf.get(0);
          }
        } else {
          if (knightListConf.get(0).getPosX()
                .equals(ParserString.convertX(stringInput.substring(1, 2)))) {
            posKnightonE = Knight.validMove(stepXC, stepYC, knightListConf.get(0));
            firstKnightPositioN = knightListConf.get(0);
          }
        }
      } else {
        throw new IllegalArgumentException("Mossa non valida, non ci "
                 + "sono due cavalli in conflitto.");
      }
    } else {
      throw new IllegalArgumentException("Mossa non valida, non ci "
               + "sono due cavalli in conflitto.");
    }
    Piece knightConf = board.getPiece(firstKnightPositioN.getPosX(),
          firstKnightPositioN.getPosY());
    Knight pieceConf = (Knight) knightConf;
    if (stringInput.length() == FOUR && board.isEmpty(stepXC, stepYC)) {
      if (King.controlCheck(pieceConf.getPosition(),
           new Position(firstKnightPositioN.getPosX() + posKnightonE[ZERO],
              firstKnightPositioN.getPosY() + posKnightonE[ZERO]),
                 board, turn)) {
        pieceConf.setPositionX(firstKnightPositioN.getPosX() + posKnightonE[ZERO]);
        pieceConf.setPositionY(firstKnightPositioN.getPosY() + posKnightonE[ONE]);
        board.setPiece(pieceConf.getPosition(),
              board.getPiece(firstKnightPositioN.getPosX(), firstKnightPositioN.getPosY()));
        board.setEmpty(firstKnightPositioN.getPosX(), firstKnightPositioN.getPosY());
        board.setDoubleMove(null);
        board.setStoryMove(stringInput);
      } else {
        throw new IllegalArgumentException("Mossa illegale, il Re "
                 + "verrebbe messo sotto scacco.");
      }
    } else if (!board.isEmpty(stepXC, stepYC)) {
      if (board.getPieceColor(stepXC, stepYC).compareTo(colour) != 0) {
        if (King.controlCheck(pieceConf.getPosition(),
                new Position(firstKnightPositioN.getPosX() + posKnightonE[ZERO],
                        firstKnightPositioN.getPosY() + posKnightonE[ZERO]),
                           board, turn)) {
          board.storeCaptures(turn, new Position(stepXC, stepYC));
          pieceConf.setPositionX(firstKnightPositioN.getPosX() + posKnightonE[0]);
          pieceConf.setPositionY(firstKnightPositioN.getPosY() + posKnightonE[1]);
          board.setEmpty(stepXC, stepYC);
          board.setPiece(pieceConf.getPosition(),
                board.getPiece(firstKnightPositioN.getPosX(), firstKnightPositioN.getPosY()));
          board.setEmpty(firstKnightPositioN.getPosX(), firstKnightPositioN.getPosY());
          board.setDoubleMove(null);
          board.setStoryMove(stringInput);
        } else {
          throw new IllegalArgumentException("Mossa illegale, il Re "
                   + "verrebbe messo sotto scacco.");
        }
      } else {
        throw new IllegalArgumentException("Il pezzo che vuoi catturare"
                 + " non e' dell'avversario");
      }
    } else {
        throw new IllegalArgumentException("La casella d'arrivo risulta vuota, "
                 + "quindi non c'e' nulla da catturare");
    }
  }
  //______________________________________________________________________________________

  /**
   * Metodo per muovere il re.
   * Prende in input la stringa in notazione algebrica, la scacchiera
   * e il turno e controlla se il movimento e' valido seguendo le regole
   * standard degli scacchi.
   *
   * @param stringInput stringa in notazione algebrica
   * @param board scacchiera di gioco
   * @param turn turno in corso
   * @param actual posizione iniziale
   * @param step posizione finale
   * @param move tipo di movimento
   * @exception IllegalArgumentException se il movimento non si puo' fare viene chiamata eccezione
  */

  public static void captureMoveKing(final Board board, final Position actual, final Position step,
      final String stringInput, final Integer move, final Boolean turn) {
    if (move == TEN) { //cattura
      board.storeCaptures(turn, step);
      Piece king = board.getPiece(actual.getPosX(), actual.getPosY());
      King piece = (King) king;
      piece.setPositionX(step.getPosX());
      piece.setPositionY(step.getPosY());
      board.setEmpty(step.getPosX(), step.getPosY());
      piece.setFirstStep(false);
      board.setPiece(piece.getPosition(), board.getPiece(actual.getPosX(), actual.getPosY()));
      board.setEmpty(actual.getPosX(), actual.getPosY());
      board.setDoubleMove(null);
      board.setStoryMove(stringInput);
    } else if (move == ELEVEN) { //movimento
      Piece king = board.getPiece(actual.getPosX(), actual.getPosY());
      King piece = (King) king;
      piece.setPositionX(step.getPosX());
      piece.setPositionY(step.getPosY());
      piece.setFirstStep(false);
      board.setPiece(piece.getPosition(), board.getPiece(actual.getPosX(), actual.getPosY()));
      board.setEmpty(actual.getPosX(), actual.getPosY());
      board.setDoubleMove(null);
      board.setStoryMove(stringInput);
    }
  }

  //____________________________________________________________________________________________

  /**
   * Metodo per effettuare il movimento/cattura del re.
   * Prende in input la stringa in notazione algebrica, la scacchiera
   * e il turno e aggiorna la scacchiera con le nuove posizioni.
   *
   * @param stringInput stringa in notazione algebrica
   * @param board scacchiera di gioco
   * @param turn turno in corso
   * @exception IllegalArgumentException se il movimento non si puo' fare viene chiamata eccezione
  */

  public static void moveKing(final String stringInput, final Board board, final Boolean turn) {
    Integer move = ParserString.analyzer(stringInput);
    char type = '0'; // carattere necessario per far capire quale pezzo si sta ricercando
    if (turn) {
      type = 'R';
    } else {
      type = 'r';
    }
    switch (move) {
      case TEN: // caso di cattura
        Integer stepYC = ParserString.convertY(stringInput.substring(TWO, THREE));
        Integer stepXC = ParserString.convertX(stringInput.substring(THREE, FOUR));
        if ((!board.isEmpty(stepXC, stepYC)
              && board.getPieceColor(stepXC, stepYC))) {
          Position step = new Position(stepXC, stepYC);
          Position actual = King.findPosition(stepXC, stepYC, board, type);
          if (CheckLegalMove.legalKing(step, turn, board)) {
            Move.captureMoveKing(board, actual, step, stringInput, move, turn);
          } else {
            throw new IllegalArgumentException("Mossa non valida, il "
                   + "re potrebbe essere mangiato");
          }
        } else {
          throw new IllegalArgumentException("Mossa non valida.");
        }
        break;
      case ELEVEN: // caso di  movimento semplice
        Integer stepYcM = ParserString.convertY(stringInput.substring(ONE, TWO));
        Integer stepXcM = ParserString.convertX(stringInput.substring(TWO, THREE));
        if (board.isEmpty(stepXcM, stepYcM)) { //controllo se destinazione e' vuota
          Position step = new Position(stepXcM, stepYcM);
          Position actual = King.findPosition(stepXcM, stepYcM, board, type);
          if (CheckLegalMove.legalKing(step, turn, board)) {
            Move.captureMoveKing(board, actual, step, stringInput, move, turn);
          } else {
            throw new IllegalArgumentException("Mossa non valida, il re"
                   + " potrebbe essere mangiato");
          }
        } else {
          throw new IllegalArgumentException("Mossa non valida.");
        }
        break;
      default:
        throw new IllegalArgumentException("Mossa non valida.");
    }
  }

  //____________________________________________________________________________________________

  /**
   * Metodo per muovere effettuare arrocco corto/lungo.
   * Prende in input la stringa in notazione algebrica, la scacchiera
   * e il turno e controlla se si puo' effettuare l'arrcco desiderato.
   *
   * @param stringInput stringa in notazione algebrica
   * @param board scacchiera di gioco
   * @param turn turno in corso
   * @exception IllegalArgumentException se il movimento non si puo' fare viene chiamata eccezione
  */

  public static void moveCastling(final String stringInput, final Board board, final Boolean turn) {
    Integer x; // riga del re
    Character nameKing; // serve a verificare se il pezzo preso è un re
    Character nameRook; // serve a verificare se il pezzo preso è una torrre
    Boolean castling = false;
    Boolean check = false; // ture= re sotto scacco
    Position positionA = new Position(0, 0); //posizione da controllare per effettuare l'arrocco
    Position positionB = new Position(0, 0); //posizione da controllare per effettuare l'arrocco

    if (turn) { // turno del bianco
      x = SEVEN; // ci interessa solo la riga del re
      nameKing = 'R';
      nameRook = 'T';
    } else { // turno del nero
      x = 0;
      nameKing = 'r';
      nameRook = 't';
    }
    Position positionRook = new Position(0, 0); //posizione della torre con cui si vuole arroccare
    positionA.setPosX(x); //la x in entrambi gli arrocchi non cambia
    positionB.setPosX(x);
    positionRook.setPosX(x);
    Integer y = FOUR; //colonna del re
    Integer move = ParserString.analyzer(stringInput);
    if (move == FOURTEEN) { //arrocco corto
      positionA.setPosY(FIVE);
      positionB.setPosY(SIX);
      positionRook.setPosY(SEVEN);
    } else {
      positionA.setPosY(THREE);
      positionB.setPosY(TWO);
      positionRook.setPosY(ZERO);
    }
    if (!board.isEmpty(x, y)
        && board.getPieceName(x, y).equals(nameKing)) { // controllo che nella posizione del re

      Piece pieceK = board.getPiece(x, y);
      King king = (King) pieceK;

      if (king.getFirstStep()) { // controllo che sia la prima mossa del re
        check = CheckLegalMove.legalKing(new Position(x, y), turn, board);
        if (check) { //controllo se il re è sotto scacco
          if (!board.isEmpty(positionRook.getPosX(), positionRook.getPosY())
              && board.getPieceName(positionRook.getPosX(),
              positionRook.getPosY()).equals(nameRook)) {
            Piece pieceT = board.getPiece(positionRook.getPosX(), positionRook.getPosY());
            Rook rook = (Rook) pieceT;
            if (rook.getFirstStep()) { // se non si è mossa si può arroccare
              if (board.isEmpty(positionA.getPosX(), positionA.getPosY())
                  && board.isEmpty(positionB.getPosX(), positionB.getPosY())) {
                //controllo assenza di pezzi
                castling = CheckLegalMove.legalKing(positionA, turn, board);
                if (castling) {
                  castling = CheckLegalMove.legalKing(positionB, turn, board);
                }
                if (castling) {  // se tutte le condizioni sono state rispettate effettua l'arrocco
                  board.setEmpty(king.getPosition().getPosX(), king.getPosition().getPosY());
                  board.setEmpty(rook.getPosition().getPosX(), rook.getPosition().getPosY());
                  king.setFirstStep(false);
                  rook.setFirstStep(false);
                  board.setPiece(positionB, king);
                  board.setPiece(positionA, rook);
                  board.setDoubleMove(null);
                  board.setStoryMove(stringInput);
                  king.setPositionX(positionB.getPosX());
                  king.setPositionY(positionB.getPosY());
                  rook.setPositionX(positionA.getPosX());
                  rook.setPositionY(positionA.getPosY());
                } else {
                  throw new IllegalArgumentException("Impossibile arroccare, "
                         + "un pezzo minaccia la strada del re.");
                }
              } else {
                throw new IllegalArgumentException("Impossibile arroccare.");
              }
            } else {
              throw new IllegalArgumentException("Impossibile arroccare, la "
                     + "torre e' stata gia' mossa.");
            }
          } else {
            throw new IllegalArgumentException("Impossibile arroccare.");
          }
        } else {
          throw new IllegalArgumentException("Impossibile arroccare, il re e' sotto scacco.");
        }
      } else {
        throw new IllegalArgumentException("Impossibile arroccare, il re e' stato gia' mosso.");
      }
    } else {
      throw new IllegalArgumentException("Impossibile arroccare.");
    }
  }
}
