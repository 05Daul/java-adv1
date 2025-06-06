package thread.bounded;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

import java.util.ArrayList;
import java.util.List;

public class BoundedMain1 {

  public static void main(String[] args) {
    /// 1. BoundedQueue 선택
  BoundedQueue queue = new BoundedQueueV1(2);

  /// 생산자 , 소비자 실행 순서 선택, 반드시 하나만 선택!
   // producerFirst(queue); //생산자 먼저 실행
    consumerFirst(queue); // 소비자 먼저 실행
  }

  private static void consumerFirst(BoundedQueue queue) {
    log("[소비자 먼저 실행] 시작, "+queue.getClass().getSimpleName()+" ==");
    List<Thread> threads = new ArrayList<Thread>();
    startConsumer(queue,threads);
    printAllState(queue,threads);
    startProducer(queue,threads);
    printAllState(queue,threads);
    log("[소바자 먼저 실행] 종료, \"+queue.getClass().getSimpleName()+\" ==\");");
  }

  private static void producerFirst(BoundedQueue queue) {
    log("[생산자 먼저 실행] 시작, "+queue.getClass().getSimpleName()+" ==");
    List<Thread> threads = new ArrayList<Thread>();
    startProducer(queue,threads);
    printAllState(queue,threads);
    startConsumer(queue,threads);
    printAllState(queue,threads);
    log("[생산자 먼저 실행] 종료, \"+queue.getClass().getSimpleName()+\" ==\");");
  }

  private static void startConsumer(BoundedQueue queue, List<Thread> threads) {
    System.out.println();
    log("[소비자 시작]");
    for (int i = 1; i <=3 ; i++) {
      Thread consumer = new Thread(new ConsumerTask(queue), "Consumer" + i);
      threads.add(consumer);
      consumer.start();
      sleep(100);
    }
  }

  private static void printAllState(BoundedQueue queue, List<Thread> threads) {
    System.out.println();
    log("현재 상태 출력: 큐 데이터 "+queue);
    for(Thread thread : threads) {
      log(thread.getName()+" + "+thread.getState());
    }
  }

  private static void startProducer(BoundedQueue queue, List<Thread> threads) {
    System.out.println();
    log("생산자 시작");
    for (int i = 1; i <= 3; i++) {
      Thread producer = new Thread(new ProducerTask(queue,"data "+i),"Producer"+i);
      threads.add(producer);
      producer.start();
      sleep(100);
    }
  }

}
