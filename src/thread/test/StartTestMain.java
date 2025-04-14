package thread.test;
import static thread.util.MyLogger.log;
public class StartTestMain {

  public static void main(String[] args) {
    CountThread countThread = new CountThread();
    countThread.start();

  }

  static class CountThread extends Thread {

    @Override
    public void  run(){
      for (int i = 1; i <= 5; i++) {
        log("value: "+i);
        try {
          Thread.sleep(1000);
        }catch (InterruptedException e){
          throw new RuntimeException(e);
        }
      }
    }
  }
}
