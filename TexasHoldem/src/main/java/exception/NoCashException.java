package exception;

public class NoCashException extends Exception {
  private static final long serialVersionUID = -1444473325340705049L;

  public NoCashException() {
    super("Sorry, you don't have enough funds to make this bet");
  }

}
