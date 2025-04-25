package thread.bounded;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedQueueV6_1 implements BoundedQueue {
  /// BlockingQueue 사용하기
  /// 멀티 스레드를 사용할 응답성이 중요하다.
  /// ex) 대기 상태에 있어도, 고객이 중지 요청을 하거나 너무 오래 대기하는 경우 포기하고 빠져 나갈 방법이 필요하다.
  ///
  /* 기능 설명
  * */

  private BlockingQueue<String> queue;

  public BoundedQueueV6_1(int max) {
    this.queue = new ArrayBlockingQueue<>(max);
  }

  @Override
  public void put(String data) {

    try {
      queue.put(data);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

  }

  @Override
  public String take() {
    try {
      return queue.take();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public String toString() {
    return queue.toString();
  }
}
