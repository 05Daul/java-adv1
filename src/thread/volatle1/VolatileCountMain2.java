package thread.volatle1;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class VolatileCountMain2 {

  public static void main(String[] args) {
    VolatileCount task = new VolatileCount();
    Thread t = new Thread(task);
    t.start();
    sleep(1000);
    task.flag = false;
    log("flag: " + task.flag + ", count: " + task.count + " in main");
  }

  static class VolatileCount implements Runnable {
//
//    long count;
//    boolean flag = true;

    volatile long count;
    volatile boolean flag = true;

    @Override
    public void run() {
      while (flag) {
        count++;
        //1억번에 한번씩 출력
        if (count % 100_000_000 == 0) {
          log("flag: " + flag + ", count: " + count + " in while");
        }
      }
      log("flag: " + flag + ", count: " + count + " in while 종료");

    }
  }
}
