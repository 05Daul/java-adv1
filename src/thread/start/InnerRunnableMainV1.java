package thread.start;

import static thread.util.MyLogger.log;

public class InnerRunnableMainV1 {

  /// 중첩 클래스를 만들면 Runnable 을 좀더 쉽게 사용할 수 있다
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