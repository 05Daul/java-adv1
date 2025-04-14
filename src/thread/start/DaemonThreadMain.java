package thread.start;

public class DaemonThreadMain {

  public static void main(String[] args) {
    System.out.println(Thread.currentThread().getName()+": , main 스레드 시작") ;
    DaemonThread daemonThread = new DaemonThread();
    daemonThread.setDaemon(false);
    ///데몬 스레드 여부
    /// false는 thread-0 이 종료될때까지 자바가 기다림 그다음 종료.
    daemonThread.start();
    System.out.println(Thread.currentThread().getName()+": , main 스레드 종료");

  }
  static class DaemonThread extends Thread{

    @Override
    public void run() {
      System.out.println(Thread.currentThread().getName()+" : run");

      try {
        Thread.sleep(10000);
      }catch (InterruptedException e){
        throw new RuntimeException(e);
      }
      System.out.println(Thread.currentThread().getName()+" : run end");
    }
  }

}
