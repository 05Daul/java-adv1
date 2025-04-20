package thread.sync.test;


import static thread.util.MyLogger.log;

public class SyncTest2Main {

  /// 쓰레드 하나가 각각 만번씩 호출되어야만 한다. : synchronized
  public static void main(String[] args) throws InterruptedException {

    MyCounter counter = new MyCounter();
    Runnable runnable = new Runnable() {
      public void run() {
        counter.count();
      }
    };

    Thread t1 = new Thread(runnable);
    Thread t2 = new Thread(runnable);
    t1.start();
    t2.start();
    t1.join();
    t2.join();
  }
  static class MyCounter {
    public void count(){
    /// localValue 는 지역 변수로 스레드 별로 각각 개별 스택에 생성.
      // *** => 이 메모리 공간은 다른 스레드와 공유 되지 않는다 ***
      // *** => 그래서 동기화이 대한 걱정을 하지 않아도 된다. ***

      int  localValue = 0;

      for (int i = 0; i < 1000; i++) {
        localValue++;
      }
      log("결과: "+localValue);
    }
  }
}
