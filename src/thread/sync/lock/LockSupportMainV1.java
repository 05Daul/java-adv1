package thread.sync.lock;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

import java.util.concurrent.locks.LockSupport;

public class LockSupportMainV1 {
public static void main(String[] args) {
  Thread t1 = new Thread(new PartTest(),"Thread-1");
  t1.start();
  /// 잠시 대기해서 Thread-1이 park상태로 빠질 시간을 부여.
  sleep(100);
  log("Thread-1 state: "+t1.getState());
  log("main -> unpark(Thread-1): ");
  LockSupport.unpark(t1);
  //1. unpark를 사용.
}

static class PartTest implements Runnable {

  @Override
  public void run() {
    log("park 시작");
    LockSupport.park();
    log("park 종료, state: "+Thread.currentThread().getState());
    log("인터럽트 상태, state: "+Thread.currentThread().isInterrupted());

  }
}
}
