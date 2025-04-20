package thread.sync.main;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

import thread.sync.WithDrawTask;
import thread.sync.service.BankAccountV3;

public class BankMain3 {
/// 악의적인 사용자가 2대에서 동시에 출금을 실행하려할떄
  public static void main(String[] args) throws InterruptedException {
    BankAccountV3 bank = new BankAccountV3(1000);

    Thread t1 = new Thread(new WithDrawTask(bank, 800), "t1");
    Thread t2 = new Thread(new WithDrawTask(bank, 800), "t2");
    t1.start();
    t2.start();

    sleep(500);
    log("t1의 상태: "+t1.getState());
    log("t2의 상태: "+t2.getState());
    t1.join();
    t2.join();
    log("최종 잔액: " + bank.getBalance());
  }


}
