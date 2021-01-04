package task4_sgl;

import task4_sgl.filter.ArrayFilter;

import java.util.Arrays;
import java.util.Objects;

/** @author Andrey Egorov */
public class Main {
  public static void main(String[] args) {
    String[] initialArray = new String[] {"One", "Two", null, "Three", null, "Four", "Five"};
    System.out.println("Initial Array = " + Arrays.toString(initialArray));
    Object[] newArray = ArrayFilter.getInstance().filter(initialArray, Objects::nonNull);
    System.out.println("Result Array = " + Arrays.toString(newArray));
  }
}
