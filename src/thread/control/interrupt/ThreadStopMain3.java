package thread.control.interrupt;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class ThreadStopMain3 {

  public static void main(String[] args) {
    MyTask task = new MyTask();
    Thread thread = new Thread(task);
    thread.start();
    sleep(100);
    log("작업 중단 지시 "  );
    thread.interrupt();
    log("work 스레드 인터럽트 상태1: "+ thread.isInterrupted());
  }
  static class MyTask implements Runnable {
     volatile boolean runFlag = true;

    @Override
    public void run() {
      while (!Thread.interrupted()) {
        /// 인터럽트 상태를 체크, 변경은 x
      log("작업 중");

      }
      log("work 스레드 인터럽트 상태2="+ Thread.currentThread().isInterrupted());
      log("자원 정리");
      log("자원 종료");
    }
  }
}
