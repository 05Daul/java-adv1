package thread.start;

public class HelloThreadMain2bad {

  public static void main(String[] args) {
    System.out.println(Thread.currentThread().getName()+": , main 스레드 시작") ;
    HelloThread helloThread = new HelloThread();
    /// helloThread.run 은 실행한다면?
    System.out.println(Thread.currentThread().getName()+": , start 호출 전");
    /// 메인 흐레드가 run을 직접 실행. 즉 별도의 스레드가 run을 실행되는 구조가 꺠지게 됌.
    helloThread.run();
    System.out.println(Thread.currentThread().getName()+": , start 호출 후");
    System.out.println(Thread.currentThread().getName()+": , main 스레드 종료");
  }
}
