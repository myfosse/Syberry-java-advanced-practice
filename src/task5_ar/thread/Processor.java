package task5_ar.thread;

/** @author Andrey Egorov */
@Repeat(repeat=3)
public class Processor implements Runnable {

  private static final String LOG_MESSAGE = "The Processor class is running...";

  private final String message;

  public Processor(final String message) {
    this.message = message;
  }

  @Override
  public void run() {
    System.out.println(LOG_MESSAGE);
  }
}
