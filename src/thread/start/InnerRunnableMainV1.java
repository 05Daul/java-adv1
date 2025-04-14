package thread.start;

import static thread.util.MyLogger.log;

public class InnerRunnableMainV1 {

  public static void main(String[] args) {
    log("main start");

    thread.start.HelloRunnable helloRunnable = new thread.start.HelloRunnable();
    Thread thread = new Thread(helloRunnable);
    thread.start();
    log("main end");
  }

  static class HelloRunnable implements Runnable {

    @Override
    public void run() {
      System.out.println(Thread.currentThread().getName() + ": run");
    }
  }
}