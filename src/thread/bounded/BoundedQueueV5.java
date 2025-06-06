package thread.bounded;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedQueueV5 implements BoundedQueue {

  ///  Lock, ReentrantLock 활용하기
  private final Lock lock = new ReentrantLock();
  /// 대기집합
  private final Condition prodCon = lock.newCondition();
  private final Condition consCon = lock.newCondition();

  private final Queue<String> queue = new ArrayDeque<>();
  private final int max;

  public BoundedQueueV5(int max) {
    this.max = max;
  }

  @Override
  public void put(String data) {
    lock.lock();
    try {
      while (queue.size() == max) {
        log("put: 큐가 가득 참, 생산자 대기");
        try {
          prodCon.await();
          log("[put] 생상자 깨어남");
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
      queue.offer(data);
      log("[put] 생산자 데이터 저장, notify() 호출");
      consCon.signal();
    } finally {
      lock.unlock();
    }
  }

  @Override
  public String take() {
    lock.lock();
    try {
      while (queue.isEmpty()) {
        log("[take] 큐에 데이터가 없음. 소비자 대기");
        try {
          consCon.await();
          log("[take] 소비자 꺠어남");
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        sleep(1000);
      }
      String data = queue.poll();
      log("[take] 소비자 데이터 획득 , notify()호출");
      prodCon.signal();
      return data;

    } finally {
      lock.unlock();
    }
  }

  @Override
  public String toString() {
    return queue.toString();
  }

}
