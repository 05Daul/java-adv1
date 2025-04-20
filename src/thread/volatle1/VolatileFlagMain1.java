package thread.volatle1;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;


public class VolatileFlagMain1 {

  public static void main(String[] args) {

    MyTask task = new MyTask();
    Thread t = new Thread(task,"work");
    log("runFlag : "+task.runFlag);
    t.start();
    sleep(1000);
    log("runFlag 를 False 로 변경 ");
    task.runFlag = false;
    log("runFlag : "+task.runFlag);
    log("메인 종료");
  }

  static class MyTask implements Runnable {

    boolean runFlag = true;
    //volatile boolean runFlag = true;

    @Override
    public void run() {
      log("task 시작");
      while (runFlag) {
        ///  runFlag 가 false 면 탈출
      }
      log("task 종료");

    }
  }
}
