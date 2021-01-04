package task2_mt.multithread;

import java.util.Queue;
import java.util.Random;

/** @author Andrey Egorov */
public class Producer implements Runnable {

  private int queueCapacityToAdd = 20;
  private final Queue<Integer> queue;

  public Producer(final int queueCapacityToAdd, final Queue<Integer> queue) {
    this.queueCapacityToAdd = queueCapacityToAdd;
    this.queue = queue;
  }

  public void run() {
    try {
      while (true) {
        if (queue.stream().count() < queueCapacityToAdd) {
          queue.add(produce());
        }
        Thread.sleep(1000);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private Integer produce() {
    return new Random().nextInt(10);
  }
}
