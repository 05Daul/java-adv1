package thread.control;

import static thread.util.MyLogger.log;

public class ThreadStateMain {

  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(new MyRunnable(), "MyThread");
    log("MyThread: " + thread.getState());
    log("MyThread.start");
    thread.start();
    log("MyThread: " + thread.getState());
    Thread.sleep(1000);

  }

  static class MyRunnable implements Runnable {

    @Override
    public void run() {
      try {
        log("start");
        log("myRunnable2.state" + Thread.currentThread().getState());
        log("sleep.start");
        Thread.sleep(3000);
        log("sleep.end");
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }
}
