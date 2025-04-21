package thread.sync.lock;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

import java.util.concurrent.locks.LockSupport;

public class LockSupportMainV2 {
  /// parkNanos 를 사용해보기
public static void main(String[] args) {

  Thread t1 = new Thread(new PartTest(),"Thread-1");
  t1.start();
  sleep(100);
  log("Thread-1 state: "+t1.getState());
}

static class PartTest implements Runnable {

  @Override
  public void run() {
    log("park 시작");
    LockSupport.parkNanos(2000_000000);// 2초
    log("park 종료, state: "+Thread.currentThread().getState());
    log("인터럽트 상태, state: "+Thread.currentThread().isInterrupted());

  }
}
}
