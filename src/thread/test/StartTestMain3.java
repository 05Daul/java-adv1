package thread.test;

import static thread.util.MyLogger.log;

public class StartTestMain3 {
/// 익명클래스로 만들기
  public static void main(String[] args) {

    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        for (int i = 1; i <= 5; i++) {
          log("value: "+i);
          try {
            Thread.sleep(1000);
          }catch (InterruptedException e){
            throw new RuntimeException(e);
          }
        }
      }
    };
      Thread thread = new Thread(runnable,"counter");
      thread.start();
  };
}
