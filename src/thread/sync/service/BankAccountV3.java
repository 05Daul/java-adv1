package thread.sync.service;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

import thread.sync.BankCount;

public class BankAccountV3 implements BankCount {

  /// 동시성 문제를 확인해보는 예제

  private int balance;

  public BankAccountV3(int balance) {
    this.balance = balance;
  }

  @Override
  /// synchronized 를 임계영역에만 사용하기
  public  boolean withdraw(int amount) {
    log("거래시작 : " + getClass().getSimpleName());
    /// 잔고가 출금액보다 적으면 진행하면 안됌.
    //***임계 영역 시작***
    synchronized(this) {
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
    }
    log("거래종료");
    return false;
  }

  @Override
  public synchronized int getBalance() {
    return balance;
  }
}
