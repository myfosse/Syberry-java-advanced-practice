package task2_mt;

import task2_mt.multithread.Consumer;
import task2_mt.multithread.Producer;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/** @author Andrey Egorov */
public class Main {
  public static void main(String[] args) {

    Queue<Integer> queue = new ArrayBlockingQueue<>(100);

    Thread producer = new Thread(new Producer(20, queue));
    Thread consumer = new Thread(new Consumer(10, queue));

    producer.start();
    consumer.start();
  }
}
