package thread.bounded;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

import java.util.ArrayDeque;
import java.util.Queue;

public class BoundedQueueV3 implements BoundedQueue {

  /// 무한 대기락 해결하기
  private final Queue<String> queue = new ArrayDeque<>();
  private final int max;

  public BoundedQueueV3(int max) {
    this.max = max;
  }

  @Override
  public synchronized void put(String data) {
    while (queue.size() == max) {
      log("put: 큐가 가득 참, 생산자 대기");
      try {
        wait(); /// Runnable -> waiting, 락 반납
        log("[put] 생상자 깨어남");
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    queue.offer(data);
    log("[put] 생산자 데이터 저장, notify() 호출");
    notify();
    ///  notify(); 대기스레드 , wait => Blocked
  }

  @Override
  public synchronized String take() {
    while (queue.isEmpty()) {
      log("[take] 큐에 데이터가 없음. 소비자 대기");
      try {
        wait();
        log("[take] 소비자 꺠어남");
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      sleep(1000);
    }
    String data= queue.poll();
    log("[take] 소비자 데이터 획득 , notify()호출");
    notify(); /// 대기스레드 하나가 wait-> blocked
    return data;
  }

  @Override
  public String toString() {
    return queue.toString();
  }

}
