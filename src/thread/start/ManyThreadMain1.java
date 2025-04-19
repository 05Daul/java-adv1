package thread.start;

import static thread.util.MyLogger.log;

public class ManyThreadMain1 {

  public static void main(String[] args) {
    log("main 쓰레드 시작");

    HelloRunnable helloRunnable1 = new HelloRunnable();
    Thread t1 = new Thread(helloRunnable1);
    Thread t2 = new Thread(helloRunnable1);
    Thread t3 = new Thread(helloRunnable1);
    t1.start();
    t2.start();
    t3.start();
    log("main 쓰레드 종료");

  }

}
