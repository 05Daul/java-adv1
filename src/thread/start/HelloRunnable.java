package thread.start;

public class HelloRunnable implements Runnable {
/// Runnable 인터페이스를 구현해서
/// run메서드를 사용할 수 있게 정의
  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + ": run");
  }
}
