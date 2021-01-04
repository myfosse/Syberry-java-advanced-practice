package task3_op;

import task3_op.builder.AppendString;
import task3_op.builder.ObservableStringBuilder;
import task3_op.builder.Observer;

/**
 * @author Andrey Egorov
 */

/*
I did not understand where there is a one-to-many relationship for implementing the pattern.
Therefore, I did what I thought was necessary
 */
public class Main {
    public static void main(String[] args) {
        ObservableStringBuilder observableStringBuilder = new ObservableStringBuilder();
        Observer observer = new AppendString();
        observableStringBuilder.addObserver(observer);

        observableStringBuilder.append("Hello");
        observableStringBuilder.append(", ");
        observableStringBuilder.append("World!");
    }
}
