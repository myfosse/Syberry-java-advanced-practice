package task3_op.builder;

import java.util.ArrayList;
import java.util.List;

/** @author Andrey Egorov */
public class ObservableStringBuilder {

  private final List<String> appendedStrings;
  private final List<Observer> observers;

  public ObservableStringBuilder() {
    appendedStrings = new ArrayList<>();
    observers = new ArrayList<>();
    appendedStrings.add("");
  }

  public void addObserver(final Observer observer) {
    observers.add(observer);
  }

  public void removeObserver(final Observer observer) {
    observers.remove(observer);
  }

  public void append(final String appendString) {
    appendedStrings.add(appendedStrings.get(appendedStrings.size() - 1) + appendString);
    notifyObservers(appendedStrings.get(appendedStrings.size() - 2) + appendString);
  }

  private void notifyObservers(final String appendString) {
    for (Observer observer : observers) {
      observer.update(appendString);
    }
  }
}
