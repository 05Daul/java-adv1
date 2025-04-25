package thread.bounded;

import static thread.util.MyLogger.log;

import java.sql.Time;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BoundedQueueV6_3 implements BoundedQueue {

  private BlockingQueue<String> queue;

  public BoundedQueueV6_3(int max) {
  this.queue = new ArrayBlockingQueue<>(max);
  }
/// 대기시간 설정
  @Override
  public void put(String data) {
    boolean result = false;
    try {
      result = queue.offer(data,1, TimeUnit.NANOSECONDS);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    log("저장 시도 결과 : " + result);

  }

  @Override
  public String take() {
    try {
      return queue.poll(2,TimeUnit.NANOSECONDS);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public String toString() {
    return queue.toString();
  }
}
