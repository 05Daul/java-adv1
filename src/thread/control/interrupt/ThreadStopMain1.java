package thread.control.interrupt;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class ThreadStopMain1 {

  public static void main(String[] args) {
    MyTask task = new MyTask();
    Thread thread = new Thread(task);
    thread.start();
    log("작업 중단 지시 runFlag = false"  );
    task.runFlag = false;

  }

  static class MyTask implements Runnable {
     volatile boolean runFlag = true;


    @Override
    public void run() {
      while (runFlag) {
        log("작업중");
        sleep(3000);

      }
      log("자원 정리");
      log("자원 종료");
    }
  }
}
