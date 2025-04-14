package thread.control;

import static thread.util.MyLogger.log;

public class ThreadStateMain {

  public static void main(String[] args) {
    Thread thread = new Thread(new MyRunnable(), "MyRunnable");
    thread.start();
    log("MyRunnalbe"+thread.getState());
    log("MyRunnalbe.start");
  }

  static class MyRunnable implements Runnable {

    @Override
    public void run() {
      try {
        log("start");
        log("myRunnable2.state" + Thread.currentThread().getState());
        log("sleep.start");
        Thread.sleep(300);
        log("sleep.end");
      }catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }
}
