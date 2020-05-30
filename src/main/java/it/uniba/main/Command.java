package it.uniba.main;

import java.util.Scanner;

/**
 *Class name: Command
 *Class type: Boundary
 *Responsibilities
 *Knows:
 *Conosce la lista di tutti i possibili comandi.
 *Does:
 *Permette di iniziare una nuova partita.
 *Durante una partita, permette di cominciarne una nuova.
 *Permette di uscire da una partita in corso.
 *Permette di visualizzare la lista dei possibili comandi.
 *Permette di visualizzare la scacchiera.
 *Permette di stampare lo storico delle mosse.
 *Permette di stampare lo storico delle catture.
 */

public final class Command {
  private static final int CHESSBOARDL = 8;
  private static final int CAPTURE0 = 0;
  private static final int CAPTURE1 = 1;
  private static final int CAPTURE2 = 2;
  private static final int CAPTURE3 = 3;
  private static final int CAPTURE4 = 4;
  private static final int CAPTURE5 = 5;

  //____________________________________________________________________________________________
  /**
   * Costruttore classe command.
   * non richiamto
   */
  private Command() {
    //non richiamato
  }
  //____________________________________________________________________________________________
  /**
   * Metodo per ricominciare la partita resettando tutto.
   */

  public static void play() {
    Scanner keyboard = new Scanner(System.in, "utf-8");
    boolean flag = false;                // flag per la fine del ciclo (true se reply e' accettato)
    String reply;                        // variabile che contiene la risposta

    System.out.println("Confermare di voler ricominciare la partita: Si/No");
    do {                                 //cicla fin quando non viene scritto o si o no
      reply = keyboard.nextLine();
      reply = reply.replace("\n", " ");

      if (reply.equalsIgnoreCase("si")) {               // comando per ignorare il case sensitive
        System.out.println("Il gioco e'ricominciato, inserire prima mossa della partita:");
        Play.play();
        keyboard.close();
      }
      if (reply.equalsIgnoreCase("no")) {
        System.out.println("Gioco ripreso");
        flag = true;
      }
      if (!flag) {
        System.out.println("La risposta non e' stata riconosciuta, digitare o si o no");
      }
    } while (!flag);
  }

  //____________________________________________________________________________________________

  /**
   * Metodo per stampare tutti i comandi possibili.
   */

  public static void help() {
    System.out.println("I COMANDI POSSIBILI SONO I SEGUENTI: ");
    System.out.println("\t -help");
    System.out.println("\t -play");
    System.out.println("\t -board");
    System.out.println("\t -moves");
    System.out.println("\t -captures");
    System.out.println("\t -quit");
    System.out.println(" ");
  }

  //____________________________________________________________________________________________

  /**
   * Metodo per uscire dal gioco.
   */

  public static void quit() {
    Scanner keyboard = new Scanner(System.in, "utf-8");
    boolean flag = false;              // flag per la fine del ciclo (true se reply e' accettato)
    String reply;                            // variabile che contiene la risposta

    System.out.println("Confermare di voler uscire: Si/No");
    do {                                      //cicla fin quando non viene scritto o si o no
      reply = keyboard.nextLine();
      reply = reply.replace("\n", " ");

      if (reply.equalsIgnoreCase("si")) {               // comando per ignorare il case sensitive
        System.out.println("GRAZIE DI AVER USATO SCACCHI....");
        keyboard.close();
        System.exit(0);
      }
      if (reply.equalsIgnoreCase("no")) {
        System.out.println("Gioco ripreso \n");
        flag = true;
      }
      if (!(flag)) {
        System.out.println("La risposta non e' stata riconosciuta, digitare o si o no");
      }
    } while (!(flag));
  }

  //____________________________________________________________________________________________

  /**
   * Metodo per visualizzare la scacchiera.
   *
   * @param board scacchiera di gioco
   */

  public static void chessboardDisplay(final Board board) {

    String ansiBlackBackground = "\u001B[107m";
    String ansiRedBackground = "\u001B[105m";
    String ansiNormal = "\u001B[00m";
    String textBord = "\033[38;5;0m";
    char[] rook = {'\u2656', '\u265C'};
    char[] knight = {'\u2658', '\u265E'};
    char[] bishop = {'\u2657', '\u265D'};
    char[] queen = {'\u2655', '\u265B'};
    char[] king = {'\u2654', '\u265A'};
    char[] pawn = {'\u2659',  '\u265F'};

    Integer i = 0;
    Integer j;
    System.out.println("");
    System.out.println("      A  B  C  D  E  F  G  H ");
    while (i >= 0 && i < CHESSBOARDL) {
      System.out.print(ansiNormal + "  " + (CHESSBOARDL - i) + "  ");
      j = 0;
      while (j >= 0 && j < CHESSBOARDL) {
        if (board.isEmpty(i, j)) {
          if ((i + j) % 2 != 0) {
            System.out.print(ansiBlackBackground + "   ");
          } else {
            System.out.print(ansiRedBackground + "   ");
          }
        } else {
          if ((i + j) % 2 != 0) {
            System.out.print(ansiBlackBackground + " ");
          } else {
            System.out.print(ansiRedBackground + " ");
          }
          switch (board.getPieceName(i, j)) {
            case 'R':
              System.out.print(textBord + king[0  ] + " ");
              break;
            case 'r':
              System.out.print(textBord + king[1 ] + " ");
              break;
            case 'D':
              System.out.print(textBord + queen[0] +  " ");
              break;
            case 'd':
              System.out.print(textBord + queen[1] + " ");
              break;
            case 'T':
              System.out.print(textBord + rook[0] + " ");
              break;
            case 't':
              System.out.print(textBord + rook[1] + " ");
              break;
            case 'A':
              System.out.print(textBord + bishop[0] + " ");
              break;
            case 'a':
              System.out.print(textBord + bishop[1] + " ");
              break;
            case 'C':
              System.out.print(textBord + knight[0] + " ");
              break;
            case 'c':
              System.out.print(textBord + knight[1] + " ");
              break;
            case 'P':
              System.out.print(textBord + pawn[0] + " ");
              break;
            case 'p':
              System.out.print(textBord + pawn[1] + " ");
              break;
            default:
              break;
          }
        }
        j++;
      }
      System.out.println(ansiNormal + "  " + (CHESSBOARDL - i));
      i++;
    }

    System.out.println("      A  B  C  D  E  F  G  H ");
    System.out.println("");

  }

  //____________________________________________________________________________________________

  /**
   * Metodo per stampare lo storico mosse.
   *
   * @param turn turno in corso
   * @param board scacchiera di gioco
   */

  public static void printMoves(final boolean turn, final Board board) {
    int j = 1;

    if (board.getFirstTurn()) {
      System.out.println("E' il primo turno non ci sono mosse");
    } else {
      if (!turn) {
        if (board.getTotalStory().size() == 1) {
          System.out.println("1." + board.getTotalStory().get(0));
        } else {
          for (int i = 0; i < board.getTotalStory().size(); i++) {
            if (board.getTotalStory().size() - 1 != i) {
              System.out.println(j + "." + board.getTotalStory().get(i)
                  + " " + board.getTotalStory().get(i + 1));
              i++;
            } else {
              System.out.println(j + "." + board.getTotalStory().get(i));
              i++;
            }
            j++;
          }
        }
      } else {
        for (int i = 1; i < board.getTotalStory().size(); i++) {
          System.out.println(j + "." + board.getTotalStory().get(i - 1) + " "
              + board.getTotalStory().get(i));
          i++;
          j++;
        }
      }
    }
  }

  //_____________________________________________________________________________________

  /**
   * Metodo per stampare le catture effettuate durante la partita in corso.
   *
   * @param board scacchiera di gioco
   */

  public static void printCapture(final Board board) {                         //stampa catture
    System.out.print("\nIL BIANCO HA CATTURATO\n");
    System.out.print("\t-PEDONE:" + board.getCapture(CAPTURE0, true) + "\n");
    System.out.print("\t-TORRE:" + board.getCapture(CAPTURE1, true) + "\n");
    System.out.print("\t-CAVALLO:" + board.getCapture(CAPTURE2, true) + "\n");
    System.out.print("\t-ALFIERE:" + board.getCapture(CAPTURE3, true) + "\n");
    System.out.print("\t-DONNA:" + board.getCapture(CAPTURE4, true) + "\n");
    System.out.print("\t-RE:" + board.getCapture(CAPTURE5, true) + "\n");

    System.out.print("IL NERO HA CATTURATO\n");
    System.out.print("\t-PEDONE:" + board.getCapture(CAPTURE0, false) + "\n");
    System.out.print("\t-TORRE:" + board.getCapture(CAPTURE1, false) + "\n");
    System.out.print("\t-CAVALLO:" + board.getCapture(CAPTURE2, false) + "\n");
    System.out.print("\t-ALFIERE:" + board.getCapture(CAPTURE3, false) + "\n");
    System.out.print("\t-DONNA:" + board.getCapture(CAPTURE4, false) + "\n");
    System.out.print("\t-RE:" + board.getCapture(CAPTURE5, false) + "\n\n");
  }
}
