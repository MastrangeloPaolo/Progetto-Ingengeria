package it.uniba.main;

import java.util.Scanner;

/**
 *Class name: Play
 *Class type: Boundary
 *Responsibilities
 *Knows:
 *Conosce il turno della partita.
 *Does:
 *Gestisce la partita in corso richiamando i metodi necessari in base alle richieste dell'utente.
 */

public final class Play {
  private static Boolean turn = false;
  private static final int MAXTURN = 200;
  private static final int ONE = 1;
  private static final int TWO = 2;
  private static final int THREE = 3;
  private static final int FOUR = 4;
  private static final int FIVE = 5;
  private static final int SIX = 6;
  private static final int SEVEN = 7;
  private static final int EIGHT = 8;
  private static final int NINE = 9;
  private static final int TEN = 10;
  private static final int ELEVEN = 11;
  private static final int TWELVE = 12;
  private static final int THIRTEEN = 13;
  private static final int FIFTEEN = 15;
  private static final int FOURTEEN = 14;

  /**
   *Costruttore classe Play.
   */

  private Play() {
    //non chiamato
  }

  /**
   * Metodo per gestire la partita.
   * Chiede una stringa in input e la analizza
   * per capire che fare
   *
   * @exception IllegalArgumentException se il movimento non si puo' fare viene chiamata eccezione
  */

  public static void play() {
    Scanner scan = new Scanner(System.in, "utf-8");
    Integer k = 0;
    Board board = new Board();
    Boolean flag = true;
    board.fillBoard();

    do {
      if (k % 2 == 0) {
        turn = true;  // se k e' pari allora il turno e' di true
      } else {
        turn = false;
      }
      do {
        try {
          flag = true;
          if (turn) {
            System.out.println("(B) Inserire la mossa/opzione:\t");
          } else {
            System.out.println("(N) Inserire la mossa/opzione:\t");
          }
          String moveOpt = scan.nextLine();
          moveOpt = moveOpt.replace(" ", "");

          switch (ParserString.analyzer(moveOpt)) {
            case ONE:
            case TWO:
            case THREE:
              moveOpt = moveOpt.toLowerCase();
              Move.movePawn(moveOpt, board, turn);
              board.setFirstTurn(false);
              break;

            case FOUR:
              //help
              Command.help();
              flag = false;
              break;

            case FIVE:
              //quit
              Command.quit();
              flag = false;
              break;

            case SIX:
              //moves
              Command.printMoves(turn, board);
              System.out.println("");
              flag = false;
              break;

            case SEVEN:
              //captures
              Command.printCapture(board);
              flag = false;
              break;

            case EIGHT:
              //chessboard_display
              Command.chessboardDisplay(board);
              flag = false;
              break;

            case NINE:
              //play
              Command.play();
              flag  = false;
              break;

            case TEN:
            case ELEVEN:
            case TWELVE:
            case THIRTEEN:
              //Movement and capture of all the pieces but pawn
              switch (moveOpt.charAt(0)) {
                case 'A': //Alfiere
                  Move.moveBishop(moveOpt, board, turn);
                  break;

                case 'C': //Cavallo
                  Move.moveKnight(moveOpt, board, turn);
                  break;

                case 'D': //Donna
                  Move.moveQueen(moveOpt, board, turn);
                  break;

                case 'R': //Re
                  Move.moveKing(moveOpt, board, turn);
                  break;

                case 'T': //Torre
                  Move.moveRook(moveOpt, board, turn);
                  break;
                default:
                  break;
              }
              board.setFirstTurn(false);
              break;

            case FOURTEEN:
            case FIFTEEN:
              Move.moveCastling(moveOpt, board, turn);
              board.setFirstTurn(false);
              break;

            default:
              flag = false;
              System.out.println("\nComando inserito errato, i comandi possibili sono:");
              System.out.println("\t-Inserire una mossa valida");
              System.out.println("\t-help");
              System.out.println("\t-quit");
              System.out.println("\t-moves");
              System.out.println("\t-captures");
              System.out.println("\t-board");
          }
        } catch (IllegalArgumentException exception) {
          System.out.println(exception.getLocalizedMessage());
          System.out.println("Prego reinserire...");
          flag = false;
        }
      } while (!flag);
      k++;
      System.out.println("------------------------------------------------------------");
    } while (k < MAXTURN);  //200 turni per prova poiche' scacco matto non e' implementato
    scan.close();
  }
}
