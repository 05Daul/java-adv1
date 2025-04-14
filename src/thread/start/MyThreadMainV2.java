package thread.start;

import thread.util.MyLogger;

public class MyThreadMainV2 {

  public static void main(String[] args) {
    /// 100개 쓰레드
    MyLogger.log("main start");

    HelloRunnable helloRunnable = new HelloRunnable();
    for (int i = 0; i < 100; i++) {

      Thread thread = new Thread(helloRunnable);
      thread.start();

    }
    MyLogger.log("main end");

  }

}
