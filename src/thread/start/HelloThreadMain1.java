package thread.start;

public class HelloThreadMain1 {

  public static void main(String[] args) {
    System.out.println(Thread.currentThread().getName()+": , main 스레드 시작") ;
    HelloThread helloThread = new HelloThread();
    /// helloThread.run 은 실행하면 안됌
    System.out.println(Thread.currentThread().getName()+": , start 호출 전");
    helloThread.start();
    System.out.println(Thread.currentThread().getName()+": , start 호출 후");
    System.out.println(Thread.currentThread().getName()+": , main 스레드 종료");
    /// 호출결과는 달라질 수 있음. 왜? 스케줄링의 타이밍에 따라 달라질 수 있음.
  }
}
