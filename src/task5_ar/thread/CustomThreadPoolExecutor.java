package task5_ar.thread;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/** @author Andrey Egorov */
public class CustomThreadPoolExecutor extends ThreadPoolExecutor {

  public CustomThreadPoolExecutor() {
    super(3, 6, 0L, TimeUnit.SECONDS, new SynchronousQueue<>());
  }

  public CustomThreadPoolExecutor(
      int corePoolSize,
      int maximumPoolSize,
      long keepAliveTime,
      TimeUnit unit,
      BlockingQueue<Runnable> workQueue) {
    super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
  }

  private List<String> getListOfDescribedFields(final Runnable command)
      throws IllegalAccessException {
    List<String> listOfDescribedFields = new ArrayList<>();
    Field[] describedFields = command.getClass().getDeclaredFields();

    return Arrays.stream(describedFields)
        .filter(
            field ->
                !Modifier.isStatic(field.getModifiers())
                    && Modifier.isPrivate(field.getModifiers()))
        .peek(field -> field.setAccessible(true))
        .map(
            field -> {
              try {
                return field.getName() + "  =  " + field.get(command);
              } catch (IllegalAccessException e) {
                e.printStackTrace();
              }
              return null;
            })
        .collect(Collectors.toList());
  }

  @Override
  public void execute(final Runnable command) {
    Repeat repeat = command.getClass().getAnnotation(Repeat.class);
    if (repeat != null) {
      for (int i = 0; i < repeat.repeat(); i++) {
        super.execute(command);
      }
    }
    try {
      System.out.println(getListOfDescribedFields(command));
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
  }
}
