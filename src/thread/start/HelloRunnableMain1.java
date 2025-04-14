package thread.start;

public class HelloRunnableMain1 {

  public static void main(String[] args) {

    System.out.println(Thread.currentThread().getName()+": main start");
    HelloRunnable helloRunnable = new HelloRunnable();
    Thread thread = new Thread(helloRunnable);
    thread.start();
    /// Thread 상속 vs Runnable 구현 중 보통 Runnalbe 구현하는 방법을 많이씀.
    System.out.println(Thread.currentThread().getName()+": main end");
  }

}
