package thread.control.yield;

import static thread.util.ThreadUtils.sleep;

public class YieldMain {

static final int THREAD_COUNT =1000;
  public static void main(String[] args) {
    for (int i = 0; i < THREAD_COUNT; i++) {
      Thread thread = new Thread(new MyThread()); {
        thread.start();

      }
    }


  }
static class MyThread implements Runnable {

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName()+" - "+i);
      // 1.empty
      //sleep(1); // 2.sleep(1) : 쓰레드가 뒤죽박죽 섞이며 실행되는 걸 찾을 수 있음
      Thread.yield();  //3.  Thread.yield(); 섞이긴 하지만 sleep 보다는 덜 섞임
      /// sleep
    /// yield 은 runnable을 상태를 유지하면서 cpu를 다른 스레드에 양보. 즉 스케줄링 큐에서 대기하는 상태로 바뀜
    }
  }
}
}
