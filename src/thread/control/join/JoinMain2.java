package thread.control.join;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class JoinMain2 {

  public static void main(String[] args) {
    log("start");
    SumTask task1 = new SumTask(1, 50);
    SumTask task2 = new SumTask(51, 100);

    Thread thread1 = new Thread(task1, "thread1");
    Thread thread2 = new Thread(task2, "thread2");

    thread1.start();
    thread2.start();
    /// 메인 스레드 sleep 정확한 타이밍을 맞추긴 어려움
    log("main thread sleep");
    sleep(3000);
    log("main thread sleep에서 깨어남");
    log("end");

    int sunAll = task1.result + task2.result;
    System.out.println("sunAll = " + sunAll);

  }

  static class SumTask implements Runnable {

    int startVal;
    int endVal;
    int result = 0;

    public SumTask(int startVal, int endVal) {
      this.startVal = startVal;
      this.endVal = endVal;
    }


    @Override
    public void run() {
      log("작업 시작");
      sleep(1);
      int sum = 0;
      for (int i = startVal; i <= endVal; i++) {
        sum += i;

      }
      result = sum;
      log("작업 종료 result: " + result);
    }
  }
}
