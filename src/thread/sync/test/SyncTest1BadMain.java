package thread.sync.test;


public class SyncTest1BadMain {
/// 쓰레드 하나가 각각 만번씩 호출되어야만 한다.
  public static void main(String[] args) throws InterruptedException {

    Counter counter = new Counter();
    Runnable runnable = new Runnable() {
      public void run() {
        for (int i = 0; i < 10000; i++) {
          counter.increment();
        }
      }
    };

    Thread t1 = new Thread(runnable);
    Thread t2 = new Thread(runnable);
    t1.start();
    t2.start();
    t1.join();
    t2.join();
    System.out.println("결과 = " + counter.getCount());
  }

  static class Counter {

    private int count = 0;

    public void increment() {
      count++;
    }

    public int getCount() {
      return count;
    }

    public void setCount(int count) {
      this.count = count;
    }
  }
}
