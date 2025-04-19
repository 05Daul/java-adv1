package thread.test;

import static thread.util.MyLogger.log;

public class StartTestMain4 {

  public static void main(String[] args) {
    PrintWork a = new PrintWork("A",2000);
    PrintWork b = new PrintWork("B",500);

    Thread t1 = new Thread(a,"Thread-A");
    Thread t2 = new Thread(b,"Thread-B");
    t1.start();
    t2.start();
  }

  static class PrintWork implements Runnable {

    private String content;
    private int sleepms;

    public PrintWork(String content, int sleepms) {
      this.content = content;
      this.sleepms = sleepms;
    }

    @Override
    public void run() {
      while (true) {
        log(content);
        try {
          Thread.sleep(sleepms);
        }catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    }
  }
}
