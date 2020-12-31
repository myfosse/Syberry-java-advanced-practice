package task1.exception;

/** @author Andrey Egorov */
public class IncorrectInputMatrixException extends Exception {

  public IncorrectInputMatrixException() {}

  public IncorrectInputMatrixException(String message) {
    super(message);
  }

  public IncorrectInputMatrixException(Throwable err) {
    super(err);
  }

  public IncorrectInputMatrixException(String message, Throwable err) {
    super(message, err);
  }
}
