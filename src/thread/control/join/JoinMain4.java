package thread.control.join;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class JoinMain4 {

  public static void main(String[] args) throws InterruptedException {
    log("start");
    SumTask task1 = new SumTask(1, 50);

    Thread thread1 = new Thread(task1, "thread1");

    thread1.start();
    log("join -main 스레드가 thread종료될때 까지 1초 대기");
    thread1.join(1000);

    int sunAll = task1.result;
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
