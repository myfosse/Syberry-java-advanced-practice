package task5_ar;

import task5_ar.thread.CustomThreadPoolExecutor;
import task5_ar.thread.Processor;

/** @author Andrey Egorov */
public class Main {
  public static void main(String[] args) {
    Processor processor = new Processor("Hello world!");
    CustomThreadPoolExecutor customThreadPoolExecutor = new CustomThreadPoolExecutor();
    customThreadPoolExecutor.execute(processor);
  }
}
