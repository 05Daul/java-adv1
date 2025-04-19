package thread.control.interrupt;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

import java.util.List;
import java.util.Vector;

public class ThreadStopMain2 {

  public static void main(String[] args) {
    MyTask task = new MyTask();
    Thread thread = new Thread(task);
    thread.start();
    sleep(1000);
    log("작업 중단 지시 "  );
    thread.interrupt();
    log("work 스레드 인터럽트 상태1: "+ thread.isInterrupted());
  }
  static class MyTask implements Runnable {
     volatile boolean runFlag = true;

    @Override
    public void run() {
      try {
        while (runFlag) {
          log("작업중");
          Thread.sleep(3000);
        }
      }catch (InterruptedException e){
       log("work 스레드 인터럽트 상태2="+ Thread.currentThread().isInterrupted());
       log("interrupt message :"+e.getMessage());
       log("state :"+Thread.currentThread().getState());
      }
      log("자원 정리");
      log("자원 종료");
    }
  }
}
