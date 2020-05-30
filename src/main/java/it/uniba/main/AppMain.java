package it.uniba.main;

import java.util.Scanner;


/**
 *Class name: AppMain
 *Class type: Boundary
 *Responsibilities
 *Knows:
 *Does:
 *Gestisce il menu' iniziale attraverso le interazioni con l'utente.
 */

public final class AppMain {
  /**
   ** This is the main entry of the application.
   *
   * @param args The command-line arguments.
   */

  private AppMain() {
  //non chiamato
  }

  /**
  ** This is the main entry of the application.
  *
  * @param args The command-line arguments.
  */

  public static void main(final String[] args) {

    Scanner select = new Scanner(System.in, "utf-8");


    System.out.println("Inserire cosa si vuole fare, le opzioni sono:");
    System.out.println("\t-play");
    System.out.println("\t-help");
    System.out.println("\t-quit");
    boolean flag = false;
    do {
      String option = select.next();
      option = option.toLowerCase();
      switch (option) {
        case "play":
          Play.play();
          flag = true;
          break;

        case "help":
          Command.help();
          flag = false;
          break;

        case "quit":
          Command.quit();
          System.out.println("Inserire un comando:\n");
          flag = false;
          break;

        default:
          flag = false;
          System.out.println("Comando inserito errato, i comandi possibili sono:");
          System.out.println("\t-play");
          System.out.println("\t-help");
          System.out.println("\t-quit");
          System.out.println("");
          break;
      }
    } while (!flag);
    select.close();
  }
}


