package task2_mt.multithread;

import java.util.Arrays;
import java.util.Queue;

/** @author Andrey Egorov */
public class Consumer implements Runnable {

  private final int queueCapacityBeforeRemove;
  private final Queue<Integer> queue;

  public Consumer(final int queueCapacityBeforeRemove, final Queue<Integer> queue) {
    this.queueCapacityBeforeRemove = queueCapacityBeforeRemove;
    this.queue = queue;
  }

  public void run() {
    while (true) {
      try {
        if (queue.stream().count() < queueCapacityBeforeRemove) {
          consume();
        } else {
          for (int i = 0; i < queueCapacityBeforeRemove; i++) {
            queue.poll();
          }
        }
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private void consume() {
    System.out.println("Shared Queue = " + Arrays.toString(queue.toArray()));
  }
}
