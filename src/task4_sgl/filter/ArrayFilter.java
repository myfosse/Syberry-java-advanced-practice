package task4_sgl.filter;

import java.util.ArrayList;
import java.util.Collection;
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

  public static Object[] filter(Object[] target, IPredicate<Object> predicate) {

    Collection<Object> result = new ArrayList<>();
    for (Object element: target) {
      if (predicate.apply(element)) {
        result.add(element);
      }
    }
    return result.toArray();
    //return Arrays.stream(target).filter(predicate).toArray(Object[]::new);
  }
}
