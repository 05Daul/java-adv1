package thread.volatle1;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;


public class VolatileFlagMain2 {
/// 메모리 가시성
/// 멀티 쓰레드 환경에서 한 스러드가 변경한 값이 다른 스레드에서 언제 보이는 지에 대한 문제를 '메모리 가시성'이라한다.
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

    //boolean runFlag = true;
    volatile boolean runFlag = true;

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
