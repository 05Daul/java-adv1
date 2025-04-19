package thread.start;

public class HelloRunnableMain1 {

  public static void main(String[] args) {

    System.out.println(Thread.currentThread().getName()+": main start");
    /// 1. 정의한 run메서드의 객체를 생성
    HelloRunnable helloRunnable = new HelloRunnable();
    /// 2. 기본 thread 의 객체를 생성해서 생성자로 넘겨주기
    Thread thread = new Thread(helloRunnable);
    thread.start();
    System.out.println(Thread.currentThread().getName()+": main end");
    /// Thread 상속 vs Runnable 구현 중 보통 Runnalbe 구현하는 방법을 많이씀.
    // 왜?
    //Thread 상속은 run메서드만 재정의하면 되니까 간단.
    // 다만 자바는 단일 상속만 허용하므로 다른 것으 상속받으면 Thread를 상속 받지 못함, 그리고  유연성이 부족
    // Runnable은 단일 상속에서 벗어남. 유연성이 증가. 스레드와 실행할 코드를 분리에 가독성이 높음.




  }
}
