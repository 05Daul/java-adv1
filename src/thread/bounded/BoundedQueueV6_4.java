package thread.bounded;

import static thread.util.MyLogger.log;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BoundedQueueV6_4 implements BoundedQueue {

  private BlockingQueue<String> queue;

  public BoundedQueueV6_4(int max) {
  this.queue = new ArrayBlockingQueue<>(max);
  }
/// 대기시간 설정
  @Override
  public void put(String data) {
    queue.add(data);
/// java.lang.IllegalStateException : queue full
  }

  @Override
  public String take() {
    return queue.remove();
    ///java.lang.NoSuchException
  }

  @Override
  public String toString() {
    return queue.toString();
  }
}
