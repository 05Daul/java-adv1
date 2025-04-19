package thread.start;

public class HelloThread extends Thread {
/// 쓰레드를 만드는 방법
/// 1. Thread 를 상속 2. Runnable 로 구현
  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName()+": run" );
  }
}
