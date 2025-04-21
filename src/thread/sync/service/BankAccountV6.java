package thread.sync.service;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import thread.sync.BankCount;

public class BankAccountV6 implements BankCount {

  ///  ReentrantLock 을 이용하기
  private int balance;
  private final Lock lock = new ReentrantLock();

  public BankAccountV6(int balance) {
    this.balance = balance;
  }

  @Override
  public boolean withdraw(int amount) {
    log("거래시작 : " + getClass().getSimpleName());
    /// 잔고가 출금액보다 적으면 진행하면 안됌.
    //***임계 영역 시작***
    try {

      if (!lock.tryLock(1000, TimeUnit.MICROSECONDS)) {
        log("[진입실패] 이미 처리중인 작업이 있습니다.");
        return false;
      }
    } catch (InterruptedException e) {
      throw new RuntimeException(e);

    }
    try {
      log("[검증 시작] 출금액: " + amount + ", 잔액: " + balance);
      if (balance < amount) {
        log("[검증 실패] 출금액: " + amount + ", 잔액: " + balance);
        return false;
      }

      /// 잔고가 출금액보다 많으면 진행O.
      log("[검증 완료] 출금액: " + amount + ", 잔액: " + balance);
      sleep(1000); // 출금액 걸리는 시간
      balance -= amount;
      log("[출금 완료] 출금액: " + amount + ", 잔액: " + balance);
      //***임계 영역 종료***
    } finally {
      lock.unlock();
      log("거래종료");
    }
    return false;
  }

  @Override
  public int getBalance() {
    lock.lock();
    try {
      return balance;
    } finally {
      lock.unlock();
    }
  }


}
