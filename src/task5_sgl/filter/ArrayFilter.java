package task5_sgl.filter;

import java.util.Arrays;
import java.util.function.Predicate;

/** @author Andrey Egorov */
public class ArrayFilter {

  private static volatile ArrayFilter instance;

  private ArrayFilter() {}

  public static ArrayFilter getInstance() {
    if (instance == null) {
      synchronized (ArrayFilter.class) {
        if (instance == null) {
          instance = new ArrayFilter();
        }
      }
    }
    return instance;
  }

  public static <T> Object[] filter(Object[] target, Predicate<Object> predicate) {
    return Arrays.stream(target).filter(predicate).toArray(Object[]::new);
  }
}
