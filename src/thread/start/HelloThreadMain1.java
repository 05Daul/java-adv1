package thread.start;

public class HelloThreadMain1 {

  public static void main(String[] args) {
    /// Thread.currentThread()는 현재 실행 중인 스레드의 Thread 객체를 반환
    /// 또한 helloThread.run 은 실행하면 안됌
    /// -> helloThread.run을 실행하면 별도의 스레드가 실행되는 것이 아닌, main 스레드가 이를 실행
    /// 알아야 할 것 main 쓰레드가 실행하는 게 아니라.
    /// 생성된 쓰레드에게 메인쓰레드가 "너 실행해라" 지시를 내리는 것
    /// 쓰레드간 실행순서는 얼마든지 달라질 수 있다.
    System.out.println(Thread.currentThread().getName() + ": , main 스레드 시작");
    HelloThread helloThread = new HelloThread();
    System.out.println(Thread.currentThread().getName() + ": , start 호출 전");
    helloThread.start();
    /// HelloThread helloThread = new HelloThread() 객체를 통해 thread를 통해 별도의 스레드를 실행

    System.out.println(Thread.currentThread().getName() + ": , start 호출 후");
    System.out.println(Thread.currentThread().getName() + ": , main 스레드 종료");
    /// 호출결과는 달라질 수 있음. 왜? 스케줄링의 타이밍에 따라 달라질 수 있음.
  }
}
