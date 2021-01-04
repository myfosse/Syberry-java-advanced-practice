package task3_op.builder;

/** @author Andrey Egorov */
public class AppendString implements Observer {
  @Override
  public void update(final String appendString) {
    System.out.println("The observable StringBuilder has been changed: " + appendString);
  }
}
