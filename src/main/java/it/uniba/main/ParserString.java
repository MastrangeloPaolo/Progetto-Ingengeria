package it.uniba.main;

/**
 *Class name: ParserString
 *Class type: No ECB
 *Responsibilities
 *Knows:
 * Conosce la struttura delle stringhe riguardanti i possibili comandi.
 *Does:
 * Analizza le stringhe passate in input e, in base alle espressioni regolari,
 * restituisce un valore intero corrispondente ai vari comandi.
 */

public final class ParserString  {
  private static String expRegcatturaEP = "^[a-h][x][a-h][1-8](e.p.)$";
  private static String expRegmovimento = "^[a-h][1-8]$";
  private static String expRegcattura = "^[a-h][x][a-h][1-8]$";
  private static String expRegcatturapezzi = "^[ACDRT][x][a-h][1-8]$";
  private static String expRegmovimentopezzi = "^[ACDRT][a-h][1-8]$";
  private static String expRegmovimentopezziAm = "^[CT][1-8|a-h][a-h][1-8]$";
  private static String expRegcatturapezziAm = "^[CT][1-8|a-h][x][a-h][1-8]$";
  private static final int ZERO = 0;
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
  private static final int MAXLUNG = 5;

  /**
   * Costruttore classe ParserString.
   */

  private ParserString() {
    //non chiamato
  }

  //________________________________________________________________________

  /**
   * Metodo per analizzare la stringa in notazione algebrica/scelta.
   * Prende in input la stringa in notazione algebrica/scelta e attraverso
   * espressioni regolari indica la tipologia di azione che si desidera
   * effettuare
   *
   * @param input stringa in notazione algebrica/opzione
   * @return azione da eseguire
  */

  public static Integer analyzer(final String input) {
    int valReturn = ZERO;

    if (controlStringcapt(input)) { //cattura classica
      valReturn = ONE;
    } else if (controlStringmov(input)) { // movimento
      valReturn = TWO;
    } else if (controlStringcaptEP(input)) { //cattura ep
      valReturn = THREE;
    } else if (input.compareTo("help") == 0) {
      valReturn = FOUR;
    } else if (input.compareTo("quit") == 0) {
      valReturn = FIVE;
    } else if (input.compareTo("moves") == 0) {
      valReturn = SIX;
    } else if (input.compareTo("captures") == 0) {
      valReturn = SEVEN;
    } else if (input.compareTo("board") == 0) {
      valReturn = EIGHT;
    } else if (input.compareTo("play") == 0) {
      valReturn = NINE;
    } else if (controlStringcaptPez(input)) {
      valReturn = TEN;
    } else if (controlStringmovPez(input)) {
      valReturn = ELEVEN;
    } else if (controlStringmovPezAm(input)) {
      valReturn = TWELVE;
    } else if (controlStringcatPezAm(input)) {
      valReturn = THIRTEEN;
    } else if (input.compareTo("0-0") == 0
          || input.compareTo("o-o") == 0 || input.compareTo("O-O") == 0) {
      valReturn = FOURTEEN;
    } else if (input.compareTo("0-0-0") == 0
          || input.compareTo("o-o-o") == 0 || input.compareTo("O-O-O") == 0) {
      valReturn = FIFTEEN;
    }
    return valReturn;
  }

  //__________________________________________________________________________________________
  public static Boolean controlStringcapt(final String string) {
    return string.matches(expRegcattura);
  }

  //__________________________________________________________________________________________
  public static Boolean controlStringmov(final String string) {
    return string.matches(expRegmovimento);
  }

  //__________________________________________________________________________________________
  public static Boolean controlStringcaptEP(final String string) {
    return string.matches(expRegcatturaEP);
  }

  //__________________________________________________________________________________________
  public static Boolean controlStringcaptPez(final String string) {
    return string.matches(expRegcatturapezzi);
  }

  //__________________________________________________________________________________________
  public static Boolean controlStringmovPez(final String string) {
    return string.matches(expRegmovimentopezzi);
  }

  //__________________________________________________________________________________________
  public static Boolean controlStringmovPezAm(final String string) {
    return string.matches(expRegmovimentopezziAm);
  }

  //__________________________________________________________________________________________
  public static Boolean controlStringcatPezAm(final String string) {
    return string.matches(expRegcatturapezziAm);
  }

  //_____________________________________________________________________________________________

  /**
   * Metodo convertire la x letterare in x numerica.
   * Prende in input la x e restituisce l'equivalente
   * numerico
   *
   * @param posX colonna da convertire
   * @return restituisce la y
  */

  public static Integer convertY(final String posX) {
    Integer row = ZERO;

    switch (posX) {

      case "a": row = ZERO;
      break;
      case "b": row = ONE;
      break;
      case "c": row = TWO;
      break;
      case "d": row = THREE;
      break;
      case "e": row = FOUR;
      break;
      case "f": row = FIVE;
      break;
      case "g": row = SIX;
      break;
      case "h": row = SEVEN;
      break;
      default: System.out.println("errore");
      break;
    }
    return row;
  }

  //_____________________________________________________________________________________________

  /**
   * Metodo invertire la y.
   * Prende in input la y e restituisce l'equivalente invertito
   * per leggere la matrice che rappresenta la scacchiera nel modo corretto
   * numerico
   *
   * @param posY colonna da convertire
   * @return restituisce la x
  */

  public static Integer convertX(final String posY) {
    Integer line = ZERO;

    switch (posY) {
      case "1": line = SEVEN;
      break;
      case "2": line = SIX;
      break;
      case "3": line = FIVE;
      break;
      case "4": line = FOUR;
      break;
      case "5": line = THREE;
      break;
      case "6": line = TWO;
      break;
      case "7": line = ONE;
      break;
      case "8": line = ZERO;
      break;
      default: System.out.println("errore");
      break;
    }
    return line;
  }

  //____________________________________________________________________________

  /**
   * Metodo per controllare se la cattura en passant e' valida.
   * Controlla se la stringa e' di una cattura en passant e controlla
   * se e' valida
   *
   * @param move colonna da convertire
   * @param y la riga del movimento
   * @param turn turno in corso
   * @return true se la cattura e' valida, altrimenti false
  */

  public static Boolean controlEp(final String move, final Integer y, final boolean turn) {

    Boolean control = false;   //true se la mossa precedente e' stata muovere il pedone su y+2


    if (move.length() == MAXLUNG) {
      Integer startX = Integer.parseInt(move.substring(ZERO, ONE));
      Integer startY = Integer.parseInt(move.substring(ONE, TWO));
      Integer endX = Integer.parseInt(move.substring(THREE, FOUR));
      if (startY.equals(y)) {
        if (turn) { // se e' il turno dei bianchi controllo il pedone nero
          if (endX - startX == 2) {
            control = true;
          }
        } else {
          if (startX - endX == 2) {
            control = true;
          }

        }
      }
    }
    return control;
  }
}
