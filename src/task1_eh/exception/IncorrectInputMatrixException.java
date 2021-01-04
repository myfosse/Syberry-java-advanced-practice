package task1_eh.exception;

/** @author Andrey Egorov */
public class IncorrectInputMatrixException extends Exception {

  public IncorrectInputMatrixException() {}

  public IncorrectInputMatrixException(final String message) {
    super(message);
  }

  public IncorrectInputMatrixException(final Throwable err) {
    super(err);
  }

  public IncorrectInputMatrixException(final String message, final Throwable err) {
    super(message, err);
  }
}
